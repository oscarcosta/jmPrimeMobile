package com.jm.mobile.controllers;

import com.jm.mobile.entities.Cliente;
import com.jm.mobile.services.PedidoService;
import com.jm.mobile.util.JsfUtils;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Oscar Costa <oscarcosta@gmail.com>
 */
@ManagedBean
@ViewScoped
public class ClienteController implements Serializable {

    private PedidoService pedidoService; // Mock Service
    
    private List<Cliente> listaClientes;
    private Cliente cliente;
    
    @PostConstruct
    public void init() {
        pedidoService = PedidoService.getInstance();
    }
    
    public String listarClientes() {
        listaClientes = pedidoService.buscaTodosClientes();
        return "pm:listaClientes";
    }

    public String novoCliente() {
        cliente = new Cliente();
        return "pm:cliente";
    }
    
    public String selecionaCliente(String documento) {
        cliente = pedidoService.buscaClientePorDocumento(documento);
        if (cliente != null) {
            return "pm:cliente";
        } else {
            JsfUtils.showErrorMessage("Cliente não encontrado!");
            return null;
        }
    }
    
    public void salvaCliente() {
        pedidoService.salvaCliente(cliente);
        JsfUtils.showInfoMessage("Cliente Salvo!");
    }

    // getters and setters 
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
}
