package com.example.demo.controller;

import com.example.demo.dto.test.TestDto;
import com.example.demo.entity.TestEntity;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TestController {

    TestService testService;

    @Autowired
    TestController(TestService testService){
        this.testService = testService;
    }

    // http://127.0.0.1:8081/api/v1/
    @GetMapping(value = "/")
    public String getMapping(){
        return "getMapping";
    }

    // http://127.0.0.1:8081/api/v1/test?name=yb&age=3
    @GetMapping(value = "/test")
    public String getMapping1(@RequestParam String name, @RequestParam int age){
        return name + " " + age;
    }

    // http://127.0.0.1:8081/api/v1/test2?nickname=yb&age=3
    @GetMapping(value = "/test2")
    public String getMapping2(@RequestParam(name = "nickname") String name, @RequestParam int age){
        return name + " " + age;
    }

    // http://127.0.0.1:8081/api/v1/test3/99
    @GetMapping(value = "/test3/{id}")
    public String getMapping3(@PathVariable(name = "id") int age){
        return ""+age;
    }

    @PostMapping("/")
    public String postMapping(){
        return "postMapping";
    }

    // http://127.0.0.1:8081/api/v1/test
    /*
    {
      "id":3,
      "name":"yb",
      "age":3
    }
     */
    @PostMapping("/test")
    public String postMapping1(@RequestBody TestDto testDto){
        System.out.println("testDto = " + testDto);
        return testDto.toString();
    }

    @PutMapping("")
    public String putMapping(){
        return "put mapping";
    }

    @DeleteMapping
    public String deleteMapping(){
        return "delete Mapping";
    }

    //------------------------------------------------------------------------

    // http://127.0.0.1:8081/api/v1/
    @GetMapping(value = "/testentity")
    public List<TestEntity> getAllTestEntity(){
        return testService.getAllTestEntity();
    }

    // http://127.0.0.1:8081/api/v1/
        /*
    {
      "name":"yb",
      "age":3
    }
     */
    @PostMapping(value = "/testentity")
    public void saveTestEntity(@RequestBody TestDto testDto){
        testService.saveEntity(testDto);
    }
}
