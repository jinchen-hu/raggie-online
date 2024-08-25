package com.raggie.content;

import com.raggie.content.mapper.CourseBaseMapper;
import com.raggie.content.model.po.CourseBase;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ContentBaseMapperTests {
    @Resource
    CourseBaseMapper courseBaseMapper;

    @Test
    public void testCourseBaseMapper() {
        CourseBase courseBase = courseBaseMapper.selectById(22);
        System.out.println(courseBase.toString());
        log.info("Course information with ID 22: {}", courseBase);
    }
}