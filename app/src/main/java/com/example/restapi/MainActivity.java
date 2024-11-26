package com.example.restapi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    EditText first;
    EditText last;
    EditText email;
    EditText phone;
    EditText age;
    Button show;
    Button add;
    Button Cancel;
    LinearLayout from;
    ListView list;
    List<people> people;
    PeopleAdatpter adatpter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        innitalzation();
        RestApiService apiservice=Retrofitclient.getInstance().create(RestApiService.class);
        loadpeaple(apiservice);

    }
    public void innitalzation(){
        first=findViewById(R.id.firstnamedittext);
        last=findViewById(R.id.lastnamedittext);
        email=findViewById(R.id.emailedittext);
        phone=findViewById(R.id.phoneedittext);
        age=findViewById(R.id.ageedittext);
        show=findViewById(R.id.showFormButton);
        add=findViewById(R.id.addButton);
        Cancel=findViewById(R.id.cancelButton);
        from=findViewById(R.id.formlinearliyout);
        list=findViewById(R.id.Listwiew);
        people=new ArrayList<>();
        adatpter=new PeopleAdatpter(people,MainActivity.this);
        list.setAdapter(adatpter);
    }
    public  void loadpeaple(RestApiService res){
        res.getAllPeople().enqueue(new Callback<List<com.example.restapi.people>>() {
            @Override
            public void onResponse(Call<List<com.example.restapi.people>> call, Response<List<com.example.restapi.people>> response) {
                if(response.isSuccessful() && response.body()!=null){
                    people.clear();
                    people.addAll(response.body());
                    adatpter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<List<com.example.restapi.people>> call, Throwable t) {

            }
        });

    }
}