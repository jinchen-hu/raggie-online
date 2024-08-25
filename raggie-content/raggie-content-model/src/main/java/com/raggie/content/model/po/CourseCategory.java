package com.raggie.content.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 课程分类
 * </p>
 *
 * @author Luke
 * @since 2024-08-23
 */
@Getter
@Setter
@TableName("course_category")
@ApiModel(value = "CourseCategory对象", description = "课程分类")
public class CourseCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("分类名称")
    private String name;

    @ApiModelProperty("分类标签默认和名称一样")
    private String label;

    @ApiModelProperty("父结点id（第一级的父节点是0，自关联字段id）")
    private String parentid;

    @ApiModelProperty("是否显示")
    private Integer isShow;

    @ApiModelProperty("排序字段")
    private Integer orderby;

    @ApiModelProperty("是否叶子")
    private Integer isLeaf;
}
