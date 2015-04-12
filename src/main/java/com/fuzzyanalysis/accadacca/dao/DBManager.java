package com.fuzzyanalysis.accadacca.dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.fuzzyanalysis.accadacca.utils.PropertiesManager;
import com.fuzzyanalysis.accadacca.view.CarBean;

public class DBManager {

	public final String CAR_MAKES_QUERY_ALL = "SELECT MAKE FROM CARS"; //
	public final String CAR_MAKES_QUERY = 
			"SELECT MAKE FROM CARS WHERE MODEL LIKE '%%%s%%' AND YEAR LIKE '%%%s%%'";
	public final String CAR_MODELS_QUERY = 
			"SELECT MODEL FROM CARS WHERE MAKE LIKE '%%%s%%' AND YEAR LIKE '%%%s%%'";
	public final String CAR_YEARS_QUERY = 
			"SELECT YEAR FROM CARS WHERE MAKE LIKE '%%%s%%' AND MODEL LIKE '%%%s%%'";
	
	public final String CAR_DETAILS_QUERY = 
			"SELECT car_aerodynamic_dragcoefisient FROM CARS WHERE MAKE LIKE '%%%s%%' AND MODEL LIKE '%%%s%%' AND YEAR LIKE '%%%s%%'";

	static DBManager instance;
	Connection connection = null;

	static {
		try {
			if (instance == null) {
				instance = DBManager.class.newInstance();
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Creates a Connection object to connect to the PostgreSQL database
	 * 
	 * @return
	 */
	public Connection connect() {
		System.out.println("---- PostgreSQL JDBC Connection Testing ----");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out
					.println("PostgreSQL JDBC Driver not specified in library path!");
			e.printStackTrace();
			return null;

		}

		System.out.println("PostgreSQL JDBC Driver registered successfully.");

		Connection connection = null;

		try {

			PropertiesManager pm = new PropertiesManager();

			String dburl = pm.getProperty("dburl");
			String dbuser = pm.getProperty("dbuser");
			String dbpassword = pm.getProperty("dbpassword");

			connection = DriverManager.getConnection(dburl, dbuser, dbpassword);

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return connection;

		}
		return connection;
	}

	public String getCarDetails(String make, String model, String year){
		String detail = null;
		Connection connection = connect();
		if (connection != null) {
			System.out.println("Connected to database, ready for Years.");
		} else {
			System.out.println("Failed to make connection!");
		}

		try {			
			Statement st = connection.createStatement();
			String query = String.format(CAR_DETAILS_QUERY, make, model, year);
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				detail = rs.getString(1);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return detail;
		
	}
	
	public TreeMap<String, String> getCarYears(String make, String model){
		TreeMap<String, String> years = new TreeMap<String, String>();
		Connection connection = connect();
		if (connection != null) {
			System.out.println("Connected to database, ready for Years.");
		} else {
			System.out.println("Failed to make connection!");
		}

		try {
			String year;
			Statement st = connection.createStatement();
			String query = String.format(CAR_YEARS_QUERY, make, model);
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				year = rs.getString(1);
				years.put(year, year); 
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return years;

	}
	
	public TreeMap<String, String> getCarModels(String make, String year){
		TreeMap<String, String> models = new TreeMap<String, String>();
		Connection connection = connect();
		if (connection != null) {
			System.out.println("Connected to database, ready for Models.");
		} else {
			System.out.println("Failed to make connection!");
		}

		try {
			String model;
			//String query = "SELECT ID, MODEL FROM CARS";
			Statement st = connection.createStatement();
			String query = String.format(CAR_MODELS_QUERY, make, year);
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				model = rs.getString(1);
				models.put(model, model); 
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return models;

	}
	
	public TreeMap<String, String> getCarMakes(String model, String year){
		
		TreeMap<String, String> makes = new TreeMap<String, String>();
		Connection connection = connect();
		if (connection != null) {
			System.out.println("Connected to database, ready for Models.");
		} else {
			System.out.println("Failed to make connection!");
		}

		try {
			String make;
			//String query = "SELECT ID, MODEL FROM CARS";
			String query = String.format(CAR_MAKES_QUERY, model, year);
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				make = rs.getString(1);
				makes.put(make, make); 
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return makes;
	}
	
	public TreeMap<String, String> getAllCarMakes(){
		
		TreeMap<String, String> makes = new TreeMap<String, String>();
		Connection connection = connect();
		if (connection != null) {
			System.out.println("Connected to database, ready for Models.");
		} else {
			System.out.println("Failed to make connection!");
		}

		try {
			String make;			
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(CAR_MAKES_QUERY_ALL);
			while (rs.next()) {
				make = rs.getString(1);
				makes.put(make, make); 
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return makes;
	}

//	public List<Car> getCars(String query) {
//
//		List<Car> list = new ArrayList<Car>();
//
//		Connection connection = connect();
//		if (connection != null) {
//			System.out.println("You made it, take control your database now!");
//		} else {
//			System.out.println("Failed to make connection!");
//		}
//
//		try {
//			String retval = "";
//			// String query = "SELECT ID, MODEL FROM CARS";
//			Statement st = connection.createStatement();
//			ResultSet rs = st.executeQuery(query);
//			while (rs.next()) {
//				Car car = new Car();
//				System.out.println(rs.getString(1));
//				car.setId(rs.getString(1));
//				list.add(car);
//			}
//			rs.close();
//			st.close();
//			connection.close();
//			System.out.println(retval);
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return list;
//
//	}

}
