package devtools;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		int a=89;
		int b=78;
		int c=93;
		int d=85;
		return "this is just testing   sum of a and b is  " +(a + b + c+d);
		
	}
}
