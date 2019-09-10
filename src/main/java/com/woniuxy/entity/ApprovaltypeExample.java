package com.woniuxy.entity;

import java.util.ArrayList;
import java.util.List;

public class ApprovaltypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApprovaltypeExample() {
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

        public Criteria andAptidIsNull() {
            addCriterion("aptid is null");
            return (Criteria) this;
        }

        public Criteria andAptidIsNotNull() {
            addCriterion("aptid is not null");
            return (Criteria) this;
        }

        public Criteria andAptidEqualTo(Integer value) {
            addCriterion("aptid =", value, "aptid");
            return (Criteria) this;
        }

        public Criteria andAptidNotEqualTo(Integer value) {
            addCriterion("aptid <>", value, "aptid");
            return (Criteria) this;
        }

        public Criteria andAptidGreaterThan(Integer value) {
            addCriterion("aptid >", value, "aptid");
            return (Criteria) this;
        }

        public Criteria andAptidGreaterThanOrEqualTo(Integer value) {
            addCriterion("aptid >=", value, "aptid");
            return (Criteria) this;
        }

        public Criteria andAptidLessThan(Integer value) {
            addCriterion("aptid <", value, "aptid");
            return (Criteria) this;
        }

        public Criteria andAptidLessThanOrEqualTo(Integer value) {
            addCriterion("aptid <=", value, "aptid");
            return (Criteria) this;
        }

        public Criteria andAptidIn(List<Integer> values) {
            addCriterion("aptid in", values, "aptid");
            return (Criteria) this;
        }

        public Criteria andAptidNotIn(List<Integer> values) {
            addCriterion("aptid not in", values, "aptid");
            return (Criteria) this;
        }

        public Criteria andAptidBetween(Integer value1, Integer value2) {
            addCriterion("aptid between", value1, value2, "aptid");
            return (Criteria) this;
        }

        public Criteria andAptidNotBetween(Integer value1, Integer value2) {
            addCriterion("aptid not between", value1, value2, "aptid");
            return (Criteria) this;
        }

        public Criteria andAptypeIsNull() {
            addCriterion("aptype is null");
            return (Criteria) this;
        }

        public Criteria andAptypeIsNotNull() {
            addCriterion("aptype is not null");
            return (Criteria) this;
        }

        public Criteria andAptypeEqualTo(String value) {
            addCriterion("aptype =", value, "aptype");
            return (Criteria) this;
        }

        public Criteria andAptypeNotEqualTo(String value) {
            addCriterion("aptype <>", value, "aptype");
            return (Criteria) this;
        }

        public Criteria andAptypeGreaterThan(String value) {
            addCriterion("aptype >", value, "aptype");
            return (Criteria) this;
        }

        public Criteria andAptypeGreaterThanOrEqualTo(String value) {
            addCriterion("aptype >=", value, "aptype");
            return (Criteria) this;
        }

        public Criteria andAptypeLessThan(String value) {
            addCriterion("aptype <", value, "aptype");
            return (Criteria) this;
        }

        public Criteria andAptypeLessThanOrEqualTo(String value) {
            addCriterion("aptype <=", value, "aptype");
            return (Criteria) this;
        }

        public Criteria andAptypeLike(String value) {
            addCriterion("aptype like", value, "aptype");
            return (Criteria) this;
        }

        public Criteria andAptypeNotLike(String value) {
            addCriterion("aptype not like", value, "aptype");
            return (Criteria) this;
        }

        public Criteria andAptypeIn(List<String> values) {
            addCriterion("aptype in", values, "aptype");
            return (Criteria) this;
        }

        public Criteria andAptypeNotIn(List<String> values) {
            addCriterion("aptype not in", values, "aptype");
            return (Criteria) this;
        }

        public Criteria andAptypeBetween(String value1, String value2) {
            addCriterion("aptype between", value1, value2, "aptype");
            return (Criteria) this;
        }

        public Criteria andAptypeNotBetween(String value1, String value2) {
            addCriterion("aptype not between", value1, value2, "aptype");
            return (Criteria) this;
        }

        public Criteria andTablenameIsNull() {
            addCriterion("tablename is null");
            return (Criteria) this;
        }

        public Criteria andTablenameIsNotNull() {
            addCriterion("tablename is not null");
            return (Criteria) this;
        }

        public Criteria andTablenameEqualTo(String value) {
            addCriterion("tablename =", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotEqualTo(String value) {
            addCriterion("tablename <>", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThan(String value) {
            addCriterion("tablename >", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThanOrEqualTo(String value) {
            addCriterion("tablename >=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThan(String value) {
            addCriterion("tablename <", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThanOrEqualTo(String value) {
            addCriterion("tablename <=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLike(String value) {
            addCriterion("tablename like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotLike(String value) {
            addCriterion("tablename not like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameIn(List<String> values) {
            addCriterion("tablename in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotIn(List<String> values) {
            addCriterion("tablename not in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameBetween(String value1, String value2) {
            addCriterion("tablename between", value1, value2, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotBetween(String value1, String value2) {
            addCriterion("tablename not between", value1, value2, "tablename");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Integer value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Integer value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Integer value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Integer value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Integer value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Integer> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Integer> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Integer value1, Integer value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("flag not between", value1, value2, "flag");
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