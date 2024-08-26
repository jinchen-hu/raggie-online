package com.raggie.content.api;


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
import com.raggie.content.service.CourseBaseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "Course Info", tags = "Course Info")
public class CourseBaseInfoController {

    @Autowired
    CourseBaseInfoService courseBaseInfoService;
    @Autowired
    private CourseBaseMapper courseBaseMapper;
    @Autowired
    private CourseMarketMapper courseMarketMapper;
    @Autowired
    private CourseCategoryMapper courseCategoryMapper;

    @PostMapping("/course/list")
    @ApiOperation("Query Course Interface")
    public PageResult<CourseBase> list(PageParams pageParams, @RequestBody(required = false) QueryCourseParamsDto queryCourseParams) {
        return courseBaseInfoService.queryCourseBaseList(pageParams, queryCourseParams);
    }

    @ApiOperation("")
    @PostMapping("/course")
    public CourseBaseInfoDto createCourseBase(@RequestBody @Validated AddCourseDto addCourseDto){
        //获取到用户所属机构的id
        Long companyId = 1232141425L;
//        int i = 1/0;
        return courseBaseInfoService.createCourseBase(companyId, addCourseDto);
    }
    @ApiOperation("")
    @GetMapping("/course/{courseId}")
    public CourseBaseInfoDto getCourseBaseInfoById(@PathVariable(value = "courseId") Long courseId){
        return courseBaseInfoService.getCourseBase(courseId);
    }

    @ApiOperation("")
    @PutMapping("/course")
    public CourseBaseInfoDto updateCourseBase(@RequestBody @Validated EditCourseDto editCourseDto){
        Long companyId = 1232141425L;
        return courseBaseInfoService.updateCourseBase(companyId, editCourseDto);
    }

    @ApiOperation("")
    @DeleteMapping("/course/{courseId}")
    public void deleteCourseBase(@PathVariable(value = "courseId") Long courseId){
        Long companyId = 1232141425L;
        courseBaseInfoService.deleteCourseBase(companyId, courseId);
    }
}
