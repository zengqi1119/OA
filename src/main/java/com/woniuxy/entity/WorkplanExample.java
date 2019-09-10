package com.woniuxy.entity;

import java.util.ArrayList;
import java.util.List;

public class WorkplanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkplanExample() {
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

        public Criteria andWidIsNull() {
            addCriterion("wid is null");
            return (Criteria) this;
        }

        public Criteria andWidIsNotNull() {
            addCriterion("wid is not null");
            return (Criteria) this;
        }

        public Criteria andWidEqualTo(Integer value) {
            addCriterion("wid =", value, "wid");
            return (Criteria) this;
        }

        public Criteria andWidNotEqualTo(Integer value) {
            addCriterion("wid <>", value, "wid");
            return (Criteria) this;
        }

        public Criteria andWidGreaterThan(Integer value) {
            addCriterion("wid >", value, "wid");
            return (Criteria) this;
        }

        public Criteria andWidGreaterThanOrEqualTo(Integer value) {
            addCriterion("wid >=", value, "wid");
            return (Criteria) this;
        }

        public Criteria andWidLessThan(Integer value) {
            addCriterion("wid <", value, "wid");
            return (Criteria) this;
        }

        public Criteria andWidLessThanOrEqualTo(Integer value) {
            addCriterion("wid <=", value, "wid");
            return (Criteria) this;
        }

        public Criteria andWidIn(List<Integer> values) {
            addCriterion("wid in", values, "wid");
            return (Criteria) this;
        }

        public Criteria andWidNotIn(List<Integer> values) {
            addCriterion("wid not in", values, "wid");
            return (Criteria) this;
        }

        public Criteria andWidBetween(Integer value1, Integer value2) {
            addCriterion("wid between", value1, value2, "wid");
            return (Criteria) this;
        }

        public Criteria andWidNotBetween(Integer value1, Integer value2) {
            addCriterion("wid not between", value1, value2, "wid");
            return (Criteria) this;
        }

        public Criteria andDidIsNull() {
            addCriterion("did is null");
            return (Criteria) this;
        }

        public Criteria andDidIsNotNull() {
            addCriterion("did is not null");
            return (Criteria) this;
        }

