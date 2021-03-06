package ua.leonidius.trading.help;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandExecutor;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.PluginCommand;
import cn.nukkit.item.Item;
import ua.leonidius.trading.Main;
import ua.leonidius.trading.utils.Message;

/**
 * Created by Leonidius20 on 05.03.17.
 */
public class IdCmd extends PluginCommand implements CommandExecutor{

    @SuppressWarnings("unchecked")
    public IdCmd(){
        super ("id", Main.getPlugin());
        this.setExecutor(this);
        this.setDescription(Message.CMD_ID.toString());
        this.setUsage("/id");
        this.getCommandParameters().clear();
    }

    public boolean onCommand (CommandSender sender, Command command, String label, String[] args){
        if (!(sender instanceof Player)){
            Message.CMD_CONSOLE.printError(sender);
        } else {
            Player player = (Player) sender;
            Item heldItem = player.getInventory().getItemInHand();
            int id = heldItem.getId();
            int meta = heldItem.getDamage();
            String name = heldItem.getName();
            if (id == 0){
                Message.ID_EMPTY.printError(player);
            } else {
                Message.ID_ITEMID.print(sender, name, id, meta);
            }
        }
        return true;
    }
}
