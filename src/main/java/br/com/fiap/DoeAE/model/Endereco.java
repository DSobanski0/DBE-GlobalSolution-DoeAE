package br.com.fiap.DoeAE.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Endereco {

	@Column(name = "ds_logradouro")
	private String logradouro;
	
	@Column(name = "nr_lar")
	private Integer numero;

	@Column(name = "ds_complemento")
	private String complemento;
	
	@Column(name = "nr_cep")
	private String cep;
}
