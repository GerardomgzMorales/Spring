package mx.gerdev.com.spring_demo.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import java.lang.NumberFormatException
import javax.servlet.http.HttpServletRequest


@Controller
@RequestMapping("/paramsEntrada")
class TomarDatosController {


    @GetMapping("/paramDos")
    fun index(): String {
        return "params/paramDos"
    }

    @GetMapping("/entradaUno")
    fun tomasrDatos(
        @RequestParam(name = "texto", required = false, defaultValue = "sin Valores") texto: String?,
        vista: Model
    ): String {

        vista.addAttribute("resultado", "El parametro enviado es: $texto")
        return "params/paramaOne"
    }


    @GetMapping("/mix_param")
    fun paramMix(
        @RequestParam texto: String?,
        @RequestParam numero: Int?,
        vista: Model
    ): String {

        vista.addAttribute("resultado", "El parametro enviado es: $texto y el numero es $numero \n")
        return "params/mixparam"
    }


    @GetMapping("/mix_param_dos")
    fun paramMix(
        request: HttpServletRequest,
        vista: Model
    ): String {
        val texto: String?
        var numero: Int?
        try {
            texto = request.getParameter("texto")
            numero = request.getParameter("numero").toInt()
            vista.addAttribute("resultado", "dinamico El parametro enviado es: $texto y el numero es $numero \n")
        } catch (e: NumberFormatException) {
            vista.addAttribute("resultado", "ERROR NO SON VALORES PERMITIDOS")
            e.printStackTrace()
        }
        return "params/mixparam"
    }


}