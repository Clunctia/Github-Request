package com.kamontat.model.management;

import com.kamontat.constant.FileExtension;

import java.io.*;
import java.util.*;

/**
 * this class is file api you can easy to use in many way this class contain some of method but all of them is static method so you don't need to assign everything to use it
 *
 * @author kamontat
 * @version 1.1
 * @since 1/25/2017 AD - 8:44 PM
 */
public class FileUtil {
	/**
	 * get file extension (enum {@link FileExtension}) by using file parameter
	 *
	 * @param f
	 * 		file to search extension
	 * @return extension
	 */
	public static FileExtension getExtension(File f) {
		return FileExtension.getExtension(getStringExtension(f));
	}
	
	/**
	 * get all data separate each by line (To use this method you might need plain text file). <br>
	 * you can get line count by using {@link ArrayList#size()}. <br>
	 * <b>Warning: </b> this cass have some exception that not handle so you might do some thing with it
	 *
	 * @param f
	 * 		reading file
	 * @return array of information or content in the file
	 */
	public static ArrayList<String> getContentByLine(File f) {
		ArrayList<String> output = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = "";
			while ((line = br.readLine()) != null) {
				output.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	/**
	 * get file extension (String {@link String}) of file in parameter
	 *
	 * @param f
	 * 		file
	 * @return string of extension <b>WITHOUT dot(.)</b>
	 */
	public static String getStringExtension(File f) {
		return f.getName().substring(f.getName().indexOf(".") + 1, f.getName().length()).toLowerCase();
	}
}
