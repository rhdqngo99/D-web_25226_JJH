package com.koreait.www;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.IntStream;

@Slf4j
@Controller
public class TestController {

    @GetMapping("/")
    public String index(Model m){
        m.addAttribute("msg","Test Thymeleaf!!");
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee","fff");
        m.addAttribute("list", list);
        return "index";
    }

    @GetMapping("/ex01")
    public String ex01(Model model){
        List<String> list = Arrays.asList("hong","kim","lee","pack","choi");
        model.addAttribute("list",list);
        return "/ex01/ex01";
    }

    @GetMapping("/ex02")
    public String ex02(@RequestParam("name") String name,
                       @RequestParam("age") int age,
                       Model model){
        log.info("name >> {}",name);
        log.info("age >> {}",age);
        TestVO tvo = new TestVO("소나타","1234");
        model.addAttribute("tvo", tvo);
        return "/ex01/ex02";
    }

    @GetMapping("/ex03")
    public String ex03(Model model){
        List<String> strList = IntStream.range(1,10)
                .mapToObj(i -> "data "+i)
                .toList();
        log.info("strList >> {}",strList);
        model.addAttribute("strList", strList);

        Map<String,Integer> map = new HashMap<>();
        map.put("apple", 500);
        map.put("orange",700);
        map.put("banana",300);
        map.put("kiwi",300);
        model.addAttribute("map",map);

        List<TestVO> testList = new ArrayList<>();
        testList.add(new TestVO("car1","1234"));
        testList.add(new TestVO("car2","1111"));
        testList.add(new TestVO("car3","2222"));
        testList.add(new TestVO("car4","2333"));
        model.addAttribute("testList", testList);
        return "/ex01/ex03";
    }
}