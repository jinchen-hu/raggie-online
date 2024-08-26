package com.raggie.content.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 课程发布
 * </p>
 *
 * @author Luke
 * @since 2024-08-25
 */
@Getter
@Setter
@TableName("course_publish")
@ApiModel(value = "CoursePublish对象", description = "课程发布")
public class CoursePublish implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("机构ID")
    private Long companyId;

    @ApiModelProperty("公司名称")
    private String companyName;

    @ApiModelProperty("课程名称")
    private String name;

    @ApiModelProperty("适用人群")
    private String users;

    @ApiModelProperty("标签")
    private String tags;

    @ApiModelProperty("创建人")
    private String username;

    @ApiModelProperty("大分类")
    private String mt;

    @ApiModelProperty("大分类名称")
    private String mtName;

    @ApiModelProperty("小分类")
    private String st;

    @ApiModelProperty("小分类名称")
    private String stName;

    @ApiModelProperty("课程等级")
    private String grade;

    @ApiModelProperty("教育模式")
    private String teachmode;

    @ApiModelProperty("课程图片")
    private String pic;

    @ApiModelProperty("课程介绍")
    private String description;

    @ApiModelProperty("课程营销信息，json格式")
    private String market;

    @ApiModelProperty("所有课程计划，json格式")
    private String teachplan;

    @ApiModelProperty("教师信息，json格式")
    private String teachers;

    @ApiModelProperty("发布时间")
    private LocalDateTime createDate;

    @ApiModelProperty("上架时间")
    private LocalDateTime onlineDate;

    @ApiModelProperty("下架时间")
    private LocalDateTime offlineDate;

    @ApiModelProperty("发布状态")
    private String status;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("收费规则，对应数据字典--203")
    private String charge;

    @ApiModelProperty("现价")
    private Float price;

    @ApiModelProperty("原价")
    private Float originalPrice;

    @ApiModelProperty("课程有效期天数")
    private Integer validDays;
}
