package steps;

import java.io.*;

public class CaptureLogs extends Thread{
    String log;

    public void run()
    {
        try{

            System.out.printf("Inside CaptureLogs class");
            Process process = Runtime.getRuntime().exec("adb logcat");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

             log = "";
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("inside bufferedreader while loop");
                log.concat(line);
            }

            System.out.printf("outside while loop");
                File file = new File("/Users/prashanthsiddharamaiah/Development/HelloAppium/build/ADBLogs.log");
                if (!file.exists())
                    file.createNewFile();


            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] b = log.getBytes();
            fileOutputStream.write(b);
            fileOutputStream.flush();
            fileOutputStream.close();



        }
        catch (Exception e)
        {
            System.out.println("Exception in capture logs");
            System.out.println(e.getMessage());
        }
    }
}
