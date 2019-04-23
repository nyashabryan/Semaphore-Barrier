package BarrierS;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Barrier {
	
	private final Semaphore barrierSem;
	private static AtomicInteger count;
	private static int n;
	
	protected Barrier(int n) {
		barrierSem = new Semaphore(n);
		barrierSem.drainPermits();
		Barrier.n = n;
		count = new AtomicInteger(0);
	}
	
	public void b_wait() throws InterruptedException{
		// this is the only additional method you will need to complete
		count.incrementAndGet();
		if(count.get() == n){
			barrierSem.release();
		}
		barrierSem.acquire();
		barrierSem.release();
	}

}
