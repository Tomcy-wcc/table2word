package com.mark.springboot.domain;

import java.util.Date;
import java.util.List;

/**
 * 接口信息
 */
public class InterfaceInfo {

    private Integer id;

    private String name;

    private String url;

    private String method;

    private String description;

    private Integer priority;

    private Integer status;

    private Integer creatorId;

    private Integer lockerId;

    private Integer moduleId;

    private Integer repositoryId;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private List<Property> requestProperties;

    private List<Property> responseProperties;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Property> getResponseProperties() {
        return responseProperties;
    }

    public void setResponseProperties(List<Property> responseProperties) {
        this.responseProperties = responseProperties;
    }

    public List<Property> getRequestProperties() {
        return requestProperties;
    }

    public void setRequestProperties(List<Property> requestProperties) {
        this.requestProperties = requestProperties;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Integer getLockerId() {
        return lockerId;
    }

    public void setLockerId(Integer lockerId) {
        this.lockerId = lockerId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getRepositoryId() {
        return repositoryId;
    }

    public void setRepositoryId(Integer repositoryId) {
        this.repositoryId = repositoryId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        return "InterfaceInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", status=" + status +
                ", creatorId=" + creatorId +
                ", lockerId=" + lockerId +
                ", moduleId=" + moduleId +
                ", repositoryId=" + repositoryId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                ", requestProperties=" + requestProperties +
                ", responseProperties=" + responseProperties +
                '}';
    }
}
