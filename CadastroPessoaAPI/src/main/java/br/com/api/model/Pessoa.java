package br.com.api.model;

import java.util.Calendar;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Pessoa {
	
	@Id
    @GeneratedValue
    private Integer idPessoa;

    private Calendar criacaoRegistro;
    private Calendar alteracaoRegistro;
    private String nome;
    @JsonbDateFormat(value = "dd/MM/yyyy")
    private Calendar nascimento;
    private String cpf;
    private String email;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fidEndereco", referencedColumnName = "idEndereco")
    private Endereco endereco;
    
	public Integer getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}
	public Calendar getCriacaoRegistro() {
		return criacaoRegistro;
	}
	public void setCriacaoRegistro(Calendar criacaoRegistro) {
		this.criacaoRegistro = criacaoRegistro;
	}
	public Calendar getAlteracaoRegistro() {
		return alteracaoRegistro;
	}
	public void setAlteracaoRegistro(Calendar alteracaoRegistro) {
		this.alteracaoRegistro = alteracaoRegistro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Calendar getNascimento() {
		return nascimento;
	}
	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
