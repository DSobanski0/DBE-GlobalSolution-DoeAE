package br.com.fiap.DoeAE.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.DoeAE.model.Alimento;
import br.com.fiap.DoeAE.repository.AlimentoRepository;

@Controller
@RequestMapping("/alimento")
public class AlimentoController {

	@Autowired
	private AlimentoRepository alimentoRepository;
	
	@GetMapping
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("alimento");
		List<Alimento> alimentos = alimentoRepository.findAll();
		mv.addObject("alimentos", alimentos);
		return mv;
	}
	
	@RequestMapping("/new")
	public String create(Alimento alimento) {
		return "alimento-form";
	}
	
	@PostMapping
	public String save(@Valid Alimento alimento, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) return "alimento-form";
		alimentoRepository.save(alimento);
		redirect.addFlashAttribute("message", "Alimento cadastrado!");
		return "redirect:/alimento";
	}
	
	@GetMapping("/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Alimento alimento = alimentoRepository.findById(id).get();
        model.addAttribute("alimento", alimento);
        return "alimento-edit";
    }
	
	@PostMapping("/{id}")
    public String edit(@PathVariable("id") Long id, @Validated Alimento alimento, BindingResult result, Model model) {
    	if(result.hasErrors()) {
    		return "alimento";
    	}
    	alimentoRepository.save(alimento);
    	model.addAttribute("alimentos", alimentoRepository.findAll());
    	return "alimento";
    }
}
