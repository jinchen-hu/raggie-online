package com.raggie.content.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 课程基本信息
 * </p>
 *
 * @author Luke
 * @since 2024-08-25
 */
@Getter
@Setter
@TableName("course_base")
@ApiModel(value = "CourseBase对象", description = "课程基本信息")
public class CourseBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("机构ID")
    private Long companyId;

    @ApiModelProperty("机构名称")
    private String companyName;

    @ApiModelProperty("课程名称")
    private String name;

    @ApiModelProperty("适用人群")
    private String users;

    @ApiModelProperty("课程标签")
    private String tags;

    @ApiModelProperty("大分类")
    private String mt;

    @ApiModelProperty("小分类")
    private String st;

    @ApiModelProperty("课程等级")
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
