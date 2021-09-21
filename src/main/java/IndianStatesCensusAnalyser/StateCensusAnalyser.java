package IndianStatesCensusAnalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import IndianStatesCensusAnalyser.CensusAnalyserException.ExceptionType;

public class StateCensusAnalyser 
{
	 public int loadIndianCensusData(String csvFilePath) throws CensusAnalyserException 
	 {

	    try 
	    {
	    	if(csvFilePath.contains(".txt")) 
	    	{
    			throw new CensusAnalyserException("File must be in CSV Format!", ExceptionType.CENSUS_INCORRECT_FILE_FORMAT);
    		}
    		Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
    		CsvToBeanBuilder<CSVStateCensus> csvToBeanBuilder = new CsvToBeanBuilder<CSVStateCensus>(reader);
    		csvToBeanBuilder.withType(CSVStateCensus.class);
    		csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
    		CsvToBean<CSVStateCensus> csvToBean = csvToBeanBuilder.build();
    		Iterator<CSVStateCensus> censusCSVIterator = csvToBean.iterator();
    		int numberOfEntries = 0;
    		while(censusCSVIterator.hasNext()) 
    		{
    			numberOfEntries++;
    			CSVStateCensus censusData = censusCSVIterator.next();
    		}
    		return numberOfEntries;		
	    }
	    catch(IOException e) 
	    {
	    	throw new CensusAnalyserException(e.getMessage(), ExceptionType.CENSUS_FILE_PROBLEM);
	    }
	    catch(RuntimeException e)
	    {
	    	throw new CensusAnalyserException(e.getMessage(), ExceptionType.CENSUS_WRONG_DELIMITER_OR_HEADER);
	    }
	    
	}
	 
	 public int loadIndianStateCode(String csvFilePath) throws CensusAnalyserException 
	 {
	    	
	        try 
	        {
	        	if(csvFilePath.contains(".txt")) 
	        	{
	        		throw new CensusAnalyserException("File must be in CSV Format!", ExceptionType.CENSUS_INCORRECT_FILE_FORMAT);
	        	}
	        	
	        	Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
	            CsvToBeanBuilder<CSVStates> csvToBeanBuilder = new CsvToBeanBuilder<CSVStates>(reader);
	            csvToBeanBuilder.withType(CSVStates.class);
	            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
	            CsvToBean<CSVStates> csvToBean = csvToBeanBuilder.build();
	            Iterator<CSVStates> stateCodesCSVIterator = csvToBean.iterator();
	            
	            int numberOfEntries = 0;
	    		while(stateCodesCSVIterator.hasNext()) 
	    		{
	    			numberOfEntries++;
	    			CSVStates censusData = stateCodesCSVIterator.next();
	    		}
	    		return numberOfEntries;
	        } 
	        catch (IOException e) 
	        {
	            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
	        } 
	        catch(RuntimeException e) 
	        {
	    		throw new CensusAnalyserException(e.getMessage(), ExceptionType.CENSUS_WRONG_DELIMITER_OR_HEADER);
	    	}
	    }
}
