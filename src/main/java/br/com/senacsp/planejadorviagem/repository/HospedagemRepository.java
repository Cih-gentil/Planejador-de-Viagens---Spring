package br.com.senacsp.planejadorviagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senacsp.planejadorviagem.model.Hospedagem;

public interface HospedagemRepository extends JpaRepository<Hospedagem, Long>{

}
