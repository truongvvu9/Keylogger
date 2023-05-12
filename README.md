# Keylogger
A console application that hides the window and the IDE and records the keystrokes silently to a text file.
<br>
<br>
A console application that silently records keystrokes while the console window is hidden. This is a keylogger proof of concept application  This application primarily targets windows OS but it should work for mac and linux although the window will only be hidden for windows OS users. This application uses the JNativeHook and JNA libaries for hooking into the operating system and gaining low level access. There are a total of three JAR files that you must add as dependecies. If you are using IntelliJ Idea Community Edition, click on File > Project Structure > Modules > Module Source > + > JARS or Directories and then navigate to the directory of the three JAR files and add all three files. The three JAR files can be downloaded in the 'Dependencies' folder on my github.
