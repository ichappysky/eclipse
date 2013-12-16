package cp;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ExecutorBlockingQueuePlayCompletionService {
	private final ExecutorService executor;

	ExecutorBlockingQueuePlayCompletionService(ExecutorService executor) {
		this.executor = executor;
	}

	void renderPage(CharSequence source) {
		final List<ImageInfo> info = scanForImageInfo(source);
		CompletionService<ImageData> completionService = new ExecutorCompletionService<ImageData>(
				executor);
		for (final ImageInfo imageInfo : info)
			completionService.submit(new Callable<ImageData>() {
				public ImageData call() {
					return imageInfo.downloadImage();
				}
			});
		renderText(source);
		try {
			for (int t = 0; t < info.size(); t++) {
				Future<ImageData> f = completionService.take();
				ImageData imageData = f.get();
				renderImage(imageData);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} catch (ExecutionException e) {
			throw launderThrowable(e.getCause());
		}
	}

	private RuntimeException launderThrowable(Throwable cause) {
		// TODO Auto-generated method stub
		return null;
	}

	private void renderImage(ImageData imageData) {
		// TODO Auto-generated method stub

	}

	private void renderText(CharSequence source) {
		// TODO Auto-generated method stub

	}

	private List<ImageInfo> scanForImageInfo(CharSequence source) {
		// TODO Auto-generated method stub
		return null;
	}
}