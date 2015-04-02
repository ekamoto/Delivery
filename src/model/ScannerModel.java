package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.StringCharacterIterator;

public class ScannerModel {
	
	private static String input;
	private StringCharacterIterator inputIt;
	 
	public ScannerModel (String fileName)
	{
		File inputFile = new File(fileName);
		
		FileReader fr = null;
		
		try {
			fr = new FileReader(inputFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
         
        int size = (int)inputFile.length();
        char[] buffer = new char[size];
        
        try
        {
        	fr.read(buffer, 0, size);
            input = new String(buffer);
            inputIt = new StringCharacterIterator(input);
            fr.close();
        }
        catch(FileNotFoundException e)
	    {
        
	    }
	    catch(IOException e)
	    {
        
	    }
        
        // utilize as funcoes abaixo (e outras que achar
        // necessario, para a leitura e manipulacao
        // dos dados armazenados no buffer
                              
        if (inputIt.getIndex() < inputIt.getEndIndex()) 
        {
        	// devolve o caractere "corrente" 
            inputIt.current();
            // le o proximo caractere
            inputIt.next();
        }
	}
	
}
