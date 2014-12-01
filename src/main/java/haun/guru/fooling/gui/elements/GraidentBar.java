package haun.guru.fooling.gui.elements;

/**
 * Created by KJ4IPS on 11/30/2014.
 */
public class GraidentBar extends RenderedGuiElement {

    public int outlineColor;
    public int fillColor;

    public int topColor;
    public int bottomColor;

    public float targetFill;
    public float currentFill;

    public float slewRate;
    public long lastTime = 0;

    public void doRender(int top,int left,int bottom, int right) {
        mc.mcProfiler.startSection("GradientBar");
        if(lastTime == 0) currentFill = targetFill;
        slew((int) (System.currentTimeMillis() - lastTime));
        lastTime = System.currentTimeMillis();
        int height = bottom - top;
        int width = right - left;
        renderOutlinedBox(left, top, right, bottom, outlineColor, fillColor);
        renderGradient(left + 1, top + 1, left + Math.round(width*currentFill) - 1, top + height - 1,topColor, bottomColor);
        mc.mcProfiler.endSection();
    }

    private void slew(int counts) {
        if(targetFill != currentFill){ //If the values are not already the same
            float slewAmount = slewRate * counts;
            //Slew!
            if(Math.abs(targetFill - currentFill) < slewAmount) //finalization
                currentFill = targetFill;
            else{
                byte direction = (byte) ((targetFill - currentFill > 0) ? 1 : -1);
                currentFill += slewAmount * direction;
            }
        }
    }
}
