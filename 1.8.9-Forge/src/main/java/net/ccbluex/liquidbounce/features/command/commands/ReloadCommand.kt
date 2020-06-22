/*
 * LiquidHUD Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/CCBlueX/LiquidBounce/
 */
package net.ccbluex.liquidbounce.features.command.commands

import net.ccbluex.liquidbounce.LiquidHUD
import net.ccbluex.liquidbounce.features.command.Command
import net.ccbluex.liquidbounce.features.command.CommandManager
import net.ccbluex.liquidbounce.ui.client.clickgui.ClickGui
import net.ccbluex.liquidbounce.ui.font.Fonts

class ReloadCommand : Command("reload", arrayOf("configreload")) {
    /**
     * Execute commands with provided [args]
     */
    override fun execute(args: Array<String>) {
        chat("Reloading...")
        chat("§c§lReloading commands...")
        LiquidHUD.commandManager = CommandManager()
        LiquidHUD.commandManager.registerCommands()
        LiquidHUD.isStarting = true
        for(module in LiquidHUD.moduleManager.modules)
            LiquidHUD.moduleManager.generateCommand(module)
        chat("§c§lReloading fonts...")
        Fonts.loadFonts()
        chat("§c§lReloading modules...")
        LiquidHUD.fileManager.loadConfig(LiquidHUD.fileManager.modulesConfig)
        LiquidHUD.isStarting = false
        chat("§c§lReloading values...")
        LiquidHUD.fileManager.loadConfig(LiquidHUD.fileManager.valuesConfig)
        chat("§c§lReloading HUD...")
        LiquidHUD.fileManager.loadConfig(LiquidHUD.fileManager.hudConfig)
        chat("§c§lReloading ClickGUI...")
        LiquidHUD.clickGui = ClickGui()
        LiquidHUD.fileManager.loadConfig(LiquidHUD.fileManager.clickGuiConfig)
        chat("Reloaded.")
    }
}
