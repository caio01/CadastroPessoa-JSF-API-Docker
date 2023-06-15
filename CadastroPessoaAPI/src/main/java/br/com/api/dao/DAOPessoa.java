package br.com.api.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.api.exception.CPFAlreadyRegistered;
import br.com.api.model.Pessoa;

public class DAOPessoa {
	
    @PersistenceContext(name = "banco-api")
    private EntityManager entityManager;
    
    public List<Pessoa> getAllPessoas() {
    	List<Pessoa> listPessoa = entityManager.createQuery("FROM Pessoa h", Pessoa.class)
    	.setMaxResults(100)
    	.getResultList();
    	
    	return listPessoa;
    }
    
    public Pessoa getPessoaByCPF(String cpf) {
    	try {
	    	Pessoa pessoa = entityManager.createQuery("SELECT p FROM Pessoa p WHERE p.cpf LIKE :cpf", Pessoa.class)
	    		    .setParameter("cpf", cpf)
	    		    .setMaxResults(1)
	    		    .getSingleResult();
	    	
	    	return pessoa;
    	} catch (Exception e) {
    		return null;
    	}
    }
    
	public Pessoa postPessoa(Pessoa pessoa) {
		if(getPessoaByCPF(pessoa.getCpf()) == null) {
			pessoa.setCriacaoRegistro(Calendar.getInstance());
			entityManager.persist(pessoa);
	    	return pessoa;
		} else {
			throw new CPFAlreadyRegistered();
		}
    }

	public Pessoa putPessoa(String cpf, Pessoa pessoaAPI) {
		Pessoa pessoaBanco = entityManager.createQuery("SELECT p FROM Pessoa p WHERE p.cpf LIKE :cpf", Pessoa.class)
    		    .setParameter("cpf", cpf)
    		    .setMaxResults(1)
    		    .getSingleResult();
		if (pessoaBanco != null) {
			if(pessoaAPI.getCpf() != null) pessoaBanco.setCpf(pessoaAPI.getCpf());
			if(pessoaAPI.getEmail() != null) pessoaBanco.setEmail(pessoaAPI.getEmail());
			if(pessoaAPI.getEndereco() != null) pessoaBanco.setEndereco(pessoaAPI.getEndereco());
			if(pessoaAPI.getNascimento() != null) pessoaBanco.setNascimento(pessoaAPI.getNascimento());
			if(pessoaAPI.getNome() != null) pessoaBanco.setNome(pessoaAPI.getNome());
			pessoaBanco.setAlteracaoRegistro(Calendar.getInstance());
		}
		return pessoaBanco;
	}

	public void deletePessoa(String cpf) {
		Pessoa pessoa = entityManager.createQuery("SELECT p FROM Pessoa p WHERE p.cpf LIKE :cpf", Pessoa.class)
    		    .setParameter("cpf", cpf)
    		    .setMaxResults(1)
    		    .getSingleResult();
		if (pessoa != null) {
			entityManager.remove(pessoa);
		}
	}

}
