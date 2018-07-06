package com.djxs.qrcode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.djxs.util.MyQrcodeImage;

import jp.sourceforge.qrcode.QRCodeDecoder;

public class QrcodeReader {
     public static void main(String []args) throws IOException{
    	 File file=new File("D:/djxsQrcode/qrcodeeasy.png");
    	 BufferedImage bufferedimage=ImageIO.read(file);
    	 QRCodeDecoder qrcodedecoder=new QRCodeDecoder();
    	 byte[] bytes=qrcodedecoder.decode( new MyQrcodeImage(bufferedimage));
    	 String result=new String (bytes);
    	 System.out.println(new String(result));
     }
}
