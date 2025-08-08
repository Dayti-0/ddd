package best.spaghetcodes.duckdueller.bot.bots

import best.spaghetcodes.duckdueller.bot.config.comboProfile
import best.spaghetcodes.duckdueller.bot.features.Bow
import best.spaghetcodes.duckdueller.bot.player.Movement
import best.spaghetcodes.duckdueller.bot.state.StateManager
import best.spaghetcodes.duckdueller.bot.util.findNearestEnemy
import best.spaghetcodes.duckdueller.bot.util.mc

object Combo {
    fun tick() {
        val self = mc.thePlayer ?: return
        StateManager.tick()

        Movement.strafeOpening()
        Bow.openingArrowsIfEnabled(self, StateManager.target ?: findNearestEnemy(32.0))
        Bow.useBow(self, StateManager.target ?: findNearestEnemy(32.0), comboProfile.maxBowDistance)
    }
}
