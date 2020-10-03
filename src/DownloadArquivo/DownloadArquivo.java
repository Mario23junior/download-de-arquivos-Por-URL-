package DownloadArquivo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DownloadArquivo {
    
	public static void main(String[] args) {
		
		final String HttpFile = "https://telescopiohubble.com.br/wp-content/uploads/2019/04/56913358_2115394191872168_491140904845836288_n.jpg";
		final String localFile = "/home/alienmj/imgJava/imgAplication.jpg";
		
		try {
			URL website = new URL(HttpFile);
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream(localFile);
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			fos.close();
			rbc.close();
		}catch (IOException e ){
			e.printStackTrace();
		}
	}
	
}
