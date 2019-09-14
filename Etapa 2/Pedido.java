package p2.prop3_2.papelaria;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {

    private int numero;
    private String nomeCliente;
    private Date data;
    private String endereco;
    private ArrayList<ItemPedido> listaDeItens = new ArrayList<ItemPedido>();
    private CalculoEntrega tipoEntrega;

    public ArrayList<ItemPedido> getListaDeItens() {
        return listaDeItens;
    }

    public void setListaDeItens(ItemPedido listaDeItens) {
        getListaDeItens().add(listaDeItens);
    }

    public CalculoEntrega getTipoDeEntrega() {
        return tipoEntrega;
    }

    public void setTipoDeEntrega(CalculoEntrega tipoDeEntrega) {
        this.tipoEntrega = tipoDeEntrega;
    }

    public Pedido() {

    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getValorPedido() {
        float valorTotalDosProdutos = 0;
        for (ItemPedido item : getListaDeItens()) {
            valorTotalDosProdutos += item.getProduto().getValor();
        }
        return valorTotalDosProdutos;
    }

    public void incluirItem(Produto produto, int valor) {
        ItemPedido item = new ItemPedido(produto, valor);

        listaDeItens.add(item);
    }

    public double getValorEntrega() throws TipoEntregaInvalido {
        
        return tipoEntrega.calculafrete(pesagemFinal(), listaDeItens.size());
        
    }

    public double pesagemFinal() {
        double pesoTotal = 0;
        for (ItemPedido item : listaDeItens) {
            pesoTotal += item.getProduto().getPeso();
        }
        return pesoTotal;
    }

    public double getValorTotal() throws TipoEntregaInvalido {
        return getValorPedido() + getValorEntrega();
    }
    
}
