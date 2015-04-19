package com.fuzzyanalysis.accadacca.view;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CarBean {

	public final String ID = "id";
	public final String MAKE = "make";
	public final String MODEL = "model";
	public final String YEAR = "year";
	public final String COLOR = "";
	public final String CATEGORY = "car_category";
	public final String ENGINEPOSITION = "car_engine_position";
	public final String ENGINE = "car_engine";
	public final String ENGINETYPE = "car_engine_type";
	public final String VALVESPERCYLINDER = "car_valves_per_cylinder";
	public final String MAXPOWER = "car_max_power";
	public final String MAXTORQUE = "car_max_torque";
	public final String BORESTROKE = "car_bore_stroke";
	public final String COMPRESSION = "car_compression";
	public final String TOPSPEED = "car_top_speed";
	public final String FUEL = "car_fuel";
	public final String TRANSMISSION = "car_transmission";
	public final String POWERPERWEIGHT = "car_power_per_weight";
	public final String ZEROTO100KMHZEROTO62MPH = "car_0_100_km_h_0_62_mph";
	public final String DRIVE = "car_drive";
	public final String SEATS = "car_seats";
	public final String PASSENGERSPACE = "car_passenger_space";
	public final String DOORS = "car_doors";
	public final String COUNTRYOFORIGIN = "car_country_of_origin";
	public final String FRONTTIRE = "car_front_tire";
	public final String REARTIRE = "car_rear_tire";
	public final String CHASSIS = "car_chassis";
	public final String C02EMISSIONS = "car_c02_emissions";
	public final String TURNCIRCLE = "car_turn_circle";
	public final String WEIGHT = "car_weight";
	public final String TOWINGWEIGHT = "car_towing_weight";
	public final String TOTALLENGTH = "car_total_length";
	public final String TOTALWIDTH = "car_total_width";
	public final String TOTALHEIGHT = "car_total_height";
	public final String MAXWEIGHTWITHLOAD = "car_max_weight_with_load";
	public final String GROUNDCLEARANCE = "car_ground_clearance";
	public final String WHEELBASE = "car_wheel_base";
	public final String COOLING = "car_cooling";
	public final String FRONTBRAKESTYPE = "car_front_brakes_type";
	public final String REARBRAKESTYPE = "car_rear_brakes_type";
	public final String CARGOSPACE = "car_cargo_space";
	public final String LUBRICATION = "car_lubrication";
	public final String FRONT_LEG_ROOM = "car_front_leg_room";
	public final String AERODYNAMIC_DRAGCOEFISIENT = "car_aerodynamic_dragcoefisient";
	public final String FUEL_WITH_HIGHWAY_DRIVE = "car_fuel_with_highway_drive";
	public final String FUEL_WITH_MIXED_DRIVE = "car_fuel_with_mixed_drive";
	public final String FUEL_WITH_CITY_DRIVE = "car_fuel_with_city_drive";
	public final String FUEL_TANK_CAPACITY = "car_fuel_tank_capacity";
	public final String CREATED_BY = "created_by";
	public final String CREATED_ON = "created_on";
	
	public String id;
	public String make;
	public String model;
	public String year;
	public String color;
	public String category;
	public String enginePosition;
	public String engine;
	public String engineType;
	public String valvesPerCylinder;
	public String maxPower;
	public String maxTorque;
	public String boreStroke;
	public String compression;
	public String topSpeed;
	public String fuel;
	public String transmission;
	public String powerPerWeight;
	public String zeroTo100KmHZeroTo62Mph;
	public String drive;
	public String seats;
	public String passengerSpace;
	public String doors;
	public String countryOfOrigin;
	public String frontTire;
	public String rearTire;
	public String chassis;
	public String c02Emissions;
	public String turnCircle;
	public String weight;
	public String towingWeight;
	public String totalLength;
	public String totalWidth;
	public String totalHeight;
	public String maxWeightWithLoad;
	public String groundClearance;
	public String wheelbase;
	public String cooling;
	public String frontBrakesType;
	public String rearBrakesType;
	public String cargoSpace;
	public String lubrication;
	public String front_leg_room;
	public String aerodynamic_dragcoefisient;
	public String fuel_with_highway_drive;
	public String fuel_with_mixed_drive;
	public String fuel_with_city_drive;
	public String fuel_tank_capacity;
	public String created_by;
	public String created_on;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getEnginePosition() {
		return enginePosition;
	}

	public void setEnginePosition(String enginePosition) {
		this.enginePosition = enginePosition;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public String getValvesPerCylinder() {
		return valvesPerCylinder;
	}

	public void setValvesPerCylinder(String valvesPerCylinder) {
		this.valvesPerCylinder = valvesPerCylinder;
	}

	public String getMaxPower() {
		return maxPower;
	}

	public void setMaxPower(String maxPower) {
		this.maxPower = maxPower;
	}

	public String getMaxTorque() {
		return maxTorque;
	}

	public void setMaxTorque(String maxTorque) {
		this.maxTorque = maxTorque;
	}

	public String getBoreStroke() {
		return boreStroke;
	}

	public void setBoreStroke(String boreStroke) {
		this.boreStroke = boreStroke;
	}

	public String getCompression() {
		return compression;
	}

	public void setCompression(String compression) {
		this.compression = compression;
	}

	public String getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(String topSpeed) {
		this.topSpeed = topSpeed;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getPowerPerWeight() {
		return powerPerWeight;
	}

	public void setPowerPerWeight(String powerPerWeight) {
		this.powerPerWeight = powerPerWeight;
	}

	public String getZeroTo100KmHZeroTo62Mph() {
		return zeroTo100KmHZeroTo62Mph;
	}

	public void setZeroTo100KmHZeroTo62Mph(String zeroTo100KmHZeroTo62Mph) {
		this.zeroTo100KmHZeroTo62Mph = zeroTo100KmHZeroTo62Mph;
	}

	public String getDrive() {
		return drive;
	}

	public void setDrive(String drive) {
		this.drive = drive;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}

	public String getPassengerSpace() {
		return passengerSpace;
	}

	public void setPassengerSpace(String passengerSpace) {
		this.passengerSpace = passengerSpace;
	}

	public String getDoors() {
		return doors;
	}

	public void setDoors(String doors) {
		this.doors = doors;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public String getFrontTire() {
		return frontTire;
	}

	public void setFrontTire(String frontTire) {
		this.frontTire = frontTire;
	}

	public String getRearTire() {
		return rearTire;
	}

	public void setRearTire(String rearTire) {
		this.rearTire = rearTire;
	}

	public String getChassis() {
		return chassis;
	}

	public void setChassis(String chassis) {
		this.chassis = chassis;
	}

	public String getC02Emissions() {
		return c02Emissions;
	}

	public void setC02Emissions(String c02Emissions) {
		this.c02Emissions = c02Emissions;
	}

	public String getTurnCircle() {
		return turnCircle;
	}

	public void setTurnCircle(String turnCircle) {
		this.turnCircle = turnCircle;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getTowingWeight() {
		return towingWeight;
	}

	public void setTowingWeight(String towingWeight) {
		this.towingWeight = towingWeight;
	}

	public String getTotalLength() {
		return totalLength;
	}

	public void setTotalLength(String totalLength) {
		this.totalLength = totalLength;
	}

	public String getTotalWidth() {
		return totalWidth;
	}

	public void setTotalWidth(String totalWidth) {
		this.totalWidth = totalWidth;
	}

	public String getTotalHeight() {
		return totalHeight;
	}

	public void setTotalHeight(String totalHeight) {
		this.totalHeight = totalHeight;
	}

	public String getMaxWeightWithLoad() {
		return maxWeightWithLoad;
	}

	public void setMaxWeightWithLoad(String maxWeightWithLoad) {
		this.maxWeightWithLoad = maxWeightWithLoad;
	}

	public String getGroundClearance() {
		return groundClearance;
	}

	public void setGroundClearance(String groundClearance) {
		this.groundClearance = groundClearance;
	}

	public String getWheelbase() {
		return wheelbase;
	}

	public void setWheelbase(String wheelbase) {
		this.wheelbase = wheelbase;
	}

	public String getCooling() {
		return cooling;
	}

	public void setCooling(String cooling) {
		this.cooling = cooling;
	}

	public String getFrontBrakesType() {
		return frontBrakesType;
	}

	public void setFrontBrakesType(String frontBrakesType) {
		this.frontBrakesType = frontBrakesType;
	}

	public String getRearBrakesType() {
		return rearBrakesType;
	}

	public void setRearBrakesType(String rearBrakesType) {
		this.rearBrakesType = rearBrakesType;
	}

	public String getCargoSpace() {
		return cargoSpace;
	}

	public void setCargoSpace(String cargoSpace) {
		this.cargoSpace = cargoSpace;
	}

	public String getLubrication() {
		return lubrication;
	}

	public void setLubrication(String lubrication) {
		this.lubrication = lubrication;
	}

	public String getFront_leg_room() {
		return front_leg_room;
	}

	public void setFront_leg_room(String front_leg_room) {
		this.front_leg_room = front_leg_room;
	}

	public String getAerodynamic_dragcoefisient() {
		return aerodynamic_dragcoefisient;
	}

	public void setAerodynamic_dragcoefisient(String aerodynamic_dragcoefisient) {
		this.aerodynamic_dragcoefisient = aerodynamic_dragcoefisient;
	}

	public String getFuel_with_highway_drive() {
		return fuel_with_highway_drive;
	}

	public void setFuel_with_highway_drive(String fuel_with_highway_drive) {
		this.fuel_with_highway_drive = fuel_with_highway_drive;
	}

	public String getFuel_with_mixed_drive() {
		return fuel_with_mixed_drive;
	}

	public void setFuel_with_mixed_drive(String fuel_with_mixed_drive) {
		this.fuel_with_mixed_drive = fuel_with_mixed_drive;
	}

	public String getFuel_with_city_drive() {
		return fuel_with_city_drive;
	}

	public void setFuel_with_city_drive(String fuel_with_city_drive) {
		this.fuel_with_city_drive = fuel_with_city_drive;
	}

	public String getFuel_tank_capacity() {
		return fuel_tank_capacity;
	}

	public void setFuel_tank_capacity(String fuel_tank_capacity) {
		this.fuel_tank_capacity = fuel_tank_capacity;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getCreated_on() {
		return created_on;
	}

	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}

	public void setAll(Map<String, String> details) {
		
//		for(Map.Entry<String,String> entry : details.entrySet()) {
//			  String key = entry.getKey();
//			  String value = entry.getValue();
//
//			  System.out.println(key + " => " + value);
//			}
		
		setAerodynamic_dragcoefisient(details.get(AERODYNAMIC_DRAGCOEFISIENT));
		setBoreStroke(details.get(BORESTROKE));
		setC02Emissions(details.get(C02EMISSIONS));
		setCargoSpace(details.get(CARGOSPACE));
		setCategory(details.get(CATEGORY));
		setColor(details.get(COLOR));
		setCompression(details.get(COMPRESSION));
		setCooling(details.get(COOLING));
		setCountryOfOrigin(details.get(COUNTRYOFORIGIN));
		setDoors(details.get(DOORS));
		setDrive(details.get(DRIVE));		
		setEngine(details.get(ENGINE));
		setEnginePosition(details.get(ENGINEPOSITION));
		setEngineType(details.get(ENGINETYPE));
		setFront_leg_room(details.get(FRONT_LEG_ROOM));
		setFrontBrakesType(details.get(FRONTBRAKESTYPE));
		setFrontTire(details.get(FRONTTIRE));
		setFuel_tank_capacity(details.get(FUEL_TANK_CAPACITY));
		setFuel_with_city_drive(details.get(FUEL_WITH_CITY_DRIVE));
		setFuel_with_highway_drive(details.get(FUEL_WITH_HIGHWAY_DRIVE));
		setFuel_with_mixed_drive(details.get(FUEL_WITH_MIXED_DRIVE));
		setFuel(details.get(FUEL));
		setGroundClearance(details.get(GROUNDCLEARANCE));
		setId(details.get(ID));
		setLubrication(details.get(LUBRICATION));
		setMake(details.get(MAKE));
		setMaxPower(details.get(MAXPOWER));
		setMaxTorque(details.get(MAXTORQUE));
		setMaxWeightWithLoad(details.get(MAXWEIGHTWITHLOAD));
		setModel(details.get(MODEL));
		setPassengerSpace(details.get(PASSENGERSPACE));
		setPowerPerWeight(details.get(POWERPERWEIGHT));
		setRearBrakesType(details.get(REARBRAKESTYPE));
		setRearTire(details.get(REARTIRE));
		setSeats(details.get(SEATS));
		setTopSpeed(details.get(TOPSPEED));
		setTotalHeight(details.get(TOTALHEIGHT));
		setTotalLength(details.get(TOTALLENGTH));
		setTotalWidth(details.get(TOTALWIDTH));
		setTowingWeight(details.get(TOWINGWEIGHT));
		setTransmission(details.get(TRANSMISSION));
		setTurnCircle(details.get(TURNCIRCLE));
		
	}

	
}
