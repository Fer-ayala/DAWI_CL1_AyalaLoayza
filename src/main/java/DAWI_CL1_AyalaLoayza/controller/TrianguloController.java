package DAWI_CL1_AyalaLoayza.controller;

import DAWI_CL1_AyalaLoayza.model.TrianguloModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TrianguloController {

    @GetMapping("/triangulo")
    public String inicioTipoTriangulo(Model model){
        model.addAttribute("trianguloModel", new TrianguloModel());
        model.addAttribute("mostrarTipo", false);
        return "triangulo";
    }

    @PostMapping("/triangulo")
    public String determinarTipoTriangulo(@ModelAttribute("trianguloModel") TrianguloModel trianguloModel,
                                          Model model){
        double lado1 = trianguloModel.getLado1();
        double lado2 = trianguloModel.getLado2();
        double lado3 = trianguloModel.getLado3();
        String tipo = "";

        if (lado1 == lado2 && lado2 == lado3) {
            tipo = "Equilátero";
        } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
            tipo = "Isósceles";
        } else {
            tipo = "Escaleno";
        }

        model.addAttribute("mostrarTipo", true);
        model.addAttribute("resultado", "El triángulo con lados de longitud "
                + lado1 + ", " + lado2 + " y " + lado3 + " es de tipo " + tipo);
        return "triangulo";
    }
}
