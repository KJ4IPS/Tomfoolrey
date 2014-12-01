package haun.guru.fooling.notification.overlay;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by KJ4IPS on 11/30/2014.
 */
public class OverlayRenderHandler {

    @SubscribeEvent
    public void onRenderScreen(TickEvent.RenderTickEvent event){ //a proof of concept box
        if(!Minecraft.getMinecraft().inGameHasFocus) return;
        Gui.drawRect(0,0,50,20,0x88000000);
        FontRenderer fontRender = Minecraft.getMinecraft().fontRendererObj;
        fontRender.drawString("Test Text",0,0,0xFFFFFFFF);
        fontRender.drawString(new SimpleDateFormat("HH:mm:ss").format(new Date()),0,9,0xFFFFFFFF);
    }
}
