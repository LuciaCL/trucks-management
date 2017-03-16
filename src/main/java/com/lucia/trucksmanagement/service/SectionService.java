package com.lucia.trucksmanagement.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucia.trucksmanagement.persistence.dao.HibernateDaoImpl;
import com.lucia.trucksmanagement.persistence.domain.Section;

@Service
public class SectionService {

	@Resource(name="sectionDao")
	private HibernateDaoImpl<Section, Long> sectionDao;
	
	@Transactional
	public void createSection(Section section) {
		sectionDao.persist(section);
	}
	
	@Transactional
	public void updateSection(Section section) {
		sectionDao.merge(section);
	}
	
	@Transactional
	public Section find(Long sectionId) {
		return sectionDao.find(sectionId);
	}
	
	@Transactional
	public Section findByDni(String dni) {
		return sectionDao.findByUniqueField("dni", dni);
	}
	@Transactional
	public List<Section> findAll() {
		List<Section> sections = new ArrayList<Section>(sectionDao.findAll());
		return sections;
	}
	
}
