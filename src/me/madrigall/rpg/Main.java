package me.madrigall.rpg;

import java.util.logging.Logger;

import me.madrigall.rpg.sql.Sql;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class Main extends JavaPlugin implements Listener {
	
	public static Main instance;
	Logger log = Logger.getLogger("Minecraft");
	
	@Override 
	public void onEnable()
	{
		loadConf();
		saveConf();
		
		instance = this;
		
		Sql sql = new Sql(); 
		sql.init();
		
		Bukkit.getPluginManager().registerEvents(this, this);

	}
	public static Main getPlugin()
	{
		return instance;
	}
	
	protected void saveConf()
	{
		getConfig().set("general.language","ru");
        saveConfig();
	}
	
	public void loadConf()
	{
		
	}
	
	@Override
	public void onDisable()
	{

	}
	
	@EventHandler
	public void onLogin(PlayerLoginEvent event)
	{
		Player player = event.getPlayer();
		
		player.setLevel(50);
        //player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 200, 1));
				
	}
}
