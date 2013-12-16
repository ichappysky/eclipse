package cp;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExcecutorPlayWebServer {
	private static final Executor exec = Executors.newFixedThreadPool(1);

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 5; i++) {
			Runnable task = new Runnable() {
				public void run() {
					System.out.println("running...");
				}
			};

			exec.execute(task);
		}
	}
}
