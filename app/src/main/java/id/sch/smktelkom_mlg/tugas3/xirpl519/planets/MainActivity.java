package id.sch.smktelkom_mlg.tugas3.xirpl519.planets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String url = "https://swapi.co/api/starships/";

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<ShipClass> shipClassList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_content);
        recyclerView.setAdapter(adapter);

        getvolley();
    }

    public void getvolley() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                getJSON(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void getJSON(String request) {
        try {
            JSONObject object = new JSONObject(request);
            JSONArray jsonArray = object.getJSONArray("results");

            for (int x = 0; x < jsonArray.length(); x++) {
                JSONObject jObject = jsonArray.getJSONObject(x);
                ShipClass ship = new ShipClass(jObject.getString("nama"), jObject.getString("diameter"), jObject.getString("population"),
                        jObject.getString("climate"));

                shipClassList.add(ship);
                adapter = new ShipAdapter(shipClassList);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(adapter);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
