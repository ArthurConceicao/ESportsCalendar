package br.gov.to.sefaz.apps.esportscalendar;

/**
 * Created by 04998369105 on 23/11/2017.
 */

public class Time {
    private String nome;
    private String cdgTime;
    private int pontos;

    public Time() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCdgTime() {
        return cdgTime;
    }

    public void setCdgTime(String codigo) {
        this.cdgTime = codigo;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
