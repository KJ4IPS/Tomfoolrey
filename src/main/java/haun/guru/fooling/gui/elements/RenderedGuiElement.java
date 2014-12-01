package haun.guru.fooling.gui.elements;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Created by KJ4IPS on 11/30/2014.
 */
public abstract class RenderedGuiElement {
    protected Tessellator tess = Tessellator.getInstance();
    protected WorldRenderer worldRenderer = tess.getWorldRenderer();
    protected Minecraft mc = Minecraft.getMinecraft();
    protected FontRenderer fontRenderer = mc.fontRendererObj;

    public void doRender(ScaledResolution scaledResolution){

    }

    protected void renderOutlinedBox(int left, int top, int right, int bottom, int outline, int color){
        Gui.drawRect(left, top, right, bottom, outline | 0xFF000000);
        Gui.drawRect(left+1, top+1, right-1, bottom-1, color | 0xFF000000);
    }

    protected void renderGradient(int left, int top, int right, int bottom, int topColor, int bottomColor){ /*ALPHAS ARE NOT SUPPORTED!*/
        float topRed = (float)(topColor >> 16 & 0xFF) / 255F;
        float topGreen = (float)(topColor >> 8 & 0xFF) / 255F;
        float topBlue = (float)(topColor & 0xFF) / 255F;
        float bottomRed = (float)(bottomColor >> 16 & 0xFF) / 255F;
        float bottomGreen = (float)(bottomColor >> 8 & 0xFF) / 255F;
        float bottomBlue = (float)(bottomColor & 0xFF) / 255F;

        GlStateManager.func_179090_x(); //disableTextures
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA,GL11.GL_ONE_MINUS_SRC_ALPHA,1,0);
        GlStateManager.shadeModel(GL11.GL_SMOOTH);

        worldRenderer.startDrawingQuads();
        worldRenderer.func_178960_a(topRed,topGreen,topBlue, 1F); //color4f
        worldRenderer.addVertex((double) right, (double) top, 1D);
        worldRenderer.addVertex((double) left, (double) top, 1D);
        worldRenderer.func_178960_a(bottomRed, bottomGreen, bottomBlue, 1F); //color4f
        worldRenderer.addVertex((double) left, (double) bottom, 1D);
        worldRenderer.addVertex((double) right, (double) bottom, 1D);

        tess.draw();

        GlStateManager.shadeModel(GL11.GL_FLAT);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.func_179098_w(); //enableTextures
    }

}
