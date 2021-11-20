package br.com.fiap.DoeAE.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_ALIMENTO")
public class Alimento {
	
	@Id
	@Column(name = "ID_ALIMENTO", nullable = false)
	@SequenceGenerator(name = "sqAlimento", sequenceName = "SQ_TB_ALIMENTO", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "sqAlimento", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "NM_ALIMENTO")
	private String nome;
}
