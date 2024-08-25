package com.raggie.content.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 课程基本信息
 * </p>
 *
 * @author Luke
 * @since 2024-08-23
 */
@Getter
@Setter
@ToString
@TableName("course_base")
@ApiModel(value = "CourseBase Object", description = "Basic course information")
public class CourseBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("Primary key")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("Company ID")
    private Long companyId;

    @ApiModelProperty("Company name")
    private String companyName;

    @ApiModelProperty("Course name")
    private String name;

    @ApiModelProperty("Targeted people")
    private String users;

    @ApiModelProperty("Course tags")
    private String tags;

    @ApiModelProperty("Major category")
    private String mt;

    @ApiModelProperty("Minor category")
    private String st;

    @ApiModelProperty("Course level")
    private String grade;

    @ApiModelProperty("教育模式(common普通，record 录播，live直播等）")
    private String teachmode;

    @ApiModelProperty("课程介绍")
    private String description;

    @ApiModelProperty("课程图片")
    private String pic;

    @ApiModelProperty("创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty("修改时间")
    private LocalDateTime changeDate;

    @ApiModelProperty("创建人")
    private String createPeople;

    @ApiModelProperty("更新人")
    private String changePeople;

    @ApiModelProperty("审核状态")
    private String auditStatus;

    @ApiModelProperty("课程发布状态 未发布  已发布 下线")
    private String status;
}
