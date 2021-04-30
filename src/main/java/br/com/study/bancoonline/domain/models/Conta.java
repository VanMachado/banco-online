package br.com.study.bancoonline.domain.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

@Entity
public class Conta {

	@Id
	@Column(name = "id_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

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
	private String numeroVerificador;

	@NotNull
	@Embedded
	private Cliente cliente;

	@NotNull
	@PositiveOrZero
	private BigDecimal saldo;

	@Deprecated
	Conta() {

	}

	public Conta(@NotEmpty @Size(min = 4, max = 5) String agencia, @NotEmpty @Size(min = 8, max = 8) String numeroConta,
			@NotEmpty @Size(min = 1, max = 1) String numeroVerificador, @NotNull Cliente cliente) {
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.numeroVerificador = numeroVerificador;
		this.cliente = cliente;
		this.saldo = BigDecimal.ZERO;
	}

	public Conta(@NotEmpty @Size(min = 4, max = 5) String agencia, @NotEmpty @Size(min = 8, max = 8) String numeroConta,
			@NotEmpty @Size(min = 1, max = 1) String numeroVerificador, @NotNull Cliente cliente,
			@NotNull @PositiveOrZero BigDecimal saldo) {

		this(agencia, numeroConta, numeroVerificador, cliente);
		this.saldo = saldo;
	}

	public Integer getId() {
		return id;
	}

	public String getAgencia() {
		return agencia;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public String getNumeroVerificador() {
		return numeroVerificador;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

}
