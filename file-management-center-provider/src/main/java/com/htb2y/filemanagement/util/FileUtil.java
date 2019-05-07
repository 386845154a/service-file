package com.htb2y.filemanagement.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtil {
    private static final Long FILE_SIZE = 2*1024*1024*1024L;

    private static final String PATH = "C:\\航天部二院项目";

    public static boolean uploadFile(MultipartFile file, String path) throws Exception {
        if (file == null){
            throw new NullPointerException();
        }
        if (FILE_SIZE<file.getSize()){
            throw new RuntimeException("上传文件超过2G");
        }
        long  startTime=System.currentTimeMillis();
        file.transferTo(new File(path));
        long  endTime=System.currentTimeMillis();
        long uploadTime = endTime - startTime;
        System.out.println("文件上传成功--->上传时间："+uploadTime+"ms");
        return true;
    }

    public static boolean uploadFile(MultipartFile file) throws Exception {
        if (file == null){
            throw new NullPointerException();
        }
        if (FILE_SIZE<file.getSize()){
            throw new RuntimeException("上传文件超过2G");
        }
        file.transferTo(new File(PATH));
        return true;
    }
}
