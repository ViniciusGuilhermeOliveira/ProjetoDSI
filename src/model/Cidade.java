package model;

import controller.DataAccessObject;
import java.util.ArrayList;

/**
 *
 * @author Aline e Ruan
 */

public class Cidade extends DataAccessObject{
    private int codigoCidade;
    private String cidade;
    private String estado; 
    
    
    public Cidade() {
        super("cidade");
    }
    
    
    public int getCodigoCidade() {
        return codigoCidade;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }
    
    
    public void setCodigoCidade(int codigoCidade) {
        if( codigoCidade != this.codigoCidade ) { 
            this.codigoCidade = codigoCidade;
            addChange("codigo_cidade", this.codigoCidade);
        }     
    }

    public void setCidade(String cidade) { 
        if( !cidade.equals(this.cidade) ) {
            this.cidade = cidade;
            addChange("cidade", this.cidade);            
        }   
    }

    public void setEstado(String estado) {
        if( !estado.equals(this.estado) ) {
            this.estado = estado;
            addChange("estado", this.estado);            
        }   
    }
    

    @Override
    protected String getWhereClauseForOneEntry() {
        return " codigo_cidade = " + this.codigoCidade;
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
        this.codigoCidade = (int) data.get(0);
        this.cidade = (String) data.get(1);
        this.estado = (String) data.get(2);
    }
    
    @Override
    public boolean equals(Object obj) {        
        if( obj instanceof Cidade ) {
           Cidade aux;
           aux = (Cidade) obj;  
           if( codigoCidade == aux.getCodigoCidade() ) {
               return true;
           }             
        }        
        return false;
    }   
}
