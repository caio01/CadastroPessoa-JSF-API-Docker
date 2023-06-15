package br.com.api.controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.api.dao.DAOPessoa;
import br.com.api.exception.CPFNotExistException;
import br.com.api.model.Pessoa;

@Stateless
public class ControllerPessoa {

	@Inject
	private DAOPessoa daoPessoa;

	public List<Pessoa> getAllPessoas() {
		return daoPessoa.getAllPessoas();
	}
	
	public Pessoa getPessoaByCPF(String cpf) {
		if (daoPessoa.getPessoaByCPF(cpf) != null) {
			return daoPessoa.getPessoaByCPF(cpf);
		} else {
			throw new CPFNotExistException();
		}
	}
	
	public Pessoa postPessoa(Pessoa pessoa) {
		return daoPessoa.postPessoa(pessoa);
	}

	public Pessoa putPessoa(String cpf, Pessoa pessoa) {
		return daoPessoa.putPessoa(cpf, pessoa);		
	}

	public void deletePessoa(String cpf) {
		daoPessoa.deletePessoa(cpf);
	}
	
}
