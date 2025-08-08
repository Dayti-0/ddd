package best.spaghetcodes.duckdueller.bot.state

import net.minecraft.entity.EntityLivingBase

object StateManager {
    @JvmStatic var ticksSinceGameStart: Int = 0
    @JvmStatic var target: EntityLivingBase? = null

    fun onGameStart() {
        ticksSinceGameStart = 0
        target = null
    }

    fun tick() {
        ticksSinceGameStart++
    }

    fun reset() {
        ticksSinceGameStart = 0
        target = null
    }
}
