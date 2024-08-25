package com.raggie.content.api;


import com.raggie.base.model.PageParams;
import com.raggie.base.model.PageResult;
import com.raggie.content.model.dto.QueryCourseParamsDto;
import com.raggie.content.model.po.CourseBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "Course Info", tags = "Course Info")
public class CourseBaseInfoController {
    @PostMapping("/course/list")
    @ApiOperation("课程查询接口")
    public PageResult<CourseBase> list(PageParams pageParams, @RequestBody QueryCourseParamsDto queryCourseParams) {
        CourseBase courseBase = new CourseBase();
        courseBase.setId(15L);
        courseBase.setDescription("Test Course");
        PageResult<CourseBase> result = new PageResult<>();
        result.setItems(List.of(courseBase));
        result.setPage(1);
        result.setPageSize(10);
        result.setCounts(1);
        return result;
    }
}
