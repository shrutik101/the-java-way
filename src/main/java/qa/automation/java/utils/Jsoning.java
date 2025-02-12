package qa.automation.java.utils;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Jsoning {
    ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String args[]){
        String filePath = "F:\\Shruti\\workspace\\the-java-way\\src\\main\\resources\\listings.json";
        Jsoning json = new Jsoning();
        json.readJson(filePath);
    }

    public void readJson(String filePath){
        try {
            File file = new File(filePath);
            JsonNode rootNode = objectMapper.readTree(file);
            JsonNode listings = rootNode.get("listings");

            for(JsonNode listing : listings){
//                if(listing.get("address").asText().contains("Chicago")){
//                    double price = listing.get("price").asDouble();
//                    System.out.println("Address = "+listing.get("address").asText()+"\n"+"Price = "+price);
//                }
//                int id = listing.get("id").intValue();
//                System.out.println("id = "+id);
//                if(listing.get("bathrooms").intValue()>1){
//                    int bedrooms = listing.get("bedrooms").intValue();
//                    int bathrooms = listing.get("bathrooms").intValue();
//                    String address = listing.get("address").toString();
//                    System.out.println("Address = "+address+"\n"+"Bedrooms = "+bedrooms+"\n"+"Bathrooms = "+bathrooms);
//                }
                JsonNode amenities = listing.get("amenities");
                for(JsonNode amenity : amenities){
                    if(amenity.asText().equalsIgnoreCase("Gym")){
                    String address = listing.get("address").toString();
                    System.out.println("Address = "+address);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
