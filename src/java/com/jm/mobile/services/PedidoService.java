package com.jm.mobile.services;

import com.jm.mobile.entities.Cliente;
import com.jm.mobile.entities.Pedido;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author oscar
 */
public class PedidoService {

    private List<Cliente> listaClientes;
    
    private static PedidoService instance = new PedidoService();
    
    private PedidoService() {
        listaClientes = new ArrayList<Cliente>();
        listaClientes.add(new Cliente("97.898.427/0001-90", "Pamonharia Milho Verde", "Rua do Vale, 13, Centro, Taboca"));
        Pedido pedido1 = new Pedido(listaClientes.get(0));
        pedido1.adicionaItem("Agua Mineral 20 lts", 10, new BigDecimal("15.00"));
        pedido1.adicionaItem("Sal 1kg", 3, new BigDecimal("3.50"));
        pedido1.adicionaItem("Farinha 5kg", 2, new BigDecimal("5.00"));
        pedido1.concluiPedido(Boolean.TRUE);
        listaClientes.add(new Cliente("63.213.771/0001-87", "Padaria Pão de Sal", "Rua Pr. Janio, 10, Centro, Taboca"));
        Pedido pedido2 = new Pedido(listaClientes.get(1));
        pedido2.adicionaItem("Agua Mineral 20 lts", 20, new BigDecimal("15.00"));
        pedido2.adicionaItem("Sal 1kg", 5, new BigDecimal("3.50"));
        pedido2.adicionaItem("Farinha 5kg", 15, new BigDecimal("5.00"));
        pedido2.concluiPedido(Boolean.FALSE);
        listaClientes.add(new Cliente("88.928.824/0001-77", "Restaurante Serve Bem", "Rua Pr. Janio, 5, Centro, Taboca"));
    }

    public static PedidoService getInstance() {
        return instance;
    }

    public List<Cliente> buscaTodosClientes() {
        return listaClientes;
    }
    
    public Cliente buscaClientePorDocumento(String documento) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getDocumento().equals(documento)) {
                return cliente;
            }
        }
        return null;
    }
    
    public void salvaCliente(Cliente cliente) {
        if (listaClientes.contains(cliente)) {
            listaClientes.remove(cliente);
        }
        listaClientes.add(cliente);
    }
    
    public List<Pedido> buscaPedidosCliente(String documento) {
        return new ArrayList<Pedido>(buscaClientePorDocumento(documento).getPedidos());
    }
    
    public Pedido buscaPedidoClientePorNumero(String documento, long numero) {
        for (Pedido pedido : buscaPedidosCliente(documento)) {
            if (pedido.getNumero() == numero) {
                return pedido;
            }
        }
        return null;
    }
}
