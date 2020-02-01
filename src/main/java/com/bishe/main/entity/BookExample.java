package com.bishe.main.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookExample() {
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

        public Criteria andBookIdIsNull() {
            addCriterion("book_id is null");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNotNull() {
            addCriterion("book_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookIdEqualTo(Integer value) {
            addCriterion("book_id =", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotEqualTo(Integer value) {
            addCriterion("book_id <>", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThan(Integer value) {
            addCriterion("book_id >", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_id >=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThan(Integer value) {
            addCriterion("book_id <", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThanOrEqualTo(Integer value) {
            addCriterion("book_id <=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdIn(List<Integer> values) {
            addCriterion("book_id in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotIn(List<Integer> values) {
            addCriterion("book_id not in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdBetween(Integer value1, Integer value2) {
            addCriterion("book_id between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotBetween(Integer value1, Integer value2) {
            addCriterion("book_id not between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNull() {
            addCriterion("book_name is null");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNotNull() {
            addCriterion("book_name is not null");
            return (Criteria) this;
        }

        public Criteria andBookNameEqualTo(String value) {
            addCriterion("book_name =", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotEqualTo(String value) {
            addCriterion("book_name <>", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThan(String value) {
            addCriterion("book_name >", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("book_name >=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThan(String value) {
            addCriterion("book_name <", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThanOrEqualTo(String value) {
            addCriterion("book_name <=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLike(String value) {
            addCriterion("book_name like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotLike(String value) {
            addCriterion("book_name not like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameIn(List<String> values) {
            addCriterion("book_name in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotIn(List<String> values) {
            addCriterion("book_name not in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameBetween(String value1, String value2) {
            addCriterion("book_name between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotBetween(String value1, String value2) {
            addCriterion("book_name not between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookAuthorIsNull() {
            addCriterion("book_author is null");
            return (Criteria) this;
        }

        public Criteria andBookAuthorIsNotNull() {
            addCriterion("book_author is not null");
            return (Criteria) this;
        }

        public Criteria andBookAuthorEqualTo(String value) {
            addCriterion("book_author =", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotEqualTo(String value) {
            addCriterion("book_author <>", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorGreaterThan(String value) {
            addCriterion("book_author >", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("book_author >=", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorLessThan(String value) {
            addCriterion("book_author <", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorLessThanOrEqualTo(String value) {
            addCriterion("book_author <=", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorLike(String value) {
            addCriterion("book_author like", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotLike(String value) {
            addCriterion("book_author not like", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorIn(List<String> values) {
            addCriterion("book_author in", values, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotIn(List<String> values) {
            addCriterion("book_author not in", values, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorBetween(String value1, String value2) {
            addCriterion("book_author between", value1, value2, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotBetween(String value1, String value2) {
            addCriterion("book_author not between", value1, value2, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookPriceIsNull() {
            addCriterion("book_price is null");
            return (Criteria) this;
        }

        public Criteria andBookPriceIsNotNull() {
            addCriterion("book_price is not null");
            return (Criteria) this;
        }

        public Criteria andBookPriceEqualTo(String value) {
            addCriterion("book_price =", value, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceNotEqualTo(String value) {
            addCriterion("book_price <>", value, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceGreaterThan(String value) {
            addCriterion("book_price >", value, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceGreaterThanOrEqualTo(String value) {
            addCriterion("book_price >=", value, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceLessThan(String value) {
            addCriterion("book_price <", value, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceLessThanOrEqualTo(String value) {
            addCriterion("book_price <=", value, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceLike(String value) {
            addCriterion("book_price like", value, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceNotLike(String value) {
            addCriterion("book_price not like", value, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceIn(List<String> values) {
            addCriterion("book_price in", values, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceNotIn(List<String> values) {
            addCriterion("book_price not in", values, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceBetween(String value1, String value2) {
            addCriterion("book_price between", value1, value2, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceNotBetween(String value1, String value2) {
            addCriterion("book_price not between", value1, value2, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookCodeIsNull() {
            addCriterion("book_code is null");
            return (Criteria) this;
        }

        public Criteria andBookCodeIsNotNull() {
            addCriterion("book_code is not null");
            return (Criteria) this;
        }

        public Criteria andBookCodeEqualTo(String value) {
            addCriterion("book_code =", value, "bookCode");
            return (Criteria) this;
        }

        public Criteria andBookCodeNotEqualTo(String value) {
            addCriterion("book_code <>", value, "bookCode");
            return (Criteria) this;
        }

        public Criteria andBookCodeGreaterThan(String value) {
            addCriterion("book_code >", value, "bookCode");
            return (Criteria) this;
        }

        public Criteria andBookCodeGreaterThanOrEqualTo(String value) {
            addCriterion("book_code >=", value, "bookCode");
            return (Criteria) this;
        }

        public Criteria andBookCodeLessThan(String value) {
            addCriterion("book_code <", value, "bookCode");
            return (Criteria) this;
        }

        public Criteria andBookCodeLessThanOrEqualTo(String value) {
            addCriterion("book_code <=", value, "bookCode");
            return (Criteria) this;
        }

        public Criteria andBookCodeLike(String value) {
            addCriterion("book_code like", value, "bookCode");
            return (Criteria) this;
        }

        public Criteria andBookCodeNotLike(String value) {
            addCriterion("book_code not like", value, "bookCode");
            return (Criteria) this;
        }

        public Criteria andBookCodeIn(List<String> values) {
            addCriterion("book_code in", values, "bookCode");
            return (Criteria) this;
        }

        public Criteria andBookCodeNotIn(List<String> values) {
            addCriterion("book_code not in", values, "bookCode");
            return (Criteria) this;
        }

        public Criteria andBookCodeBetween(String value1, String value2) {
            addCriterion("book_code between", value1, value2, "bookCode");
            return (Criteria) this;
        }

        public Criteria andBookCodeNotBetween(String value1, String value2) {
            addCriterion("book_code not between", value1, value2, "bookCode");
            return (Criteria) this;
        }

        public Criteria andBookPressIsNull() {
            addCriterion("book_press is null");
            return (Criteria) this;
        }

        public Criteria andBookPressIsNotNull() {
            addCriterion("book_press is not null");
            return (Criteria) this;
        }

        public Criteria andBookPressEqualTo(String value) {
            addCriterion("book_press =", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressNotEqualTo(String value) {
            addCriterion("book_press <>", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressGreaterThan(String value) {
            addCriterion("book_press >", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressGreaterThanOrEqualTo(String value) {
            addCriterion("book_press >=", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressLessThan(String value) {
            addCriterion("book_press <", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressLessThanOrEqualTo(String value) {
            addCriterion("book_press <=", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressLike(String value) {
            addCriterion("book_press like", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressNotLike(String value) {
            addCriterion("book_press not like", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressIn(List<String> values) {
            addCriterion("book_press in", values, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressNotIn(List<String> values) {
            addCriterion("book_press not in", values, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressBetween(String value1, String value2) {
            addCriterion("book_press between", value1, value2, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressNotBetween(String value1, String value2) {
            addCriterion("book_press not between", value1, value2, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookTimeIsNull() {
            addCriterion("book_time is null");
            return (Criteria) this;
        }

        public Criteria andBookTimeIsNotNull() {
            addCriterion("book_time is not null");
            return (Criteria) this;
        }

        public Criteria andBookTimeEqualTo(Date value) {
            addCriterion("book_time =", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeNotEqualTo(Date value) {
            addCriterion("book_time <>", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeGreaterThan(Date value) {
            addCriterion("book_time >", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("book_time >=", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeLessThan(Date value) {
            addCriterion("book_time <", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeLessThanOrEqualTo(Date value) {
            addCriterion("book_time <=", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeIn(List<Date> values) {
            addCriterion("book_time in", values, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeNotIn(List<Date> values) {
            addCriterion("book_time not in", values, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeBetween(Date value1, Date value2) {
            addCriterion("book_time between", value1, value2, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeNotBetween(Date value1, Date value2) {
            addCriterion("book_time not between", value1, value2, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookRecomendNumIsNull() {
            addCriterion("book_recomend_num is null");
            return (Criteria) this;
        }

        public Criteria andBookRecomendNumIsNotNull() {
            addCriterion("book_recomend_num is not null");
            return (Criteria) this;
        }

        public Criteria andBookRecomendNumEqualTo(Integer value) {
            addCriterion("book_recomend_num =", value, "bookRecomendNum");
            return (Criteria) this;
        }

        public Criteria andBookRecomendNumNotEqualTo(Integer value) {
            addCriterion("book_recomend_num <>", value, "bookRecomendNum");
            return (Criteria) this;
        }

        public Criteria andBookRecomendNumGreaterThan(Integer value) {
            addCriterion("book_recomend_num >", value, "bookRecomendNum");
            return (Criteria) this;
        }

        public Criteria andBookRecomendNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_recomend_num >=", value, "bookRecomendNum");
            return (Criteria) this;
        }

        public Criteria andBookRecomendNumLessThan(Integer value) {
            addCriterion("book_recomend_num <", value, "bookRecomendNum");
            return (Criteria) this;
        }

        public Criteria andBookRecomendNumLessThanOrEqualTo(Integer value) {
            addCriterion("book_recomend_num <=", value, "bookRecomendNum");
            return (Criteria) this;
        }

        public Criteria andBookRecomendNumIn(List<Integer> values) {
            addCriterion("book_recomend_num in", values, "bookRecomendNum");
            return (Criteria) this;
        }

        public Criteria andBookRecomendNumNotIn(List<Integer> values) {
            addCriterion("book_recomend_num not in", values, "bookRecomendNum");
            return (Criteria) this;
        }

        public Criteria andBookRecomendNumBetween(Integer value1, Integer value2) {
            addCriterion("book_recomend_num between", value1, value2, "bookRecomendNum");
            return (Criteria) this;
        }

        public Criteria andBookRecomendNumNotBetween(Integer value1, Integer value2) {
            addCriterion("book_recomend_num not between", value1, value2, "bookRecomendNum");
            return (Criteria) this;
        }

        public Criteria andBookPicIsNull() {
            addCriterion("book_pic is null");
            return (Criteria) this;
        }

        public Criteria andBookPicIsNotNull() {
            addCriterion("book_pic is not null");
            return (Criteria) this;
        }

        public Criteria andBookPicEqualTo(String value) {
            addCriterion("book_pic =", value, "bookPic");
            return (Criteria) this;
        }

        public Criteria andBookPicNotEqualTo(String value) {
            addCriterion("book_pic <>", value, "bookPic");
            return (Criteria) this;
        }

        public Criteria andBookPicGreaterThan(String value) {
            addCriterion("book_pic >", value, "bookPic");
            return (Criteria) this;
        }

        public Criteria andBookPicGreaterThanOrEqualTo(String value) {
            addCriterion("book_pic >=", value, "bookPic");
            return (Criteria) this;
        }

        public Criteria andBookPicLessThan(String value) {
            addCriterion("book_pic <", value, "bookPic");
            return (Criteria) this;
        }

        public Criteria andBookPicLessThanOrEqualTo(String value) {
            addCriterion("book_pic <=", value, "bookPic");
            return (Criteria) this;
        }

        public Criteria andBookPicLike(String value) {
            addCriterion("book_pic like", value, "bookPic");
            return (Criteria) this;
        }

        public Criteria andBookPicNotLike(String value) {
            addCriterion("book_pic not like", value, "bookPic");
            return (Criteria) this;
        }

        public Criteria andBookPicIn(List<String> values) {
            addCriterion("book_pic in", values, "bookPic");
            return (Criteria) this;
        }

        public Criteria andBookPicNotIn(List<String> values) {
            addCriterion("book_pic not in", values, "bookPic");
            return (Criteria) this;
        }

        public Criteria andBookPicBetween(String value1, String value2) {
            addCriterion("book_pic between", value1, value2, "bookPic");
            return (Criteria) this;
        }

        public Criteria andBookPicNotBetween(String value1, String value2) {
            addCriterion("book_pic not between", value1, value2, "bookPic");
            return (Criteria) this;
        }

        public Criteria andBookLevelIsNull() {
            addCriterion("book_level is null");
            return (Criteria) this;
        }

        public Criteria andBookLevelIsNotNull() {
            addCriterion("book_level is not null");
            return (Criteria) this;
        }

        public Criteria andBookLevelEqualTo(String value) {
            addCriterion("book_level =", value, "bookLevel");
            return (Criteria) this;
        }

        public Criteria andBookLevelNotEqualTo(String value) {
            addCriterion("book_level <>", value, "bookLevel");
            return (Criteria) this;
        }

        public Criteria andBookLevelGreaterThan(String value) {
            addCriterion("book_level >", value, "bookLevel");
            return (Criteria) this;
        }

        public Criteria andBookLevelGreaterThanOrEqualTo(String value) {
            addCriterion("book_level >=", value, "bookLevel");
            return (Criteria) this;
        }

        public Criteria andBookLevelLessThan(String value) {
            addCriterion("book_level <", value, "bookLevel");
            return (Criteria) this;
        }

        public Criteria andBookLevelLessThanOrEqualTo(String value) {
            addCriterion("book_level <=", value, "bookLevel");
            return (Criteria) this;
        }

        public Criteria andBookLevelLike(String value) {
            addCriterion("book_level like", value, "bookLevel");
            return (Criteria) this;
        }

        public Criteria andBookLevelNotLike(String value) {
            addCriterion("book_level not like", value, "bookLevel");
            return (Criteria) this;
        }

        public Criteria andBookLevelIn(List<String> values) {
            addCriterion("book_level in", values, "bookLevel");
            return (Criteria) this;
        }

        public Criteria andBookLevelNotIn(List<String> values) {
            addCriterion("book_level not in", values, "bookLevel");
            return (Criteria) this;
        }

        public Criteria andBookLevelBetween(String value1, String value2) {
            addCriterion("book_level between", value1, value2, "bookLevel");
            return (Criteria) this;
        }

        public Criteria andBookLevelNotBetween(String value1, String value2) {
            addCriterion("book_level not between", value1, value2, "bookLevel");
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