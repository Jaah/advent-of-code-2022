import java.io.File

fun main(args: Array<String>) {
    if (args.isEmpty())
    {
        println("Input file not provided")
        return
    }

    val fileName = args.first()
    val file = File(fileName)
    if(!file.exists())
    {
        println("File $fileName does not exist.")
        return
    }

    var total = 0
    file.forEachLine {
        val opponent = parseShape(it.first())
        val expected = parseExpectedOutcome(it.last())
        val outcome = playRound(opponent, expected)
        total += outcome
    }

    println("Total score after all rounds: $total")
}

fun parseShape(letter: Char): Shape {
    return when (letter) {
        'A', 'X' -> Shape.ROCK
        'B', 'Y' -> Shape.PAPER
        'C', 'Z' -> Shape.SCISSORS
        else -> Shape.UNKNOWN
    }
}

fun parseExpectedOutcome(letter: Char): Outcome {
    return when (letter) {
        'X' -> Outcome.LOSS
        'Y' -> Outcome.DRAW
        'Z' -> Outcome.WIN
        else -> Outcome.UNKNOWN
    }
}

// part 2
fun playRound(opponent: Shape, expected: Outcome): Int {
    return expected.points + when(opponent) {
        Shape.UNKNOWN -> {
            TODO()
        }
        Shape.ROCK -> {
             when(expected) {
                 Outcome.UNKNOWN -> TODO()
                 Outcome.WIN -> Shape.PAPER.points
                 Outcome.DRAW -> Shape.ROCK.points
                 Outcome.LOSS -> Shape.SCISSORS.points
             }
        }
        Shape.PAPER -> {
            when(expected) {
                Outcome.UNKNOWN -> TODO()
                Outcome.WIN -> Shape.SCISSORS.points
                Outcome.DRAW -> Shape.PAPER.points
                Outcome.LOSS -> Shape.ROCK.points
            }
        }
        Shape.SCISSORS -> {
            when(expected) {
                Outcome.UNKNOWN -> TODO()
                Outcome.WIN -> Shape.ROCK.points
                Outcome.DRAW -> Shape.SCISSORS.points
                Outcome.LOSS -> Shape.PAPER.points
            }
        }
    }
}

// part 1
fun playRound(opponent: Shape, me: Shape): Int {
    return me.points + when(opponent) {
        Shape.UNKNOWN -> {
            TODO()
        }
        Shape.ROCK -> {
             when(me) {
               Shape.UNKNOWN -> TODO()
               Shape.ROCK -> Outcome.DRAW.points
               Shape.PAPER -> Outcome.WIN.points
               Shape.SCISSORS -> Outcome.LOSS.points
           }
        }
        Shape.PAPER -> {
            when(me) {
                Shape.UNKNOWN -> TODO()
                Shape.ROCK -> Outcome.LOSS.points
                Shape.PAPER -> Outcome.DRAW.points
                Shape.SCISSORS -> Outcome.WIN.points
            }
        }
        Shape.SCISSORS -> {
            when(me) {
                Shape.UNKNOWN -> TODO()
                Shape.ROCK -> Outcome.WIN.points
                Shape.PAPER -> Outcome.LOSS.points
                Shape.SCISSORS -> Outcome.DRAW.points
            }
        }
    }
}

enum class Shape(val points: Int) {
    UNKNOWN(0),
    ROCK(1),
    PAPER(2),
    SCISSORS(3)
}

enum class Outcome(val points: Int) {
    UNKNOWN(0),
    WIN(6),
    DRAW(3),
    LOSS(0)
}