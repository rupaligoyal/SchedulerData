package app.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@RequestMapping(value="/test", method = RequestMethod.GET)
	public String testme() {
		return "Hello World";
	}
}
