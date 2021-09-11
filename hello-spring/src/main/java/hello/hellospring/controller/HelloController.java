package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "Spring!");
        return "hello"; //resources/templates/hello.html 을 자동으로 찾아가서 렌더링 : 뷰리졸버가 화면을 찾아서 처리
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model){   //required false 면 없어도 동작
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello: " + name; //바디에 name을 직접
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();//그냥 스트링이 아닌 객체로 주네? -> json방식으로 만들어서 http 응답에 반환
        hello.setName(name);

        return hello; //json 방식 - 키밸류로 이루어진 구조 key:value
    }

    static class Hello{
        private String name;//키

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
