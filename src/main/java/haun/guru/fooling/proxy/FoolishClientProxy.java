package haun.guru.fooling.proxy;

import haun.guru.fooling.FoolishMod;
import haun.guru.fooling.gui.GameOverlayHandler;
import haun.guru.fooling.notification.overlay.OverlayRenderHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;

/**
 * Created by KJ4IPS on 11/30/2014.
 */
public class FoolishClientProxy extends FoolishCommonProxy {
    @Override
    public void replaceIngameGui() {
        super.replaceIngameGui();
        FoolishMod.getInstance().getLogger().info("Activating Custom GUI");
        MinecraftForge.EVENT_BUS.register(new GameOverlayHandler());
    }

    @Override
    public void registerOverlays() {
        super.registerOverlays();
        FMLCommonHandler.instance().bus().register(new OverlayRenderHandler());
    }
}
