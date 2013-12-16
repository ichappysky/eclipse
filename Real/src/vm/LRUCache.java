package vm;

import java.sql.Blob;
import java.util.HashMap;
import java.util.Map;

import javax.sql.rowset.serial.SerialBlob;

/**
 * Implement a LRU Cache
 * 
 * [A] Minimum capabilities:
 * 
 * Implement a single-threaded in-memory LRU cache, with the following
 * capabilities:
 * 
 * 1) A way to put (key, value) tuples to a cache The key is a string The value
 * is a binary blob of variable size. Note that a zero-length value is valid and
 * is not the same as "value does not exist" Note that this function would
 * replace the value if the (key, value) pair already exists in the cache 2) A
 * way to get values from a cache using a key 3) A way to evict the value for a
 * given key from the cache 4) A way to create a cache initially with a size
 * parameter (the maximum amount of RAM the cache may consume) and a key compare
 * function for the cache to use 5) A way to clear a cache, but keep it ready
 * for a new put's, get's, evict's etc 6) A way to destroy a cache and free all
 * its memory usage
 * 
 * All code should have simple unit tests.
 * 
 * You can assume that basic collection types (hashes, lists, queues, stacks)
 * are available to you. If you use them, write a comment describing their
 * behavior, or make it clear which one you are using (e.g
 * java.util.LinkedList).
 * 
 * 
 * [B] Extra credit / Feature Creep
 * 
 * If you have time, here are some optional "extra credit" features to implement
 * - upgrade your answer, impress us further and have fun! We consider getting
 * 1-6 above correct to be more important than lots of "extra credit" answers,
 * so only take these on if you are confident that you have correctly
 * implemented the minimum capabilities described above. The list of suggestions
 * is in no particular order. Use the 'shortname' tags here in your comments
 * (e.g. // ANTICACHE) so we are clear which of these (if any) you have
 * implemented.
 * 
 * - ANTICACHE. An anti-caching capability, so that 'not found' values can also
 * be cached - CACHESTAT. A way to obtain useful statistics to determine the
 * effectiveness and efficiency of a cache - CACHESTATS. A way to obtain useful
 * statistics to determine the effectiveness and efficiency of all caches this
 * code is managing in this thread - FUNCTEST. A comprehensive functional test
 * for the cache. This includes a thorough test set for the cache for invalid
 * operations/params to check error handling - PERFTEST. A simple performance
 * test for the cache. Describe briefly in comments any profiling tools you
 * would use and how - TRUERAM. Keep the cache memory usage within the
 * configured RAM usage limits including any overhead of a dynamic memory
 * allocation system. - URLHELL. Make this robust and secure if the semantics of
 * the key string are that it is a RFC 1738 URL
 * (http://www.ietf.org/rfc/rfc1738.txt) - GCOMG. Anything you may think to
 * improve this if you are using a GC'ed language and memory, where there may be
 * overall system memory pressure - STACKER. Implement single-instancing of
 * values - useful in the case where many keys can have the same value -
 * TIMEOUT. Timed expiry of values - THREADY. Make this thread-safe in a simple,
 * robust but not performance optimized manner - VERYTHREADY. Make this
 * thread-safe and very heavily optimized for concurrency on many CPUs
 * (lock-free, avoiding lock convoys etc)
 * 
 * @author yongz
 * 
 */
public class LRUCache {
	// a map from key to the underlying node;
	private Map<String, Node> cacheMap = null;
	// max size of cache
	private int cacheSize = 0;
	// head of doubly linked list
	private Node head = null;
	// tail
	private Node tail = null;

	public void put(String key, Blob value) {
		Validate.notNull(cacheMap);
		Validate.notNull(head);
		Validate.notNull(tail);

		if (!cacheMap.containsKey(key)) {
			Node node = new Node(key, value);
			cacheMap.put(key, node);
			insertToHead(node);
		} else {
			Node node = cacheMap.get(key);
			node.val = value;
			removeNode(node);
			insertToHead(node);
		}

		// release tail node if cache is oversized
		if (cacheMap.size() > cacheSize) {
			Node tail = this.tail;
			cacheMap.remove(tail.key);
			this.tail = tail.prev;
			tail.next = null;
		}
	}

	public Blob get(String key) {
		Validate.notNull(cacheMap);

		if (!cacheMap.containsKey(key)) {
			throw new IllegalArgumentException("No cache is found for " + key);
		}

		Node node = cacheMap.get(key);
		removeNode(node);
		insertToHead(node);

		return node.val;
	}

	// if key doesn't exist, IllegalArgumentException is thrown
	public void evict(String key) {
		Validate.notNull(cacheMap);

		if (!cacheMap.containsKey(key)) {
			throw new IllegalArgumentException("No cache is found for " + key);
		}

		Node node = cacheMap.get(key);
		cacheMap.remove(key);
		removeNode(node);
	}

	private void removeNode(Node node) {
		Validate.notNull(node);

		if (node.prev != null) {
			node.prev.next = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		}
		if (tail == node) {
			tail = node.prev;
		}
		node.prev = null;
		node.next = null;
	}

	// insert node to head
	private void insertToHead(Node node) {
		Validate.notNull(head);
		Validate.notNull(node);

		node.prev = head;
		node.next = head.next;
		if (head.next != null) {
			head.next.prev = node;
		} else {
			tail = node;
		}
		head.next = node;
	}

	public void clear() {
		if (cacheMap != null) {
			cacheMap.clear();
		}
		head.next = null;
		tail = head;

	}

	public void destroy() {
		cacheMap = null;
		head = null;
		tail = null;
		cacheSize = 0;
	}

	public void initialize(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Positive size is required "
					+ size);
		}
		cacheMap = new HashMap<String, Node>();
		head = new Node("head", new SerialBlob(new byte[]());
		tail = head;
		this.cacheSize = size;
	}

	public LRUCache() {
		initialize(22);
	}

}

class Node {
	// make them public for simplicity
	public String key;
	public Blob val;
	public Node prev;
	public Node next;

	public Node(String key, Blob val) {
		this.key = key;
		this.val = val;
	}
}
