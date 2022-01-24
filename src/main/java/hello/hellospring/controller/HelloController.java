package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // 슬러시 헬로라고 들어오면 아래를 호출. get 방식.
    public String hello(Model model)
    {
        model.addAttribute("data" , "Hello!");
        return "hello"; //템플릿의 hello.html 한테 가서 렌더링해라.
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model) //@RE... -> get으로 뒤에꺼를 받아서 string의 name 넣는다.
    {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //body에 직접 넣겠다.
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;  //이 문자가 그대로 내려감. html을 변환해서 내려보내는 것이 아님.
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //객체를 반환하면 JSON 으로 반환하는게 디폴트이다.
    }
    static class Hello { //static으로 만듦면 클래스 안에서 . 으로 사용 가능함
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
