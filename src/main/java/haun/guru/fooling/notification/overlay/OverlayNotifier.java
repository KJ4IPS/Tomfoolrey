package haun.guru.fooling.notification.overlay;

import haun.guru.fooling.notification.BasicNotification;

import java.util.List;

/**
 * Created by KJ4IPS on 11/30/2014.
 */
public class OverlayNotifier {
    private static List<BasicNotification> notificationQueue;
    private static final int ticksPer = 200; //Ten Seconds
    private static int ticksLeft;
    private static BasicNotification activeNotification;

    public static BasicNotification getActiveNotification() {
        return activeNotification;
    }

    public static void addNotification(BasicNotification notification) {
        notificationQueue.add(notification);
    }

    public static int getTicksLeft(){
        return ticksLeft;
    }

    public static void setTicksLeft(int newSecondsLeft){
        ticksLeft = newSecondsLeft;
    }
}
