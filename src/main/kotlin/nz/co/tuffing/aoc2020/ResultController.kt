package nz.co.tuffing.aoc2020

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigInteger

@RestController
class ResultController(val fileService: FileService, val d1: Day1Service,
                       val d2: Day2Service, val d3: Day3Service, val d4: Day4Service,
                       val d5: Day5Service, val d6: Day6Service, val d7: Day7Service,
                       val d8: Day8Service, val d12: Day12Service) {
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

    @GetMapping("day3")
    fun dayThree(): Pair<BigInteger, BigInteger> {
        var input = fileService.getInputAsListOfStrings("input/day3input.txt");

        return Pair(d3.partOne(input), d3.partTwo(input));
    }

    @GetMapping("day4")
    fun dayFour(): Pair<Int, Int> {
        var input = fileService.getInputAsListOfStrings("input/day4input.txt");

        return Pair(d4.partOne(input), d4.partTwo(input));
    }

    @GetMapping("day5")
    fun dayFive(): Pair<Int, Int> {
        var input = fileService.getInputAsListOfStrings("input/day5input.txt");

        return Pair(d5.partOne(input), d5.partTwo(input));
    }

    @GetMapping("day6")
    fun daySix(): Pair<Int, Int> {
        var input = fileService.getInputAsListOfStrings("input/day6input.txt");

        return Pair(d6.partOne(input), d6.partTwo(input));
    }

    @GetMapping("day7")
    fun daySeven(): Pair<Int, Int> {
        var input = fileService.getInputAsListOfStrings("input/day7input.txt");

        return Pair(d7.partOne(input), d7.partTwo(input));
    }

    @GetMapping("day8")
    fun dayEight(): Pair<Int, Int> {
        var input = fileService.getInputAsListOfStrings("input/day8input.txt");

        return Pair(d8.partOne(input), d8.partTwo(input));
    }

    @GetMapping("day12")
    fun dayTwelve(): Pair<Int, Int> {
        var input = fileService.getInputAsListOfStrings("input/day12input.txt");

        return Pair(d12.partOne(input), d12.partTwo(input));
    }
}