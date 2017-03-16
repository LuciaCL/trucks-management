package com.lucia.trucksmanagement.controller;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lucia.trucksmanagement.persistence.dao.Identifiable;
import com.lucia.trucksmanagement.service.GenericAdminService;

public abstract class GenericAdminController<S extends GenericAdminService<E,K>, E extends Identifiable<K>, K extends Serializable> {

	
	@Resource
	private S adminService;
	
	private Class<E> entityClass;
	
	@SuppressWarnings("unchecked")
    public GenericAdminController() {

        this.entityClass =  (Class<E>) ((ParameterizedType) getClass().
                getGenericSuperclass()).getActualTypeArguments()[1];
    }
	
	public abstract String getConcreteUrlPath();
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String get(ModelMap modelMap) throws InstantiationException, IllegalAccessException {
		
		E form = entityClass.newInstance();
		modelMap.addAttribute("form", form);
		return getConcreteUrlPath() + "/create";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String submit(@ModelAttribute("form") E entity, ModelMap modelMap) {
		
		//TODO: validate
		
		adminService.create(entity);
		
		return "redirect:/" + getConcreteUrlPath() + "/list";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listEntities(ModelMap modelMap) {
		
		List<E> entities = adminService.findAll();
		modelMap.addAttribute("entities", entities);
		return getConcreteUrlPath()+"/list";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(@RequestParam(value="id", required=true) K id, ModelMap modelMap) {
		
		adminService.remove(id);
		return "redirect:/" + getConcreteUrlPath() + "/list";
	}
	
}
