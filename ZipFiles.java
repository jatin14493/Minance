package Minance;
import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class ZipFiles {

    public static void main(String[] args) {
        String zipFilePath = "";

        //Zip Files will be downloaded to this directory
        String destDir = "/Users/B0205328/Desktop/testing";

        //csv files will be stored here
        String csvDestDir = "/Users/B0205328/Desktop/testing/csv/";


        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("yyyy-MMM-dd'T'HH:mm:ss'Z'");

        LocalDateTime now = LocalDateTime.now();


        for(int i=1 ; i<365 ; i++){

            String day ="",month ="", year="";
            LocalDateTime then = now.minusDays(i);
            int d = then.getDayOfMonth();

            if(d < 10)
                day = "0"+d;
            else
                day = d + "";

            month = then.getMonth().toString().substring(0,3);
            year = then.getYear() +"";


            try {
                String fileUrl = "https://www.nseindia.com/content/historical/EQUITIES/"+year+"/"+month+"/cm"+day+month+year+"bhav.csv.zip";
                zipFilePath = destDir + "/day_"+i + "_.csv.zip";
                saveFileFromURL(destDir + "/day_"+i + "_.csv.zip",
                        fileUrl);

                unzip(zipFilePath, csvDestDir);

            }  catch (IOException e) {
                System.out.println("Exception in downloading ith File");
            }




            System.out.println(i + " Files processed successfully");

        }


    }

    private static void unzip(String zipFilePath, String destDir) {
        File dir = new File(destDir);
        // create output directory if it doesn't exist
        if(!dir.exists()) dir.mkdirs();
        FileInputStream fis;
        //buffer for read and write data to file
        byte[] buffer = new byte[1024];
        try {
            fis = new FileInputStream(zipFilePath);
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry ze = zis.getNextEntry();
            while(ze != null){
                String fileName = ze.getName();
                File newFile = new File(destDir + File.separator + fileName);
                System.out.println("Unzipping to "+newFile.getAbsolutePath());
                //create directories for sub directories in zip
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                //close this ZipEntry
                zis.closeEntry();
                ze = zis.getNextEntry();
            }
            //close last ZipEntry
            zis.closeEntry();
            zis.close();
            fis.close();
        } catch (IOException e) {

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
