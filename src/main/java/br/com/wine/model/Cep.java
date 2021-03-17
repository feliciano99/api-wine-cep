package br.com.wine.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "CEP")
public class Cep {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(nullable = false, name = "CODIGO_LOJA")
	@NotEmpty(message = "O campo 'Código da Loja' é obrigatório!")
	private String codigoLoja;

	@Column(nullable = false, name = "FAIXA_INICIO")
	@NotEmpty(message = "O campo 'Faixa Início' é obrigatório!")
	private String faixaInicio;

	@Column(nullable = false, name = "FAIXA_FIM")
	@NotEmpty(message = "O campo 'Código Fim' é obrigatório!")
	private String faixaFim;
}
