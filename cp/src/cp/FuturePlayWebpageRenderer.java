package cp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FuturePlayWebpageRenderer {
	private final ExecutorService executor = Executors.newFixedThreadPool(30);;

	void renderPage(CharSequence source) {
		final List<ImageInfo> imageInfos = scanForImageInfo(source);
		Callable<List<ImageData>> task = new Callable<List<ImageData>>() {
			public List<ImageData> call() {
				List<ImageData> result = new ArrayList<ImageData>();
				for (ImageInfo imageInfo : imageInfos)
					result.add(imageInfo.downloadImage());
				return result;
			}
		};
		Future<List<ImageData>> future = executor.submit(task);
		renderText(source);
		try {
			List<ImageData> imageData = future.get();
			for (ImageData data : imageData)
				renderImage(data);
		} catch (InterruptedException e) {
			// Re-assert the thread's interrupted status
			Thread.currentThread().interrupt();
			// We don't need the result, so cancel the task too
			future.cancel(true);
		} catch (ExecutionException e) {
			throw launderThrowable(e.getCause());
		}
	}

	private void renderImage(ImageData data) {
		// TODO Auto-generated method stub

	}

	private RuntimeException launderThrowable(Throwable cause) {
		// TODO Auto-generated method stub
		return null;
	}

	private void renderText(CharSequence source) {
		// TODO Auto-generated method stub

	}

	private List<ImageInfo> scanForImageInfo(CharSequence source) {
		// TODO Auto-generated method stub
		return null;
	}
}

class ImageInfo {

	public ImageData downloadImage() {
		// TODO Auto-generated method stub
		return null;
	}

}

class ImageData {
}