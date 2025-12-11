import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class AlunoTest {

    @Test
    void calculoCrCorreto() {

        // Cenário (Arrange)
        Aluno aluno = new Aluno(200);
        aluno.addRegistro(new Registro(200, 200, 80, 60)); // 4800 pontos
        aluno.addRegistro(new Registro(200, 200, 70, 40)); // 2800 pontos

        // Ação (Act)
        double cr = aluno.getCr();

        // Verificação (Assert)
        // (4800 + 2800) / 100 = 76.0
        assertEquals(76.0, cr, 0.09, "O CR deve ser a média ponderada");

    }

    @Test
    void crZeroSemDisciplinas() {

        Aluno aluno = new Aluno(200);
        assertEquals(0.0, aluno.getCr());

    }

}