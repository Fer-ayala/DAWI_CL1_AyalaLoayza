package DAWI_CL1_AyalaLoayza.controller;

import DAWI_CL1_AyalaLoayza.model.ComputadoraModel;
import DAWI_CL1_AyalaLoayza.model.TrianguloModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("/computadora")
public class ComputadoraController {
    @GetMapping("/computadora")
    public String inicioComputadora(Model model){
        model.addAttribute("ComputadoraModel", new ComputadoraModel());
        model.addAttribute("calcularDescuento", false);
        return "computadora";
    }
@PostMapping("/computadora")
    public String descComputadora(@ModelAttribute("ComputadoraModel") ComputadoraModel computadoraModel,
                                  Model model){
        int cantidad = computadoraModel.getCantidad();
        double precio = computadoraModel.getPrecio();
        double totalcompra = cantidad * precio;
        double totaldescuento;

        if(cantidad < 5){
            totaldescuento = totalcompra * 0.1;

        }else if (cantidad >= 5 && cantidad < 10) {
            totaldescuento = totalcompra * 0.2;
        } else {
            totaldescuento = totalcompra * 0.4;
        }

        double precioTotal = totalcompra - totaldescuento;

    model.addAttribute("calcularDescuento", true);
    model.addAttribute("resultado", "El precio Total de la compra es "
            + totalcompra + " soles que aplica con un descuento de " + totaldescuento + " soles y el precio final es " + precioTotal);

    return "computadora";
}

}
