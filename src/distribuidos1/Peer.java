package distribuidos1;

import java.util.Scanner;

// principal
public class Peer {
	// controla o socket multicast
	MulticastRecive multicast;
	
	
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
			entrada = scan.nextLine();
			executarComando(entrada);
		}
		System.out.println("Terminado!!!");
		
	}
	private void executarComando(String entrada) {
		multicast.procurarArquivo(entrada);
		
		
	}
	public static void main(String[] args) {
		Peer peer = new Peer();
		peer.rodar();
	}

}
