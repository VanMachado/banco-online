package br.com.study.bancoonline.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.study.bancoonline.domain.models.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
