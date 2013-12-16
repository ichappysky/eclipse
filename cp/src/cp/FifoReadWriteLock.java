package cp;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FifoReadWriteLock {
	/**
	 * The readReleases and readAcquires variables keep track of the number
	 * threads that have acquired and released the read lock. When these are
	 * equal, no thread has the read lock
	 */

	int readAcquires = 0, readReleases = 0;
	/**
	 * The writer variable indicates that a thread is trying to acquire the
	 * write lock or it already has it.
	 */
	boolean writer = false;
	ReentrantLock lock;
	Condition condition = lock.newCondition(); // This is the condition
												// variable.

	/**
	 * it first checks to see if a writer is holding the lock or is trying to
	 * acquire it. If so, it waits until the writer is done and then claims the
	 * lock for the readers by incrementing the readAcquires variable
	 * 
	 * @throws InterruptedException
	 */
	void readLock() throws InterruptedException {
		lock.lock();
		try {
			while (writer)
				condition.await();
			readAcquires++;
		} finally {
			lock.unlock();
		}
	}

	/**
	 * When unlocking, a thread increases the readReleases variable and if
	 * there's no more readers, it notifies any writers that may be waiting.
	 */
	void readUnlock() {
		lock.lock();
		try {
			readReleases++;
			if (readAcquires == readReleases)
				condition.signalAll();
		} finally {
			lock.unlock();
		}
	}

	/**
	 * To lock, a thread must first check whether any other writer is active. If
	 * they are, it has to wait until the other writer is done. It then
	 * indicates that it wants the lock by setting writer to true (note that it
	 * doesn't hold it yet). It then waits until there's no more readers before
	 * continuing.
	 * 
	 * @throws InterruptedException
	 */
	void writeLock() throws InterruptedException {
		lock.lock();
		try {
			while (writer)
				condition.await();

			writer = true;

			while (readAcquires != readReleases)
				condition.await();
		} finally {
			lock.unlock();
		}
	}

	/**
	 * To unlock, it simply sets the variable writer to false and notifies any
	 * other threads that might be waiting.
	 */
	void writeUnlock() {
		writer = false;
		condition.signalAll();
	}
}
