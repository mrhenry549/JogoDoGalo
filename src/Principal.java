

import java.util.Scanner;

public class Principal {

    private int counter;
    private final char posicao[] = new char[10];
    private char jogador;

    public static void main(String args[]) {
        String ch;
        Principal Galo = new Principal();
        do {
            Galo.novaTabela();
            Galo.jogar();
            System.out.println("Querem jogar outra vez (escreve 's' se aceita ou 'n' se quer acabar o programa)? ");
            Scanner in = new Scanner(System.in);
            ch = in.nextLine();
        } while (ch.equals("s"));

    }

    public void novaTabela() { // cria uma nova tabela

        char posicaodef[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int i;
        counter = 0;
        jogador = 'X';
        for (i = 1; i < 10; i++) {
            posicao[i] = posicaodef[i];
        }
        tabelaJogo();

    }

    public String tabelaJogo() { // desenha tabela
        System.out.println(" \t\t  " + posicao[7] + " | " + posicao[8] + " | " + posicao[9]);
        System.out.println(" \t\t ---+---+--- ");
        System.out.println(" \t\t  " + posicao[4] + " | " + posicao[5] + " | " + posicao[6]);
        System.out.println(" \t\t ---+----+--- ");
        System.out.println(" \t\t  " + posicao[1] + " | " + posicao[2] + " | " + posicao[3]);
        return "tabelaJogo";
    }

    public void jogar() { // ronda do jogador
        int spot;
        char blank = ' ';

        do {

            System.out.println("\n\n Jogador " + getJogador() + ", escolhe uma posição.");

            boolean posicaoTomada = true;
            while (posicaoTomada) {
                Scanner in = new Scanner(System.in);
                spot = in.nextInt();
                posicaoTomada = checkPosicao(spot);
                if (posicaoTomada == false) {
                    posicao[spot] = getJogador();
                }
            }

            tabelaJogo();

            proximoJogador();
        } while (checkVencedor() == blank);

    }

    public char checkVencedor() { // confere se existe uma linha/coluna/diagonal de X ou O e determina quem venceu ou se empataram
        char Vencedor = ' ';

        if (posicao[1] == 'X' && posicao[2] == 'X' && posicao[3] == 'X'
                || posicao[4] == 'X' && posicao[5] == 'X' && posicao[6] == 'X'
                || posicao[7] == 'X' && posicao[8] == 'X' && posicao[9] == 'X'
                || posicao[1] == 'X' && posicao[4] == 'X' && posicao[7] == 'X'
                || posicao[2] == 'X' && posicao[5] == 'X' && posicao[8] == 'X'
                || posicao[3] == 'X' && posicao[6] == 'X' && posicao[9] == 'X'
                || posicao[1] == 'X' && posicao[5] == 'X' && posicao[9] == 'X'
                || posicao[3] == 'X' && posicao[5] == 'X' && posicao[7] == 'X') {

            Vencedor = 'X';
        }

        if (posicao[1] == 'O' && posicao[2] == 'O' && posicao[3] == 'O'
                || posicao[4] == 'O' && posicao[5] == 'O' && posicao[6] == 'O'
                || posicao[7] == 'O' && posicao[8] == 'O' && posicao[9] == 'O'
                || posicao[1] == 'O' && posicao[4] == 'O' && posicao[7] == 'O'
                || posicao[2] == 'O' && posicao[5] == 'O' && posicao[8] == 'O'
                || posicao[3] == 'O' && posicao[6] == 'O' && posicao[9] == 'O'
                || posicao[1] == 'O' && posicao[5] == 'O' && posicao[9] == 'O'
                || posicao[3] == 'O' && posicao[5] == 'O' && posicao[7] == 'O') {

            Vencedor = 'O';
        }

        if (Vencedor == 'X') {
            System.out.println("O jogador 2 ganhou!!! |D");
            return Vencedor;
        }
        if (Vencedor == 'O') {
            System.out.println("O jogador 2 ganhou!!! |D");
            return Vencedor;
        }

        for (int i = 1; i < 10; i++) {
            if (posicao[i] == 'X' || posicao[i] == 'O') {
                if (i == 9) {
                    char Draw = 'D';
                    System.out.println("O jogo ficou empatado. Que treta :/");
                    return Draw;
                }
                continue;
            } else {
                break;
            }

        }

        return Vencedor;
    }

    public boolean checkPosicao(int spot) { // ve se a posição selecionada já foi tomada e dá erro

        if (posicao[spot] == 'X' || posicao[spot] == 'O') {
            System.out.println("Essa posição já foi tomada");
            return true;
        } else {
            return false;
        }
    }

    public void proximoJogador() { //determina o próximo jogador na ronda seguinte
        if (jogador == 'X') {
            jogador = 'O';
        } else {
            jogador = 'X';
        }

    }

    public char getJogador() {
        return jogador;
    }

}
