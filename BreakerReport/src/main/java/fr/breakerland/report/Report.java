package fr.breakerland.report;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Report extends JavaPlugin implements CommandExecutor {

	
	public void onEnable() {
		saveDefaultConfig();
		checkConfig();
		getCommand("report").setExecutor(this);
	}


	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		Player p = (Player) sender;
		TextComponent msg = new TextComponent();
		msg.setText(ChatColor.translateAlternateColorCodes('&', getConfig().getString("message", "§8Merci de cliquer sur ce lien pour report votre problème sur discord")+" "));
		TextComponent button = new TextComponent();
		button.setText(ChatColor.translateAlternateColorCodes('&', getConfig().getString("button", "§f[§eLIEN§f]")));
		button.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discordapp.com/channels/596754524392259584/646368170441048076"));
		msg.addExtra(button);
		p.spigot().sendMessage(msg);
		return false;
	}
	public void checkConfig() {
		if(!getConfig().isSet("message")) getConfig().set("message", "&8Merci de cliquer sur ce lien pour report votre problème sur discord");
		if(!getConfig().isSet("button")) getConfig().set("button", "&f[&eLIEN&f]");
		saveConfig();
	}

}
