package br.com.wine.service;

import java.util.List;
import java.util.Optional;

import br.com.wine.model.Cep;

public interface CepService {

	Optional<Cep> findByFaixaInicio(String faixaInicio);

	List<Cep> findAll();

}
