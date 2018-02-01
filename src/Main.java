import org.lwjgl.opengl.GL;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
public class Main {
    public Main(){
        if (!glfwInit()){
            System.err.println("GLFW failed to initialize");
            System.exit(1);
        }
        long window = glfwCreateWindow(650,480,"Window",0,0);
        glfwShowWindow(window);
        glfwMakeContextCurrent(window);
        GL.createCapabilities();
        
        while (!glfwWindowShouldClose(window)){
            glfwPollEvents();
            glClear(GL_COLOR_BUFFER_BIT);
            glBegin(GL_QUADS);
            glColor4f(1,0,1,0);
            glVertex2f(-0.5f,0.5f);
            glColor4f(0,1,0,0);
            glVertex2f(0.5f,0.5f);
            glColor4f(0,1,1,0);
            glVertex2f(0.5f,-0.5f);
            glColor4f(1,0,1,0);
            glVertex2f(-0.5f,-0.5f);
            glEnd();
            glfwSwapBuffers(window);
        }
        glfwTerminate();
    }
    public static void main(String[] args) {
        new Main();
    }
}
