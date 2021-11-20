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

import br.com.fiap.DoeAE.model.Doador;
import br.com.fiap.DoeAE.repository.DoadorRepository;

@Controller
@RequestMapping("/doador")
public class DoadorController {
	
	@Autowired
	private DoadorRepository doadorRepository;
	
	@GetMapping
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("doador");
		List<Doador> doadores = doadorRepository.findAll();
		mv.addObject("doadores", doadores);
		return mv;
	}
	
	@RequestMapping("/new")
	public String create(Doador doador) {
		return "doador-form";
	}
	
	@PostMapping
	public String save(@Valid Doador doador, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) return "doador-form";
		doadorRepository.save(doador);
		redirect.addFlashAttribute("message", "Doador cadastrado!");
		return "redirect:/doador";
	}
	
	@GetMapping("/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Doador doador = doadorRepository.findById(id).get();
        model.addAttribute("doador", doador);
        return "doador-edit";
    }
	
	@PostMapping("/{id}")
    public String edit(@PathVariable("id") Long id, @Validated Doador doador, BindingResult result, Model model) {
    	if(result.hasErrors()) {
    		return "doador";
    	}
    	doadorRepository.save(doador);
    	model.addAttribute("doadores", doadorRepository.findAll());
    	return "doador";
    }
	
	@GetMapping("/excluir/{id}")
    public String remove(@PathVariable("id") Long id, Model model) {
    	doadorRepository.deleteById(id);
    	model.addAttribute("doadores", doadorRepository.findAll());
    	return "doador";
    }
}