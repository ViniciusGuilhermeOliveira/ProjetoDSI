package model;

import controller.DataAccessObject;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

/**
 *
 * @author Aline e Ruan
 */

public class Funcionario extends DataAccessObject{
    private int codigoFuncionario;
    private TipoFuncionario tipoFuncionario; //cargo
    private String nome;    
    private String rg;
    private String cpf;
    private String cnh;
    private String telefone;
    private String celular;
    private String dataNascimento;
    private String rua;
    private String numero;
    private String cidade;
    private String bairro;
    private String estado;
    private String email;
    private String senhaAcesso;
    
    public Funcionario() {
        super("funcionario");
    }

    public int getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public String getRg() {
        return rg;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCelular() {
        return celular;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getEstado() {
        return estado;
    }

    public String getEmail() {
        return email;
    }

    public String getSenhaAcesso() {
        return senhaAcesso;
    }
    
    


    public void setCodigoFuncionario(int codigoFuncionario) {
        if( codigoFuncionario != this.codigoFuncionario ) {
            this.codigoFuncionario = codigoFuncionario;
            addChange("codigo_funcionario", this.codigoFuncionario);
        }
    }

    public void setTipoFuncionario(TipoFuncionario tipoFuncionario) throws Exception{
        if( this.tipoFuncionario == null ) { 
            if( tipoFuncionario != null ) {
                this.tipoFuncionario = tipoFuncionario;
                this.tipoFuncionario.setCargo(tipoFuncionario.getCargo());
                this.tipoFuncionario.load();
                addChange("tipo_funcionario", this.tipoFuncionario.getCargo());
            }        
        } else { 
            if( tipoFuncionario == null ) {   
                this.tipoFuncionario = null;
                addChange("tipo_funcionario", null);   
            } else {
                if( !this.tipoFuncionario.equals(tipoFuncionario) ) {  
                    this.tipoFuncionario.setCargo(tipoFuncionario.getCargo());
                    this.tipoFuncionario.load();
                    addChange("tipo_funcionario", this.tipoFuncionario.getCargo());                
                }   
            }   
        }
    }

    public void setNome(String nome) {
        if( !nome.equals( this.nome ) ) {
            this.nome = nome;
            addChange("nome", this.nome);
        }
    }

    public void setRg(String rg) {
        if( !rg.equals( this.rg ) ) {
            this.rg = rg;
            addChange("rg", this.rg);
        }
    }

    public void setCpf(String cpf) {
        if( !cpf.equals( this.cpf ) ) {
            this.cpf = cpf;
            addChange("cpf", this.cpf);
        }
    }

    public void setCnh(String cnh) {
        if( !cnh.equals( this.cnh ) ) {
            this.cnh = cnh;
            addChange("cnh", this.cnh);
        }
    }

    public void setTelefone(String telefone) {
        if( !telefone.equals( this.telefone ) ) {
            this.telefone = telefone;
            addChange("telefone", this.telefone);
        }
    }

    public void setCelular(String celular) {
        if( !celular.equals( this.celular ) ) {
            this.celular = celular;
            addChange("celular", this.celular);
        }
    }

    public void setDataNascimento(String dataNascimento) {
        if( !dataNascimento.equals( this.dataNascimento ) ) {
            this.dataNascimento = dataNascimento;
            addChange("data_nascimento", this.dataNascimento);
        }
    }

    public void setRua(String rua) {
        if( !rua.equals( this.rua ) ) {
            this.rua = rua;
            addChange("rua", this.rua);
        }
    }

    public void setNumero(String numero) {
        if( !numero.equals( this.numero ) ) {
            this.numero = numero;
            addChange("numero", this.numero);
        }
    }

    public void setCidade(String cidade) {
        if( !cidade.equals( this.cidade ) ) {
            this.cidade = cidade;
            addChange("cidade", this.cidade);
        }
    }

    public void setBairro(String bairro) {
        if( !bairro.equals( this.bairro ) ) {
            this.bairro = bairro;
            addChange("bairro", this.bairro);
        }
    }

    public void setEstado(String estado) {
        if( !estado.equals( this.estado ) ) {
            this.estado = estado;
            addChange("estado", this.estado);
        }
    }

    public void setEmail(String email) {
        if( !email.equals( this.email ) ) {
            this.email = email;
            addChange("email", this.email);
        }
    }

    public void setSenhaAcesso(String senhaAcesso) {
        if( !senhaAcesso.equals( this.senhaAcesso ) ) {
            this.senhaAcesso = getSenhaHash( senhaAcesso );
            addChange("senha_acesso", this.senhaAcesso);
        }
    }
    
    private String getSenhaHash(String senhaAcesso) {
        String senhaHash = "";
        try {            
            MessageDigest md = MessageDigest.getInstance( "SHA-256" );            
            senhaAcesso += String.valueOf( getCodigoFuncionario());
            senhaHash = new BigInteger( 1, md.digest( senhaAcesso.getBytes("UTF-8") ) ).toString(16);       
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }               
        return senhaHash;
    }
    
    

    @Override
    protected String getWhereClauseForOneEntry() {
        return " codigo_funcionario = " + this.codigoFuncionario;
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
        codigoFuncionario = (int) data.get(0);
        nome = (String) data.get(1);
        cpf = (String) data.get(2);
        rg = (String) data.get(3);
        cnh = (String) data.get(4);
        telefone = (String) data.get(5);
        celular = (String) data.get(6);
        dataNascimento = (String) data.get(7);
        rua = (String) data.get(8);
        numero = (String) data.get(9);
        cidade = (String) data.get(10);
        bairro = (String) data.get(11);
        estado = (String) data.get(12);
        email = (String) data.get(13);  
        tipoFuncionario = (TipoFuncionario) data.get(14);
        senhaAcesso = (String) data.get(15);
    }
    
    @Override
    public boolean equals(Object obj) {        
        if( obj instanceof Funcionario ) {
           Funcionario aux;
           aux = (Funcionario) obj;  
           if( codigoFuncionario == aux.getCodigoFuncionario() ) {
               return true;
           }             
        }        
        return false;
    }
}
