/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tabela;

import java.util.Scanner;

public class Tabela {

    public static void main(String[] args) {
        CampeonatoTimes campeonato = new CampeonatoTimes();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantos times terá no campeonato?");
        int quantidadeDeTimes = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < quantidadeDeTimes; i++) {
            System.out.print("Digite o nome do time " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            campeonato.adicionarTime(nome);
        }

        System.out.println("Quantas partidas deseja registrar?");
        int quantidadeDePartidas = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < quantidadeDePartidas; i++) {
            System.out.println("\nPartida " + (i + 1) + ":");

            System.out.print("Nome do time 1: ");
            String time1 = scanner.nextLine();

            System.out.print("Gols do time 1: ");
            int gols1 = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Nome do time 2: ");
            String time2 = scanner.nextLine();

            System.out.print("Gols do time 2: ");
            int gols2 = scanner.nextInt();
            scanner.nextLine(); 

            campeonato.registrarPartida(time1, gols1, time2, gols2);
        }

        System.out.println("\nClassificação Final:");
        campeonato.mostrarClassificacao();

        System.out.print("\nDeseja salvar a classificação em arquivo? (s/n): ");
        String resposta = scanner.nextLine();

        if (resposta.equalsIgnoreCase("s")) {
            System.out.print("Digite o nome do arquivo: ");
            String nomeArquivo = scanner.nextLine();
            campeonato.salvarClassificacao(nomeArquivo);
        }

        scanner.close();
    }
}

    

