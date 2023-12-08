package model;

import controller.DataAccessObject;
import java.util.ArrayList;
import model.Onibus;
import model.Cidade;

/**
 *
 * @author Aline e Ruan
 */

public class Itinerario extends DataAccessObject{
    private int codigoItinerario;
    private float valor ;
    private int qtdParadas;
    private Onibus onibus;
    private String localEmbarque;
    private String localDesembarque;
    private Cidade origem;
    private Cidade destino;
    private String dataEmbarque;
    
    
    public Itinerario() {
        super("itinerario");
    }

    public int getCodigoItinerario() {
        return codigoItinerario;
    }

    public float getValor() {
        return valor;
    }

    public int getQtdParadas() {
        return qtdParadas;
    }

    public Onibus getOnibus() {
        return onibus;
    }

    public String getLocalEmbarque() {
        return localEmbarque;
    }

    public String getLocalDesembarque() {
        return localDesembarque;
    }

    public Cidade getOrigem() {
        return origem;
    }

    public Cidade getDestino() {
        return destino;
    }

    public String getDataEmbarque() {
        return dataEmbarque;
    }

    
    public void setCodigoItinerario(int codigoItinerario) {
        if( codigoItinerario != this.codigoItinerario ) {
            this.codigoItinerario = codigoItinerario;
            addChange("codigo_itineraio", this.codigoItinerario);
        }
    }

    public void setValor(float valor) {
        if( valor != this.valor ) {
            this.valor = valor;
            addChange("valor", this.valor);
        }
    }

    public void setQtdParadas(int qtdParadas) {
        if( qtdParadas != this.qtdParadas ) {   
            this.qtdParadas = qtdParadas;
            addChange("qtd_paradas", this.qtdParadas);
        }
    }

    public void setOnibus(Onibus onibus) throws Exception{ 
        if( this.onibus == null ) { 
            if( onibus != null ) {
                this.onibus = new Onibus();
                this.onibus.setCodigoOnibus(onibus.getCodigoOnibus() );
                this.onibus.load();
                addChange("codigo_onibus", this.onibus.getCodigoOnibus() );
            }        
        } else { 
            if( onibus == null ) {   
                this.onibus = null;
                addChange("codigo_onibus", null);   
            } else {
                if( !this.onibus.equals(onibus) ) {  
                    this.onibus.setCodigoOnibus(onibus.getCodigoOnibus() );
                    this.onibus.load();
                    addChange("codigo_onibus", this.onibus.getCodigoOnibus() );                
                }   
            }   
        }
    }

    public void setLocalEmbarque(String localEmbarque) {
        if( !localEmbarque.equals( this.localEmbarque ) ) {
            this.localEmbarque = localEmbarque;
            addChange("local_embarque", this.localEmbarque);
        }
    }

    public void setLocalDesembarque(String localDesembarque) {
        if( !localDesembarque.equals( this.localDesembarque ) ) {
            this.localDesembarque = localDesembarque;
            addChange("local_desembarque", this.localDesembarque);
        }
    }
    
    public void setOrigem(Cidade origem) throws Exception{
        if( this.origem == null ) { 
            if( origem != null ) {
                this.origem = origem;
                this.origem.setCidade(origem.getCidade());
                this.origem.load();
                addChange("cidade_embarque", this.origem.getCidade());
            }        
        } else { 
            if( origem == null ) {   
                this.origem = null;
                addChange("cidade_embarque", null);   
            } else {
                if( !this.origem.equals(origem) ) {  
                    this.origem.setCidade(origem.getCidade());
                    this.origem.load();
                    addChange("cidade_embarque", this.origem.getCidade());                
                }   
            }   
        }
    }
        
    public void setDestino(Cidade destino) throws Exception{  
        if( this.destino == null ) { 
            if( destino != null ) {
                this.destino = destino;
                this.destino.setCidade(destino.getCidade());
                this.destino.load();
                addChange("cidade_desembarque", this.destino.getCidade());
            }        
        } else { 
            if( destino == null ) {   
                this.destino = null;
                addChange("cidade_desembarque", null);   
            } else {
                if( !this.destino.equals(destino) ) {  
                    this.destino.setCidade(destino.getCidade());
                    this.destino.load();
                    addChange("cidade_desembarque", this.destino.getCidade());                
                }   
            }   
        }
    }

    public void setDataEmbarque(String dataEmbarque) {
        if( !dataEmbarque.equals( this.dataEmbarque ) ) {
            this.dataEmbarque = dataEmbarque;
            addChange("data_embarque", this.dataEmbarque);
        }
    }


    
    @Override
    protected String getWhereClauseForOneEntry() {
        return " codigo_itinerario = " + this.codigoItinerario;
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
        this.codigoItinerario = (int) data.get(0);
        this.valor = (float) data.get(1);
        this.qtdParadas = (int) data.get(2);
        this.onibus = (Onibus) data.get(3);
        this.localEmbarque = (String) data.get(4);
        this.localDesembarque = (String) data.get(5);
        this.origem = (Cidade) data.get(6);
        this.destino = (Cidade) data.get(7);
        this.dataEmbarque = (String) data.get(8);
    }
    
    
   @Override
    public boolean equals(Object obj) {        
        if( obj instanceof Itinerario ) { 
           Itinerario aux;
           aux = (Itinerario) obj;
           if( codigoItinerario == aux.getCodigoItinerario()) {
               return true;
           }             
        }        
        return false;
    }  
}

