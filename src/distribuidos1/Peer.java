package distribuidos1;

import java.util.Scanner;

public class Peer {
	
	public Peer() {
		// iniciar o programa 
		
		// abre uma thread que vai receber o multicast
		
		
	}
	private void rodar() {
		// loop infinito ate que o usuario decida sair da rede
		String entrada = "";
		Scanner scan = new Scanner(System.in);
		while(!entrada.equals("sair")) {
			System.out.println("Entre o comando: ");
			scan.nextLine();
		}
		System.out.println("Terminado!!!");
		
	}

	public static void main(String[] args) {
		Peer peer = new Peer();
		peer.rodar();
	}

}
