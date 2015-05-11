package com.rubrica.DL;

import java.io.File;

/**
 * DataConstants interface provides all the constants required from Reader 
 * and Writer classes.
 * @author Alessandro Giordano
 *
 */
public interface DataConstants {

	//path constant
	public static final String PATH = "rubrica_data" + File.separator + "informazioni.txt";

	//MessageDialog constant messages
	public static final String INFO_MESSAGE = "retrieving.data?";
	
	public static final String WRITE_FAILURE = "exception.occurred.while.writing.data";
	public static final String WRITER_FAILURE = "exception.occurred.while.initializing.writer";
	public static final String WRITE_FAILURE_CLOSE = "exception.occurred.while.closing.writing.resource";
	
	public static final String READ_FAILURE = "exception.occurred.while.retrieving.data";
	public static final String READER_FAILURE = "exception.occurred.while.initializing.reader";
	public static final String READ_FAILURE_CLOSE = "exception.occurred.while.closing.reading.resource";
	
	//FileOutputStream constructor initialization constants
	public static final boolean SET_TO_APPEND = true;
	public static final boolean SET_TO_OVERWRITE = false;
	
	//The pattern that represents a new line, used as delimiter for each record
	public static final String LINE_SEPARATOR_PATTERN = "\r\n|[\r\n\u2028\u2029\u0085]";

}
