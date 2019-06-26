package com.billy.bloodbank;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Application_Form extends AppCompatActivity {

        private EditText hname,pname,rname,age,ward,doctor,units,weight,bed,adno;
        private Button submit;
        private RadioGroup radiosexGroup,radiobloodtype,radiobloodgroup;
        private RadioButton radioSexButton,radiobtype,radiobgroup;


        DatabaseReference databasePatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application__form);

        databasePatient = FirebaseDatabase.getInstance().getReference("Patient");


        hname = findViewById(R.id.hname);
        pname = findViewById(R.id.pname);
        rname = findViewById(R.id.rname);
        age = findViewById(R.id.age);
        ward = findViewById(R.id.ward);
        weight = findViewById(R.id.weight);
        bed = findViewById(R.id.bed);
        doctor = findViewById(R.id.doctor);
        adno = findViewById(R.id.adno);
        units = findViewById(R.id.units);
        radiosexGroup = findViewById(R.id.sex);
        radiobloodtype = findViewById(R.id.bloodtype);
        radiobloodgroup = findViewById(R.id.bloodgroup);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addinfo();
            }
        });
        }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

        public void addinfo(){

        boolean isValid  = true;

            int Selectedsex  = radiosexGroup.getCheckedRadioButtonId();
            if(Selectedsex == -1)
            {
                Toast.makeText(getApplicationContext(),"Please Select Gender",Toast.LENGTH_SHORT).show();
                isValid = false;;
            }
            int Selectedbloodtype = radiobloodtype.getCheckedRadioButtonId();
            if(Selectedbloodtype == -1)
            {
                Toast.makeText(getApplicationContext(),"Please Select Blood Type",Toast.LENGTH_SHORT).show();
                isValid = false;;
            }

            int Selectedbloodgroup = radiobloodgroup.getCheckedRadioButtonId();
            if(Selectedbloodtype == -1)
            {
                Toast.makeText(getApplicationContext(),"Please Select Blood Group",Toast.LENGTH_SHORT).show();
                isValid = false;;
            }


            if(isEmpty(hname)){
                hname.setError("Field is empty");
                isValid = false;
            }

            if(isEmpty(pname)){
                pname.setError("Field is empty");
                isValid = false;
            }
            if(isEmpty(rname)){
                rname.setError("Field is empty");
                isValid = false;
            }
            if(isEmpty(age)){
                age.setError("Field is empty");
                isValid = false;
            }
            if(isEmpty(ward)){
                ward.setError("Field is empty");
                isValid = false;
            }

            if(isEmpty(weight)){
                weight.setError("Field is empty");
                isValid = false;
            }

            if(isEmpty(bed)){
                bed.setError("Field is empty");
                isValid = false;
            }


            if(isEmpty(doctor)){
                doctor.setError("Field is empty");
                isValid = false;
            }

            if(isEmpty(units)){
                units.setError("Field is empty");
                isValid = false;
            }


            if(isValid == true){

                Toast.makeText(Application_Form.this,"Successful",Toast.LENGTH_SHORT).show();
                radioSexButton = findViewById(Selectedsex);
                radiobtype = findViewById(Selectedbloodtype);
                radiobgroup = findViewById(Selectedbloodgroup);

                String Hname = hname.getText().toString().trim();
                String Pname = pname.getText().toString().trim();
                String Rname = rname.getText().toString().trim();
                int Age = Integer.parseInt(age.getText().toString());
                int Weight = Integer.parseInt(weight.getText().toString().trim());
                String Incharge = doctor.getText().toString().trim();
                int RegNo = Integer.parseInt(adno.getText().toString().trim());
                int UnitCount = Integer.parseInt(units.getText().toString().trim());
                String Gender = radioSexButton.getText().toString().trim();
                String BloodType = radiobtype.getText().toString().trim();
                String BloodGroup = radiobgroup.getText().toString().trim();
                String Ward = ward.getText().toString().trim();
                String Bed = bed.getText().toString().trim();

                String ID = databasePatient.push().getKey();

                Patient patient =  new Patient(ID,Pname,Rname,Gender,Age,Weight,Hname,Incharge,RegNo,Ward,Bed,BloodGroup,BloodType,UnitCount);
                databasePatient.child(ID).setValue(patient);
                Toast.makeText(Application_Form.this,"Added to Database",Toast.LENGTH_SHORT).show();

            }


        }

}
