package model;

import controller.DataAccessObject;
import java.util.ArrayList;

/**
 *
 * @author Aline e Ruan
 */

public class TipoOnibus extends DataAccessObject{
   private int codigoTipoOnibus;
   private String descricao;
   private int qtdPoltrona;
   
   
    public TipoOnibus() {
        super("TipoOnibus");
    }

    
    public int getCodigoTipoOnibus() {
        return codigoTipoOnibus;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQtdPoltrona() {
        return qtdPoltrona;
    }

    public void setCodigoTipoOnibus(int codigoTipoOnibus) {
        if( codigoTipoOnibus != this.codigoTipoOnibus ) { 
            this.codigoTipoOnibus = codigoTipoOnibus;
            addChange("codigo_tipo_onibus", this.codigoTipoOnibus);
        } 
    }

    public void setDescricao(String descricao) {
        if( !descricao.equals(this.descricao) ) {
            this.descricao = descricao;
            addChange("descricao", this.descricao);            
        } 
    }

    public void setQtdPoltrona(int qtdPoltrona) {
        if( qtdPoltrona != this.qtdPoltrona ) { 
            this.qtdPoltrona = qtdPoltrona;
            addChange("qtd_poltrona", this.qtdPoltrona);
        } 
    }
    

    @Override
    protected String getWhereClauseForOneEntry() {
        return " codigo_tipo_onibus = " + this.codigoTipoOnibus;
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
        this.codigoTipoOnibus = (int) data.get(0);
        this.descricao = (String) data.get(1);
        this.qtdPoltrona = (int) data.get(2);
    }
   
   @Override
    public boolean equals(Object obj) {        
        if( obj instanceof TipoOnibus ) {
           TipoOnibus aux;
           aux = (TipoOnibus) obj;  
           if( codigoTipoOnibus == aux.getCodigoTipoOnibus()) {
               return true;
           }             
        }        
        return false;
    }

   
   
   
   
   
   
   
}
