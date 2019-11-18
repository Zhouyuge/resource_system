package com.bishe.main.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SelectTitleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SelectTitleExample() {
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

        public Criteria andTitleIdIsNull() {
            addCriterion("title_id is null");
            return (Criteria) this;
        }

        public Criteria andTitleIdIsNotNull() {
            addCriterion("title_id is not null");
            return (Criteria) this;
        }

        public Criteria andTitleIdEqualTo(Integer value) {
            addCriterion("title_id =", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdNotEqualTo(Integer value) {
            addCriterion("title_id <>", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdGreaterThan(Integer value) {
            addCriterion("title_id >", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("title_id >=", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdLessThan(Integer value) {
            addCriterion("title_id <", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdLessThanOrEqualTo(Integer value) {
            addCriterion("title_id <=", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdIn(List<Integer> values) {
            addCriterion("title_id in", values, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdNotIn(List<Integer> values) {
            addCriterion("title_id not in", values, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdBetween(Integer value1, Integer value2) {
            addCriterion("title_id between", value1, value2, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("title_id not between", value1, value2, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleNameIsNull() {
            addCriterion("title_name is null");
            return (Criteria) this;
        }

        public Criteria andTitleNameIsNotNull() {
            addCriterion("title_name is not null");
            return (Criteria) this;
        }

        public Criteria andTitleNameEqualTo(String value) {
            addCriterion("title_name =", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameNotEqualTo(String value) {
            addCriterion("title_name <>", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameGreaterThan(String value) {
            addCriterion("title_name >", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameGreaterThanOrEqualTo(String value) {
            addCriterion("title_name >=", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameLessThan(String value) {
            addCriterion("title_name <", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameLessThanOrEqualTo(String value) {
            addCriterion("title_name <=", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameLike(String value) {
            addCriterion("title_name like", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameNotLike(String value) {
            addCriterion("title_name not like", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameIn(List<String> values) {
            addCriterion("title_name in", values, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameNotIn(List<String> values) {
            addCriterion("title_name not in", values, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameBetween(String value1, String value2) {
            addCriterion("title_name between", value1, value2, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameNotBetween(String value1, String value2) {
            addCriterion("title_name not between", value1, value2, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleContentIsNull() {
            addCriterion("title_content is null");
            return (Criteria) this;
        }

        public Criteria andTitleContentIsNotNull() {
            addCriterion("title_content is not null");
            return (Criteria) this;
        }

        public Criteria andTitleContentEqualTo(String value) {
            addCriterion("title_content =", value, "titleContent");
            return (Criteria) this;
        }

        public Criteria andTitleContentNotEqualTo(String value) {
            addCriterion("title_content <>", value, "titleContent");
            return (Criteria) this;
        }

        public Criteria andTitleContentGreaterThan(String value) {
            addCriterion("title_content >", value, "titleContent");
            return (Criteria) this;
        }

        public Criteria andTitleContentGreaterThanOrEqualTo(String value) {
            addCriterion("title_content >=", value, "titleContent");
            return (Criteria) this;
        }

        public Criteria andTitleContentLessThan(String value) {
            addCriterion("title_content <", value, "titleContent");
            return (Criteria) this;
        }

        public Criteria andTitleContentLessThanOrEqualTo(String value) {
            addCriterion("title_content <=", value, "titleContent");
            return (Criteria) this;
        }

        public Criteria andTitleContentLike(String value) {
            addCriterion("title_content like", value, "titleContent");
            return (Criteria) this;
        }

        public Criteria andTitleContentNotLike(String value) {
            addCriterion("title_content not like", value, "titleContent");
            return (Criteria) this;
        }

        public Criteria andTitleContentIn(List<String> values) {
            addCriterion("title_content in", values, "titleContent");
            return (Criteria) this;
        }

        public Criteria andTitleContentNotIn(List<String> values) {
            addCriterion("title_content not in", values, "titleContent");
            return (Criteria) this;
        }

        public Criteria andTitleContentBetween(String value1, String value2) {
            addCriterion("title_content between", value1, value2, "titleContent");
            return (Criteria) this;
        }

        public Criteria andTitleContentNotBetween(String value1, String value2) {
            addCriterion("title_content not between", value1, value2, "titleContent");
            return (Criteria) this;
        }

        public Criteria andTitleAnswerIsNull() {
            addCriterion("title_answer is null");
            return (Criteria) this;
        }

        public Criteria andTitleAnswerIsNotNull() {
            addCriterion("title_answer is not null");
            return (Criteria) this;
        }

        public Criteria andTitleAnswerEqualTo(String value) {
            addCriterion("title_answer =", value, "titleAnswer");
            return (Criteria) this;
        }

        public Criteria andTitleAnswerNotEqualTo(String value) {
            addCriterion("title_answer <>", value, "titleAnswer");
            return (Criteria) this;
        }

        public Criteria andTitleAnswerGreaterThan(String value) {
            addCriterion("title_answer >", value, "titleAnswer");
            return (Criteria) this;
        }

        public Criteria andTitleAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("title_answer >=", value, "titleAnswer");
            return (Criteria) this;
        }

        public Criteria andTitleAnswerLessThan(String value) {
            addCriterion("title_answer <", value, "titleAnswer");
            return (Criteria) this;
        }

        public Criteria andTitleAnswerLessThanOrEqualTo(String value) {
            addCriterion("title_answer <=", value, "titleAnswer");
            return (Criteria) this;
        }

        public Criteria andTitleAnswerLike(String value) {
            addCriterion("title_answer like", value, "titleAnswer");
            return (Criteria) this;
        }

        public Criteria andTitleAnswerNotLike(String value) {
            addCriterion("title_answer not like", value, "titleAnswer");
            return (Criteria) this;
        }

        public Criteria andTitleAnswerIn(List<String> values) {
            addCriterion("title_answer in", values, "titleAnswer");
            return (Criteria) this;
        }

        public Criteria andTitleAnswerNotIn(List<String> values) {
            addCriterion("title_answer not in", values, "titleAnswer");
            return (Criteria) this;
        }

        public Criteria andTitleAnswerBetween(String value1, String value2) {
            addCriterion("title_answer between", value1, value2, "titleAnswer");
            return (Criteria) this;
        }

        public Criteria andTitleAnswerNotBetween(String value1, String value2) {
            addCriterion("title_answer not between", value1, value2, "titleAnswer");
            return (Criteria) this;
        }

        public Criteria andTitleHardIsNull() {
            addCriterion("title_hard is null");
            return (Criteria) this;
        }

        public Criteria andTitleHardIsNotNull() {
            addCriterion("title_hard is not null");
            return (Criteria) this;
        }

        public Criteria andTitleHardEqualTo(Integer value) {
            addCriterion("title_hard =", value, "titleHard");
            return (Criteria) this;
        }

        public Criteria andTitleHardNotEqualTo(Integer value) {
            addCriterion("title_hard <>", value, "titleHard");
            return (Criteria) this;
        }

        public Criteria andTitleHardGreaterThan(Integer value) {
            addCriterion("title_hard >", value, "titleHard");
            return (Criteria) this;
        }

        public Criteria andTitleHardGreaterThanOrEqualTo(Integer value) {
            addCriterion("title_hard >=", value, "titleHard");
            return (Criteria) this;
        }

        public Criteria andTitleHardLessThan(Integer value) {
            addCriterion("title_hard <", value, "titleHard");
            return (Criteria) this;
        }

        public Criteria andTitleHardLessThanOrEqualTo(Integer value) {
            addCriterion("title_hard <=", value, "titleHard");
            return (Criteria) this;
        }

        public Criteria andTitleHardIn(List<Integer> values) {
            addCriterion("title_hard in", values, "titleHard");
            return (Criteria) this;
        }

        public Criteria andTitleHardNotIn(List<Integer> values) {
            addCriterion("title_hard not in", values, "titleHard");
            return (Criteria) this;
        }

        public Criteria andTitleHardBetween(Integer value1, Integer value2) {
            addCriterion("title_hard between", value1, value2, "titleHard");
            return (Criteria) this;
        }

        public Criteria andTitleHardNotBetween(Integer value1, Integer value2) {
            addCriterion("title_hard not between", value1, value2, "titleHard");
            return (Criteria) this;
        }

        public Criteria andTitleAuthorIsNull() {
            addCriterion("title_author is null");
            return (Criteria) this;
        }

        public Criteria andTitleAuthorIsNotNull() {
            addCriterion("title_author is not null");
            return (Criteria) this;
        }

        public Criteria andTitleAuthorEqualTo(String value) {
            addCriterion("title_author =", value, "titleAuthor");
            return (Criteria) this;
        }

        public Criteria andTitleAuthorNotEqualTo(String value) {
            addCriterion("title_author <>", value, "titleAuthor");
            return (Criteria) this;
        }

        public Criteria andTitleAuthorGreaterThan(String value) {
            addCriterion("title_author >", value, "titleAuthor");
            return (Criteria) this;
        }

        public Criteria andTitleAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("title_author >=", value, "titleAuthor");
            return (Criteria) this;
        }

        public Criteria andTitleAuthorLessThan(String value) {
            addCriterion("title_author <", value, "titleAuthor");
            return (Criteria) this;
        }

        public Criteria andTitleAuthorLessThanOrEqualTo(String value) {
            addCriterion("title_author <=", value, "titleAuthor");
            return (Criteria) this;
        }

        public Criteria andTitleAuthorLike(String value) {
            addCriterion("title_author like", value, "titleAuthor");
            return (Criteria) this;
        }

        public Criteria andTitleAuthorNotLike(String value) {
            addCriterion("title_author not like", value, "titleAuthor");
            return (Criteria) this;
        }

        public Criteria andTitleAuthorIn(List<String> values) {
            addCriterion("title_author in", values, "titleAuthor");
            return (Criteria) this;
        }

        public Criteria andTitleAuthorNotIn(List<String> values) {
            addCriterion("title_author not in", values, "titleAuthor");
            return (Criteria) this;
        }

        public Criteria andTitleAuthorBetween(String value1, String value2) {
            addCriterion("title_author between", value1, value2, "titleAuthor");
            return (Criteria) this;
        }

        public Criteria andTitleAuthorNotBetween(String value1, String value2) {
            addCriterion("title_author not between", value1, value2, "titleAuthor");
            return (Criteria) this;
        }

        public Criteria andTitleTypeIsNull() {
            addCriterion("title_type is null");
            return (Criteria) this;
        }

        public Criteria andTitleTypeIsNotNull() {
            addCriterion("title_type is not null");
            return (Criteria) this;
        }

        public Criteria andTitleTypeEqualTo(Integer value) {
            addCriterion("title_type =", value, "titleType");
            return (Criteria) this;
        }

        public Criteria andTitleTypeNotEqualTo(Integer value) {
            addCriterion("title_type <>", value, "titleType");
            return (Criteria) this;
        }

        public Criteria andTitleTypeGreaterThan(Integer value) {
            addCriterion("title_type >", value, "titleType");
            return (Criteria) this;
        }

        public Criteria andTitleTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("title_type >=", value, "titleType");
            return (Criteria) this;
        }

        public Criteria andTitleTypeLessThan(Integer value) {
            addCriterion("title_type <", value, "titleType");
            return (Criteria) this;
        }

        public Criteria andTitleTypeLessThanOrEqualTo(Integer value) {
            addCriterion("title_type <=", value, "titleType");
            return (Criteria) this;
        }

        public Criteria andTitleTypeIn(List<Integer> values) {
            addCriterion("title_type in", values, "titleType");
            return (Criteria) this;
        }

        public Criteria andTitleTypeNotIn(List<Integer> values) {
            addCriterion("title_type not in", values, "titleType");
            return (Criteria) this;
        }

        public Criteria andTitleTypeBetween(Integer value1, Integer value2) {
            addCriterion("title_type between", value1, value2, "titleType");
            return (Criteria) this;
        }

        public Criteria andTitleTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("title_type not between", value1, value2, "titleType");
            return (Criteria) this;
        }

        public Criteria andTitleRightIsNull() {
            addCriterion("title_right is null");
            return (Criteria) this;
        }

        public Criteria andTitleRightIsNotNull() {
            addCriterion("title_right is not null");
            return (Criteria) this;
        }

        public Criteria andTitleRightEqualTo(Integer value) {
            addCriterion("title_right =", value, "titleRight");
            return (Criteria) this;
        }

        public Criteria andTitleRightNotEqualTo(Integer value) {
            addCriterion("title_right <>", value, "titleRight");
            return (Criteria) this;
        }

        public Criteria andTitleRightGreaterThan(Integer value) {
            addCriterion("title_right >", value, "titleRight");
            return (Criteria) this;
        }

        public Criteria andTitleRightGreaterThanOrEqualTo(Integer value) {
            addCriterion("title_right >=", value, "titleRight");
            return (Criteria) this;
        }

        public Criteria andTitleRightLessThan(Integer value) {
            addCriterion("title_right <", value, "titleRight");
            return (Criteria) this;
        }

        public Criteria andTitleRightLessThanOrEqualTo(Integer value) {
            addCriterion("title_right <=", value, "titleRight");
            return (Criteria) this;
        }

        public Criteria andTitleRightIn(List<Integer> values) {
            addCriterion("title_right in", values, "titleRight");
            return (Criteria) this;
        }

        public Criteria andTitleRightNotIn(List<Integer> values) {
            addCriterion("title_right not in", values, "titleRight");
            return (Criteria) this;
        }

        public Criteria andTitleRightBetween(Integer value1, Integer value2) {
            addCriterion("title_right between", value1, value2, "titleRight");
            return (Criteria) this;
        }

        public Criteria andTitleRightNotBetween(Integer value1, Integer value2) {
            addCriterion("title_right not between", value1, value2, "titleRight");
            return (Criteria) this;
        }

        public Criteria andTitleCountIsNull() {
            addCriterion("title_count is null");
            return (Criteria) this;
        }

        public Criteria andTitleCountIsNotNull() {
            addCriterion("title_count is not null");
            return (Criteria) this;
        }

        public Criteria andTitleCountEqualTo(Integer value) {
            addCriterion("title_count =", value, "titleCount");
            return (Criteria) this;
        }

        public Criteria andTitleCountNotEqualTo(Integer value) {
            addCriterion("title_count <>", value, "titleCount");
            return (Criteria) this;
        }

        public Criteria andTitleCountGreaterThan(Integer value) {
            addCriterion("title_count >", value, "titleCount");
            return (Criteria) this;
        }

        public Criteria andTitleCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("title_count >=", value, "titleCount");
            return (Criteria) this;
        }

        public Criteria andTitleCountLessThan(Integer value) {
            addCriterion("title_count <", value, "titleCount");
            return (Criteria) this;
        }

        public Criteria andTitleCountLessThanOrEqualTo(Integer value) {
            addCriterion("title_count <=", value, "titleCount");
            return (Criteria) this;
        }

        public Criteria andTitleCountIn(List<Integer> values) {
            addCriterion("title_count in", values, "titleCount");
            return (Criteria) this;
        }

        public Criteria andTitleCountNotIn(List<Integer> values) {
            addCriterion("title_count not in", values, "titleCount");
            return (Criteria) this;
        }

        public Criteria andTitleCountBetween(Integer value1, Integer value2) {
            addCriterion("title_count between", value1, value2, "titleCount");
            return (Criteria) this;
        }

        public Criteria andTitleCountNotBetween(Integer value1, Integer value2) {
            addCriterion("title_count not between", value1, value2, "titleCount");
            return (Criteria) this;
        }

        public Criteria andTitleCreateTimeIsNull() {
            addCriterion("title_create_time is null");
            return (Criteria) this;
        }

        public Criteria andTitleCreateTimeIsNotNull() {
            addCriterion("title_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andTitleCreateTimeEqualTo(Date value) {
            addCriterion("title_create_time =", value, "titleCreateTime");
            return (Criteria) this;
        }

        public Criteria andTitleCreateTimeNotEqualTo(Date value) {
            addCriterion("title_create_time <>", value, "titleCreateTime");
            return (Criteria) this;
        }

        public Criteria andTitleCreateTimeGreaterThan(Date value) {
            addCriterion("title_create_time >", value, "titleCreateTime");
            return (Criteria) this;
        }

        public Criteria andTitleCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("title_create_time >=", value, "titleCreateTime");
            return (Criteria) this;
        }

        public Criteria andTitleCreateTimeLessThan(Date value) {
            addCriterion("title_create_time <", value, "titleCreateTime");
            return (Criteria) this;
        }

        public Criteria andTitleCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("title_create_time <=", value, "titleCreateTime");
            return (Criteria) this;
        }

        public Criteria andTitleCreateTimeIn(List<Date> values) {
            addCriterion("title_create_time in", values, "titleCreateTime");
            return (Criteria) this;
        }

        public Criteria andTitleCreateTimeNotIn(List<Date> values) {
            addCriterion("title_create_time not in", values, "titleCreateTime");
            return (Criteria) this;
        }

        public Criteria andTitleCreateTimeBetween(Date value1, Date value2) {
            addCriterion("title_create_time between", value1, value2, "titleCreateTime");
            return (Criteria) this;
        }

        public Criteria andTitleCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("title_create_time not between", value1, value2, "titleCreateTime");
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