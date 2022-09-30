package andreas.fenyvesi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoClass {

	@GetMapping("/getMsg")
	public String getMessage() {
		return "Welcome to my first Steps";
	}
}
