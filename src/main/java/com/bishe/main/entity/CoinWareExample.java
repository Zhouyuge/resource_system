package com.bishe.main.entity;

import java.util.ArrayList;
import java.util.List;

public class CoinWareExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CoinWareExample() {
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

        public Criteria andCoinWareIdIsNull() {
            addCriterion("coin_ware_id is null");
            return (Criteria) this;
        }

        public Criteria andCoinWareIdIsNotNull() {
            addCriterion("coin_ware_id is not null");
            return (Criteria) this;
        }

        public Criteria andCoinWareIdEqualTo(Integer value) {
            addCriterion("coin_ware_id =", value, "coinWareId");
            return (Criteria) this;
        }

        public Criteria andCoinWareIdNotEqualTo(Integer value) {
            addCriterion("coin_ware_id <>", value, "coinWareId");
            return (Criteria) this;
        }

        public Criteria andCoinWareIdGreaterThan(Integer value) {
            addCriterion("coin_ware_id >", value, "coinWareId");
            return (Criteria) this;
        }

        public Criteria andCoinWareIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("coin_ware_id >=", value, "coinWareId");
            return (Criteria) this;
        }

        public Criteria andCoinWareIdLessThan(Integer value) {
            addCriterion("coin_ware_id <", value, "coinWareId");
            return (Criteria) this;
        }

        public Criteria andCoinWareIdLessThanOrEqualTo(Integer value) {
            addCriterion("coin_ware_id <=", value, "coinWareId");
            return (Criteria) this;
        }

        public Criteria andCoinWareIdIn(List<Integer> values) {
            addCriterion("coin_ware_id in", values, "coinWareId");
            return (Criteria) this;
        }

        public Criteria andCoinWareIdNotIn(List<Integer> values) {
            addCriterion("coin_ware_id not in", values, "coinWareId");
            return (Criteria) this;
        }

        public Criteria andCoinWareIdBetween(Integer value1, Integer value2) {
            addCriterion("coin_ware_id between", value1, value2, "coinWareId");
            return (Criteria) this;
        }

        public Criteria andCoinWareIdNotBetween(Integer value1, Integer value2) {
            addCriterion("coin_ware_id not between", value1, value2, "coinWareId");
            return (Criteria) this;
        }

        public Criteria andCoinWareNameIsNull() {
            addCriterion("coin_ware_name is null");
            return (Criteria) this;
        }

        public Criteria andCoinWareNameIsNotNull() {
            addCriterion("coin_ware_name is not null");
            return (Criteria) this;
        }

        public Criteria andCoinWareNameEqualTo(String value) {
            addCriterion("coin_ware_name =", value, "coinWareName");
            return (Criteria) this;
        }

        public Criteria andCoinWareNameNotEqualTo(String value) {
            addCriterion("coin_ware_name <>", value, "coinWareName");
            return (Criteria) this;
        }

        public Criteria andCoinWareNameGreaterThan(String value) {
            addCriterion("coin_ware_name >", value, "coinWareName");
            return (Criteria) this;
        }

        public Criteria andCoinWareNameGreaterThanOrEqualTo(String value) {
            addCriterion("coin_ware_name >=", value, "coinWareName");
            return (Criteria) this;
        }

        public Criteria andCoinWareNameLessThan(String value) {
            addCriterion("coin_ware_name <", value, "coinWareName");
            return (Criteria) this;
        }

        public Criteria andCoinWareNameLessThanOrEqualTo(String value) {
            addCriterion("coin_ware_name <=", value, "coinWareName");
            return (Criteria) this;
        }

        public Criteria andCoinWareNameLike(String value) {
            addCriterion("coin_ware_name like", value, "coinWareName");
            return (Criteria) this;
        }

        public Criteria andCoinWareNameNotLike(String value) {
            addCriterion("coin_ware_name not like", value, "coinWareName");
            return (Criteria) this;
        }

        public Criteria andCoinWareNameIn(List<String> values) {
            addCriterion("coin_ware_name in", values, "coinWareName");
            return (Criteria) this;
        }

        public Criteria andCoinWareNameNotIn(List<String> values) {
            addCriterion("coin_ware_name not in", values, "coinWareName");
            return (Criteria) this;
        }

        public Criteria andCoinWareNameBetween(String value1, String value2) {
            addCriterion("coin_ware_name between", value1, value2, "coinWareName");
            return (Criteria) this;
        }

        public Criteria andCoinWareNameNotBetween(String value1, String value2) {
            addCriterion("coin_ware_name not between", value1, value2, "coinWareName");
            return (Criteria) this;
        }

        public Criteria andCoinWarePriceIsNull() {
            addCriterion("coin_ware_price is null");
            return (Criteria) this;
        }

        public Criteria andCoinWarePriceIsNotNull() {
            addCriterion("coin_ware_price is not null");
            return (Criteria) this;
        }

        public Criteria andCoinWarePriceEqualTo(Integer value) {
            addCriterion("coin_ware_price =", value, "coinWarePrice");
            return (Criteria) this;
        }

        public Criteria andCoinWarePriceNotEqualTo(Integer value) {
            addCriterion("coin_ware_price <>", value, "coinWarePrice");
            return (Criteria) this;
        }

        public Criteria andCoinWarePriceGreaterThan(Integer value) {
            addCriterion("coin_ware_price >", value, "coinWarePrice");
            return (Criteria) this;
        }

        public Criteria andCoinWarePriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("coin_ware_price >=", value, "coinWarePrice");
            return (Criteria) this;
        }

        public Criteria andCoinWarePriceLessThan(Integer value) {
            addCriterion("coin_ware_price <", value, "coinWarePrice");
            return (Criteria) this;
        }

        public Criteria andCoinWarePriceLessThanOrEqualTo(Integer value) {
            addCriterion("coin_ware_price <=", value, "coinWarePrice");
            return (Criteria) this;
        }

        public Criteria andCoinWarePriceIn(List<Integer> values) {
            addCriterion("coin_ware_price in", values, "coinWarePrice");
            return (Criteria) this;
        }

        public Criteria andCoinWarePriceNotIn(List<Integer> values) {
            addCriterion("coin_ware_price not in", values, "coinWarePrice");
            return (Criteria) this;
        }

        public Criteria andCoinWarePriceBetween(Integer value1, Integer value2) {
            addCriterion("coin_ware_price between", value1, value2, "coinWarePrice");
            return (Criteria) this;
        }

        public Criteria andCoinWarePriceNotBetween(Integer value1, Integer value2) {
            addCriterion("coin_ware_price not between", value1, value2, "coinWarePrice");
            return (Criteria) this;
        }

        public Criteria andCoinWareNumIsNull() {
            addCriterion("coin_ware_num is null");
            return (Criteria) this;
        }

        public Criteria andCoinWareNumIsNotNull() {
            addCriterion("coin_ware_num is not null");
            return (Criteria) this;
        }

        public Criteria andCoinWareNumEqualTo(Integer value) {
            addCriterion("coin_ware_num =", value, "coinWareNum");
            return (Criteria) this;
        }

        public Criteria andCoinWareNumNotEqualTo(Integer value) {
            addCriterion("coin_ware_num <>", value, "coinWareNum");
            return (Criteria) this;
        }

        public Criteria andCoinWareNumGreaterThan(Integer value) {
            addCriterion("coin_ware_num >", value, "coinWareNum");
            return (Criteria) this;
        }

        public Criteria andCoinWareNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("coin_ware_num >=", value, "coinWareNum");
            return (Criteria) this;
        }

        public Criteria andCoinWareNumLessThan(Integer value) {
            addCriterion("coin_ware_num <", value, "coinWareNum");
            return (Criteria) this;
        }

        public Criteria andCoinWareNumLessThanOrEqualTo(Integer value) {
            addCriterion("coin_ware_num <=", value, "coinWareNum");
            return (Criteria) this;
        }

        public Criteria andCoinWareNumIn(List<Integer> values) {
            addCriterion("coin_ware_num in", values, "coinWareNum");
            return (Criteria) this;
        }

        public Criteria andCoinWareNumNotIn(List<Integer> values) {
            addCriterion("coin_ware_num not in", values, "coinWareNum");
            return (Criteria) this;
        }

        public Criteria andCoinWareNumBetween(Integer value1, Integer value2) {
            addCriterion("coin_ware_num between", value1, value2, "coinWareNum");
            return (Criteria) this;
        }

        public Criteria andCoinWareNumNotBetween(Integer value1, Integer value2) {
            addCriterion("coin_ware_num not between", value1, value2, "coinWareNum");
            return (Criteria) this;
        }

        public Criteria andCoinWareTypeIsNull() {
            addCriterion("coin_ware_type is null");
            return (Criteria) this;
        }

        public Criteria andCoinWareTypeIsNotNull() {
            addCriterion("coin_ware_type is not null");
            return (Criteria) this;
        }

        public Criteria andCoinWareTypeEqualTo(Integer value) {
            addCriterion("coin_ware_type =", value, "coinWareType");
            return (Criteria) this;
        }

        public Criteria andCoinWareTypeNotEqualTo(Integer value) {
            addCriterion("coin_ware_type <>", value, "coinWareType");
            return (Criteria) this;
        }

        public Criteria andCoinWareTypeGreaterThan(Integer value) {
            addCriterion("coin_ware_type >", value, "coinWareType");
            return (Criteria) this;
        }

        public Criteria andCoinWareTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("coin_ware_type >=", value, "coinWareType");
            return (Criteria) this;
        }

        public Criteria andCoinWareTypeLessThan(Integer value) {
            addCriterion("coin_ware_type <", value, "coinWareType");
            return (Criteria) this;
        }

        public Criteria andCoinWareTypeLessThanOrEqualTo(Integer value) {
            addCriterion("coin_ware_type <=", value, "coinWareType");
            return (Criteria) this;
        }

        public Criteria andCoinWareTypeIn(List<Integer> values) {
            addCriterion("coin_ware_type in", values, "coinWareType");
            return (Criteria) this;
        }

        public Criteria andCoinWareTypeNotIn(List<Integer> values) {
            addCriterion("coin_ware_type not in", values, "coinWareType");
            return (Criteria) this;
        }

        public Criteria andCoinWareTypeBetween(Integer value1, Integer value2) {
            addCriterion("coin_ware_type between", value1, value2, "coinWareType");
            return (Criteria) this;
        }

        public Criteria andCoinWareTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("coin_ware_type not between", value1, value2, "coinWareType");
            return (Criteria) this;
        }

        public Criteria andCoinWareBigPicIsNull() {
            addCriterion("coin_ware_big_pic is null");
            return (Criteria) this;
        }

        public Criteria andCoinWareBigPicIsNotNull() {
            addCriterion("coin_ware_big_pic is not null");
            return (Criteria) this;
        }

        public Criteria andCoinWareBigPicEqualTo(String value) {
            addCriterion("coin_ware_big_pic =", value, "coinWareBigPic");
            return (Criteria) this;
        }

        public Criteria andCoinWareBigPicNotEqualTo(String value) {
            addCriterion("coin_ware_big_pic <>", value, "coinWareBigPic");
            return (Criteria) this;
        }

        public Criteria andCoinWareBigPicGreaterThan(String value) {
            addCriterion("coin_ware_big_pic >", value, "coinWareBigPic");
            return (Criteria) this;
        }

        public Criteria andCoinWareBigPicGreaterThanOrEqualTo(String value) {
            addCriterion("coin_ware_big_pic >=", value, "coinWareBigPic");
            return (Criteria) this;
        }

        public Criteria andCoinWareBigPicLessThan(String value) {
            addCriterion("coin_ware_big_pic <", value, "coinWareBigPic");
            return (Criteria) this;
        }

        public Criteria andCoinWareBigPicLessThanOrEqualTo(String value) {
            addCriterion("coin_ware_big_pic <=", value, "coinWareBigPic");
            return (Criteria) this;
        }

        public Criteria andCoinWareBigPicLike(String value) {
            addCriterion("coin_ware_big_pic like", value, "coinWareBigPic");
            return (Criteria) this;
        }

        public Criteria andCoinWareBigPicNotLike(String value) {
            addCriterion("coin_ware_big_pic not like", value, "coinWareBigPic");
            return (Criteria) this;
        }

        public Criteria andCoinWareBigPicIn(List<String> values) {
            addCriterion("coin_ware_big_pic in", values, "coinWareBigPic");
            return (Criteria) this;
        }

        public Criteria andCoinWareBigPicNotIn(List<String> values) {
            addCriterion("coin_ware_big_pic not in", values, "coinWareBigPic");
            return (Criteria) this;
        }

        public Criteria andCoinWareBigPicBetween(String value1, String value2) {
            addCriterion("coin_ware_big_pic between", value1, value2, "coinWareBigPic");
            return (Criteria) this;
        }

        public Criteria andCoinWareBigPicNotBetween(String value1, String value2) {
            addCriterion("coin_ware_big_pic not between", value1, value2, "coinWareBigPic");
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