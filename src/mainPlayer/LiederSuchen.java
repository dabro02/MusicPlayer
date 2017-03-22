package mainPlayer;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * Created by Daniel on 21.03.2017.
 */
public class LiederSuchen {

    Thread thread3;
    LiederSuchen() {
        thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<File> mp3files = new ArrayList();
                saveAsTxt(liederSuchen("C:/Users/Daniel/Music", mp3files));

                System.out.println( mp3files.size());
            }
        });
        thread3.start();
    }

    public ArrayList<File> liederSuchen(String pathname, ArrayList<File> mp3files) {

        try {
            String newPathname;

            File MP3files = new File(pathname);
            File[] dateien = MP3files.listFiles();
            for (File file : dateien) {
                newPathname = file.getAbsolutePath();
                if (file.isDirectory()) {
                    liederSuchen(newPathname, mp3files);
                }
                //funktioniert noch nciht die boolean abfrage
                ifMP3(newPathname, file, mp3files);
            }

        }
        catch(Exception e){

        }
        return mp3files;
    }

    public void ifMP3(String pathname, File file, ArrayList<File> mp3files)
    {
        if(pathname.substring(pathname.length()-3, pathname.length()).equalsIgnoreCase("mp3") ) {
            mp3files.add(file);
        }
    }

    public void saveAsTxt(ArrayList<File> mp3files)
    {
        File mp3Dateien = new File("mp3dateien.txt");
        if(!mp3Dateien.exists())
        {
            try{
                mp3Dateien.createNewFile();
            }
            catch(Exception e) {

            }
        }
        else{
            try {
                PrintWriter fw = new PrintWriter(mp3Dateien);
                for(int i = 0 ; i<mp3files.size(); i++)
                {
                    fw.write(mp3files.get(i).getAbsolutePath()+"\n");
                }


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
