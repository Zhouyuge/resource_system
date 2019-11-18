package com.bishe.main.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogCenterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogCenterExample() {
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

        public Criteria andBlogCenterIdIsNull() {
            addCriterion("blog_center_id is null");
            return (Criteria) this;
        }

        public Criteria andBlogCenterIdIsNotNull() {
            addCriterion("blog_center_id is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCenterIdEqualTo(Integer value) {
            addCriterion("blog_center_id =", value, "blogCenterId");
            return (Criteria) this;
        }

        public Criteria andBlogCenterIdNotEqualTo(Integer value) {
            addCriterion("blog_center_id <>", value, "blogCenterId");
            return (Criteria) this;
        }

        public Criteria andBlogCenterIdGreaterThan(Integer value) {
            addCriterion("blog_center_id >", value, "blogCenterId");
            return (Criteria) this;
        }

        public Criteria andBlogCenterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_center_id >=", value, "blogCenterId");
            return (Criteria) this;
        }

        public Criteria andBlogCenterIdLessThan(Integer value) {
            addCriterion("blog_center_id <", value, "blogCenterId");
            return (Criteria) this;
        }

        public Criteria andBlogCenterIdLessThanOrEqualTo(Integer value) {
            addCriterion("blog_center_id <=", value, "blogCenterId");
            return (Criteria) this;
        }

        public Criteria andBlogCenterIdIn(List<Integer> values) {
            addCriterion("blog_center_id in", values, "blogCenterId");
            return (Criteria) this;
        }

        public Criteria andBlogCenterIdNotIn(List<Integer> values) {
            addCriterion("blog_center_id not in", values, "blogCenterId");
            return (Criteria) this;
        }

        public Criteria andBlogCenterIdBetween(Integer value1, Integer value2) {
            addCriterion("blog_center_id between", value1, value2, "blogCenterId");
            return (Criteria) this;
        }

        public Criteria andBlogCenterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_center_id not between", value1, value2, "blogCenterId");
            return (Criteria) this;
        }

        public Criteria andBlogCenterNameIsNull() {
            addCriterion("blog_center_name is null");
            return (Criteria) this;
        }

        public Criteria andBlogCenterNameIsNotNull() {
            addCriterion("blog_center_name is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCenterNameEqualTo(String value) {
            addCriterion("blog_center_name =", value, "blogCenterName");
            return (Criteria) this;
        }

        public Criteria andBlogCenterNameNotEqualTo(String value) {
            addCriterion("blog_center_name <>", value, "blogCenterName");
            return (Criteria) this;
        }

        public Criteria andBlogCenterNameGreaterThan(String value) {
            addCriterion("blog_center_name >", value, "blogCenterName");
            return (Criteria) this;
        }

        public Criteria andBlogCenterNameGreaterThanOrEqualTo(String value) {
            addCriterion("blog_center_name >=", value, "blogCenterName");
            return (Criteria) this;
        }

        public Criteria andBlogCenterNameLessThan(String value) {
            addCriterion("blog_center_name <", value, "blogCenterName");
            return (Criteria) this;
        }

        public Criteria andBlogCenterNameLessThanOrEqualTo(String value) {
            addCriterion("blog_center_name <=", value, "blogCenterName");
            return (Criteria) this;
        }

        public Criteria andBlogCenterNameLike(String value) {
            addCriterion("blog_center_name like", value, "blogCenterName");
            return (Criteria) this;
        }

        public Criteria andBlogCenterNameNotLike(String value) {
            addCriterion("blog_center_name not like", value, "blogCenterName");
            return (Criteria) this;
        }

        public Criteria andBlogCenterNameIn(List<String> values) {
            addCriterion("blog_center_name in", values, "blogCenterName");
            return (Criteria) this;
        }

        public Criteria andBlogCenterNameNotIn(List<String> values) {
            addCriterion("blog_center_name not in", values, "blogCenterName");
            return (Criteria) this;
        }

        public Criteria andBlogCenterNameBetween(String value1, String value2) {
            addCriterion("blog_center_name between", value1, value2, "blogCenterName");
            return (Criteria) this;
        }

        public Criteria andBlogCenterNameNotBetween(String value1, String value2) {
            addCriterion("blog_center_name not between", value1, value2, "blogCenterName");
            return (Criteria) this;
        }

        public Criteria andBlogCenterAuthorIsNull() {
            addCriterion("blog_center_author is null");
            return (Criteria) this;
        }

        public Criteria andBlogCenterAuthorIsNotNull() {
            addCriterion("blog_center_author is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCenterAuthorEqualTo(String value) {
            addCriterion("blog_center_author =", value, "blogCenterAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogCenterAuthorNotEqualTo(String value) {
            addCriterion("blog_center_author <>", value, "blogCenterAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogCenterAuthorGreaterThan(String value) {
            addCriterion("blog_center_author >", value, "blogCenterAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogCenterAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("blog_center_author >=", value, "blogCenterAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogCenterAuthorLessThan(String value) {
            addCriterion("blog_center_author <", value, "blogCenterAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogCenterAuthorLessThanOrEqualTo(String value) {
            addCriterion("blog_center_author <=", value, "blogCenterAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogCenterAuthorLike(String value) {
            addCriterion("blog_center_author like", value, "blogCenterAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogCenterAuthorNotLike(String value) {
            addCriterion("blog_center_author not like", value, "blogCenterAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogCenterAuthorIn(List<String> values) {
            addCriterion("blog_center_author in", values, "blogCenterAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogCenterAuthorNotIn(List<String> values) {
            addCriterion("blog_center_author not in", values, "blogCenterAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogCenterAuthorBetween(String value1, String value2) {
            addCriterion("blog_center_author between", value1, value2, "blogCenterAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogCenterAuthorNotBetween(String value1, String value2) {
            addCriterion("blog_center_author not between", value1, value2, "blogCenterAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogCenterPicIsNull() {
            addCriterion("blog_center_pic is null");
            return (Criteria) this;
        }

        public Criteria andBlogCenterPicIsNotNull() {
            addCriterion("blog_center_pic is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCenterPicEqualTo(String value) {
            addCriterion("blog_center_pic =", value, "blogCenterPic");
            return (Criteria) this;
        }

        public Criteria andBlogCenterPicNotEqualTo(String value) {
            addCriterion("blog_center_pic <>", value, "blogCenterPic");
            return (Criteria) this;
        }

        public Criteria andBlogCenterPicGreaterThan(String value) {
            addCriterion("blog_center_pic >", value, "blogCenterPic");
            return (Criteria) this;
        }

        public Criteria andBlogCenterPicGreaterThanOrEqualTo(String value) {
            addCriterion("blog_center_pic >=", value, "blogCenterPic");
            return (Criteria) this;
        }

        public Criteria andBlogCenterPicLessThan(String value) {
            addCriterion("blog_center_pic <", value, "blogCenterPic");
            return (Criteria) this;
        }

        public Criteria andBlogCenterPicLessThanOrEqualTo(String value) {
            addCriterion("blog_center_pic <=", value, "blogCenterPic");
            return (Criteria) this;
        }

        public Criteria andBlogCenterPicLike(String value) {
            addCriterion("blog_center_pic like", value, "blogCenterPic");
            return (Criteria) this;
        }

        public Criteria andBlogCenterPicNotLike(String value) {
            addCriterion("blog_center_pic not like", value, "blogCenterPic");
            return (Criteria) this;
        }

        public Criteria andBlogCenterPicIn(List<String> values) {
            addCriterion("blog_center_pic in", values, "blogCenterPic");
            return (Criteria) this;
        }

        public Criteria andBlogCenterPicNotIn(List<String> values) {
            addCriterion("blog_center_pic not in", values, "blogCenterPic");
            return (Criteria) this;
        }

        public Criteria andBlogCenterPicBetween(String value1, String value2) {
            addCriterion("blog_center_pic between", value1, value2, "blogCenterPic");
            return (Criteria) this;
        }

        public Criteria andBlogCenterPicNotBetween(String value1, String value2) {
            addCriterion("blog_center_pic not between", value1, value2, "blogCenterPic");
            return (Criteria) this;
        }

        public Criteria andBlogCenterAgreeIsNull() {
            addCriterion("blog_center_agree is null");
            return (Criteria) this;
        }

        public Criteria andBlogCenterAgreeIsNotNull() {
            addCriterion("blog_center_agree is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCenterAgreeEqualTo(Integer value) {
            addCriterion("blog_center_agree =", value, "blogCenterAgree");
            return (Criteria) this;
        }

        public Criteria andBlogCenterAgreeNotEqualTo(Integer value) {
            addCriterion("blog_center_agree <>", value, "blogCenterAgree");
            return (Criteria) this;
        }

        public Criteria andBlogCenterAgreeGreaterThan(Integer value) {
            addCriterion("blog_center_agree >", value, "blogCenterAgree");
            return (Criteria) this;
        }

        public Criteria andBlogCenterAgreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_center_agree >=", value, "blogCenterAgree");
            return (Criteria) this;
        }

        public Criteria andBlogCenterAgreeLessThan(Integer value) {
            addCriterion("blog_center_agree <", value, "blogCenterAgree");
            return (Criteria) this;
        }

        public Criteria andBlogCenterAgreeLessThanOrEqualTo(Integer value) {
            addCriterion("blog_center_agree <=", value, "blogCenterAgree");
            return (Criteria) this;
        }

        public Criteria andBlogCenterAgreeIn(List<Integer> values) {
            addCriterion("blog_center_agree in", values, "blogCenterAgree");
            return (Criteria) this;
        }

        public Criteria andBlogCenterAgreeNotIn(List<Integer> values) {
            addCriterion("blog_center_agree not in", values, "blogCenterAgree");
            return (Criteria) this;
        }

        public Criteria andBlogCenterAgreeBetween(Integer value1, Integer value2) {
            addCriterion("blog_center_agree between", value1, value2, "blogCenterAgree");
            return (Criteria) this;
        }

        public Criteria andBlogCenterAgreeNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_center_agree not between", value1, value2, "blogCenterAgree");
            return (Criteria) this;
        }

        public Criteria andBlogCenterCollectIsNull() {
            addCriterion("blog_center_collect is null");
            return (Criteria) this;
        }

        public Criteria andBlogCenterCollectIsNotNull() {
            addCriterion("blog_center_collect is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCenterCollectEqualTo(Integer value) {
            addCriterion("blog_center_collect =", value, "blogCenterCollect");
            return (Criteria) this;
        }

        public Criteria andBlogCenterCollectNotEqualTo(Integer value) {
            addCriterion("blog_center_collect <>", value, "blogCenterCollect");
            return (Criteria) this;
        }

        public Criteria andBlogCenterCollectGreaterThan(Integer value) {
            addCriterion("blog_center_collect >", value, "blogCenterCollect");
            return (Criteria) this;
        }

        public Criteria andBlogCenterCollectGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_center_collect >=", value, "blogCenterCollect");
            return (Criteria) this;
        }

        public Criteria andBlogCenterCollectLessThan(Integer value) {
            addCriterion("blog_center_collect <", value, "blogCenterCollect");
            return (Criteria) this;
        }

        public Criteria andBlogCenterCollectLessThanOrEqualTo(Integer value) {
            addCriterion("blog_center_collect <=", value, "blogCenterCollect");
            return (Criteria) this;
        }

        public Criteria andBlogCenterCollectIn(List<Integer> values) {
            addCriterion("blog_center_collect in", values, "blogCenterCollect");
            return (Criteria) this;
        }

        public Criteria andBlogCenterCollectNotIn(List<Integer> values) {
            addCriterion("blog_center_collect not in", values, "blogCenterCollect");
            return (Criteria) this;
        }

        public Criteria andBlogCenterCollectBetween(Integer value1, Integer value2) {
            addCriterion("blog_center_collect between", value1, value2, "blogCenterCollect");
            return (Criteria) this;
        }

        public Criteria andBlogCenterCollectNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_center_collect not between", value1, value2, "blogCenterCollect");
            return (Criteria) this;
        }

        public Criteria andBlogCenterEditTimeIsNull() {
            addCriterion("blog_center_edit_time is null");
            return (Criteria) this;
        }

        public Criteria andBlogCenterEditTimeIsNotNull() {
            addCriterion("blog_center_edit_time is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCenterEditTimeEqualTo(Date value) {
            addCriterion("blog_center_edit_time =", value, "blogCenterEditTime");
            return (Criteria) this;
        }

        public Criteria andBlogCenterEditTimeNotEqualTo(Date value) {
            addCriterion("blog_center_edit_time <>", value, "blogCenterEditTime");
            return (Criteria) this;
        }

        public Criteria andBlogCenterEditTimeGreaterThan(Date value) {
            addCriterion("blog_center_edit_time >", value, "blogCenterEditTime");
            return (Criteria) this;
        }

        public Criteria andBlogCenterEditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("blog_center_edit_time >=", value, "blogCenterEditTime");
            return (Criteria) this;
        }

        public Criteria andBlogCenterEditTimeLessThan(Date value) {
            addCriterion("blog_center_edit_time <", value, "blogCenterEditTime");
            return (Criteria) this;
        }

        public Criteria andBlogCenterEditTimeLessThanOrEqualTo(Date value) {
            addCriterion("blog_center_edit_time <=", value, "blogCenterEditTime");
            return (Criteria) this;
        }

        public Criteria andBlogCenterEditTimeIn(List<Date> values) {
            addCriterion("blog_center_edit_time in", values, "blogCenterEditTime");
            return (Criteria) this;
        }

        public Criteria andBlogCenterEditTimeNotIn(List<Date> values) {
            addCriterion("blog_center_edit_time not in", values, "blogCenterEditTime");
            return (Criteria) this;
        }

        public Criteria andBlogCenterEditTimeBetween(Date value1, Date value2) {
            addCriterion("blog_center_edit_time between", value1, value2, "blogCenterEditTime");
            return (Criteria) this;
        }

        public Criteria andBlogCenterEditTimeNotBetween(Date value1, Date value2) {
            addCriterion("blog_center_edit_time not between", value1, value2, "blogCenterEditTime");
            return (Criteria) this;
        }

        public Criteria andBlogCenterVlogIsNull() {
            addCriterion("blog_center_vlog is null");
            return (Criteria) this;
        }

        public Criteria andBlogCenterVlogIsNotNull() {
            addCriterion("blog_center_vlog is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCenterVlogEqualTo(String value) {
            addCriterion("blog_center_vlog =", value, "blogCenterVlog");
            return (Criteria) this;
        }

        public Criteria andBlogCenterVlogNotEqualTo(String value) {
            addCriterion("blog_center_vlog <>", value, "blogCenterVlog");
            return (Criteria) this;
        }

        public Criteria andBlogCenterVlogGreaterThan(String value) {
            addCriterion("blog_center_vlog >", value, "blogCenterVlog");
            return (Criteria) this;
        }

        public Criteria andBlogCenterVlogGreaterThanOrEqualTo(String value) {
            addCriterion("blog_center_vlog >=", value, "blogCenterVlog");
            return (Criteria) this;
        }

        public Criteria andBlogCenterVlogLessThan(String value) {
            addCriterion("blog_center_vlog <", value, "blogCenterVlog");
            return (Criteria) this;
        }

        public Criteria andBlogCenterVlogLessThanOrEqualTo(String value) {
            addCriterion("blog_center_vlog <=", value, "blogCenterVlog");
            return (Criteria) this;
        }

        public Criteria andBlogCenterVlogLike(String value) {
            addCriterion("blog_center_vlog like", value, "blogCenterVlog");
            return (Criteria) this;
        }

        public Criteria andBlogCenterVlogNotLike(String value) {
            addCriterion("blog_center_vlog not like", value, "blogCenterVlog");
            return (Criteria) this;
        }

        public Criteria andBlogCenterVlogIn(List<String> values) {
            addCriterion("blog_center_vlog in", values, "blogCenterVlog");
            return (Criteria) this;
        }

        public Criteria andBlogCenterVlogNotIn(List<String> values) {
            addCriterion("blog_center_vlog not in", values, "blogCenterVlog");
            return (Criteria) this;
        }

        public Criteria andBlogCenterVlogBetween(String value1, String value2) {
            addCriterion("blog_center_vlog between", value1, value2, "blogCenterVlog");
            return (Criteria) this;
        }

        public Criteria andBlogCenterVlogNotBetween(String value1, String value2) {
            addCriterion("blog_center_vlog not between", value1, value2, "blogCenterVlog");
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