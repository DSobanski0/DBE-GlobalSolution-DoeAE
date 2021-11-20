package br.com.fiap.DoeAE.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_DOADOR")
public class Doador {

	@Id
	@Column(name = "ID_DOADOR", nullable = false)
	@SequenceGenerator(name = "sqDoador", sequenceName = "SQ_TB_DOADOR", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "sqDoador", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "NM_DOADOR")
	private String nome;

	@Column(name = "NR_CPF")
	private String cpf;
	
	@Column(name = "NR_CNPJ")	
	private String cnpj;
	
	@Embedded
	private Endereco endereco;
	
	@Column(name = "NR_TELEFONE")	
	private String telefone;
	
	@Column(name = "DS_EMAIL")
	private String email;
	
	@Column(name = "NM_RESPONSAVEL")
	private String responsavel;
	
	@Column(name = "DS_RAMO")
	@Enumerated(EnumType.STRING)
	private Ramo ramo;
}
