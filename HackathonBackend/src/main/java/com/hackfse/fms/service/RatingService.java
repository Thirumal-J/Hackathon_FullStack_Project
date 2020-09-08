package com.hackfse.fms.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackfse.fms.repository.FeedbackRepository;

@Service
public class RatingService {
	
	@Autowired
	FeedbackRepository feedbackRepository;
	public HashMap<String,HashMap<String,Integer>> getFeedbackReport() {
		int fiveStar = 0;
		int fourStar = 0;
		int threeStar = 0;
		int twoStar = 0;
		int oneStar = 0;
		 
		HashMap<String,HashMap<String,Integer>> report = new HashMap<>();
		List<String> eventList = (List<String>) feedbackRepository.findDistinctEvent();
		for (String temp : eventList) {
			HashMap<String, Integer> map = new HashMap<>();
	    	fiveStar = feedbackRepository.countFive(temp);
	    	map.put("fiveStar", fiveStar);
	    	fourStar = feedbackRepository.countFour(temp);
	    	map.put("fourStar", fourStar);
	    	threeStar = feedbackRepository.countThree(temp);
	    	map.put("threeStar", threeStar);
	    	twoStar = feedbackRepository.countTwo(temp);
	    	map.put("twoStar", twoStar);
	    	oneStar = feedbackRepository.countOne(temp);       	        	
	    	map.put("oneStar", oneStar);
	    	report.put(temp, map);
		}
		return report;
	}
}
