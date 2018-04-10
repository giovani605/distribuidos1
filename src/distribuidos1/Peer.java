package distribuidos1;

import java.util.Scanner;

// principal
public class Peer {
	// controla o socket multicast
	ControladorMulticast multicast;

	public Peer(String chave) {
		// inicia os sockets e etc.
		// iniciar o programa
		multicast = new ControladorMulticast(chave);
		// abre uma thread que vai receber o multicast
		multicast.start();
		

	}

	private void rodar() {
		// loop infinito ate que o usuario decida sair da rede
		String entrada = "";
		Scanner scan = new Scanner(System.in);
		while (!entrada.equals("sair")) {
			System.out.println("Entre o comando: ");
			entrada = scan.nextLine();
			executarComando(entrada);
		}
		System.out.println("Terminado!!!");
		scan.close();
		fechar();

	}

	private void fechar() {
		// fechar os casts e as portas
	}

	private void executarComando(String entrada) {
		multicast.procurarArquivo(entrada);

	}

	public static void main(String[] args) {
		System.out.println("Digite a chave");
		String chave = new Scanner(System.in).nextLine();
		Peer peer = new Peer(chave);
		peer.rodar();
	}

}
