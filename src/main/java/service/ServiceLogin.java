package service;

import model.Login;
import model.User;
import dao.DAOLogin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class ServiceLogin {
	public static User sessionVar = null;
	
	public static boolean checkCredentials(Login credential){
		
		User user = DAOLogin.getUserByCredential(credential.getEmail());
		
		if(user!=null){			
			String salt = user.getLogin().getSalt();		
			String saltedPwd = generateSecurePassword(credential.getSafePassword(), salt);			

			if(user.getLogin().getSafePassword().equals(saltedPwd)){
				sessionVar = user;
				return true;
			}
		}
		
		System.out.println("false");
		return false;
	}
	
	public static String generateSalt() throws NoSuchAlgorithmException
	{
	    //Always use a SecureRandom generator
	    SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
	    //Create array for salt
	    byte[] salt = new byte[16];
	    //Get a random salt
	    sr.nextBytes(salt);
	    //return salt
	    return salt.toString();
	}

    public static String generateSecurePassword(String passwordToHash, String salt)
    {
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(salt.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest(passwordToHash.getBytes());
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
	
}
