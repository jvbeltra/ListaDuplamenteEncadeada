/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaduplamenteencadeada;

/**
 *
 * @author Joao
 */
public class ListaDuplamenteEncadeada {

    private Caixa head;
    private Caixa cursor;
    private Caixa ultimo;

    public ListaDuplamenteEncadeada(Pessoa pessoa) {
        this.head = new Caixa(pessoa, null, null);
        this.cursor = head;
        this.ultimo = head;
    }

    private void irParaPrimeiro() {
        this.cursor = this.head;
    }
    
    private void irParaUltimo(){
        this.cursor = this.ultimo;
    }
    
    private void retrocederKPosicoes(int k){
        Caixa atual = acessaAtual();
        
    }

    public void InserirAposAtual(Pessoa pessoa) {
        //melhorar isso aqui, não tenho certeza se eh assim
        Caixa nova = new Caixa(pessoa, this.head.getAnterior(), this.head.getProxima());
        this.cursor = nova ;
    }

    public void inserirNaFrente(Pessoa pessoa) {
        Caixa first = new Caixa(pessoa, null, this.head);
        this.head.setAnterior(first);
        this.head = first;
    }
    
    public void inserirNoFim(Pessoa pessoa){
        Caixa last = new Caixa(pessoa, this.ultimo, null);
        this.ultimo.setProxima(last);
        this.ultimo = last;
    }

    public void ExcluirAtual() {
        
    }
    
    public void ExcluirPrim(){
        Caixa first = head.getProxima();
        first.setAnterior(null);
        head = first;
    }

    public void ExcluirUlt() {

    }

    public Caixa acessaAtual() {
        return this.cursor;
    }
    
    public boolean buscar(int codigo){
       cursor = head;
       while(cursor.getProxima()!=null){
           if(codigo == cursor.getPessoa().getCodigo()){
               return true;
           }else{
               cursor=cursor.getProxima();
           }
       }
       return ultimo.getPessoa().getCodigo()==codigo; 
    }

    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Joao", 1);
        Pessoa pessoa2 = new Pessoa("Caio", 2);
        Pessoa pessoa3 = new Pessoa("Cleber", 3);
        Pessoa pessoa4 = new Pessoa("Paulo", 4);
        Pessoa pessoa5 = new Pessoa("Cleiton", 5);
        Pessoa pessoa6 = new Pessoa("Frederico", 6);

        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada(pessoa1);
    }

}
