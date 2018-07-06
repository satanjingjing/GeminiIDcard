/*package com.djxs.qrcode;


import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Base64ImageUtil {

	public static String getImageBinary(String filename){
    	  File f=new File(filename);
    	  BufferedImage bi;
    	  try{
    		 bi=ImageIO.read(f);
    		 ByteArrayOutputStream baos=new ByteArrayOutputStream();
    		 ImageIO.write(bi,"jpg", baos);
    		 byte[] bytes=baos.toByteArray();
    		 return new String(Base64.encodeBytes(bytes));
    	  }catch(IOException e){
    		  e.printStackTrace();
    	  }
    	  return null;
      }
}*/
