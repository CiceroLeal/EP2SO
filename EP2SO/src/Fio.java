import java.util.Random;

public class Fio extends Thread {
	
	boolean funcaoLeitor = false;//Se for true, ele é escritor.
	String palavraLida;
	RegiaoCritica rc;
	
	public Fio(int LouR, int pos, RegiaoCritica rc){
		if(LouR == 1)funcaoLeitor = true;
		this.rc = rc;
	}
	
	public void run(){
		Random rng = new Random();
		int p;
		
		//Executa 100 operações de leitura ou escrita na base de dados
		for(int i = 0; i < 100; i++){
			p = rng.nextInt(36242);
			//verifica se é leitor
			if(funcaoLeitor){
				//se for leitor bloqueia o acesso da base de dados e modifica uma palavra depois libera
				try{
					rc.Bd().acquire();
					Main.bd[p]= "MODIFICADO";
					rc.Bd().release();
				}catch(Exception e){
					e.printStackTrace();
				}
			}else {
				try{
					//se for leitor, bloqueia o acesso da lista de leitores e grava que tem mais um leitor
					//se for o primeiro leitor bloqueia o acesso para que escritores não entrem
					rc.Mutex().acquire();
						rc.setRc(rc.getRc()+1);
						if(rc.getRc() == 1) rc.Bd().acquire();
					rc.Mutex().release();
					
					//le uma palavra do base de dados
					palavraLida = Main.bd[p];
					
					//bloqueia o acesso na lista de leitores e diminui a quantidade de leitores
					//se for o ultimo leitor, libera o acesso para que os escritores entrem
					rc.Mutex().acquire();
						rc.setRc(rc.getRc() - 1);
						if(rc.getRc() == 0) rc.Bd().release();
					rc.Mutex().release();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
}
