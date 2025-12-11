package com.desafio.demo.service;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.desafio.demo.model.Aluno;
import com.desafio.demo.model.Curso;
import com.desafio.demo.model.Registro;


@Service
public class DesafioService {

    public Map<String, Object> processarRelatorio() {

        Map<String, Object> resultado = new HashMap<>();

        try {
            
            // Leitura do CSV

            List<Registro> registros = lerArquivo();


            // Agrupar registros por aluno

            Map<Integer, Aluno> a = new HashMap<>();

            for (Registro reg : registros) {

                a.putIfAbsent( reg.getMatricula(), new Aluno(reg.getMatricula()) );
                a.get( reg.getMatricula() ).addRegistro(reg);

            }

            List<Aluno> alunos = new ArrayList<>(a.values());


            // Calcular médias por curso

            Map<Integer, Curso> c = new HashMap<>();

            for ( Aluno aluno : a.values() ) {

                for ( int codCurso : aluno.cursos() ) {

                    double crParcial = aluno.getCrCurso(codCurso);
                    c.putIfAbsent( codCurso, new Curso(codCurso) );
                    c.get(codCurso).attMedia(crParcial);

                }

            }

            List<Curso> cursos = new ArrayList<>(c.values());


            // ORdenar listas

            Collections.sort(alunos);
            Collections.sort(cursos);
            

            // Retorna Mapa

            resultado.put("alunos", alunos);
            resultado.put("cursos", cursos);

        }

        catch(IOException | NumberFormatException e) {

            System.err.println("Erro ao processar linha do arquivo: " + e.getMessage());

        }

        return resultado;

    }

    
    private List<Registro> lerArquivo() throws IOException, NumberFormatException {

        List<Registro> registros = new ArrayList<>();

        try {

            InputStream is = getClass().getResourceAsStream("/notas.csv");

            if (is == null) {
                
                return registros;

            }

            BufferedReader br = new BufferedReader( new InputStreamReader(is, StandardCharsets.UTF_8) );
            String linha;

            while ( (linha = br.readLine()) != null ) {

                if (linha.toUpperCase().startsWith("MATRICULA")) {

                    continue;

                }

                String[] dados = linha.split(",");

                if (dados.length < 5) {

                    continue;

                }

                int matricula = Integer.parseInt( dados[0].trim() );
                int codCurso = Integer.parseInt( dados[2].trim() );
                int nota = Integer.parseInt( dados[3].trim() );
                int cargaHoraria = Integer.parseInt( dados[4].trim() );
                registros.add(new Registro(matricula, codCurso, nota, cargaHoraria));

            }

        }

        catch (IOException | NumberFormatException e) {

            System.err.println("Erro ao processar linha do arquivo: " + e.getMessage());

        }

        return registros;

    }

}