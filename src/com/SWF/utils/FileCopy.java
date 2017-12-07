package com.SWF.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	
	FileInputStream input = null;
    FileOutputStream output = null;

	public void fileCopy(String orgFilePath, String newFilePath) {
		try{
            File file = new File(orgFilePath);
             
            input = new FileInputStream(file);
            output = new FileOutputStream(new File(newFilePath));
                         
            int readBuffer = 0;
            byte [] buffer = new byte[512];
            while((readBuffer = input.read(buffer)) != -1) {
                output.write(buffer, 0, readBuffer);
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try{
                input.close();
                output.close();
            } catch(IOException io) {}
        }
    }

}
