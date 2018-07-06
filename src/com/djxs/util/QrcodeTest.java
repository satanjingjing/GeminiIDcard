package com.djxs.util;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.swetake.util.Qrcode;
public class QrcodeTest {
	
	

		
		public static void CreateQrcode(int ver,char qrcodeErrorCorrect,String str,String logoPath,int logosize,String qrcodeimagepaht,String startcolor,String endcolor) throws IOException {
			
			
			Qrcode qrcode=new Qrcode();
			qrcode.setQrcodeErrorCorrect(qrcodeErrorCorrect);
			qrcode.setQrcodeVersion(ver);//���ð汾��
			/*��ά���С�����ұ�׼��
			 * ver = 1 , imagesize=21
			 * ver = 2 , imagesize=25
			 * ver = 3 , imagesize=29
			 * ver = n , imagesize=21+(ver-1)*4
			 * ��ÿһλ��mλ���ص��ʾʱ��Ĭ��һλ����
			 * imagesize=(21+(ver-1)*4)*m
			 * ���ı߼�x�����صİױ�ʱ����Ĭ�ϲ��ӣ���
			 *imagesize=((21+x*2)+(ver-1)*4)*m
			 */
			int x=2;//������������صİױ�
			int imagesize=67+12*(ver-1);//��ά���С
			
			BufferedImage bufferedimage=new BufferedImage(imagesize,imagesize,BufferedImage.TYPE_INT_RGB);//���ö�ά���С
			Graphics2D gs1=bufferedimage.createGraphics();
			gs1.setBackground(Color.WHITE);
			gs1.setColor(Color.BLACK);
			gs1.clearRect(0,0,imagesize,imagesize);//�������bufferedimage�Ĵ�Сһ������Ȼ���кڱ�
	        
	        
	        int startR=Integer.parseInt(startcolor.split(",")[0]);
	        int startG=Integer.parseInt(startcolor.split(",")[1]);
	        int startB=Integer.parseInt(startcolor.split(",")[2]);
	        
	        int endR=Integer.parseInt(endcolor.split(",")[0]);
	        int endG=Integer.parseInt(endcolor.split(",")[1]);
	        int endB=Integer.parseInt(endcolor.split(",")[2]);
	        boolean[][] calQrcode=qrcode.calQrcode(str.getBytes());
	       
	        for (int i=0;i<calQrcode.length;i++){
	        	for (int j=0;j<calQrcode.length;j++){
	        		if(calQrcode[i][j]){
	        		   /*x=��ʼֵ+������ֵ-��ʼֵ��*����/����
	        			*                   j+1       ������       ���䣩
	        			*                   i+1       ������       ���䣩
	        			*                  (i+j)/2�����Խ��߽��䣩
	        			*/ 
	        		
	        		   int num1=startR+(endR-startR)*(i+1)/calQrcode.length;
	        		   int num2=startG+(endG-startG)*(j+1)/calQrcode.length;
	        		   int num3=startB+(endB-startB)*(j+1)/calQrcode.length;
	        		
	        		   Color color1= new Color(num1,num2,num3);
	        		   gs1.setColor(color1);
	        		   gs1.fillRect(i*3+x,j*3+x,3,3);//(i*m+x,j*m+x,m,m)
	        		  
	        		}
	        	}
	        }
	        Image logo=ImageIO.read(new File(logoPath));
	        int logox=(imagesize-logosize)/2;
	        gs1.drawImage(logo,logox, logox, logosize, logosize, null);
	        gs1.dispose();
	    	bufferedimage.flush();
	    	ImageIO.write(bufferedimage,"png",new File(qrcodeimagepaht));
		}
	}

