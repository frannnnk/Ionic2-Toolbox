package com.franks.ionic;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.text.WordUtils;

public class Ionic2Tools {
	
	public static void main(String[] args) throws IOException {
		generatePagesForAppModule();
	}
	public static void generatePagesForAppModule() throws IOException {
		System.out.println("Please enter the dir of your pages: (ends with slash / )");
		BufferedReader cin = new BufferedReader( new InputStreamReader( System.in ) ); 
		String keyIn = cin.readLine();
		
		File pagesDir = new File(keyIn);
		Collection<File> files = FileUtils.listFiles(pagesDir, new String[]{"html"}, true);
		
		for (File file : files) {
			//System.out.println(file.getAbsolutePath());
			System.out.println("import { "+ WordUtils.capitalize(FilenameUtils.removeExtension(file.getName()) )+"Page } from '../pages/"+FilenameUtils.removeExtension(file.getAbsolutePath().split("/pages/")[1])+"';");
		}
		
		System.out.println("declarations: [");
		for (File file : files) {
			//System.out.println(file.getAbsolutePath());
			System.out.println(" 	"+WordUtils.capitalize(FilenameUtils.removeExtension(file.getName()) )+"Page,");
		}
		System.out.println(" 	MyApp");
		System.out.println("],");
		System.out.println("entryComponents: [");
		for (File file : files) {
			//System.out.println(file.getAbsolutePath());
			System.out.println(" 	"+WordUtils.capitalize(FilenameUtils.removeExtension(file.getName()) )+"Page,");
		}
		System.out.println(" 	MyApp");
		System.out.println("],");
		
		
		
		
	}

}
