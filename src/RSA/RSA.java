package RSA;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class RSA {

	String menssagem = "";
	String response = "";
	private BigInteger P = BigInteger.valueOf(17);
	private BigInteger Q = BigInteger.valueOf(29);
	private BigInteger E = BigInteger.valueOf(13);
	private BigInteger D;
	private BigInteger N;
	private BigInteger QE;
	private BigInteger aux;
	private BigInteger arm;
	private List<BigInteger> codigocifrado = new ArrayList<BigInteger>();
	protected List<BigInteger> codigodecifrado = new ArrayList<BigInteger>();
	protected List<Integer> finaly = new ArrayList<Integer>();
	private BigInteger item = BigInteger.valueOf(0);

	public void KeysGeneration() {

		// Compute n = p * q
		N = P.multiply(Q);
		// Compute a função totiente phi(n) = (p -1) (q -1)
		QE = (P.subtract(BigInteger.ONE)).multiply(Q.subtract(BigInteger.ONE));
		// Escolha um inteiro "e" , 1 < "e" < phi(n) , "e" e phi(n) sejam primos
		// entre si.
		if (E == BigInteger.ZERO) {
			E = new BigInteger("3");
			while (QE.gcd(E).intValue() > 1)
				E = E.add(new BigInteger("2"));
		}
		// d seja inverso multiplicativo de "e"
		D = E.modInverse(QE);
		// Chave Pública e Chave Privada
		System.out.println(" Chave Pública = ( " + N + ", " + E + " )");
		System.out.println(" Chave Privada = ( " + N + ", " + D + " )");
	}

	public void Cifragem(EncodeASCHIIMod EAM) {
		for (int i = 0; i < EAM.encrypt.size(); i++) {
			arm = new BigInteger(String.valueOf(EAM.encrypt.get(i)));
			aux = arm.pow(E.intValue());
			codigocifrado.add(aux.mod(N));
		}
	}

	public void DeCifragem(RSA Cript) {
		for (int i = 0; i < Cript.codigocifrado.size(); i++) {
			item = codigocifrado.get(i).pow(D.intValue());
			codigodecifrado.add(item.mod(N));
		}
	}

	public void printRSAEncrypt() {
		System.out.print(" Menssagem Encrypt ASCHII in RSA = ");
		for (Iterator<BigInteger> iterator = codigocifrado.iterator(); iterator.hasNext();) {
			BigInteger obj = (BigInteger) iterator.next();
			System.out.print(" " + obj);
		}
		System.out.println();
	}

	public void printRSADecrypt() {
		System.out.print(" Menssagem Decrypt RSA in ASCHII = ");
		for (Iterator<BigInteger> iterator = codigodecifrado.iterator(); iterator.hasNext();) {
			BigInteger obj = (BigInteger) iterator.next();
			System.out.print(" " + obj);
		}
		System.out.println();
	}


	public void printDecryptASCHII() {

		System.out.print(" Menssagem Decrypt ASCHII = ");
		for (Iterator<BigInteger> iterator = codigodecifrado.iterator(); iterator.hasNext();) {
			char c;
			BigInteger bigInteger = (BigInteger) iterator.next();
			c = (char)(bigInteger.intValue());
			response += c;
		}
		System.out.println(response);
				
		
		
	}
}
