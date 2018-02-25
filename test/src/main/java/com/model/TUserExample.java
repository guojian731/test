package com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TUserExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(String value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(String value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(String value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(String value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(String value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(String value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLike(String value) {
            addCriterion("age like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotLike(String value) {
            addCriterion("age not like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<String> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<String> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(String value1, String value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(String value1, String value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andBiyetimeIsNull() {
            addCriterion("biyetime is null");
            return (Criteria) this;
        }

        public Criteria andBiyetimeIsNotNull() {
            addCriterion("biyetime is not null");
            return (Criteria) this;
        }

        public Criteria andBiyetimeEqualTo(Date value) {
            addCriterion("biyetime =", value, "biyetime");
            return (Criteria) this;
        }

        public Criteria andBiyetimeNotEqualTo(Date value) {
            addCriterion("biyetime <>", value, "biyetime");
            return (Criteria) this;
        }

        public Criteria andBiyetimeGreaterThan(Date value) {
            addCriterion("biyetime >", value, "biyetime");
            return (Criteria) this;
        }

        public Criteria andBiyetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("biyetime >=", value, "biyetime");
            return (Criteria) this;
        }

        public Criteria andBiyetimeLessThan(Date value) {
            addCriterion("biyetime <", value, "biyetime");
            return (Criteria) this;
        }

        public Criteria andBiyetimeLessThanOrEqualTo(Date value) {
            addCriterion("biyetime <=", value, "biyetime");
            return (Criteria) this;
        }

        public Criteria andBiyetimeIn(List<Date> values) {
            addCriterion("biyetime in", values, "biyetime");
            return (Criteria) this;
        }

        public Criteria andBiyetimeNotIn(List<Date> values) {
            addCriterion("biyetime not in", values, "biyetime");
            return (Criteria) this;
        }

        public Criteria andBiyetimeBetween(Date value1, Date value2) {
            addCriterion("biyetime between", value1, value2, "biyetime");
            return (Criteria) this;
        }

        public Criteria andBiyetimeNotBetween(Date value1, Date value2) {
            addCriterion("biyetime not between", value1, value2, "biyetime");
            return (Criteria) this;
        }

        public Criteria andDeptIsNull() {
            addCriterion("dept is null");
            return (Criteria) this;
        }

        public Criteria andDeptIsNotNull() {
            addCriterion("dept is not null");
            return (Criteria) this;
        }

        public Criteria andDeptEqualTo(String value) {
            addCriterion("dept =", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptNotEqualTo(String value) {
            addCriterion("dept <>", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptGreaterThan(String value) {
            addCriterion("dept >", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptGreaterThanOrEqualTo(String value) {
            addCriterion("dept >=", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptLessThan(String value) {
            addCriterion("dept <", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptLessThanOrEqualTo(String value) {
            addCriterion("dept <=", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptLike(String value) {
            addCriterion("dept like", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptNotLike(String value) {
            addCriterion("dept not like", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptIn(List<String> values) {
            addCriterion("dept in", values, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptNotIn(List<String> values) {
            addCriterion("dept not in", values, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptBetween(String value1, String value2) {
            addCriterion("dept between", value1, value2, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptNotBetween(String value1, String value2) {
            addCriterion("dept not between", value1, value2, "dept");
            return (Criteria) this;
        }

        public Criteria andEmernameIsNull() {
            addCriterion("emerName is null");
            return (Criteria) this;
        }

        public Criteria andEmernameIsNotNull() {
            addCriterion("emerName is not null");
            return (Criteria) this;
        }

        public Criteria andEmernameEqualTo(String value) {
            addCriterion("emerName =", value, "emername");
            return (Criteria) this;
        }

        public Criteria andEmernameNotEqualTo(String value) {
            addCriterion("emerName <>", value, "emername");
            return (Criteria) this;
        }

        public Criteria andEmernameGreaterThan(String value) {
            addCriterion("emerName >", value, "emername");
            return (Criteria) this;
        }

        public Criteria andEmernameGreaterThanOrEqualTo(String value) {
            addCriterion("emerName >=", value, "emername");
            return (Criteria) this;
        }

        public Criteria andEmernameLessThan(String value) {
            addCriterion("emerName <", value, "emername");
            return (Criteria) this;
        }

        public Criteria andEmernameLessThanOrEqualTo(String value) {
            addCriterion("emerName <=", value, "emername");
            return (Criteria) this;
        }

        public Criteria andEmernameLike(String value) {
            addCriterion("emerName like", value, "emername");
            return (Criteria) this;
        }

        public Criteria andEmernameNotLike(String value) {
            addCriterion("emerName not like", value, "emername");
            return (Criteria) this;
        }

        public Criteria andEmernameIn(List<String> values) {
            addCriterion("emerName in", values, "emername");
            return (Criteria) this;
        }

        public Criteria andEmernameNotIn(List<String> values) {
            addCriterion("emerName not in", values, "emername");
            return (Criteria) this;
        }

        public Criteria andEmernameBetween(String value1, String value2) {
            addCriterion("emerName between", value1, value2, "emername");
            return (Criteria) this;
        }

        public Criteria andEmernameNotBetween(String value1, String value2) {
            addCriterion("emerName not between", value1, value2, "emername");
            return (Criteria) this;
        }

        public Criteria andEmerphoneIsNull() {
            addCriterion("emerPhone is null");
            return (Criteria) this;
        }

        public Criteria andEmerphoneIsNotNull() {
            addCriterion("emerPhone is not null");
            return (Criteria) this;
        }

        public Criteria andEmerphoneEqualTo(String value) {
            addCriterion("emerPhone =", value, "emerphone");
            return (Criteria) this;
        }

        public Criteria andEmerphoneNotEqualTo(String value) {
            addCriterion("emerPhone <>", value, "emerphone");
            return (Criteria) this;
        }

        public Criteria andEmerphoneGreaterThan(String value) {
            addCriterion("emerPhone >", value, "emerphone");
            return (Criteria) this;
        }

        public Criteria andEmerphoneGreaterThanOrEqualTo(String value) {
            addCriterion("emerPhone >=", value, "emerphone");
            return (Criteria) this;
        }

        public Criteria andEmerphoneLessThan(String value) {
            addCriterion("emerPhone <", value, "emerphone");
            return (Criteria) this;
        }

        public Criteria andEmerphoneLessThanOrEqualTo(String value) {
            addCriterion("emerPhone <=", value, "emerphone");
            return (Criteria) this;
        }

        public Criteria andEmerphoneLike(String value) {
            addCriterion("emerPhone like", value, "emerphone");
            return (Criteria) this;
        }

        public Criteria andEmerphoneNotLike(String value) {
            addCriterion("emerPhone not like", value, "emerphone");
            return (Criteria) this;
        }

        public Criteria andEmerphoneIn(List<String> values) {
            addCriterion("emerPhone in", values, "emerphone");
            return (Criteria) this;
        }

        public Criteria andEmerphoneNotIn(List<String> values) {
            addCriterion("emerPhone not in", values, "emerphone");
            return (Criteria) this;
        }

        public Criteria andEmerphoneBetween(String value1, String value2) {
            addCriterion("emerPhone between", value1, value2, "emerphone");
            return (Criteria) this;
        }

        public Criteria andEmerphoneNotBetween(String value1, String value2) {
            addCriterion("emerPhone not between", value1, value2, "emerphone");
            return (Criteria) this;
        }

        public Criteria andEmpdescIsNull() {
            addCriterion("empDesc is null");
            return (Criteria) this;
        }

        public Criteria andEmpdescIsNotNull() {
            addCriterion("empDesc is not null");
            return (Criteria) this;
        }

        public Criteria andEmpdescEqualTo(String value) {
            addCriterion("empDesc =", value, "empdesc");
            return (Criteria) this;
        }

        public Criteria andEmpdescNotEqualTo(String value) {
            addCriterion("empDesc <>", value, "empdesc");
            return (Criteria) this;
        }

        public Criteria andEmpdescGreaterThan(String value) {
            addCriterion("empDesc >", value, "empdesc");
            return (Criteria) this;
        }

        public Criteria andEmpdescGreaterThanOrEqualTo(String value) {
            addCriterion("empDesc >=", value, "empdesc");
            return (Criteria) this;
        }

        public Criteria andEmpdescLessThan(String value) {
            addCriterion("empDesc <", value, "empdesc");
            return (Criteria) this;
        }

        public Criteria andEmpdescLessThanOrEqualTo(String value) {
            addCriterion("empDesc <=", value, "empdesc");
            return (Criteria) this;
        }

        public Criteria andEmpdescLike(String value) {
            addCriterion("empDesc like", value, "empdesc");
            return (Criteria) this;
        }

        public Criteria andEmpdescNotLike(String value) {
            addCriterion("empDesc not like", value, "empdesc");
            return (Criteria) this;
        }

        public Criteria andEmpdescIn(List<String> values) {
            addCriterion("empDesc in", values, "empdesc");
            return (Criteria) this;
        }

        public Criteria andEmpdescNotIn(List<String> values) {
            addCriterion("empDesc not in", values, "empdesc");
            return (Criteria) this;
        }

        public Criteria andEmpdescBetween(String value1, String value2) {
            addCriterion("empDesc between", value1, value2, "empdesc");
            return (Criteria) this;
        }

        public Criteria andEmpdescNotBetween(String value1, String value2) {
            addCriterion("empDesc not between", value1, value2, "empdesc");
            return (Criteria) this;
        }

        public Criteria andEmpnoIsNull() {
            addCriterion("empNo is null");
            return (Criteria) this;
        }

        public Criteria andEmpnoIsNotNull() {
            addCriterion("empNo is not null");
            return (Criteria) this;
        }

        public Criteria andEmpnoEqualTo(String value) {
            addCriterion("empNo =", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoNotEqualTo(String value) {
            addCriterion("empNo <>", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoGreaterThan(String value) {
            addCriterion("empNo >", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoGreaterThanOrEqualTo(String value) {
            addCriterion("empNo >=", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoLessThan(String value) {
            addCriterion("empNo <", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoLessThanOrEqualTo(String value) {
            addCriterion("empNo <=", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoLike(String value) {
            addCriterion("empNo like", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoNotLike(String value) {
            addCriterion("empNo not like", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoIn(List<String> values) {
            addCriterion("empNo in", values, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoNotIn(List<String> values) {
            addCriterion("empNo not in", values, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoBetween(String value1, String value2) {
            addCriterion("empNo between", value1, value2, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoNotBetween(String value1, String value2) {
            addCriterion("empNo not between", value1, value2, "empno");
            return (Criteria) this;
        }

        public Criteria andHujiIsNull() {
            addCriterion("huji is null");
            return (Criteria) this;
        }

        public Criteria andHujiIsNotNull() {
            addCriterion("huji is not null");
            return (Criteria) this;
        }

        public Criteria andHujiEqualTo(String value) {
            addCriterion("huji =", value, "huji");
            return (Criteria) this;
        }

        public Criteria andHujiNotEqualTo(String value) {
            addCriterion("huji <>", value, "huji");
            return (Criteria) this;
        }

        public Criteria andHujiGreaterThan(String value) {
            addCriterion("huji >", value, "huji");
            return (Criteria) this;
        }

        public Criteria andHujiGreaterThanOrEqualTo(String value) {
            addCriterion("huji >=", value, "huji");
            return (Criteria) this;
        }

        public Criteria andHujiLessThan(String value) {
            addCriterion("huji <", value, "huji");
            return (Criteria) this;
        }

        public Criteria andHujiLessThanOrEqualTo(String value) {
            addCriterion("huji <=", value, "huji");
            return (Criteria) this;
        }

        public Criteria andHujiLike(String value) {
            addCriterion("huji like", value, "huji");
            return (Criteria) this;
        }

        public Criteria andHujiNotLike(String value) {
            addCriterion("huji not like", value, "huji");
            return (Criteria) this;
        }

        public Criteria andHujiIn(List<String> values) {
            addCriterion("huji in", values, "huji");
            return (Criteria) this;
        }

        public Criteria andHujiNotIn(List<String> values) {
            addCriterion("huji not in", values, "huji");
            return (Criteria) this;
        }

        public Criteria andHujiBetween(String value1, String value2) {
            addCriterion("huji between", value1, value2, "huji");
            return (Criteria) this;
        }

        public Criteria andHujiNotBetween(String value1, String value2) {
            addCriterion("huji not between", value1, value2, "huji");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNull() {
            addCriterion("id_card is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNotNull() {
            addCriterion("id_card is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEqualTo(String value) {
            addCriterion("id_card =", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotEqualTo(String value) {
            addCriterion("id_card <>", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThan(String value) {
            addCriterion("id_card >", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("id_card >=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThan(String value) {
            addCriterion("id_card <", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThanOrEqualTo(String value) {
            addCriterion("id_card <=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLike(String value) {
            addCriterion("id_card like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotLike(String value) {
            addCriterion("id_card not like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardIn(List<String> values) {
            addCriterion("id_card in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotIn(List<String> values) {
            addCriterion("id_card not in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardBetween(String value1, String value2) {
            addCriterion("id_card between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotBetween(String value1, String value2) {
            addCriterion("id_card not between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIsdelIsNull() {
            addCriterion("isDel is null");
            return (Criteria) this;
        }

        public Criteria andIsdelIsNotNull() {
            addCriterion("isDel is not null");
            return (Criteria) this;
        }

        public Criteria andIsdelEqualTo(Integer value) {
            addCriterion("isDel =", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotEqualTo(Integer value) {
            addCriterion("isDel <>", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThan(Integer value) {
            addCriterion("isDel >", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThanOrEqualTo(Integer value) {
            addCriterion("isDel >=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThan(Integer value) {
            addCriterion("isDel <", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThanOrEqualTo(Integer value) {
            addCriterion("isDel <=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelIn(List<Integer> values) {
            addCriterion("isDel in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotIn(List<Integer> values) {
            addCriterion("isDel not in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelBetween(Integer value1, Integer value2) {
            addCriterion("isDel between", value1, value2, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotBetween(Integer value1, Integer value2) {
            addCriterion("isDel not between", value1, value2, "isdel");
            return (Criteria) this;
        }

        public Criteria andJuzhudiIsNull() {
            addCriterion("juzhudi is null");
            return (Criteria) this;
        }

        public Criteria andJuzhudiIsNotNull() {
            addCriterion("juzhudi is not null");
            return (Criteria) this;
        }

        public Criteria andJuzhudiEqualTo(String value) {
            addCriterion("juzhudi =", value, "juzhudi");
            return (Criteria) this;
        }

        public Criteria andJuzhudiNotEqualTo(String value) {
            addCriterion("juzhudi <>", value, "juzhudi");
            return (Criteria) this;
        }

        public Criteria andJuzhudiGreaterThan(String value) {
            addCriterion("juzhudi >", value, "juzhudi");
            return (Criteria) this;
        }

        public Criteria andJuzhudiGreaterThanOrEqualTo(String value) {
            addCriterion("juzhudi >=", value, "juzhudi");
            return (Criteria) this;
        }

        public Criteria andJuzhudiLessThan(String value) {
            addCriterion("juzhudi <", value, "juzhudi");
            return (Criteria) this;
        }

        public Criteria andJuzhudiLessThanOrEqualTo(String value) {
            addCriterion("juzhudi <=", value, "juzhudi");
            return (Criteria) this;
        }

        public Criteria andJuzhudiLike(String value) {
            addCriterion("juzhudi like", value, "juzhudi");
            return (Criteria) this;
        }

        public Criteria andJuzhudiNotLike(String value) {
            addCriterion("juzhudi not like", value, "juzhudi");
            return (Criteria) this;
        }

        public Criteria andJuzhudiIn(List<String> values) {
            addCriterion("juzhudi in", values, "juzhudi");
            return (Criteria) this;
        }

        public Criteria andJuzhudiNotIn(List<String> values) {
            addCriterion("juzhudi not in", values, "juzhudi");
            return (Criteria) this;
        }

        public Criteria andJuzhudiBetween(String value1, String value2) {
            addCriterion("juzhudi between", value1, value2, "juzhudi");
            return (Criteria) this;
        }

        public Criteria andJuzhudiNotBetween(String value1, String value2) {
            addCriterion("juzhudi not between", value1, value2, "juzhudi");
            return (Criteria) this;
        }

        public Criteria andManagerIsNull() {
            addCriterion("manager is null");
            return (Criteria) this;
        }

        public Criteria andManagerIsNotNull() {
            addCriterion("manager is not null");
            return (Criteria) this;
        }

        public Criteria andManagerEqualTo(String value) {
            addCriterion("manager =", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotEqualTo(String value) {
            addCriterion("manager <>", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerGreaterThan(String value) {
            addCriterion("manager >", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerGreaterThanOrEqualTo(String value) {
            addCriterion("manager >=", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLessThan(String value) {
            addCriterion("manager <", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLessThanOrEqualTo(String value) {
            addCriterion("manager <=", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLike(String value) {
            addCriterion("manager like", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotLike(String value) {
            addCriterion("manager not like", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerIn(List<String> values) {
            addCriterion("manager in", values, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotIn(List<String> values) {
            addCriterion("manager not in", values, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerBetween(String value1, String value2) {
            addCriterion("manager between", value1, value2, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotBetween(String value1, String value2) {
            addCriterion("manager not between", value1, value2, "manager");
            return (Criteria) this;
        }

        public Criteria andPeixunjigouIsNull() {
            addCriterion("peixunjigou is null");
            return (Criteria) this;
        }

        public Criteria andPeixunjigouIsNotNull() {
            addCriterion("peixunjigou is not null");
            return (Criteria) this;
        }

        public Criteria andPeixunjigouEqualTo(String value) {
            addCriterion("peixunjigou =", value, "peixunjigou");
            return (Criteria) this;
        }

        public Criteria andPeixunjigouNotEqualTo(String value) {
            addCriterion("peixunjigou <>", value, "peixunjigou");
            return (Criteria) this;
        }

        public Criteria andPeixunjigouGreaterThan(String value) {
            addCriterion("peixunjigou >", value, "peixunjigou");
            return (Criteria) this;
        }

        public Criteria andPeixunjigouGreaterThanOrEqualTo(String value) {
            addCriterion("peixunjigou >=", value, "peixunjigou");
            return (Criteria) this;
        }

        public Criteria andPeixunjigouLessThan(String value) {
            addCriterion("peixunjigou <", value, "peixunjigou");
            return (Criteria) this;
        }

        public Criteria andPeixunjigouLessThanOrEqualTo(String value) {
            addCriterion("peixunjigou <=", value, "peixunjigou");
            return (Criteria) this;
        }

        public Criteria andPeixunjigouLike(String value) {
            addCriterion("peixunjigou like", value, "peixunjigou");
            return (Criteria) this;
        }

        public Criteria andPeixunjigouNotLike(String value) {
            addCriterion("peixunjigou not like", value, "peixunjigou");
            return (Criteria) this;
        }

        public Criteria andPeixunjigouIn(List<String> values) {
            addCriterion("peixunjigou in", values, "peixunjigou");
            return (Criteria) this;
        }

        public Criteria andPeixunjigouNotIn(List<String> values) {
            addCriterion("peixunjigou not in", values, "peixunjigou");
            return (Criteria) this;
        }

        public Criteria andPeixunjigouBetween(String value1, String value2) {
            addCriterion("peixunjigou between", value1, value2, "peixunjigou");
            return (Criteria) this;
        }

        public Criteria andPeixunjigouNotBetween(String value1, String value2) {
            addCriterion("peixunjigou not between", value1, value2, "peixunjigou");
            return (Criteria) this;
        }

        public Criteria andPxStarttimeIsNull() {
            addCriterion("px_startTime is null");
            return (Criteria) this;
        }

        public Criteria andPxStarttimeIsNotNull() {
            addCriterion("px_startTime is not null");
            return (Criteria) this;
        }

        public Criteria andPxStarttimeEqualTo(Date value) {
            addCriterion("px_startTime =", value, "pxStarttime");
            return (Criteria) this;
        }

        public Criteria andPxStarttimeNotEqualTo(Date value) {
            addCriterion("px_startTime <>", value, "pxStarttime");
            return (Criteria) this;
        }

        public Criteria andPxStarttimeGreaterThan(Date value) {
            addCriterion("px_startTime >", value, "pxStarttime");
            return (Criteria) this;
        }

        public Criteria andPxStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("px_startTime >=", value, "pxStarttime");
            return (Criteria) this;
        }

        public Criteria andPxStarttimeLessThan(Date value) {
            addCriterion("px_startTime <", value, "pxStarttime");
            return (Criteria) this;
        }

        public Criteria andPxStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("px_startTime <=", value, "pxStarttime");
            return (Criteria) this;
        }

        public Criteria andPxStarttimeIn(List<Date> values) {
            addCriterion("px_startTime in", values, "pxStarttime");
            return (Criteria) this;
        }

        public Criteria andPxStarttimeNotIn(List<Date> values) {
            addCriterion("px_startTime not in", values, "pxStarttime");
            return (Criteria) this;
        }

        public Criteria andPxStarttimeBetween(Date value1, Date value2) {
            addCriterion("px_startTime between", value1, value2, "pxStarttime");
            return (Criteria) this;
        }

        public Criteria andPxStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("px_startTime not between", value1, value2, "pxStarttime");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPostIsNull() {
            addCriterion("post is null");
            return (Criteria) this;
        }

        public Criteria andPostIsNotNull() {
            addCriterion("post is not null");
            return (Criteria) this;
        }

        public Criteria andPostEqualTo(String value) {
            addCriterion("post =", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostNotEqualTo(String value) {
            addCriterion("post <>", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostGreaterThan(String value) {
            addCriterion("post >", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostGreaterThanOrEqualTo(String value) {
            addCriterion("post >=", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostLessThan(String value) {
            addCriterion("post <", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostLessThanOrEqualTo(String value) {
            addCriterion("post <=", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostLike(String value) {
            addCriterion("post like", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostNotLike(String value) {
            addCriterion("post not like", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostIn(List<String> values) {
            addCriterion("post in", values, "post");
            return (Criteria) this;
        }

        public Criteria andPostNotIn(List<String> values) {
            addCriterion("post not in", values, "post");
            return (Criteria) this;
        }

        public Criteria andPostBetween(String value1, String value2) {
            addCriterion("post between", value1, value2, "post");
            return (Criteria) this;
        }

        public Criteria andPostNotBetween(String value1, String value2) {
            addCriterion("post not between", value1, value2, "post");
            return (Criteria) this;
        }

        public Criteria andPxEndtimeIsNull() {
            addCriterion("px_endTime is null");
            return (Criteria) this;
        }

        public Criteria andPxEndtimeIsNotNull() {
            addCriterion("px_endTime is not null");
            return (Criteria) this;
        }

        public Criteria andPxEndtimeEqualTo(Date value) {
            addCriterion("px_endTime =", value, "pxEndtime");
            return (Criteria) this;
        }

        public Criteria andPxEndtimeNotEqualTo(Date value) {
            addCriterion("px_endTime <>", value, "pxEndtime");
            return (Criteria) this;
        }

        public Criteria andPxEndtimeGreaterThan(Date value) {
            addCriterion("px_endTime >", value, "pxEndtime");
            return (Criteria) this;
        }

        public Criteria andPxEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("px_endTime >=", value, "pxEndtime");
            return (Criteria) this;
        }

        public Criteria andPxEndtimeLessThan(Date value) {
            addCriterion("px_endTime <", value, "pxEndtime");
            return (Criteria) this;
        }

        public Criteria andPxEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("px_endTime <=", value, "pxEndtime");
            return (Criteria) this;
        }

        public Criteria andPxEndtimeIn(List<Date> values) {
            addCriterion("px_endTime in", values, "pxEndtime");
            return (Criteria) this;
        }

        public Criteria andPxEndtimeNotIn(List<Date> values) {
            addCriterion("px_endTime not in", values, "pxEndtime");
            return (Criteria) this;
        }

        public Criteria andPxEndtimeBetween(Date value1, Date value2) {
            addCriterion("px_endTime between", value1, value2, "pxEndtime");
            return (Criteria) this;
        }

        public Criteria andPxEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("px_endTime not between", value1, value2, "pxEndtime");
            return (Criteria) this;
        }

        public Criteria andPeixunneirongIsNull() {
            addCriterion("peixunneirong is null");
            return (Criteria) this;
        }

        public Criteria andPeixunneirongIsNotNull() {
            addCriterion("peixunneirong is not null");
            return (Criteria) this;
        }

        public Criteria andPeixunneirongEqualTo(String value) {
            addCriterion("peixunneirong =", value, "peixunneirong");
            return (Criteria) this;
        }

        public Criteria andPeixunneirongNotEqualTo(String value) {
            addCriterion("peixunneirong <>", value, "peixunneirong");
            return (Criteria) this;
        }

        public Criteria andPeixunneirongGreaterThan(String value) {
            addCriterion("peixunneirong >", value, "peixunneirong");
            return (Criteria) this;
        }

        public Criteria andPeixunneirongGreaterThanOrEqualTo(String value) {
            addCriterion("peixunneirong >=", value, "peixunneirong");
            return (Criteria) this;
        }

        public Criteria andPeixunneirongLessThan(String value) {
            addCriterion("peixunneirong <", value, "peixunneirong");
            return (Criteria) this;
        }

        public Criteria andPeixunneirongLessThanOrEqualTo(String value) {
            addCriterion("peixunneirong <=", value, "peixunneirong");
            return (Criteria) this;
        }

        public Criteria andPeixunneirongLike(String value) {
            addCriterion("peixunneirong like", value, "peixunneirong");
            return (Criteria) this;
        }

        public Criteria andPeixunneirongNotLike(String value) {
            addCriterion("peixunneirong not like", value, "peixunneirong");
            return (Criteria) this;
        }

        public Criteria andPeixunneirongIn(List<String> values) {
            addCriterion("peixunneirong in", values, "peixunneirong");
            return (Criteria) this;
        }

        public Criteria andPeixunneirongNotIn(List<String> values) {
            addCriterion("peixunneirong not in", values, "peixunneirong");
            return (Criteria) this;
        }

        public Criteria andPeixunneirongBetween(String value1, String value2) {
            addCriterion("peixunneirong between", value1, value2, "peixunneirong");
            return (Criteria) this;
        }

        public Criteria andPeixunneirongNotBetween(String value1, String value2) {
            addCriterion("peixunneirong not between", value1, value2, "peixunneirong");
            return (Criteria) this;
        }

        public Criteria andRnameIsNull() {
            addCriterion("rname is null");
            return (Criteria) this;
        }

        public Criteria andRnameIsNotNull() {
            addCriterion("rname is not null");
            return (Criteria) this;
        }

        public Criteria andRnameEqualTo(String value) {
            addCriterion("rname =", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotEqualTo(String value) {
            addCriterion("rname <>", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameGreaterThan(String value) {
            addCriterion("rname >", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameGreaterThanOrEqualTo(String value) {
            addCriterion("rname >=", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameLessThan(String value) {
            addCriterion("rname <", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameLessThanOrEqualTo(String value) {
            addCriterion("rname <=", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameLike(String value) {
            addCriterion("rname like", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotLike(String value) {
            addCriterion("rname not like", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameIn(List<String> values) {
            addCriterion("rname in", values, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotIn(List<String> values) {
            addCriterion("rname not in", values, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameBetween(String value1, String value2) {
            addCriterion("rname between", value1, value2, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotBetween(String value1, String value2) {
            addCriterion("rname not between", value1, value2, "rname");
            return (Criteria) this;
        }

        public Criteria andRuzhitimeIsNull() {
            addCriterion("ruzhiTime is null");
            return (Criteria) this;
        }

        public Criteria andRuzhitimeIsNotNull() {
            addCriterion("ruzhiTime is not null");
            return (Criteria) this;
        }

        public Criteria andRuzhitimeEqualTo(Date value) {
            addCriterion("ruzhiTime =", value, "ruzhitime");
            return (Criteria) this;
        }

        public Criteria andRuzhitimeNotEqualTo(Date value) {
            addCriterion("ruzhiTime <>", value, "ruzhitime");
            return (Criteria) this;
        }

        public Criteria andRuzhitimeGreaterThan(Date value) {
            addCriterion("ruzhiTime >", value, "ruzhitime");
            return (Criteria) this;
        }

        public Criteria andRuzhitimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ruzhiTime >=", value, "ruzhitime");
            return (Criteria) this;
        }

        public Criteria andRuzhitimeLessThan(Date value) {
            addCriterion("ruzhiTime <", value, "ruzhitime");
            return (Criteria) this;
        }

        public Criteria andRuzhitimeLessThanOrEqualTo(Date value) {
            addCriterion("ruzhiTime <=", value, "ruzhitime");
            return (Criteria) this;
        }

        public Criteria andRuzhitimeIn(List<Date> values) {
            addCriterion("ruzhiTime in", values, "ruzhitime");
            return (Criteria) this;
        }

        public Criteria andRuzhitimeNotIn(List<Date> values) {
            addCriterion("ruzhiTime not in", values, "ruzhitime");
            return (Criteria) this;
        }

        public Criteria andRuzhitimeBetween(Date value1, Date value2) {
            addCriterion("ruzhiTime between", value1, value2, "ruzhitime");
            return (Criteria) this;
        }

        public Criteria andRuzhitimeNotBetween(Date value1, Date value2) {
            addCriterion("ruzhiTime not between", value1, value2, "ruzhitime");
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

        public Criteria andUniversityIsNull() {
            addCriterion("university is null");
            return (Criteria) this;
        }

        public Criteria andUniversityIsNotNull() {
            addCriterion("university is not null");
            return (Criteria) this;
        }

        public Criteria andUniversityEqualTo(String value) {
            addCriterion("university =", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityNotEqualTo(String value) {
            addCriterion("university <>", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityGreaterThan(String value) {
            addCriterion("university >", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityGreaterThanOrEqualTo(String value) {
            addCriterion("university >=", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityLessThan(String value) {
            addCriterion("university <", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityLessThanOrEqualTo(String value) {
            addCriterion("university <=", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityLike(String value) {
            addCriterion("university like", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityNotLike(String value) {
            addCriterion("university not like", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityIn(List<String> values) {
            addCriterion("university in", values, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityNotIn(List<String> values) {
            addCriterion("university not in", values, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityBetween(String value1, String value2) {
            addCriterion("university between", value1, value2, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityNotBetween(String value1, String value2) {
            addCriterion("university not between", value1, value2, "university");
            return (Criteria) this;
        }

        public Criteria andUpassIsNull() {
            addCriterion("upass is null");
            return (Criteria) this;
        }

        public Criteria andUpassIsNotNull() {
            addCriterion("upass is not null");
            return (Criteria) this;
        }

        public Criteria andUpassEqualTo(String value) {
            addCriterion("upass =", value, "upass");
            return (Criteria) this;
        }

        public Criteria andUpassNotEqualTo(String value) {
            addCriterion("upass <>", value, "upass");
            return (Criteria) this;
        }

        public Criteria andUpassGreaterThan(String value) {
            addCriterion("upass >", value, "upass");
            return (Criteria) this;
        }

        public Criteria andUpassGreaterThanOrEqualTo(String value) {
            addCriterion("upass >=", value, "upass");
            return (Criteria) this;
        }

        public Criteria andUpassLessThan(String value) {
            addCriterion("upass <", value, "upass");
            return (Criteria) this;
        }

        public Criteria andUpassLessThanOrEqualTo(String value) {
            addCriterion("upass <=", value, "upass");
            return (Criteria) this;
        }

        public Criteria andUpassLike(String value) {
            addCriterion("upass like", value, "upass");
            return (Criteria) this;
        }

        public Criteria andUpassNotLike(String value) {
            addCriterion("upass not like", value, "upass");
            return (Criteria) this;
        }

        public Criteria andUpassIn(List<String> values) {
            addCriterion("upass in", values, "upass");
            return (Criteria) this;
        }

        public Criteria andUpassNotIn(List<String> values) {
            addCriterion("upass not in", values, "upass");
            return (Criteria) this;
        }

        public Criteria andUpassBetween(String value1, String value2) {
            addCriterion("upass between", value1, value2, "upass");
            return (Criteria) this;
        }

        public Criteria andUpassNotBetween(String value1, String value2) {
            addCriterion("upass not between", value1, value2, "upass");
            return (Criteria) this;
        }

        public Criteria andUsexIsNull() {
            addCriterion("usex is null");
            return (Criteria) this;
        }

        public Criteria andUsexIsNotNull() {
            addCriterion("usex is not null");
            return (Criteria) this;
        }

        public Criteria andUsexEqualTo(Integer value) {
            addCriterion("usex =", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexNotEqualTo(Integer value) {
            addCriterion("usex <>", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexGreaterThan(Integer value) {
            addCriterion("usex >", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexGreaterThanOrEqualTo(Integer value) {
            addCriterion("usex >=", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexLessThan(Integer value) {
            addCriterion("usex <", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexLessThanOrEqualTo(Integer value) {
            addCriterion("usex <=", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexIn(List<Integer> values) {
            addCriterion("usex in", values, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexNotIn(List<Integer> values) {
            addCriterion("usex not in", values, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexBetween(Integer value1, Integer value2) {
            addCriterion("usex between", value1, value2, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexNotBetween(Integer value1, Integer value2) {
            addCriterion("usex not between", value1, value2, "usex");
            return (Criteria) this;
        }

        public Criteria andXueliIsNull() {
            addCriterion("xueli is null");
            return (Criteria) this;
        }

        public Criteria andXueliIsNotNull() {
            addCriterion("xueli is not null");
            return (Criteria) this;
        }

        public Criteria andXueliEqualTo(String value) {
            addCriterion("xueli =", value, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliNotEqualTo(String value) {
            addCriterion("xueli <>", value, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliGreaterThan(String value) {
            addCriterion("xueli >", value, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliGreaterThanOrEqualTo(String value) {
            addCriterion("xueli >=", value, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliLessThan(String value) {
            addCriterion("xueli <", value, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliLessThanOrEqualTo(String value) {
            addCriterion("xueli <=", value, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliLike(String value) {
            addCriterion("xueli like", value, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliNotLike(String value) {
            addCriterion("xueli not like", value, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliIn(List<String> values) {
            addCriterion("xueli in", values, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliNotIn(List<String> values) {
            addCriterion("xueli not in", values, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliBetween(String value1, String value2) {
            addCriterion("xueli between", value1, value2, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliNotBetween(String value1, String value2) {
            addCriterion("xueli not between", value1, value2, "xueli");
            return (Criteria) this;
        }

        public Criteria andZhuanyeIsNull() {
            addCriterion("zhuanye is null");
            return (Criteria) this;
        }

        public Criteria andZhuanyeIsNotNull() {
            addCriterion("zhuanye is not null");
            return (Criteria) this;
        }

        public Criteria andZhuanyeEqualTo(String value) {
            addCriterion("zhuanye =", value, "zhuanye");
            return (Criteria) this;
        }

        public Criteria andZhuanyeNotEqualTo(String value) {
            addCriterion("zhuanye <>", value, "zhuanye");
            return (Criteria) this;
        }

        public Criteria andZhuanyeGreaterThan(String value) {
            addCriterion("zhuanye >", value, "zhuanye");
            return (Criteria) this;
        }

        public Criteria andZhuanyeGreaterThanOrEqualTo(String value) {
            addCriterion("zhuanye >=", value, "zhuanye");
            return (Criteria) this;
        }

        public Criteria andZhuanyeLessThan(String value) {
            addCriterion("zhuanye <", value, "zhuanye");
            return (Criteria) this;
        }

        public Criteria andZhuanyeLessThanOrEqualTo(String value) {
            addCriterion("zhuanye <=", value, "zhuanye");
            return (Criteria) this;
        }

        public Criteria andZhuanyeLike(String value) {
            addCriterion("zhuanye like", value, "zhuanye");
            return (Criteria) this;
        }

        public Criteria andZhuanyeNotLike(String value) {
            addCriterion("zhuanye not like", value, "zhuanye");
            return (Criteria) this;
        }

        public Criteria andZhuanyeIn(List<String> values) {
            addCriterion("zhuanye in", values, "zhuanye");
            return (Criteria) this;
        }

        public Criteria andZhuanyeNotIn(List<String> values) {
            addCriterion("zhuanye not in", values, "zhuanye");
            return (Criteria) this;
        }

        public Criteria andZhuanyeBetween(String value1, String value2) {
            addCriterion("zhuanye between", value1, value2, "zhuanye");
            return (Criteria) this;
        }

        public Criteria andZhuanyeNotBetween(String value1, String value2) {
            addCriterion("zhuanye not between", value1, value2, "zhuanye");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Long value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Long value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Long value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Long value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Long value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Long> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Long> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Long value1, Long value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Long value1, Long value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andMarineIdIsNull() {
            addCriterion("marine_id is null");
            return (Criteria) this;
        }

        public Criteria andMarineIdIsNotNull() {
            addCriterion("marine_id is not null");
            return (Criteria) this;
        }

        public Criteria andMarineIdEqualTo(Long value) {
            addCriterion("marine_id =", value, "marineId");
            return (Criteria) this;
        }

        public Criteria andMarineIdNotEqualTo(Long value) {
            addCriterion("marine_id <>", value, "marineId");
            return (Criteria) this;
        }

        public Criteria andMarineIdGreaterThan(Long value) {
            addCriterion("marine_id >", value, "marineId");
            return (Criteria) this;
        }

        public Criteria andMarineIdGreaterThanOrEqualTo(Long value) {
            addCriterion("marine_id >=", value, "marineId");
            return (Criteria) this;
        }

        public Criteria andMarineIdLessThan(Long value) {
            addCriterion("marine_id <", value, "marineId");
            return (Criteria) this;
        }

        public Criteria andMarineIdLessThanOrEqualTo(Long value) {
            addCriterion("marine_id <=", value, "marineId");
            return (Criteria) this;
        }

        public Criteria andMarineIdIn(List<Long> values) {
            addCriterion("marine_id in", values, "marineId");
            return (Criteria) this;
        }

        public Criteria andMarineIdNotIn(List<Long> values) {
            addCriterion("marine_id not in", values, "marineId");
            return (Criteria) this;
        }

        public Criteria andMarineIdBetween(Long value1, Long value2) {
            addCriterion("marine_id between", value1, value2, "marineId");
            return (Criteria) this;
        }

        public Criteria andMarineIdNotBetween(Long value1, Long value2) {
            addCriterion("marine_id not between", value1, value2, "marineId");
            return (Criteria) this;
        }

        public Criteria andPxdescIsNull() {
            addCriterion("pxDesc is null");
            return (Criteria) this;
        }

        public Criteria andPxdescIsNotNull() {
            addCriterion("pxDesc is not null");
            return (Criteria) this;
        }

        public Criteria andPxdescEqualTo(String value) {
            addCriterion("pxDesc =", value, "pxdesc");
            return (Criteria) this;
        }

        public Criteria andPxdescNotEqualTo(String value) {
            addCriterion("pxDesc <>", value, "pxdesc");
            return (Criteria) this;
        }

        public Criteria andPxdescGreaterThan(String value) {
            addCriterion("pxDesc >", value, "pxdesc");
            return (Criteria) this;
        }

        public Criteria andPxdescGreaterThanOrEqualTo(String value) {
            addCriterion("pxDesc >=", value, "pxdesc");
            return (Criteria) this;
        }

        public Criteria andPxdescLessThan(String value) {
            addCriterion("pxDesc <", value, "pxdesc");
            return (Criteria) this;
        }

        public Criteria andPxdescLessThanOrEqualTo(String value) {
            addCriterion("pxDesc <=", value, "pxdesc");
            return (Criteria) this;
        }

        public Criteria andPxdescLike(String value) {
            addCriterion("pxDesc like", value, "pxdesc");
            return (Criteria) this;
        }

        public Criteria andPxdescNotLike(String value) {
            addCriterion("pxDesc not like", value, "pxdesc");
            return (Criteria) this;
        }

        public Criteria andPxdescIn(List<String> values) {
            addCriterion("pxDesc in", values, "pxdesc");
            return (Criteria) this;
        }

        public Criteria andPxdescNotIn(List<String> values) {
            addCriterion("pxDesc not in", values, "pxdesc");
            return (Criteria) this;
        }

        public Criteria andPxdescBetween(String value1, String value2) {
            addCriterion("pxDesc between", value1, value2, "pxdesc");
            return (Criteria) this;
        }

        public Criteria andPxdescNotBetween(String value1, String value2) {
            addCriterion("pxDesc not between", value1, value2, "pxdesc");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("qq is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("qq is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("qq =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("qq <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("qq >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("qq >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("qq <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("qq <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("qq like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("qq not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("qq in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("qq not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("qq between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("qq not between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andWeixinIsNull() {
            addCriterion("weixin is null");
            return (Criteria) this;
        }

        public Criteria andWeixinIsNotNull() {
            addCriterion("weixin is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinEqualTo(String value) {
            addCriterion("weixin =", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinNotEqualTo(String value) {
            addCriterion("weixin <>", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinGreaterThan(String value) {
            addCriterion("weixin >", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinGreaterThanOrEqualTo(String value) {
            addCriterion("weixin >=", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinLessThan(String value) {
            addCriterion("weixin <", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinLessThanOrEqualTo(String value) {
            addCriterion("weixin <=", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinLike(String value) {
            addCriterion("weixin like", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinNotLike(String value) {
            addCriterion("weixin not like", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinIn(List<String> values) {
            addCriterion("weixin in", values, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinNotIn(List<String> values) {
            addCriterion("weixin not in", values, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinBetween(String value1, String value2) {
            addCriterion("weixin between", value1, value2, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinNotBetween(String value1, String value2) {
            addCriterion("weixin not between", value1, value2, "weixin");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNull() {
            addCriterion("dept_id is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(Long value) {
            addCriterion("dept_id =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(Long value) {
            addCriterion("dept_id <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(Long value) {
            addCriterion("dept_id >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(Long value) {
            addCriterion("dept_id >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(Long value) {
            addCriterion("dept_id <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(Long value) {
            addCriterion("dept_id <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<Long> values) {
            addCriterion("dept_id in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<Long> values) {
            addCriterion("dept_id not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(Long value1, Long value2) {
            addCriterion("dept_id between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(Long value1, Long value2) {
            addCriterion("dept_id not between", value1, value2, "deptId");
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