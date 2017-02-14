package RSA;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MSG {

	protected String DIRETORIO;
	public String MENSSAGEM ="";


	public MSG(String diretorio) {
		this.DIRETORIO = diretorio;
		processMENSSAGEM(DIRETORIO);
	}

	private String processMENSSAGEM(String DIRETORIO) {
		this.MENSSAGEM = FileSTR(DIRETORIO, MENSSAGEM);
		return MENSSAGEM;
	}

	public String getDIRETORIO() {
		return DIRETORIO;
	}

	public void setDIRETORIO(String dIRETORIO) {
		DIRETORIO = dIRETORIO;
	}

	public String getMENSSAGEM() {
		return MENSSAGEM;
	}

	public void setMENSSAGEM(String mENSSAGEM) {
		MENSSAGEM = mENSSAGEM;
	}

	public void printMenssagem(){
		System.out.println(" Menssagem Original = " + MENSSAGEM);
	}
	private static String FileSTR(String diretorio, String Dados) {
		List<String> menssagem = new ArrayList<String>();
		try {
			BufferedReader BuffFileopen = new BufferedReader(new FileReader(diretorio));
			while (BuffFileopen.ready()) {
				String linha = BuffFileopen.readLine();
				while (linha != null) {
					menssagem.add(linha);
					linha = BuffFileopen.readLine();
				}
			}
			BuffFileopen.close();
		} catch (FileNotFoundException erro) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", erro.getMessage());
		} catch (IOException erro) {
			System.err.printf("Erro: %s.\n", erro.getMessage());
		}
		for (int i = 0; i < menssagem.size(); i++) {
			Dados += (String) menssagem.get(i);
		}
		return Dados;
	}

}
