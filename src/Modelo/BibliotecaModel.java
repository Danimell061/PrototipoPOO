package Modelo;

import java.util.ArrayList;

public class BibliotecaModel {
    private ArrayList<Livro> livros;

    public BibliotecaModel(){
        livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro){
        livros.add(livro);
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void imprimirLivros(){
        for(Livro l: livros){
            System.out.println(l);
        }
    }
}
