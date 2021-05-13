package br.com.study.bancoonline.api.dtos;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import br.com.study.bancoonline.domain.models.Cliente;
import br.com.study.bancoonline.domain.models.Conta;

public class ContaRequestDTO {

	/**
	 * { "nomeCliente":,"Van Damme", "documento":,"12345678911", "endereco":,"rua
	  tal", "dataDeNascimento":,"1992-02-23", "agencia":,"1234",
	  "numeroConta":,"12345678", "digito":,"9", "saldo":1000.00 }
	 */

	@NotEmpty
	private String nomeCliente;

	@NotEmpty
	@Size(min = 11, max = 11)
	private String documento;

	@NotEmpty
	@Size(min = 30, max = 255)
	private String endereco;

	@Past
	private Date dataDeNascimento;

	@NotEmpty
	@NumberFormat
	@Size(min = 4, max = 5)
	private String agencia;

	@NotEmpty
	@NumberFormat
	@Size(min = 8, max = 8)
	private String numeroConta;

	@NotEmpty
	@NumberFormat
	@Size(min = 1, max = 1)
	private String digito;

	@NotNull
	@PositiveOrZero
	private BigDecimal saldo;

	public ContaRequestDTO(@NotEmpty String nomeCliente, @NotEmpty @Size(min = 11, max = 11) String documento,
			@NotEmpty @Size(min = 30, max = 255) String endereco, @Past Date dataDeNascimento,
			@NotEmpty @Size(min = 4, max = 5) String agencia, @NotEmpty @Size(min = 8, max = 8) String numeroConta,
			@NotEmpty @Size(min = 1, max = 1) String digito, @NotNull @PositiveOrZero BigDecimal saldo) {
		
		this.nomeCliente = nomeCliente;
		this.documento = documento;
		this.endereco = endereco;
		this.dataDeNascimento = dataDeNascimento;
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.digito = digito;
		this.saldo = saldo;
	}

	public Conta toModel() {
		
		Cliente cliente = new Cliente(nomeCliente, documento, endereco, dataDeNascimento);
		Conta conta = new Conta(agencia, numeroConta, digito, cliente, saldo);
		
		return conta;
		
	}
}
