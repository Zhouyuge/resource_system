package com.bishe.main.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNull() {
            addCriterion("user_password is null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNotNull() {
            addCriterion("user_password is not null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordEqualTo(String value) {
            addCriterion("user_password =", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotEqualTo(String value) {
            addCriterion("user_password <>", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThan(String value) {
            addCriterion("user_password >", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("user_password >=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThan(String value) {
            addCriterion("user_password <", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("user_password <=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLike(String value) {
            addCriterion("user_password like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotLike(String value) {
            addCriterion("user_password not like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIn(List<String> values) {
            addCriterion("user_password in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotIn(List<String> values) {
            addCriterion("user_password not in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordBetween(String value1, String value2) {
            addCriterion("user_password between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotBetween(String value1, String value2) {
            addCriterion("user_password not between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNull() {
            addCriterion("user_sex is null");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNotNull() {
            addCriterion("user_sex is not null");
            return (Criteria) this;
        }

        public Criteria andUserSexEqualTo(Boolean value) {
            addCriterion("user_sex =", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotEqualTo(Boolean value) {
            addCriterion("user_sex <>", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThan(Boolean value) {
            addCriterion("user_sex >", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThanOrEqualTo(Boolean value) {
            addCriterion("user_sex >=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThan(Boolean value) {
            addCriterion("user_sex <", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThanOrEqualTo(Boolean value) {
            addCriterion("user_sex <=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexIn(List<Boolean> values) {
            addCriterion("user_sex in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotIn(List<Boolean> values) {
            addCriterion("user_sex not in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexBetween(Boolean value1, Boolean value2) {
            addCriterion("user_sex between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotBetween(Boolean value1, Boolean value2) {
            addCriterion("user_sex not between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserVisualNameIsNull() {
            addCriterion("user_visual_name is null");
            return (Criteria) this;
        }

        public Criteria andUserVisualNameIsNotNull() {
            addCriterion("user_visual_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserVisualNameEqualTo(String value) {
            addCriterion("user_visual_name =", value, "userVisualName");
            return (Criteria) this;
        }

        public Criteria andUserVisualNameNotEqualTo(String value) {
            addCriterion("user_visual_name <>", value, "userVisualName");
            return (Criteria) this;
        }

        public Criteria andUserVisualNameGreaterThan(String value) {
            addCriterion("user_visual_name >", value, "userVisualName");
            return (Criteria) this;
        }

        public Criteria andUserVisualNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_visual_name >=", value, "userVisualName");
            return (Criteria) this;
        }

        public Criteria andUserVisualNameLessThan(String value) {
            addCriterion("user_visual_name <", value, "userVisualName");
            return (Criteria) this;
        }

        public Criteria andUserVisualNameLessThanOrEqualTo(String value) {
            addCriterion("user_visual_name <=", value, "userVisualName");
            return (Criteria) this;
        }

        public Criteria andUserVisualNameLike(String value) {
            addCriterion("user_visual_name like", value, "userVisualName");
            return (Criteria) this;
        }

        public Criteria andUserVisualNameNotLike(String value) {
            addCriterion("user_visual_name not like", value, "userVisualName");
            return (Criteria) this;
        }

        public Criteria andUserVisualNameIn(List<String> values) {
            addCriterion("user_visual_name in", values, "userVisualName");
            return (Criteria) this;
        }

        public Criteria andUserVisualNameNotIn(List<String> values) {
            addCriterion("user_visual_name not in", values, "userVisualName");
            return (Criteria) this;
        }

        public Criteria andUserVisualNameBetween(String value1, String value2) {
            addCriterion("user_visual_name between", value1, value2, "userVisualName");
            return (Criteria) this;
        }

        public Criteria andUserVisualNameNotBetween(String value1, String value2) {
            addCriterion("user_visual_name not between", value1, value2, "userVisualName");
            return (Criteria) this;
        }

        public Criteria andUserTelIsNull() {
            addCriterion("user_tel is null");
            return (Criteria) this;
        }

        public Criteria andUserTelIsNotNull() {
            addCriterion("user_tel is not null");
            return (Criteria) this;
        }

        public Criteria andUserTelEqualTo(String value) {
            addCriterion("user_tel =", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotEqualTo(String value) {
            addCriterion("user_tel <>", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelGreaterThan(String value) {
            addCriterion("user_tel >", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelGreaterThanOrEqualTo(String value) {
            addCriterion("user_tel >=", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelLessThan(String value) {
            addCriterion("user_tel <", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelLessThanOrEqualTo(String value) {
            addCriterion("user_tel <=", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelLike(String value) {
            addCriterion("user_tel like", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotLike(String value) {
            addCriterion("user_tel not like", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelIn(List<String> values) {
            addCriterion("user_tel in", values, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotIn(List<String> values) {
            addCriterion("user_tel not in", values, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelBetween(String value1, String value2) {
            addCriterion("user_tel between", value1, value2, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotBetween(String value1, String value2) {
            addCriterion("user_tel not between", value1, value2, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserEmalIsNull() {
            addCriterion("user_emal is null");
            return (Criteria) this;
        }

        public Criteria andUserEmalIsNotNull() {
            addCriterion("user_emal is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmalEqualTo(String value) {
            addCriterion("user_emal =", value, "userEmal");
            return (Criteria) this;
        }

        public Criteria andUserEmalNotEqualTo(String value) {
            addCriterion("user_emal <>", value, "userEmal");
            return (Criteria) this;
        }

        public Criteria andUserEmalGreaterThan(String value) {
            addCriterion("user_emal >", value, "userEmal");
            return (Criteria) this;
        }

        public Criteria andUserEmalGreaterThanOrEqualTo(String value) {
            addCriterion("user_emal >=", value, "userEmal");
            return (Criteria) this;
        }

        public Criteria andUserEmalLessThan(String value) {
            addCriterion("user_emal <", value, "userEmal");
            return (Criteria) this;
        }

        public Criteria andUserEmalLessThanOrEqualTo(String value) {
            addCriterion("user_emal <=", value, "userEmal");
            return (Criteria) this;
        }

        public Criteria andUserEmalLike(String value) {
            addCriterion("user_emal like", value, "userEmal");
            return (Criteria) this;
        }

        public Criteria andUserEmalNotLike(String value) {
            addCriterion("user_emal not like", value, "userEmal");
            return (Criteria) this;
        }

        public Criteria andUserEmalIn(List<String> values) {
            addCriterion("user_emal in", values, "userEmal");
            return (Criteria) this;
        }

        public Criteria andUserEmalNotIn(List<String> values) {
            addCriterion("user_emal not in", values, "userEmal");
            return (Criteria) this;
        }

        public Criteria andUserEmalBetween(String value1, String value2) {
            addCriterion("user_emal between", value1, value2, "userEmal");
            return (Criteria) this;
        }

        public Criteria andUserEmalNotBetween(String value1, String value2) {
            addCriterion("user_emal not between", value1, value2, "userEmal");
            return (Criteria) this;
        }

        public Criteria andUserDetailIsNull() {
            addCriterion("user_detail is null");
            return (Criteria) this;
        }

        public Criteria andUserDetailIsNotNull() {
            addCriterion("user_detail is not null");
            return (Criteria) this;
        }

        public Criteria andUserDetailEqualTo(String value) {
            addCriterion("user_detail =", value, "userDetail");
            return (Criteria) this;
        }

        public Criteria andUserDetailNotEqualTo(String value) {
            addCriterion("user_detail <>", value, "userDetail");
            return (Criteria) this;
        }

        public Criteria andUserDetailGreaterThan(String value) {
            addCriterion("user_detail >", value, "userDetail");
            return (Criteria) this;
        }

        public Criteria andUserDetailGreaterThanOrEqualTo(String value) {
            addCriterion("user_detail >=", value, "userDetail");
            return (Criteria) this;
        }

        public Criteria andUserDetailLessThan(String value) {
            addCriterion("user_detail <", value, "userDetail");
            return (Criteria) this;
        }

        public Criteria andUserDetailLessThanOrEqualTo(String value) {
            addCriterion("user_detail <=", value, "userDetail");
            return (Criteria) this;
        }

        public Criteria andUserDetailLike(String value) {
            addCriterion("user_detail like", value, "userDetail");
            return (Criteria) this;
        }

        public Criteria andUserDetailNotLike(String value) {
            addCriterion("user_detail not like", value, "userDetail");
            return (Criteria) this;
        }

        public Criteria andUserDetailIn(List<String> values) {
            addCriterion("user_detail in", values, "userDetail");
            return (Criteria) this;
        }

        public Criteria andUserDetailNotIn(List<String> values) {
            addCriterion("user_detail not in", values, "userDetail");
            return (Criteria) this;
        }

        public Criteria andUserDetailBetween(String value1, String value2) {
            addCriterion("user_detail between", value1, value2, "userDetail");
            return (Criteria) this;
        }

        public Criteria andUserDetailNotBetween(String value1, String value2) {
            addCriterion("user_detail not between", value1, value2, "userDetail");
            return (Criteria) this;
        }

        public Criteria andUserHeadPicIsNull() {
            addCriterion("user_head_pic is null");
            return (Criteria) this;
        }

        public Criteria andUserHeadPicIsNotNull() {
            addCriterion("user_head_pic is not null");
            return (Criteria) this;
        }

        public Criteria andUserHeadPicEqualTo(String value) {
            addCriterion("user_head_pic =", value, "userHeadPic");
            return (Criteria) this;
        }

        public Criteria andUserHeadPicNotEqualTo(String value) {
            addCriterion("user_head_pic <>", value, "userHeadPic");
            return (Criteria) this;
        }

        public Criteria andUserHeadPicGreaterThan(String value) {
            addCriterion("user_head_pic >", value, "userHeadPic");
            return (Criteria) this;
        }

        public Criteria andUserHeadPicGreaterThanOrEqualTo(String value) {
            addCriterion("user_head_pic >=", value, "userHeadPic");
            return (Criteria) this;
        }

        public Criteria andUserHeadPicLessThan(String value) {
            addCriterion("user_head_pic <", value, "userHeadPic");
            return (Criteria) this;
        }

        public Criteria andUserHeadPicLessThanOrEqualTo(String value) {
            addCriterion("user_head_pic <=", value, "userHeadPic");
            return (Criteria) this;
        }

        public Criteria andUserHeadPicLike(String value) {
            addCriterion("user_head_pic like", value, "userHeadPic");
            return (Criteria) this;
        }

        public Criteria andUserHeadPicNotLike(String value) {
            addCriterion("user_head_pic not like", value, "userHeadPic");
            return (Criteria) this;
        }

        public Criteria andUserHeadPicIn(List<String> values) {
            addCriterion("user_head_pic in", values, "userHeadPic");
            return (Criteria) this;
        }

        public Criteria andUserHeadPicNotIn(List<String> values) {
            addCriterion("user_head_pic not in", values, "userHeadPic");
            return (Criteria) this;
        }

        public Criteria andUserHeadPicBetween(String value1, String value2) {
            addCriterion("user_head_pic between", value1, value2, "userHeadPic");
            return (Criteria) this;
        }

        public Criteria andUserHeadPicNotBetween(String value1, String value2) {
            addCriterion("user_head_pic not between", value1, value2, "userHeadPic");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeIsNull() {
            addCriterion("user_create_time is null");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeIsNotNull() {
            addCriterion("user_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeEqualTo(Date value) {
            addCriterion("user_create_time =", value, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeNotEqualTo(Date value) {
            addCriterion("user_create_time <>", value, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeGreaterThan(Date value) {
            addCriterion("user_create_time >", value, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("user_create_time >=", value, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeLessThan(Date value) {
            addCriterion("user_create_time <", value, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("user_create_time <=", value, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeIn(List<Date> values) {
            addCriterion("user_create_time in", values, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeNotIn(List<Date> values) {
            addCriterion("user_create_time not in", values, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeBetween(Date value1, Date value2) {
            addCriterion("user_create_time between", value1, value2, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("user_create_time not between", value1, value2, "userCreateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}