import java.util.Random;

public class Fio2 extends Thread {
	
	boolean funcaoLeitor = false;//Se for true, ele é escritor.
	String palavraLida;
	RegiaoCritica2 rc;
	
	public Fio2(int LouR, int pos, RegiaoCritica2 rc){
		if(LouR == 1)funcaoLeitor = true;
		this.rc = rc;
	}
	
	public void run(){
		Random rng = new Random();
		int p;
		for(int i = 0; i < 100; i++){
			p = rng.nextInt(100);
			if(funcaoLeitor == true){
				try{
					rc.Mutex().acquire();
						Main.bd[p]= "MODIFICADO";
					rc.Mutex().release();
				}catch(Exception e){
					e.printStackTrace();
				}
			}else{
				try{
					rc.Mutex().acquire();
					
					palavraLida = Main.bd[p];
					
					rc.Mutex().release();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
}
