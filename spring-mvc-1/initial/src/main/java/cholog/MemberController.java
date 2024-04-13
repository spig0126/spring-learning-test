package cholog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

    @GetMapping("/hello")
    public String world(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        // TODO: /hello 요청 시 resources/templates/static.html 페이지가 응답할 수 있도록 설정하세요.
        // TODO: 쿼리 파라미터로 name 요청이 들어왔을 때 해당 값을 hello.html에서 사용할 수 있도록 하세요.
        model.addAttribute("name", name);
        return "hello";
        /*
        @GetMapping("/hello")
        - url을 이 Controller method와 매핑시켜주는 일을 한다

        @RequestParam
        - used to extract request parameters from URL query string or form data
        - maps value of query parameter or form field to method parameter -> 여기선 String name이 method parameter임
        - name = "name": 받고자 하는 파라미터 변수 이름은 'name'임을 나타냄

        Model
        - Model은 controller에서 view로 데이터를 넘길 수 있는 인터페이스 역할을 함

        Controller return
        - return {렌더링하고자하는 템플릿 페이지 이름}
        - 렌더링하고 싶은 페이지를 반환하는 역할을 함
        - 렌더링하고자하는 템플릿 페이지 이름을 return한다.
         */
    }

    @GetMapping("/json")
    @ResponseBody
    public Person json() {
        // TODO: /json 요청 시 {"name": "brown", "age": 20} 데이터를 응답할 수 있도록 설정하세요.
        return new Person("brown",  20);

        /*
        @ResponseBody
        - annotation in Spring MVC
        - the return value of a method should be directly written to the HTTP response body, rather than being interpreted as a view name and resolved by a view resolver to render an HTML page.
         */
    }
}
