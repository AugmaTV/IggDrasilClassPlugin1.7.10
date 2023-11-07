/*    */ package com.augma.iggdrasilclassplugin.command;
/*    */ 
/*    */ import com.augma.iggdrasilclassplugin.Main;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ 
/*    */ public class ClassRequierementCommand
/*    */   implements CommandExecutor
/*    */ {
/*    */   public Main main;
/*    */   
/*    */   public ClassRequierementCommand(Main main) {
/* 20 */     this.main = main;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
/* 25 */     if (sender instanceof Player) {
/* 26 */       Player player = (Player)sender;
/* 27 */       if (args.length == 0) {
/* 28 */         player.sendMessage("Merci de préciser la classe");
/* 29 */         player.sendMessage("/classrequierement <guerrier/archer/assassin/samourai/faucheur>");
/*    */       }
/* 31 */       else if (args.length == 1) {
/* 32 */         List<String> lore; String classe = null;
/* 33 */         ItemStack item = player.getItemInHand();
/* 34 */         ItemMeta itemM = item.getItemMeta();
/*    */         
/* 36 */         if (itemM.getLore() != null) {
/* 37 */           lore = itemM.getLore();
/*    */         } else {
/* 39 */           lore = new ArrayList<>();
/*    */         } 
/*    */         
/* 42 */         if (args[0].equalsIgnoreCase("guerrier")) {
/* 43 */           classe = args[0];
/* 44 */         } else if (args[0].equalsIgnoreCase("archer")) {
/* 45 */           classe = args[0];
/* 46 */         } else if (args[0].equalsIgnoreCase("assassin")) {
/* 47 */           classe = args[0];
/* 48 */         } else if (args[0].equalsIgnoreCase("samourai")) {
/* 49 */           classe = args[0];
/* 50 */         } else if (args[0].equalsIgnoreCase("faucheur")) {
/* 51 */           classe = args[0];
/*    */         } else {
/* 53 */           player.sendMessage("/classrequierement <guerrier/archer/assassin/samourai/faucheur>");
/* 54 */           return false;
/*    */         } 
/*    */         
/* 57 */         lore.add("§cRequière la classe " + classe.toLowerCase());
/* 58 */         itemM.setLore(lore);
/* 59 */         item.setItemMeta(itemM);
/*    */       } 
/*    */     } 
/*    */     
/* 63 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IggDrasilClassePlugin.jar!\com\augma\iggdrasilclassplugin\command\ClassRequierementCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */