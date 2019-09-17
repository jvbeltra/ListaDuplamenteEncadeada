/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaduplamenteencadeada;

/**
 *
 * @author Joao Beltramini e Caio Noguerol
 */
public class Caixa {
    private Pessoa pessoa;
    private Caixa anterior;
    private Caixa proxima;

    public Caixa(Pessoa pessoa, Caixa anterior, Caixa proxima) {
        this.pessoa = pessoa;
        this.anterior = anterior;
        this.proxima = proxima;
    }
    
    public Caixa(Pessoa pessoa){
        this.pessoa = pessoa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Caixa getAnterior() {
        return anterior;
    }

    public void setAnterior(Caixa anterior) {
        this.anterior = anterior;
    }

    public Caixa getProxima() {
        return proxima;
    }

    public void setProxima(Caixa proxima) {
        this.proxima = proxima;
    }
}
