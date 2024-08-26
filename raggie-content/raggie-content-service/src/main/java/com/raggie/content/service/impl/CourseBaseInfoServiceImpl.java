package com.raggie.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.raggie.base.exception.RaggieException;
import com.raggie.base.model.PageParams;
import com.raggie.base.model.PageResult;
import com.raggie.content.mapper.CourseBaseMapper;
import com.raggie.content.mapper.CourseCategoryMapper;
import com.raggie.content.mapper.CourseMarketMapper;
import com.raggie.content.model.dto.AddCourseDto;
import com.raggie.content.model.dto.CourseBaseInfoDto;
import com.raggie.content.model.dto.EditCourseDto;
import com.raggie.content.model.dto.QueryCourseParamsDto;
import com.raggie.content.model.po.CourseBase;
import com.raggie.content.model.po.CourseCategory;
import com.raggie.content.model.po.CourseMarket;
import com.raggie.content.service.CourseBaseInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CourseBaseInfoServiceImpl implements CourseBaseInfoService {

    @Autowired
    CourseBaseMapper courseBaseMapper;

    @Autowired
    CourseMarketMapper courseMarketMapper;

    @Autowired
    CourseCategoryMapper courseCategoryMapper;

    @Autowired
    CourseMarketServiceImpl courseMarketService;

    @Override
    public PageResult<CourseBase> queryCourseBaseList(PageParams pageParams, QueryCourseParamsDto queryCourseParamsDto) {
        // Create condition query
        LambdaQueryWrapper<CourseBase> queryWrapper = new LambdaQueryWrapper<>();
        // Condition: fuzzy query by course name
        queryWrapper.like(StringUtils.isNotEmpty(queryCourseParamsDto.getCourseName()), CourseBase::getName, queryCourseParamsDto.getCourseName());
        // Condition: query by audit status
        queryWrapper.eq(StringUtils.isNotEmpty(queryCourseParamsDto.getAuditStatus()), CourseBase::getAuditStatus, queryCourseParamsDto.getAuditStatus());
        // Condition: query by publish status
        // queryWrapper.eq(StringUtils.isNotEmpty(queryCourseParamsDto.getPublishStatus()), CourseBase::getStatus, queryCourseParamsDto.getPublishStatus());

        // Paginate results
        Page<CourseBase> page = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());
        Page<CourseBase> pageResult = courseBaseMapper.selectPage(page, queryWrapper);

        List<CourseBase> courseBaseList = pageResult.getRecords();
        long total = pageResult.getTotal();

        return new PageResult<CourseBase>(courseBaseList, total, pageParams.getPageNo(), pageParams.getPageSize());
    }

    @Override
    public CourseBaseInfoDto createCourseBase(Long companyId, AddCourseDto addCourseDto) {
        if(StringUtils.isBlank(addCourseDto.getName())){
            throw new RuntimeException("Course name is empty");
        }
        if(StringUtils.isBlank(addCourseDto.getMt()) || StringUtils.isBlank(addCourseDto.getSt())){
            throw new RuntimeException("Course category is empty");
        }
        if (StringUtils.isBlank(addCourseDto.getGrade())) {
            throw new RuntimeException("Course grade is empty");
        }
        if(StringUtils.isBlank(addCourseDto.getTeachmode())){
            throw new RuntimeException("Course teach mode is empty");
        }
        if(StringUtils.isBlank(addCourseDto.getUsers())) {
            throw new RuntimeException("Course target is empty");
        }
        if(StringUtils.isBlank(addCourseDto.getCharge())) {
            throw new RuntimeException("Course charge is empty");
        }

        // Create request params
        CourseBase courseBase = new CourseBase();
        BeanUtils.copyProperties(addCourseDto, courseBase);
        courseBase.setAuditStatus("202002");
        courseBase.setStatus("203001");
        courseBase.setCompanyId(companyId);
        courseBase.setCreateDate(LocalDateTime.now());

        int baseInsert = courseBaseMapper.insert(courseBase);
        Long courseId = courseBase.getId();

        CourseMarket courseMarket = new CourseMarket();
        BeanUtils.copyProperties(addCourseDto, courseMarket);
        courseMarket.setId(courseId);

        String charge = courseMarket.getCharge();
        if("201001".equals(charge)) {
            Float price = addCourseDto.getPrice();
            if(price == null || price <= 0) {
                throw new RuntimeException("Invalid course price");
            }
        }

        int marketInsert = courseMarketMapper.insert(courseMarket);
        if(baseInsert <= 0 || marketInsert <= 0) {
            throw new RuntimeException("Failed to create course");
        }

        return getCourseBaseInfo(courseId);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public CourseBaseInfoDto getCourseBase(Long id) {
        CourseBaseInfoDto courseBaseInfoDto = new CourseBaseInfoDto();

        CourseBase courseBase = courseBaseMapper.selectById(id);
        if (courseBase == null) {
            return null;
        }
        BeanUtils.copyProperties(courseBase, courseBaseInfoDto);

        CourseMarket courseMarket = courseMarketMapper.selectById(id);
        if(courseMarket != null) {
            BeanUtils.copyProperties(courseMarket, courseBaseInfoDto);
        }

        courseBaseInfoDto.setStName(courseCategoryMapper.selectById(courseBase.getSt()).getName());
        courseBaseInfoDto.setMtName(courseCategoryMapper.selectById(courseBase.getMt()).getName());
        return courseBaseInfoDto;
    }

    /**
     * @param companyId
     * @param courseBaseInfoDto
     * @return
     */
    @Override
    public CourseBaseInfoDto updateCourseBase(Long companyId, EditCourseDto editCourseDto) {
        Long courseId = editCourseDto.getId();
        CourseBase courseBase = courseBaseMapper.selectById(courseId);
        if(!companyId.equals(courseBase.getCompanyId())) {
            RaggieException.cast("You can only edit the course in your company");
        }
        BeanUtils.copyProperties(editCourseDto, courseBase);
        courseBase.setChangeDate(LocalDateTime.now());
        courseBaseMapper.updateById(courseBase);

        CourseMarket courseMarket = courseMarketMapper.selectById(courseId);
        if(courseMarket == null) {
            courseMarket = new CourseMarket();
        }

        courseMarket.setId(courseId);

        String charge = editCourseDto.getCharge();
        courseMarket.setCharge(charge);

        if("201001".equals(charge)) {
            Float price = editCourseDto.getPrice();
            if(price == null || price <= 0) {
                RaggieException.cast("Invalid course price");
            }
        }

        BeanUtils.copyProperties(editCourseDto, courseMarket);
        courseMarketService.saveOrUpdate(courseMarket);
        return getCourseBaseInfo(courseId);
    }

    private CourseBaseInfoDto getCourseBaseInfo(Long courseId) {
        CourseBaseInfoDto courseBaseInfoDto = new CourseBaseInfoDto();

        CourseBase courseBase = courseBaseMapper.selectById(courseId);
        if(courseBase == null) {
            return null;
        }

        BeanUtils.copyProperties(courseBase, courseBaseInfoDto);
        CourseMarket courseMarket = courseMarketMapper.selectById(courseId);
        if(courseMarket != null) {
            BeanUtils.copyProperties(courseMarket, courseBaseInfoDto);
        }

        CourseCategory courseCategoryBySt = courseCategoryMapper.selectById(courseBase.getSt());
        courseBaseInfoDto.setStName(courseCategoryBySt.getName());
        CourseCategory courseCategoryByMt = courseCategoryMapper.selectById(courseBase.getMt());
        courseBaseInfoDto.setMtName(courseCategoryByMt.getName());
        return courseBaseInfoDto;
    }
}
