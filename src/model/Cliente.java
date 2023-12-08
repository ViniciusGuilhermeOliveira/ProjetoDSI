package model;

import controller.DataAccessObject;
import java.util.ArrayList;

/**
 *
 * @author Aline e Ruan
 */

public class Cliente extends DataAccessObject{
    private int codigoCliente;
    private String nome;
    private String cpf;
    private String rg;
    private String celular;
    private String telefone;
    
    
    public Cliente() {
        super("cliente");
    }
    
    public int getCodigoCliente() {
        return codigoCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getCelular() {
        return celular;
    }

    public String getTelefone() {
        return telefone;
    }
    

    public void setCodigoCliente(int codigoCliente) {
        if( codigoCliente != this.codigoCliente ) { 
            this.codigoCliente = codigoCliente;;
            addChange("codigo_cliente", this.codigoCliente);
        }  
    }

    public void setNome(String nome) {
        if( !nome.equals(this.nome) ) {
            this.nome = nome;
            addChange("nome", this.nome);            
        }
    }

    public void setCpf(String cpf) {
        if( !cpf.equals(this.cpf) ) {
            this.cpf = cpf;
            addChange("cpf", this.cpf);            
        }
    }

    public void setRg(String rg) {
        if( !rg.equals(this.rg) ) {
            this.rg = rg;
            addChange("rg", this.rg);            
        }
    }

    public void setCelular(String celular) {
        if( !celular.equals(this.celular) ) {
            this.celular = celular;
            addChange("celular", this.celular);            
        }
    }

    public void setTelefone(String telefone) {
        if( !telefone.equals(this.telefone) ) {
            this.telefone = telefone;
            addChange("telefone", this.telefone);            
        }
    }
    
    
    @Override
    protected String getWhereClauseForOneEntry() {
        return " codigo_cliente = " + this.codigoCliente;
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
        this.codigoCliente = (int) data.get(0);
        this.nome = (String) data.get(1);
        this.cpf = (String) data.get(2);
        this.rg = (String) data.get(3);
        this.celular = (String) data.get(4);
        this.telefone = (String) data.get(5);
    }
    
    @Override
    public boolean equals(Object obj) {        
        if( obj instanceof Cliente ) {
           Cliente aux;
           aux = (Cliente) obj;  
           if( codigoCliente == aux.getCodigoCliente()) {
               return true;
           }             
        }        
        return false;
    } 


    
}
