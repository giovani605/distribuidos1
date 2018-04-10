package distribuidos1;

import java.net.InetAddress;

// essa classe representa um no na rede
public class Node {
	// guardar ip
	 // lista de arquivos que ele possue
	InetAddress endereco;
	int porta;
	public InetAddress getEndereco() {
		return endereco;
	}
	public void setEndereco(InetAddress endereco) {
		this.endereco = endereco;
	}
	public int getPorta() {
		return porta;
	}
	public void setPorta(int porta) {
		this.porta = porta;
	}
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	String chave;
}
