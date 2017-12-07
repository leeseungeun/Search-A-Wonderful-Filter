package com.SWF.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class FileSave {
	
	public void saveAsFile(String location,String text) throws Exception{
		
		File file = new File(location);
		file.createNewFile();
		
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getAbsolutePath()),"UTF-8"));
		
		output.write(text);
		output.close();
		
	}
	
}
