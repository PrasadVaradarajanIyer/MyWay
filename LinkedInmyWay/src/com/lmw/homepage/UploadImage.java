package com.lmw.homepage;
import javax.faces.bean.ManagedBean;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.Part;
import javax.faces.bean.SessionScoped;

@ManagedBean

public class UploadImage {
	private Part image;
	
	public void doUpload()
	{
		try {
			InputStream in = image.getInputStream();
			File f = new File("../../../WebContent/resources/images/"+image.getName());
			f.createNewFile();
			//File f1 = new File("../../../WebContent/resources/images/Urban.jpg");
			//f.renameTo(f1);
			FileOutputStream out = new FileOutputStream(f);
			
			byte[] buffer = new byte [1024];
			int length;
			
			while((length=in.read(buffer))>0){
				out.write(buffer, 0, length);
			}
			out.close();
			in.close();
			
		} catch (IOException e) {
			System.out.println("Your upload did not work");
		}
		
	}
	
	

	public Part getImage() {
		return image;
	}

	public void setImage(Part image) {
		this.image = image;
	}
	
	
	

}
