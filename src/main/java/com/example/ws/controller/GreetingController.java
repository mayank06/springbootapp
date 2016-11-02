package com.example.ws.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ws.model.Greeting;

@RestController
public class GreetingController {

	private static Integer nextId;
	private static Map<Integer, Greeting> greetingMap;

	private static Greeting saveGreeting(Greeting greeting) {
		if(greetingMap == null) {
			greetingMap = new HashMap<Integer, Greeting>();
			nextId = 1;

		}
		greeting.setId(nextId);
		nextId += 1;
		greetingMap.put(nextId, greeting);
		return greeting;
	}
	
	static {
		Greeting g1 = new Greeting();
		g1.setText("Hello Mayank");
		saveGreeting(g1);
		
		Greeting g2 = new Greeting();
		g2.setText("Hey Sinha");
		saveGreeting(g2);
	}
	
	
	@RequestMapping(
			value = "/bootdemo/greetings",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE
			)
	public Collection<Greeting> getGreeting() {

		Collection<Greeting> greetings = greetingMap.values();
		return greetings;
	}
}
