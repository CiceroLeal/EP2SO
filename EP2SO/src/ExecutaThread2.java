import java.util.Random;

public class ExecutaThread2 {
	Random rng;
	Fio2[] AllMyFios = new Fio2[100];
	boolean rc = true;
	boolean mutex = true;
	
	public ExecutaThread2(TextWriter esc, int leitor){
		rng= new Random();
		RegiaoCritica2 rc = new RegiaoCritica2();
		int pos;
		int LouR;
		int leitura;
		int index = leitor;
		for(int i=0; i<100; i++){
			if(leitor >= 0){
				LouR = 0;
			}else{
				LouR = 1;
			}
			pos = rng.nextInt(100);
			leitura = rng.nextInt(36242);
			while(AllMyFios[pos] != null){
				pos = rng.nextInt(100);
			}
			Fio2 aux = new Fio2(LouR,leitura, rc);
			AllMyFios[pos]=aux;
			
			leitor--;
			
		}
		long inicio = System.currentTimeMillis();
			Executa();
		long fim = System.currentTimeMillis();
		esc.escrever_arq_fim(fim-inicio+"\n", "src\\logSemLE"+index+".txt");
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
