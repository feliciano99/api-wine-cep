package br.com.wine.controller;

import java.util.List;

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
	private CepRepository cepRepository;

	@GetMapping
	public List<Cep> listar() {
		return cepRepository.findAll();
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public Cep insert(@RequestBody @Valid Cep cep) {
		return cepRepository.save(cep);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity update(@PathVariable("id") long id, @RequestBody Cep cep) {
		return cepRepository.findById(id).map(cep_updated -> {
			cep.setFaixa_inicio(cep.getFaixa_inicio());
			cep.setFaixa_fim(cep.getFaixa_fim());
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
