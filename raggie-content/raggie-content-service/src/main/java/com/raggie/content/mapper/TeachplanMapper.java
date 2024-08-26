package com.raggie.content.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.raggie.content.model.dto.TeachplanDto;
import com.raggie.content.model.po.Teachplan;

import java.util.List;

/**
 * <p>
 * 课程计划 Mapper 接口
 * </p>
 *
 * @author itcast
 */
public interface TeachplanMapper extends BaseMapper<Teachplan> {
    List<TeachplanDto> selectTreeNodes(Long courseId);
}
