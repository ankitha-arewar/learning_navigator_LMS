package com.week2.lms.Service;
import org.springframework.http.ResponseEntity;
import com.week2.lms.Exceptions.NotAIntegerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
@Service
public class ApiServiceImpl implements  ApiService{

    private boolean isInteger(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String callExternalApi(String apiUrl, String number)throws NotAIntegerException {
        if(!isInteger(number)) throw new NotAIntegerException("Not an integer");
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(apiUrl+ "/ " + number, String.class);
            return response.getBody();
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            return "Error: " + e.getStatusCode() + " " + e.getResponseBodyAsString();
        } catch (RestClientException e) {
            return "Error: " + e.getMessage();
        }
    }
}
