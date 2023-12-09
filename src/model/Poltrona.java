package model;

import controller.DataAccessObject;
import java.util.ArrayList;
import model.Onibus;
/**
 *
 * @author Aline e Ruan
 */
public class Poltrona extends DataAccessObject{
    private int codigoPoltrona; //codigo no sistema
    private int onibus; //codigo onibus
    private int statusPoltrona; //Livre/Ocupada
    private int numeroPoltrona; //representa o número do assento no onibus
    
    
    public Poltrona() {
        super("poltrona");
    }

    
    public int getCodigoPoltrona() {
        return codigoPoltrona;
    }

    public int getOnibus() {
        return onibus;
    }

    public int getStatusPoltrona() {
        return statusPoltrona;
    }

    public int getNumeroPoltrona() {
        return numeroPoltrona;
    }


    public void setCodigoPoltrona(int codigoPoltrona) {   
        if( codigoPoltrona != this.codigoPoltrona ) { 
            this.codigoPoltrona = codigoPoltrona;
            addChange("codigo_poltrona", this.codigoPoltrona);
        }
    }

    public void setOnibus(int onibus) throws Exception{
        this.onibus = onibus;

    }

    public void setStatusPoltrona(int statusPoltrona) {
        if( statusPoltrona != this.statusPoltrona ) { 
            this.statusPoltrona = statusPoltrona;
            addChange("status", this.statusPoltrona);
        }
    }

    public void setNumeroPoltrona(int numeroPoltrona) {
        if( numeroPoltrona != this.numeroPoltrona ) { 
            this.numeroPoltrona = numeroPoltrona;
            addChange("numero", this.numeroPoltrona);
        }
    }

   

    @Override
    protected String getWhereClauseForOneEntry() {
        return " codigo_poltrona = " + this.codigoPoltrona;
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
        this.codigoPoltrona = (int) data.get(0);
        this.statusPoltrona = (int) data.get(1);
        this.numeroPoltrona = (int) data.get(2);
        this.onibus = (int) data.get(3);
    }
    

    @Override
    public boolean equals(Object obj) {        
        if( obj instanceof Poltrona ) {
           Poltrona aux;
           aux = (Poltrona) obj;  
           if( codigoPoltrona == aux.getCodigoPoltrona()) {
               return true;
           }             
        }        
        return false;
    }
    
    
}
