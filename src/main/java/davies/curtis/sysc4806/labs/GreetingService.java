package davies.curtis.sysc4806.labs;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String greet() {
        return "Hi :)";
    }
}
