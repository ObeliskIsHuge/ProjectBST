/**  Test driver for BST generic.
 *
 *   This file (testDriver.java) should be in a directory, say testBST.
 *   There should be a subtree Minor/P2/DS, containing the precompiled
 *   file Monk.class (which is the actual test code).
 *
 *   Place your BST.java file in Minor/P2/DS and compile with the 
 *   command:   javac testDriver.java
 *
 *   This should compile both testDriver.java and BST.java.  Watch for
 *   error and warning messages.  Warnings about unsafe or unchecked
 *   operations can (most likely) be safely ignored.
 *
 *   Execute the test code:   java testDriver -prof
 *   This will randomize testing and write a bunch of log files, which
 *   you'll have to examine manually for errors (i.e., you'll have to 
 *   check results for errors by examining the output).
 *   If you want to repeat the previous random tests, execute the test
 *   code without the -prof switch.
 *
 *   You MUST use the -prof switch the first time, or if you have 
 *   deleted the file Seed.txt.
 *
 *   You'll also have to use version 1.8 of the JDK to compile this.
 */

import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import Minor.P2.DS.BST;
import Minor.P2.DS.Monk;

public class testDriver {
	
	public static void main( String[] args ) throws IOException {
		
		//System.out.println("args.length is " + args.length);
		String logName = new String("Summary.txt");
		boolean profMode = false;
		if ( args.length > 0 )
			profMode = true;
		if ( profMode ) {
			logName = "prof" + logName;
		}
		FileWriter Log;
		try {
			Log = new FileWriter(logName);
		}
		catch ( IOException e ) {
			System.out.println("Error creating log file: " + logName);
			System.out.println("Exiting...");
			return;
		}
		
		int numTestsPassed = 0;
		int numTestsRun    = 0;
		long randSeed = 0;
		if ( profMode ) {
			randSeed = System.currentTimeMillis();
			FileOutputStream f = new FileOutputStream("Seed.txt");
			DataOutputStream Seed = new DataOutputStream(f);
			Seed.writeLong(randSeed);
			Seed.close();
		}
		else {
			FileInputStream Seed = new FileInputStream("Seed.txt");
			DataInputStream Sd = new DataInputStream(Seed);
			randSeed = Sd.readLong();
			Seed.close();
		}
		//System.out.println("randSeed is " + randSeed);
		Monk M = new Monk( profMode, randSeed);
   	    String Prefix = null;
	    Prefix = M.writePoints(0);
		
		// wrap each test call in a try block to catch bad pointer exceptions locally
		try {
		   
		   try {
		      numTestsRun++;
	          if ( M.checkTreeInitialization() ) {
			     Log.write(Prefix + "Passed:  check of BST initialization.\n");
			     numTestsPassed++;
		      }
		      else {
			     Log.write(Prefix + "Failed:  check of BST initialization.\n");
			     Log.write(Prefix + "Aborting remainder of BST testing due to this error.\n");
				 Log.write(Prefix + "Passed " + numTestsPassed + " of " + numTestsRun + " tests executed.\n");
				 Log.close();
		      }
		   }
		   catch ( Exception e ) {
			  Log.write(Prefix + "Unexpected exception caught during test of BST initialization.\n");
			  Log.write(Prefix + "Likely cause would be a bad pointer.\n");
			  Log.write(Prefix + "Aborting remainder of BST testing due to this error.\n");
			  Log.write(Prefix + "Passed " + numTestsPassed + " of " + numTestsRun + " tests executed.\n");
			  Log.close();
			  return;
		   }
		   
		   try {
		      numTestsRun++;
		      if ( M.checkNodeInitialization() ) {
			     Log.write(Prefix + "Passed:  check of BinaryNode initialization.\n");
			     numTestsPassed++;
		      }
		      else {
			     Log.write(Prefix + "Failed:  check of BinaryNode initialization.\n");
			     Log.write(Prefix + "Aborting remainder of BST testing due to this error.\n");
				 Log.write(Prefix + "Passed " + numTestsPassed + " of " + numTestsRun + " tests executed.\n");
				 Log.close();
		      }
		   }
		   catch ( Exception e ) {
				  Log.write(Prefix + "Unexpected exception caught during test of BinaryNode initialization.\n");
				  Log.write(Prefix + "Likely cause would be a bad pointer.\n");
				  Log.write(Prefix + "Aborting remainder of BST testing due to this error.\n");
				  Log.write(Prefix + "Passed " + numTestsPassed + " of " + numTestsRun + " tests executed.\n");
				  Log.close();
				  return;
		   }
		
		   try {
		      numTestsRun++;
		      if ( M.checkInsertion() ) {
			     Log.write(Prefix + "Passed:  check of BST insertion.\n");
			     numTestsPassed++;
		      }
		      else {
			     Log.write(Prefix + "Failed:  check of BST insertion.\n");
			     Log.write(Prefix + "Aborting remainder of BST testing due to this error.\n");
				 Log.write(Prefix + "Passed " + numTestsPassed + " of " + numTestsRun + " tests executed.\n");
				 Log.close();
		      }
		   }
		   catch ( Exception e ) {
				  Log.write(Prefix + "Unexpected exception caught during test of BST insertion.\n");
				  Log.write(Prefix + "Likely cause would be a bad pointer.\n");
				  Log.write(Prefix + "Aborting remainder of BST testing due to this error.\n");
				  Log.write(Prefix + "Passed " + numTestsPassed + " of " + numTestsRun + " tests executed.\n");
				  Log.close();
				  return;
		   }
		   
		   try {
		      numTestsRun++;
		      if ( M.checkIsEmpty() ) {
			     Log.write(Prefix + "Passed:  check of BST isEmpty() function.\n");
			     numTestsPassed++;
		      }
		      else {
			     Log.write(Prefix + "Failed:  check of BST isEmpty() function.\n");
			     Log.write(Prefix + "Aborting remainder of BST testing due to this error.\n");
				 Log.write(Prefix + "Passed " + numTestsPassed + " of " + numTestsRun + " tests executed.\n");
				 Log.close();
		      }
		   }
		   catch ( Exception e ) {
				  Log.write(Prefix + "Unexpected exception caught during test of BST isEmpty() function.\n");
				  Log.write(Prefix + "Likely cause would be a bad pointer.\n");
				  Log.write(Prefix + "Aborting remainder of BST testing due to this error.\n");
				  Log.write(Prefix + "Passed " + numTestsPassed + " of " + numTestsRun + " tests executed.\n");
				  Log.close();
				  return;
		   }
			
		   try {
		      numTestsRun++;
		      if ( M.checkSearch() ) {
			     Log.write(Prefix + "Passed:  check of BST search.\n");
			     numTestsPassed++;
		      }
		      else {
			     Log.write(Prefix + "Failed:  check of BST search.\n");
			     Log.write(Prefix + "Will attempt next test.\n");
		      }
		   }
		   catch ( Exception e ) {
				  Log.write(Prefix + "Unexpected exception caught during test of BST search.\n");
				  Log.write(Prefix + "Likely cause would be a bad pointer.\n");
				  Log.write(Prefix + "Will attempt next test.\n");
		   }
			
		   try {
		      numTestsRun++;
		      if ( M.checkDeletion() ) {
			     Log.write(Prefix + "Passed:  check of BST deletion.\n");
			     numTestsPassed++;
		      }
		      else {
			     Log.write(Prefix + "Failed:  check of BST deletion.\n");
			     Log.write(Prefix + "Will attempt next test.\n");
		      }
		   }
		   catch ( Exception e ) {
				  Log.write(Prefix + "Unexpected exception caught during test of BST deletion.\n");
				  Log.write(Prefix + "Likely cause would be a bad pointer.\n");
				  Log.write(Prefix + "Will attempt next test.\n");
		   }
		   try {
			  numTestsRun++;
			  if ( M.checkEquals() ) {
				     Log.write(Prefix + "Passed:  check of BST equals method.\n");
				     numTestsPassed++;
			  }
		      else {
				     Log.write(Prefix + "Failed:  check of BST equals method.\n");
				     Log.write(Prefix + "Will attempt next test.\n");
			      }
		   }
		   catch ( Exception e ) {
				  Log.write(Prefix + "Unexpected exception caught during test of BST equals method.\n");
				  Log.write(Prefix + "Likely cause would be a bad pointer.\n");
				  Log.write(Prefix + "Will attempt next test.\n");
		   }
		   try {
			  numTestsRun++;
			  if ( M.checkLevels() ) {
			     Log.write(Prefix + "Passed:  check of BST levels method.\n");
			     numTestsPassed++;
			  }
			  else {
			     Log.write(Prefix + "Failed:  check of BST levels method.\n");
			     Log.write(Prefix + "Will attempt next test.\n");
			  }
			}
			catch ( Exception e ) {
			   Log.write(Prefix + "Unexpected exception caught during test of BST levels method.\n");
			   Log.write(Prefix + "Likely cause would be a bad pointer.\n");
			   Log.write(Prefix + "Will attempt next test.\n");
			}
			
			try {
			   numTestsRun++;
			   if ( M.checkCap() ) {
			      Log.write(Prefix + "Passed:  check of BST cap method.\n");
			      numTestsPassed++;
			   }
			   else {
			      Log.write(Prefix + "Failed:  check of BST cap method.\n");
			      //Log.write(Prefix + "Will attempt next test.\n");
			  }
			}
			catch ( Exception e ) {
			   Log.write(Prefix + "Unexpected exception caught during test of BST cap method.\n");
			   Log.write(Prefix + "Likely cause would be a bad pointer.\n");
		    }
			
			try {
			   numTestsRun++;
			   if ( M.checkPool() ) {
			      Log.write(Prefix + "Passed:  check of BST node pool.\n");
			      numTestsPassed++;
			   }
			   else {
			      Log.write(Prefix + "Failed:  check of BST node pool.\n");
			      //Log.write(Prefix + "Will attempt next test.\n");
			  }
			}
			catch ( Exception e ) {
			   Log.write(Prefix + "Unexpected exception caught during test of BST node pool.\n");
			   Log.write(Prefix + "Likely cause would be a bad pointer.\n");
		    }
		}
		catch ( IOException e ) {
			Log.write("IOException occurred during testing.\n");
			return;
		}
		catch ( Exception e ) {
			Log.write("Exception occurred during testing.\n");
			return;
		}
		
		try {
			Log.write(Prefix + "Passed " + numTestsPassed + " of " + numTestsRun + " tests executed.\n");
			Log.close();
		}
		catch ( IOException e ) {
			//System.out.println("Error closing log file.");
		}
		//System.out.println("Total points assigned by Monk: " + M.ptsAssigned());
	}
}
