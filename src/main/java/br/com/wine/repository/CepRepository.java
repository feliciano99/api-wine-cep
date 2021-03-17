package br.com.wine.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.wine.model.Cep;

@Repository
public interface CepRepository extends JpaRepository<Cep, Long> {
	@Query(value = "select * "
			+ "from cep "
			+ "where faixa_inicio >= :faixaInicio or"
			+ " faixa_fim <= :faixaInicio "
			+ "fetch first 1 rows only", nativeQuery = true)
	Optional<Cep> findByFaixaInicio(@Param("faixaInicio") String faixaInicio);
}
