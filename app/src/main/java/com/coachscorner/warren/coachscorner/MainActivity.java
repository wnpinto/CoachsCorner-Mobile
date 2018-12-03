package com.coachscorner.warren.coachscorner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView playerInfoTextView = findViewById(R.id.playerInfoRequest);
        final TextView teamListTextView = findViewById(R.id.teamListRequest);

        // Instantiate and start the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.start();

        PlayerInfoApiRequest playerInfoRequest = new PlayerInfoApiRequest(playerInfoTextView);
        TeamListApiRequest teamListRequest = new TeamListApiRequest(teamListTextView);


        // Add the request to the RequestQueue.
        queue.add(playerInfoRequest.getRequest());
        queue.add(teamListRequest.getRequest());
    }
}