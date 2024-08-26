package com.raggie.content.service;

import com.raggie.content.model.dto.SaveTeachplanDto;
import com.raggie.content.model.dto.TeachplanDto;

import java.util.List;

public interface TeachplanService {
    List<TeachplanDto> findTeachplanTree(Long courseId);
    void saveTeachplan(SaveTeachplanDto teachplanDto);
    void deleteTeachplan(Long teachplanId);
}
