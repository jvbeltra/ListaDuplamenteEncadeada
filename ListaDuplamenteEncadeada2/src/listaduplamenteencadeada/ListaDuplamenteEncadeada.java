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

    private int cont;
    private Caixa head;
    private Caixa cursor;
    private Caixa ultimo;

    public ListaDuplamenteEncadeada(Pessoa pessoa) {
        this.head = new Caixa(pessoa, null, null);
        this.cursor = head;
        this.ultimo = head;
    }
    
    public ListaDuplamenteEncadeada (){
       
    }

    private void irParaPrimeiro() {
        this.cursor = this.head;
    }

    private void irParaUltimo() {
        this.cursor = this.ultimo;
    }

    private void retrocederKPosicoes(int k) {
        Caixa atual = acessaAtual();
    }

    private void avancaKPosicoes(int k) {
        int intCont = 0;

        while (intCont != k && cursor.getProxima() != null) {
            cursor = cursor.getProxima();
            intCont++;
        }

        if (intCont == k && cursor.getProxima() == null) {
            System.out.println("Limite de posições atingido");
        }
    }

    public void inserirAposAtual(Pessoa pessoa) {
        Caixa nova = new Caixa(pessoa);
        nova.setAnterior(cursor);
        nova.setProxima(this.cursor.getProxima());
        this.cursor = nova;
        this.cont++;
    }

    public void inserirNaFrente(Pessoa pessoa) {
        Caixa first = new Caixa(pessoa, null, this.head);
        if (this.cont !=0) this.head.setAnterior(first);
        this.head = first;
        this.head.setAnterior(ultimo);
        this.cont++;
    }

    public void inserirNoFim(Pessoa pessoa) {
        Caixa last = new Caixa(pessoa, this.ultimo, null);
        this.ultimo.setProxima(last);
        this.ultimo = last;
        this.cont++;
    }

    public void excluirAtual() {
        if (this.cont != 0) {
            this.cursor.setPessoa(null);
            if (this.cursor != this.head) {
                this.cursor  = this.cursor.getAnterior();
            } else {
                this.cursor = this.cursor.getProxima();
            }
            this.cont--;
        } else {
            System.out.println("Lista vazia!");
        }
    }

    public void excluirPrim() {
        Caixa first = head.getProxima();
        first.setAnterior(null);
        head = first;
        this.cont--;
    }

    public void excluirUlt() {
        if (cont != 0) {
            ultimo.getAnterior().setProxima(null);
            ultimo.setAnterior(ultimo.getAnterior().getAnterior());
            this.cont--;
        } else {
            System.out.println("Lista vazia!");
        }
    }

    public Caixa acessaAtual() {
        return this.cursor;
    }

    public boolean buscar(int codigo) {
        cursor = head;
        while (cursor.getProxima() != null) {
            if (codigo == cursor.getPessoa().getCodigo()) {
                return true;
            } else {
                cursor = cursor.getProxima();
            }
        }
        return ultimo.getPessoa().getCodigo() == codigo;
    }
    
    public void listarCaixas(){
        this.irParaPrimeiro();
        while(this.cursor.getProxima() != null){
            System.out.print(this.cursor.getPessoa().getNome()+", ");
            this.cursor = this.cursor.getProxima();
        }
        System.out.println(this.cursor.getPessoa().getNome());

    }

    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Joao", 1);
        Pessoa pessoa2 = new Pessoa("Caio", 2);
        Pessoa pessoa3 = new Pessoa("Cleber", 3);
        Pessoa pessoa4 = new Pessoa("Paulo", 4);
        Pessoa pessoa5 = new Pessoa("Cleiton", 5);
        Pessoa pessoa6 = new Pessoa("Frederico", 6);
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada(pessoa1);
        lista.inserirNaFrente(pessoa2);
        lista.listarCaixas();
        lista.inserirNaFrente(pessoa3);
        lista.listarCaixas();
        lista.inserirNoFim(pessoa5);
        lista.listarCaixas();
        lista.excluirPrim();
        lista.listarCaixas();
        lista.excluirUlt();
        lista.listarCaixas();
        lista.excluirUlt();
        lista.listarCaixas();
        
    }

}
