package com.bishe.main.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CircleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CircleExample() {
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

        public Criteria andCircleNameIsNull() {
            addCriterion("circle_name is null");
            return (Criteria) this;
        }

        public Criteria andCircleNameIsNotNull() {
            addCriterion("circle_name is not null");
            return (Criteria) this;
        }

        public Criteria andCircleNameEqualTo(String value) {
            addCriterion("circle_name =", value, "circleName");
            return (Criteria) this;
        }

        public Criteria andCircleNameNotEqualTo(String value) {
            addCriterion("circle_name <>", value, "circleName");
            return (Criteria) this;
        }

        public Criteria andCircleNameGreaterThan(String value) {
            addCriterion("circle_name >", value, "circleName");
            return (Criteria) this;
        }

        public Criteria andCircleNameGreaterThanOrEqualTo(String value) {
            addCriterion("circle_name >=", value, "circleName");
            return (Criteria) this;
        }

        public Criteria andCircleNameLessThan(String value) {
            addCriterion("circle_name <", value, "circleName");
            return (Criteria) this;
        }

        public Criteria andCircleNameLessThanOrEqualTo(String value) {
            addCriterion("circle_name <=", value, "circleName");
            return (Criteria) this;
        }

        public Criteria andCircleNameLike(String value) {
            addCriterion("circle_name like", value, "circleName");
            return (Criteria) this;
        }

        public Criteria andCircleNameNotLike(String value) {
            addCriterion("circle_name not like", value, "circleName");
            return (Criteria) this;
        }

        public Criteria andCircleNameIn(List<String> values) {
            addCriterion("circle_name in", values, "circleName");
            return (Criteria) this;
        }

        public Criteria andCircleNameNotIn(List<String> values) {
            addCriterion("circle_name not in", values, "circleName");
            return (Criteria) this;
        }

        public Criteria andCircleNameBetween(String value1, String value2) {
            addCriterion("circle_name between", value1, value2, "circleName");
            return (Criteria) this;
        }

        public Criteria andCircleNameNotBetween(String value1, String value2) {
            addCriterion("circle_name not between", value1, value2, "circleName");
            return (Criteria) this;
        }

        public Criteria andCircleUserNumIsNull() {
            addCriterion("circle_user_num is null");
            return (Criteria) this;
        }

        public Criteria andCircleUserNumIsNotNull() {
            addCriterion("circle_user_num is not null");
            return (Criteria) this;
        }

        public Criteria andCircleUserNumEqualTo(Integer value) {
            addCriterion("circle_user_num =", value, "circleUserNum");
            return (Criteria) this;
        }

        public Criteria andCircleUserNumNotEqualTo(Integer value) {
            addCriterion("circle_user_num <>", value, "circleUserNum");
            return (Criteria) this;
        }

        public Criteria andCircleUserNumGreaterThan(Integer value) {
            addCriterion("circle_user_num >", value, "circleUserNum");
            return (Criteria) this;
        }

        public Criteria andCircleUserNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("circle_user_num >=", value, "circleUserNum");
            return (Criteria) this;
        }

        public Criteria andCircleUserNumLessThan(Integer value) {
            addCriterion("circle_user_num <", value, "circleUserNum");
            return (Criteria) this;
        }

        public Criteria andCircleUserNumLessThanOrEqualTo(Integer value) {
            addCriterion("circle_user_num <=", value, "circleUserNum");
            return (Criteria) this;
        }

        public Criteria andCircleUserNumIn(List<Integer> values) {
            addCriterion("circle_user_num in", values, "circleUserNum");
            return (Criteria) this;
        }

        public Criteria andCircleUserNumNotIn(List<Integer> values) {
            addCriterion("circle_user_num not in", values, "circleUserNum");
            return (Criteria) this;
        }

        public Criteria andCircleUserNumBetween(Integer value1, Integer value2) {
            addCriterion("circle_user_num between", value1, value2, "circleUserNum");
            return (Criteria) this;
        }

        public Criteria andCircleUserNumNotBetween(Integer value1, Integer value2) {
            addCriterion("circle_user_num not between", value1, value2, "circleUserNum");
            return (Criteria) this;
        }

        public Criteria andCirclePicIsNull() {
            addCriterion("circle_pic is null");
            return (Criteria) this;
        }

        public Criteria andCirclePicIsNotNull() {
            addCriterion("circle_pic is not null");
            return (Criteria) this;
        }

        public Criteria andCirclePicEqualTo(String value) {
            addCriterion("circle_pic =", value, "circlePic");
            return (Criteria) this;
        }

        public Criteria andCirclePicNotEqualTo(String value) {
            addCriterion("circle_pic <>", value, "circlePic");
            return (Criteria) this;
        }

        public Criteria andCirclePicGreaterThan(String value) {
            addCriterion("circle_pic >", value, "circlePic");
            return (Criteria) this;
        }

        public Criteria andCirclePicGreaterThanOrEqualTo(String value) {
            addCriterion("circle_pic >=", value, "circlePic");
            return (Criteria) this;
        }

        public Criteria andCirclePicLessThan(String value) {
            addCriterion("circle_pic <", value, "circlePic");
            return (Criteria) this;
        }

        public Criteria andCirclePicLessThanOrEqualTo(String value) {
            addCriterion("circle_pic <=", value, "circlePic");
            return (Criteria) this;
        }

        public Criteria andCirclePicLike(String value) {
            addCriterion("circle_pic like", value, "circlePic");
            return (Criteria) this;
        }

        public Criteria andCirclePicNotLike(String value) {
            addCriterion("circle_pic not like", value, "circlePic");
            return (Criteria) this;
        }

        public Criteria andCirclePicIn(List<String> values) {
            addCriterion("circle_pic in", values, "circlePic");
            return (Criteria) this;
        }

        public Criteria andCirclePicNotIn(List<String> values) {
            addCriterion("circle_pic not in", values, "circlePic");
            return (Criteria) this;
        }

        public Criteria andCirclePicBetween(String value1, String value2) {
            addCriterion("circle_pic between", value1, value2, "circlePic");
            return (Criteria) this;
        }

        public Criteria andCirclePicNotBetween(String value1, String value2) {
            addCriterion("circle_pic not between", value1, value2, "circlePic");
            return (Criteria) this;
        }

        public Criteria andCircleTypeIsNull() {
            addCriterion("circle_type is null");
            return (Criteria) this;
        }

        public Criteria andCircleTypeIsNotNull() {
            addCriterion("circle_type is not null");
            return (Criteria) this;
        }

        public Criteria andCircleTypeEqualTo(Integer value) {
            addCriterion("circle_type =", value, "circleType");
            return (Criteria) this;
        }

        public Criteria andCircleTypeNotEqualTo(Integer value) {
            addCriterion("circle_type <>", value, "circleType");
            return (Criteria) this;
        }

        public Criteria andCircleTypeGreaterThan(Integer value) {
            addCriterion("circle_type >", value, "circleType");
            return (Criteria) this;
        }

        public Criteria andCircleTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("circle_type >=", value, "circleType");
            return (Criteria) this;
        }

        public Criteria andCircleTypeLessThan(Integer value) {
            addCriterion("circle_type <", value, "circleType");
            return (Criteria) this;
        }

        public Criteria andCircleTypeLessThanOrEqualTo(Integer value) {
            addCriterion("circle_type <=", value, "circleType");
            return (Criteria) this;
        }

        public Criteria andCircleTypeIn(List<Integer> values) {
            addCriterion("circle_type in", values, "circleType");
            return (Criteria) this;
        }

        public Criteria andCircleTypeNotIn(List<Integer> values) {
            addCriterion("circle_type not in", values, "circleType");
            return (Criteria) this;
        }

        public Criteria andCircleTypeBetween(Integer value1, Integer value2) {
            addCriterion("circle_type between", value1, value2, "circleType");
            return (Criteria) this;
        }

        public Criteria andCircleTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("circle_type not between", value1, value2, "circleType");
            return (Criteria) this;
        }

        public Criteria andCircleLabelIsNull() {
            addCriterion("circle_label is null");
            return (Criteria) this;
        }

        public Criteria andCircleLabelIsNotNull() {
            addCriterion("circle_label is not null");
            return (Criteria) this;
        }

        public Criteria andCircleLabelEqualTo(String value) {
            addCriterion("circle_label =", value, "circleLabel");
            return (Criteria) this;
        }

        public Criteria andCircleLabelNotEqualTo(String value) {
            addCriterion("circle_label <>", value, "circleLabel");
            return (Criteria) this;
        }

        public Criteria andCircleLabelGreaterThan(String value) {
            addCriterion("circle_label >", value, "circleLabel");
            return (Criteria) this;
        }

        public Criteria andCircleLabelGreaterThanOrEqualTo(String value) {
            addCriterion("circle_label >=", value, "circleLabel");
            return (Criteria) this;
        }

        public Criteria andCircleLabelLessThan(String value) {
            addCriterion("circle_label <", value, "circleLabel");
            return (Criteria) this;
        }

        public Criteria andCircleLabelLessThanOrEqualTo(String value) {
            addCriterion("circle_label <=", value, "circleLabel");
            return (Criteria) this;
        }

        public Criteria andCircleLabelLike(String value) {
            addCriterion("circle_label like", value, "circleLabel");
            return (Criteria) this;
        }

        public Criteria andCircleLabelNotLike(String value) {
            addCriterion("circle_label not like", value, "circleLabel");
            return (Criteria) this;
        }

        public Criteria andCircleLabelIn(List<String> values) {
            addCriterion("circle_label in", values, "circleLabel");
            return (Criteria) this;
        }

        public Criteria andCircleLabelNotIn(List<String> values) {
            addCriterion("circle_label not in", values, "circleLabel");
            return (Criteria) this;
        }

        public Criteria andCircleLabelBetween(String value1, String value2) {
            addCriterion("circle_label between", value1, value2, "circleLabel");
            return (Criteria) this;
        }

        public Criteria andCircleLabelNotBetween(String value1, String value2) {
            addCriterion("circle_label not between", value1, value2, "circleLabel");
            return (Criteria) this;
        }

        public Criteria andCircleInstructionIsNull() {
            addCriterion("circle_instruction is null");
            return (Criteria) this;
        }

        public Criteria andCircleInstructionIsNotNull() {
            addCriterion("circle_instruction is not null");
            return (Criteria) this;
        }

        public Criteria andCircleInstructionEqualTo(String value) {
            addCriterion("circle_instruction =", value, "circleInstruction");
            return (Criteria) this;
        }

        public Criteria andCircleInstructionNotEqualTo(String value) {
            addCriterion("circle_instruction <>", value, "circleInstruction");
            return (Criteria) this;
        }

        public Criteria andCircleInstructionGreaterThan(String value) {
            addCriterion("circle_instruction >", value, "circleInstruction");
            return (Criteria) this;
        }

        public Criteria andCircleInstructionGreaterThanOrEqualTo(String value) {
            addCriterion("circle_instruction >=", value, "circleInstruction");
            return (Criteria) this;
        }

        public Criteria andCircleInstructionLessThan(String value) {
            addCriterion("circle_instruction <", value, "circleInstruction");
            return (Criteria) this;
        }

        public Criteria andCircleInstructionLessThanOrEqualTo(String value) {
            addCriterion("circle_instruction <=", value, "circleInstruction");
            return (Criteria) this;
        }

        public Criteria andCircleInstructionLike(String value) {
            addCriterion("circle_instruction like", value, "circleInstruction");
            return (Criteria) this;
        }

        public Criteria andCircleInstructionNotLike(String value) {
            addCriterion("circle_instruction not like", value, "circleInstruction");
            return (Criteria) this;
        }

        public Criteria andCircleInstructionIn(List<String> values) {
            addCriterion("circle_instruction in", values, "circleInstruction");
            return (Criteria) this;
        }

        public Criteria andCircleInstructionNotIn(List<String> values) {
            addCriterion("circle_instruction not in", values, "circleInstruction");
            return (Criteria) this;
        }

        public Criteria andCircleInstructionBetween(String value1, String value2) {
            addCriterion("circle_instruction between", value1, value2, "circleInstruction");
            return (Criteria) this;
        }

        public Criteria andCircleInstructionNotBetween(String value1, String value2) {
            addCriterion("circle_instruction not between", value1, value2, "circleInstruction");
            return (Criteria) this;
        }

        public Criteria andCircleUserIdIsNull() {
            addCriterion("circle_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCircleUserIdIsNotNull() {
            addCriterion("circle_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCircleUserIdEqualTo(String value) {
            addCriterion("circle_user_id =", value, "circleUserId");
            return (Criteria) this;
        }

        public Criteria andCircleUserIdNotEqualTo(String value) {
            addCriterion("circle_user_id <>", value, "circleUserId");
            return (Criteria) this;
        }

        public Criteria andCircleUserIdGreaterThan(String value) {
            addCriterion("circle_user_id >", value, "circleUserId");
            return (Criteria) this;
        }

        public Criteria andCircleUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("circle_user_id >=", value, "circleUserId");
            return (Criteria) this;
        }

        public Criteria andCircleUserIdLessThan(String value) {
            addCriterion("circle_user_id <", value, "circleUserId");
            return (Criteria) this;
        }

        public Criteria andCircleUserIdLessThanOrEqualTo(String value) {
            addCriterion("circle_user_id <=", value, "circleUserId");
            return (Criteria) this;
        }

        public Criteria andCircleUserIdLike(String value) {
            addCriterion("circle_user_id like", value, "circleUserId");
            return (Criteria) this;
        }

        public Criteria andCircleUserIdNotLike(String value) {
            addCriterion("circle_user_id not like", value, "circleUserId");
            return (Criteria) this;
        }

        public Criteria andCircleUserIdIn(List<String> values) {
            addCriterion("circle_user_id in", values, "circleUserId");
            return (Criteria) this;
        }

        public Criteria andCircleUserIdNotIn(List<String> values) {
            addCriterion("circle_user_id not in", values, "circleUserId");
            return (Criteria) this;
        }

        public Criteria andCircleUserIdBetween(String value1, String value2) {
            addCriterion("circle_user_id between", value1, value2, "circleUserId");
            return (Criteria) this;
        }

        public Criteria andCircleUserIdNotBetween(String value1, String value2) {
            addCriterion("circle_user_id not between", value1, value2, "circleUserId");
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