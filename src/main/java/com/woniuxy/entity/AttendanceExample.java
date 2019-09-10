package com.woniuxy.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AttendanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttendanceExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(Integer value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(Integer value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(Integer value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(Integer value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(Integer value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<Integer> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<Integer> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(Integer value1, Integer value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(Integer value1, Integer value2) {
            addCriterion("sid not between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andAmtimeIsNull() {
            addCriterion("amtime is null");
            return (Criteria) this;
        }

        public Criteria andAmtimeIsNotNull() {
            addCriterion("amtime is not null");
            return (Criteria) this;
        }

        public Criteria andAmtimeEqualTo(Date value) {
            addCriterionForJDBCTime("amtime =", value, "amtime");
            return (Criteria) this;
        }

        public Criteria andAmtimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("amtime <>", value, "amtime");
            return (Criteria) this;
        }

        public Criteria andAmtimeGreaterThan(Date value) {
            addCriterionForJDBCTime("amtime >", value, "amtime");
            return (Criteria) this;
        }

        public Criteria andAmtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("amtime >=", value, "amtime");
            return (Criteria) this;
        }

        public Criteria andAmtimeLessThan(Date value) {
            addCriterionForJDBCTime("amtime <", value, "amtime");
            return (Criteria) this;
        }

        public Criteria andAmtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("amtime <=", value, "amtime");
            return (Criteria) this;
        }

        public Criteria andAmtimeIn(List<Date> values) {
            addCriterionForJDBCTime("amtime in", values, "amtime");
            return (Criteria) this;
        }

        public Criteria andAmtimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("amtime not in", values, "amtime");
            return (Criteria) this;
        }

        public Criteria andAmtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("amtime between", value1, value2, "amtime");
            return (Criteria) this;
        }

        public Criteria andAmtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("amtime not between", value1, value2, "amtime");
            return (Criteria) this;
        }

        public Criteria andNoonbegintimeIsNull() {
            addCriterion("noonbegintime is null");
            return (Criteria) this;
        }

        public Criteria andNoonbegintimeIsNotNull() {
            addCriterion("noonbegintime is not null");
            return (Criteria) this;
        }

        public Criteria andNoonbegintimeEqualTo(Date value) {
            addCriterionForJDBCTime("noonbegintime =", value, "noonbegintime");
            return (Criteria) this;
        }

        public Criteria andNoonbegintimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("noonbegintime <>", value, "noonbegintime");
            return (Criteria) this;
        }

        public Criteria andNoonbegintimeGreaterThan(Date value) {
            addCriterionForJDBCTime("noonbegintime >", value, "noonbegintime");
            return (Criteria) this;
        }

        public Criteria andNoonbegintimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("noonbegintime >=", value, "noonbegintime");
            return (Criteria) this;
        }

        public Criteria andNoonbegintimeLessThan(Date value) {
            addCriterionForJDBCTime("noonbegintime <", value, "noonbegintime");
            return (Criteria) this;
        }

        public Criteria andNoonbegintimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("noonbegintime <=", value, "noonbegintime");
            return (Criteria) this;
        }

        public Criteria andNoonbegintimeIn(List<Date> values) {
            addCriterionForJDBCTime("noonbegintime in", values, "noonbegintime");
            return (Criteria) this;
        }

        public Criteria andNoonbegintimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("noonbegintime not in", values, "noonbegintime");
            return (Criteria) this;
        }

        public Criteria andNoonbegintimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("noonbegintime between", value1, value2, "noonbegintime");
            return (Criteria) this;
        }

        public Criteria andNoonbegintimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("noonbegintime not between", value1, value2, "noonbegintime");
            return (Criteria) this;
        }

        public Criteria andNoonendtimeIsNull() {
            addCriterion("noonendtime is null");
            return (Criteria) this;
        }

        public Criteria andNoonendtimeIsNotNull() {
            addCriterion("noonendtime is not null");
            return (Criteria) this;
        }

        public Criteria andNoonendtimeEqualTo(Date value) {
            addCriterionForJDBCTime("noonendtime =", value, "noonendtime");
            return (Criteria) this;
        }

        public Criteria andNoonendtimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("noonendtime <>", value, "noonendtime");
            return (Criteria) this;
        }

        public Criteria andNoonendtimeGreaterThan(Date value) {
            addCriterionForJDBCTime("noonendtime >", value, "noonendtime");
            return (Criteria) this;
        }

        public Criteria andNoonendtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("noonendtime >=", value, "noonendtime");
            return (Criteria) this;
        }

        public Criteria andNoonendtimeLessThan(Date value) {
            addCriterionForJDBCTime("noonendtime <", value, "noonendtime");
            return (Criteria) this;
        }

        public Criteria andNoonendtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("noonendtime <=", value, "noonendtime");
            return (Criteria) this;
        }

        public Criteria andNoonendtimeIn(List<Date> values) {
            addCriterionForJDBCTime("noonendtime in", values, "noonendtime");
            return (Criteria) this;
        }

        public Criteria andNoonendtimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("noonendtime not in", values, "noonendtime");
            return (Criteria) this;
        }

        public Criteria andNoonendtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("noonendtime between", value1, value2, "noonendtime");
            return (Criteria) this;
        }

        public Criteria andNoonendtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("noonendtime not between", value1, value2, "noonendtime");
            return (Criteria) this;
        }

        public Criteria andPmtimeIsNull() {
            addCriterion("pmtime is null");
            return (Criteria) this;
        }

        public Criteria andPmtimeIsNotNull() {
            addCriterion("pmtime is not null");
            return (Criteria) this;
        }

        public Criteria andPmtimeEqualTo(Date value) {
            addCriterionForJDBCTime("pmtime =", value, "pmtime");
            return (Criteria) this;
        }

        public Criteria andPmtimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("pmtime <>", value, "pmtime");
            return (Criteria) this;
        }

        public Criteria andPmtimeGreaterThan(Date value) {
            addCriterionForJDBCTime("pmtime >", value, "pmtime");
            return (Criteria) this;
        }

        public Criteria andPmtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("pmtime >=", value, "pmtime");
            return (Criteria) this;
        }

        public Criteria andPmtimeLessThan(Date value) {
            addCriterionForJDBCTime("pmtime <", value, "pmtime");
            return (Criteria) this;
        }

        public Criteria andPmtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("pmtime <=", value, "pmtime");
            return (Criteria) this;
        }

        public Criteria andPmtimeIn(List<Date> values) {
            addCriterionForJDBCTime("pmtime in", values, "pmtime");
            return (Criteria) this;
        }

        public Criteria andPmtimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("pmtime not in", values, "pmtime");
            return (Criteria) this;
        }

        public Criteria andPmtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("pmtime between", value1, value2, "pmtime");
            return (Criteria) this;
        }

        public Criteria andPmtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("pmtime not between", value1, value2, "pmtime");
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