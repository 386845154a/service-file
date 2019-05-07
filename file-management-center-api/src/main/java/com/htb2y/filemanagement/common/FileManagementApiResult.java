package com.htb2y.filemanagement.common;

import com.htb2y.filemanagement.bean.enums.FileManagementApiEnum;

import java.io.Serializable;

public class FileManagementApiResult<T> implements Serializable {
    private static final long serialVersionUID = -8046877952512659909L;
    private String code;
    private String massage;
    private T data;

    public FileManagementApiResult(){
        this.code = "0";
        this.massage = "";
        this.data = null;
    }

    public FileManagementApiResult(String code,String massage,T data){
        this.code = code;
        this.massage = massage;
        this.data = data;
    }

    public FileManagementApiResult(String code,T data){
        this.code = code==null?"":code;
        if (code == null){
            this.massage = "";
        }else{
            for (FileManagementApiEnum fileToolCenterApiEnum: FileManagementApiEnum.values()) {
                if (fileToolCenterApiEnum.getCode().equals(code)){
                    this.massage = fileToolCenterApiEnum.getValue();
                    break;
                }
            }
        }
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
