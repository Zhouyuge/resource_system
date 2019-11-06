package com.bishe.main.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EtileCategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EtileCategoryExample() {
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

        public Criteria andEtileCategoryIdIsNull() {
            addCriterion("etile_category_id is null");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryIdIsNotNull() {
            addCriterion("etile_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryIdEqualTo(Integer value) {
            addCriterion("etile_category_id =", value, "etileCategoryId");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryIdNotEqualTo(Integer value) {
            addCriterion("etile_category_id <>", value, "etileCategoryId");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryIdGreaterThan(Integer value) {
            addCriterion("etile_category_id >", value, "etileCategoryId");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("etile_category_id >=", value, "etileCategoryId");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryIdLessThan(Integer value) {
            addCriterion("etile_category_id <", value, "etileCategoryId");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("etile_category_id <=", value, "etileCategoryId");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryIdIn(List<Integer> values) {
            addCriterion("etile_category_id in", values, "etileCategoryId");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryIdNotIn(List<Integer> values) {
            addCriterion("etile_category_id not in", values, "etileCategoryId");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("etile_category_id between", value1, value2, "etileCategoryId");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("etile_category_id not between", value1, value2, "etileCategoryId");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryNameIsNull() {
            addCriterion("etile_category_name is null");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryNameIsNotNull() {
            addCriterion("etile_category_name is not null");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryNameEqualTo(String value) {
            addCriterion("etile_category_name =", value, "etileCategoryName");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryNameNotEqualTo(String value) {
            addCriterion("etile_category_name <>", value, "etileCategoryName");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryNameGreaterThan(String value) {
            addCriterion("etile_category_name >", value, "etileCategoryName");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("etile_category_name >=", value, "etileCategoryName");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryNameLessThan(String value) {
            addCriterion("etile_category_name <", value, "etileCategoryName");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("etile_category_name <=", value, "etileCategoryName");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryNameLike(String value) {
            addCriterion("etile_category_name like", value, "etileCategoryName");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryNameNotLike(String value) {
            addCriterion("etile_category_name not like", value, "etileCategoryName");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryNameIn(List<String> values) {
            addCriterion("etile_category_name in", values, "etileCategoryName");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryNameNotIn(List<String> values) {
            addCriterion("etile_category_name not in", values, "etileCategoryName");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryNameBetween(String value1, String value2) {
            addCriterion("etile_category_name between", value1, value2, "etileCategoryName");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryNameNotBetween(String value1, String value2) {
            addCriterion("etile_category_name not between", value1, value2, "etileCategoryName");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryNumIsNull() {
            addCriterion("etile_category_num is null");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryNumIsNotNull() {
            addCriterion("etile_category_num is not null");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryNumEqualTo(Integer value) {
            addCriterion("etile_category_num =", value, "etileCategoryNum");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryNumNotEqualTo(Integer value) {
            addCriterion("etile_category_num <>", value, "etileCategoryNum");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryNumGreaterThan(Integer value) {
            addCriterion("etile_category_num >", value, "etileCategoryNum");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("etile_category_num >=", value, "etileCategoryNum");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryNumLessThan(Integer value) {
            addCriterion("etile_category_num <", value, "etileCategoryNum");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryNumLessThanOrEqualTo(Integer value) {
            addCriterion("etile_category_num <=", value, "etileCategoryNum");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryNumIn(List<Integer> values) {
            addCriterion("etile_category_num in", values, "etileCategoryNum");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryNumNotIn(List<Integer> values) {
            addCriterion("etile_category_num not in", values, "etileCategoryNum");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryNumBetween(Integer value1, Integer value2) {
            addCriterion("etile_category_num between", value1, value2, "etileCategoryNum");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryNumNotBetween(Integer value1, Integer value2) {
            addCriterion("etile_category_num not between", value1, value2, "etileCategoryNum");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryPhotoIsNull() {
            addCriterion("etile_category_photo is null");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryPhotoIsNotNull() {
            addCriterion("etile_category_photo is not null");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryPhotoEqualTo(String value) {
            addCriterion("etile_category_photo =", value, "etileCategoryPhoto");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryPhotoNotEqualTo(String value) {
            addCriterion("etile_category_photo <>", value, "etileCategoryPhoto");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryPhotoGreaterThan(String value) {
            addCriterion("etile_category_photo >", value, "etileCategoryPhoto");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("etile_category_photo >=", value, "etileCategoryPhoto");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryPhotoLessThan(String value) {
            addCriterion("etile_category_photo <", value, "etileCategoryPhoto");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryPhotoLessThanOrEqualTo(String value) {
            addCriterion("etile_category_photo <=", value, "etileCategoryPhoto");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryPhotoLike(String value) {
            addCriterion("etile_category_photo like", value, "etileCategoryPhoto");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryPhotoNotLike(String value) {
            addCriterion("etile_category_photo not like", value, "etileCategoryPhoto");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryPhotoIn(List<String> values) {
            addCriterion("etile_category_photo in", values, "etileCategoryPhoto");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryPhotoNotIn(List<String> values) {
            addCriterion("etile_category_photo not in", values, "etileCategoryPhoto");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryPhotoBetween(String value1, String value2) {
            addCriterion("etile_category_photo between", value1, value2, "etileCategoryPhoto");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryPhotoNotBetween(String value1, String value2) {
            addCriterion("etile_category_photo not between", value1, value2, "etileCategoryPhoto");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryCreateTimeIsNull() {
            addCriterion("etile_category_create_time is null");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryCreateTimeIsNotNull() {
            addCriterion("etile_category_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryCreateTimeEqualTo(Date value) {
            addCriterion("etile_category_create_time =", value, "etileCategoryCreateTime");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryCreateTimeNotEqualTo(Date value) {
            addCriterion("etile_category_create_time <>", value, "etileCategoryCreateTime");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryCreateTimeGreaterThan(Date value) {
            addCriterion("etile_category_create_time >", value, "etileCategoryCreateTime");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("etile_category_create_time >=", value, "etileCategoryCreateTime");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryCreateTimeLessThan(Date value) {
            addCriterion("etile_category_create_time <", value, "etileCategoryCreateTime");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("etile_category_create_time <=", value, "etileCategoryCreateTime");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryCreateTimeIn(List<Date> values) {
            addCriterion("etile_category_create_time in", values, "etileCategoryCreateTime");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryCreateTimeNotIn(List<Date> values) {
            addCriterion("etile_category_create_time not in", values, "etileCategoryCreateTime");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryCreateTimeBetween(Date value1, Date value2) {
            addCriterion("etile_category_create_time between", value1, value2, "etileCategoryCreateTime");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("etile_category_create_time not between", value1, value2, "etileCategoryCreateTime");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryEditTimeIsNull() {
            addCriterion("etile_category_edit_time is null");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryEditTimeIsNotNull() {
            addCriterion("etile_category_edit_time is not null");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryEditTimeEqualTo(Date value) {
            addCriterion("etile_category_edit_time =", value, "etileCategoryEditTime");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryEditTimeNotEqualTo(Date value) {
            addCriterion("etile_category_edit_time <>", value, "etileCategoryEditTime");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryEditTimeGreaterThan(Date value) {
            addCriterion("etile_category_edit_time >", value, "etileCategoryEditTime");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryEditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("etile_category_edit_time >=", value, "etileCategoryEditTime");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryEditTimeLessThan(Date value) {
            addCriterion("etile_category_edit_time <", value, "etileCategoryEditTime");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryEditTimeLessThanOrEqualTo(Date value) {
            addCriterion("etile_category_edit_time <=", value, "etileCategoryEditTime");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryEditTimeIn(List<Date> values) {
            addCriterion("etile_category_edit_time in", values, "etileCategoryEditTime");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryEditTimeNotIn(List<Date> values) {
            addCriterion("etile_category_edit_time not in", values, "etileCategoryEditTime");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryEditTimeBetween(Date value1, Date value2) {
            addCriterion("etile_category_edit_time between", value1, value2, "etileCategoryEditTime");
            return (Criteria) this;
        }

        public Criteria andEtileCategoryEditTimeNotBetween(Date value1, Date value2) {
            addCriterion("etile_category_edit_time not between", value1, value2, "etileCategoryEditTime");
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