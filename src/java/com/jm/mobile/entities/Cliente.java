package com.jm.mobile.entities;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Oscar Costa <oscarcosta@gmail.com>
 */
public class Cliente {
    
    private String documento;
    private String nome;
    private String endereco;

    private Set<Pedido> pedidos;
    
    public Cliente() {
    }

    public Cliente(String documento, String nome, String endereco) {
        this.documento = documento;
        this.nome = nome;
        this.endereco = endereco;
        this.pedidos = new HashSet<Pedido>();
    }
    
    protected void adicionaPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
    
    // getters and setters

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }
}