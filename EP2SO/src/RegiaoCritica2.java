import java.util.concurrent.Semaphore;

public class RegiaoCritica2 {
	private Semaphore mutex = new Semaphore(1);
	
	public Semaphore Mutex() {
		return mutex;
	}
	public void setMutex(Semaphore mutex) {
		this.mutex = mutex;
	}
}
