package com.jm.mobile.controllers;

import com.jm.mobile.entities.Cliente;
import com.jm.mobile.entities.Item;
import com.jm.mobile.entities.Pedido;
import com.jm.mobile.services.PedidoService;
import com.jm.mobile.util.JsfUtils;
import java.io.Serializable;
import java.util.Iterator;
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
public class PedidoController implements Serializable {
    
    private PedidoService pedidoService;
    
    private Cliente cliente;
    private List<Pedido> listaPedidos;
    private Pedido pedido;
    private Boolean fechaPedido;
    
    @PostConstruct
    public void init() {
        pedidoService = PedidoService.getInstance();
    }
    
    public String listarPedidos(Cliente cliente) {
        this.cliente = cliente;
        listaPedidos = pedidoService.buscaPedidosCliente(cliente.getDocumento());
        return "pm:listaPedidos";
    }
    
    public String novoPedido(Cliente cliente) {
        this.cliente = cliente;
        pedido = new Pedido(cliente);
        novoItem();
        return "pm:pedido";
    }
    
    public String abrePedido(Long numeroPedido) {
        pedido = pedidoService.buscaPedidoClientePorNumero(cliente.getDocumento(), numeroPedido);
        if (pedido != null) {
            return "pm:pedido";
        } else {
            JsfUtils.showErrorMessage("Pedido não encontrado!");
            return null;
        }
    }
    
    public void concluiPedido() {
        pedido.concluiPedido(fechaPedido);
        JsfUtils.showInfoMessage("Pedido realizado!");
    }
    
    public void novoItem() {
        pedido.novoItem();
    }
    
    public void excluiItensSelecionados() {
        for (Iterator<Item> it = pedido.getItens().iterator(); it.hasNext();) {
            Item item = it.next();
            if (item.getSelecionado()) {
                it.remove();
                pedido.excluiItem(item);
            }
        }
    }
    
    // getters and setters

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Boolean getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Boolean fechaPedido) {
        this.fechaPedido = fechaPedido;
    }
    
}
