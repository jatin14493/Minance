package Minance;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

class FileDownloadTest {

    public static void main(String[] args) {

        // Make sure that this directory exists in the system
        String dirName = "/Users/B0205328/Desktop/Testing";

        try {

            //https://www.nseindia.com/content/historical/EQUITIES/2017/MAY/cm05JUN2017bhav.csv.zip

            saveFileFromURL(dirName + "/abc.zip",
                    "https://www.nseindia.com/content/historical/EQUITIES/2017/JUN/cm05JUN2017bhav.csv.zip");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void saveFileFromURL(String fileName, String fileUrl)
            throws IOException {

        BufferedInputStream in = null;
        FileOutputStream fout = null;
        try {
            in = new BufferedInputStream(new URL(fileUrl).openStream());
            fout = new FileOutputStream(fileName);

            byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }
        } finally {
            if (in != null)
                in.close();
            if (fout != null)
                fout.close();
        }
    }

}