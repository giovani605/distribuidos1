package distribuidos1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

// Essa classe processa as mensagens que vem do multicast
public class ControladorMulticast extends Thread {
	private MulticastSocket s;
	InetAddress group;
	String chave;

	// cria o controlador
	public ControladorMulticast(String c) {

		try {
			group = InetAddress.getByName("228.5.6.7");
			s = new MulticastSocket(6789);
			s.joinGroup(group);
			this.chave = c;
			anunciar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// quando entro na rede, me anuncio
	public void anunciar() {
		try {
			byte[] m = ("novo@" + chave).getBytes();
			DatagramPacket messageOut = new DatagramPacket(m, m.length, group, 6789);
			s.send(messageOut);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// roda infinitamente esperando mensagens
	@Override
	public void run() {

		boolean flag = true;
		// se anunciar?

		byte[] buffer = new byte[1000];
		while (flag) {
			// recebe as mensagens e depois ve oq faz
			DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
			try {
				s.receive(messageIn);
				processar(messageIn);
				buffer = new byte[1000];
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			s.leaveGroup(group);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void processar(DatagramPacket messageIn) {
		// TODO Auto-generated method stub
		// processa a mensagem
		String mensangem = new String(messageIn.getData());

		String[] vet = mensangem.split("@");
		String cmd = vet[0];
		if (cmd.equals("novo")) {
			// add na lista de conhecidos
			Node n = new Node();

			n.setEndereco(messageIn.getAddress());
			n.setPorta(messageIn.getPort());
			n.setChave(vet[1]);

			ListaGerais.getInstance().getListaNos().add(n);

		}
		if (cmd.equals("quero")) {
			System.out.println(messageIn.getAddress().toString() + " quer " + vet[1]);

		}
		// tipos de mensagem
		// anuncio de um novo node
		// se receber o anuncio de um novo node tenho q resposter que eu existo
		// se anunciar com a lista de arquivos?
		// caso utilizar essa abordagem preciso reanunciar na rede a canal novo arquivo

		// ou utilizar respostas on demand

	}

	public void procurarArquivo(String entrada) {
		// TODO
		this.mandarMsg("quero@" + entrada);
		// enviar uma mensagem no multicast para procurar o arquivo
		// quanto tempo esperar uma resposta?
		// fazer com que o sistema receba os arquivos q cada um tem na hr de anunciar no
		// multicas
		// -- mais simples
		// se a professora perguntar gasta dizer que eh para facilitar a resposta

		// gerar uma lista de peer que tem o arquivo
		// escolhe o melhor
		// abre conexao unicast
		// ou retorna que o arquivo nao foi encontrado
	}

	public void mandarMsg(String teste) {
		try {
			byte[] m = (teste).getBytes();
			DatagramPacket messageOut = new DatagramPacket(m, m.length, group, 6789);
			s.send(messageOut);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
