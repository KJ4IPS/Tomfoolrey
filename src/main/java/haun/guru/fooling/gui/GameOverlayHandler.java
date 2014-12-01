package haun.guru.fooling.gui;

import haun.guru.fooling.gui.elements.GraidentBar;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Arrays;
import java.util.List;

/**
 * Created by KJ4IPS on 11/30/2014.
 */
public class GameOverlayHandler {

    private GraidentBar healthBar;

    private static final int healthbarWidth = 200;
    private static final int healthbarHeight = 10;


    public GameOverlayHandler(){
        healthBar = new GraidentBar();
        healthBar.topColor = 0xFFFF0000;
        healthBar.bottomColor = 0xFFFFAA00;
        healthBar.slewRate = .001f;
        healthBar.fillColor = 0xFF292929;
        healthBar.outlineColor = 0xFFFFFFFF;
    }

    private static final List<RenderGameOverlayEvent.ElementType> elementsToCancel = Arrays.asList(
            RenderGameOverlayEvent.ElementType.AIR,
            RenderGameOverlayEvent.ElementType.ARMOR,
            RenderGameOverlayEvent.ElementType.EXPERIENCE,
            RenderGameOverlayEvent.ElementType.FOOD,
            RenderGameOverlayEvent.ElementType.HEALTH,
            RenderGameOverlayEvent.ElementType.HEALTHMOUNT,
            RenderGameOverlayEvent.ElementType.HOTBAR,
            RenderGameOverlayEvent.ElementType.JUMPBAR,
            RenderGameOverlayEvent.ElementType.PLAYER_LIST
    );

    @SubscribeEvent
    public void onPreRender(RenderGameOverlayEvent.Pre e){
        if(elementsToCancel.contains(e.type)){
            e.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onRenderIngame(RenderGameOverlayEvent e){
        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayer player = mc.thePlayer;
        renderHeathBar(e.resolution,(player.getHealth()/player.getMaxHealth()));
    }

    private void renderHeathBar(ScaledResolution resolution, float portion){
        healthBar.targetFill = portion;
        healthBar.doRender(resolution.getScaledHeight() - 30, (resolution.getScaledWidth() >> 1) - (healthbarWidth >> 1),resolution.getScaledHeight()-30+healthbarHeight,(resolution.getScaledWidth() >> 1) + (healthbarWidth >> 1));
    }

}
