package best.spaghetcodes.duckdueller.bot.bots

import best.spaghetcodes.duckdueller.bot.config.classicProfile
import best.spaghetcodes.duckdueller.bot.features.Bow
import best.spaghetcodes.duckdueller.bot.player.Movement
import best.spaghetcodes.duckdueller.bot.state.StateManager
import best.spaghetcodes.duckdueller.bot.util.findNearestEnemy
import best.spaghetcodes.duckdueller.bot.util.mc

object Classic {
    fun tick() {
        val self = mc.thePlayer ?: return
        StateManager.tick()

        // Opening movement
        Movement.strafeOpening()

        // Opening arrows if enabled
        Bow.openingArrowsIfEnabled(self, StateManager.target ?: findNearestEnemy(32.0))

        // Mid-fight bow usage if in distance
        Bow.useBow(self, StateManager.target ?: findNearestEnemy(32.0), classicProfile.maxBowDistance)
    }
}
