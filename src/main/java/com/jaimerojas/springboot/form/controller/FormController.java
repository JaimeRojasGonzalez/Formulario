package com.jaimerojas.springboot.form.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.jaimerojas.springboot.form.models.Usuario;


@Controller
@SessionAttributes("usuario")
public class FormController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "fechaNac", new CustomDateEditor(dateFormat, true));

	}

	@GetMapping("/form")
	public String formulario(Model model) {

		Usuario usuario = new Usuario();

		/*
		 * usuario.setNombre("Jaime"); usuario.setApellido("Rojas");
		 * usuario.setEmail("jaimerg813@gmail.com"); usuario.setEdad(29);
		 */

		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Datos del formulario");

		return "form";
	}

	@PostMapping("/form")
	public String resultado(@Valid Usuario usuario, BindingResult result, Model model) {
		
		if (result.hasErrors()) {

			model.addAttribute("titulo", "Resultado formulario");

			return "form";
		}

		model.addAttribute("usuario", usuario);

		return "redirect:/ver";
	}

	@GetMapping("/ver")
	public String ver(@SessionAttribute(name = "usuario", required = false) Usuario usuario, Model model,
			SessionStatus status) {

		if (usuario == null) {
			return "redirect:/form";
		}

		model.addAttribute("titulo", "Resultado formulario");

		status.setComplete();
		return "resultado";
	}

}
