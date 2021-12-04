package nz.co.tuffing.aoc2020

import org.springframework.stereotype.Service

@Service
class Day2Service {
    fun partOne(input: List<String>): Int {
        return input.map { row -> row.split("-", ": ", " ") }
            .count { x -> x[3].count { x[2].contains(it) } >= x[0].toInt() && x[3].count { x[2].contains(it) } <= x[1].toInt() };
    }

    fun partTwo(input: List<String>): Int {
        return input.map { row -> row.split("-", ": ", " ") }
            .count { x -> (x[3][x[0].toInt()-1].toString() == x[2]) xor (x[3][x[1].toInt()-1].toString() == x[2]) };
    }
}