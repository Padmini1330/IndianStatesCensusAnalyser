package IndianStatesCensusAnalyser;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest 
{
	private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndianStatesCensus.csv";
	private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndianStatesCensus.csv";
	private static final String INCORRECT_FILE_FORMAT = "./src/test/resources/CensusDataInWrongFormat.txt";
	private static final String CSV_WITH_WRONG_DELIMITER = "./src/test/resources/CensusDataWithWrongDelimiter.csv";
	private static final String CSV_WITH_INCORRECT_HEADER = "./src/test/resources/CensusDataIncorrectHeader.csv";
	
	private static final String INDIAN_STATE_CODES = "./src/test/resources/IndianStateCodes.csv";
	private static final String INDIAN_STATE_CODES_WITH_WRONG_FILEPATH = "./src/main/resources/IndianStateCodes.csv"; 	
	private static final String INDIAN_STATE_CODES_WITH_WRONG_FILE_FORMAT = "./src/test/resources/IndianStateCodesWithWrongFormat.txt";
	private static final String INDIAN_STATE_CODES_WITH_WRONG_DELIMITER = "./src/test/resources/IndianStateCodesWithWrongDelimiter.csv";
	private static final String INDIAN_STATE_CODES_WITH_WRONG_HEADER = "./src/test/resources/IndianStateCodesWithWrongHeader.csv";
	
	
  	StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
	ExpectedException exceptionRule = ExpectedException.none();
  	
    @Test
    public void givenStateCensusCSVFile_ShouldReturn_CorrectNumberOfRecords() 
    {
        try 
        {
            int numOfRecords = censusAnalyser.loadIndianCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(5,numOfRecords);
        } 
        catch (CensusAnalyserException e) 
        { 
        	e.printStackTrace();
        }
    }
    
    @Test
	public void givenStateCensusCSVFile_WhenIncorrect_ShouldThrowException() 
    {
		try 
		{
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndianCensusData(WRONG_CSV_FILE_PATH);
		} 
		catch (CensusAnalyserException e) 
		{
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
			e.printStackTrace();
		}
	}
    
    @Test
    public void givenStateCensusCSVFile_WhenCorrectButWrongFileFormat_ShouldThrowException() 
    {
		try 
		{
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndianCensusData(INCORRECT_FILE_FORMAT);
		} 
		catch (CensusAnalyserException e) 
		{
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT, e.type);
			e.printStackTrace();
		}
    }
    
    @Test
    public void givenStateCensusCSVFile_WhenCorrectButDelimiterIncorrect_ShouldThrowException() 
    {
		try 
		{
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndianCensusData(CSV_WITH_WRONG_DELIMITER);
		} 
		catch (CensusAnalyserException e) 
		{
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_HEADER, e.type);
			e.printStackTrace();
		}
    }
    
    @Test
    public void givenStateCensusCSVFile_WhenCorrectButHeaderIncorrect_ShouldThrowException() 
    {
		
		try 
		{
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndianCensusData(CSV_WITH_INCORRECT_HEADER);
		} 
		catch (CensusAnalyserException e) 
		{
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_HEADER, e.type);
			e.printStackTrace();
		}
    }
    
    @Test
    public void givenIndianStateCodeCSVFile_ShouldReturn_CorrectNumberOfRecords() 
    {
        try 
        {
            int numOfRecords = censusAnalyser.loadIndianStateCode(INDIAN_STATE_CODES);
            Assert.assertEquals(5,numOfRecords);
        } 
        catch (CensusAnalyserException e) 
        { 
        	e.printStackTrace();
        }
    }
    
    @Test
	public void givenIndianStateCodeCSVFile_WhenIncorrect_ShouldThrowException() 
    {
		try 
		{
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndianStateCode(INDIAN_STATE_CODES_WITH_WRONG_FILEPATH);
		} 
		catch (CensusAnalyserException e) 
		{
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
			e.printStackTrace();
		}
	}
    
    @Test
    public void givenIndianStateCodeCSVFile_WhenCorrectButWrongFileFormat_ShouldThrowException() 
    {
		try 
		{
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndianStateCode(INDIAN_STATE_CODES_WITH_WRONG_FILE_FORMAT);
		} 
		catch (CensusAnalyserException e) 
		{
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT, e.type);
			e.printStackTrace();
		}
    }
    
    @Test
    public void givenIndianStateCodeCSVFile_WhenCorrectButDelimiterIncorrect_ShouldThrowException() 
    {
		try 
		{
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndianStateCode(INDIAN_STATE_CODES_WITH_WRONG_DELIMITER);
		} 
		catch (CensusAnalyserException e) 
		{
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_HEADER, e.type);
			e.printStackTrace();
		}
    }
    
    @Test
    public void givenIndianStateCodeCSVFile_WhenCorrectButHeaderIncorrect_ShouldThrowException() 
    {
		try 
		{
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndianStateCode(INDIAN_STATE_CODES_WITH_WRONG_HEADER);
		} 
		catch (CensusAnalyserException e) 
		{
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_HEADER, e.type);
			e.printStackTrace();
		}
    }
    
}
