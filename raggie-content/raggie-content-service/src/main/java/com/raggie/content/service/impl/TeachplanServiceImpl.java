package com.raggie.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.raggie.base.exception.RaggieException;
import com.raggie.content.mapper.TeachplanMapper;
import com.raggie.content.model.dto.SaveTeachplanDto;
import com.raggie.content.model.dto.TeachplanDto;
import com.raggie.content.model.po.Teachplan;
import com.raggie.content.service.TeachplanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class TeachplanServiceImpl implements TeachplanService {
    @Autowired
    private TeachplanMapper teachplanMapper;
    @Override
    public List<TeachplanDto> findTeachplanTree(Long courseId) {
        return teachplanMapper.selectTreeNodes(courseId);
    }

    /**
     * @param teachplanDto
     */
    @Transactional
    @Override
    public void saveTeachplan(SaveTeachplanDto teachplanDto) {
        Long teachplanId = teachplanDto.getId();
        if (teachplanId == null) {
            Teachplan teachplan = new Teachplan();
            BeanUtils.copyProperties(teachplanDto, teachplan);
            teachplan.setCreateDate(LocalDateTime.now());

            teachplan.setOrderby(getTeachplanCount(teachplan.getCourseId(), teachplan.getParentid()));

            if(teachplanMapper.insert(teachplan) <= 0) {
                RaggieException.cast("Failed to create teach plan");
            }
        } else {
            Teachplan teachplan = teachplanMapper.selectById(teachplanId);
            BeanUtils.copyProperties(teachplanDto, teachplan);
            teachplan.setChangeDate(LocalDateTime.now());

            if(teachplanMapper.updateById(teachplan) <= 0) {
                RaggieException.cast("Failed to update teach plan");
            }
        }
    }

    private Integer getTeachplanCount(Long courseId, Long parentId) {
        LambdaQueryWrapper<Teachplan> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Teachplan::getCourseId, courseId)
                .eq(Teachplan::getParentid, parentId);
        return Math.toIntExact(teachplanMapper.selectCount(queryWrapper) + 1);
    }
}
