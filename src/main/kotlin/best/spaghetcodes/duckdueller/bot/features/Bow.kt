package best.spaghetcodes.duckdueller.bot.features

import best.spaghetcodes.duckdueller.bot.config.Config
import best.spaghetcodes.duckdueller.bot.state.StateManager
import best.spaghetcodes.duckdueller.bot.util.*
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Items

object Bow {
    // Shoot N arrows at the start if enabled and a target is in range
    fun openingArrowsIfEnabled(self: EntityPlayer, target: EntityPlayer?) {
        if (!Config.aggressiveArrows) return
        val tgt = target ?: findNearestEnemy(Config.openingArrowDistance) ?: return

        if (self.getDistanceToEntity(tgt) <= Config.openingArrowDistance) {
            if (selectBow()) {
                repeat(Config.openingArrowsCount.coerceAtLeast(1)) {
                    rightClick() // start charging/shot; on 1.8 this usually triggers a quick shot
                }
                if (Config.debug) chat("Aggressive arrow opening on ${tgt.name}")
            }
        }
    }

    // Generic bow usage when within distance constraint for active profile
    fun useBow(self: EntityPlayer, target: EntityPlayer?, maxDistance: Double) {
        val tgt = target ?: return
        if (self.getDistanceToEntity(tgt) > maxDistance) return

        // ensure bow is selected
        if (selectBow()) {
            rightClick()
        }
    }
}
