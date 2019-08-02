package com.fish.service;

import com.fish.dao.WorkFlowDao;
import com.fish.model.WorkFlowModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WorkFlowService {

    @Autowired
    private WorkFlowDao workFlowDao;

    public List<WorkFlowModel> getWorkFlowByUserId(int userId){
        return workFlowDao.getWorkFlowByUserId(userId);
    }
}
