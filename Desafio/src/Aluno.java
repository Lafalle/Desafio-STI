import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Aluno implements Comparable<Aluno> {

    private final int matricula;
    private final List<Registro> registros = new ArrayList<>();


    // Construtor

    public Aluno(int matricula) {

        this.matricula = matricula;

    }


    // Métodos

    public void addRegistro(Registro registro) {

        this.registros.add(registro);

    }

    public Set<Integer> cursos() {

        Set<Integer> cursos = new HashSet<>();

        for (Registro reg : registros) {

            cursos.add( reg.getCodCurso() );

        }

        return cursos;

    }

    public double getCr() {

        double somaPonderada = 0;
        int totalCarga = 0;

        for (Registro reg : registros) {

            somaPonderada += reg.getNota() * reg.getCargaHoraria();
            totalCarga += reg.getCargaHoraria();

        }

        return (totalCarga == 0) ? 0.0 : somaPonderada / totalCarga;

    }

    public double getCrCurso(int codCurso) {

        double somaPonderada = 0;
        int totalCarga = 0;

        for (Registro reg : registros) {

            if (reg.getCodCurso() == codCurso) {

                somaPonderada += reg.getNota() * reg.getCargaHoraria();
                totalCarga += reg.getCargaHoraria();

            }

        }

        return (totalCarga == 0) ? 0.0 : somaPonderada / totalCarga;

    }

    @Override
    public int compareTo(Aluno a) {

        return Integer.compare(this.getMatricula(), a.getMatricula());

    }


    // Getters

    public int getMatricula() {

        return matricula;

    }

}