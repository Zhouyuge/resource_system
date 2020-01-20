package com.bishe.main.entity;

import java.util.Date;

public class Resume {
    private Integer id;

    private String userId;

    private String name;

    private Integer age;

    private String selfDesc;

    private String edu;

    private String sex;

    private String tel;

    private String email;

    private String school;

    private String skill;

    private String productName;

    private String productType;

    private String productDate;

    private String productExpirence;

    private String workName;

    private String workType;

    private String workDate;

    private String workExpirence;

    private Date createTime;

    private Date editTime;

    private Integer deliverNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSelfDesc() {
        return selfDesc;
    }

    public void setSelfDesc(String selfDesc) {
        this.selfDesc = selfDesc == null ? null : selfDesc.trim();
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu == null ? null : edu.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill == null ? null : skill.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate == null ? null : productDate.trim();
    }

    public String getProductExpirence() {
        return productExpirence;
    }

    public void setProductExpirence(String productExpirence) {
        this.productExpirence = productExpirence == null ? null : productExpirence.trim();
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName == null ? null : workName.trim();
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType == null ? null : workType.trim();
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate == null ? null : workDate.trim();
    }

    public String getWorkExpirence() {
        return workExpirence;
    }

    public void setWorkExpirence(String workExpirence) {
        this.workExpirence = workExpirence == null ? null : workExpirence.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public Integer getDeliverNum() {
        return deliverNum;
    }

    public void setDeliverNum(Integer deliverNum) {
        this.deliverNum = deliverNum;
    }
}