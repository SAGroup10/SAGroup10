package ncu.im3069.demo.app;

import org.json.*;

public class For_adoption {
    private int for_adoption_id;
    private String name;
    private String species;
    private String breed;
    private int age;
    private String gender;
    private String size;
    private String exterior;
    private String ligation;
    private String area;
    private String description;
    private String img_path;
    private String status;
    
 public For_adoption(int id) {
  this.for_adoption_id = id;
 }

 public For_adoption(String name, String species, String breed, int age, String gender, String size, String exterior,
   String ligation, String area, String description, String img_path, String status) {
  this.name = name;
  this.species = species;
  this.breed = breed;
  this.age = age;
  this.gender = gender;
  this.size = size;
  this.exterior = exterior;
  this.ligation = ligation;
  this.area = area;
  this.description = description;
  this.img_path = img_path;
  this.status = status;
 }
 public For_adoption( String name, String species, String breed, int age, String gender, String size, String exterior,
		   String ligation, String area, String description, String img_path) {
		  this.name = name;
		  this.species = species;
		  this.breed = breed;
		  this.age = age;
		  this.gender = gender;
		  this.size = size;
		  this.exterior = exterior;
		  this.ligation = ligation;
		  this.area = area;
		  this.description = description;
		  this.img_path = img_path;
		 }
    
 public For_adoption(int for_adoption_id, String name, String species, String breed, int age, String gender, String size, String exterior,
   String ligation, String area, String description, String img_path, String status) {
  this.for_adoption_id = for_adoption_id;
  this.name = name;
  this.species = species;
  this.breed = breed;
  this.age = age;
  this.gender = gender;
  this.size = size;
  this.exterior = exterior;
  this.ligation = ligation;
  this.area = area;
  this.description = description;
  this.img_path = img_path;
  this.status = status;
 }


 public int getID() {
  return this.for_adoption_id;
 }

 public String getName() {
  return this.name;
 }

 public String getSpecies() {
  return this.species;
 }

 public String getBreed() {
  return this.breed;
 }

 public int getAge() {
  return this.age;
 }
 
 public String getGender() {
  return this.gender;
 }
 
 public String getSize() {
  return this.size;
 }
 
 public String getExterior() {
  return this.exterior;
 }
 
 public String getLigation() {
  return this.ligation;
 }
 
 public String getArea() {
  return this.area;
 }
 
 public String getDescription() {
  return this.description;
 }
 
 public String getImgPath() {
  return this.img_path;
 }
 
 public String getStatus() {
  return this.status;
 }

 public JSONObject getData() {
        JSONObject jso = new JSONObject();
        jso.put("for_adoption_id", getID());
        jso.put("name", getName());
        jso.put("species", getSpecies());
        jso.put("breed", getBreed());
        jso.put("age", getAge());
        jso.put("gender", getGender());
        jso.put("size", getSize());
        jso.put("exterior", getExterior());
        jso.put("ligation", getLigation());
        jso.put("area", getArea());
        jso.put("description", getDescription());
        jso.put("img_path", getImgPath());
        jso.put("status", getStatus());

        return jso;
    }
}