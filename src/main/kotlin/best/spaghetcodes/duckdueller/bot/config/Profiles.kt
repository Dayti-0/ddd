package best.spaghetcodes.duckdueller.bot.config

data class BotProfile(
    val name: String,
    val maxBowDistance: Double,
    val keepSprint: Boolean,
    val circleRadius: Double,
)

val classicProfile = BotProfile(
    name = "Classic",
    maxBowDistance = 18.0,
    keepSprint = true,
    circleRadius = 2.5
)

val comboProfile = BotProfile(
    name = "Combo",
    maxBowDistance = 20.0,
    keepSprint = false,
    circleRadius = 3.0
)

val opProfile = BotProfile(
    name = "OP",
    maxBowDistance = 25.0,
    keepSprint = true,
    circleRadius = 4.0
)
