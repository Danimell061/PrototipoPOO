package Visao;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BibliotecaView extends JFrame {
    private JTextField txtTitulo, txtAutor;
    private JComboBox<String> comboAcoes;
    private JList<String> listaLivros;
    private JButton btnExecutar;
    private DefaultListModel<String> modeloLista;

    public BibliotecaView() {
        // Configuração principal da janela
        setTitle("Biblioteca - Gerenciamento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Painel superior (formulário)
        JPanel painelSuperior = new JPanel(new GridLayout(2, 2));
        painelSuperior.setBorder(new EmptyBorder(10, 10, 10, 10));
        painelSuperior.add(new JLabel("Título:"));
        txtTitulo = new JTextField();
        painelSuperior.add(txtTitulo);
        painelSuperior.add(new JLabel("Autor:"));
        txtAutor = new JTextField();
        painelSuperior.add(txtAutor);
        add(painelSuperior, BorderLayout.NORTH);

        // Painel central (lista de livros)
        modeloLista = new DefaultListModel<>();
        listaLivros = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(listaLivros);
        scrollPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(scrollPane, BorderLayout.CENTER);

        // Painel inferior (ações)
        JPanel painelInferior = new JPanel(new GridLayout(1, 3));
        painelInferior.setBorder(new EmptyBorder(10, 10, 10, 10));
        comboAcoes = new JComboBox<>(new String[]{"Adicionar", "Emprestar", "Devolver"});
        painelInferior.add(comboAcoes);
        btnExecutar = new JButton("Executar");
        painelInferior.add(btnExecutar);
        add(painelInferior, BorderLayout.SOUTH);
    }

    public String getTitulo() {
        return txtTitulo.getText();
    }

    public String getAutor() {
        return txtAutor.getText();
    }

    public String getAcaoSelecionada() {
        return (String) comboAcoes.getSelectedItem();
    }

    public String getLivroSelecionado(){
        return listaLivros.getSelectedValue();
    }

    public void atualizarLista(String livro) {
        modeloLista.addElement(livro);
    }

    public DefaultListModel<String> getModeloLista() {
        return modeloLista;
    }

    public JButton getBotaoExecutar() {
        return btnExecutar;
    }
}
