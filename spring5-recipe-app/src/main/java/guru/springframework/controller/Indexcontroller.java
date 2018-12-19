package guru.springframework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Indexcontroller {

	@RequestMapping({"","/","/index"})
	public String getIndexPage() {
		return "index";
	}
	
}
