package nz.co.tuffing.aoc2020

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class Day2Tests {
    @Autowired
    private lateinit var fileService: FileService;

    @Autowired
    private lateinit var d2: Day2Service;

    @Test
    fun Day2Part1() {
        var input = fileService.getInputAsListOfStrings("input/day2.txt");
        var result = d2.partOne(input);
        assertEquals(result, 2);
    }

}