package cn.sd.sprinmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Index2Controller {
//    @RequestMapping(value = "/index")
//    public void testIndex() {
//		System.out.println("index page ");
//    }

    @RequestMapping(value = "/testGet", method = RequestMethod.GET)
    public String testGet() {
        return "success";
    }

    @RequestMapping(value = "/testPost", method = RequestMethod.POST)
    public String testPost() {
        return "success";
    }

    @RequestMapping(value = "/testPut", method = RequestMethod.PUT)
    public String testPut() {
        System.out.println("testPut method runs");
        return "redirect:/index";
    }

    @RequestMapping(value = "/testDelete", method = RequestMethod.DELETE)
    public String testDelete() {
        return "redirect:/index";
    }

}
