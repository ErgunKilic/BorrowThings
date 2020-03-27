package ch.hearc.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController implements ErrorController {

    private static final String PATH = "/error";

	@RequestMapping(value="/")
    public String home(){
        return "home";
    }

    @RequestMapping(value="/admin")
    public String admin(){
        return "admin";
    }
   
    @RequestMapping(value="/login")
    public String login(){
        return "login";
    }
    
//    @RequestMapping(value="/register")
//    public String register(){
//        return "register";
//    }
   
    @RequestMapping(value="/403")
    public String Error403(){
        return "403";
    }
    
    @RequestMapping(value = PATH)
    public String Error() {
        return "error";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
