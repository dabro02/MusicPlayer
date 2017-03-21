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
        ArrayList mp3Dateien = null;
        thread3 = new Thread(new Runnable() {
            @Override
            public void run() {

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
                ifMP3(newPathname, file, mp3Dateien);

                //System.out.println(newPathname);
            }

        }
        catch(Exception e){

        }
    }

    public void ifMP3(String pathname, File file, ArrayList mp3Dateien)
    {
        if(pathname.substring(pathname.length()-3, pathname.length()).equalsIgnoreCase("mp3") ){
            System.out.println(pathname.substring(pathname.length()-3, pathname.length()));
            //return true;
        }
        else {
            //return false;
        }

    }


}
