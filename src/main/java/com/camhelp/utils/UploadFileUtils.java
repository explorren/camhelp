package com.camhelp.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jupiter on 2017/8/3.
 */

public class UploadFileUtils {

    public static List<String> uploadFile(List<MultipartFile> files,String filepathpart){

        MultipartFile file = null;
        BufferedOutputStream stream = null;

       // String filePath = "C:\\database\\apache-tomcat-8.5.14\\webapps\\camhelp"+filepathpart+"\\";
        String filePath="E://test//"+filepathpart+"//";
        String newfilePath;

        List<String> list=new ArrayList<>();
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);

            newfilePath=filePath+ DateConvertUtils.GetNowTimeToString()+file.getOriginalFilename();


            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();

                    File file1= new File(newfilePath);

                    if (!file1.getParentFile().exists()) {
                        file1.getParentFile().mkdirs();
                    }

                    stream = new BufferedOutputStream(new FileOutputStream(
                           file1));


                    stream.write(bytes);
                    stream.close();

                } catch (Exception e) {
                    stream = null;
                 /*   return "You failed to upload " + i + " => "
                            + e.getMessage();*/
                }
            } else {
               /* return "You failed to upload " + i
                        + " because the file was empty.";*/
            }
            list.add(newfilePath);
        }

        return list;
    }

}

