import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;


public interface JUser32 extends User32 { //native C function
    boolean ShowWindow(HWND hWnd, int nCmdShow);

}