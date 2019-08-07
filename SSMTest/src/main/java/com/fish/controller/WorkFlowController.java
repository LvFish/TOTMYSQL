package com.fish.controller;

import com.fish.model.StepModel;
import com.fish.model.WorkFlowModel;
import com.fish.service.StepService;
import com.fish.service.WorkFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping(value="/flow")
public class WorkFlowController {

    @Autowired
    private WorkFlowService workFlowService;

    @Autowired
    private StepService stepService;

    @RequestMapping(value="/apply",method = RequestMethod.GET)
    public String apply(){
        return "apply";
    }

    @RequestMapping(value="/addFlow",method = RequestMethod.POST)
    public void addFlow(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int userId = Integer.valueOf(session.getAttribute("userId").toString());
        WorkFlowModel workFlowModel = new WorkFlowModel();
        workFlowModel.setAddTime(new Date());
        workFlowModel.setDescription(description);
        workFlowModel.setUserId(userId);
        workFlowModel.setFlowName(name);
        workFlowModel.setIsOver(0);
        workFlowModel.setStep(1);
        workFlowService.addFlow(workFlowModel);
        response.getWriter().write("");
    }

    @RequestMapping(value="/addStep",method = RequestMethod.POST)
    public void addStep(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
        String description = request.getParameter("description");
        int flowId = Integer.valueOf(request.getParameter("flowId"));
        int result = Integer.valueOf(request.getParameter("result"));
        int userId = Integer.valueOf(session.getAttribute("userId").toString());
        WorkFlowModel workFlowModel = workFlowService.getWorkFlowByFlowId(flowId);
        StepModel stepModel = new StepModel();
        stepModel.setIsPass(result);
        stepModel.setUserId(userId);
        stepModel.setDescription(description);
        stepModel.setOperationTime(new Date());
        stepModel.setStep(workFlowModel.getStep());
        stepModel.setWorkFlowId(flowId);

        workFlowModel.setStep(workFlowModel.getStep()+1);
        if(result==0){
            workFlowModel.setIsOver(2);
        }else if(result == 1&& workFlowModel.getStep()==5){
            workFlowModel.setIsOver(1);
        }
        stepService.insertStep(stepModel);
        workFlowService.updateWorkFlowModel(workFlowModel);
        response.getWriter().write("");
    }
}
