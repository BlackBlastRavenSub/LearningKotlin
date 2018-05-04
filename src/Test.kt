//(Int) -> Int 左が引数、右が戻り値
var TEST = 0

fun main(args: Array<String>) {
    //args[0] = "TEST"
    if (args.isNotEmpty()) {
        println("Hello!")
        println(args[0])
    } else {
        println("・・・Who?")
    }
    val name0: String = "TEST"
    println()
    for (A in 0..10) {

        if (A == 10) {
            println(A)
        } else {
            print(A)
        }
    }
    println(subSys(1, 2))

    val plus = ::subSys
    TEST = 1 + plus.invoke(1, 5)

    val A = subSysPlus(1, 1, ::subSys)
    println("関数内関数は" + A)

    println(map(src, ::square)) // => [4, 9, 16]

    println(map(src, ::factorial)) // => [2, 6, 24]
}

fun subSys(a: Int, b: Int): Int {
    return a + b
}

fun subSysPlus(x: Int, y: Int, z: (Int, Int) -> Int): Int {
    val f = z(x, y)
    return f
}

//関数・変数名(引数,引数):戻り値
fun map(ints: List<Int>, f: (Int) -> Int): List<Int> {
    val newList = java.util.ArrayList<Int>()
    //ループごとに変数へListの中身が渡される(変数名 in List名)
    for (e in ints) {
        newList.add(f(e))
    }
    return newList
}

// [2, 3, 4]のリストを作る
val src = listOf(2, 3, 4)

// 平方を得る関数を各要素に適用
fun square(n: Int): Int = n * n

// 階乗を得る関数を各要素に適用
fun factorial(n: Int): Int =
        if (n == 1) 1
        else n * factorial(n - 1)