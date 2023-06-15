package br.com.api.rest;

import br.com.api.controller.ControllerPessoa;
import br.com.api.model.Pessoa;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pessoa")
public class RestPessoa {

    @Inject
    ControllerPessoa controllerPessoa;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPessoas() {
        return Response.ok(controllerPessoa.getAllPessoas()).build();
    }
    
    @GET
    @Path("{cpf}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPessoaById(@PathParam("cpf") String cpf) {
    	try {
    		return Response.ok(controllerPessoa.getPessoaByCPF(cpf)).build();
    	} catch (Exception e) {
    		Map<String, Object> body = new HashMap<String, Object>();
            body.put("mensagem", "O CPF informado não foi encontrado.");
    		return Response.status(Response.Status.BAD_REQUEST).entity(body).build();
    	}        
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postPessoa(Pessoa pessoa) {
        try {
        	return Response.status(Response.Status.CREATED).entity(controllerPessoa.postPessoa(pessoa)).build();
        } catch(Exception e) {
        	Map<String, Object> body = new HashMap<String, Object>();
            body.put("mensagem", "CPF já cadastrado.");
    		return Response.status(Response.Status.BAD_REQUEST).entity(body).build();
        } 
    }
    
    @PUT
    @Path("{cpf}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("cpf") String cpf, Pessoa pessoa) {
        try {
            return Response.status(Response.Status.OK).entity(controllerPessoa.putPessoa(cpf, pessoa)).build();
        } catch(Exception e) {
        	Map<String, Object> body = new HashMap<String, Object>();
            body.put("mensagem", "Erro na solicitação.");
    		return Response.status(Response.Status.BAD_REQUEST).entity(body).build();
        } 
    }
    
    @DELETE
    @Path("{cpf}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("cpf") String cpf)
    {
        try{
        	controllerPessoa.deletePessoa(cpf);
        	Map<String, Object> body = new HashMap<String, Object>();
            body.put("mensagem", "Pessoa deletada com sucesso!");
            return Response.status(Response.Status.OK).entity(body).build();
        } catch(Exception e) {
        	Map<String, Object> body = new HashMap<String, Object>();
            body.put("mensagem", "O CPF informado não foi encontrado.");
    		return Response.status(Response.Status.BAD_REQUEST).entity(body).build();
        }
    }

}
