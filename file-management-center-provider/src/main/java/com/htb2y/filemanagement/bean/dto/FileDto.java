package com.htb2y.filemanagement.bean.dto;

import com.htb2y.filemanagement.bean.entity.FmcFileManageInfo;
import org.springframework.web.multipart.MultipartFile;

public class FileDto {

//    private FileBo fileBo;
    private MultipartFile file;

    private FmcFileManageInfo fmcFileManageInfo;

    private String loadPath;

    public FmcFileManageInfo getFmcFileManageInfo() {
        return fmcFileManageInfo;
    }

    public void setFmcFileManageInfo(FmcFileManageInfo fmcFileManageInfo) {
        this.fmcFileManageInfo = fmcFileManageInfo;
    }

    public String getLoadPath() {
        return loadPath;
    }

    public void setLoadPath(String loadPath) {
        this.loadPath = loadPath;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
