package com.htb2y.filemanagement.bean.bo;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileBo {

    private CommonsMultipartFile commonsMultipartFile;

    public CommonsMultipartFile getCommonsMultipartFile() {
        return commonsMultipartFile;
    }

    public void setCommonsMultipartFile(CommonsMultipartFile commonsMultipartFile) {
        this.commonsMultipartFile = commonsMultipartFile;
    }
}
