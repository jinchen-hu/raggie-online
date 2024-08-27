package com.raggie.media.api.controller;

import com.raggie.base.model.PageParams;
import com.raggie.base.model.PageResult;
import com.raggie.media.model.dto.QueryMediaParamsDto;
import com.raggie.media.model.dto.UploadFileParamsDto;
import com.raggie.media.model.dto.UploadFileResultDto;
import com.raggie.media.model.po.MediaFiles;
import com.raggie.media.service.MediaFilesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Api("")
@RestController
public class MediaFilesController {
    @Autowired
    MediaFilesService mediaFilesService;

    @ApiOperation("媒资列表查询接口")
    @PostMapping("/files")
    public PageResult<MediaFiles> list(PageParams pageParams, @RequestBody QueryMediaParamsDto queryMediaParamsDto){
        Long companyId = 1232141425L;
        return mediaFilesService.queryMediaFiles(companyId,pageParams,queryMediaParamsDto);

    }
    // TODO: handle folder
    @ApiOperation("")
    @RequestMapping(value = "/upload/coursefile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public UploadFileResultDto upload(@RequestPart("filedata") MultipartFile filedata) throws IOException {
        UploadFileParamsDto uploadFileParamsDto = new UploadFileParamsDto();
        //原始文件名称
        uploadFileParamsDto.setFilename(filedata.getOriginalFilename());
        //文件大小
        uploadFileParamsDto.setFileSize(filedata.getSize());
        //文件类型
        uploadFileParamsDto.setFileType("001001");
        //创建一个临时文件
        File tempFile = File.createTempFile("minio", ".temp");
        filedata.transferTo(tempFile);
        Long companyId = 1232141425L;
        //文件路径
        String localFilePath = tempFile.getAbsolutePath();

        //调用service上传图片

        return mediaFilesService.uploadFile(companyId, uploadFileParamsDto, localFilePath);
    }
}
