import java.util.Random;

public class ExecutaThread {
	Random rng;
	Fio[] AllMyFios = new Fio[100];
	boolean rc = true;
	boolean mutex = true;
	
	public ExecutaThread(){
		rng= new Random();
		RegiaoCritica rc = new RegiaoCritica();
		int pos;
		int LouR;
		int leitura;
		for(int i=0; i<100; i++){
			LouR = rng.nextInt(2);
			pos = rng.nextInt(100);
			leitura = rng.nextInt(36242);
			while(AllMyFios[pos] != null){
				pos = rng.nextInt(100);
			}
			Fio aux = new Fio(LouR,leitura, rc);
			AllMyFios[pos]=aux;
			
		}
			Executa();
	}
	public void Executa(){
		for(int i = 0; i<100; i++){
			AllMyFios[i].start();
			if (AllMyFios[i].isAlive ())
		        try{
		            Thread.sleep (1); //Bota o fio pra dormir boa noite doce fio. s2
		        }
		        catch (InterruptedException e){
		        	e.printStackTrace();
		        }
		}
	}
}
