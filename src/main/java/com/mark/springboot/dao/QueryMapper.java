package com.mark.springboot.dao;


import com.mark.springboot.domain.TableFields;
import com.mark.springboot.domain.Tables;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueryMapper {

    /**
     * 获取库下面所有表的表名和表的注释
     * @return 某个库所有表名和注释
     */
    List<Tables> getAllTables(@Param("dataName") String dataName);

    /**
     * 获取某张表下面的字段名，字段类型，是否为null, 约束, 字段说明，
     * @param dataName 库名
     * @param tableName 表名
     * @return
     */
    List<TableFields> getTable(@Param("dataName") String dataName, @Param("tableName") String tableName);

}
