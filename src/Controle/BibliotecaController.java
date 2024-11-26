package Controle;

import Modelo.BibliotecaModel;
import Modelo.Livro;
import Visao.BibliotecaView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BibliotecaController {
    private BibliotecaModel model;
    private BibliotecaView view;

    public BibliotecaController(BibliotecaModel model, BibliotecaView view) {
        this.model = model;
        this.view = view;

        // Configura o listener do botão
        this.view.getBotaoExecutar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executarAcao();
            }
        });
    }

    private void executarAcao() {
        String titulo = view.getTitulo();
        String autor = view.getAutor();
        String livroSelecionado = view.getLivroSelecionado();
        String acao = view.getAcaoSelecionada();

        switch (acao) {
            case "Adicionar":
                adicionarLivro(titulo, autor);
                break;

            case "Emprestar":
                emprestarLivro(livroSelecionado);
                break;

            case "Devolver":
                devolverLivro(livroSelecionado);
                break;

            default:
                throw new IllegalStateException("Ação desconhecida: " + acao);
        }
    }

    private void adicionarLivro(String titulo, String autor){
        if(titulo == null || autor == null){
            JOptionPane.showMessageDialog(view, "Titulo/autor obrigatorio!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Livro livro = new Livro(titulo, autor);
        model.adicionarLivro(livro);
        view.atualizarLista(livro.toString());

    }

    private void emprestarLivro(String livroSelecionado){
        if (livroSelecionado == null) {
            JOptionPane.showMessageDialog(view, "Nenhum livro selecionado!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for(Livro livro : model.getLivros()){
            if(livro.toString().equals(livroSelecionado)){
                if(livro.isDisponivel()){
                    livro.setDisponivel(false);
                    atualizarLista();
                    JOptionPane.showMessageDialog(view, "Livro emprestado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(view, "Livro não disponivel!");
                }
                return;
            }
        }
    }

    private void devolverLivro(String livroSelecionado){
        if (livroSelecionado == null) {
            JOptionPane.showMessageDialog(view, "Nenhum livro selecionado!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for(Livro livro : model.getLivros()){
            if(livro.toString().equals(livroSelecionado)){
                if(!livro.isDisponivel()){
                    livro.setDisponivel(true);
                    atualizarLista();
                    JOptionPane.showMessageDialog(view, "Livro devolvido com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(view, "Nenhum desses livros foi emprestado!");
                }
                return;
            }
        }
    }

    private void atualizarLista() {
        DefaultListModel<String> modeloLista = view.getModeloLista();
        modeloLista.clear();
        for (Livro livro : model.getLivros()) {
            modeloLista.addElement(livro.toString()); // Adiciona os livros novamente
        }
    }
}
