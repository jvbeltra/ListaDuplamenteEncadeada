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
        int intCont = 0;
        
        while(intCont!=k && cursor.getAnterior()!= null){
            cursor = cursor.getAnterior();
            intCont++;
        }
        if (intCont!= k && cursor.getAnterior() == null){
            System.out.println("Limite de posições atingido");
        }
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
    
    public void inserirAntesAtual(Pessoa pessoa){
        Caixa nova = new Caixa(pessoa);
        nova.setProxima(cursor);
        if(this.cursor.getAnterior()!=null){
            nova.setAnterior(this.cursor.getAnterior());
        }else{
            nova.setAnterior(null);
            head = nova;
        }
        
    }
    
   
    public void inserirAposAtual(Pessoa pessoa) {
        Caixa nova = new Caixa(pessoa);
        nova.setAnterior(cursor);
        //System.out.println(this.cursor.getPessoa().getNome() + "<1");
        //System.out.println(nova.getPessoa().getNome() + "<1");
        
        if (this.cursor.getProxima() != null) {
            nova.setProxima(this.cursor.getProxima());
        } else {
            nova.setProxima(null);
        }
        
        this.cursor = nova;
        this.cont++;
    }
    
    public void inserirNaPosicao(Pessoa pessoa, int k){
        Caixa nova = new Caixa(pessoa);
        cursor = head;
        if(k<= cont){
            for(int i= 1; i<=k; i++){
                cursor = cursor.getProxima();
            }
            nova.setAnterior(cursor.getAnterior());
            nova.setProxima(cursor);
            cursor.setAnterior(nova);
            cont++;
        }else{
            System.out.println("Limite de posições atingido");
        }
        
    }
    
    public void inserirNaFrente(Pessoa pessoa) {
        Caixa first = new Caixa(pessoa, null, this.head);
        if (this.cont != 0) {
            this.head.setAnterior(first);
        }
        this.head = first;
        this.head.setAnterior(null);
        if (this.ultimo == null && this.head != null) {
            this.cursor = this.head;
            if (this.head.getProxima() != null) {
                this.ultimo = this.head.getProxima();
            } else {
                this.ultimo = head;
            }
        }
        this.cont++;
    }

    public void inserirNoFim(Pessoa pessoa) {
        
            
        if(cont!=0){
            Caixa last = new Caixa(pessoa, this.ultimo, null);
            this.ultimo.setProxima(last);
            this.ultimo = last;
            this.cont++;
        }else{
            Caixa last = new Caixa(pessoa);
            head = last;
            ultimo = last;
            this.cont++;
        }
        
    }

    public void excluirAtual() {
        if (this.cont != 0) {
            if (this.cursor != this.head) {
                this.cursor = this.cursor.getAnterior();
            } else {
                this.cursor = this.cursor.getProxima();
            }
            this.cont--;
        } else {
            System.out.println("Lista vazia!");
        }
    }

    public void excluirPrim() {
        
        
        if(cont == 1){
            head = null;
            ultimo = null;
        }else if(cont>1){    
            Caixa first = head.getProxima();
            first.setAnterior(null);
            head = first;
            this.cont--;
        }else{
            System.out.println("Nada na lista");
        }
        
    }

    public void excluirUlt() {
        if (cont != 0) {
            if (ultimo.getAnterior() == null) {
                head = null;
                ultimo = head;
            } else {
                ultimo = ultimo.getAnterior();
                ultimo.setProxima(null);
            }
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

    public void listarCaixas() {
        this.irParaPrimeiro();
//        if (this.cursor != null) {
            Caixa aux = head;
            //System.out.println(aux);
            while (aux != null) {
                System.out.print(aux.getPessoa().getNome() + ", ");
                aux = aux.getProxima();
            }
//            if (this.cursor.getPessoa() != null) {
//                System.out.println(this.cursor.getPessoa().getNome());
//            }
        
    }
    
   public void acessaLista(){
        cursor = head;
        System.out.println("InicioLista"); 
        if(cursor!=null){
            System.out.println(cursor.getPessoa().getNome());
            for(int i = 0; i <cont; i++){
            cursor = cursor.getProxima();
            if(cursor!= null){    
                
                System.out.println(cursor.getPessoa().getNome());
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
        lista.inserirNaFrente(pessoa2);
        lista.inserirNoFim(pessoa3);
        lista.inserirNaFrente(pessoa4);
        lista.excluirUlt();
        lista.excluirUlt();
        lista.excluirUlt();
        lista.excluirUlt();
        lista.inserirNaFrente(pessoa2);
        lista.excluirUlt();
        lista.inserirNoFim(pessoa3);
        lista.acessaLista();
    }

}
