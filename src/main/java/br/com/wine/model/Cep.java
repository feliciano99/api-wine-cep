package br.com.wine.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Data
@Entity
@Table(name = "CEP")
public class Cep {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(nullable = false, name = "CODIGO_LOJA", updatable = false)
	@NotEmpty(message = "O campo 'Código da Loja' é obrigatório!")
	private String codigoLoja;

	@Column(nullable = false, name = "FAIXA_INICIO", unique = true, updatable = true)
	@NotEmpty(message = "O campo 'Faixa Início' é obrigatório!")
	@Size(min = 8, max = 8, message = "O campo 'Faixa Início' deve ter 8 caracteres!")
	private String faixaInicio;

	@Column(nullable = false, name = "FAIXA_FIM", unique = true, updatable = true)
	@NotEmpty(message = "O campo 'Código Fim' é obrigatório!")
	@Size(min = 8, max = 8, message = "O campo 'Faixa Fim' deve ter 8 caracteres!")
	private String faixaFim;
}
