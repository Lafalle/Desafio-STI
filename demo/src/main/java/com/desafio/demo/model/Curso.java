package com.desafio.demo.model;


public class Curso implements Comparable<Curso> {

    private final int codCurso;
    private double crs;
    private int qtAlunos;


    // Construtor

    public Curso(int codCurso) {

        this.codCurso = codCurso;
        this.crs = 0.0;
        this.qtAlunos = 0;

    }


    // Métodos

    public void attMedia(double crs) {

        this.crs += crs;
        this.qtAlunos++;

    }

    public double getMedia() {

        return (qtAlunos == 0) ? 0.0 : crs / qtAlunos;

    }

    @Override
    public int compareTo(Curso c) {

        return Integer.compare(this.getCodCurso(), c.getCodCurso());

    }


    // Getters

    public int getCodCurso() {

        return codCurso;

    }

}