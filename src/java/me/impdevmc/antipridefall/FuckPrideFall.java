package me.impdevmc.antipridefall;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;
import org.bukkit.plugin.java.JavaPlugin;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedServerPing;

public class FuckPrideFall extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		
		Bukkit.getPluginManager().registerEvents(this, this);
		
		ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(this, new PacketType[] { PacketType.Status.Server.SERVER_INFO }) {
            public void onPacketSending(final PacketEvent event) {
                final WrappedServerPing ping = (WrappedServerPing)event.getPacket().getServerPings().read(0);
                
                ping.setVersionName("§a#§bP§br§ci§dd§ee");
                
                ping.setVersionProtocol(-999992310);
                ping.setPlayersMaximum(500);
                ping.setPlayersOnline(500);
                
                ping.setMotD("                   §a#§bP§br§ci§dd§ee§aM§bo§cn§dt§eh" + "\n" + "                §aR§ba§ci§dn§eb§ao§bw§cF§bo§cr§dE§ev§ae§br");
            }
        });
		
	}
	
	@EventHandler
	public void onJoin(final AsyncPlayerPreLoginEvent a) {
		a.disallow(Result.KICK_OTHER, "\n §aR§ba§ci§dn§eb§ao§bw§cF§bo§cr§dE§ev§ae§br \n §8§o#FuckPrideFall \n");
	}

}
