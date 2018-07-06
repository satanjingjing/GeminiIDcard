package com.djxs.util;

import java.awt.image.BufferedImage;

import jp.sourceforge.qrcode.data.QRCodeImage;

public class MyQrcodeImage implements QRCodeImage{
	 private BufferedImage bufferedimage;
	 public MyQrcodeImage(BufferedImage bufferedimage){
		    this.bufferedimage=bufferedimage;
	 }
     public int getHeight(){
    	 return bufferedimage.getHeight();
     }
     public int getPixel(int arg0,int arg1){
    	 return bufferedimage.getRGB(arg0, arg1);
     }
     public int getWidth(){
    	 return bufferedimage.getWidth();
     }
}
