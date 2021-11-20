package br.com.fiap.DoeAE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.DoeAE.model.Alimento;

@Repository
public interface AlimentoRepository extends JpaRepository<Alimento, Long> {

}
