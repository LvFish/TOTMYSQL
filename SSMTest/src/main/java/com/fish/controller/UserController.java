package com.fish.controller;

import com.fish.model.StepModel;
import com.fish.model.UserModel;
import com.fish.model.WorkFlowModel;
import com.fish.service.StepService;
import com.fish.service.UserService;
import com.fish.service.WorkFlowService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private WorkFlowService workFlowService;
    @Autowired
    private StepService stepService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request,HttpSession session) {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        UserModel userModel = userService.getUserByAccount(account, password);
        if (userModel == null) {
            return "redirect:/login";
        }
        session.setAttribute("userId",userModel.getId());
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request,HttpSession session) {
        return "index";
    }

    @RequestMapping(value = "/showDetail", method = RequestMethod.GET)
    public String showDetail(HttpServletRequest request,HttpSession session) {
        String workflowId = request.getParameter("workflowId");
        session.setAttribute("workflowId",workflowId);
        return "workflowDetail";
    }

    @RequestMapping(value = "/getUserWorkFlow",method = RequestMethod.POST)
    public void getUserWorkFlow(HttpServletResponse response,HttpSession session) throws IOException {
        JSONObject json = new JSONObject();
        int userId = Integer.valueOf(session.getAttribute("userId").toString());
        List<WorkFlowModel> workFlowModelList = workFlowService.getWorkFlowByUserId(userId);
        json.put("workFlowModelList",workFlowModelList);
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        String js = json.toString();
        response.getWriter().write(js);
    }

    @RequestMapping(value = "/getApprovalWorkFlow",method = RequestMethod.POST)
    public void getApprovalWorkFlow(HttpServletResponse response,HttpSession session) throws IOException {
        JSONObject json = new JSONObject();
        int userId = Integer.valueOf(session.getAttribute("userId").toString());
        List<WorkFlowModel> workFlowModelList = workFlowService.getWorkFlowById(userId);
        json.put("approvalWorkFlowList",workFlowModelList);
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        String js = json.toString();
        response.getWriter().write(js);
    }


    @RequestMapping(value="getStepList",method = RequestMethod.POST)
    public void getStepList(HttpServletResponse response,HttpSession session) throws IOException {
        JSONObject json = new JSONObject();
        int flowId = Integer.valueOf(session.getAttribute("workflowId").toString());
        List<StepModel> stepModelList = stepService.getStepListByFlowId(flowId);
        json.put("stepList",stepModelList);
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        String js = json.toString();
        response.getWriter().write(js);
    }
}