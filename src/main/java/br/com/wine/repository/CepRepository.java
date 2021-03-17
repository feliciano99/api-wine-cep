package br.com.wine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wine.model.Cep;

@Repository
public interface CepRepository extends JpaRepository<Cep, Long> {

}
