package mx.gerdev.com.spring_demo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

    @GetMapping("", "/")
    fun home(): String {
        //return "redirect:/app/usuarios"
        //Solo depacha request de la rutra y no externos


        return "forward:/app/usuarios"
    }
}