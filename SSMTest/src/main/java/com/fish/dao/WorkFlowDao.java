package com.fish.dao;

import com.fish.model.WorkFlowModel;

import java.util.List;

public interface WorkFlowDao {

    List<WorkFlowModel> getWorkFlowByUserId(int userId);

    List<WorkFlowModel> getWorkFlowById(int userId);

    void addFlow(WorkFlowModel workFlowModel);

    WorkFlowModel getWorkFlowByFlowId(int flowId);

    void updateWorkFlowModel(WorkFlowModel workFlowModel);
}
