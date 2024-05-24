package com.agenda.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agenda.modelo.entidad.Moto;
import com.agenda.modelo.servicio.IMotoServicio;

@Controller
@RequestMapping("/vistas/motos")
public class ControladorMoto {
	@Autowired
	private IMotoServicio motoServicio;
	//ruta para listar las motos en una tabla
	@GetMapping("/")
	public String listarMotos(Model modelo) {
		//crear una lista de los datos a mostrar
		List<Moto> listadoMotos=motoServicio.listaTodos();
		modelo.addAttribute("motos",listadoMotos);
		return "/vistas/motos/listar";
	}
	
	//ruta para crear 
	@GetMapping("/create")
	public String crear(Model modelo) {
		//crear el objeto de tipo moto
		Moto moto=new Moto();
		modelo.addAttribute("Titulo","Formulario: Nueva Moto ");
		modelo.addAttribute("moto",moto);
		return"/vistas/motos/registromoto";
	}
	
	//Ruta para guardar
	@PostMapping("/save")
	public String guardar(@ModelAttribute Moto moto,Model modelo) {
		modelo.addAttribute("Titulo","Formulario: Nueva Moto ");
		modelo.addAttribute("moto",moto);
		//Utilizar el servico para almacenar en la BD
		motoServicio.guardar(moto);
		return "redirect:/vistas/motos/";
	}
	//ruta para editar
	@GetMapping("/edit/{id}")
	public String edtar(@PathVariable("id") int idMoto,Model modelo) {
		Moto moto=new Moto();
		//validar si el id existe
		if(idMoto>0) {
			moto=motoServicio.buscarPorId(idMoto);
			if(moto==null) {
				return "redirect:/vistas/motos/";
			}
			}
		else {return "redirect:/vistas/motos/";
		
	}
		modelo.addAttribute("Titulo","Formulario: Editar Moto ");
		modelo.addAttribute("moto",moto);
		return"/vistas/motos/registromoto";
	}
	//ruta para eliminar
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable ("id") Integer idMoto) {
		Moto moto=new Moto();
		//validar si el id existe
		if(idMoto>0) {
			moto=motoServicio.buscarPorId(idMoto);
			if(moto==null) {
				return "redirect:/vistas/motos/";
			}
			}
		else {return "redirect:/vistas/motos/";
		
	}
		//invocar el servicio el eliminar
		motoServicio.eleminar(idMoto);
		return "redirect:/vistas/motos/";
	}
}