package com.l33tindustries.tools.database;

import java.sql.*;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Db2 {

	final static Logger logger = Logger.getLogger(Db2.class);

	Db db;
	
	private String hostname, username, password, databaseName, port;

	/**
	 * @return the hostname
	 */
	public String getHostname() {
		logger.trace("Entering ");
		logger.trace("Exiting : " + hostname);
		return hostname;
	}

	/**
	 * @param hostname the hostname to set
	 */
	public void setHostname(String hostname) {
		logger.trace("Entering ");
		this.hostname = hostname;
		logger.trace("Exiting ");
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		logger.trace("Entering ");
		logger.trace("Exiting : " + username);
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		logger.trace("Entering ");
		this.username = username;
		logger.trace("Exiting ");
	}

	/**
	 * @return the password
	 */
	private String getPassword() {
		logger.trace("Entering ");
		logger.trace("Exiting : " + password);
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		logger.trace("Entering ");
		this.password = password;
		logger.trace("Exiting ");
	}

	/**
	 * @return the databaseName
	 */
	public String getDatabaseName() {
		logger.trace("Entering ");
		logger.trace("Exiting : " + databaseName);
		return databaseName;
	}

	/**
	 * @param databaseName the databaseName to set
	 */
	public void setDatabaseName(String databaseName) {
		logger.trace("Entering ");
		this.databaseName = databaseName;
		logger.trace("Exiting ");
	}

	/**
	 * @return the port
	 */
	public String getPort() {
		logger.trace("Entering ");
		logger.trace("Exiting : " + port);
		return port;

	}

	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		logger.trace("Entering ");
		this.port = port;
		logger.trace("Exiting ");
	}

	Db2(String Hostname, String Username, String Password, String DatabaseName, String Port)
	{

		logger.trace("Entering ");

		setHostname(hostname);
		setUsername(username);
		setPassword(password);
		setDatabaseName(databaseName);
		setPort(port);

		logger.trace("Exiting ");
	}
	
	public Connection connect()
	{
		String[] connectArgs = { 
				databaseName, hostname, port, username, password
		};

		try {
			db = new Db(connectArgs);
			db.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return db.con;
	}

	public void disconnect()
	{
		try {
			db.disconnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public boolean Select(String Statement)
	{
		Connection con = connect();
		PreparedStatement pstmt = null;
		ResultSet rset=null;
		boolean found=false;
		try
		{
			//Statement stmt = con.createStatement();
			System.out.println("executing : " + Statement);
			pstmt=con.prepareStatement(Statement);
			rset=pstmt.executeQuery();


			if(rset!=null)
			{

				while(rset.next())
				{
					found=true;

					System.out.println("ID: "+rset.getString("id"));
					System.out.println("Name: "+rset.getString("name"));

				}

			}
			if (found ==false)
			{
				System.out.println("No Information Found");
			}
			pstmt.close();
			db.disconnect();
		}
		catch (Exception e)
		{
			JdbcException jdbcExc = new JdbcException(e, con);
			jdbcExc.handle();
		}
		
		return found;
	}

	public void Insert(String Statement)
	{
		Connection con = connect();

		try
		{

			Statement stmt = con.createStatement();
			System.out.println("executing : " + Statement);
			stmt.executeUpdate(Statement);
			stmt.close();
			db.disconnect();
		}
		catch (Exception e)
		{
			JdbcException jdbcExc = new JdbcException(e, con);
			jdbcExc.handle();
		}
	} // basicInsert

}

class Db
{
  public String alias;
  public String server;
  public int    portNumber = 0; // 0 indicates legacy type 2 connection,
                                // < 0 use universal type 2 connection
  public String userId;
  public String password;
  public Connection con = null;

  public Db()
  {
  }

  public Db(String argv[]) throws Exception
  {
    if( argv.length > 5 ||
        ( argv.length == 1 &&
          ( argv[0].equals( "?" )               ||
            argv[0].equals( "-?" )              ||
            argv[0].equals( "/?" )              ||
            argv[0].equalsIgnoreCase( "-h" )    ||
            argv[0].equalsIgnoreCase( "/h" )    ||
            argv[0].equalsIgnoreCase( "-help" ) ||
            argv[0].equalsIgnoreCase( "/help" ) ) ) )
    {
      throw new Exception(
        "Usage: prog_name [dbAlias] [userId passwd] (use legacy JDBC type 2 driver)\n" +
        "       prog_name -u2 [dbAlias] [userId passwd] (use universal JDBC type 2 driver)\n" +
        "       prog_name [dbAlias] server portNum userId passwd (use universal JDBC type 4 driver)" );
    }

    switch (argv.length)
    {
      case 0:  // Type 2, use all defaults
        alias = "sample";
        userId = "";
        password = "";
        break;
      case 1:  // Type 2, dbAlias specified or Type 2 Universal
        if (argv[0].equalsIgnoreCase("-u2"))
        {
           alias ="sample";
           portNumber = -1;
        }
        else
        {
           alias = argv[0];
        }

        userId = "";
        password = "";
        break;
      case 2:  // Type 2, userId & passwd specified
        if (argv[0].equalsIgnoreCase("-u2"))
        {
           alias = argv[1];
           userId = "";
           password = "";
           portNumber = -1;
        }
        else
        {
           alias = "sample";
           userId = argv[0];
           password = argv[1];
        }

        break;
      case 3:  // Type 2, dbAlias, userId & passwd specified or Type 2 Universal
        if (argv[0].equalsIgnoreCase("-u2"))
        {
           alias = "sample";
           userId = argv[1];
           password = argv[2];
           portNumber = -1;
        }
        else
        {
           alias = argv[0];
           userId = argv[1];
           password = argv[2];
        }

        break;
      case 4:  // Type 4, use default dbAlias or Type 2 Universal
        if (argv[0].equalsIgnoreCase("-u2"))
        {
           alias = argv[1];
           userId = argv[2];
           password = argv[3];
           portNumber = -1;
        }
        else
        {
           alias = "sample";
           server = argv[0];
           portNumber = Integer.valueOf( argv[1] ).intValue();
           userId = argv[2];
           password = argv[3];
        }
        break;
      case 5:  // Type 4, everything specified
        if (! argv[0].equalsIgnoreCase("-u2"))
        {
           alias = argv[0];
           server = argv[1];
           portNumber = Integer.valueOf( argv[2] ).intValue();
           userId = argv[3];
           password = argv[4];
        }
        break;
    }
  } // Db Constructor

  public Connection connect() throws Exception
  {
    String url = null;

    // In Partitioned Database environment, set this to the node number
    // to which you wish to connect (leave as "0" in non-Partitioned Database environment)
    String nodeNumber = "0";

    Properties props = new Properties();

    if ( portNumber < 0 )
    {
      url = "jdbc:db2:" + alias;
      System.out.println(
        "  Connect to '" + alias + "' database using JDBC Universal type 2 driver." );
      Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
    }
    else if( portNumber == 0 )
    {
      url = "jdbc:db2:" + alias;
      System.out.println(
        "  Connect to '" + alias + "' database using JDBC type 2 driver." );
      Class.forName("COM.ibm.db2.jdbc.app.DB2Driver").newInstance();
    }
    else
    {
      url = "jdbc:db2://" + server + ":" + portNumber + "/" + alias;
      System.out.println(
        "  Connect to '" + alias + "' database using JDBC type 4 driver." );
      Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
    }

    if( null != userId )
    {
      props.setProperty("user", userId);
      props.setProperty("password", password);
    }

    props.setProperty("CONNECTNODE", nodeNumber);

    con = DriverManager.getConnection( url, props );

    // enable transactions
    con.setAutoCommit(false);
    return con;
  } // connect

  public void disconnect() throws Exception
  {
    System.out.println();
    System.out.println("  Disconnect from '" + alias + "' database.");

    // makes all changes made since the previous commit/rollback permanent
    // and releases any database locks currrently held by the Connection.
    con.commit();

    // immediately disconnects from database and releases JDBC resources
    con.close();
  } // disconnect
} // Db

class JdbcException extends Exception
{
  Connection conn;

  public JdbcException(Exception e)
  {
    super(e.getMessage());
    conn = null;
  }

  public JdbcException(Exception e, Connection con)
  {
    super(e.getMessage());
    conn = con;
  }

  public void handle()
  {
    System.out.println(getMessage());
    System.out.println();

    if (conn != null)
    {
      try
      {
        System.out.println("--Rollback the transaction-----");
        conn.rollback();
        System.out.println("  Rollback done!");
      }
      catch (Exception e)
      {
      };
    }
  } // handle

  public void handleExpectedErr()
  {
    System.out.println();
    System.out.println(
      "**************** Expected Error ******************\n");
    System.out.println(getMessage());
    System.out.println(
      "**************************************************");
  } // handleExpectedError
} // JdbcException

