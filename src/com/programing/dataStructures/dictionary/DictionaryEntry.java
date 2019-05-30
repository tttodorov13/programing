package com.programing.dataStructures.dictionary;

/**
 * This class is used by Dictionary Abstract Data Type (ADT).
 * It encapsulates Key and Value objects.
 *
 * @param <K> - type of the keys.
 * @param <V> - type of the values.
 */
public class DictionaryEntry<K, V> {

	private K key;
	private V value;

	public DictionaryEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return this.key;
	}

	public V getValue() {
		return this.value;
	}

	@Override public String toString() {
		return String.format("[%s, %s]", key, value);
	}
}

