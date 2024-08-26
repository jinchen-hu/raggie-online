package com.raggie.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.raggie.system.model.po.Dictionary;

import java.util.List;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author Luke
 * @since 2024-08-25
 */
public interface DictionaryService extends IService<Dictionary> {
    List<Dictionary> queryAll();

    Dictionary getByCode(String code);
}
