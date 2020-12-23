package fr.hybridetv.drunlydiscord.proxy;

import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends ServerProxy {
	public ClientProxy()
	{
	MinecraftForge.EVENT_BUS.register(this);
	
	}
}
