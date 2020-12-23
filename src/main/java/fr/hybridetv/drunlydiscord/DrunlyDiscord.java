package fr.hybridetv.drunlydiscord;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;
import fr.hybridetv.drunlydiscord.proxy.ServerProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@Mod(modid = "drunlydiscord", name = "drunlydiscord", version = "2.0", acceptedMinecraftVersions = "[1.12]")
public class DrunlyDiscord
{
  @Instance("drunlydiscord")
  public static DrunlyDiscord instance;
  public static int loops = 1;

  @SidedProxy(clientSide = "fr.hybridetv.drunlydiscord.proxy.ClientProxy", serverSide = "fr.hybridetv.drunlydiscord.proxy.ServerProxy", modId = "drunlydiscord")
  public static ServerProxy proxy;
  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    discordRPC();
  }
  @EventHandler
  public void init(FMLInitializationEvent event) { proxy.register(); }
  @EventHandler
  public void postInit(FMLPostInitializationEvent event) {}
  @EventHandler
  public static void serverInit(FMLServerStartingEvent event) {}

  
  @SideOnly(Side.CLIENT)
  private void discordRPC() {
    DiscordRPC discord = DiscordRPC.INSTANCE;
    String applicationId = "SET YOUR BOT ID HERE";
    String steamId = "";
    
    DiscordEventHandlers handlers = new DiscordEventHandlers();
    discord.Discord_Initialize(applicationId, handlers, true, steamId);
    
    DiscordRichPresence presence = new DiscordRichPresence();
    presence.startTimestamp = System.currentTimeMillis() / 1000L;
    presence.largeImageKey = "logodrunly";
    presence.largeImageText = "Drunly V2";
    presence.details = "drunlypvp.fr";
    presence.state = "Joue sur le serveur !";
    
    discord.Discord_UpdatePresence(presence);
  }
}
