package distribuidos1;

import java.util.ArrayList;

public class ListaGerais {
	private ArrayList<Node> listaNos = new ArrayList<>();
	private static ListaGerais instance;

	public static ListaGerais getInstance() {
		if (instance != null)
			return instance;
		instance = new ListaGerais();
		return instance;
	}

	private ListaGerais() {
		super();
	}

	public ArrayList<Node> getListaNos() {
		return listaNos;
	}

	public void setListaNos(ArrayList<Node> listaNos) {
		this.listaNos = listaNos;
	}

}
