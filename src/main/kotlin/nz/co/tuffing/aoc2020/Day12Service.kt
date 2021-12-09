package nz.co.tuffing.aoc2020

import org.springframework.stereotype.Service
import kotlin.math.absoluteValue

@Service
class Day12Service {
    fun partOne(input: List<String>): Int {
        /*
            Action N means to move north by the given value.
            Action S means to move south by the given value.
            Action E means to move east by the given value.
            Action W means to move west by the given value.
            Action L means to turn left the given number of degrees.
            Action R means to turn right the given number of degrees.
            Action F means to move forward by the given value in the direction the ship is currently facing.
        */
        var coords = Pair(0,0)
        var dir = 1
        val dirs = listOf(::north,::east,::south,::west)
        input.forEach {
            val dist =  it.drop(1).toInt()
            when (it[0]) {
                'N' -> coords = north(coords, dist)
                'E' -> coords = east(coords, dist)
                'S' -> coords = south(coords, dist)
                'W' -> coords = west(coords, dist)
                'L' -> dir = left(dir, dist)
                'R' -> dir = right(dir, dist)
                'F' -> coords = dirs[dir](coords, dist)
            }
        }

        return coords.first.absoluteValue + coords.second.absoluteValue
    }

    fun north(coords: Pair<Int,Int>, dist: Int): Pair<Int,Int> {
        return Pair(coords.first, coords.second + dist)
    }

    fun east(coords: Pair<Int,Int>, dist: Int): Pair<Int,Int> {
        return Pair(coords.first + dist, coords.second)
    }

    fun south(coords: Pair<Int,Int>, dist: Int): Pair<Int,Int> {
        return Pair(coords.first, coords.second - dist)
    }

    fun west(coords: Pair<Int,Int>, dist: Int): Pair<Int,Int> {
        return Pair(coords.first - dist, coords.second)
    }

    fun left(dir: Int, degrees: Int): Int {
        return (dir - degrees / 90).mod(4)
    }

    fun right(dir: Int, degrees: Int): Int {
        return (dir + degrees / 90).mod(4)
    }

    fun partTwo(input: List<String>): Int {
        /*
            Action N means to move the waypoint north by the given value.
            Action S means to move the waypoint south by the given value.
            Action E means to move the waypoint east by the given value.
            Action W means to move the waypoint west by the given value.
            Action L means to rotate the waypoint around the ship left (counter-clockwise) the given number of degrees.
            Action R means to rotate the waypoint around the ship right (clockwise) the given number of degrees.
            Action F means to move forward to the waypoint a number of times equal to the given value.
        */
        var ship = Pair(0,0)
        var wp = Pair(10,1)

        input.forEach {
            val dist =  it.drop(1).toInt()
            when (it[0]) {
                'N' -> wp = Pair(wp.first, wp.second + dist);
                'E' -> wp = Pair(wp.first + dist, wp.second);
                'S' -> wp = Pair(wp.first, wp.second - dist);
                'W' -> wp = Pair(wp.first - dist, wp.second);
                'L' -> (90 .. dist step 90).forEach { _ -> wp = Pair(wp.second*-1,wp.first) }
                'R' -> (90 .. dist step 90).forEach { _ -> wp = Pair(wp.second,wp.first*-1) }
                'F' -> ship = Pair(ship.first + (wp.first*dist), ship.second + (wp.second*dist))
            }
        }

        return ship.first.absoluteValue + ship.second.absoluteValue
    }
}