package Papelaria;

public class Produto {
    private String descricao;
    private double valor;
    private int peso;
    
    public Produto(String descricao, double valor, int peso){
        setDescricao(descricao);
        setValor(valor);
        setPeso(peso);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    
}
