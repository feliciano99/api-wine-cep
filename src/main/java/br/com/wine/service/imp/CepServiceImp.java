package br.com.wine.service.imp;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wine.model.Cep;
import br.com.wine.repository.CepRepository;
import br.com.wine.service.CepService;

@Service
public class CepServiceImp implements CepService {
	
	Logger logger = org.slf4j.LoggerFactory.getLogger(CepServiceImp.class);
	
	@Autowired
	private CepRepository cepRepository;
	
	@Override
	public Optional<Cep> findByFaixaInicio(String faixaInicio) {
		return cepRepository.findByFaixaInicio(faixaInicio);
	}

	@Override
	public List<Cep> findAll() {
		return cepRepository.findAll();
	}
}
