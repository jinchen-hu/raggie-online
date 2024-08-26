package com.raggie.content;

import com.raggie.content.model.dto.CourseCategoryTreeDto;
import com.raggie.content.service.CourseCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class CourseCategoryServiceTests {
    @Autowired
    CourseCategoryService courseCategoryService;

    @Test
    public void testCourseCategoryService() {

        List<CourseCategoryTreeDto> courseCategoryTreeDtos = courseCategoryService.queryTreeNodes("1");
        Assertions.assertNotNull(courseCategoryTreeDtos);
        Assertions.assertFalse(courseCategoryTreeDtos.isEmpty());
        log.info(">>>result: {}", courseCategoryTreeDtos);

    }
}
