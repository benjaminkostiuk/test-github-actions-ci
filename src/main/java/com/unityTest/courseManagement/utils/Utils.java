package com.unityTest.courseManagement.utils;

import com.unityTest.courseManagement.models.CourseAttributeName;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Utils {

	// TODO Change mapping if necessary
	public static <K, V> Map<K, V> toMap(Class<K> keyType, Class<V> valueType, Object... entries) {
		if (entries.length % 2 == 1)
			throw new IllegalArgumentException("Invalid entries");
		return IntStream
			.range(0, entries.length / 2)
			.map(i -> i * 2)
			.collect(
				HashMap::new, (m, i) -> m.put(keyType.cast(entries[i]), valueType.cast(entries[i + 1])), Map::putAll);
	}

	public static <E extends Enum<E>> E parseToEnum(String string, Class<E> clazz) {
		// Convert string to enum value
		E value = null;
		if (string != null) {
			try {
				value = Enum.valueOf(clazz, string);
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException(
						String.format("Not one of accepted value for %s", clazz.getCanonicalName()));
			}
		}
		return value;
	}
}
