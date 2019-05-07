package com.htb2y.filemanagement.controller;

import com.alibaba.fastjson.JSONObject;
import com.htb2y.filemanagement.bean.bo.FileBo;
import com.htb2y.filemanagement.bean.dto.FileDto;
import com.htb2y.filemanagement.bean.entity.FmcFileManageInfo;
import com.htb2y.filemanagement.bean.enums.FileManagementApiEnum;
import com.htb2y.filemanagement.common.FileManagementApiResult;
import com.htb2y.filemanagement.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
@Api("文件操作应用")
@RequestMapping(value = "/filecontroller")
public class FileController {

    @Autowired
    private FileService fileService;

    @ApiOperation("文件下载")
    @PostMapping(value = "/download")
    public void downloadFile(HttpServletResponse httpServletResponse){
//        return new FileToolCenterApiResult(FileToolCenterApiEnum.API_RESULT_SUCCESS.getCode(),"asasas");
    }

    @ApiOperation("文件上传")
    @PostMapping(value = "/upload")
    public FileManagementApiResult upload(/*@RequestBody FileBo fileBo,*/
                                        @RequestParam(value = "file",required = true) MultipartFile file,
                                        @RequestParam("token")String token){

        //Step1：校验登陆信息
        //Step2：文件上传
        //Step3：上传文件入库

        //TODO token校验登陆信息
        //User user = userService.getToken(token);
        //if(user == null) return new FileManagementApiResult(FileManagementApiEnum.API_RESULT_ERROR.getCode(),"登陆超时");
        //fileBo.setUser(user);
        //文件上传以及下载
        int upload = 0;
        FileDto fileDto = new FileDto();
        fileDto.setFile(file);
        FmcFileManageInfo fmcFileManageInfo = new FmcFileManageInfo();
        fileDto.setFmcFileManageInfo(fmcFileManageInfo);
        try {
            upload = fileService.upload(fileDto);
        } catch (Exception e) {
            return new FileManagementApiResult(FileManagementApiEnum.API_RESULT_ERROR.getCode(),e.toString());
        }
        if (upload != 1){
            return new FileManagementApiResult(FileManagementApiEnum.API_RESULT_FAIL.getCode(),"文件处理失败");
        }
        return new FileManagementApiResult(FileManagementApiEnum.API_RESULT_SUCCESS.getCode(),"");
    }

    @ApiOperation("获取文件信息")
    @PostMapping(value = "/massage")
    public FileManagementApiResult getFileMassage(){
        String jsonStr = JSONObject.toJSONString("");
        return new FileManagementApiResult(FileManagementApiEnum.API_RESULT_SUCCESS.getCode(),jsonStr);
    }

    @PostMapping(value = "/test")
    public FileManagementApiResult test(@RequestParam("id")String id){
        String jsonStr = JSONObject.toJSONString("");
        return new FileManagementApiResult(FileManagementApiEnum.API_RESULT_SUCCESS.getCode(),jsonStr);
    }
}
