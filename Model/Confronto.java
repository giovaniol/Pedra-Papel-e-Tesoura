package Model;

import java.util.Scanner;

public class Confronto {
    private Jogador jogador, jogador2;
    private int rounds, resposta, resposta2;
    private int[] pontos = new int[2];
    private Scanner ler = new Scanner(System.in);

    public void Confrontar() {
        do {
            do {
                System.out.println(
                        "\nO que deseja escolher?\n1 - Humano x Computador\n2 - Computador x Computador\n0 - Sair do programa\n");
                resposta = ler.nextInt();
            } while (resposta < 0 || resposta > 2);

            switch (resposta) {
                case 1:
                    do {

                        System.out.println("Quantas Rodadas?\n1 - Melhor de 1\n2 - Melhor de 3");
                        rounds = ler.nextInt();
                    } while (rounds < 1 || rounds > 2);
                    verificar(rounds);

                    break;
                case 2:
                    do {
                        System.out.println("Quantas Rodadas?\n1 - Melhor de 1\n2 - Melhor de 3");
                        rounds = ler.nextInt();
                    } while (rounds < 1 || rounds > 2);
                    verificarR(rounds);
                    break;
                case 0:
                    System.out.println("Saindo...");
                default:
                    break;
            }
        } while (resposta != 0);

    }

    private void luta(int rounds) {
        for (int i = 0; i < rounds; i++) {
            do {
                text();
                System.out.println("O Que você vai jogar?\n1 - Papel\n2 - Pedra\n3 - Papel\n");
                resposta2 = ler.nextInt();
            } while (resposta2 < 1 || resposta2 > 3);

            switch (resposta2) {
                case 1:

                    jogador = instanciar(jogador, resposta2);
                    jogador.escolha(resposta2);
                    escrever(jogador);
                    jogador2 = instanciar(jogador2);
                    escrever();
                    batalha(jogador, jogador2);
                    text();

                    break;
                case 2:
                    jogador = instanciar(jogador, resposta2);
                    jogador.escolha(resposta2);
                    escrever(jogador);
                    jogador2 = instanciar(jogador2);
                    escrever();
                    batalha(jogador, jogador2);
                    text();

                    break;
                case 3:

                    jogador = instanciar(jogador, resposta2);
                    jogador.escolha(resposta2);
                    escrever(jogador);
                    jogador2 = instanciar(jogador2);
                    escrever();
                    batalha(jogador, jogador2);
                    text();

                    break;

                default:
                    break;
            }
        }
        somarPontos();

    }

    private void lutaRobo(int rounds) {

        for (int i = 0; i < rounds; i++) {
            this.jogador = instanciar(jogador);
            System.out.println("Jogador1 escolheu " + jogador.getEscolha().getClass().getSimpleName());
            this.jogador2 = instanciar(jogador2);
            System.out.println("Jogador2 escolheu " + jogador2.getEscolha().getClass().getSimpleName());
            batalha(jogador, jogador2);
            text();
        }
        somarPontos();

    }

    private void batalha(Jogador jogador1, Jogador jogador2) {

        if (jogador1.getEscolha().batalha(jogador2.getEscolha())) {
            pontos[0]++;
            System.out.println("Jogador1 ganhou a rodada");
        } else if (jogador2.getEscolha().batalha(jogador1.getEscolha())) {
            pontos[1]++;
            System.out.println("Jogador2 ganhou a rodada");
        } else {
            System.out.println("Empatou. Ambos escolheram a mesma coisa.");
        }
    }

    private void verificar(int rounds) {
        if (rounds == 1) {
            luta(rounds);
        } else {
            rounds = 3;
            luta(rounds);
        }
    }

    private void somarPontos() {
        if (pontos[0] > pontos[1]) {
            System.out.println(jogador.getClass().getSimpleName() + "1 ganhou com " + pontos[0] + " ponto(s)\n");
            resetarPontos();

        } else if (pontos[0] == pontos[1]) {
            System.out.println("Empate!!");
            resetarPontos();
        } else {
            System.out.println(jogador.getClass().getSimpleName() + "2 ganhou com " + pontos[1] + " ponto(s)\n");
            resetarPontos();
        }

    }

    private void verificarR(int rounds) {
        if (rounds == 1) {
            lutaRobo(rounds);
        } else {
            rounds = 3;
            lutaRobo(rounds);
        }
    }

    private void resetarPontos() {
        for (int i = 0; i < 2; i++) {
            pontos[i] = 0;
        }
    }

    private Jogador instanciar(Jogador escolhido, int opcao) {
        return escolhido = new Jogador(opcao);

    }

    private Jogador instanciar(Jogador escolhido) {

        return escolhido = new Jogador();

    }

    private void text() {
        System.out.println("---------------------------------\n");
    }

    private void escrever(Jogador player) {
        System.out.println("Jogador1 escolheu " + player.getEscolha().getClass().getSimpleName());
    }

    private void escrever() {
        System.out.println("Jogador2 escolheu " + jogador2.getEscolha().getClass().getSimpleName());
    }
}
