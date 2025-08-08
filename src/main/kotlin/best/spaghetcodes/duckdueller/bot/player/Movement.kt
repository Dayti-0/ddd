package best.spaghetcodes.duckdueller.bot.player

import best.spaghetcodes.duckdueller.bot.config.Config
import best.spaghetcodes.duckdueller.bot.state.StateManager
import best.spaghetcodes.duckdueller.bot.util.mc
import best.spaghetcodes.duckdueller.bot.util.holdKey
import best.spaghetcodes.duckdueller.bot.util.unholdKey
import best.spaghetcodes.duckdueller.bot.util.setSprinting

object Movement {
    private var strafeLeft = true

    /** Opening strafe for the first X ticks **/
    fun strafeOpening() {
        if (!Config.enableOpeningStrafe) return
        if (StateManager.ticksSinceGameStart > Config.strafeOpeningTicks) {
            // release keys after opening
            unholdKey(mc.gameSettings.keyBindLeft)
            unholdKey(mc.gameSettings.keyBindRight)
            return
        }

        swapLeftRight()
    }

    /** Alternates between left and right each tick **/
    fun swapLeftRight() {
        val left = mc.gameSettings.keyBindLeft
        val right = mc.gameSettings.keyBindRight

        if (strafeLeft) {
            holdKey(left)
            unholdKey(right)
        } else {
            holdKey(right)
            unholdKey(left)
        }
        strafeLeft = !strafeLeft
    }

    fun forward(on: Boolean) {
        val fwd = mc.gameSettings.keyBindForward
        if (on) holdKey(fwd) else unholdKey(fwd)
    }

    fun sprint(on: Boolean) = setSprinting(on)
}
