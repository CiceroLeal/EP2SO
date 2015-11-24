import java.util.concurrent.Semaphore;

public class RegiaoCritica {
	private int rc = 0;
	private Semaphore mutex = new Semaphore(1);
	private Semaphore bd = new Semaphore(1);
	
	public Semaphore Bd() {
		return bd;
	}
	public void setBd(Semaphore bd) {
		this.bd = bd;
	}
	public int getRc() {
		return rc;
	}
	public void setRc(int rc) {
		this.rc = rc;
	}
	public Semaphore Mutex() {
		return mutex;
	}
	public void setMutex(Semaphore mutex) {
		this.mutex = mutex;
	}
}
