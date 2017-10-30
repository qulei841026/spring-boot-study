package org.qulit.sample.flow.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/basic")
public class BasicController {

    //http://localhost:8080/basic/
    @GetMapping
    public String doGet() {
        return "Hello World !";
    }

    //http://localhost:8080/basic/temp1/2
    @RequestMapping(value = "/temp1/{pid:\\d+}", method = RequestMethod.GET)
    public void doGetTemp1(@PathVariable Long pid) {
        System.out.println("doGetTemp1: {pid=" + pid + "}");
    }

    //http://localhost:8080/basic/temp2?uName=huangshang&pwd=gugong
    @RequestMapping(value = "/temp2", method = RequestMethod.GET)
    public void doGetTemp2(@RequestParam("uName") String userName, @RequestParam("pwd") String pwd) {
        System.out.println("doGetTemp2: {uName=" + userName + ", pwd=" + pwd + "}");
    }

    @RequestMapping(value = "/my-post", method = RequestMethod.POST)
    public void doPost(@RequestParam(value = "name") String name,
                       @RequestParam(value = "pwd") String pwd) {
        System.out.println("name = " + name + ", pwd = " + pwd);
        System.out.println("doPost");
    }

    @RequestMapping(value = "/my-post-json", method = RequestMethod.POST)
    public void doPostJson(@RequestBody String object) {
        System.out.println("doPostJson = " + object);
    }

}
