package mx.utng.jarm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import jakarta.validation.Valid;
import mx.utng.jarm.model.entity.Consumo;
import mx.utng.jarm.model.service.IConsumoService;

@Controller
@SessionAttributes("consumo")
public class ConsumoController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IConsumoService consumoService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/consumo/list","/consumo","/consumo/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Consumo");
    model.addAttribute("consumos", consumoService.list());
    return "clist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/consumo/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Consumo");
        model.addAttribute("consumo", new Consumo());
        return "cform";
    }

    @GetMapping("/consumo/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Consumo consumo = null;
        if (id>0) {
            consumo = consumoService.getById(id);
        }else{
            return "redirect:clist";
        }

        model.addAttribute("title", "Editar Consumo");
        model.addAttribute("consumo", consumo);
        return "cform";
    }


    @PostMapping ("/consumo/form")
    public String save(@Valid Consumo consumo, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Consumo");
            return "cform";
        }

        consumoService.save(consumo);
        return "redirect:/consumo/list";
    }

    @GetMapping("/consumo/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            consumoService.delete(id);
        }
        return "redirect:/consumo/list";
    }

}

