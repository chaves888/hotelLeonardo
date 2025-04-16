package hotelaria.unialfa.leonardo.controller;

import hotelaria.unialfa.leonardo.model.Suite;
import hotelaria.unialfa.leonardo.repository.SuiteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/suites")
public class SuiteController {

    private final SuiteRepository suiteRepository;

    public SuiteController(SuiteRepository suiteRepository) {
        this.suiteRepository = suiteRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("suites", suiteRepository.findAll());
        return "suites";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("suite", new Suite());
        return "form-suite";
    }

    @PostMapping
    public String salvar(@ModelAttribute Suite suite) {
        suiteRepository.save(suite);
        return "redirect:/suites";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Suite suite = suiteRepository.findById(id).orElseThrow();
        model.addAttribute("suite", suite);
        return "form-suite";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        suiteRepository.deleteById(id);
        return "redirect:/suites";
    }
}
