package edwin.com.Log;

import java.io.IOException;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App{

	   /* Get actual class name to be printed on */
	   //static Logger log = Logger.getLogger(App.class.getName());
	   private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	   public static void main(String[] args)throws IOException,SQLException{
		   LOGGER.debug("Hello this is a debug message");
		   LOGGER.info("Hello this is an info message");
	   }
	}