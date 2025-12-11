import java.io.IOException;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        // Leitura do CSV

        String caminho = "notas.csv";
        LeitorCSV leitor = new LeitorCSV();
        List<Registro> registros = leitor.lerArquivo(caminho);


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


        // Exibir resultados (CR Aluno)

        Collections.sort(alunos);
        System.out.println("------- O CR dos alunos é: --------");

        for (Aluno aluno : alunos) {

            System.out.printf( "%-3d  -  %3d%n", aluno.getMatricula(), (int) aluno.getCr() );

        }

        System.out.println("-----------------------------------");


        // Exibir resultados (CR Cursos)

        Collections.sort(cursos);
        System.out.println("----- Média de CR dos cursos ------");

        for  (Curso curso : cursos) {

            System.out.printf( "%-3d  -  %3d%n", curso.getCodCurso(), (int) curso.getMedia() );

        }

        System.out.println("-----------------------------------");

    }

}