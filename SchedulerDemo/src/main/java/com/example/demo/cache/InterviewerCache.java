package com.example.demo.cache;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Interviewer;
import com.example.demo.interviewer.InterviewerRepository;

@Component
public class InterviewerCache {
	
	@Autowired
	private InterviewerCache(InterviewerRepository interviewerRepository) {
		System.out.println("************Inside the cache");
		loadCache(interviewerRepository);
		print();
		System.out.println("************cache loaded");
	}
	
	public static void loadCache(InterviewerRepository interviewerRepository) {
		if(interviewerRepository == null) {
			System.out.println("*****************interviewerRepository is null **************");
		}else {
			List<Interviewer> interviewerList = interviewerRepository.findAll();
			interviewerList.stream().forEach( interviewer -> {
				SingletonCacheConcurrentHashMap.getInstance().put(interviewer, new Date());
			});
		}
	}
	
	public static void print() {
		ConcurrentHashMap<Interviewer, Date> map = SingletonCacheConcurrentHashMap.getInstance();
		Set<Interviewer> keyset=map.keySet();
		for (Interviewer interviewer : keyset) {
			System.out.println("########################################################");
			System.out.println("$$$$$$$$$$$$$$$$$$$$"+interviewer.getEmailId());
			System.out.println("$$$$$$$$$$$$$$$$$$$$"+interviewer.getAvilabilityStatus());
			System.out.println("$$$$$$$$$$$$$$$$$$$$"+interviewer.getFirstname());
			System.out.println("$$$$$$$$$$$$$$$$$$$$"+interviewer.getLastname());
			System.out.println("$$$$$$$$$$$$$$$$$$$$"+interviewer.getManagerEmailId());
			System.out.println("$$$$$$$$$$$$$$$$$$$$"+interviewer.getPriority());
			
		}
	}
	
	public static class SingletonCacheConcurrentHashMap extends ConcurrentHashMap<Interviewer, Date>{

		private static class SingletonCahceHolder{
			public static final SingletonCacheConcurrentHashMap instance = new SingletonCacheConcurrentHashMap();
		}
		
		public static SingletonCacheConcurrentHashMap getInstance() {
			return SingletonCahceHolder.instance;
		}
	}
}
