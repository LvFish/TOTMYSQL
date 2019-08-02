package com.fish.model;

import java.util.Date;

public class WorkFlowModel {
    private int id;
    private String flowName;
    private String description;
    private Date addTime;
    private int userId;
    private int isOver;
    private int step;

    public WorkFlowModel(){

    }

    public WorkFlowModel(int id, String flowName, String description, Date addTime, int userId, int isOver, int step) {
        this.id = id;
        this.flowName = flowName;
        this.description = description;
        this.addTime = addTime;
        this.userId = userId;
        this.isOver = isOver;
        this.step = step;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
