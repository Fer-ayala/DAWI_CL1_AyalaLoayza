package DAWI_CL1_AyalaLoayza.controller;

import DAWI_CL1_AyalaLoayza.model.AguaModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AguaController {

    @GetMapping("/estado-agua")
    public String inicioEstadoAgua(Model model){
        model.addAttribute("AguaModel", new AguaModel());
        model.addAttribute("mostrarEstado", false);
        return "estado-agua";
    }

    @PostMapping("/estado-agua")
    public String determinarEstadoAgua(@ModelAttribute("AguaModel") AguaModel AguaModel,
                                       Model model){
        double temperatura = AguaModel.getTemperatura();
        String estado = "";

        if (temperatura < 0) {
            estado = "Sólido";
        } else if (temperatura < 100) {
            estado = "Líquido";
        } else {
            estado = "Gaseoso";
        }

        model.addAttribute("mostrarEstado", true);
        model.addAttribute("resultado", "El estado del agua a " + temperatura + "°C es: " + estado);
        return "estado-agua";
    }
}
