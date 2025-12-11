import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class CursoTest {

    @Test
    void calculoMediaDoisAlunos() {

        // Arrange (Cenário)
        Curso curso = new Curso(10);

        // Act (Ação)
        // Simula: Aluno 1 com CR parcial 80, Aluno 2 com CR parcial 60
        curso.attMedia(80.0);
        curso.attMedia(60.0);

        // Assert (Verificação)
        // Esperado: (80 + 60) / 2 = 70.0
        assertEquals(70.0, curso.getMedia(), 0.09);

    }

    @Test
    void deveRetornarZeroSeCursoNaoTiverAlunos() {

        // Cenário: Curso criado sem adicionar notas
        Curso curso = new Curso(20);

        // Ação
        double media = curso.getMedia();

        // Verificação: Agora esperamos 0.0 explicitamente
        assertEquals(0.0, media, 0.0001, "A média deve ser 0.0 se não houver alunos");

    }

}