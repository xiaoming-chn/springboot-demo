package top.xiaoming.demo.springbootdemo.webapp.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import top.xiaoming.demo.springbootdemo.webapp.example.service.impl.ExampleServiceImpl;

import javax.annotation.Resource;

@RestController
@RequestMapping("/example")
public class ExampleController {
    @Resource
    private ExampleServiceImpl exampleService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listTbs() {
        ModelAndView mv = new ModelAndView("example/index");
        mv.addObject("tbs", exampleService.getAllExampleTb());
        return mv;
    }

}
