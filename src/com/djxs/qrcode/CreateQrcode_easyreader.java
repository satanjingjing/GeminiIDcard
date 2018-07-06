package com.djxs.qrcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;



public class CreateQrcode_easyreader {

	
	public static void main(String[] args) throws IOException {
		int ver=5;//假设版本号为5
		
		Qrcode qrcode=new Qrcode();
		qrcode.setQrcodeErrorCorrect('Q');
		qrcode.setQrcodeVersion(ver);//设置版本号
		
		int x=2;//假设加两个像素的白边
		int imagesize=67+12*(ver-1);//二维码大小
		
		BufferedImage bufferedimage=new BufferedImage(imagesize,imagesize,BufferedImage.TYPE_INT_RGB);//设置二维码大小
		Graphics2D gs1=bufferedimage.createGraphics();
		gs1.setBackground(Color.WHITE);
		gs1.setColor(Color.BLACK);
		gs1.clearRect(0,0,imagesize,imagesize);//与上面的bufferedimage的大小一样，不然会有黑边
        String str="张家口欢迎您！";//二维码扫出来的内容
        
        boolean[][] calQrcode=qrcode.calQrcode(str.getBytes());
        for (int i=0;i<calQrcode.length;i++){
        	for (int j=0;j<calQrcode.length;j++){
        		if(calQrcode[i][j]){

        		   gs1.fillRect(i*3+x,j*3+x,3,3);//(i*m+x,j*m+x,m,m)
        		  
        		}
        	}
        }

        gs1.dispose();
    	bufferedimage.flush();
    	ImageIO.write(bufferedimage,"png",new File("D:/djxsQrcode/qrcodeeasy.png"));
	}
}
