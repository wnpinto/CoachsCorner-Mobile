package com.coachscorner.warren.coachscorner;

import android.util.Base64;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PlayerInfoApiRequest extends CoachsCornerApiRequest{

    private String url = "getPlayerInfo/";
    TextView mTextView;

    @Override
    public String getUrl()
    {
        return super.getUrl() + this.url;
    }

    public PlayerInfoApiRequest( TextView mTextView)
    {
        this.mTextView = mTextView;
    }

    public JsonObjectRequest getRequest()
    {

        // Request a json response from the provided URL.
        return new JsonObjectRequest
                (Request.Method.GET, getUrl(), null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        setResponseMessage(response.toString());
                        mTextView.setText(responseMessage);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        setResponseMessage("Failed to retrieve Player Info Data.");

                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                String credentials = "warren:warren";
                String auth = "Basic "
                        + Base64.encodeToString(credentials.getBytes(), Base64.DEFAULT);
                headers.put("Content-Type", "application/json");
                headers.put("Authorization", auth);
                return headers;
            }
        };
    }
}
