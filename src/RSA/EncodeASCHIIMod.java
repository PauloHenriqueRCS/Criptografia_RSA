package RSA;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EncodeASCHIIMod {

	protected List<Integer> procaschii = new ArrayList<Integer>();
	protected List<Integer> encrypt = new ArrayList<Integer>();
	protected List<String> msg = new ArrayList<String>();
	protected String input;
	protected String output;

	public EncodeASCHIIMod(String menssagem) {
		this.input = menssagem;
	}

	public String getMenssagem() {
		return input;
	}

	public void setMenssagem(String m) {
		this.input = m;
	}

	public void ASCHIImenssagem() {
		EncryptASCHII();
	}

	public void processesInputASCHII() {

		for (int i = 0; i < input.length(); i++) {
			Integer aux = (int) input.charAt(i);
			this.procaschii.add(aux);
		}

	}

	public void EncryptASCHII() {
		processesInputASCHII();
		for (int i = 0; i < procaschii.size(); i++) {
			this.encrypt.add(procaschii.get(i));
		}
	}



	public void printEncryptASCHII() {
		System.out.print(" Menssagem Encrypt ASCHII = ");

		for (Iterator<Integer> iterator = encrypt.iterator(); iterator.hasNext();) {
			Integer obj = (Integer) iterator.next();
			System.out.print(" " + obj);
		}

		System.out.println();
	}

	

	public String toString() {
		return input;
	}
}
