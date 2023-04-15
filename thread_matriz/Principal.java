package thread_matriz;

import thread_site.Principal.NovaThread;

public class Principal {
    int[][] M;
    int[] somaLinhas;

    public Principal() { // PONTO DE PARTIDA DA THREAD PRINCIPAL 
        M = new int[5][5];
        somaLinhas = new int[5];
        for (int i = 0; i < M.length; i++) { // PREENCHUMENTO DA MATRIZ M
            for (int j = 0; j < M[i].length; j++) {
                M[i][j] = i + j;
            }
        }

        NovaThread[] t = new NovaThread[5];

        for (int i = 0; i < t.length; i++) {
            t[i] = new NovaThread(i);
            t[i].start();
        }

        try {
            for (int i = 0; i < M.length; i++) {
                t[i].join();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < somaLinhas.length; i++) { // IMPRESSÃO DO ARRAY 'somalinhas'
            System.out.println("Soma linha " + i + ": " + somaLinhas[i]);
        }
    }

    public class NovaThread extends Thread {

        public int i;
        NovaThread(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            for (int j = 0; j < M.length; j++) {
                somaLinhas[i] += M[i][j];
            }
        }

    }
}
