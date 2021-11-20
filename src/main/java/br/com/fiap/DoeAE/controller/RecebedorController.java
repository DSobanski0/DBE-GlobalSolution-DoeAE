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

import br.com.fiap.DoeAE.model.Recebedor;
import br.com.fiap.DoeAE.repository.RecebedorRepository;

@Controller
@RequestMapping("/recebedor")
public class RecebedorController {
	
	@Autowired
	private RecebedorRepository recebedorRepository;
	
	@GetMapping
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("recebedor");
		List<Recebedor> recebedors = recebedorRepository.findAll();
		mv.addObject("recebedores", recebedors);
		return mv;
	}
	
	@RequestMapping("/new")
	public String create(Recebedor recebedor) {
		return "recebedor-form";
	}
	
	@PostMapping
	public String save(@Valid Recebedor recebedor, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) return "recebedor-form";
		recebedorRepository.save(recebedor);
		redirect.addFlashAttribute("message", "Recebedor cadastrado!");
		return "redirect:/recebedor";
	}
	
	@GetMapping("/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Recebedor recebedor = recebedorRepository.findById(id).get();
        model.addAttribute("recebedor", recebedor);
        return "recebedor-edit";
    }
	
	@PostMapping("/{id}")
    public String edit(@PathVariable("id") Long id, @Validated Recebedor recebedor, BindingResult result, Model model) {
    	if(result.hasErrors()) {
    		return "recebedor";
    	}
    	recebedorRepository.save(recebedor);
    	model.addAttribute("recebedores", recebedorRepository.findAll());
    	return "recebedor";
    }
	
	@GetMapping("/excluir/{id}")
    public String remove(@PathVariable("id") Long id, Model model) {
    	recebedorRepository.deleteById(id);
    	model.addAttribute("recebedores", recebedorRepository.findAll());
    	return "recebedor";
    }
}