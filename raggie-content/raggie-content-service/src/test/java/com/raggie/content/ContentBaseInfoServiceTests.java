package com.raggie.content;

import com.raggie.base.model.PageParams;
import com.raggie.base.model.PageResult;
import com.raggie.content.model.dto.QueryCourseParamsDto;
import com.raggie.content.model.po.CourseBase;
import com.raggie.content.service.CourseBaseInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ContentBaseInfoServiceTests {
    @Autowired
    CourseBaseInfoService courseBaseInfoService;

    @Test
    public void testCourseBaseInfoService() {
        QueryCourseParamsDto courseParamsDto = new QueryCourseParamsDto();
        courseParamsDto.setCourseName("java");//课程名称查询条件
        courseParamsDto.setAuditStatus("202004");//202004表示课程审核通过

        PageParams pageParams = new PageParams();
        pageParams.setPageNo(2L);
        pageParams.setPageSize(2L);

        PageResult<CourseBase> courseBasePageResult = courseBaseInfoService.queryCourseBaseList(pageParams, courseParamsDto);
        Assertions.assertFalse(courseBasePageResult.getItems().isEmpty());
        log.info(">>>> results: {}", courseBasePageResult);
    }
}
