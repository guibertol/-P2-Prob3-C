package p2.prop3_2.papelaria;

public class Motoboy implements CalculoEntrega{

    @Override
    public double calculafrete(double peso, int qtdProdutos) throws TipoEntregaInvalido {
        
         if(peso<25 && qtdProdutos <= 30){
            return 7;
        }

        throw new TipoEntregaInvalido();

    }
    
}
