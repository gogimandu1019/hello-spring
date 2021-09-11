package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")    //맵핑된 url이 있는 소스부터 먼저 호출-index.html 기존에 만든 건 무시당함
    public String home(){
        return "home";
    }
}
