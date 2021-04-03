package com.springboottask.Task2;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.io.IOException;
import java.net.URL;
import java.util.List;

@Controller
public class MovieController {

	@Autowired
    private MoviesService moviesService;




    @GetMapping("/import")
    public void save(){
    	moviesService.save();
    }

    @GetMapping("/movies/{genres}")
    public List<Movies> retriveAllGenres(@PathVariable String genres) {
		
    	return moviesService.findByGenres(genres);

    	

    }


    

}
