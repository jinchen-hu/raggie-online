package com.raggie.content.service;

import com.raggie.content.model.po.CourseTeacher;

import java.util.List;

/**
 * <p>
 * 课程-教师关系表 服务类
 * </p>
 *
 * @author Luke
 * @since 2024-08-25
 */
public interface CourseTeacherService {
    List<CourseTeacher> getCourseTeacherList(Long courseId);
    CourseTeacher saveCourseTeacher(CourseTeacher courseTeacher);
    void deleteCourseTeacher(Long courseId, Long teacherId);
}