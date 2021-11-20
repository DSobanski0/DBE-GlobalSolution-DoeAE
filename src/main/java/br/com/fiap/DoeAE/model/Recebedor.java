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
@Table(name = "TB_RECEBEDOR")
public class Recebedor {

	@Id
	@Column(name = "ID_RECEBEDOR", nullable = false)
	@SequenceGenerator(name = "sqRecebedor", sequenceName = "SQ_TB_RECEBEDOR", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "sqRecebedor", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "DS_RAZAO_SOCIAL")
	private String razaoSocial;

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
