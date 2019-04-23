package BarrierS;
import java.util.concurrent.Semaphore;

public class Barrier {
	
	private final Semaphore barrierSem;
	private static int count = 0;
	private static int n;
	
	protected Barrier(int n) {
		barrierSem = new Semaphore(n);
		barrierSem.drainPermits();
		Barrier.n = n;
	}
	
	public void b_wait() throws InterruptedException{
		// this is the only additional method you will need to complete
		count++;
		if(count== n){
			barrierSem.release();
		}
		barrierSem.acquire();
		barrierSem.release();
	}

}
