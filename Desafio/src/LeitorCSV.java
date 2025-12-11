import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LeitorCSV {

    public List<Registro> lerArquivo(String caminho) throws IOException, NumberFormatException {

        List<Registro> registros = new ArrayList<>();

        try ( BufferedReader br = new BufferedReader( new FileReader(caminho) ) ) {

            String linha;

            while ( (linha = br.readLine()) != null ) {

                if ( linha.toUpperCase().startsWith("MATRICULA") ) {

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