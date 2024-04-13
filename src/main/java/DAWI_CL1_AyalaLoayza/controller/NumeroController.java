package DAWI_CL1_AyalaLoayza.controller;

import DAWI_CL1_AyalaLoayza.model.NumeroModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

public class NumeroController {
    @GetMapping("/serieNumero")
    public String inicioSerieNumero(Model model){
        model.addAttribute("SerieModel", new NumeroModel());
        model.addAttribute("mostrarSerie", false);
        return "serieNumero";
    }

    public String determinarSerieLetras(@ModelAttribute("SerieModel") NumeroModel numeroModel,
                                       Model model){
        int numero = numeroModel.getNumero();

        if (numero > 0 && numero <= 26) {
            StringBuilder serieLetras = new StringBuilder();
            for (int i = 1; i <= numero; i++) {
                char letra = (char) ('A' + i - 1);
                serieLetras.append(i).append(" = ").append(letra).append(", ");
            }

            model.addAttribute("mostrarSerie", true);
            model.addAttribute("resultado", "La serie en letras es: " + serieLetras);
        } else {
            model.addAttribute("resultado", "El número límite debe estar entre 1 y 26.");
        }
        return "serieNumero";
    }
}
