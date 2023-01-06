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

    var current = 0
    var calories = mutableListOf<Int>()

    file.forEachLine {
        if (!it.isNullOrBlank())
        {
            val n = it.toInt()
            current += n
        }
        else
        {
            calories.add(current)
            current = 0
        }
    }

    println("Sum of top 3 calories is: ${calories.sortedDescending().take(3).sum()}")
}