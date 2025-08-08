package best.spaghetcodes.duckdueller.bot.player

import net.minecraft.client.settings.KeyBinding

private fun hold(key: KeyBinding) = KeyBinding.setKeyBindState(key.keyCode, true)
private fun unhold(key: KeyBinding) = KeyBinding.setKeyBindState(key.keyCode, false)

val left get() = mc.gameSettings.keyBindLeft
val right get() = mc.gameSettings.keyBindRight

fun startForward() = hold(mc.gameSettings.keyBindForward)
fun stopForward() = unhold(mc.gameSettings.keyBindForward)

fun startBackward() = hold(mc.gameSettings.keyBindBack)
fun stopBackward() = unhold(mc.gameSettings.keyBindBack)

fun startLeft() = hold(left)
fun stopLeft() = unhold(left)

fun startRight() = hold(right)
fun stopRight() = unhold(right)

fun startJumping() = hold(mc.gameSettings.keyBindJump)
fun stopJumping() = unhold(mc.gameSettings.keyBindJump)
fun singleJump() = startJumping() // one-tap; release logic can be handled elsewhere

fun startSneaking() = hold(mc.gameSettings.keyBindSneak)
fun stopSneaking() = unhold(mc.gameSettings.keyBindSneak)
fun sneaking(): Boolean = mc.thePlayer?.isSneaking ?: false

fun startSprinting() = hold(mc.gameSettings.keyBindSprint)
fun stopSprinting() = unhold(mc.gameSettings.keyBindSprint)
fun setSprinting(value: Boolean) { if (value) startSprinting() else stopSprinting() }

fun clearLeftRight() { stopLeft(); stopRight() }
fun clearAll() {
    stopForward(); stopBackward(); clearLeftRight()
    stopJumping(); stopSneaking(); stopSprinting()
}
