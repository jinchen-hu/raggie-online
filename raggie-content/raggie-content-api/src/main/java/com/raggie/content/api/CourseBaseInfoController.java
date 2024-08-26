package com.raggie.content.api;


import com.raggie.base.model.PageParams;
import com.raggie.base.model.PageResult;
import com.raggie.content.model.dto.QueryCourseParamsDto;
import com.raggie.content.model.po.CourseBase;
import com.raggie.content.service.CourseBaseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Course Info", tags = "Course Info")
public class CourseBaseInfoController {

    @Autowired
    CourseBaseInfoService courseBaseInfoService;

    @PostMapping("/course/list")
    @ApiOperation("Query Course Interface")
    public PageResult<CourseBase> list(PageParams pageParams, @RequestBody(required = false) QueryCourseParamsDto queryCourseParams) {
        return courseBaseInfoService.queryCourseBaseList(pageParams, queryCourseParams);
    }
}
