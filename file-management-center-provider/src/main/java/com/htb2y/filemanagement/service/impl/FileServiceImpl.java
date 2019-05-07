package com.htb2y.filemanagement.service.impl;

import com.htb2y.filemanagement.bean.bo.FileBo;
import com.htb2y.filemanagement.bean.dto.FileDto;
import com.htb2y.filemanagement.bean.entity.FmcFileManageInfo;
import com.htb2y.filemanagement.mapper.FmcFileManageInfoMapper;
import com.htb2y.filemanagement.service.FileService;
import com.htb2y.filemanagement.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FmcFileManageInfoMapper fmcFileManageInfoMapper;


    public int upload(FileDto fileDto) throws Exception {

        //上传文件
        this.fileUpload(fileDto);

        int n=1;
        //信息入库
//        n = this.insert(fileDto);

        //TODO 文件管理轨迹
        //TODO 日志中心-存储操作日志

        return n;
    }

    /**
     * 上传文件信息入库
     * @param fileDto
     * @return
     */
    private int insert(FileDto fileDto) {
        FmcFileManageInfo fmcFileManageInfo = fileDto.getFmcFileManageInfo();

        fmcFileManageInfo.setCreateTime(new Date());
        fmcFileManageInfo.setCreateUser("");//TODO
        return fmcFileManageInfoMapper.insert(fmcFileManageInfo);
    }

    /**
     * 文件上传
     * @param fileDto
     * @throws Exception
     */
    private void fileUpload(FileDto fileDto) throws Exception{
//        FileBo fileBo = fileDto.getFileBo();
        MultipartFile file = fileDto.getFile();
        if(file == null) throw new NullPointerException();
        long  startTime=System.currentTimeMillis();
//        CommonsMultipartFile commonsMultipartFile = fileBo.getCommonsMultipartFile();
        //TODO 暂时未处理集群环境幂等性问题 后续需要分布式锁
        String uuid= new Date().getTime()+UUID.randomUUID().toString();
        String path="C:\\航天部二院项目\\";
        String url=path+uuid;
        FileUtil.uploadFile(file,url);
        long  endTime=System.currentTimeMillis();
        long uploadTime = endTime - startTime;
        logger.info("文件上传成功--->上传时间：{} ms",uploadTime);
        //上传文件路径
        fileDto.getFmcFileManageInfo().setUploadUrl(path);
        //上传文件名称
        fileDto.getFmcFileManageInfo().setUploadName(uuid);
        //文件名称 TODO MD5加密
        fileDto.getFmcFileManageInfo().setFileName(file.getOriginalFilename());
        //文件上传时长
        fileDto.getFmcFileManageInfo().setUploadTime(new BigDecimal(uploadTime));
    }
}
