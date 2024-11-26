package com.example.restapi;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.List;

public class PeopleAdatpter extends BaseAdapter {
    List<people> peoplelist;
    Context con;

    public PeopleAdatpter(List<people> peoplelist, Context con) {
        this.peoplelist = peoplelist;
        this.con = con;
    }

    @Override
    public int getCount() {
        return peoplelist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(con).inflate(R.layout.lpeoplelistwiew,viewGroup,false);
        TextView fisrt=view.findViewById(R.id.Firstnametextwiew);
        TextView Last=view.findViewById(R.id.Lasttextwiew);
        TextView age=view.findViewById(R.id.agetwiew);
        TextView email=view.findViewById(R.id.emailwiew);
        Button delete=view.findViewById(R.id.deleteButton);
        people person=peoplelist.get(i);
        fisrt.setText(person.getFirstName());
        Last.setText(person.getLastName());
        age.setText("("+ person.getAge()+")");
        email.setText(person.getEmail());
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(con);
                builder.setTitle("törlés");
                builder.setMessage("biztosantörlik");
                builder.setPositiveButton("igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setNegativeButton("nem",null);
                AlertDialog dialog=builder.create();
                dialog.show();

            }

        });
        return view;
    }
}
