import org.lwjgl.opengl.GL;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;
import java.util.Random;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
public class Main {
    Random random = new Random();
    public Main(){

        if (!glfwInit()){
            System.err.println("GLFW failed to initialize");
            System.exit(1);
        }
        long window = glfwCreateWindow(650,480,"Window",0,0);
        glfwShowWindow(window);
        glfwMakeContextCurrent(window);
        GL.createCapabilities();

        float x = 0, y=0;
        
        while (!glfwWindowShouldClose(window)){
            if (glfwGetKey(window, GLFW_KEY_LEFT)==GLFW_TRUE){x-=0.001f;}
            if (glfwGetKey(window, GLFW_KEY_RIGHT)==GLFW_TRUE){x+=0.001f;}
            if (glfwGetKey(window, GLFW_KEY_UP)==GLFW_TRUE){y+=0.001f;}
            if (glfwGetKey(window, GLFW_KEY_DOWN)==GLFW_TRUE){y-=0.001f;}
            glfwPollEvents();
            glClear(GL_COLOR_BUFFER_BIT);
            glBegin(GL_QUADS);
            glColor4f(1,0,1,0);
            glVertex2f(-0.5f+x,0.5f+y);
            glColor4f(0,1,0,0);
            glVertex2f(0.5f+x,0.5f+y);
            glColor4f(1,1,0,0);
            glVertex2f(0.5f+x,-0.5f+y);
            glColor4f(1,0,0,0);
            glVertex2f(-0.5f+x,-0.5f+y);
            glEnd();
            glfwSwapBuffers(window);
        }
        glfwTerminate();
    }

    private static void music() {
        while (true){
            new Thread(() -> {
                File file = new File("");
                Clip clip = null;
                try {
                    clip = AudioSystem.getClip();
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                }
                try {
                    clip.open(AudioSystem.getAudioInputStream(file));
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                }
                clip.start();
                try {
                    Thread.sleep(clip.getMicrosecondLength());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
