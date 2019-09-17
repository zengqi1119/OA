package com.woniuxy.entity;

import java.util.ArrayList;
import java.util.List;

public class RolepermissiontableExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;
	private Integer pageIndex;
	private Integer pageSize;

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public RolepermissiontableExample() {
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

		public Criteria andUnameIsNull() {
			addCriterion("uname is null");
			return (Criteria) this;
		}

		public Criteria andUnameIsNotNull() {
			addCriterion("uname is not null");
			return (Criteria) this;
		}

		public Criteria andUnameEqualTo(String value) {
			addCriterion("uname =", value, "uname");
			return (Criteria) this;
		}

		public Criteria andUnameNotEqualTo(String value) {
			addCriterion("uname <>", value, "uname");
			return (Criteria) this;
		}

		public Criteria andUnameGreaterThan(String value) {
			addCriterion("uname >", value, "uname");
			return (Criteria) this;
		}

		public Criteria andUnameGreaterThanOrEqualTo(String value) {
			addCriterion("uname >=", value, "uname");
			return (Criteria) this;
		}

		public Criteria andUnameLessThan(String value) {
			addCriterion("uname <", value, "uname");
			return (Criteria) this;
		}

		public Criteria andUnameLessThanOrEqualTo(String value) {
			addCriterion("uname <=", value, "uname");
			return (Criteria) this;
		}

		public Criteria andUnameLike(String value) {
			addCriterion("uname like", value, "uname");
			return (Criteria) this;
		}

		public Criteria andUnameNotLike(String value) {
			addCriterion("uname not like", value, "uname");
			return (Criteria) this;
		}

		public Criteria andUnameIn(List<String> values) {
			addCriterion("uname in", values, "uname");
			return (Criteria) this;
		}

		public Criteria andUnameNotIn(List<String> values) {
			addCriterion("uname not in", values, "uname");
			return (Criteria) this;
		}

		public Criteria andUnameBetween(String value1, String value2) {
			addCriterion("uname between", value1, value2, "uname");
			return (Criteria) this;
		}

		public Criteria andUnameNotBetween(String value1, String value2) {
			addCriterion("uname not between", value1, value2, "uname");
			return (Criteria) this;
		}

		public Criteria andAccountIsNull() {
			addCriterion("account is null");
			return (Criteria) this;
		}

		public Criteria andAccountIsNotNull() {
			addCriterion("account is not null");
			return (Criteria) this;
		}

		public Criteria andAccountEqualTo(String value) {
			addCriterion("account =", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountNotEqualTo(String value) {
			addCriterion("account <>", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountGreaterThan(String value) {
			addCriterion("account >", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountGreaterThanOrEqualTo(String value) {
			addCriterion("account >=", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountLessThan(String value) {
			addCriterion("account <", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountLessThanOrEqualTo(String value) {
			addCriterion("account <=", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountLike(String value) {
			addCriterion("account like", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountNotLike(String value) {
			addCriterion("account not like", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountIn(List<String> values) {
			addCriterion("account in", values, "account");
			return (Criteria) this;
		}

		public Criteria andAccountNotIn(List<String> values) {
			addCriterion("account not in", values, "account");
			return (Criteria) this;
		}

		public Criteria andAccountBetween(String value1, String value2) {
			addCriterion("account between", value1, value2, "account");
			return (Criteria) this;
		}

		public Criteria andAccountNotBetween(String value1, String value2) {
			addCriterion("account not between", value1, value2, "account");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNull() {
			addCriterion("password is null");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNotNull() {
			addCriterion("password is not null");
			return (Criteria) this;
		}

		public Criteria andPasswordEqualTo(String value) {
			addCriterion("password =", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotEqualTo(String value) {
			addCriterion("password <>", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThan(String value) {
			addCriterion("password >", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("password >=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThan(String value) {
			addCriterion("password <", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThanOrEqualTo(String value) {
			addCriterion("password <=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLike(String value) {
			addCriterion("password like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotLike(String value) {
			addCriterion("password not like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordIn(List<String> values) {
			addCriterion("password in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotIn(List<String> values) {
			addCriterion("password not in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordBetween(String value1, String value2) {
			addCriterion("password between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotBetween(String value1, String value2) {
			addCriterion("password not between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andRidIsNull() {
			addCriterion("rid is null");
			return (Criteria) this;
		}

		public Criteria andRidIsNotNull() {
			addCriterion("rid is not null");
			return (Criteria) this;
		}

		public Criteria andRidEqualTo(Integer value) {
			addCriterion("rid =", value, "rid");
			return (Criteria) this;
		}

		public Criteria andRidNotEqualTo(Integer value) {
			addCriterion("rid <>", value, "rid");
			return (Criteria) this;
		}

		public Criteria andRidGreaterThan(Integer value) {
			addCriterion("rid >", value, "rid");
			return (Criteria) this;
		}

		public Criteria andRidGreaterThanOrEqualTo(Integer value) {
			addCriterion("rid >=", value, "rid");
			return (Criteria) this;
		}

		public Criteria andRidLessThan(Integer value) {
			addCriterion("rid <", value, "rid");
			return (Criteria) this;
		}

		public Criteria andRidLessThanOrEqualTo(Integer value) {
			addCriterion("rid <=", value, "rid");
			return (Criteria) this;
		}

		public Criteria andRidIn(List<Integer> values) {
			addCriterion("rid in", values, "rid");
			return (Criteria) this;
		}

		public Criteria andRidNotIn(List<Integer> values) {
			addCriterion("rid not in", values, "rid");
			return (Criteria) this;
		}

		public Criteria andRidBetween(Integer value1, Integer value2) {
			addCriterion("rid between", value1, value2, "rid");
			return (Criteria) this;
		}

		public Criteria andRidNotBetween(Integer value1, Integer value2) {
			addCriterion("rid not between", value1, value2, "rid");
			return (Criteria) this;
		}

		public Criteria andRoleIsNull() {
			addCriterion("role is null");
			return (Criteria) this;
		}

		public Criteria andRoleIsNotNull() {
			addCriterion("role is not null");
			return (Criteria) this;
		}

		public Criteria andRoleEqualTo(String value) {
			addCriterion("role =", value, "role");
			return (Criteria) this;
		}

		public Criteria andRoleNotEqualTo(String value) {
			addCriterion("role <>", value, "role");
			return (Criteria) this;
		}

		public Criteria andRoleGreaterThan(String value) {
			addCriterion("role >", value, "role");
			return (Criteria) this;
		}

		public Criteria andRoleGreaterThanOrEqualTo(String value) {
			addCriterion("role >=", value, "role");
			return (Criteria) this;
		}

		public Criteria andRoleLessThan(String value) {
			addCriterion("role <", value, "role");
			return (Criteria) this;
		}

		public Criteria andRoleLessThanOrEqualTo(String value) {
			addCriterion("role <=", value, "role");
			return (Criteria) this;
		}

		public Criteria andRoleLike(String value) {
			addCriterion("role like", value, "role");
			return (Criteria) this;
		}

		public Criteria andRoleNotLike(String value) {
			addCriterion("role not like", value, "role");
			return (Criteria) this;
		}

		public Criteria andRoleIn(List<String> values) {
			addCriterion("role in", values, "role");
			return (Criteria) this;
		}

		public Criteria andRoleNotIn(List<String> values) {
			addCriterion("role not in", values, "role");
			return (Criteria) this;
		}

		public Criteria andRoleBetween(String value1, String value2) {
			addCriterion("role between", value1, value2, "role");
			return (Criteria) this;
		}

		public Criteria andRoleNotBetween(String value1, String value2) {
			addCriterion("role not between", value1, value2, "role");
			return (Criteria) this;
		}

		public Criteria andPidIsNull() {
			addCriterion("pid is null");
			return (Criteria) this;
		}

		public Criteria andPidIsNotNull() {
			addCriterion("pid is not null");
			return (Criteria) this;
		}

		public Criteria andPidEqualTo(Integer value) {
			addCriterion("pid =", value, "pid");
			return (Criteria) this;
		}

		public Criteria andPidNotEqualTo(Integer value) {
			addCriterion("pid <>", value, "pid");
			return (Criteria) this;
		}

		public Criteria andPidGreaterThan(Integer value) {
			addCriterion("pid >", value, "pid");
			return (Criteria) this;
		}

		public Criteria andPidGreaterThanOrEqualTo(Integer value) {
			addCriterion("pid >=", value, "pid");
			return (Criteria) this;
		}

		public Criteria andPidLessThan(Integer value) {
			addCriterion("pid <", value, "pid");
			return (Criteria) this;
		}

		public Criteria andPidLessThanOrEqualTo(Integer value) {
			addCriterion("pid <=", value, "pid");
			return (Criteria) this;
		}

		public Criteria andPidIn(List<Integer> values) {
			addCriterion("pid in", values, "pid");
			return (Criteria) this;
		}

		public Criteria andPidNotIn(List<Integer> values) {
			addCriterion("pid not in", values, "pid");
			return (Criteria) this;
		}

		public Criteria andPidBetween(Integer value1, Integer value2) {
			addCriterion("pid between", value1, value2, "pid");
			return (Criteria) this;
		}

		public Criteria andPidNotBetween(Integer value1, Integer value2) {
			addCriterion("pid not between", value1, value2, "pid");
			return (Criteria) this;
		}

		public Criteria andPnameIsNull() {
			addCriterion("pname is null");
			return (Criteria) this;
		}

		public Criteria andPnameIsNotNull() {
			addCriterion("pname is not null");
			return (Criteria) this;
		}

		public Criteria andPnameEqualTo(String value) {
			addCriterion("pname =", value, "pname");
			return (Criteria) this;
		}

		public Criteria andPnameNotEqualTo(String value) {
			addCriterion("pname <>", value, "pname");
			return (Criteria) this;
		}

		public Criteria andPnameGreaterThan(String value) {
			addCriterion("pname >", value, "pname");
			return (Criteria) this;
		}

		public Criteria andPnameGreaterThanOrEqualTo(String value) {
			addCriterion("pname >=", value, "pname");
			return (Criteria) this;
		}

		public Criteria andPnameLessThan(String value) {
			addCriterion("pname <", value, "pname");
			return (Criteria) this;
		}

		public Criteria andPnameLessThanOrEqualTo(String value) {
			addCriterion("pname <=", value, "pname");
			return (Criteria) this;
		}

		public Criteria andPnameLike(String value) {
			addCriterion("pname like", value, "pname");
			return (Criteria) this;
		}

		public Criteria andPnameNotLike(String value) {
			addCriterion("pname not like", value, "pname");
			return (Criteria) this;
		}

		public Criteria andPnameIn(List<String> values) {
			addCriterion("pname in", values, "pname");
			return (Criteria) this;
		}

		public Criteria andPnameNotIn(List<String> values) {
			addCriterion("pname not in", values, "pname");
			return (Criteria) this;
		}

		public Criteria andPnameBetween(String value1, String value2) {
			addCriterion("pname between", value1, value2, "pname");
			return (Criteria) this;
		}

		public Criteria andPnameNotBetween(String value1, String value2) {
			addCriterion("pname not between", value1, value2, "pname");
			return (Criteria) this;
		}

		public Criteria andUrlIsNull() {
			addCriterion("url is null");
			return (Criteria) this;
		}

		public Criteria andUrlIsNotNull() {
			addCriterion("url is not null");
			return (Criteria) this;
		}

		public Criteria andUrlEqualTo(String value) {
			addCriterion("url =", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotEqualTo(String value) {
			addCriterion("url <>", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlGreaterThan(String value) {
			addCriterion("url >", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlGreaterThanOrEqualTo(String value) {
			addCriterion("url >=", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlLessThan(String value) {
			addCriterion("url <", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlLessThanOrEqualTo(String value) {
			addCriterion("url <=", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlLike(String value) {
			addCriterion("url like", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotLike(String value) {
			addCriterion("url not like", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlIn(List<String> values) {
			addCriterion("url in", values, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotIn(List<String> values) {
			addCriterion("url not in", values, "url");
			return (Criteria) this;
		}

		public Criteria andUrlBetween(String value1, String value2) {
			addCriterion("url between", value1, value2, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotBetween(String value1, String value2) {
			addCriterion("url not between", value1, value2, "url");
			return (Criteria) this;
		}

		public Criteria andPrivilegeIsNull() {
			addCriterion("privilege is null");
			return (Criteria) this;
		}

		public Criteria andPrivilegeIsNotNull() {
			addCriterion("privilege is not null");
			return (Criteria) this;
		}

		public Criteria andPrivilegeEqualTo(String value) {
			addCriterion("privilege =", value, "privilege");
			return (Criteria) this;
		}

		public Criteria andPrivilegeNotEqualTo(String value) {
			addCriterion("privilege <>", value, "privilege");
			return (Criteria) this;
		}

		public Criteria andPrivilegeGreaterThan(String value) {
			addCriterion("privilege >", value, "privilege");
			return (Criteria) this;
		}

		public Criteria andPrivilegeGreaterThanOrEqualTo(String value) {
			addCriterion("privilege >=", value, "privilege");
			return (Criteria) this;
		}

		public Criteria andPrivilegeLessThan(String value) {
			addCriterion("privilege <", value, "privilege");
			return (Criteria) this;
		}

		public Criteria andPrivilegeLessThanOrEqualTo(String value) {
			addCriterion("privilege <=", value, "privilege");
			return (Criteria) this;
		}

		public Criteria andPrivilegeLike(String value) {
			addCriterion("privilege like", value, "privilege");
			return (Criteria) this;
		}

		public Criteria andPrivilegeNotLike(String value) {
			addCriterion("privilege not like", value, "privilege");
			return (Criteria) this;
		}

		public Criteria andPrivilegeIn(List<String> values) {
			addCriterion("privilege in", values, "privilege");
			return (Criteria) this;
		}

		public Criteria andPrivilegeNotIn(List<String> values) {
			addCriterion("privilege not in", values, "privilege");
			return (Criteria) this;
		}

		public Criteria andPrivilegeBetween(String value1, String value2) {
			addCriterion("privilege between", value1, value2, "privilege");
			return (Criteria) this;
		}

		public Criteria andPrivilegeNotBetween(String value1, String value2) {
			addCriterion("privilege not between", value1, value2, "privilege");
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