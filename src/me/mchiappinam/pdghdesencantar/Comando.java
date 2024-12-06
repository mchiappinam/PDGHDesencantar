package me.mchiappinam.pdghdesencantar;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Comando implements CommandExecutor, Listener {
	private Main plugin;
	List<Player> lista = new ArrayList<Player>();
	public Comando(Main main) {
		plugin=main;
	}
	
  	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("desencantar")) {
			if(args.length>0) {
	            sender.sendMessage("§cUse /desencantar");
				return true;
        	}
  			if(!sender.hasPermission("pdgh.vip")) {
				sender.sendMessage("§cApenas §6§lVIP §cpode desencantar!");
				sender.sendMessage("§cAdquira seu §6§lVIP §cem www.pdgh.com.br");
  				return true;
  			}
    	    if(((Player)sender).getItemInHand().getEnchantments().size()==0) {
    	    	sender.sendMessage("§cEsse item não tem encantamento.");
    	    	return true;
    	    }
			double taxa = plugin.getConfig().getDouble("taxa");
	        if(!(Main.econ.getBalance(sender.getName()) >= plugin.getConfig().getDouble("taxa"))) {
			    sender.sendMessage("§cVocê não tem money suficiente.");
			    sender.sendMessage("§cMoney necessário: §a$"+taxa+"§c.");
			    return true;
	        }
	        if(!lista.contains((Player)sender)) {
	        	lista.add((Player)sender);
	        	sender.sendMessage("§cMoney necessário: §a$"+taxa+"§c.");
	        	sender.sendMessage("§aDigite novamente para desencantar!");
			    return true;
	        }
	        lista.remove((Player)sender);
	        Main.econ.withdrawPlayer(sender.getName(), taxa);
    	    ((Player)sender).getItemInHand().removeEnchantment(Enchantment.ARROW_DAMAGE);
    	    ((Player)sender).getItemInHand().removeEnchantment(Enchantment.ARROW_FIRE);
    	    ((Player)sender).getItemInHand().removeEnchantment(Enchantment.ARROW_INFINITE);
    	    ((Player)sender).getItemInHand().removeEnchantment(Enchantment.ARROW_KNOCKBACK);
    	    ((Player)sender).getItemInHand().removeEnchantment(Enchantment.DAMAGE_ALL);
    	    ((Player)sender).getItemInHand().removeEnchantment(Enchantment.DAMAGE_ARTHROPODS);
    	    ((Player)sender).getItemInHand().removeEnchantment(Enchantment.DAMAGE_UNDEAD);
    	    ((Player)sender).getItemInHand().removeEnchantment(Enchantment.DIG_SPEED);
    	    ((Player)sender).getItemInHand().removeEnchantment(Enchantment.DURABILITY);
    	    ((Player)sender).getItemInHand().removeEnchantment(Enchantment.FIRE_ASPECT);
    	    ((Player)sender).getItemInHand().removeEnchantment(Enchantment.KNOCKBACK);
    	    ((Player)sender).getItemInHand().removeEnchantment(Enchantment.LOOT_BONUS_BLOCKS);
    	    ((Player)sender).getItemInHand().removeEnchantment(Enchantment.LOOT_BONUS_MOBS);
    	    ((Player)sender).getItemInHand().removeEnchantment(Enchantment.OXYGEN);
    	    ((Player)sender).getItemInHand().removeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL);
    	    ((Player)sender).getItemInHand().removeEnchantment(Enchantment.PROTECTION_EXPLOSIONS);
    	    ((Player)sender).getItemInHand().removeEnchantment(Enchantment.PROTECTION_FALL);
    	    ((Player)sender).getItemInHand().removeEnchantment(Enchantment.PROTECTION_FIRE);
    	    ((Player)sender).getItemInHand().removeEnchantment(Enchantment.PROTECTION_PROJECTILE);
    	    ((Player)sender).getItemInHand().removeEnchantment(Enchantment.SILK_TOUCH);
    	    ((Player)sender).getItemInHand().removeEnchantment(Enchantment.THORNS);
    	    ((Player)sender).getItemInHand().removeEnchantment(Enchantment.WATER_WORKER);
    	    sender.sendMessage("§aItem desencantado com sucesso. §cTaxa: §a$"+taxa);
    	    return true;
        }
		return false;
    }
	
  	
  	
  	
  	
  	
}