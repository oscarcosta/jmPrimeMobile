package com.jm.mobile.entities;

import java.math.BigDecimal;

/**
 *
 * @author Oscar Costa <oscarcosta@gmail.com>
 */
public class Item {
    
    private String nome;
    private Integer quantidade;
    private BigDecimal precoUnitario;
    
    // transiente
    private Boolean selecionado;
    
    protected Item() {
    }

    protected Item(String nome, Integer quantidade, BigDecimal precoUnitario) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public BigDecimal getPrecoItem() {
        if (precoUnitario != null && quantidade != null) {
            return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
        } else {
            return BigDecimal.ZERO;
        }
    }

    // getters and setters
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Boolean getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(Boolean selecionado) {
        this.selecionado = selecionado;
    }
}