import kotlin.math.abs

fun main() {

    fun getSortedLists(input: List<String>): Pair<List<Int>, List<Int>> {
        val leftList = mutableListOf<Int>()
        val rightList = mutableListOf<Int>()
        input.forEach { line ->
            leftList.add(line.split("   ").first().toInt())
            rightList.add(line.split("   ").last().toInt())
        }

        leftList.sort()
        rightList.sort()

        return Pair(leftList, rightList)
    }

    fun part1(input: List<String>): Int {
        val (leftList, rightList) = getSortedLists(input);
        return leftList.zip(rightList).sumOf { pair ->
            abs(pair.first - pair.second)
        }
    }

    fun part2(input: List<String>): Int {
        val (leftList, rightList) = getSortedLists(input);
        return leftList.sumOf { leftNum -> leftNum * rightList.count { rightNum -> rightNum == leftNum} }
    }


    println(part1(readInput("input/Day01_test")))
    println(part1(readInput("input/Day01")))

    println(part2(readInput("input/Day01_test")))
    println(part2(readInput("input/Day01")))
}

