package mainPlayer;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by Daniel on 21.03.2017.
 */
public class LiederSuchen {

    Thread thread3;
    LiederSuchen(){
        thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList mp3Dateien = null;
                liederSuchen("C:/Users", mp3Dateien);
                System.out.println("finished");
                System.out.println(mp3Dateien);


            }
        });
        thread3.start();
    }

    public void liederSuchen(String pathname, ArrayList mp3Dateien) {
        try {
            String newPathname;
            File MP3files = new File(pathname);
            File[] dateien = MP3files.listFiles();
            for (File file : dateien) {
                newPathname = file.getAbsolutePath();
                if (file.isDirectory()) {


                    liederSuchen(newPathname, mp3Dateien);
                }

                //funktioniert noch nciht die boolean abfrage
                if(ifMP3(newPathname)){
                    ifMP3(newPathname);
                    mp3Dateien.add(file);

                }

                //System.out.println(newPathname);
            }

        }
        catch(Exception e){

        }
    }

    public boolean ifMP3(String pathname)
    {
        if(pathname.substring(pathname.length()-3, pathname.length()).equalsIgnoreCase("mp3") ){
            System.out.println(pathname.substring(pathname.length()-3, pathname.length()));
            System.out.println(pathname);
            return true;
        }
        else {
            return false;
        }

    }


}
