import java.io.File

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Input file not provided")
        return
    }

    val fileName = args.first()
    val file = File(fileName)
    if (!file.exists()) {
        println("File $fileName does not exist.")
        return
    }

    solvePart1(file)
    solvePart2(file)

}

fun solvePart2(input: File) {
    val group = mutableListOf<Set<Char>>()
    var count = 0
    var total = 0
    
    input.forEachLine {
        val set = it.toSet()
        group.add(set)

        count++

        if (count == 3) {
            val intersect = group[0].intersect(group[1]).intersect(group[2])
            val badge = intersect.first()
            total += getPriority(badge)
            group.clear()
            count = 0
        }
    }

    println("Part 2 total is $total")
}

fun solvePart1(input: File) {
    var total = 0
    input.forEachLine {
        val compartments = it.chunked(it.length / 2)
        val intersect = compartments.first().toSet().intersect(compartments.last().toSet())
        total += getPriority(intersect.first())
    }

    println("Part 1 total is $total")
}

fun getPriority(item: Char): Int {
    return when (item) {
        'a' -> 1
        'b' -> 2
        'c' -> 3
        'd' -> 4
        'e' -> 5
        'f' -> 6
        'g' -> 7
        'h' -> 8
        'i' -> 9
        'j' -> 10
        'k' -> 11
        'l' -> 12
        'm' -> 13
        'n' -> 14
        'o' -> 15
        'p' -> 16
        'q' -> 17
        'r' -> 18
        's' -> 19
        't' -> 20
        'u' -> 21
        'v' -> 22
        'w' -> 23
        'x' -> 24
        'y' -> 25
        'z' -> 26

        'A' -> 26 + 1
        'B' -> 26 + 2
        'C' -> 26 + 3
        'D' -> 26 + 4
        'E' -> 26 + 5
        'F' -> 26 + 6
        'G' -> 26 + 7
        'H' -> 26 + 8
        'I' -> 26 + 9
        'J' -> 26 + 10
        'K' -> 26 + 11
        'L' -> 26 + 12
        'M' -> 26 + 13
        'N' -> 26 + 14
        'O' -> 26 + 15
        'P' -> 26 + 16
        'Q' -> 26 + 17
        'R' -> 26 + 18
        'S' -> 26 + 19
        'T' -> 26 + 20
        'U' -> 26 + 21
        'V' -> 26 + 22
        'W' -> 26 + 23
        'X' -> 26 + 24
        'Y' -> 26 + 25
        'Z' -> 26 + 26

        else -> 0
    }
}