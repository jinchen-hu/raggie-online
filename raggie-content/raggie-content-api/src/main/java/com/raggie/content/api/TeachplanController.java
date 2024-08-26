package com.raggie.content.api;

import com.raggie.content.model.dto.TeachplanDto;
import com.raggie.content.service.TeachplanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "", tags = "")
public class TeachplanController {
    @Autowired
    private TeachplanService teachplanService;

    @ApiOperation("")
    @GetMapping("/teachplan/{courseId}/tree-nodes")
    public List<TeachplanDto> getTreeNodes(@PathVariable(name = "courseId") Long courseId) {
        return teachplanService.findTeachplanTree(courseId);
    }
}
