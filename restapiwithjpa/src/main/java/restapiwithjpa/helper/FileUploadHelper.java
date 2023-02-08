package restapiwithjpa.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

//	public final String UPLOAD_DIR="C:\\Users\\ASUS\\Documents\\workspace-spring-tool-suite-4-4.17.0.RELEASE\\"
//			+ "restapiwithjpa\\src\\main\\resources\\static\\image";
//	
	
	public final String UPLOAD_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	public FileUploadHelper() throws IOException
	{
		
	}
	
	
	public boolean uploadFile(MultipartFile multipart)
	{
		boolean f=false;
		
		try {
			
		// Reading data
//		InputStream is= multipart.getInputStream();
//		byte data[]= new byte[is.available()];
//		is.read(data);
//		// write we can also use File.seperator in the place of \\
//		FileOutputStream fos= new FileOutputStream(UPLOAD_DIR+ File.separator +multipart.getOriginalFilename());
//		fos.write(data);
//		
//		fos.flush();
//		fos.close();
			
	   Files.copy(multipart.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + multipart.getOriginalFilename()));
	
		f=true;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
}
