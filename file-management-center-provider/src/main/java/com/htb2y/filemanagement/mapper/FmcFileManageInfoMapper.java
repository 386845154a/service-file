package com.htb2y.filemanagement.mapper;

import com.htb2y.filemanagement.bean.entity.FmcFileManageInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FmcFileManageInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(FmcFileManageInfo record);

    FmcFileManageInfo selectByPrimaryKey(String id);

    List<FmcFileManageInfo> selectAll();

    int updateByPrimaryKey(FmcFileManageInfo record);
}