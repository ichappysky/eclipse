package cp;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchPlay {
	public static void main(String[] x) {
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(5);
		
		int count = Runtime.getRuntime().availableProcessors();
		System.out.println("processor # = " + count);
		
		for (int i = 0; i < 5; i++) {
			Thread t = new Thread("Thread " + i) {
				@Override
				public void run() {
					try {
						System.out.println("thread " + this.getName()
								+ " is waiting");
						// waiting for start latch to count down to 0
						startGate.await();

						long sleepTime = (long) (Math.random() * 5000);
						sleep(sleepTime);
						System.out.println("thread " + this.getName()
								+ " slept " + sleepTime);
						endGate.countDown();
					} catch (InterruptedException e) {
					}
				}
			};
			t.start();
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
		}

		System.out.println("let's go");

		startGate.countDown();

		try {
			endGate.await();
		} catch (InterruptedException e) {
		}
		System.out.println("Done");
	}
}
