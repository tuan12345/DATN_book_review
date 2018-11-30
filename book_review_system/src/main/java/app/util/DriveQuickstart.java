package app.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

public class DriveQuickstart {
	private static final String APPLICATION_NAME = "Google Drive API Java Quickstart";
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private static final String TOKENS_DIRECTORY_PATH = "tokens";

	/**
	 * Global instance of the scopes required by this quickstart. If modifying
	 * these scopes, delete your previously saved tokens/ folder.
	 */
	private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);
	private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

	/**
	 * Creates an authorized Credential object.
	 * 
	 * @param HTTP_TRANSPORT
	 *            The network HTTP Transport.
	 * @return An authorized Credential object.
	 * @throws IOException
	 *             If the credentials.json file cannot be found.
	 */
	private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
		// Load client secrets.
		InputStream in = DriveQuickstart.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

		// Build flow and trigger user authorization request.
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY,
				clientSecrets, SCOPES)
						.setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
						.setAccessType("offline").build();
		LocalServerReceiver receier = new LocalServerReceiver.Builder().setPort(8888).build();
		return new AuthorizationCodeInstalledApp(flow, receier).authorize("user");
	}

	public static Drive getService() throws GeneralSecurityException, IOException{
		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		return new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
				.setApplicationName(APPLICATION_NAME).build();
	}

	public static String saveToCloud(MultipartFile image) throws IllegalStateException, IOException, GeneralSecurityException{
		java.io.File filePath = FileUtil.multipartToFile(image);
		File fileMetadata = new File();
		String forderId = "1NdManbFOI2tli_1BC0AP41wWKISqDzqj";
		fileMetadata.setParents(Collections.singletonList(forderId));
		FileContent mediaContent = new FileContent("image/jpeg", filePath);
		File file = getService().files().create(fileMetadata, mediaContent).setFields("id")
				.execute();
		return file.getId();
	}
}