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

import br.com.fiap.DoeAE.model.DoadorAlimentoRecebedor;
import br.com.fiap.DoeAE.repository.AlimentoRepository;
import br.com.fiap.DoeAE.repository.DoadorAlimentoRecebedorRepository;
import br.com.fiap.DoeAE.repository.DoadorRepository;
import br.com.fiap.DoeAE.repository.RecebedorRepository;

@Controller
@RequestMapping("/doacao")
public class DoadorAlimentoRecebedorController {

	@Autowired
	private DoadorAlimentoRecebedorRepository doadorAlimentoRecebedorRepository;
	
	@Autowired
	private DoadorRepository doadorRepository;

	@Autowired
	private AlimentoRepository alimentoRepository;

	@Autowired
	private RecebedorRepository recebedorRepository;

	@GetMapping
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("doacao");
		List<DoadorAlimentoRecebedor> doacoes = doadorAlimentoRecebedorRepository.findAll();
		mv.addObject("doacoes", doacoes);
		return mv;
	}
	
	@RequestMapping("/new")
	public ModelAndView create(DoadorAlimentoRecebedor doadorAlimentoRecebedor) {
		ModelAndView mv = new ModelAndView("doacao-form");
		mv.addObject("doadores", doadorRepository.findAll());
		mv.addObject("recebedores", recebedorRepository.findAll());
		mv.addObject("alimentos", alimentoRepository.findAll());
		return mv;
	}
	
	@PostMapping
	public String save(@Valid DoadorAlimentoRecebedor doadorAlimentoRecebedor, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) return "doacao-form";
		doadorAlimentoRecebedorRepository.save(doadorAlimentoRecebedor);
		redirect.addFlashAttribute("message", "Doação cadastrada!");
		return "redirect:/doacao";
	}
	
	@GetMapping("/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("doacao-edit");
		mv.addObject("doadores", doadorRepository.findAll());
		mv.addObject("recebedores", recebedorRepository.findAll());
		mv.addObject("alimentos", alimentoRepository.findAll());
        DoadorAlimentoRecebedor doadorAlimentoRecebedor = doadorAlimentoRecebedorRepository.findById(id).get();
		mv.addObject("doadorAlimentoRecebedor", doadorAlimentoRecebedor);
        return mv;
    }
	
	@PostMapping("/{id}")
    public String edit(@PathVariable("id") Long id, @Validated DoadorAlimentoRecebedor doadorAlimentoRecebedor, BindingResult result, Model model) {
    	if(result.hasErrors()) {
    		return "doacao";
    	}
    	doadorAlimentoRecebedorRepository.save(doadorAlimentoRecebedor);
    	model.addAttribute("doadorAlimentoRecebedores", doadorAlimentoRecebedorRepository.findAll());
    	return "redirect:/doacao";
    }
}