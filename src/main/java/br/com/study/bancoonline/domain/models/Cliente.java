package br.com.study.bancoonline.domain.models;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Embeddable
public class Cliente {

	@NotEmpty
	private String nome;

	@NotEmpty
	@Size(min = 11, max = 11)
	private String cpf;

	@NotEmpty
	@Size(min = 30, max = 255)
	private String endereco;

	@Past
	private Date dataDeNascimento;

	@Deprecated
	Cliente() {

	}

	public Cliente(@NotEmpty String nome, @NotEmpty String cpf, @NotEmpty String endereco,
			@Past Date dataDeNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.dataDeNascimento = dataDeNascimento;

	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

}
