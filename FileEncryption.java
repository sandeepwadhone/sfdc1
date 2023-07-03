package log4jAI;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileEncryption {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\ACER\\Documents\\Sandeep docs\\sandeep java code docs\\sfdc\\plaintext.txt"; // Path to the input plaintext file
        String encryptedFile = "C:\\Users\\ACER\\Documents\\Sandeep docs\\sandeep java code docs\\sfdc\\encrypted.txt"; // Path to the output encrypted file
        String decryptedFile = "C:\\Users\\ACER\\Documents\\Sandeep docs\\sandeep java code docs\\sfdc\\decrypted.txt"; // Path to the output decrypted file

        String secretKey = "MySecretKey12345"; // Secret key for encryption

        try {
            // Encrypt the file
            //encryptFile(inputFile, encryptedFile, secretKey);

            // Decrypt the file
            //decryptFile(encryptedFile, decryptedFile, secretKey);

            System.out.println("File encryption and decryption completed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void encryptFile(String inputFile, String encryptedFile, String secretKey)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException,
            BadPaddingException, IllegalBlockSizeException {
        byte[] key = secretKey.getBytes();

        // Generate a secret key from the provided key
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");

        // Initialize the cipher for encryption
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        // Read the input file
        byte[] fileContent = Files.readAllBytes(Path.of(inputFile));

        // Encrypt the file content
        byte[] encryptedContent = cipher.doFinal(fileContent);

        // Write the encrypted content to the output file
        Files.write(Path.of(encryptedFile), encryptedContent, StandardOpenOption.CREATE);
    }

    List<Byte> decryptFile(String encryptedFile, String decryptedFile, String secretKey)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException,
            BadPaddingException, IllegalBlockSizeException {
        byte[] key = secretKey.getBytes();

        // Generate a secret key from the provided key
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");

        // Initialize the cipher for decryption
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

        // Read the encrypted file content
        byte[] encryptedContent = Files.readAllBytes(Path.of(encryptedFile));

        // Decrypt the file content
        byte[] decryptedContent = cipher.doFinal(encryptedContent);
        
        List<Byte> decryptedList = new ArrayList<>();
        for (byte b : encryptedContent) {
            decryptedList.add(b);
        }
        
        return decryptedList;

        // Write the decrypted content to the output file
        //Files.write(Path.of(decryptedFile), decryptedContent, StandardOpenOption.CREATE);
    }
}

