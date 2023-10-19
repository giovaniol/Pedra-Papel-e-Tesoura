package Model;

import java.util.Random;
import java.util.Scanner;

public class Confronto {
    private Coisa jogador, oponente, oponente2;
    private int rounds, resposta, resposta2;
    private int[] pontos = new int[2];
    private Scanner ler = new Scanner(System.in);
    private Random gerador = new Random();

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
            do{
                System.out.println("---------------------------------\n");
                System.out.println("O Que você vai jogar?\n1 - Papel\n2 - Pedra\n3 - Papel\n");
                resposta2 = ler.nextInt();
            }while(resposta2 < 1 || resposta2 > 3);

            switch (resposta2) {
                case 1:

                    escolha(resposta2);
                    oponente = gerarCoisa(1);
                    batalha(jogador, oponente);
                    System.out.println("---------------------------------");

                    break;
                case 2:

                    escolha(resposta2);
                    oponente = gerarCoisa(1);
                    batalha(jogador, oponente);
                    System.out.println("---------------------------------");

                    break;
                case 3:

                    escolha(resposta2);
                    oponente = gerarCoisa(1);
                    batalha(jogador, oponente);
                    System.out.println("---------------------------------\n");

                    break;

                default:
                    break;
            }
        }
        somarPontos();

    }

    private void lutaRobo(int rounds) {
        for (int i = 0; i < rounds; i++) {
            oponente = gerarCoisa(1);
            oponente2 = gerarCoisa(2);
            batalha(oponente, oponente2);
            System.out.println("---------------------------------");
        }
        somarPontos();

    }

    private Coisa gerarCoisa(int jogador) {
        int computador = gerador.nextInt(3) + 1;
        Coisa jogada;

        if (computador == 1) {
            jogada = new Papel();
        } else if (computador == 2) {
            jogada = new Pedra();
        } else {
            jogada = new Tesoura();
        }

        System.out.println("Computador " + jogador + " escolheu " + jogada.getClass().getSimpleName());
        return jogada;
    }

    private void batalha(Coisa jogador, Coisa oponente) {

        if ((jogador instanceof Papel && oponente instanceof Pedra) ||
                (jogador instanceof Pedra && oponente instanceof Tesoura) ||
                (jogador instanceof Tesoura && oponente instanceof Papel)) {
            pontos[0]++;
            System.out.println("Desafiante ganhou a rodada");
        } else if ((oponente instanceof Papel && jogador instanceof Pedra) ||
                (oponente instanceof Pedra && jogador instanceof Tesoura) ||
                (oponente instanceof Tesoura && jogador instanceof Papel)) {
            pontos[1]++;
            System.out.println("Desafiado ganhou a rodada");
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

    private void escolha(int resposta2) {

        if (resposta2 == 1) {
            this.jogador = new Papel();
        } else if (resposta2 == 2) {
            this.jogador = new Pedra();
        } else {
            this.jogador = new Tesoura();
        }

        System.out.println("Você escolheu " + this.jogador.getClass().getSimpleName());

    }

    private void somarPontos() {
        if (pontos[0] > pontos[1]) {
            System.out.println("Desafiante ganhou com " + pontos[0] + " ponto(s)\n");
            resetarPontos();

        } else if (pontos[0] == pontos[1]) {
            System.out.println("Empate!!");
        } else {
            System.out.println("Desafiado Ganhou o jogo com " + pontos[1] + " ponto(s) \n");
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
    private void resetarPontos(){
        for(int i = 0; i < 2; i++){
            pontos[i] = 0;
        }
    }


}
