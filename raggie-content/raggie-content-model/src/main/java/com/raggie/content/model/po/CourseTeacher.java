package com.raggie.content.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 课程-教师关系表
 * </p>
 *
 * @author Luke
 * @since 2024-08-23
 */
@Getter
@Setter
@TableName("course_teacher")
@ApiModel(value = "CourseTeacher对象", description = "课程-教师关系表")
public class CourseTeacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("课程标识")
    private Long courseId;

    @ApiModelProperty("教师标识")
    private String teacherName;

    @ApiModelProperty("教师职位")
    private String position;

    @ApiModelProperty("教师简介")
    private String introduction;

    @ApiModelProperty("照片")
    private String photograph;

    @ApiModelProperty("创建时间")
    private LocalDateTime createDate;
}
