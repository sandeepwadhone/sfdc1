package log4jAI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;

public class FileDecryptionExample {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\ACER\\Documents\\Sandeep docs\\sandeep java code docs\\sfdc\\encrypted.txt"; // Path to the input encrypted file
        String outputFile = "C:\\Users\\ACER\\Documents\\Sandeep docs\\sandeep java code docs\\sfdc\\decrypted.txt"; // Path to the output decrypted file

        try {
            // Generate RSA key pair
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            // Initialize the cipher with the private key for decryption
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            // Open the input and output streams
            try (InputStream inputStream = new FileInputStream(inputFile);
                 OutputStream outputStream = new FileOutputStream(outputFile)) {

                // Decrypt the file
                byte[] inputBuffer = new byte[256]; // Maximum size for RSA decryption
                int bytesRead;
                while ((bytesRead = inputStream.read(inputBuffer)) != -1) {
                    byte[] decryptedBytes = cipher.doFinal(inputBuffer, 0, bytesRead);
                    outputStream.write(decryptedBytes);
                }
            }

            System.out.println("File decrypted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
