package com.springboottask.Task2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class MoviesService {

	 @Autowired
    private MoviesRepository moviesRepository;
   
       public void save(){
    	   ObjectMapper objectMapper=new ObjectMapper();
           List<Movies> movie=new ArrayList<>();
           try {
               URL url = new URL("https://raw.githubusercontent.com/prust/wikipedia-movie-data/master/movies.json");

               //parsed and generate list of Movie Object
               movie = objectMapper.readValue(url, new TypeReference<List<Movies>>(){});
           }catch(
                   JsonParseException jsp) {
               jsp.printStackTrace();
           }catch(JsonMappingException jme) {
               jme.printStackTrace();
           }catch (IOException e) {
               e.printStackTrace();
           }
           

        moviesRepository.saveAll(movie);
    }
       
       public List<Movies> findByGenres(String genres){
    	   return moviesRepository.findByGenres(genres);
       }
       
}
