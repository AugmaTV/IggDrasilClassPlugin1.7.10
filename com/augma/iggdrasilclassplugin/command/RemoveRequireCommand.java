/*    */ package com.augma.iggdrasilclassplugin.command;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ public class RemoveRequireCommand
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
/* 16 */     if (sender instanceof Player) {
/* 17 */       Player player = (Player)sender;
/* 18 */       if (!player.getItemInHand().getType().equals(Material.AIR)) {
/* 19 */         ItemMeta item = player.getItemInHand().getItemMeta();
/* 20 */         if (item.getLore() != null) {
/* 21 */           String[] a = { "guerrier", "archer", "assassin", "samourai", "faucheur" };
/* 22 */           List<String> classe = Arrays.asList(a);
/* 23 */           List<String> lore = item.getLore();
/* 24 */           for (String classeName : classe) {
/* 25 */             if (item.getLore().contains("§cRequière la classe " + classeName)) {
/* 26 */               lore.remove(lore.indexOf("§cRequière la classe " + classeName));
/*    */             }
/*    */           } 
/* 29 */           item.setLore(lore);
/* 30 */           player.getItemInHand().setItemMeta(item);
/* 31 */           player.sendMessage("Suppression des restrictions réussi !");
/*    */         } else {
/* 33 */           player.sendMessage("Cet item n'a pas de lore.");
/*    */         } 
/*    */       } else {
/* 36 */         player.sendMessage("Merci d'avoir un item dans la main.");
/*    */       } 
/*    */     } 
/* 39 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IggDrasilClassePlugin.jar!\com\augma\iggdrasilclassplugin\command\RemoveRequireCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */