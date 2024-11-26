package Visao;

import Controle.BibliotecaController;
import Modelo.BibliotecaModel;

public class BibliotecaApp {
    public static void main(String[] args) {
        BibliotecaModel model = new BibliotecaModel();
        BibliotecaView view = new BibliotecaView();
        new BibliotecaController(model, view);

        view.setVisible(true);
    }
}
