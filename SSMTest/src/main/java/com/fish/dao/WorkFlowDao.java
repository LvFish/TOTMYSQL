package com.fish.dao;

import com.fish.model.WorkFlowModel;

import java.util.List;

public interface WorkFlowDao {

    List<WorkFlowModel> getWorkFlowByUserId(int userId);
}
