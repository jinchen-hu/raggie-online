package com.raggie.content.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EditCourseDto extends AddCourseDto{
    @ApiModelProperty
    private Long id;
}
