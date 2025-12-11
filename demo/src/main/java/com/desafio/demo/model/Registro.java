package com.desafio.demo.model;


public class Registro {

    private final int matricula;
    private final int codCurso;
    private final int nota;
    private final int cargaHoraria;


    // Construtor

    public Registro(int matricula, int codCurso, int nota, int cargaHoraria) {

        this.matricula = matricula;
        this.codCurso = codCurso;
        this.nota = nota;
        this.cargaHoraria = cargaHoraria;

    }


    // Getters

    public int getMatricula() {

        return matricula;

    }

    public int getCodCurso() {

        return codCurso;

    }

    public int getNota() {

        return nota;

    }

    public int getCargaHoraria() {

        return cargaHoraria;

    }

}