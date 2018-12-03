package com.coachscorner.warren.coachscorner;

public class CoachsCornerApiRequest {
    String baseUrl = "http://10.0.2.2:8080/coachscorner/api/";
    String responseMessage = null;

    public String getUrl()
    {
        return this.baseUrl;
    }


    public String getResponseMessage()
    {
        return this.responseMessage;
    }

    public void setResponseMessage(String responseMessage)
    {
        this.responseMessage = responseMessage;
    }
}
