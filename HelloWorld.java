package log4jAI;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class HelloWorld {

	private static final Logger logger = LogManager.getLogger(HelloWorld.class);

	public static void main(String[] args) {
		
		logger.info(" ");
		logger.info(" ************** start of the code " + LocalDateTime.now() + "***********");
		logger.info("Hello world");
		logger.error("we are in logger info mode");
		logger.trace("Hello world");
		logger.fatal("Hello world");
		
		String inputFile = "C:\\Users\\ACER\\Documents\\Sandeep docs\\sandeep java code docs\\sfdc\\plaintext.txt"; // Path to the input plaintext file
        String encryptedFile = "C:\\Users\\ACER\\Documents\\Sandeep docs\\sandeep java code docs\\sfdc\\encrypted.txt"; // Path to the output encrypted file
        String decryptedFile = "C:\\Users\\ACER\\Documents\\Sandeep docs\\sandeep java code docs\\sfdc\\decrypted.txt"; // Path to the output decrypted file

        logger.info("inputFile: " + inputFile);
        logger.info("encryptedFile: " + encryptedFile);
        logger.info("decryptedFile: " + decryptedFile);
        
        String secretKey = "MySecretKey12345"; // Secret key for encryption
        FileEncryption fileEncryption = new FileEncryption();
        
     // file encryption one time activity
        try {
            // Encrypt the file
        	fileEncryption.encryptFile(inputFile, encryptedFile, secretKey);
        	logger.info("File encryption completed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
     // file decryption 
        try {
           // Decrypt the file
        	//byte[] encryptedContent = fileEncryption.decryptFile(encryptedFile, decryptedFile, secretKey);
        	 // Convert decrypted byte array to ArrayList<Byte>
            List<Byte> decryptedList = fileEncryption.decryptFile(encryptedFile, decryptedFile, secretKey);
            System.out.println("TTTT");
            if (decryptedList != null) {
                // Iterate over the decrypted data byte by byte
                for (Byte b : decryptedList) {
                    byte decryptedByte = b.byteValue();
                    // Process each decrypted byte here
                    System.out.println(">>" + decryptedByte);
                }
            }
        	

        	logger.info("File decryption completed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
		
		
		
		

		logger.info(" ************** end of the code "+ LocalDateTime.now() + " ***********");
		logger.info(" ");

	}

}