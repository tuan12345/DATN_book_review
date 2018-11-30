package app.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	public static File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException 
	{
	    File convFile = new File( multipart.getOriginalFilename());
	    multipart.transferTo(convFile);
	    return convFile;
	}
}
