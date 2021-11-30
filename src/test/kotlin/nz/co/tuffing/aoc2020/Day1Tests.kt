package nz.co.tuffing.aoc2020

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class Day1Tests {
    @Autowired
    private lateinit var fileService: FileService;

    @Autowired
    private lateinit var d1: Day1Service;

    @Test
    fun Day1Part1() {
        var input = fileService.getInputAsListOfNumbers("testInput/day1.txt");
        var result = d1.partOne(input);
        assertEquals(result, 514579);
    }

}