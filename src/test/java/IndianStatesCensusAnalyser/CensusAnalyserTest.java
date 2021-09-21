package IndianStatesCensusAnalyser;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest 
{
	private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
  	private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
  	private static final String INDIAN_CSV_STATE_PATH="./src/test/resources/IndiaStateCode.csv";
  	private static final String INCORRECT_FILE_FORMAT = "./src/test/resources/CensusDataInWrongFormat.txt";
  	
  	StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
	ExpectedException exceptionRule = ExpectedException.none();
  	
    @Test
    public void givenStateCensusCSVFile_ShouldReturn_CorrectNumberOfRecords() 
    {
        try 
        {
            int numOfRecords = censusAnalyser.loadIndianCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29,numOfRecords);
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
    
}
