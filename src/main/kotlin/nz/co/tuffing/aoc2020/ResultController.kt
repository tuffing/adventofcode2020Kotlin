package nz.co.tuffing.aoc2020

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ResultController(val fileService: FileService, val d1: Day1Service, val d2: Day2Service) {
    @GetMapping("day1")
    fun dayOne(): Pair<Int, Int> {
        var input = fileService.getInputAsListOfNumbers("input/day1input.txt");

        return Pair(d1.partOne(input), d1.partTwo(input));
    }

    @GetMapping("day2")
    fun dayTwo(): Pair<Int, Int> {
        var input = fileService.getInputAsListOfStrings("input/day2input.txt");

        return Pair(d2.partOne(input), d2.partTwo(input));
    }

}