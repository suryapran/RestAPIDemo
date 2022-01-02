package resources;

public enum APIResourceEnum {
	
	AddPlaceAPI("/maps/api/place/add/json"),//AddPlaceAPI is should be same name as the string in feature file string
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	
	private String resor;
	APIResourceEnum(String resourc)
	{
		this.resor=resourc;
	}
	
	public String getResource()
	{
		return resor;
	}

}
