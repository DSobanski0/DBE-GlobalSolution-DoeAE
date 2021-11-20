package br.com.fiap.DoeAE.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.DoeAE.model.Doador;

public interface DoadorRepository extends JpaRepository<Doador, Long> {

}
