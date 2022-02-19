package brokenAvg

main()

fun main() {
    val inputs: MutableList<Int?> = getInputs() 
    val totalSum: Double = eccEval(inputs)

    println("INPUTS: " + inputs)
    println("AVG SUM: " + totalSum/inputs.size)
}

fun eccEval(inputs: MutableList<Int?>): Double {
    var sum: Double = 0.0

    for (i in inputs.indices) {
        if (inputs[i] == null) {
            var tempSum = 0
            for (j in (i - 2)..i + 2) {
                if (j != i) {
                    if (j >= 0 && j < inputs.size) tempSum += inputs[j]!!
                }
            }
            inputs[i] = kotlin.math.ceil(tempSum / 4.0).toInt()
        }
        sum += inputs[i]!!
    }

    return sum
}

fun getInputs(): MutableList<Int?> {
    val inputs: MutableList<Int?> = mutableListOf<Int?>() 

    while (true) {
        val input = readLine()
        if (input == "END") break
        else inputs.add(input?.toIntOrNull())
    }

    return inputs
}