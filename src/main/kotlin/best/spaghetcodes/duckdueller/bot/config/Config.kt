package best.spaghetcodes.duckdueller.bot.config

object Config {
    // General
    @JvmField var debug: Boolean = true
    @JvmField var profile: String = "Classic" // "Classic" | "Combo" | "OP"

    // Opening behaviour
    @JvmField var enableOpeningStrafe: Boolean = true
    @JvmField var strafeOpeningTicks: Int = 28

    // Arrows
    @JvmField var aggressiveArrows: Boolean = true
    @JvmField var openingArrowsCount: Int = 1
    @JvmField var openingArrowDistance: Double = 18.0 // shoot if <= this distance

    // Requeue
    @JvmField var enableAutoRequeue: Boolean = false
    @JvmField var queueCommand: String = "/play duels_classic_duel"
}
