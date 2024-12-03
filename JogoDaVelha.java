import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        char[][] tabuleiro = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
        char jogadorAtual = 'X';
        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirTabuleiro(tabuleiro);
            System.out.println("Jogador " + jogadorAtual + ", insira linha e coluna:");
            int linha = scanner.nextInt(), coluna = scanner.nextInt();

            if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2 || tabuleiro[linha][coluna] != ' ') {
                System.out.println("Jogada inválida! Tente novamente.");
                continue;
            }

            tabuleiro[linha][coluna] = jogadorAtual;

            if (venceu(tabuleiro, jogadorAtual)) {
                exibirTabuleiro(tabuleiro);
                System.out.println("Jogador " + jogadorAtual + " venceu!");
                break;
            }

            jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
        }
    }

    static void exibirTabuleiro(char[][] tab) {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tab[i][j] + (j < 2 ? "|" : ""));
            }
            System.out.println(i < 2 ? "\n  -----" : "");
        }
    }

    static boolean venceu(char[][] tab, char jogador) {
        for (int i = 0; i < 3; i++)
            if ((tab[i][0] == jogador && tab[i][1] == jogador && tab[i][2] == jogador) ||
                (tab[0][i] == jogador && tab[1][i] == jogador && tab[2][i] == jogador))
                return true;
        return (tab[0][0] == jogador && tab[1][1] == jogador && tab[2][2] == jogador) ||
               (tab[0][2] == jogador && tab[1][1] == jogador && tab[2][0] == jogador);
    }
}
