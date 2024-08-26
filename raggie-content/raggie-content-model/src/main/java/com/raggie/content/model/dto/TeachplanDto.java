package com.raggie.content.model.dto;

import com.raggie.content.model.po.Teachplan;
import com.raggie.content.model.po.TeachplanMedia;
import lombok.Data;

import java.util.List;

@Data
public class TeachplanDto extends Teachplan {
    private TeachplanMedia teachplanMedia;
    private List<TeachplanDto> teachPlanTreeNodes;
}
