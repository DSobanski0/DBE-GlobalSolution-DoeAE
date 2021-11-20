package br.com.fiap.DoeAE.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_DOADOR_ALIMENTO")
public class DoadorAlimentoRecebedor {

	@Id
	@Column(name = "ID_DOADOR_ALIMENTO", nullable = false)
	@SequenceGenerator(name = "sqDoadorAlimento", sequenceName = "SQ_TB_DOADOR_ALIMENTO", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "sqDoadorAlimento", strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ID_DOADOR", nullable = false)
	private Doador doador;
	
	@ManyToOne
	@JoinColumn(name = "ID_ALIMENTO", nullable = false)
	private Alimento alimento;
	
	@ManyToOne
	@JoinColumn(name = "ID_RECEBEDOR")
	private Recebedor recebedor;
	
	@Column(name = "qt_alimento", nullable = false)
	private Integer quantidade;
}
