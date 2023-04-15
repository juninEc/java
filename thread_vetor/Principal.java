package thread_vetor; 

public class Principal{

    public int [] valores; 
    public int soma = 0; 

    //construtor 
    public Principal(){
        
        valores = new int [10]; //inicializando o array 

        //preenchendo as posições com valores de 1 - 10
        for(int i=0; i<valores.length; i++){
            valores[i] = (i + 1); 
        }

        //processando os dados, soma dos valores do array
        for(int i=0; i<valores.length; i++){
            soma += valores[i]; 
        }

        Thread2 t2 = new Thread2(); 
        Thread3 t3 = new Thread3(); 
        t2.start();
        t3.start();

        try {
			t2.join();
			t3.join();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("O somatorio dos valores do = " + soma);
    }

	public class Thread2 extends Thread{
		@Override
		public void run() {
			
			for(int i=0; i<valores.length; i++) {
				if(i%2 == 0)
				soma += valores[i]; 
			}
		}
	}
	
	public class Thread3 extends Thread{
		@Override
		public void run() {
			
			for(int i=0; i<valores.length; i++) {
				if(i%2 != 0)
				soma += valores[i]; 
			}
		}
	}
	
}