package haun.guru.fooling;

import haun.guru.fooling.network.FoolishPacketHandler;
import haun.guru.fooling.proxy.FoolishCommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.FMLEmbeddedChannel;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.Logger;

import java.util.EnumMap;

@Mod(modid="tomfoolrey")
public class FoolishMod{

    @Mod.Instance
    private static FoolishMod instance;

    @SidedProxy(clientSide = "haun.guru.fooling.proxy.FoolishClientProxy", serverSide = "haun.guru.fooling.proxy.FoolishCommonProxy")
    private static FoolishCommonProxy proxy;

    private Logger logger;
    private EnumMap<Side,FMLEmbeddedChannel> channel;

    public static FoolishMod getInstance() {
        return instance;
    }


    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent e){
        logger = e.getModLog();
        channel = NetworkRegistry.INSTANCE.newChannel("tomfoolrey", new FoolishPacketHandler());
        proxy.registerOverlays();
        proxy.replaceIngameGui();
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent e){
    }

    @Mod.EventHandler
    public void onPostInit(FMLPostInitializationEvent e){
    }

    public Logger getLogger(){
        return logger;
    }

    public static FoolishCommonProxy getProxy() {
        return proxy;
    }

    public EnumMap<Side, FMLEmbeddedChannel> getChannel() {
        return channel;
    }
}
