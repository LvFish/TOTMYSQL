package com.fish.dao;

import com.fish.model.StepModel;

import java.util.List;

public interface StepDao {

    List<StepModel> getStepListByFlowId(int flowId);

    void insertStep(StepModel stepModel);
}
