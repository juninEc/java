package thread_site;

import java.io.FileWriter;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class Principal {
	public StringBuffer buffer;
	public String nome;
	public boolean semaforo; 

	public Principal() { // PONTO DE PARTIDA DA THREAD PRINCIPAL 
		System.out.print("Digite a url: ");
		Scanner sc = new Scanner(System.in);
		nome = sc.next();

		try {

			buffer = new StringBuffer();
			NovaThread t2 = new NovaThread();
			t2.start();

			//SEMAFORO
			semaforo = false; 
			while(semaforo == false) {
				System.out.println("Carregando..."); 
			}
			// SALVA OS DADOS EM UM ARQUIVO
			FileWriter arquivo = new FileWriter("site.html");
			arquivo.write(buffer.toString());
			arquivo.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public class NovaThread extends Thread {

		public NovaThread() {

		}

		@Override
		public void run() {
			try {
				// CARREGA OS DADOS DE UM SITE
				URL url = new URL(nome);
				InputStream is = url.openStream();
				int ptr = 0;

				while ((ptr = is.read()) != -1) {
					buffer.append((char) ptr);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			semaforo = true; 
		}
	}

}
