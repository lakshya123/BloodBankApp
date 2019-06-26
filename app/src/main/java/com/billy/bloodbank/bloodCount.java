package com.billy.bloodbank;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class bloodCount extends AppCompatActivity {

    private ProgressDialog progDailog;

    private static final String URL = "https://api.myjson.com/bins/1bp425";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_count);

        final RecyclerView bloodType_list = findViewById(R.id.bloodType_list);
        bloodType_list.setLayoutManager(new LinearLayoutManager(this));

        progDailog = ProgressDialog.show(bloodCount.this, "Loading","Fetching Data...", true);
        progDailog.setCancelable(false);

        final StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                progDailog.dismiss();
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                BloodType[] bloodTypes = gson.fromJson(s, BloodType[].class);
                bloodType_list.setAdapter(new bloodCountAdapter(bloodCount.this, bloodTypes));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(bloodCount.this, "Something Went Wrong", Toast.LENGTH_LONG).show();
            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }

    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
