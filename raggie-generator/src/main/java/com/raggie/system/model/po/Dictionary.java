package com.raggie.system.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 数据字典
 * </p>
 *
 * @author Luke
 * @since 2024-08-25
 */
@Getter
@Setter
@ApiModel(value = "Dictionary对象", description = "数据字典")
public class Dictionary implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id标识")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("数据字典名称")
    private String name;

    @ApiModelProperty("数据字典代码")
    private String code;

    @ApiModelProperty("数据字典项--json格式
  ")
    private String itemValues;
}
