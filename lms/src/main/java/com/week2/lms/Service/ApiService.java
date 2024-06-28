package com.week2.lms.Service;

import com.week2.lms.Exceptions.NotAIntegerException;
public interface ApiService {
    String callExternalApi(String url, String number) throws NotAIntegerException;
}
