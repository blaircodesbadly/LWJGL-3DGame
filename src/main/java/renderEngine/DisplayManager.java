package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

public class DisplayManager {


    private static int WIDTH = 1280;
    private static int HEIGHT = 720;
    private static int FPS_CAP = 120;

    public static void createDisplay(){
        ContextAttribs attribs = new ContextAttribs(3,2)
        .withForwardCompatible(true)
        .withProfileCore(true);
        try{
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.setTitle("Hi hen");
            Display.create(new PixelFormat(), attribs);
            //Display.setTitle("Hi hen");
        } catch (LWJGLException e){
            e.printStackTrace();
        }
        GL11.glViewport(0,0,WIDTH,HEIGHT);
    }

    public static void updateDisplay(){
         Display.sync(FPS_CAP);
         Display.update();
    }

    public static void closeDisplay(){
        Display.destroy();
    }
}
