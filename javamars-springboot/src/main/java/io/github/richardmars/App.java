package io.github.richardmars;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */

@RestController
@EnableAutoConfiguration
public class App 
{
	@RequestMapping("/")
	public String home() {
		return "hello";
	}
	
	@RequestMapping("/httpclientdemo")
	public String httpClientDemo(HttpServletRequest request) {
		if (("GET").equals(request.getMethod())) {
			return "You should post with params";
		} else {
			String value = request.getParameter("name");
			return value;
		}
	}
	
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}
