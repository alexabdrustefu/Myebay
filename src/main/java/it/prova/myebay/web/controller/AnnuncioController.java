package it.prova.myebay.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import it.prova.myebay.dto.AnnuncioDTO;
import it.prova.myebay.dto.CategoriaDTO;
import it.prova.myebay.model.Annuncio;
import it.prova.myebay.service.AnnuncioService;
import it.prova.myebay.service.CategoriaService;

@Controller
@RequestMapping(value = "/annuncio")
public class AnnuncioController {
	@Autowired
	private AnnuncioService annuncioService;
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public ModelAndView listAllArticoli() {
		ModelAndView mv = new ModelAndView();
		List<Annuncio> articoli = annuncioService.listAllElements();
		mv.addObject("annuncio_list_attribute", AnnuncioDTO.createAnnuncioDTOListFromModelList(articoli,false));
		mv.setViewName("annuncio/list");
		return mv;
	}
	@GetMapping("/search")
	public String searchFilm(Model model) {
		model.addAttribute("annuncio_list_attribute",
				CategoriaDTO.createCategoriaDTOListFromModelList(categoriaService.listAll()));
		return "public/annuncio/search";
	}

	@PostMapping("/list")
	public String listArticoli(AnnuncioDTO annuncioExample, ModelMap model) {
		List<Annuncio> annunci = annuncioService.findByExample(annuncioExample.buildAnnuncioModel());
		model.addAttribute("annuncio_list_attribute", AnnuncioDTO.createAnnuncioDTOListFromModelList(annunci,false));
		return "public/annuncio/list";
	}

	@GetMapping("/show/{idFilm}")
	public String showFilm(@PathVariable(required = true) Long idAnnuncio, Model model) {
		model.addAttribute("show_annuncio_attr",
				AnnuncioDTO.buildAnnuncioDTOFromModel(annuncioService.caricaSingoloElementoEager(idAnnuncio), true));
		return "annuncio/show";
	}
	
	
	
}
