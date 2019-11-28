package com.mark.springboot.domain;

public class TableFields {

    private String field;//字段名
    private String type;//类型
    private String isNull;//是否为空
    private String keyName;//主键
    private String comment;//字段说明

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsNull() {
        return isNull;
    }

    public void setIsNull(String isNull) {
        this.isNull = isNull;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "TableFileds{" +
                "field='" + field + '\'' +
                ", type='" + type + '\'' +
                ", isNull='" + isNull + '\'' +
                ", keyName='" + keyName + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
