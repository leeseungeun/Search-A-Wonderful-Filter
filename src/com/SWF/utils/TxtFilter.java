package com.SWF.utils;

import java.io.File;
import java.io.FileFilter;

public class TxtFilter implements FileFilter{

	public boolean accept(File file) {
        return file.toString().endsWith(".txt");
	}
}
