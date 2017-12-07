package com.SWF.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class FileUploadUtil {

	public static String uploadAttFile(String uploadPath, String filenmclient, byte[] fileData) throws Exception{
		
		UUID uid = UUID.randomUUID();
		
		String filenmserver = uid.toString()+"_"+filenmclient;
		
		String savedPath = calcPath(uploadPath);
		
		File target = new File(uploadPath+savedPath, filenmserver);
		FileCopyUtils.copy(fileData, target);
		
		String strsavedPath = savedPath.replace(File.separatorChar, '/');
		
		String resultset = strsavedPath+'/'+filenmserver;
		
		return resultset;
		
	}
	
	private static String calcPath(String uploadPath){
		
		Calendar cal = Calendar.getInstance();
		
		String yearPath = File.separator+cal.get(Calendar.YEAR);
		String monthPath = yearPath+File.separator+new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		String datePath = monthPath+File.separator+new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		makeDir(uploadPath, yearPath, monthPath, datePath);
		
		return datePath;
		
	}
	
	private static void makeDir(String uploadPath, String ... paths){
		
		if(new File(paths[paths.length-1]).exists()){
			return;
		}
		
		for(String path : paths){
			
			File dirPath = new File(uploadPath + path);
			
			if(!dirPath.exists()){
				
				dirPath.mkdirs();
				
			}
			
		}
		
	}
	
}
