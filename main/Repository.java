package com.erpbackend.production;

	import java.sql.SQLException;
	import java.util.Arrays;
	import java.util.List;

	public class Repository {
		//for git push
	    public List<String> getStuff() throws SQLException {
	        // Execute Query

	        // Return results
	        return Arrays.asList("One", "Two", "Three");
	    }
}
