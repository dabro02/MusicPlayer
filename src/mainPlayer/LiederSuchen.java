package mainPlayer;


import java.io.File;
import java.util.ArrayList;


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

                liederSuchen("C:/Users");
                System.out.println("finished");
                System.out.println(mp3Dateien);


            }
        });
        thread3.start();
    }

    public ArrayList liederSuchen(String pathname) {
        ArrayList mp3files = null;
        try {
            String newPathname;

            File MP3files = new File(pathname);
            File[] dateien = MP3files.listFiles();
            for (File file : dateien) {
                newPathname = file.getAbsolutePath();
                if (file.isDirectory()) {
                    liederSuchen(newPathname);
                }
                //funktioniert noch nciht die boolean abfrage
                ifMP3(newPathname, file, mp3files);
            }

        }
        catch(Exception e){

        }
        return mp3files;
    }

    public void ifMP3(String pathname, File file, ArrayList mp3files)
    {
        if(pathname.substring(pathname.length()-3, pathname.length()).equalsIgnoreCase("mp3") ){
            mp3files.add(file);
        }
        else {

        }

    }


}
