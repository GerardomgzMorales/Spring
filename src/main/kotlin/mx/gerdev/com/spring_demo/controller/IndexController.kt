package mx.gerdev.com.spring_demo.controller

import mx.gerdev.com.spring_demo.models.Usuario
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/app")
class IndexController {

    @Autowired
    @Qualifier("tituloMensaje")
    private lateinit var mensajeStr: String

    @Autowired
    @Qualifier("mensajePerfil")
    private lateinit var tituloPerfil: String

    @GetMapping("/index", "/", "/home")
    fun mensaje(vista: ModelMap): String {
        vista.addAttribute("mensaje", this.mensajeStr)
        return "index"
    }

    @GetMapping("/perfil")
    fun perfilUsuario(vista: Model): String {
        val usuario = Usuario()
        usuario.nombre = "Gerardo"
        usuario.apellidos = "Morales Gómez"
        usuario.e_mail = "gerardo@gmail.com "
        vista.addAttribute("usuario", usuario)
        vista.addAttribute("titulo", "$tituloPerfil: ${usuario.nombre}")
        return "perfil_usuario"
    }

    @GetMapping("/usuarios")
    fun listaUsuarios(vista: Model): String {

        vista.addAttribute("tituloPagina", "Hola mensaje de titulo")
        return "listado/usuarios"
    }

    @ModelAttribute("mutableUsuario")
    fun listaCompleta(): MutableList<Usuario> {
        //tener un model View Global para cualquier metodo habdler declarado
        val mutableUsuarioLista: MutableList<Usuario> = mutableListOf()

        mutableUsuarioLista.add(Usuario("Israel", "Morales", "israel@gmailc.om"))
        mutableUsuarioLista.add(Usuario("Brenda Lee", "Morales", "brenda@gmailc.om"))
        mutableUsuarioLista.add(Usuario("Gerardo", "Morales", "israel@gmailc.om"))
        mutableUsuarioLista.add(Usuario("Irene", "Morales", "irene@gmailc.om"))
        mutableUsuarioLista.add(Usuario("Miguel", "Morales", "miguel@gmailc.om"))
        return mutableUsuarioLista
    }
}