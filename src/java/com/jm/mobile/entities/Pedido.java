package com.jm.mobile.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Oscar Costa <oscarcosta@gmail.com>
 */
public class Pedido {

    private static long gerador = 0;
    
    private long numero;
    private Status status;
    private Cliente cliente;
    private Date data;
    private List<Item> itens;
    private Integer prioridade;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.status = Status.ABERTO;
        this.data = new Date();
        this.prioridade = 1;
        this.itens = new ArrayList<Item>();
    }
    
    public void concluiPedido(Boolean fechado) {
        if (numero == 0) {
            numero = gerador++;
        }
        if (fechado) {
            status = Status.FECHADO;
        }
        cliente.adicionaPedido(this);
    }
    
    public void novoItem() {
        adicionaItem(new Item());
    }
    
    public void adicionaItem(String nome, Integer quantidade, BigDecimal precoUnitario) {
        adicionaItem(new Item(nome, quantidade, precoUnitario));
    }
    
    private void adicionaItem(Item item) {
        itens.add(item);
    }
    
    public void excluiItem(Item item) {
        itens.remove(item);
    }
    
    public BigDecimal getPrecoTotal() {
        BigDecimal precoTotal = BigDecimal.ZERO;
        for (Item item : itens) {
            precoTotal = precoTotal.add(item.getPrecoItem());
        }
        return precoTotal;
    }
    
    enum Status {
        ABERTO,
        FECHADO,
        PROCESSADO,
        CANCELADO;
    }
    
    // getters and setters
    
    public long getNumero() {
        return numero;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItens() {
        return itens;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }
}