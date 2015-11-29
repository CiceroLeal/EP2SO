import java.util.Random;

public class ExecutaThread {
	Random rng;
	Fio[] AllMyFios = new Fio[100];
	boolean rc = true;
	boolean mutex = true;
	
	public ExecutaThread(int leitor){
		rng= new Random();
		RegiaoCritica rc = new RegiaoCritica();
		int pos;
		int LouR;
		int leitura;
		
		//cria 100 threads de acordo com a quantidade de leitores
		//coloca as threads em posições aleatorias do arranjo
		for(int i=0; i<100; i++){
			if(leitor > 0){
				LouR = 0;
			}else{
				LouR = 1;
			}
			pos = rng.nextInt(100);
			leitura = rng.nextInt(36242);
			while(AllMyFios[pos] != null){
				pos = rng.nextInt(100);
			}
			Fio aux = new Fio(LouR,leitura, rc);
			AllMyFios[pos]=aux;
			leitor--;
		}
		//pega o tempo que a execução demora
		long inicio = System.currentTimeMillis();
			Executa();
		long fim = System.currentTimeMillis();
		
		//grava o tempo que demorou
		Main.tempoComLE += (fim-inicio);
	}
	public void Executa(){
		
		//executa as 100 threads
		for(int i = 0; i<100; i++){
			AllMyFios[i].start();
			if (AllMyFios[i].isAlive ())
		        try{
		            Thread.sleep (1); //Bota o fio pra dormir boa noite doce fio. ZzZ
		        }
		        catch (InterruptedException e){
		        	e.printStackTrace();
		        }
		}
	}
}
