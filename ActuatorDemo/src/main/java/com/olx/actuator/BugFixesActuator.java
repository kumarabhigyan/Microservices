package com.olx.actuator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;


@Component
@Endpoint(id="bug-fixes")
public class BugFixesActuator {
	
	private static Map<String, List<String>> bugsMap=new HashMap<String,List<String>>();
	@PostConstruct
	public void initialize() {
		bugsMap.put("v1", Arrays.asList("Bug 1","Bug 2"));
		bugsMap.put("v2", Arrays.asList("Bug 3","Bug 4"));
		
		
		
		
	}
	@ReadOperation
	public Map<String, List<String>> getAllBugs(){
		return bugsMap;
		
	}
	@WriteOperation
	public void addNewVersion(@Selector String id, String bugs){
		bugsMap.put(id,Arrays.asList(bugs.split(",")));
		
		
		
		
		}
	@DeleteOperation
	public void deleteBugVersion(@Selector String id) {
		bugsMap.remove(id);
		
		
		
		
	}

}
