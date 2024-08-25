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
 * 
 * </p>
 *
 * @author Luke
 * @since 2024-08-23
 */
@Getter
@Setter
@TableName("teachplan_media")
@ApiModel(value = "TeachplanMedia对象", description = "")
public class TeachplanMedia implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("媒资文件id")
    private String mediaId;

    @ApiModelProperty("课程计划标识")
    private Long teachplanId;

    @ApiModelProperty("课程标识")
    private Long courseId;

    @ApiModelProperty("媒资文件原始名称")
    private String mediaFilename;

    private LocalDateTime createDate;

    @ApiModelProperty("创建人")
    private String createPeople;

    @ApiModelProperty("修改人")
    private String changePeople;
}
