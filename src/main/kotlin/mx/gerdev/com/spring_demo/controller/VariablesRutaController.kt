package mx.gerdev.com.spring_demo.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("/variables")
class VariablesRutaController {

    @GetMapping("/", "")
    fun index(): String {
        return "variables/paramrutas"
    }

    @GetMapping("/string/{texto}")
    fun variablePorRuta(@PathVariable(name = "texto") txt: String?, vista: Model): String {
        vista.addAttribute("parametroTexto", "se muestra los valores de la ruta con pathvariable: $txt")
        return "variables/ver"
    }

    @GetMapping("/strings/{texto}/{numero}")
    fun variablePorRutaDos(
        @PathVariable(name = "texto") txt: String?,
        @PathVariable numero: Int?,
        vista: Model
    ): String {
        vista.addAttribute(
            "parametroTexto",
            "se muestra los valores de la ruta con pathvariable: $txt y el numero es $numero"
        )
        return "variables/ver"
    }

}