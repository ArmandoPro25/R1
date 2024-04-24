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
import mx.utng.jarm.model.entity.Reproduccion;
import mx.utng.jarm.model.service.IReproduccionService;

@Controller
@SessionAttributes("reproduccion")
public class ReproduccionController {
    // Inyectamos una dependencia del servicio
    @Autowired
    private IReproduccionService reproduccionService;

    // Manda llamar este método en una petición GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/reproduccion/list", "/reproduccion", "/reproduccion/"})
    public String list(Model model) {
        model.addAttribute("title", "Listas de Reproducción");
        model.addAttribute("reproducciones", reproduccionService.list());
        return "relist";
    }

    // Petición que contenga al final de la url /form
    @GetMapping("/reproduccion/form")
    public String create(Model model) {
        model.addAttribute("title", "Formulario de Listas de Reproducción");
        model.addAttribute("reproduccion", new Reproduccion());
        return "reform";
    }

    // Peticion que contenga al final de la url /form
    @GetMapping("/reproduccion/form/{id}")
    public String update(@PathVariable Long id, Model model) {
        Reproduccion reproduccion = null;
        if (id > 0) {
            reproduccion = reproduccionService.getById(id);
        } else {
            return "redirect:/reproduccion/list";
        }

        model.addAttribute("title", "Editar Lista de Reproducción");
        model.addAttribute("reproduccion", reproduccion);
        return "reform";
    }

    @PostMapping("/reproduccion/form")
    public String save(@Valid Reproduccion reproduccion, BindingResult br, Model model) {

        if (br.hasErrors()) {
            model.addAttribute("title", "Formulario de Listas de Reproduccion");
            return "reform";
        }

        reproduccionService.save(reproduccion);
        return "redirect:/reproduccion/list";
    }

    @GetMapping("/reproduccion/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        if (id > 0) {
            reproduccionService.delete(id);
        }
        return "redirect:/reproduccion/list";
    }

}
