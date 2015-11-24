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
		for(int i = 0; i < 100; i++){
			p = rng.nextInt(100);
			if(funcaoLeitor == true){
				try{
					rc.Bd().acquire();
					Main.bd[p]= "MODIFICADO";
					rc.Bd().release();
				}catch(Exception e){
					e.printStackTrace();
				}
			}else {
				try{
					rc.Mutex().acquire();
						rc.setRc(rc.getRc()+1);
						if(rc.getRc() == 1) rc.Bd().acquire();
					rc.Mutex().release();
					
					palavraLida = Main.bd[p];
					
					rc.Mutex().acquire();
						rc.setRc(rc.getRc() - 1);
						if(rc.getRc() == 0) rc.Bd().release();;
					rc.Mutex().release();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
}
