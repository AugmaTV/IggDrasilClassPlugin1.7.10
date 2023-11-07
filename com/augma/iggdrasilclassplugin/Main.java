/*    */ package com.augma.iggdrasilclassplugin;
/*    */ 
/*    */ import com.augma.iggdrasilclassplugin.command.ClassRequierementCommand;
/*    */ import com.augma.iggdrasilclassplugin.command.InfoClasseCommand;
/*    */ import com.augma.iggdrasilclassplugin.command.RemoveRequireCommand;
/*    */ import com.augma.iggdrasilclassplugin.command.ResetClasseCommand;
/*    */ import com.augma.iggdrasilclassplugin.listener.PlayerListener;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ public class Main extends JavaPlugin {
/*    */   public void onEnable() {
/* 18 */     System.out.println("IggDrasil Classe Plugin is loaded.");
/* 19 */     saveDefaultConfig();
/* 20 */     getCommand("resetclasse").setExecutor((CommandExecutor)new ResetClasseCommand(this));
/* 21 */     getCommand("infoclasse").setExecutor((CommandExecutor)new InfoClasseCommand(this));
/* 22 */     getCommand("classrequierement").setExecutor((CommandExecutor)new ClassRequierementCommand(this));
/* 23 */     getCommand("removerequierement").setExecutor((CommandExecutor)new RemoveRequireCommand());
/* 24 */     getServer().getPluginManager().registerEvents((Listener)new PlayerListener(this), (Plugin)this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onDisable() {
/* 29 */     System.out.println("IggDrasil Classe Plugin has been stopped.");
/*    */     
/* 31 */     for (Player p : getServer().getOnlinePlayers()) {
/* 32 */       if (getConfig().getBoolean(String.valueOf(p.getUniqueId().toString()) + ".selected")) {
/* 33 */         PlayerListener.removePlayerPotionEffect(p);
/* 34 */         getConfig().set(String.valueOf(p.getUniqueId().toString()) + ".selected", Boolean.valueOf(false));
/*    */       } 
/*    */     } 
/*    */     
/*    */     try {
/* 39 */       getConfig().save(getDataFolder() + File.separator + "config.yml");
/* 40 */     } catch (IOException e) {
/* 41 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IggDrasilClassePlugin.jar!\com\augma\iggdrasilclassplugin\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */