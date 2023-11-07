/*    */ package com.augma.iggdrasilclassplugin.command;
/*    */ 
/*    */ import com.augma.iggdrasilclassplugin.Main;
/*    */ import com.augma.iggdrasilclassplugin.listener.PlayerListener;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ public class ResetClasseCommand
/*    */   implements CommandExecutor {
/*    */   public Main main;
/*    */   
/*    */   public ResetClasseCommand(Main main) {
/* 19 */     this.main = main;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
/* 25 */     if (sender instanceof Player) {
/* 26 */       Player player = (Player)sender;
/* 27 */       if (args.length == 0) {
/* 28 */         player.sendMessage("Merci de préciser le nom d'un joueur.");
/* 29 */         player.sendMessage("/resetclasse <Player>");
/*    */       }
/* 31 */       else if (args.length == 1) {
/* 32 */         if (Bukkit.getPlayer(args[0]) != null) {
/* 33 */           Player target = Bukkit.getPlayer(args[0]);
/* 34 */           target.getInventory().clear();
/* 35 */           target.getEnderChest().clear();
/* 36 */           target.setLevel(0);
/* 37 */           target.setExp(0.0F);
/* 38 */           target.getInventory().addItem(new ItemStack[] { PlayerListener.bookClass });
/* 39 */           for (PotionEffect pe : target.getActivePotionEffects()) {
/* 40 */             if (pe.getType().equals(PotionEffectType.DAMAGE_RESISTANCE) || pe.getType().equals(PotionEffectType.INCREASE_DAMAGE) || pe.getType().equals(PotionEffectType.SPEED) || pe.getType().equals(PotionEffectType.REGENERATION)) {
/* 41 */               target.removePotionEffect(pe.getType());
/*    */             }
/*    */           } 
/* 44 */           this.main.getConfig().set(String.valueOf(target.getUniqueId().toString()) + ".selected", Boolean.valueOf(false));
/* 45 */           this.main.getConfig().set(String.valueOf(target.getUniqueId().toString()) + ".classe", "null");
/* 46 */           player.performCommand("resetattr " + target.getDisplayName());
/*    */         } else {
/* 48 */           player.sendMessage("Le joueur " + args[0] + " est introuvable.");
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 53 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IggDrasilClassePlugin.jar!\com\augma\iggdrasilclassplugin\command\ResetClasseCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */