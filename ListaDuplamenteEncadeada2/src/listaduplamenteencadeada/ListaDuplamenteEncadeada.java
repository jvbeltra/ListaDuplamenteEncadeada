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
        this.cont++;
    }

    private void irParaPrimeiro() {
        this.cursor = this.head;
    }

    private void irParaUltimo() {
        this.cursor = this.ultimo;
    }

    private void retrocederKPosicoes(int k) {
        if (k >= 0) {
            for (int i = 0; i < k; i++) {
                if (this.cursor.getAnterior() != null) {
                    this.cursor = this.cursor.getAnterior();
                } else {
                    throw new IllegalArgumentException("Posicao inexistente");
                }
            }
        } else {
            throw new IllegalArgumentException("Posicao inexistente");

        }

    }

    private void avancaKPosicoes(int k) {
        if (k >= 0) {
            for (int i = 0; i < k; i++) {
                if (this.cursor.getProxima() != null) {
                    this.cursor = this.cursor.getProxima();
                } else {
                    throw new IllegalArgumentException("Posicao inexistente");
                }
            }
        } else {
            throw new IllegalArgumentException("Posicao inexistente");

        }

    }

    public void inserirAntesAtual(Pessoa pessoa) {
        Caixa nova = new Caixa(pessoa);
        if (cont > 1) {
            nova.setProxima(this.cursor);
            if (this.cursor.getAnterior() != null) {
                nova.setAnterior(cursor.getAnterior());
                this.cursor.getAnterior().setProxima(nova);
                this.cursor.setAnterior(nova);
                this.cursor = nova;
                cont++;
            } else {
                this.cursor.setAnterior(nova);
                this.cursor = nova;
                this.head = this.cursor;
                cont++;
            }
        } else if (cont <= 1) {
            this.inserirNaFrente(pessoa);
        }

    }

    public void inserirAposAtual(Pessoa pessoa) {
        
        if (cont > 1) {
            if (this.cursor.getProxima() == null) {
                Caixa nova = new Caixa(pessoa, this.cursor, null);
                this.cursor.setProxima(nova);
                this.cursor = nova;
            } else {
                Caixa nova = new Caixa(pessoa);
                nova.setAnterior(this.cursor);
                nova.setProxima(cursor.getProxima());
                this.cursor.getProxima().setAnterior(nova);
                this.cursor.setProxima(nova);
                this.cursor = nova;
            }
            cont++;
        } else if (cont <= 1) {
            this.inserirNoFim(pessoa);
        }

    }

    public void inserirNaPosicao(Pessoa pessoa, int k) {
        Caixa nova = new Caixa(pessoa);
        irParaPrimeiro();
        avancaKPosicoes(k);
        if(cursor.getProxima() == null){
            inserirNoFim(pessoa);
        }else if(k == 0){
            inserirNaFrente(pessoa);
        }else{
            nova.setProxima(cursor);
        nova.setAnterior(this.cursor.getAnterior());
        this.cursor.getAnterior().setProxima(nova);
        this.cursor.setAnterior(nova);
        cursor = nova;
        cont++;
        }
        
    }

    public void inserirNaFrente(Pessoa pessoa) {
        if (cont != 0) {
            Caixa first = new Caixa(pessoa, null, this.head);
            this.head.setAnterior(first);
            this.head = first;
            this.cursor = first;
        } else {
            Caixa first = new Caixa(pessoa);
            this.head = first;
            this.ultimo = first;
            this.cursor = first;
        }

        this.cont++;
//      
    }

    public void inserirNoFim(Pessoa pessoa) {

        if (cont != 0) {
            Caixa last = new Caixa(pessoa, this.ultimo, null);
            this.ultimo.setProxima(last);
            this.ultimo = last;
            this.cursor = last;
        } else {
            Caixa last = new Caixa(pessoa);
            this.head = last;
            this.ultimo = last;
            this.cursor = last;
        }

        this.cont++;

    }

    public void excluirAtual() {
        if(cont!=0){
            if(acessaAtual()== head){
                excluirPrim();
            }else if( acessaAtual() == ultimo){
                excluirUlt();
            }else{
                Caixa aux = acessaAtual();
                aux.getAnterior().setProxima(aux.getProxima());
                aux.getProxima().setAnterior(aux.getAnterior());
                cursor = aux.getAnterior();
                aux.setAnterior(null);
                aux.setProxima(null);
                cont--;
            }
        }else{
            System.out.println("Lista ja esta vazia");
        }
    }

    public void excluirPrim() {

        if (cont == 1) {
            head = null;
            ultimo = null;
            this.cont--;
        } else if (cont > 1) {
            Caixa first = head.getProxima();
            first.setAnterior(null);
            head = first;
            cursor = first;
            this.cont--;
        } else {
            System.out.println("Lista ja esta vazia");
        }

    }

    public void excluirUlt() {
        if (cont != 0) {
            if (ultimo.getAnterior() == null) {
                head = null;
                ultimo = head;
                cursor = null;
            } else {
                
                Caixa aux = ultimo.getAnterior();
                ultimo.setAnterior(null);
                ultimo = aux;
                ultimo.setProxima(null);
                cursor = ultimo;
            }
            this.cont--;
        } else {
            System.out.println("Lista ja esta vazia");
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

    public void acessaLista() {
        cursor = head;
        System.out.println("InicioLista");
        if (cursor != null) {
            System.out.println(cursor.getPessoa().getNome());

            for (int i = 0; i < cont; i++) {
                if (cursor.getProxima() != null) {
                    cursor = cursor.getProxima();
                    if (cursor != null) {

                        System.out.println(cursor.getPessoa().getNome());
                    }

                }
            }

        }

        System.out.println("FimLista");

    }

    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Joao", 1);
        Pessoa pessoa2 = new Pessoa("Caio", 2);
        Pessoa pessoa3 = new Pessoa("Cleber", 3);
        Pessoa pessoa4 = new Pessoa("Paulo", 4);
        Pessoa pessoa5 = new Pessoa("Cleiton", 5);
        Pessoa pessoa6 = new Pessoa("Frederico", 6);
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada(pessoa1);
        lista.inserirAntesAtual(pessoa6);
        lista.inserirAposAtual(pessoa5);
        lista.inserirNoFim(pessoa2);
        lista.inserirNaFrente(pessoa3);
        lista.inserirNaPosicao(pessoa1, 2);
        lista.excluirAtual();
        lista.excluirUlt();
        lista.excluirUlt();
        lista.excluirPrim();
        lista.excluirAtual();
        lista.excluirAtual();
        lista.excluirUlt();
        lista.inserirAntesAtual(pessoa6);
        lista.inserirAposAtual(pessoa5);
        lista.inserirNoFim(pessoa2);
        lista.inserirNaFrente(pessoa3);
        lista.inserirNaPosicao(pessoa1, 2);
          
        lista.acessaLista();
    }

}
