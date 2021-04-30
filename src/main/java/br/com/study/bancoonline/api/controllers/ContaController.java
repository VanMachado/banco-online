package br.com.study.bancoonline.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.study.bancoonline.api.dtos.ContaRequestDTO;
import br.com.study.bancoonline.domain.models.Conta;
import br.com.study.bancoonline.domain.repositories.ContaRepository;

@RestController
@RequestMapping("/contas")
public class ContaController {

	@Autowired
	private ContaRepository contaRepository;

	@PostMapping
	private ResponseEntity<Conta> postConta(@Valid @RequestBody ContaRequestDTO contaRequestDTO,
			UriComponentsBuilder uriComponentsBuilder) {

		Conta conta = contaRequestDTO.toModel();
		Conta contaSaved = contaRepository.save(conta);

		return ResponseEntity
				.created(uriComponentsBuilder.path("/contas/{id}").buildAndExpand(contaSaved.getId()).toUri())
				.body(contaSaved);
	}

}
