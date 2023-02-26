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

    solve(file)
}

fun solve(input: File) {
    var fullyContained = 0
    var overlaps = 0

    input.forEachLine {
        val ranges = it.split(',')
        val first = parseRange(ranges[0])
        val second = parseRange(ranges[1])

        if(fullyContains(first, second)) {
            fullyContained++
        }

        if(overlaps(first, second)) {
            overlaps++
        }
    }

    println("Part 1, fully contained ranges: $fullyContained")
    println("Part 2, overlapping ranges: $overlaps")
}

fun parseRange(range: String) : Range {
    val values = range.split('-')
    return Range(values[0].toInt(), values[1].toInt())
}

fun fullyContains(first: Range, second: Range) : Boolean {
    if(first.start <= second.start && first.end >= second.end) {
        return true
    }
    else if(second.start <= first.start && second.end >= first.end) {
        return true
    }

    return false
}

fun overlaps(first: Range, second: Range) : Boolean {
    if(first.end >= second.start && first.end <= second.end) {
        return true
    }
    else if(second.end >= first.start && second.end <= first.end) {
        return true
    }

    return false
}

data class Range(val start: Int, val end: Int)