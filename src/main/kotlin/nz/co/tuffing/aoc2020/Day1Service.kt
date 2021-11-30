package nz.co.tuffing.aoc2020

import org.springframework.stereotype.Service

@Service
class Day1Service {
    fun partOne(input: List<Int>): Int {
        var numbers = ArrayDeque<Int>(input);

        while (numbers.isNotEmpty()) {
            var next = numbers.removeFirst()
            numbers.filter { x -> x + next == 2020 }.forEach { i -> return i * next }
        }

        return 0;
    }

    fun partTwo(input: List<Int>): Int {
        input.forEach { x -> input.forEach { y -> input.forEach { z -> if (x + y + z == 2020) return x * y * z }} }

        return 0;
    }
}