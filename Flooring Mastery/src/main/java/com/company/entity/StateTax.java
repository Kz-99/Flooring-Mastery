package com.company.entity;


public class StateTax {
    private String stateCode;
    private String stateName;
    private double stateRate;

    public StateTax() {
    }
    public StateTax(String stateCodeIn, String stateName, double stateRate) {
        this.stateCode = stateCodeIn;
        this.stateName = stateName;
        this.stateRate = stateRate;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public double getStateRate() {
        return stateRate;
    }

    public void setStateRate(double stateRate) {
        this.stateRate = stateRate;
    }


    @Override
    public String toString() {
        return "StateTax{" +
                "stateCode='" + stateCode + '\'' +
                ", stateName='" + stateName + '\'' +
                ", stateRate=" + stateRate +
                '}';
    }
}
