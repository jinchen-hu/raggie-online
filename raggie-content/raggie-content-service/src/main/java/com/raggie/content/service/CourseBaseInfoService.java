package com.raggie.content.service;

import com.raggie.base.model.PageParams;
import com.raggie.base.model.PageResult;
import com.raggie.content.model.dto.AddCourseDto;
import com.raggie.content.model.dto.CourseBaseInfoDto;
import com.raggie.content.model.dto.EditCourseDto;
import com.raggie.content.model.dto.QueryCourseParamsDto;
import com.raggie.content.model.po.CourseBase;

public interface CourseBaseInfoService {
    /**
     *
     * @param pageParams
     * @param queryCourseParamsDto
     * @return
     */
    public PageResult<CourseBase> queryCourseBaseList(PageParams pageParams, QueryCourseParamsDto queryCourseParamsDto);

    CourseBaseInfoDto createCourseBase(Long companyId, AddCourseDto addCourseDto);
    CourseBaseInfoDto getCourseBase(Long id);
    CourseBaseInfoDto updateCourseBase(Long companyId, EditCourseDto editCourseDto);
    void deleteCourseBase(Long companyId, Long courseId);
}
