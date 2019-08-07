package com.fish.service;

import com.fish.dao.StepDao;
import com.fish.dao.WorkFlowDao;
import com.fish.model.StepModel;
import com.fish.model.WorkFlowModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StepService {

    @Autowired
    private StepDao stepDao;

    public List<StepModel> getStepListByFlowId(int flowId){
        return stepDao.getStepListByFlowId(flowId);
    }

    public void insertStep(StepModel stepModel){
        stepDao.insertStep(stepModel);
    }
}
