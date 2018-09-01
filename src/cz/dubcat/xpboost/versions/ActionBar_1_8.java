package cz.dubcat.xpboost.versions;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import cz.dubcat.xpboost.api.MainAPI;
import cz.dubcat.xpboost.constructors.Debug;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class ActionBar_1_8 implements ActionbarInterface {

	@Override
	public void sendActionBarMessage(Player player, String message) {
		CraftPlayer p = (CraftPlayer) player;
		IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \"" + message + "\"}");
		PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc, (byte) 2);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(ppoc);
		MainAPI.debug("Sent action bar message to " + p.getName(), Debug.ALL);
	}

}