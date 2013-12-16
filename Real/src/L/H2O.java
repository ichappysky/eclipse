package L;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ʵ����������: H() and O(), �����������ᱻ���̵߳��á���һ���̵߳���H��Oʱ �� �����ǰ�Ѿ������������߳�call H��һ���߳�call
 * O����ô������call H��һ�� call O���̷߳��أ�����һ��ˮ���ӣ��������Ķ�block��
 * 
 * @author yongz
 * 
 */
public class H2O {
	AtomicInteger hCounter = new AtomicInteger(0);
	AtomicInteger oCounter = new AtomicInteger(0);
	final ReentrantLock lock;
	final Condition canHaveMoreH;
	final Condition canHaveMoreO;

	public H2O() {
		lock = new ReentrantLock();
		canHaveMoreH = lock.newCondition();
		canHaveMoreO = lock.newCondition();

	}

	private void generateOneH2OIfPossible() {

		if (hCounter.get() >= 2 && oCounter.get() >= 1) {
			System.out
					.println(System.currentTimeMillis() + ": here is one H2O");
			hCounter.decrementAndGet();
			hCounter.decrementAndGet();
			oCounter.decrementAndGet();
			canHaveMoreH.signal();
			canHaveMoreH.signal();
			canHaveMoreO.signal();
		}
	}

	class H extends Thread {
		public H(String name) {
			super(name);
		}

		public void run() {
			try {
				lock.lockInterruptibly();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if (hCounter.get() >= 2) {
					canHaveMoreH.await();
				}
				hCounter.incrementAndGet();
				generateOneH2OIfPossible();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}

	class O extends Thread {
		public O(String name) {
			super(name);
		}

		public void run() {
			try {
				lock.lockInterruptibly();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if (oCounter.get() >= 1) {
					canHaveMoreO.await();
				}
				oCounter.incrementAndGet();
				generateOneH2OIfPossible();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) {
		H2O master = new H2O();
		int n = 1800;
		for (int i = 0; i < n; i++) {
			O o = master.new O("O-" + i);
			o.start();
		}

		for (int i = 0; i < 2 * n; i++) {
			H h = master.new H("H-" + i);
			h.start();
		}

	}
}
