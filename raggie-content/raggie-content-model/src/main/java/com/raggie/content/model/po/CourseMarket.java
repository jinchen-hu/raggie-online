package com.raggie.content.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 课程营销信息
 * </p>
 *
 * @author Luke
 * @since 2024-08-23
 */
@Getter
@Setter
@TableName("course_market")
@ApiModel(value = "CourseMarket对象", description = "课程营销信息")
public class CourseMarket implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键，课程id")
    private Long id;

    @ApiModelProperty("收费规则，对应数据字典")
    private String charge;

    @ApiModelProperty("现价")
    private Float price;

    @ApiModelProperty("原价")
    private Float originalPrice;

    @ApiModelProperty("咨询qq")
    private String qq;

    @ApiModelProperty("微信")
    private String wechat;

    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("有效期天数")
    private Integer validDays;
}
