package hotelaria.unialfa.leonardo.controller;

import hotelaria.unialfa.leonardo.model.Hospede;
import hotelaria.unialfa.leonardo.repository.HospedeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hospedes")
public class HospedeController {

    private final HospedeRepository hospedeRepository;

    public HospedeController(HospedeRepository hospedeRepository) {
        this.hospedeRepository = hospedeRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("hospedes", hospedeRepository.findAll());
        return "hospedes";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("hospede", new Hospede());
        return "form-hospede";
    }

    @PostMapping
    public String salvar(@ModelAttribute Hospede hospede) {
        hospedeRepository.save(hospede);
        return "redirect:/hospedes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Hospede hospede = hospedeRepository.findById(id).orElseThrow();
        model.addAttribute("hospede", hospede);
        return "form-hospede";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        hospedeRepository.deleteById(id);
        return "redirect:/hospedes";
    }
}