        public Criteria andDidEqualTo(Integer value) {
            addCriterion("did =", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotEqualTo(Integer value) {
            addCriterion("did <>", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThan(Integer value) {
            addCriterion("did >", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThanOrEqualTo(Integer value) {
            addCriterion("did >=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThan(Integer value) {
            addCriterion("did <", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThanOrEqualTo(Integer value) {
            addCriterion("did <=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidIn(List<Integer> values) {
            addCriterion("did in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotIn(List<Integer> values) {
            addCriterion("did not in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidBetween(Integer value1, Integer value2) {
            addCriterion("did between", value1, value2, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotBetween(Integer value1, Integer value2) {
            addCriterion("did not between", value1, value2, "did");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andWeeksumIsNull() {
            addCriterion("weeksum is null");
            return (Criteria) this;
        }

        public Criteria andWeeksumIsNotNull() {
            addCriterion("weeksum is not null");
            return (Criteria) this;
        }

        public Criteria andWeeksumEqualTo(String value) {
            addCriterion("weeksum =", value, "weeksum");
            return (Criteria) this;
        }

        public Criteria andWeeksumNotEqualTo(String value) {
            addCriterion("weeksum <>", value, "weeksum");
            return (Criteria) this;
        }

        public Criteria andWeeksumGreaterThan(String value) {
            addCriterion("weeksum >", value, "weeksum");
            return (Criteria) this;
        }

        public Criteria andWeeksumGreaterThanOrEqualTo(String value) {
            addCriterion("weeksum >=", value, "weeksum");
            return (Criteria) this;
        }

        public Criteria andWeeksumLessThan(String value) {
            addCriterion("weeksum <", value, "weeksum");
            return (Criteria) this;
        }

        public Criteria andWeeksumLessThanOrEqualTo(String value) {
            addCriterion("weeksum <=", value, "weeksum");
            return (Criteria) this;
        }

        public Criteria andWeeksumLike(String value) {
            addCriterion("weeksum like", value, "weeksum");
            return (Criteria) this;
        }

        public Criteria andWeeksumNotLike(String value) {
            addCriterion("weeksum not like", value, "weeksum");
            return (Criteria) this;
        }

        public Criteria andWeeksumIn(List<String> values) {
            addCriterion("weeksum in", values, "weeksum");
            return (Criteria) this;
        }

        public Criteria andWeeksumNotIn(List<String> values) {
            addCriterion("weeksum not in", values, "weeksum");
            return (Criteria) this;
        }

        public Criteria andWeeksumBetween(String value1, String value2) {
            addCriterion("weeksum between", value1, value2, "weeksum");
            return (Criteria) this;
        }

        public Criteria andWeeksumNotBetween(String value1, String value2) {
            addCriterion("weeksum not between", value1, value2, "weeksum");
            return (Criteria) this;
        }

        public Criteria andWeekqueIsNull() {
            addCriterion("weekque is null");
            return (Criteria) this;
        }

        public Criteria andWeekqueIsNotNull() {
            addCriterion("weekque is not null");
            return (Criteria) this;
        }

        public Criteria andWeekqueEqualTo(String value) {
            addCriterion("weekque =", value, "weekque");
            return (Criteria) this;
        }

        public Criteria andWeekqueNotEqualTo(String value) {
            addCriterion("weekque <>", value, "weekque");
            return (Criteria) this;
        }

        public Criteria andWeekqueGreaterThan(String value) {
            addCriterion("weekque >", value, "weekque");
            return (Criteria) this;
        }

        public Criteria andWeekqueGreaterThanOrEqualTo(String value) {
            addCriterion("weekque >=", value, "weekque");
            return (Criteria) this;
        }

        public Criteria andWeekqueLessThan(String value) {
            addCriterion("weekque <", value, "weekque");
            return (Criteria) this;
        }

        public Criteria andWeekqueLessThanOrEqualTo(String value) {
            addCriterion("weekque <=", value, "weekque");
            return (Criteria) this;
        }

        public Criteria andWeekqueLike(String value) {
            addCriterion("weekque like", value, "weekque");
            return (Criteria) this;
        }

        public Criteria andWeekqueNotLike(String value) {
            addCriterion("weekque not like", value, "weekque");
            return (Criteria) this;
        }

        public Criteria andWeekqueIn(List<String> values) {
            addCriterion("weekque in", values, "weekque");
            return (Criteria) this;
        }

        public Criteria andWeekqueNotIn(List<String> values) {
            addCriterion("weekque not in", values, "weekque");
            return (Criteria) this;
        }

        public Criteria andWeekqueBetween(String value1, String value2) {
            addCriterion("weekque between", value1, value2, "weekque");
            return (Criteria) this;
        }

        public Criteria andWeekqueNotBetween(String value1, String value2) {
            addCriterion("weekque not between", value1, value2, "weekque");
            return (Criteria) this;
        }

        public Criteria andWeekplanIsNull() {
            addCriterion("weekplan is null");
            return (Criteria) this;
        }

        public Criteria andWeekplanIsNotNull() {
            addCriterion("weekplan is not null");
            return (Criteria) this;
        }

        public Criteria andWeekplanEqualTo(String value) {
            addCriterion("weekplan =", value, "weekplan");
            return (Criteria) this;
        }

        public Criteria andWeekplanNotEqualTo(String value) {
            addCriterion("weekplan <>", value, "weekplan");
            return (Criteria) this;
        }

        public Criteria andWeekplanGreaterThan(String value) {
            addCriterion("weekplan >", value, "weekplan");
            return (Criteria) this;
        }

        public Criteria andWeekplanGreaterThanOrEqualTo(String value) {
            addCriterion("weekplan >=", value, "weekplan");
            return (Criteria) this;
        }

        public Criteria andWeekplanLessThan(String value) {
            addCriterion("weekplan <", value, "weekplan");
            return (Criteria) this;
        }

        public Criteria andWeekplanLessThanOrEqualTo(String value) {
            addCriterion("weekplan <=", value, "weekplan");
            return (Criteria) this;
        }

        public Criteria andWeekplanLike(String value) {
            addCriterion("weekplan like", value, "weekplan");
            return (Criteria) this;
        }

        public Criteria andWeekplanNotLike(String value) {
            addCriterion("weekplan not like", value, "weekplan");
            return (Criteria) this;
        }

        public Criteria andWeekplanIn(List<String> values) {
            addCriterion("weekplan in", values, "weekplan");
            return (Criteria) this;
        }

        public Criteria andWeekplanNotIn(List<String> values) {
            addCriterion("weekplan not in", values, "weekplan");
            return (Criteria) this;
        }

        public Criteria andWeekplanBetween(String value1, String value2) {
            addCriterion("weekplan between", value1, value2, "weekplan");
            return (Criteria) this;
        }

        public Criteria andWeekplanNotBetween(String value1, String value2) {
            addCriterion("weekplan not between", value1, value2, "weekplan");
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