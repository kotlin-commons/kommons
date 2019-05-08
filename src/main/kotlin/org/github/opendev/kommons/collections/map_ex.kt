package org.github.opendev.kommons.collections

inline fun Map<*, *>.getIntOrDefault(key: Any, default: Int = 0): Int {
    val value = this[key]
    return value?.toString()?.toInt() ?: default
}

inline fun Map<*, *>.getInt(key: Any): Int? {
    val value = this[key]
    return value?.toString()?.toInt()
}

inline fun Map<*, *>.getStringOrDefault(key: Any, default: String = ""): String {
    val value = this[key]
    return value?.toString() ?: default
}

inline fun Map<*, *>.getString(key: Any): String? {
    val value = this[key]
    return value?.toString()
}

//inline fun Map<*, *>.getStringByPath(path: String): Int {
//
//}