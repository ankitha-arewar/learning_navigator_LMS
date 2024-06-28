package com.week2.lms.Controller;

import com.week2.lms.Exceptions.NotAIntegerException;
import com.week2.lms.Dto.ErrorDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.week2.lms.Service.ApiServiceImpl;
@RestController
@RequestMapping("/hidden-feature")
public class NumbersAPIController {
    @Autowired
    private ApiServiceImpl apiServiceImp;

    private final String url = "http://numberapi.com";

    @GetMapping("/{number}")
    public ResponseEntity<?> getFactsAboutNumber(@PathVariable String number){
        try{
            String response = apiServiceImp.callExternalApi(url,number);
            return ResponseEntity.ok(response);
        }catch (NotAIntegerException e){
            ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST.value(), e.getMessage(), "Enter a valid Integer");
            return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
        }

    }
}
