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
import mx.utng.jarm.model.entity.Incidencia;
import mx.utng.jarm.model.service.IIncidenciaService;

@Controller
@SessionAttributes("incidencia")
public class IncidenciaController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IIncidenciaService incidenciaService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/incidencia/list","/incidencia","/incidencia/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de incidencias");
    model.addAttribute("incidencias", incidenciaService.list());
    return "ilist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/incidencia/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Incidencias");
        model.addAttribute("incidencia", new Incidencia());
        return "iform";
    }

    @GetMapping("/incidencia/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Incidencia incidencia = null;
        if (id>0) {
            incidencia = incidenciaService.getById(id);
        }else{
            return "redirect:ilist";
        }

        model.addAttribute("title", "Editar Incidencia");
        model.addAttribute("incidencia", incidencia);
        return "iform";
    }


    @PostMapping ("/incidencia/form")
    public String save(@Valid Incidencia incidencia, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Incidencias");
            return "iform";
        }

        incidenciaService.save(incidencia);
        return "redirect:/incidencia/list";
    }

    @GetMapping("/incidencia/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            incidenciaService.delete(id);
        }
        return "redirect:/incidencia/list";
    }

}

