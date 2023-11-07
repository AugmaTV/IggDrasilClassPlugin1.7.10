/*     */ package com.augma.iggdrasilclassplugin.listener;
/*     */ 
/*     */ import com.augma.iggdrasilclassplugin.Main;
/*     */ import com.codingforcookies.armorequip.ArmorEquipEvent;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*     */ import org.bukkit.event.entity.EntityShootBowEvent;
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.event.player.PlayerLevelChangeEvent;
/*     */ import org.bukkit.event.player.PlayerQuitEvent;
/*     */ import org.bukkit.event.player.PlayerRespawnEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.potion.PotionEffectType;
/*     */ 
/*     */ 
/*     */ public class PlayerListener
/*     */   implements Listener
/*     */ {
/*     */   public Main main;
/*  35 */   public static ItemStack bookClass = new ItemStack(Material.BOOK);
/*  36 */   public ItemMeta bookM = bookClass.getItemMeta();
/*     */   
/*     */   public PlayerListener(Main main) {
/*  39 */     this.main = main;
/*     */   }
/*     */   
/*     */   public void openSelectGui(final Player player) {
/*  43 */     final Inventory inv = Bukkit.createInventory(null, 27, "Sélectionne ta classe !");
/*  44 */     FileConfiguration config = this.main.getConfig();
/*  45 */     List<String> lore = new ArrayList<>();
/*     */     
/*  47 */     ItemStack classe = null;
/*  48 */     ItemStack indisponible = new ItemStack(Material.INK_SACK);
/*  49 */     indisponible.setDurability((short)1);
/*  50 */     ItemMeta meta = indisponible.getItemMeta();
/*  51 */     meta.setDisplayName("§4Impossible pour le moment !");
/*  52 */     indisponible.setItemMeta(meta);
/*  53 */     ItemStack reset = new ItemStack(Material.INK_SACK);
/*  54 */     reset.setDurability((short)3);
/*  55 */     meta = reset.getItemMeta();
/*  56 */     meta.setDisplayName("§4Reset Total");
/*  57 */     lore.add("§4Indisponible pour le moment !");
/*  58 */     meta.setLore(lore);
/*  59 */     reset.setItemMeta(meta);
/*  60 */     lore.clear();
/*     */     
/*  62 */     if (!config.contains(player.getUniqueId().toString())) {
/*  63 */       config.set(String.valueOf(player.getUniqueId().toString()) + ".playername", player.getDisplayName());
/*  64 */       config.set(String.valueOf(player.getUniqueId().toString()) + ".selected", Boolean.valueOf(false));
/*  65 */       config.set(String.valueOf(player.getUniqueId().toString()) + ".classe", "null");
/*     */     } 
/*     */     
/*  68 */     if (config.getString(String.valueOf(player.getUniqueId().toString()) + ".classe").equalsIgnoreCase("null")) {
/*  69 */       classe = new ItemStack(Material.INK_SACK);
/*  70 */       classe.setDurability((short)2);
/*  71 */       meta = classe.getItemMeta();
/*  72 */       meta.setDisplayName("§2Crée une nouvelle classe !");
/*  73 */       classe.setItemMeta(meta);
/*  74 */     } else if (config.getString(String.valueOf(player.getUniqueId().toString()) + ".classe").equalsIgnoreCase("guerrier")) {
/*  75 */       classe = new ItemStack(Material.STONE_SWORD);
/*  76 */       meta = classe.getItemMeta();
/*  77 */       meta.setDisplayName("�6" + player.getDisplayName());
/*  78 */       lore.add("§eCharacter info : �6");
/*  79 */       lore.add("§e- §8Classe : §4Guerrier");
/*  80 */       lore.add("§e- §8Niveau Actuel : §a" + player.getLevel());
/*  81 */       lore.add("§e- §8XP : §a" + (int)(player.getExp() * player.getExpToLevel()) + " / " + player.getExpToLevel());
/*  82 */       meta.setLore(lore);
/*  83 */       classe.setItemMeta(meta);
/*  84 */       lore.clear();
/*  85 */     } else if (config.getString(String.valueOf(player.getUniqueId().toString()) + ".classe").equalsIgnoreCase("archer")) {
/*  86 */       classe = new ItemStack(Material.BOW);
/*  87 */       meta = classe.getItemMeta();
/*  88 */       meta.setDisplayName("§6" + player.getDisplayName());
/*  89 */       lore.add("§eCharacter info : §6");
/*  90 */       lore.add("§e- §8Classe : §4Archer");
/*  91 */       lore.add("§e- §8Niveau Actuel : §a" + player.getLevel());
/*  92 */       lore.add("§e* §8XP : §a" + (int)(player.getExp() * player.getExpToLevel()) + " / " + player.getExpToLevel());
/*  93 */       meta.setLore(lore);
/*  94 */       classe.setItemMeta(meta);
/*  95 */       lore.clear();
/*  96 */     } else if (config.getString(String.valueOf(player.getUniqueId().toString()) + ".classe").equalsIgnoreCase("assassin")) {
/*  97 */       classe = new ItemStack(Material.SHEARS);
/*  98 */       meta = classe.getItemMeta();
/*  99 */       meta.setDisplayName("§6" + player.getDisplayName());
/* 100 */       lore.add("§eCharacter info : §6");
/* 101 */       lore.add("§e- §8Classe : §4Assassin");
/* 102 */       lore.add("§e- §8Niveau Actuel : §a" + player.getLevel());
/* 103 */       lore.add("§e- §8XP : §a" + (int)(player.getExp() * player.getExpToLevel()) + " / " + player.getExpToLevel());
/* 104 */       meta.setLore(lore);
/* 105 */       classe.setItemMeta(meta);
/* 106 */       lore.clear();
/* 107 */     } else if (config.getString(String.valueOf(player.getUniqueId().toString()) + ".classe").equalsIgnoreCase("samourai")) {
/* 108 */       classe = new ItemStack(Material.IRON_SWORD);
/* 109 */       meta = classe.getItemMeta();
/* 110 */       meta.setDisplayName("�6" + player.getDisplayName());
/* 111 */       lore.add("§eCharacter info : §6");
/* 112 */       lore.add("§e- §8Classe : §4Samourai");
/* 113 */       lore.add("§e- §8Niveau Actuel : §a" + player.getLevel());
/* 114 */       lore.add("§e- §8XP : §a" + (int)(player.getExp() * player.getExpToLevel()) + " / " + player.getExpToLevel());
/* 115 */       meta.setLore(lore);
/* 116 */       classe.setItemMeta(meta);
/* 117 */       lore.clear();
/* 118 */     } else if (config.getString(String.valueOf(player.getUniqueId().toString()) + ".classe").equalsIgnoreCase("faucheur")) {
/* 119 */       classe = new ItemStack(Material.DIAMOND_SWORD);
/* 120 */       meta = classe.getItemMeta();
/* 121 */       meta.setDisplayName("�6" + player.getDisplayName());
/* 122 */       lore.add("§eCharacter info : §6");
/* 123 */       lore.add("§e- §8Classe : §4Faucheur");
/* 124 */       lore.add("§e- §8Niveau Actuel : §a" + player.getLevel());
/* 125 */       lore.add("§e- §8XP : §a" + (int)(player.getExp() * player.getExpToLevel()) + " / " + player.getExpToLevel());
/* 126 */       meta.setLore(lore);
/* 127 */       classe.setItemMeta(meta);
/* 128 */       lore.clear();
/*     */     } 
/*     */     
/* 131 */     inv.setItem(8, reset);
/* 132 */     inv.setItem(12, classe);
/* 133 */     inv.setItem(13, indisponible);
/* 134 */     inv.setItem(14, indisponible);
/*     */     
/* 136 */     if (!player.isDead()) {
/* 137 */       this.main.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.main, new Runnable()
/*     */           {
/*     */             public void run() {
/* 140 */               player.openInventory(inv);
/*     */             }
/*     */           });
/*     */     }
/*     */   }
/*     */   
/*     */   public void openChoiceClassGui(final Player player) {
/* 147 */     final Inventory inv = Bukkit.createInventory(null, 27, "Choisi ta classe");
/* 148 */     List<String> lore = new ArrayList<>();
/* 149 */     ItemStack guerrier = new ItemStack(Material.STONE_SWORD);
/* 150 */     ItemMeta meta = guerrier.getItemMeta();
/* 151 */     meta.setDisplayName("§4Guerrier");
/* 152 */     lore.add("§1Le Guerrier est la classe la plus d�fensive de la b�ta.");
/* 153 */     lore.add("§1Elle vous sera utile pendant les donjons ou autre pour prendre");
/* 154 */     lore.add("§1les coups des monstres qui s'y trouveront !");
/* 155 */     meta.setLore(lore);
/* 156 */     lore.clear();
/* 157 */     guerrier.setItemMeta(meta);
/* 158 */     ItemStack archer = new ItemStack(Material.BOW);
/* 159 */     meta = archer.getItemMeta();
/* 160 */     meta.setDisplayName("§4Archer");
/* 161 */     lore.add("§1L'archer, la classe de prédilection des joueur");
/* 162 */     lore.add("§1à longue distance. Avec votre dague en arme secondaire");
/* 163 */     lore.add("§1vous deviendrait tr�s puissant !");
/* 164 */     meta.setLore(lore);
/* 165 */     lore.clear();
/* 166 */     archer.setItemMeta(meta);
/* 167 */     ItemStack assassin = new ItemStack(Material.SHEARS);
/* 168 */     meta = assassin.getItemMeta();
/* 169 */     meta.setDisplayName("§4Assassin");
/* 170 */     lore.add("§1L'assassin est la meilleures classe DPS de la b�ta.");
/* 171 */     lore.add("§1Elle permet d'infliger d'�norme d�g�ts et rapidement.");
/* 172 */     lore.add("§1En contrepartie vous avez une d�fense tr�s faible !");
/* 173 */     meta.setLore(lore);
/* 174 */     lore.clear();
/* 175 */     assassin.setItemMeta(meta);
/* 176 */     ItemStack samourai = new ItemStack(Material.IRON_SWORD);
/* 177 */     meta = samourai.getItemMeta();
/* 178 */     meta.setDisplayName("§4Samourai");
/* 179 */     lore.add("Le SamouraÏ qui a une maniabilité excellente avec son Katana");
/* 180 */     lore.add("vous aurez quand même de la difficulté à vous défendre !");
/* 181 */     lore.add("Au niveau 50, elle choisit de devenir Daïsho ou un Wakazaki !");
/* 182 */     meta.setLore(lore);
/* 183 */     lore.clear();
/* 184 */     samourai.setItemMeta(meta);
/*     */     
/* 186 */     ItemStack faucheur = new ItemStack(Material.DIAMOND_SWORD);
/* 187 */     meta = faucheur.getItemMeta();
/* 188 */     meta.setDisplayName("§4faucheur");
/* 189 */     lore.add("Le Faucheur est la seule classe du Continent d'IggDrasil à être spécialisée");
/* 190 */     lore.add("dans le vol de vie sur les monstres ou même sur des joueurs en PVP !");
/* 191 */     lore.add("Au niveau 50, elle choisit de devenir Life Thief ou un Finalist !");
/* 192 */     meta.setLore(lore);
/* 193 */     lore.clear();
/* 194 */     faucheur.setItemMeta(meta);
/*     */     
/* 196 */     inv.setItem(11, guerrier);
/* 197 */     inv.setItem(12, samourai);
/* 198 */     inv.setItem(13, archer);
/* 199 */     inv.setItem(14, faucheur);
/* 200 */     inv.setItem(15, assassin);
/*     */     
/* 202 */     if (!player.isDead()) {
/* 203 */       this.main.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.main, new Runnable()
/*     */           {
/*     */             public void run() {
/* 206 */               player.openInventory(inv);
/*     */             }
/*     */           });
/*     */     }
/*     */   }
/*     */   
/*     */   public static void removePlayerPotionEffect(Player player) {
/* 213 */     if (player.getActivePotionEffects() != null && 
/* 214 */       player.getLevel() >= 30) {
/* 215 */       for (PotionEffect p : player.getActivePotionEffects()) {
/* 216 */         if (p.getType().equals(PotionEffectType.DAMAGE_RESISTANCE) || p.getType().equals(PotionEffectType.INCREASE_DAMAGE) || p.getType().equals(PotionEffectType.SPEED) || p.getType().equals(PotionEffectType.REGENERATION)) {
/* 217 */           player.removePotionEffect(p.getType());
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void addPotionEffectByClass(Player player, String classe) {
/* 225 */     if (player.getLevel() >= 30) {
/* 226 */       String str; switch ((str = classe).hashCode()) { case -1415087681: if (!str.equals("guerrier"))
/*     */             break; 
/* 228 */           player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 99999, 0, true)); break;
/*     */         case -1409605757:
/*     */           if (!str.equals("archer"))
/* 231 */             break;  player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 0, true)); break;
/*     */         case -376907387:
/*     */           if (!str.equals("assassin"))
/* 234 */             break;  player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 99999, 0, true));
/*     */           break;
/*     */         case 1010777187:
/*     */           if (!str.equals("faucheur")) {
/*     */             break;
/*     */           }
/* 240 */           player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 0, true)); break;
/*     */         case 1974923253:
/*     */           if (!str.equals("samourai"))
/*     */             break; 
/*     */           player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 99999, 0, true));
/*     */           break; }
/*     */     
/* 247 */     }  } public boolean playerHavePermissionToUse(Player player, ItemStack item) { String[] a = { "guerrier", "archer", "assassin", "samourai", "faucheur" };
/* 248 */     List<String> classe = Arrays.asList(a);
/* 249 */     if (item.getType() != Material.AIR) {
/* 250 */       ItemMeta itemM = item.getItemMeta();
/* 251 */       if (itemM.getLore() != null && (
/* 252 */         itemM.getLore().contains("§cRequière la classe guerrier") || itemM.getLore().contains("§cRequière la classe archer") || itemM.getLore().contains("§cRequière la classe assassin") || itemM.getLore().contains("§cRequière la classe samourai") || itemM.getLore().contains("§cRequière la classe faucheur"))) {
/* 253 */         if (this.main.getConfig().getBoolean(String.valueOf(player.getUniqueId().toString()) + ".selected")) {
/* 254 */           boolean canUse = true;
/* 255 */           for (String str : itemM.getLore()) {
/* 256 */             for (String classeName : classe) {
/* 257 */               if (str.equalsIgnoreCase("§cRequière la classe " + classeName) && 
/* 258 */                 this.main.getConfig().getString(String.valueOf(player.getUniqueId().toString()) + ".classe").equalsIgnoreCase(classeName) && canUse) {
/* 259 */                 canUse = false;
/*     */               }
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/* 265 */           if (canUse) {
/* 266 */             player.sendMessage("Tu n'as pas la classe requise pour utilisé cette item");
/* 267 */             return true;
/*     */           } 
/*     */         } else {
/* 270 */           player.sendMessage("Merci de sélectionner une classe.");
/* 271 */           return true;
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 276 */     return false; }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onInteractEvent(InventoryClickEvent e) {
/* 281 */     Player player = (Player)e.getWhoClicked();
/*     */     
/* 283 */     if (e.getInventory().getName() == "Sélectionne ta classe !") {
/* 284 */       this.bookM.setDisplayName("§9Sélectionne ta classe !");
/* 285 */       bookClass.setItemMeta(this.bookM);
/* 286 */       ItemStack current = e.getCurrentItem();
/* 287 */       if (current.getType().equals(Material.INK_SACK) && current.getDurability() == 2) {
/*     */         
/* 289 */         e.setCancelled(true);
/* 290 */         player.closeInventory();
/* 291 */         openChoiceClassGui(player);
/* 292 */       } else if (current.getType().equals(Material.INK_SACK) && current.getDurability() == 1) {
/*     */         
/* 294 */         e.setCancelled(true);
/* 295 */       } else if (current.getType().equals(Material.INK_SACK) && current.getDurability() == 3) {
/*     */         
/* 297 */         e.setCancelled(true);
/* 298 */       } else if (current.getType().equals(Material.STONE_SWORD)) {
/*     */         
/* 300 */         this.main.getConfig().set(String.valueOf(player.getUniqueId().toString()) + ".selected", Boolean.valueOf(true));
/* 301 */         this.main.getConfig().set(String.valueOf(player.getUniqueId().toString()) + ".classe", "guerrier");
/* 302 */         removePlayerPotionEffect(player);
/* 303 */         addPotionEffectByClass(player, this.main.getConfig().getString(String.valueOf(player.getUniqueId().toString()) + ".classe").toLowerCase());
/* 304 */         e.setCancelled(true);
/* 305 */         player.closeInventory();
/* 306 */         player.sendMessage("Vous avez sélectionner votre classe guerrier, bon jeu !");
/* 307 */         player.getInventory().remove(bookClass);
/* 308 */       } else if (current.getType().equals(Material.BOW)) {
/*     */         
/* 310 */         this.main.getConfig().set(String.valueOf(player.getUniqueId().toString()) + ".selected", Boolean.valueOf(true));
/* 311 */         this.main.getConfig().set(String.valueOf(player.getUniqueId().toString()) + ".classe", "archer");
/* 312 */         removePlayerPotionEffect(player);
/* 313 */         addPotionEffectByClass(player, this.main.getConfig().getString(String.valueOf(player.getUniqueId().toString()) + ".classe").toLowerCase());
/* 314 */         e.setCancelled(true);
/* 315 */         player.closeInventory();
/* 316 */         player.sendMessage("Vous avez sélectionner votre classe archer, bon jeu !");
/* 317 */         player.getInventory().remove(bookClass);
/* 318 */       } else if (current.getType().equals(Material.SHEARS)) {
/*     */         
/* 320 */         this.main.getConfig().set(String.valueOf(player.getUniqueId().toString()) + ".selected", Boolean.valueOf(true));
/* 321 */         this.main.getConfig().set(String.valueOf(player.getUniqueId().toString()) + ".classe", "assassin");
/* 322 */         removePlayerPotionEffect(player);
/* 323 */         addPotionEffectByClass(player, this.main.getConfig().getString(String.valueOf(player.getUniqueId().toString()) + ".classe").toLowerCase());
/* 324 */         e.setCancelled(true);
/* 325 */         player.closeInventory();
/* 326 */         player.sendMessage("Vous avez sélectionner votre classe assassin, bon jeu !");
/* 327 */         player.getInventory().remove(bookClass);
/* 328 */       } else if (current.getType().equals(Material.IRON_SWORD)) {
/*     */         
/* 330 */         this.main.getConfig().set(String.valueOf(player.getUniqueId().toString()) + ".selected", Boolean.valueOf(true));
/* 331 */         this.main.getConfig().set(String.valueOf(player.getUniqueId().toString()) + ".classe", "samourai");
/* 332 */         removePlayerPotionEffect(player);
/* 333 */         addPotionEffectByClass(player, this.main.getConfig().getString(String.valueOf(player.getUniqueId().toString()) + ".classe").toLowerCase());
/* 334 */         e.setCancelled(true);
/* 335 */         player.closeInventory();
/* 336 */         player.sendMessage("Vous avez sélectionner votre classe samourai, bon jeu !");
/* 337 */         player.getInventory().remove(bookClass);
/* 338 */       } else if (current.getType().equals(Material.DIAMOND_SWORD)) {
/*     */         
/* 340 */         this.main.getConfig().set(String.valueOf(player.getUniqueId().toString()) + ".selected", Boolean.valueOf(true));
/* 341 */         this.main.getConfig().set(String.valueOf(player.getUniqueId().toString()) + ".classe", "faucheur");
/* 342 */         removePlayerPotionEffect(player);
/* 343 */         addPotionEffectByClass(player, this.main.getConfig().getString(String.valueOf(player.getUniqueId().toString()) + ".classe").toLowerCase());
/* 344 */         e.setCancelled(true);
/* 345 */         player.closeInventory();
/* 346 */         player.sendMessage("Vous avez sélectionner votre classe faucheur, bon jeu !");
/* 347 */         player.getInventory().remove(bookClass);
/*     */       } 
/* 349 */     } else if (e.getInventory().getName() == "Choisi ta classe") {
/*     */       
/* 351 */       this.bookM.setDisplayName("§9Sélectionne ta classe !");
/* 352 */       bookClass.setItemMeta(this.bookM);
/* 353 */       ItemStack current = e.getCurrentItem();
/* 354 */       if (current.getType().equals(Material.STONE_SWORD)) {
/*     */         
/* 356 */         this.main.getConfig().set(String.valueOf(player.getUniqueId().toString()) + ".selected", Boolean.valueOf(true));
/* 357 */         this.main.getConfig().set(String.valueOf(player.getUniqueId().toString()) + ".classe", "guerrier");
/* 358 */         removePlayerPotionEffect(player);
/* 359 */         addPotionEffectByClass(player, this.main.getConfig().getString(String.valueOf(player.getUniqueId().toString()) + ".classe").toLowerCase());
/* 360 */         e.setCancelled(true);
/* 361 */         player.closeInventory();
/* 362 */         player.sendMessage("Vous avez choisis la classe guerrier, bon jeu !");
/* 363 */         player.getInventory().remove(bookClass);
/* 364 */       } else if (current.getType().equals(Material.BOW)) {
/*     */         
/* 366 */         this.main.getConfig().set(String.valueOf(player.getUniqueId().toString()) + ".selected", Boolean.valueOf(true));
/* 367 */         this.main.getConfig().set(String.valueOf(player.getUniqueId().toString()) + ".classe", "archer");
/* 368 */         removePlayerPotionEffect(player);
/* 369 */         addPotionEffectByClass(player, this.main.getConfig().getString(String.valueOf(player.getUniqueId().toString()) + ".classe").toLowerCase());
/* 370 */         e.setCancelled(true);
/* 371 */         player.closeInventory();
/* 372 */         player.sendMessage("Vous avez choisis la classe archer, bon jeu !");
/* 373 */         player.getInventory().remove(bookClass);
/* 374 */       } else if (current.getType().equals(Material.SHEARS)) {
/*     */         
/* 376 */         this.main.getConfig().set(String.valueOf(player.getUniqueId().toString()) + ".selected", Boolean.valueOf(true));
/* 377 */         this.main.getConfig().set(String.valueOf(player.getUniqueId().toString()) + ".classe", "assassin");
/* 378 */         removePlayerPotionEffect(player);
/* 379 */         addPotionEffectByClass(player, this.main.getConfig().getString(String.valueOf(player.getUniqueId().toString()) + ".classe").toLowerCase());
/* 380 */         e.setCancelled(true);
/* 381 */         player.closeInventory();
/* 382 */         player.sendMessage("Vous avez choisis la classe assassin, bon jeu !");
/* 383 */         player.getInventory().remove(bookClass);
/* 384 */       } else if (current.getType().equals(Material.IRON_SWORD)) {
/*     */         
/* 386 */         this.main.getConfig().set(String.valueOf(player.getUniqueId().toString()) + ".selected", Boolean.valueOf(true));
/* 387 */         this.main.getConfig().set(String.valueOf(player.getUniqueId().toString()) + ".classe", "samourai");
/* 388 */         removePlayerPotionEffect(player);
/* 389 */         addPotionEffectByClass(player, this.main.getConfig().getString(String.valueOf(player.getUniqueId().toString()) + ".classe").toLowerCase());
/* 390 */         e.setCancelled(true);
/* 391 */         player.closeInventory();
/* 392 */         player.sendMessage("Vous avez choisis la classe samourai, bon jeu !");
/* 393 */         player.getInventory().remove(bookClass);
/* 394 */       } else if (current.getType().equals(Material.DIAMOND_SWORD)) {
/*     */         
/* 396 */         this.main.getConfig().set(String.valueOf(player.getUniqueId().toString()) + ".selected", Boolean.valueOf(true));
/* 397 */         this.main.getConfig().set(String.valueOf(player.getUniqueId().toString()) + ".classe", "faucheur");
/* 398 */         removePlayerPotionEffect(player);
/* 399 */         addPotionEffectByClass(player, this.main.getConfig().getString(String.valueOf(player.getUniqueId().toString()) + ".classe").toLowerCase());
/* 400 */         e.setCancelled(true);
/* 401 */         player.closeInventory();
/* 402 */         player.sendMessage("Vous avez choisis la classe faucheur, bon jeu !");
/* 403 */         player.getInventory().remove(bookClass);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerJoinEvent(PlayerJoinEvent e) {
/* 410 */     Player player = e.getPlayer();
/* 411 */     this.bookM.setDisplayName("§9Sélectionne ta classe !");
/* 412 */     bookClass.setItemMeta(this.bookM);
/*     */     
/* 414 */     if (!player.getInventory().contains(bookClass)) {
/* 415 */       player.getInventory().addItem(new ItemStack[] { bookClass });
/*     */     }
/* 417 */     openSelectGui(player);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerLeaveEvent(PlayerQuitEvent e) {
/* 422 */     Player player = e.getPlayer();
/* 423 */     if (this.main.getConfig().getBoolean(String.valueOf(player.getUniqueId().toString()) + ".selected")) {
/* 424 */       removePlayerPotionEffect(player);
/* 425 */       this.main.getConfig().set(String.valueOf(player.getUniqueId().toString()) + ".selected", Boolean.valueOf(false));
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerUse(PlayerInteractEvent e) {
/* 431 */     Player player = e.getPlayer();
/* 432 */     Action a = e.getAction();
/* 433 */     ItemStack current = player.getItemInHand();
/* 434 */     this.bookM.setDisplayName("§9Sélectionne ta classe !");
/* 435 */     bookClass.setItemMeta(this.bookM);
/* 436 */     if (a == Action.RIGHT_CLICK_AIR && current.equals(bookClass)) {
/* 437 */       if (!this.main.getConfig().getBoolean(String.valueOf(player.getUniqueId().toString()) + ".selected")) {
/* 438 */         openSelectGui(player);
/*     */       } else {
/* 440 */         if (!player.getInventory().contains(bookClass)) {
/* 441 */           player.getInventory().addItem(new ItemStack[] { bookClass });
/*     */         }
/* 443 */         player.sendMessage("Vous avez déjà sélectionner votre classe.");
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerUseBow(EntityShootBowEvent e) {
/* 450 */     if (e.getEntity() instanceof Player) {
/* 451 */       ItemStack bow = e.getBow();
/* 452 */       Player player = (Player)e.getEntity();
/* 453 */       e.setCancelled(playerHavePermissionToUse(player, bow));
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onHitEvent(EntityDamageByEntityEvent event) {
/* 459 */     if (event.getDamager() instanceof Player) {
/* 460 */       Player player = (Player)event.getDamager();
/* 461 */       ItemStack item = player.getItemInHand();
/* 462 */       event.setCancelled(playerHavePermissionToUse(player, item));
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onEquipArmor(ArmorEquipEvent e) {
/* 468 */     Player player = e.getPlayer();
/* 469 */     ItemStack armor = e.getNewArmorPiece();
/* 470 */     e.setCancelled(playerHavePermissionToUse(player, armor));
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onRespawnEvent(PlayerRespawnEvent e) {
/* 475 */     final Player player = e.getPlayer();
/* 476 */     if (this.main.getConfig().getBoolean(String.valueOf(player.getUniqueId().toString()) + ".selected")) {
/* 477 */       this.main.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.main, new Runnable()
/*     */           {
/*     */             public void run() {
/* 480 */               PlayerListener.addPotionEffectByClass(player, PlayerListener.this.main.getConfig().getString(String.valueOf(player.getUniqueId().toString()) + ".classe").toLowerCase());
/*     */             }
/* 482 */           }1L);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerLevelUp(PlayerLevelChangeEvent e) {
/* 489 */     Player player = e.getPlayer();
/* 490 */     addPotionEffectByClass(player, this.main.getConfig().getString(String.valueOf(player.getUniqueId().toString()) + ".classe").toLowerCase());
/*     */   }
/*     */ }


/* Location:              C:\Users\Augma\Downloads\IggDrasilClassePlugin.jar!\com\augma\iggdrasilclassplugin\listener\PlayerListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */