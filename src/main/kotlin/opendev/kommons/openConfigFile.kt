package opendev.kommons

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import java.io.File
import java.io.InputStream


val mapper = run {
    val mapper = ObjectMapper(YAMLFactory())
    mapper.registerModule(KotlinModule())
    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
    mapper
}

fun openConfigFile(fileName: String): InputStream? {
    if (File(fileName).exists()) {
        return File(fileName).inputStream()
    }
    val cl = Thread.currentThread().contextClassLoader.getResourceAsStream(fileName)
    if (cl != null) return cl
    return ClassLoader.getSystemResourceAsStream(fileName)
}

inline fun <reified T>readConfigFile(fileName: String): T? {
    if (fileName.endsWith("yml") || fileName.endsWith("yaml")) {
        return openConfigFile(fileName).use {
            mapper.readValue(it, T::class.java)
        }
    }
    return null
}