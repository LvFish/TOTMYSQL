package com.fish.model;

import java.util.Date;

public class WorkFlowModel {
    private int flowId;
    private String flowName;
    private String description;
    private Date addTime;
    private int userId;
    private int isOver;
    private int step;
    private String nickname;

    public WorkFlowModel(){

    }

    public WorkFlowModel(int flowId, String flowName, String description, Date addTime, int userId, int isOver, int step,String nickname) {
        this.flowId = flowId;
        this.flowName = flowName;
        this.description = description;
        this.addTime = addTime;
        this.userId = userId;
        this.isOver = isOver;
        this.step = step;
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getFlowId() {
        return flowId;
    }

    public void setFlowId(int flowId) {
        this.flowId = flowId;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getIsOver() {
        return isOver;
    }

    public void setIsOver(int isOver) {
        this.isOver = isOver;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
