package mx.gerdev.com.spring_demo.configuracion

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@ComponentScan("mx.gerdev.com.spring_demo")
@PropertySource("classpath:string/string.properties", encoding = "UTF-8")
class IndexConfiguracion {

    @Value("\${mensajeUno}")
    private val mensaje: String? = null

    @Value("\${mensajePerfil}")
    private val mensajePerfil: String? = null

    @Bean
    fun tituloMensaje(): String? {
        return this.mensaje
    }

    @Bean
    fun mensajePerfil(): String? {
        return this.mensajePerfil
    }

    @Bean
    fun nuevaFuncion(): String {
        return "Gerardo Morales"

    }

}