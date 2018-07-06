package com.djxs.qrcode;
import java.io.IOException;

import com.djxs.util.*;
public class CreatQrcodeTest {
    public static void main(String[]args) throws IOException{
    	QrcodeTest.CreateQrcode(5, 'Q', "http://www.4399.com/", "D:/djxsQrcode/logo.jpg", 25, "D:/djxsQrcode/qrgame.png", "30,106,230", "151,80,180");
    }
}
