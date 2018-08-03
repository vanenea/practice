package com.chen.io;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipDemo {

	public static void main(String[] args) {
		Charset cs = Charset.forName("UTF-8");
		System.out.println("指定的字符集:"+cs);
		try {
			CheckedOutputStream cos = new CheckedOutputStream(new FileOutputStream("test.zip"), new Adler32());
			ZipOutputStream zos = new ZipOutputStream(cos,cs);
			BufferedOutputStream bos = new BufferedOutputStream(zos);
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(bos));
			zos.setComment("test java zip");
			
			BufferedReader br = new BufferedReader(new FileReader("README.md"));
			zos.putNextEntry(new ZipEntry("README.md"));
			String i = null;
			while((i=br.readLine())!=null) {
				//bos.write(i);
				System.out.println(i);
				pw.println(i);
			}
			br.close();
			bos.flush();
			//bos.close();
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
