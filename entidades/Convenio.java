package Projeto1Poo.entidades;

public class Convenio {
    
    private String nomeDoPlano;
    private String numeroDoPlano;
    private String tipoDePlano;

    public Convenio(String nomeDoPlano, String numeroDoPlano, String tipoDePlano){
        this.nomeDoPlano = nomeDoPlano;
        this.numeroDoPlano = numeroDoPlano;
        this.tipoDePlano = tipoDePlano;
    }

    public String getNomeDoPlano() {
        return nomeDoPlano;
    }

    public void setNomeDoPlano(String nomeDoPlano) {
        this.nomeDoPlano = nomeDoPlano;
    }

    public String getNumeroDoPlano() {
        return numeroDoPlano;
    }

    public void setNumeroDoPlano(String numeroDoPlano) {
        this.numeroDoPlano = numeroDoPlano;
    }

    public String getTipoDePlano() {
        return tipoDePlano;
    }

    public void setTipoDePlano(String tipoDePlano) {
        this.tipoDePlano = tipoDePlano;
    }

    
}
