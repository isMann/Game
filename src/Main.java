import org.lwjgl.glfw.GLFWVidMode;

import static org.lwjgl.glfw.GLFW.*;
public class Main {
    public Main(){}
    public static void main(String[] args) {
        if (!glfwInit()){
            throw new IllegalStateException("Failed to initialize glfw");
        }
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        long window = glfwCreateWindow(640,480,"Window", 0,0);
        if (window==0){
            throw new IllegalStateException("Failed to create window");
        }
        GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        
        glfwSetWindowPos(window, (vidMode.width()-640)/2, (vidMode.height()-480)/2);
        
        glfwShowWindow(window);
        
        while (!glfwWindowShouldClose(window)){
            glfwPollEvents();
        }
        
        glfwTerminate();
    }
}
