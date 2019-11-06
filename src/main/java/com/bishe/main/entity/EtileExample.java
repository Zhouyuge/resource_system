package com.bishe.main.entity;

import java.util.ArrayList;
import java.util.List;

public class EtileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EtileExample() {
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

        public Criteria andEtileIdIsNull() {
            addCriterion("etile_id is null");
            return (Criteria) this;
        }

        public Criteria andEtileIdIsNotNull() {
            addCriterion("etile_id is not null");
            return (Criteria) this;
        }

        public Criteria andEtileIdEqualTo(Integer value) {
            addCriterion("etile_id =", value, "etileId");
            return (Criteria) this;
        }

        public Criteria andEtileIdNotEqualTo(Integer value) {
            addCriterion("etile_id <>", value, "etileId");
            return (Criteria) this;
        }

        public Criteria andEtileIdGreaterThan(Integer value) {
            addCriterion("etile_id >", value, "etileId");
            return (Criteria) this;
        }

        public Criteria andEtileIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("etile_id >=", value, "etileId");
            return (Criteria) this;
        }

        public Criteria andEtileIdLessThan(Integer value) {
            addCriterion("etile_id <", value, "etileId");
            return (Criteria) this;
        }

        public Criteria andEtileIdLessThanOrEqualTo(Integer value) {
            addCriterion("etile_id <=", value, "etileId");
            return (Criteria) this;
        }

        public Criteria andEtileIdIn(List<Integer> values) {
            addCriterion("etile_id in", values, "etileId");
            return (Criteria) this;
        }

        public Criteria andEtileIdNotIn(List<Integer> values) {
            addCriterion("etile_id not in", values, "etileId");
            return (Criteria) this;
        }

        public Criteria andEtileIdBetween(Integer value1, Integer value2) {
            addCriterion("etile_id between", value1, value2, "etileId");
            return (Criteria) this;
        }

        public Criteria andEtileIdNotBetween(Integer value1, Integer value2) {
            addCriterion("etile_id not between", value1, value2, "etileId");
            return (Criteria) this;
        }

        public Criteria andEtileNameIsNull() {
            addCriterion("etile_name is null");
            return (Criteria) this;
        }

        public Criteria andEtileNameIsNotNull() {
            addCriterion("etile_name is not null");
            return (Criteria) this;
        }

        public Criteria andEtileNameEqualTo(String value) {
            addCriterion("etile_name =", value, "etileName");
            return (Criteria) this;
        }

        public Criteria andEtileNameNotEqualTo(String value) {
            addCriterion("etile_name <>", value, "etileName");
            return (Criteria) this;
        }

        public Criteria andEtileNameGreaterThan(String value) {
            addCriterion("etile_name >", value, "etileName");
            return (Criteria) this;
        }

        public Criteria andEtileNameGreaterThanOrEqualTo(String value) {
            addCriterion("etile_name >=", value, "etileName");
            return (Criteria) this;
        }

        public Criteria andEtileNameLessThan(String value) {
            addCriterion("etile_name <", value, "etileName");
            return (Criteria) this;
        }

        public Criteria andEtileNameLessThanOrEqualTo(String value) {
            addCriterion("etile_name <=", value, "etileName");
            return (Criteria) this;
        }

        public Criteria andEtileNameLike(String value) {
            addCriterion("etile_name like", value, "etileName");
            return (Criteria) this;
        }

        public Criteria andEtileNameNotLike(String value) {
            addCriterion("etile_name not like", value, "etileName");
            return (Criteria) this;
        }

        public Criteria andEtileNameIn(List<String> values) {
            addCriterion("etile_name in", values, "etileName");
            return (Criteria) this;
        }

        public Criteria andEtileNameNotIn(List<String> values) {
            addCriterion("etile_name not in", values, "etileName");
            return (Criteria) this;
        }

        public Criteria andEtileNameBetween(String value1, String value2) {
            addCriterion("etile_name between", value1, value2, "etileName");
            return (Criteria) this;
        }

        public Criteria andEtileNameNotBetween(String value1, String value2) {
            addCriterion("etile_name not between", value1, value2, "etileName");
            return (Criteria) this;
        }

        public Criteria andEtitleQuestionIsNull() {
            addCriterion("etitle_question is null");
            return (Criteria) this;
        }

        public Criteria andEtitleQuestionIsNotNull() {
            addCriterion("etitle_question is not null");
            return (Criteria) this;
        }

        public Criteria andEtitleQuestionEqualTo(String value) {
            addCriterion("etitle_question =", value, "etitleQuestion");
            return (Criteria) this;
        }

        public Criteria andEtitleQuestionNotEqualTo(String value) {
            addCriterion("etitle_question <>", value, "etitleQuestion");
            return (Criteria) this;
        }

        public Criteria andEtitleQuestionGreaterThan(String value) {
            addCriterion("etitle_question >", value, "etitleQuestion");
            return (Criteria) this;
        }

        public Criteria andEtitleQuestionGreaterThanOrEqualTo(String value) {
            addCriterion("etitle_question >=", value, "etitleQuestion");
            return (Criteria) this;
        }

        public Criteria andEtitleQuestionLessThan(String value) {
            addCriterion("etitle_question <", value, "etitleQuestion");
            return (Criteria) this;
        }

        public Criteria andEtitleQuestionLessThanOrEqualTo(String value) {
            addCriterion("etitle_question <=", value, "etitleQuestion");
            return (Criteria) this;
        }

        public Criteria andEtitleQuestionLike(String value) {
            addCriterion("etitle_question like", value, "etitleQuestion");
            return (Criteria) this;
        }

        public Criteria andEtitleQuestionNotLike(String value) {
            addCriterion("etitle_question not like", value, "etitleQuestion");
            return (Criteria) this;
        }

        public Criteria andEtitleQuestionIn(List<String> values) {
            addCriterion("etitle_question in", values, "etitleQuestion");
            return (Criteria) this;
        }

        public Criteria andEtitleQuestionNotIn(List<String> values) {
            addCriterion("etitle_question not in", values, "etitleQuestion");
            return (Criteria) this;
        }

        public Criteria andEtitleQuestionBetween(String value1, String value2) {
            addCriterion("etitle_question between", value1, value2, "etitleQuestion");
            return (Criteria) this;
        }

        public Criteria andEtitleQuestionNotBetween(String value1, String value2) {
            addCriterion("etitle_question not between", value1, value2, "etitleQuestion");
            return (Criteria) this;
        }

        public Criteria andEtilePointIsNull() {
            addCriterion("etile_point is null");
            return (Criteria) this;
        }

        public Criteria andEtilePointIsNotNull() {
            addCriterion("etile_point is not null");
            return (Criteria) this;
        }

        public Criteria andEtilePointEqualTo(String value) {
            addCriterion("etile_point =", value, "etilePoint");
            return (Criteria) this;
        }

        public Criteria andEtilePointNotEqualTo(String value) {
            addCriterion("etile_point <>", value, "etilePoint");
            return (Criteria) this;
        }

        public Criteria andEtilePointGreaterThan(String value) {
            addCriterion("etile_point >", value, "etilePoint");
            return (Criteria) this;
        }

        public Criteria andEtilePointGreaterThanOrEqualTo(String value) {
            addCriterion("etile_point >=", value, "etilePoint");
            return (Criteria) this;
        }

        public Criteria andEtilePointLessThan(String value) {
            addCriterion("etile_point <", value, "etilePoint");
            return (Criteria) this;
        }

        public Criteria andEtilePointLessThanOrEqualTo(String value) {
            addCriterion("etile_point <=", value, "etilePoint");
            return (Criteria) this;
        }

        public Criteria andEtilePointLike(String value) {
            addCriterion("etile_point like", value, "etilePoint");
            return (Criteria) this;
        }

        public Criteria andEtilePointNotLike(String value) {
            addCriterion("etile_point not like", value, "etilePoint");
            return (Criteria) this;
        }

        public Criteria andEtilePointIn(List<String> values) {
            addCriterion("etile_point in", values, "etilePoint");
            return (Criteria) this;
        }

        public Criteria andEtilePointNotIn(List<String> values) {
            addCriterion("etile_point not in", values, "etilePoint");
            return (Criteria) this;
        }

        public Criteria andEtilePointBetween(String value1, String value2) {
            addCriterion("etile_point between", value1, value2, "etilePoint");
            return (Criteria) this;
        }

        public Criteria andEtilePointNotBetween(String value1, String value2) {
            addCriterion("etile_point not between", value1, value2, "etilePoint");
            return (Criteria) this;
        }

        public Criteria andEtileTypeIsNull() {
            addCriterion("etile_type is null");
            return (Criteria) this;
        }

        public Criteria andEtileTypeIsNotNull() {
            addCriterion("etile_type is not null");
            return (Criteria) this;
        }

        public Criteria andEtileTypeEqualTo(String value) {
            addCriterion("etile_type =", value, "etileType");
            return (Criteria) this;
        }

        public Criteria andEtileTypeNotEqualTo(String value) {
            addCriterion("etile_type <>", value, "etileType");
            return (Criteria) this;
        }

        public Criteria andEtileTypeGreaterThan(String value) {
            addCriterion("etile_type >", value, "etileType");
            return (Criteria) this;
        }

        public Criteria andEtileTypeGreaterThanOrEqualTo(String value) {
            addCriterion("etile_type >=", value, "etileType");
            return (Criteria) this;
        }

        public Criteria andEtileTypeLessThan(String value) {
            addCriterion("etile_type <", value, "etileType");
            return (Criteria) this;
        }

        public Criteria andEtileTypeLessThanOrEqualTo(String value) {
            addCriterion("etile_type <=", value, "etileType");
            return (Criteria) this;
        }

        public Criteria andEtileTypeLike(String value) {
            addCriterion("etile_type like", value, "etileType");
            return (Criteria) this;
        }

        public Criteria andEtileTypeNotLike(String value) {
            addCriterion("etile_type not like", value, "etileType");
            return (Criteria) this;
        }

        public Criteria andEtileTypeIn(List<String> values) {
            addCriterion("etile_type in", values, "etileType");
            return (Criteria) this;
        }

        public Criteria andEtileTypeNotIn(List<String> values) {
            addCriterion("etile_type not in", values, "etileType");
            return (Criteria) this;
        }

        public Criteria andEtileTypeBetween(String value1, String value2) {
            addCriterion("etile_type between", value1, value2, "etileType");
            return (Criteria) this;
        }

        public Criteria andEtileTypeNotBetween(String value1, String value2) {
            addCriterion("etile_type not between", value1, value2, "etileType");
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