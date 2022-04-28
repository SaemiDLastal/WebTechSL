package de.htw.berlin.Einkaufsliste1.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HelloWorldcontroller {

    @GetMapping(path = "/")
    public ModelAndView helloWorldSide()
    {
        return new ModelAndView("test<-hello world");
    }


}
