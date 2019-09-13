package Papelaria;

import Papelaria.Pedido.TipoDeEntrega;
import java.util.ArrayList;
import java.util.Date;

public class Pedido {

    private int numero;
    private String nomeCliente;
    private Date data;
    private String endereco;
    private ArrayList<ItemPedido> listaDeItens = new ArrayList<ItemPedido>();
    private TipoDeEntrega tipoDeEntrega;

    public ArrayList<ItemPedido> getListaDeItens() {
        return listaDeItens;
    }

    public void setListaDeItens(ItemPedido listaDeItens) {
        getListaDeItens().add(listaDeItens);
    }

    public TipoDeEntrega getTipoDeEntrega() {
        return tipoDeEntrega;
    }

    public void setTipoDeEntrega(TipoDeEntrega tipoDeEntrega) {
        this.tipoDeEntrega = tipoDeEntrega;
    }

    public enum TipoDeEntrega {
        Sedex(1), EncomendaPAC(2), RetiradaNoLocal(0);

        public int valorEntrega;

        TipoDeEntrega(int valor) {
            valorEntrega = valor;
        }
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
        float pesoTotal = pesagemFinal();
        switch (getTipoDeEntrega()) {
            case EncomendaPAC:

                if (pesoTotal <= 1000) {
                    return 10;
                } else if (pesoTotal > 1000 && pesoTotal <= 2000) {
                    return 15;
                } else if (pesoTotal > 2000 && pesoTotal <= 3000) {
                    return 20;
                } else if (pesoTotal > 3000 && pesoTotal <= 5000) {
                    return 30;
                } else if (pesoTotal > 5000) {
                    throw new TipoEntregaInvalido();
                }

                break;
            case RetiradaNoLocal:
                return 0;
            case Sedex:

                if (pesoTotal <= 500) {
                    return 12.5;
                } else if (pesoTotal > 500 && pesoTotal <= 750) {
                    return 20;
                } else if (pesoTotal > 750 && pesoTotal <= 1200) {
                    return 30;
                } else if (pesoTotal > 1200 && pesoTotal <= 2000) {
                    return 45;
                } else if (pesoTotal > 2000) {
                    return ((pesoTotal - 2000) / 100) * 1.50 + 45;
                }

                break;
        }
        return 0;
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
