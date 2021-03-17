package br.com.wine.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.wine.model.Cep;
import br.com.wine.repository.CepRepository;

@RequestMapping("/cep")
@RestController
public class CepController {
		
	@Autowired
	CepRepository cepRepository;

	@GetMapping("/")
	public List<Cep> findAll() {
		return this.cepRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Cep> findById(@PathVariable Long id) {
		return this.cepRepository.findById(id);
	}

	@GetMapping(value = "/filter/{faixaInicio}")
	public Optional<Cep> findStore(@PathVariable String faixaInicio) {
		System.out.println("VALOR: " + faixaInicio);
		return this.cepRepository.findByFaixaInicio(faixaInicio);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public Cep insert(@RequestBody @Valid Cep cep) {
		return this.cepRepository.save(cep);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity update(@PathVariable("id") long id, @RequestBody Cep cep) {
		return this.cepRepository.findById(id).map(cep_updated -> {
			cep.setFaixaInicio(cep.getFaixaInicio());
			cep.setFaixaFim(cep.getFaixaFim());
			Cep updated = cepRepository.save(cep_updated);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable long id) {
		return cepRepository.findById(id).map(record -> {
			cepRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
