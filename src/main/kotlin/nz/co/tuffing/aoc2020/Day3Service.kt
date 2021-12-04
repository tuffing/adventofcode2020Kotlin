package nz.co.tuffing.aoc2020

import org.springframework.stereotype.Service
import java.math.BigInteger

@Service
class Day3Service {
    fun partOne(input: List<String>): BigInteger {
        return treeCount(input, 3, 1);
    }

    fun partTwo(input: List<String>): BigInteger {
        /*
            Right 1, down 1.
            Right 3, down 1. (This is the slope you already checked.)
            Right 5, down 1.
            Right 7, down 1.
            Right 1, down 2.
        */
        return  treeCount(input, 1, 1) * treeCount(input, 3, 1) * treeCount(input, 5, 1) * treeCount(input, 7, 1) * treeCount(input, 1, 2);
    }

    private fun treeCount(input: List<String>, right: Int, down: Int): BigInteger {
        var x = 0;
        var y = 0;
        var count = 0;

        while (y < input.count()) {
            if (input[y][x] == '#')
                count++;

            y += down;
            x = (x + right) % input[0].count();
        }

        return count.toBigInteger();
    }
}