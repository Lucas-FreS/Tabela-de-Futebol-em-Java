package tabela;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.*;
import java.io.*;

public class Time {
    String nome;
    int pontos;
    int golsMarcados;
    int golsSofridos;

    public Time(String nome) {
        this.nome = nome;
        this.pontos = 0;
        this.golsMarcados = 0;
        this.golsSofridos = 0;
    }

    public int saldoDeGols() {
        return golsMarcados - golsSofridos;
    }
}

class CampeonatoTimes {
    private List<Time> times;

    public CampeonatoTimes() {
        times = new ArrayList<>();
    }

    public void adicionarTime(String nome) {
        int contador = 1;
        String nomeOriginal = nome;
        while (buscarTime(nome) != null) {
            nome = nomeOriginal + " " + contador;
            contador++;
        }
        times.add(new Time(nome));
    }

    private Time buscarTime(String nome) {
        for (Time time : times) {
            if (time.nome.equalsIgnoreCase(nome)) {
                return time;
            }
        }
        return null;
    }

    public void registrarPartida(String nomeTime1, int golsTime1, String nomeTime2, int golsTime2) {
        Time time1 = buscarTime(nomeTime1);
        Time time2 = buscarTime(nomeTime2);

        if (time1 == null || time2 == null) {
            System.out.println("Um dos times não foi encontrado.");
            return;
        }

        time1.golsMarcados += golsTime1;
        time1.golsSofridos += golsTime2;
        time2.golsMarcados += golsTime2;
        time2.golsSofridos += golsTime1;

        if (golsTime1 > golsTime2) {
            time1.pontos += 3;
        } else if (golsTime2 > golsTime1) {
            time2.pontos += 3;
        } else {
            time1.pontos += 1;
            time2.pontos += 1;
        }
    }

    public void mostrarClassificacao() {
        times.sort((a, b) -> {
            if (b.pontos != a.pontos) {
                return b.pontos - a.pontos;
            } else {
                return b.saldoDeGols() - a.saldoDeGols();
            }
        });

        System.out.printf("%-20s %-10s %-15s\n", "Time", "Pontos", "Saldo de Gols");
        for (Time time : times) {
            System.out.printf("%-20s %-10d %-15d\n", time.nome, time.pontos, time.saldoDeGols());
        }
    }

    public void salvarClassificacao(String arquivoNome) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivoNome))) {
            for (Time time : times) {
                writer.println(time.nome + "," + time.pontos + "," + time.saldoDeGols());
            }
            System.out.println("Classificação salva no arquivo: " + arquivoNome);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }
}

