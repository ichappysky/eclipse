package cp;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class SemaphorePlayBoundedHashSet<T> {
	private final Set<T> set;
	private final Semaphore sem;

	public SemaphorePlayBoundedHashSet(int size) {
		sem = new Semaphore(size);
		set = Collections.synchronizedSet(new HashSet<T>());
	}

	public boolean add(T o) throws InterruptedException {
		sem.acquire();
		boolean done = false;
		try {
			done = set.add(o);
			return done;
		} finally{
			if (!done) {
				sem.release();
				return false;
			}
		}
	}
	
	public boolean remove (T o) {
		boolean done = false;
		try {
			done=  set.remove(o);
			return done;
		} finally {
			if (done) {
				sem.release();
			}
		}
	}
}
