# JungleSocks

1. Download Eclipse IDE, http://eclipse.org/downloads
   You may download either 'Eclipse IDE for Java Developers' or 'Eclipse IDE for Java EE Developers', 32/64 bit depending on your system
2. Unzip the Eclipse zip file in a suitable folder on your "C" drive
3. Locate Eclipse.exe executable, double click the icon (file) to start the IDE
4. Create workspace (File -> SwitchWorkspace -> Other), name your workspace suitably.
5. Start a new Java Project (File -> New -> Java Project), name your project, use default location, select JRE version e.g. Java 1.8
6. You also need to Download the Selenium Server and Selenium Client Jar files, ensure to download appropriate java client
   http://docs.seleniumhq.org/download/
7. Create a new folder as 'lib' under your current project, copy selenium server and client jar files to the 'lib' folder
8. Select both the jar files and add to build path (Select the jar files -> Right Click -> Build Path -> Add to Build Path)
9. Download the JUnit jar file from sourceforge.net, copy the JUnit jar file to the 'lib' folder in your project
10. Add the JUnit jar file to the build path as specified in Step 8

# Executing Tests
1. Open Eclipse, go to Package explorer -> SRC -> Default Package
2. Right click on (default package), New -> JUnit Test Case
3. Name your test case as 'Jungle Socks', copy JungleSocks.java from the 'src' folder of this GitHub repo
4. Save your file in Eclipse (JungleSocks.java)
5. To run the tests, select the file in the explorer window, right click and 'Run as' JUnit test
6. You'll see all the test methods in the Java class execute successively



