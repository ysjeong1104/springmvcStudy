package hello.springmvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String username = req.getParameter("username");
        int age = Integer.parseInt( req.getParameter("age"));

        log.info("username ={}, age={}", username, age);

        resp.getWriter().write("ok");
    }

    @RequestMapping("/request-param-v2")
    @ResponseBody
    public String requestParamV2(
            @RequestParam("username") String username,
            @RequestParam("age") int age
    ) {

        log.info("username ={}, age={}", username, age);

        return "ok";

    }

    @RequestMapping("/request-param-v3")
    @ResponseBody
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age
    ) { //권장

        log.info("username ={}, age={}", username, age);

        return "ok";

    }

    @RequestMapping("/request-param-v4")
    @ResponseBody
    public String requestParamV4(  String username, int age) {

        log.info("username ={}, age={}", username, age);

        return "ok";

    }

    @RequestMapping("/request-param-required")
    @ResponseBody
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age
    ) { //권장
        /**
         *
         * int 기본형 데이터는 null넣을수 없음
         * Integer 로 사용 하여 null 사용 가능하게 처리
         *
         */
        log.info("username ={}, age={}", username, age);

        return "ok";

    }

    @RequestMapping("/request-param-default")
    @ResponseBody
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") Integer age
    ) { //권장
        /**
         *
         * int 기본형 데이터는 null넣을수 없음
         * Integer 로 사용 하여 null 사용 가능하게 처리
         *
         */
        log.info("username ={}, age={}", username, age);

        return "ok";

    }
    @RequestMapping("/request-param-map")
    @ResponseBody
    public String requestParamMap(
            @RequestParam Map<String, Object> paramMap
    ) { //권장
        /**
         *
         * 요청 파라미터 하나에 값이 여러개일 경우 MultiValueMap 사용 
         *
         */
        log.info("username ={}, age={}", paramMap.get("username"), paramMap.get("age"));

        return "ok";

    }


}
