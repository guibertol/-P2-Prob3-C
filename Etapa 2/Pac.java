package p2.prop3_2.papelaria;

public class Pac implements CalculoEntrega{

    @Override
    public double calculafrete(double peso, int qtdPedidos) throws TipoEntregaInvalido {
        
        if (peso <= 1000) {
            return 10;
        } else if (peso > 1000 && peso <= 2000) {
            return 15;
        } else if (peso > 2000 && peso <= 3000) {
            return 20;
        } else if (peso > 3000 && peso <= 5000) {
            return 30;
        } else if (peso > 5000) {
            throw new TipoEntregaInvalido();
        }

        throw new TipoEntregaInvalido();
        
    }
    
}
