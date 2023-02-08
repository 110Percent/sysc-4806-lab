package davies.curtis.sysc4806.labs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @Autowired
    GreetingService greetingService;

    @GetMapping("/")
    public String rootRequest() {
        return greetingService.greet();
    }

}
