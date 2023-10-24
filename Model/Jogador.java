package Model;

import java.util.Random;

public class Jogador {
    private Coisa escolha;

    public Jogador() {
        Random gerador = new Random();
        int gerado = gerador.nextInt(3) + 1;
        gerar(gerado);

    }

    public Jogador(int escolha) {
        escolha(escolha);
    }

    public void escolha(int resposta2) {

        gerar(resposta2);

    }

    public Coisa getEscolha() {
        return this.escolha;
    }

    private void gerar(int resposta2) {

        if (resposta2 == 1) {
            this.escolha = new Papel();
        } else if (resposta2 == 2) {
            this.escolha = new Pedra();
        } else {
            this.escolha = new Tesoura();
        }

    }

}
