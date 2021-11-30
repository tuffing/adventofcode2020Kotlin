package nz.co.tuffing.aoc2020

import org.springframework.stereotype.Service

@Service
class FileService {
    fun getInputAsListOfNumbers(filePath: String): List<Int> {
        return this::class.java.classLoader.getResource(filePath).readText().split("\r\n").map { i -> i.toInt() }.toList();
    }

    fun getInputAsListOfStrings(filePath: String): List<String> {
        return this::class.java.classLoader.getResource(filePath).readText().split("\r\n").toList();
    }
}