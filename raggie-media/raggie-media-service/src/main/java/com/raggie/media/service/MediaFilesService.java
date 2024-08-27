package com.raggie.media.service;

import com.raggie.base.model.PageParams;
import com.raggie.base.model.PageResult;
import com.raggie.media.model.dto.QueryMediaParamsDto;
import com.raggie.media.model.dto.UploadFileParamsDto;
import com.raggie.media.model.dto.UploadFileResultDto;
import com.raggie.media.model.po.MediaFiles;

public interface MediaFilesService {
    /**
     * @description 媒资文件查询方法
     * @param pageParams 分页参数
     * @param queryMediaParamsDto 查询条件
     * @return com.xuecheng.base.model.PageResult<com.xuecheng.media.model.po.MediaFiles>
     * @author Mr.M
     * @date 2022/9/10 8:57
     */
    public PageResult<MediaFiles> queryMediaFiles(Long companyId, PageParams pageParams, QueryMediaParamsDto queryMediaParamsDto);

    /**
     * 上传文件
     * @param companyId 机构id
     * @param uploadFileParamsDto 文件信息
     * @param localFilePath 文件本地路径
     * @return UploadFileResultDto
     */
    public UploadFileResultDto uploadFile(Long companyId, UploadFileParamsDto uploadFileParamsDto, String localFilePath);

    public MediaFiles addMediaFilesToDb(Long companyId,String fileMd5,UploadFileParamsDto uploadFileParamsDto,String bucket,String objectName);
}
