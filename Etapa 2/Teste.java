package p2.prop3_2.papelaria;

public class Teste {

    public static void main(String[] args) {
        Produto abacate = new Produto("Abacate", 5, 100);
        Produto tomate = new Produto("tomate", 12, 80);
        Produto morango = new Produto("morango", 6, 20);
        Produto laranja = new Produto("laranja", 2, 100);
        Produto banana = new Produto("banana", 8, 50);
        Produto batata = new Produto("batata", 9, 400);
        Produto leite = new Produto("leite", 10, 900);
        Produto cafe = new Produto("cafe", 12, 1000);
        Produto chocolate = new Produto("chocolate", 12, 500);
        Produto farinha = new Produto("farinha", 15, 5000);

        ItemPedido item1 = new ItemPedido(tomate, 4);
        ItemPedido item2 = new ItemPedido(morango, 8);
        ItemPedido item3 = new ItemPedido(laranja, 9);
        ItemPedido item4 = new ItemPedido(banana, 27);
        ItemPedido item5 = new ItemPedido(leite, 5);
        ItemPedido item6 = new ItemPedido(cafe, 10);
        ItemPedido item7 = new ItemPedido(chocolate, 8);
        ItemPedido item8 = new ItemPedido(farinha, 2);

        Pedido pedido = new Pedido();
        pedido.setListaDeItens(item1);
        pedido.setListaDeItens(item2);
        pedido.setListaDeItens(item3);
        pedido.setListaDeItens(item4);
        pedido.setListaDeItens(item5);
        pedido.setListaDeItens(item6);
        pedido.setListaDeItens(item7);
        pedido.setListaDeItens(item8);
        
        Pac pac = new Pac();
        Sedex sedex = new Sedex();
        Retiradalocal retiradalocal = new Retiradalocal();
        Motoboy motoboy = new Motoboy();
        
        pedido.setTipoDeEntrega(pac);

        mensagens(pedido);

        pedido.setTipoDeEntrega(sedex);
        
        mensagens(pedido);
        
        pedido.setTipoDeEntrega(retiradalocal);
        
        mensagens(pedido);
        
        pedido.setTipoDeEntrega(motoboy);
        
        mensagens(pedido);
        
    }

    public static void mensagens(Pedido pedido) {
        try {
            System.out.println("Valor entrega: " + pedido.getValorEntrega());
        } catch (TipoEntregaInvalido erro) {
            System.out.println("Não é possível entregar a encomendo pelas Encomenda's Pac, pois ela ultrapassou o limite de peso.");
        } catch (Exception erro) {
            System.out.println(erro.getMessage());
        }

        System.out.println("Valor pedido: " + pedido.getValorPedido());

        try {
            System.out.println("Valor Total: " + pedido.getValorTotal());
        } catch (TipoEntregaInvalido erro) {
            System.out.println("Não é possível entregar a encomendo pelas Encomenda's Pac, pois ela ultrapassou o limite de peso.");
        } catch (Exception erro) {
            System.out.println(erro.getMessage());
        }
        System.out.println("---------------------------");

    }

}
