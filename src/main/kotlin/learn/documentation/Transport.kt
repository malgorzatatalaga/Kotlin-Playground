package learn.documentation

import kotlin.math.roundToInt

fun main() {
    val transport = Transport(1000)
    val ship = Ship(2000, "marine")
    println(transport.getFullInfo())
    println(ship.getFullInfo())
    getTransportInfo(transport)
    /* The getTransportInfo() function works well with any open function of the
    Transport class and its child.
     */
    getTransportInfo(ship)
}

fun getTransportInfo(transport: Transport): String {
    return "transport info: " + transport.getFullInfo()
}

open class Transport(val cost: Int) {
    open fun getFullInfo(): String {
        return "$$cost cost"
    }

    fun getTax(): String {
        return "$${(cost * 0.25).roundToInt()} tax"
    }
}

open class Ship(cost: Int, val color: String) : Transport(cost) {
    override fun getFullInfo(): String {
        return super.getFullInfo() + ", $color color"
    }
}