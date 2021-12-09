package nz.co.tuffing.aoc2020

import org.springframework.stereotype.Service

@Service
class Day8Service {
    fun partOne(input: List<String>): Int {
        return 0;
    }

    fun partTwo(input: List<String>): Int {
        var sums : MutableList<Int> = mutableListOf()
        input.forEach { it ->
            var parts = it.split('|');
            var digits : MutableList<Set<Char>> =  MutableList(10) { mutableSetOf() };
            var unknownFives : MutableList<Set<Char>> = mutableListOf();
            var unknownSixes :  MutableList<Set<Char>> = mutableListOf();

            parts[0].split(' ').forEach { it2 ->
                when (it2.count()) {
                    2 -> digits[1] = it2.toSet()
                    3 -> digits[7] = it2.toSet()
                    4 -> digits[4] = it2.toSet()
                    5 -> unknownFives.add(it2.toSet());
                    6 -> unknownSixes.add(it2.toSet());
                    7 -> digits[8] = it2.toSet()
                }
            }

            unknownFives.forEach { it2 ->
                if (it2.containsAll(digits[7]))
                    digits[3] = it2;
                else if (digits[4].count { x -> it2.contains(x) } == 3)
                    digits[5] = it2;
                else
                    digits[2] = it2;
            }

            unknownSixes.forEach { it2 ->
                if (it2.containsAll(digits[4]))
                    digits[9] = it2;
                else if (it2.containsAll(digits[7]))
                    digits[0] = it2;
                else
                    digits[6] = it2;
            }

            var i = 1000;
            var value = 0;
            parts[1].split(' ').forEach { place ->
                var chars = place.toSet();
                for (index in 0 until digits.count()) {
                    if (digits[index].count() == chars.count() && digits[index].containsAll(chars)) {
                        value += i * index;
                        i /= 10;
                        break;
                    }
                }
            };
            sums.add(value);
        }

        return sums.sum();
    }
}