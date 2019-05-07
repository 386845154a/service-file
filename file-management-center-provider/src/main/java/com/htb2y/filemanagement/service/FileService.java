package com.htb2y.filemanagement.service;

import com.htb2y.filemanagement.bean.bo.FileBo;
import com.htb2y.filemanagement.bean.dto.FileDto;
import com.htb2y.filemanagement.bean.entity.FmcFileManageInfo;

public interface FileService {

//    public int download(String id) throws RuntimeException;

//    public FmcFileManageInfo findFileById(String id) throws RuntimeException;

    public int upload(FileDto fileDto) throws Exception;
}
