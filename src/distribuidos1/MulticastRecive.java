package distribuidos1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

// Essa classe processa as mensagens que vem do multicast
public class MulticastRecive extends Thread {
	private MulticastSocket s;
	InetAddress group;
	public MulticastRecive() {
		
		try {
			group = InetAddress.getByName("228.5.6.7");
			s = new MulticastSocket(6789);
			s.joinGroup(group);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		boolean flag = true;
		byte[] buffer = new byte[1000];
		while (flag) {
			// recebe as mensagens e depois ve oq faz
			DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
			try {
				s.receive(messageIn);
				processar(messageIn);
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
	}

}
