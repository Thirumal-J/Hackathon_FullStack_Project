package com.hackfse.fms.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hackfse.fms.model.DistinctEvent;
import com.hackfse.fms.model.EventInfo;
import com.hackfse.fms.model.Feedback;
import com.hackfse.fms.repository.EventInfoRepository;
import com.hackfse.fms.repository.FeedbackRepository;
import com.hackfse.fms.service.FmsService;
import com.hackfse.fms.service.RatingService;

@RestController
@RequestMapping(path = "/userAccount")
@CrossOrigin(origins = "http://localhost:4200")
public class UserAccountController {
    
    @Autowired
    EventInfoRepository eventInfoRepository;
    
    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    FmsService fmsService;
    
    @Autowired
    RatingService ratingService;

    @RequestMapping(value = "/addEventInfo",method=RequestMethod.POST,consumes = {"application/JSON"})
    public String addEventInformation() {

    	String fileName="C:\\Users\\Admin\\Documents\\event_info.xlsx";
        Vector dataHolder= FmsService.read(fileName);
        
        fmsService.saveToDb(dataHolder);
        return "information stored successfully..";

    }

    
    @GetMapping(path = "/getEventInfo")
    @ResponseBody
    public List<EventInfo> getEventInfo() {
        List<EventInfo> eventInfo = (List<EventInfo>) eventInfoRepository.findAll();
        return eventInfo;
    }
    
    @GetMapping(path = "/getDistinctEvents")
    @ResponseBody
    public List<DistinctEvent> getDistinctEvents() {    	
    	List<DistinctEvent> listDE = new ArrayList();
        listDE = fmsService.getDistinctEvent();
        return listDE;
    }

    @RequestMapping(value = "/postFeedback",method=RequestMethod.POST,consumes = {"application/JSON"})
    public String postFeedback(@RequestBody Feedback feedback) {
    	feedbackRepository.save(feedback);
        return "Successfully saved feedback..";
    }
    
    @GetMapping(path = "/getFeedbackReport")
    @ResponseBody
    public HashMap<String,HashMap<String,Integer>> getFeedbackReport() {    	
    	HashMap<String,HashMap<String,Integer>> report = new HashMap<>();
    	report = ratingService.getFeedbackReport();
    	return report;
    }
    

}