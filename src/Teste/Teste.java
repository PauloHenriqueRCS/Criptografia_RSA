package Teste;

import RSA.*;


public class Teste {

	

	public static void main(String[] args) {

		String DIRETORIO = "C:/Textos/texto.txt";
		MSG msg = new MSG(DIRETORIO);

		EncodeASCHIIMod eam = new EncodeASCHIIMod(msg.MENSSAGEM);
		eam.ASCHIImenssagem();

		RSA rsa = new RSA();
		rsa.KeysGeneration();
		rsa.Cifragem(eam);
		rsa.DeCifragem(rsa);
		
		
		// Imprime			
		msg.printMenssagem();
		eam.printEncryptASCHII();
		rsa.printRSAEncrypt();
		rsa.printRSADecrypt();
		rsa.printDecryptASCHII();
	}

}
