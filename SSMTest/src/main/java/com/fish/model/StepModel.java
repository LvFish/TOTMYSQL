package com.fish.model;

import java.util.Date;

public class StepModel {
    private int stepId;
    private int workFlowId;
    private String workFlowName;
    private int userId;
    private String username;
    private Date operationTime;
    private String description;
    private int isPass;
    private int step;

    public StepModel() {

    }

    public StepModel(int stepId, int workFlowId,String workFlowName, int userId, String username, Date operationTime, String description, int isPass,int step) {
        this.stepId = stepId;
        this.workFlowId = workFlowId;
        this.userId = userId;
        this.username = username;
        this.operationTime = operationTime;
        this.description = description;
        this.isPass = isPass;
        this.workFlowName = workFlowName;
        this.step = step;
    }

    public int getStepId() {
        return stepId;
    }

    public void setStepId(int stepId) {
        this.stepId = stepId;
    }

    public int getWorkFlowId() {
        return workFlowId;
    }

    public void setWorkFlowId(int workFlowId) {
        this.workFlowId = workFlowId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIsPass() {
        return isPass;
    }

    public void setIsPass(int isPass) {
        this.isPass = isPass;
    }

    public String getWorkFlowName() {
        return workFlowName;
    }

    public void setWorkFlowName(String workFlowName) {
        this.workFlowName = workFlowName;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
