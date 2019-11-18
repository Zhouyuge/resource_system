package com.bishe.main.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class STypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public STypeExample() {
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

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeFIdIsNull() {
            addCriterion("type_f_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeFIdIsNotNull() {
            addCriterion("type_f_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeFIdEqualTo(Integer value) {
            addCriterion("type_f_id =", value, "typeFId");
            return (Criteria) this;
        }

        public Criteria andTypeFIdNotEqualTo(Integer value) {
            addCriterion("type_f_id <>", value, "typeFId");
            return (Criteria) this;
        }

        public Criteria andTypeFIdGreaterThan(Integer value) {
            addCriterion("type_f_id >", value, "typeFId");
            return (Criteria) this;
        }

        public Criteria andTypeFIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_f_id >=", value, "typeFId");
            return (Criteria) this;
        }

        public Criteria andTypeFIdLessThan(Integer value) {
            addCriterion("type_f_id <", value, "typeFId");
            return (Criteria) this;
        }

        public Criteria andTypeFIdLessThanOrEqualTo(Integer value) {
            addCriterion("type_f_id <=", value, "typeFId");
            return (Criteria) this;
        }

        public Criteria andTypeFIdIn(List<Integer> values) {
            addCriterion("type_f_id in", values, "typeFId");
            return (Criteria) this;
        }

        public Criteria andTypeFIdNotIn(List<Integer> values) {
            addCriterion("type_f_id not in", values, "typeFId");
            return (Criteria) this;
        }

        public Criteria andTypeFIdBetween(Integer value1, Integer value2) {
            addCriterion("type_f_id between", value1, value2, "typeFId");
            return (Criteria) this;
        }

        public Criteria andTypeFIdNotBetween(Integer value1, Integer value2) {
            addCriterion("type_f_id not between", value1, value2, "typeFId");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNull() {
            addCriterion("type_name is null");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNotNull() {
            addCriterion("type_name is not null");
            return (Criteria) this;
        }

        public Criteria andTypeNameEqualTo(String value) {
            addCriterion("type_name =", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotEqualTo(String value) {
            addCriterion("type_name <>", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThan(String value) {
            addCriterion("type_name >", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("type_name >=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThan(String value) {
            addCriterion("type_name <", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThanOrEqualTo(String value) {
            addCriterion("type_name <=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLike(String value) {
            addCriterion("type_name like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotLike(String value) {
            addCriterion("type_name not like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameIn(List<String> values) {
            addCriterion("type_name in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotIn(List<String> values) {
            addCriterion("type_name not in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameBetween(String value1, String value2) {
            addCriterion("type_name between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotBetween(String value1, String value2) {
            addCriterion("type_name not between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeCountIsNull() {
            addCriterion("type_count is null");
            return (Criteria) this;
        }

        public Criteria andTypeCountIsNotNull() {
            addCriterion("type_count is not null");
            return (Criteria) this;
        }

        public Criteria andTypeCountEqualTo(String value) {
            addCriterion("type_count =", value, "typeCount");
            return (Criteria) this;
        }

        public Criteria andTypeCountNotEqualTo(String value) {
            addCriterion("type_count <>", value, "typeCount");
            return (Criteria) this;
        }

        public Criteria andTypeCountGreaterThan(String value) {
            addCriterion("type_count >", value, "typeCount");
            return (Criteria) this;
        }

        public Criteria andTypeCountGreaterThanOrEqualTo(String value) {
            addCriterion("type_count >=", value, "typeCount");
            return (Criteria) this;
        }

        public Criteria andTypeCountLessThan(String value) {
            addCriterion("type_count <", value, "typeCount");
            return (Criteria) this;
        }

        public Criteria andTypeCountLessThanOrEqualTo(String value) {
            addCriterion("type_count <=", value, "typeCount");
            return (Criteria) this;
        }

        public Criteria andTypeCountLike(String value) {
            addCriterion("type_count like", value, "typeCount");
            return (Criteria) this;
        }

        public Criteria andTypeCountNotLike(String value) {
            addCriterion("type_count not like", value, "typeCount");
            return (Criteria) this;
        }

        public Criteria andTypeCountIn(List<String> values) {
            addCriterion("type_count in", values, "typeCount");
            return (Criteria) this;
        }

        public Criteria andTypeCountNotIn(List<String> values) {
            addCriterion("type_count not in", values, "typeCount");
            return (Criteria) this;
        }

        public Criteria andTypeCountBetween(String value1, String value2) {
            addCriterion("type_count between", value1, value2, "typeCount");
            return (Criteria) this;
        }

        public Criteria andTypeCountNotBetween(String value1, String value2) {
            addCriterion("type_count not between", value1, value2, "typeCount");
            return (Criteria) this;
        }

        public Criteria andTypeCreateTimeIsNull() {
            addCriterion("type_create_time is null");
            return (Criteria) this;
        }

        public Criteria andTypeCreateTimeIsNotNull() {
            addCriterion("type_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andTypeCreateTimeEqualTo(Date value) {
            addCriterion("type_create_time =", value, "typeCreateTime");
            return (Criteria) this;
        }

        public Criteria andTypeCreateTimeNotEqualTo(Date value) {
            addCriterion("type_create_time <>", value, "typeCreateTime");
            return (Criteria) this;
        }

        public Criteria andTypeCreateTimeGreaterThan(Date value) {
            addCriterion("type_create_time >", value, "typeCreateTime");
            return (Criteria) this;
        }

        public Criteria andTypeCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("type_create_time >=", value, "typeCreateTime");
            return (Criteria) this;
        }

        public Criteria andTypeCreateTimeLessThan(Date value) {
            addCriterion("type_create_time <", value, "typeCreateTime");
            return (Criteria) this;
        }

        public Criteria andTypeCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("type_create_time <=", value, "typeCreateTime");
            return (Criteria) this;
        }

        public Criteria andTypeCreateTimeIn(List<Date> values) {
            addCriterion("type_create_time in", values, "typeCreateTime");
            return (Criteria) this;
        }

        public Criteria andTypeCreateTimeNotIn(List<Date> values) {
            addCriterion("type_create_time not in", values, "typeCreateTime");
            return (Criteria) this;
        }

        public Criteria andTypeCreateTimeBetween(Date value1, Date value2) {
            addCriterion("type_create_time between", value1, value2, "typeCreateTime");
            return (Criteria) this;
        }

        public Criteria andTypeCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("type_create_time not between", value1, value2, "typeCreateTime");
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