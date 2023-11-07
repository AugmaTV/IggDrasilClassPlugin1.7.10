/*    */ package com.augma.iggdrasilclassplugin.command;
/*    */ 
/*    */ import com.augma.iggdrasilclassplugin.Main;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class InfoClasseCommand
/*    */   implements CommandExecutor
/*    */ {
/*    */   public Main main;
/*    */   
/*    */   public InfoClasseCommand(Main main) {
/* 16 */     this.main = main;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
/* 22 */     if (sender instanceof Player) {
/* 23 */       Player player = (Player)sender;
/* 24 */       if (args.length == 0) {
/* 25 */         player.sendMessage("Merci de préciser le nom d'un joueur.");
/* 26 */         player.sendMessage("/infoclasse <Player>");
/*    */       }
/* 28 */       else if (args.length == 1) {
/* 29 */         if (Bukkit.getPlayer(args[0]) != null) {
/* 30 */           Player target = Bukkit.getPlayer(args[0]);
/* 31 */           player.sendMessage("§eCharacter info : §6" + target.getDisplayName());
/* 32 */           if (this.main.getConfig().getString(String.valueOf(target.getUniqueId().toString()) + ".classe") != null) {
/* 33 */             player.sendMessage("§e- §8Classe : §4" + this.main.getConfig().getString(String.valueOf(target.getUniqueId().toString()) + ".classe"));
/*    */           } else {
/* 35 */             player.sendMessage("§e- §8Classe : �4Aucune");
/*    */           } 
/* 37 */           player.sendMessage("§e- §8Niveau Actuel : §a" + target.getLevel());
/* 38 */           player.sendMessage("§e- §8XP : §a" + (int)(target.getExp() * target.getExpToLevel()) + " / " + target.getExpToLevel());
/*    */         } else {
/* 40 */           player.sendMessage("Le joueur " + args[0] + " est introuvable.");
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 45 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IggDrasilClassePlugin.jar!\com\augma\iggdrasilclassplugin\command\InfoClasseCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */