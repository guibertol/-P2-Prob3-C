package p2.prop3_2.papelaria;

public enum Entrega implements CalculoEntrega{
    
    PAC{
        
        @Override
        public double calculafrete(double pesoTotal , int qtdProdutos) throws TipoEntregaInvalido {
            
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
            
            throw new TipoEntregaInvalido();
            
        }
        
    },
    SEDEX{
        
        @Override
        public double calculafrete(double pesoTotal , int qtdProdutos) throws TipoEntregaInvalido{
            
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
            
            throw new TipoEntregaInvalido();
            
        }
        
    },
    RETIRADALOCAL{
        
        @Override
        public double calculafrete(double peso, int qtdProdutos) throws TipoEntregaInvalido{
            
            return 0;
            
        }
        
    },
    MOTOBOY{
        
        @Override
        public double calculafrete(double peso, int qtdProdutos) throws TipoEntregaInvalido{
            
            if(peso<25 && qtdProdutos <= 30){
                return 7;
            }
            
            throw new TipoEntregaInvalido();
            
        }
       
    };
    
}
