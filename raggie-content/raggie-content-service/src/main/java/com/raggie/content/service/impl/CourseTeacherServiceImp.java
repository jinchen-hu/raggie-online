package com.raggie.content.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.raggie.base.exception.RaggieException;
import com.raggie.content.mapper.CourseTeacherMapper;
import com.raggie.content.model.po.CourseTeacher;
import com.raggie.content.service.CourseTeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 课程-教师关系表 服务实现类
 * </p>
 *
 * @author Luke
 * @since 2024-08-25
 */
@Service
public class CourseTeacherServiceImp implements CourseTeacherService {
    @Autowired
    private CourseTeacherMapper courseTeacherMapper;
    /**
     * @param courseId
     * @return
     */
    @Override
    public List<CourseTeacher> getCourseTeacherList(Long courseId) {
        LambdaQueryWrapper<CourseTeacher> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CourseTeacher::getCourseId, courseId);
        return courseTeacherMapper.selectList(queryWrapper);
    }

    /**
     * @param courseTeacher
     * @return
     */
    @Transactional
    @Override
    public CourseTeacher saveCourseTeacher(CourseTeacher courseTeacher) {
        Long teacherId = courseTeacher.getId();
        if(teacherId == null) {
            CourseTeacher courseTeacherEntity = new CourseTeacher();
            BeanUtils.copyProperties(courseTeacher, courseTeacherEntity);
            courseTeacherEntity.setCreateDate(LocalDateTime.now());
            if(courseTeacherMapper.insert(courseTeacherEntity) <= 0) {
                RaggieException.cast("Failed to add course teacher");
            }
            return courseTeacherEntity;
        } else {
            CourseTeacher courseTeacherEntity = courseTeacherMapper.selectById(teacherId);
            BeanUtils.copyProperties(courseTeacher, courseTeacherEntity);
            if(courseTeacherMapper.updateById(courseTeacherEntity) <= 0) {
                RaggieException.cast("Failed to update course teacher");
            }
            return courseTeacherEntity;
        }

    }

    /**
     * @param courseId
     * @param teacherId
     */
    @Override
    public void deleteCourseTeacher(Long courseId, Long teacherId) {
        LambdaQueryWrapper<CourseTeacher> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CourseTeacher::getCourseId, courseId)
                .eq(CourseTeacher::getId, teacherId);
        if(courseTeacherMapper.delete(queryWrapper) < 0) {
            RaggieException.cast("Failed to delete course teacher");
        }
    }
}
