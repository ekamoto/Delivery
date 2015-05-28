package crypt;

import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import sun.misc.BASE64Encoder;

public class FileCrypt {  
    
    public static final int CRIPTOGRAFAR = 0;  
    public static final int DESCRIPTOGRAFAR = 1;  
      
    private static byte[] salt = {  
        (byte)0xA9, (byte)0x9B,  
        (byte)0xC8, (byte)0x32,  
        (byte)0x56, (byte)0x35,  
        (byte)0xE3, (byte)0x03  
    };  
      
    private static int iteration = 5;  
    static final int TAMANHO_BUFFER = 32768; //32kb  
    byte[] buf = new byte[TAMANHO_BUFFER];  
      
    SecretKey key = null;  
      
    public FileCrypt(String senha) {  
        try {  
            //Cria a chave criptografica baseada na senha passada  
            KeySpec keySpec = new PBEKeySpec(senha.toCharArray(), salt, iteration);  
            //Transforma a senha String em uma chave opaca  
            key = SecretKeyFactory.getInstance(  
                    "PBEWithMD5AndDES").generateSecret(keySpec);  
        } catch(Exception e) {  
              
            e.printStackTrace();  
        }  
    }  
        
    public FileCrypt() {  
        super();  
    }  
      
    public Boolean criptografa(InputStream in, OutputStream out) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {  
        try {  
  
            Cipher cifra = Cipher.getInstance(key.getAlgorithm());  
            AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iteration);  
            cifra.init(Cipher.ENCRYPT_MODE, key, paramSpec);  
              
            out = new CipherOutputStream(out, cifra);              
  
            int numRead = 0;  
  
            while ((numRead = in.read(buf, 0, TAMANHO_BUFFER)) >= 0) {  
                    out.write(buf, 0, numRead);  
                }  
                  
            out.close();  
              
            in.close();  
    
            return true;  
              
        } catch (Exception e) {  
            System.out.println("Erro ao ler os bytes. Motivo: "+e.getMessage());  
              
            return false;  
        }  
    }       
              
    public Boolean descriptografa(InputStream in, OutputStream out) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {  
      
          
        try {     
  
            Cipher cifra = Cipher.getInstance(key.getAlgorithm());  
            AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iteration);  
            cifra.init(Cipher.DECRYPT_MODE, key, paramSpec);   
              
            out = new CipherOutputStream(out, cifra);              
  
            int numRead = 0;  
  
            while ((numRead = in.read(buf, 0, TAMANHO_BUFFER)) >= 0) {
            	
	            out.write(buf, 0, numRead);
            }  
                  
                out.close();  
                  
                in.close();  
               
                return true;  
               
        } catch (Exception e) {  
            System.out.println("Erro ao ler os bytes. Motivo: "+e.getMessage());  
            return false;  
        }     
    }  
    
/*     
    public void trataDiretorio(String diretorio, int operacao) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException { 
        File dir = new File(diretorio); 
        if(dir.isDirectory()) { 
            File [] arquivos = dir.listFiles(); 
            for (int i = 0; i < arquivos.length; i++) { 
                if(arquivos<i>.isFile()) { 
                    if(operacao == FileCrypt.CRIPTOGRAFAR) { 
                        this.criptografa(arquivos<i>.getAbsolutePath()); 
                    } else if(operacao == FileCrypt.DESCRIPTOGRAFAR) { 
                        this.descriptografa(arquivos<i>.getAbsolutePath()); 
                    } else { 
                        throw new IllegalArgumentException("Invalid Operation."); 
                    } 
                } else if(arquivos<i>.isDirectory()) { 
                    trataDiretorio(arquivos<i>.getAbsolutePath(), operacao); 
                } 
            } 
        } 
    } 
 */     
    public static String encriptaSenha (String senha) {       
        try {       
             MessageDigest digest = MessageDigest.getInstance("MD5");        
             digest.update(senha.getBytes());        
             BASE64Encoder encoder = new BASE64Encoder ();        
             return encoder.encode (digest.digest ());        
        } catch (NoSuchAlgorithmException ns) {       
             ns.printStackTrace ();        
             return senha;        
        }        
   }        
}  
