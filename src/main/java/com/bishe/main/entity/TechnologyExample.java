package com.bishe.main.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TechnologyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TechnologyExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTechnologyNameIsNull() {
            addCriterion("technology_name is null");
            return (Criteria) this;
        }

        public Criteria andTechnologyNameIsNotNull() {
            addCriterion("technology_name is not null");
            return (Criteria) this;
        }

        public Criteria andTechnologyNameEqualTo(String value) {
            addCriterion("technology_name =", value, "technologyName");
            return (Criteria) this;
        }

        public Criteria andTechnologyNameNotEqualTo(String value) {
            addCriterion("technology_name <>", value, "technologyName");
            return (Criteria) this;
        }

        public Criteria andTechnologyNameGreaterThan(String value) {
            addCriterion("technology_name >", value, "technologyName");
            return (Criteria) this;
        }

        public Criteria andTechnologyNameGreaterThanOrEqualTo(String value) {
            addCriterion("technology_name >=", value, "technologyName");
            return (Criteria) this;
        }

        public Criteria andTechnologyNameLessThan(String value) {
            addCriterion("technology_name <", value, "technologyName");
            return (Criteria) this;
        }

        public Criteria andTechnologyNameLessThanOrEqualTo(String value) {
            addCriterion("technology_name <=", value, "technologyName");
            return (Criteria) this;
        }

        public Criteria andTechnologyNameLike(String value) {
            addCriterion("technology_name like", value, "technologyName");
            return (Criteria) this;
        }

        public Criteria andTechnologyNameNotLike(String value) {
            addCriterion("technology_name not like", value, "technologyName");
            return (Criteria) this;
        }

        public Criteria andTechnologyNameIn(List<String> values) {
            addCriterion("technology_name in", values, "technologyName");
            return (Criteria) this;
        }

        public Criteria andTechnologyNameNotIn(List<String> values) {
            addCriterion("technology_name not in", values, "technologyName");
            return (Criteria) this;
        }

        public Criteria andTechnologyNameBetween(String value1, String value2) {
            addCriterion("technology_name between", value1, value2, "technologyName");
            return (Criteria) this;
        }

        public Criteria andTechnologyNameNotBetween(String value1, String value2) {
            addCriterion("technology_name not between", value1, value2, "technologyName");
            return (Criteria) this;
        }

        public Criteria andTechnologyNumIsNull() {
            addCriterion("technology_num is null");
            return (Criteria) this;
        }

        public Criteria andTechnologyNumIsNotNull() {
            addCriterion("technology_num is not null");
            return (Criteria) this;
        }

        public Criteria andTechnologyNumEqualTo(Integer value) {
            addCriterion("technology_num =", value, "technologyNum");
            return (Criteria) this;
        }

        public Criteria andTechnologyNumNotEqualTo(Integer value) {
            addCriterion("technology_num <>", value, "technologyNum");
            return (Criteria) this;
        }

        public Criteria andTechnologyNumGreaterThan(Integer value) {
            addCriterion("technology_num >", value, "technologyNum");
            return (Criteria) this;
        }

        public Criteria andTechnologyNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("technology_num >=", value, "technologyNum");
            return (Criteria) this;
        }

        public Criteria andTechnologyNumLessThan(Integer value) {
            addCriterion("technology_num <", value, "technologyNum");
            return (Criteria) this;
        }

        public Criteria andTechnologyNumLessThanOrEqualTo(Integer value) {
            addCriterion("technology_num <=", value, "technologyNum");
            return (Criteria) this;
        }

        public Criteria andTechnologyNumIn(List<Integer> values) {
            addCriterion("technology_num in", values, "technologyNum");
            return (Criteria) this;
        }

        public Criteria andTechnologyNumNotIn(List<Integer> values) {
            addCriterion("technology_num not in", values, "technologyNum");
            return (Criteria) this;
        }

        public Criteria andTechnologyNumBetween(Integer value1, Integer value2) {
            addCriterion("technology_num between", value1, value2, "technologyNum");
            return (Criteria) this;
        }

        public Criteria andTechnologyNumNotBetween(Integer value1, Integer value2) {
            addCriterion("technology_num not between", value1, value2, "technologyNum");
            return (Criteria) this;
        }

        public Criteria andTechnologyIntroductionIsNull() {
            addCriterion("technology_introduction is null");
            return (Criteria) this;
        }

        public Criteria andTechnologyIntroductionIsNotNull() {
            addCriterion("technology_introduction is not null");
            return (Criteria) this;
        }

        public Criteria andTechnologyIntroductionEqualTo(String value) {
            addCriterion("technology_introduction =", value, "technologyIntroduction");
            return (Criteria) this;
        }

        public Criteria andTechnologyIntroductionNotEqualTo(String value) {
            addCriterion("technology_introduction <>", value, "technologyIntroduction");
            return (Criteria) this;
        }

        public Criteria andTechnologyIntroductionGreaterThan(String value) {
            addCriterion("technology_introduction >", value, "technologyIntroduction");
            return (Criteria) this;
        }

        public Criteria andTechnologyIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("technology_introduction >=", value, "technologyIntroduction");
            return (Criteria) this;
        }

        public Criteria andTechnologyIntroductionLessThan(String value) {
            addCriterion("technology_introduction <", value, "technologyIntroduction");
            return (Criteria) this;
        }

        public Criteria andTechnologyIntroductionLessThanOrEqualTo(String value) {
            addCriterion("technology_introduction <=", value, "technologyIntroduction");
            return (Criteria) this;
        }

        public Criteria andTechnologyIntroductionLike(String value) {
            addCriterion("technology_introduction like", value, "technologyIntroduction");
            return (Criteria) this;
        }

        public Criteria andTechnologyIntroductionNotLike(String value) {
            addCriterion("technology_introduction not like", value, "technologyIntroduction");
            return (Criteria) this;
        }

        public Criteria andTechnologyIntroductionIn(List<String> values) {
            addCriterion("technology_introduction in", values, "technologyIntroduction");
            return (Criteria) this;
        }

        public Criteria andTechnologyIntroductionNotIn(List<String> values) {
            addCriterion("technology_introduction not in", values, "technologyIntroduction");
            return (Criteria) this;
        }

        public Criteria andTechnologyIntroductionBetween(String value1, String value2) {
            addCriterion("technology_introduction between", value1, value2, "technologyIntroduction");
            return (Criteria) this;
        }

        public Criteria andTechnologyIntroductionNotBetween(String value1, String value2) {
            addCriterion("technology_introduction not between", value1, value2, "technologyIntroduction");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeIsNull() {
            addCriterion("edit_time is null");
            return (Criteria) this;
        }

        public Criteria andEditTimeIsNotNull() {
            addCriterion("edit_time is not null");
            return (Criteria) this;
        }

        public Criteria andEditTimeEqualTo(Date value) {
            addCriterion("edit_time =", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeNotEqualTo(Date value) {
            addCriterion("edit_time <>", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeGreaterThan(Date value) {
            addCriterion("edit_time >", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("edit_time >=", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeLessThan(Date value) {
            addCriterion("edit_time <", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeLessThanOrEqualTo(Date value) {
            addCriterion("edit_time <=", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeIn(List<Date> values) {
            addCriterion("edit_time in", values, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeNotIn(List<Date> values) {
            addCriterion("edit_time not in", values, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeBetween(Date value1, Date value2) {
            addCriterion("edit_time between", value1, value2, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeNotBetween(Date value1, Date value2) {
            addCriterion("edit_time not between", value1, value2, "editTime");
            return (Criteria) this;
        }

        public Criteria andTechnologyPicIsNull() {
            addCriterion("technology_pic is null");
            return (Criteria) this;
        }

        public Criteria andTechnologyPicIsNotNull() {
            addCriterion("technology_pic is not null");
            return (Criteria) this;
        }

        public Criteria andTechnologyPicEqualTo(String value) {
            addCriterion("technology_pic =", value, "technologyPic");
            return (Criteria) this;
        }

        public Criteria andTechnologyPicNotEqualTo(String value) {
            addCriterion("technology_pic <>", value, "technologyPic");
            return (Criteria) this;
        }

        public Criteria andTechnologyPicGreaterThan(String value) {
            addCriterion("technology_pic >", value, "technologyPic");
            return (Criteria) this;
        }

        public Criteria andTechnologyPicGreaterThanOrEqualTo(String value) {
            addCriterion("technology_pic >=", value, "technologyPic");
            return (Criteria) this;
        }

        public Criteria andTechnologyPicLessThan(String value) {
            addCriterion("technology_pic <", value, "technologyPic");
            return (Criteria) this;
        }

        public Criteria andTechnologyPicLessThanOrEqualTo(String value) {
            addCriterion("technology_pic <=", value, "technologyPic");
            return (Criteria) this;
        }

        public Criteria andTechnologyPicLike(String value) {
            addCriterion("technology_pic like", value, "technologyPic");
            return (Criteria) this;
        }

        public Criteria andTechnologyPicNotLike(String value) {
            addCriterion("technology_pic not like", value, "technologyPic");
            return (Criteria) this;
        }

        public Criteria andTechnologyPicIn(List<String> values) {
            addCriterion("technology_pic in", values, "technologyPic");
            return (Criteria) this;
        }

        public Criteria andTechnologyPicNotIn(List<String> values) {
            addCriterion("technology_pic not in", values, "technologyPic");
            return (Criteria) this;
        }

        public Criteria andTechnologyPicBetween(String value1, String value2) {
            addCriterion("technology_pic between", value1, value2, "technologyPic");
            return (Criteria) this;
        }

        public Criteria andTechnologyPicNotBetween(String value1, String value2) {
            addCriterion("technology_pic not between", value1, value2, "technologyPic");
            return (Criteria) this;
        }

        public Criteria andTechnologyTypeIsNull() {
            addCriterion("technology_type is null");
            return (Criteria) this;
        }

        public Criteria andTechnologyTypeIsNotNull() {
            addCriterion("technology_type is not null");
            return (Criteria) this;
        }

        public Criteria andTechnologyTypeEqualTo(Integer value) {
            addCriterion("technology_type =", value, "technologyType");
            return (Criteria) this;
        }

        public Criteria andTechnologyTypeNotEqualTo(Integer value) {
            addCriterion("technology_type <>", value, "technologyType");
            return (Criteria) this;
        }

        public Criteria andTechnologyTypeGreaterThan(Integer value) {
            addCriterion("technology_type >", value, "technologyType");
            return (Criteria) this;
        }

        public Criteria andTechnologyTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("technology_type >=", value, "technologyType");
            return (Criteria) this;
        }

        public Criteria andTechnologyTypeLessThan(Integer value) {
            addCriterion("technology_type <", value, "technologyType");
            return (Criteria) this;
        }

        public Criteria andTechnologyTypeLessThanOrEqualTo(Integer value) {
            addCriterion("technology_type <=", value, "technologyType");
            return (Criteria) this;
        }

        public Criteria andTechnologyTypeIn(List<Integer> values) {
            addCriterion("technology_type in", values, "technologyType");
            return (Criteria) this;
        }

        public Criteria andTechnologyTypeNotIn(List<Integer> values) {
            addCriterion("technology_type not in", values, "technologyType");
            return (Criteria) this;
        }

        public Criteria andTechnologyTypeBetween(Integer value1, Integer value2) {
            addCriterion("technology_type between", value1, value2, "technologyType");
            return (Criteria) this;
        }

        public Criteria andTechnologyTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("technology_type not between", value1, value2, "technologyType");
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