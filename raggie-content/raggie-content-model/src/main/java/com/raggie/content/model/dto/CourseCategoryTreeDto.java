package com.raggie.content.model.dto;

import com.raggie.content.model.po.CourseCategory;
import lombok.Data;

import java.util.List;

/**
 * @author Mr.M
 * @version 1.0
 * @description TODO
 * @date 2023/2/12 11:51
 */
@Data
public class CourseCategoryTreeDto extends CourseCategory implements java.io.Serializable {

   //子节点
   List<CourseCategoryTreeDto> childrenTreeNodes;

}
