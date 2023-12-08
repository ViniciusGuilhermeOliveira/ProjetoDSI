package model;

import controller.DataAccessObject;
import java.util.ArrayList;
import model.TipoOnibus;

/**
 *
 * @author Aline e Ruan
 */

public class Onibus extends DataAccessObject{
   private int codigoOnibus;
   private String placa;
   private TipoOnibus tipoOnibus;
   
   public Onibus() {
        super("onibus");
    }

    public int getCodigoOnibus() {
        return codigoOnibus;
    }

    public String getPlaca() {
        return placa;
    }

    public TipoOnibus getTipoOnibus() {
        return tipoOnibus;
    }

    
    
    public void setCodigoOnibus(int codigoOnibus) {
        if( codigoOnibus != this.codigoOnibus ) { 
            this.codigoOnibus = codigoOnibus;
            addChange("codigo_onibus", this.codigoOnibus);
        } 
    }

    public void setPlaca(String placa) {
        if( placa != this.placa ) { 
            this.placa = placa;
            addChange("placa", this.placa);
        } 
    }

    public void setTipoOnibus(TipoOnibus tipoOnibus) throws Exception{
        if( this.tipoOnibus == null ) { 
            if( tipoOnibus != null ) {
                this.tipoOnibus = tipoOnibus;
                this.tipoOnibus.setCodigoTipoOnibus(tipoOnibus.getCodigoTipoOnibus());
                this.tipoOnibus.load();
                addChange("tipo_onibus", this.tipoOnibus.getCodigoTipoOnibus());
            }        
        } else { 
            if( tipoOnibus == null ) {   
                this.tipoOnibus = null;
                addChange("tipo_onibus", null);   
            } else {
                if( !this.tipoOnibus.equals(tipoOnibus) ) {  
                    this.tipoOnibus.setCodigoTipoOnibus(tipoOnibus.getCodigoTipoOnibus());
                    this.tipoOnibus.load();
                    addChange("tipo_onibus", this.tipoOnibus.getCodigoTipoOnibus());                
                }   
            }   
        }
    }

    @Override
    protected String getWhereClauseForOneEntry() {
        return " codigo_onibus = " + this.codigoOnibus;
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
        this.codigoOnibus = (int) data.get(0);
        this.placa = (String) data.get(1);
        this.tipoOnibus = (TipoOnibus) data.get(2);

    }
   
@Override
    public boolean equals(Object obj) {        
        if( obj instanceof Onibus ) { 
           Onibus aux;
           aux = (Onibus) obj;
           if( codigoOnibus == aux.getCodigoOnibus()) {
               return true;
           }             
        }        
        return false;
    }  
}
