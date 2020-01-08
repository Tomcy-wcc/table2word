package com.mark.springboot.domain;

import java.util.Date;
import java.util.List;

/**
 * 请求参数
 */
public class Property {

    private Integer id;

    private String scope;

    private String type;

    private Integer pos;

    private String name;

    private String rule;

    private String value;

    private String description;

    private Integer parentId;

    private Long priority;

    private Integer interfaceId;

    private Integer creatorId;

    private Integer moduleId;

    private Integer repositoryId;

    private boolean required;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private Integer depth;

    private List<Property> children;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public Integer getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Integer interfaceId) {
        this.interfaceId = interfaceId;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
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

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
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

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public List<Property> getChildren() {
        return children;
    }

    public void setChildren(List<Property> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", scope='" + scope + '\'' +
                ", type='" + type + '\'' +
                ", pos=" + pos +
                ", name='" + name + '\'' +
                ", rule='" + rule + '\'' +
                ", value='" + value + '\'' +
                ", description='" + description + '\'' +
                ", parentId=" + parentId +
                ", priority=" + priority +
                ", interfaceId=" + interfaceId +
                ", creatorId=" + creatorId +
                ", moduleId=" + moduleId +
                ", repositoryId=" + repositoryId +
                ", required=" + required +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                ", depth=" + depth +
                ", children=" + children +
                '}';
    }
}
