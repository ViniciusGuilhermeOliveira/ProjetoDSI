package model;

import controller.DataAccessObject;
import java.util.ArrayList;

/**
 *
 * @author Aline e Ruan
 */

public class TipoFuncionario extends DataAccessObject{
    private int codigoTipoFuncionario;
    private String cargo;
    private String moduloVenda;
    
    
    public TipoFuncionario() {
        super("tipo_funcionario");
    }

    public int getCodigoTipoFuncionario() {
        return codigoTipoFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public String getModuloVenda() {
        return moduloVenda;
    }

    
    
    public void setCodigoTipoFuncionario(int codigoTipoFuncionario) {
        if( codigoTipoFuncionario != this.codigoTipoFuncionario ) { 
            this.codigoTipoFuncionario = codigoTipoFuncionario;
            addChange("codigo_tipo_funcionario", this.codigoTipoFuncionario);
        }
    }

    public void setCargo(String cargo) {
        if( !cargo.equals(this.cargo) ) {
            this.cargo = cargo;
            addChange("cargo", this.cargo);            
        } 
    }

    public void setModuloVenda(String moduloVenda) {
        if( !moduloVenda.equals(this.moduloVenda) ) {
            this.moduloVenda = moduloVenda;
            addChange("modulo_venda", this.moduloVenda);            
        } 
    }
    
    

    @Override
    protected String getWhereClauseForOneEntry() {
        return " codigo_tipo_funcionario = " + this.codigoTipoFuncionario;
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
        this.codigoTipoFuncionario = (int) data.get(0);
        this.cargo = (String) data.get(1);
        this.moduloVenda = (String) data.get(2);
    }
    
    
    @Override
    public boolean equals(Object obj) {        
        if( obj instanceof TipoFuncionario ) {
           TipoFuncionario aux;
           aux = (TipoFuncionario) obj;  
           if( codigoTipoFuncionario == aux.getCodigoTipoFuncionario()) {
               return true;
           }             
        }        
        return false;
    }  
}
