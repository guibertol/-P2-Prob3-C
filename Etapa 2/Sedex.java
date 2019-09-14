package p2.prop3_2.papelaria;

public class Sedex implements CalculoEntrega{

    @Override
    public double calculafrete(double peso, int qtdPedidos) throws TipoEntregaInvalido {
       
         if (peso <= 500) {
            return 12.5;
        } else if (peso > 500 && peso <= 750) {
            return 20;
        } else if (peso > 750 && peso <= 1200) {
            return 30;
        } else if (peso > 1200 && peso <= 2000) {
            return 45;
        } else if (peso > 2000) {
            return ((peso - 2000) / 100) * 1.50 + 45;
        }

        throw new TipoEntregaInvalido();
        
    }
    
}
