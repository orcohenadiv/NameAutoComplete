package com.example.demo;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NameAutoCompleteController {

	private Map<String, Name> namesMap;
	private DBAccess dbAccess;

	@Autowired
	public NameAutoCompleteController(DBAccess dbAccess) {
		super();
		this.namesMap = Collections.synchronizedMap(new TreeMap<String, Name>());
		this.dbAccess = dbAccess;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void init() {
		dbAccess.findAll().forEach(name -> {
			namesMap.put(name.getName(), name);
			System.out.println(name);
		});
	}

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("names", namesMap.keySet());
		return "home";
	}

}
