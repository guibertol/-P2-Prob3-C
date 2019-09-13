package p2.prop3_2.papelaria;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {

    private int numero;
    private String nomeCliente;
    private Date data;
    private String endereco;
    private ArrayList<ItemPedido> listaDeItens = new ArrayList<ItemPedido>();
    private Entrega tipoDeEntrega;

    public ArrayList<ItemPedido> getListaDeItens() {
        return listaDeItens;
    }

    public void setListaDeItens(ItemPedido listaDeItens) {
        getListaDeItens().add(listaDeItens);
    }

    public Entrega getTipoDeEntrega() {
        return tipoDeEntrega;
    }

    public void setTipoDeEntrega(Entrega tipoDeEntrega) {
        this.tipoDeEntrega = tipoDeEntrega;
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
        
        return tipoDeEntrega.calculafrete(pesagemFinal(), listaDeItens.size());
        
    }

    public float pesagemFinal() {
        float pesoTotal = 0;
        for (ItemPedido item : listaDeItens) {
            pesoTotal += item.getProduto().getPeso();
        }
        return pesoTotal;
    }

    public double getValorTotal() throws TipoEntregaInvalido {
        return getValorPedido() + getValorEntrega();
    }
    
}
