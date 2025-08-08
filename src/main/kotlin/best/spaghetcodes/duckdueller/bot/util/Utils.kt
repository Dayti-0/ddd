package best.spaghetcodes.duckdueller.bot.util

import net.minecraft.client.Minecraft
import net.minecraft.client.settings.KeyBinding
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraft.util.ChatComponentText

val mc: Minecraft by lazy { Minecraft.getMinecraft() }

fun chat(msg: String) {
    mc.thePlayer?.addChatMessage(ChatComponentText(msg))
}

fun holdKey(binding: KeyBinding) {
    KeyBinding.setKeyBindState(binding.keyCode, true)
}

fun unholdKey(binding: KeyBinding) {
    KeyBinding.setKeyBindState(binding.keyCode, false)
}

fun setSprinting(sprinting: Boolean) {
    mc.thePlayer?.setSprinting(sprinting)
}

fun rightClick() {
    // Simulate right click (use item). onTick is enough for most 1.8.9 setups.
    KeyBinding.onTick(mc.gameSettings.keyBindUseItem.keyCode)
}

fun holdItem(predicate: (ItemStack?) -> Boolean): Boolean {
    val player = mc.thePlayer ?: return false
    val inv = player.inventory ?: return false
    for (i in 0 until 9) {
        val stack = inv.getStackInSlot(i)
        if (predicate(stack)) {
            inv.currentItem = i
            mc.playerController.updateController()
            return true
        }
    }
    return false
}

fun selectBow(): Boolean {
    return holdItem { it != null && it.item == Items.bow }
}

fun findNearestEnemy(maxDistance: Double = 64.0): EntityPlayer? {
    val self = mc.thePlayer ?: return null
    return mc.theWorld?.playerEntities
        ?.asSequence()
        ?.mapNotNull { it as? EntityPlayer }
        ?.filter { it != self }
        ?.filter { self.getDistanceToEntity(it) <= maxDistance }
        ?.minByOrNull { self.getDistanceToEntity(it) }
}
