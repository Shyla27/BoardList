package com.example.myapplication.gadsleaderboard;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashMap;
import java.util.Map;

public class Submit extends AppCompatActivity {

    ProgressDialog progressDialog;
    FloatingActionButton fab;
    EditText firstName, lastName,email,githubLink;
    Button submitToGoggleForm;
    RequestQueue queue;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading...");

        toolbar = findViewById(R.id.toolbar_submit);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        firstName = (EditText) findViewById(R.id.etFname);
        lastName = (EditText) findViewById(R.id.etLname);
        email = (EditText) findViewById(R.id.etEmail);
        githubLink = (EditText) findViewById(R.id.etProject);
        submitToGoggleForm = findViewById(R.id.btnSubmit);


        // Initializing Queue for Volley
        queue = Volley.newRequestQueue(getApplicationContext());


        submitToGoggleForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sureDialog();

            }
        });
    }

    private void sureDialog() {
        final Dialog dialog = new Dialog(Submit.this);

        dialog.requestWindowFeature(Window.FEATURE_LEFT_ICON);
        dialog.setFeatureDrawableResource(Window.FEATURE_LEFT_ICON, R.color.colorWhite);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog.setContentView(R.layout.are_you_sure_dialog);
        dialog.setTitle("Dialog Title");

        dialog.show();
        TextView yes = (TextView) dialog.findViewById(R.id.btnYes);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstName.getText().toString().trim().length() > 0 && lastName.getText().toString().trim().length() > 0
                        && email.getText().toString().trim().length() > 0 && githubLink.getText().toString().trim().length() > 0 ) {
                    postData(firstName.getText().toString().trim(), lastName.getText().toString().trim() ,email.getText().toString().trim(),githubLink.getText().toString().trim());
                } else {
                    dialog.dismiss();

                }

                Toast.makeText(getApplicationContext(),"Required Fields Missing!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void failureDialog() {
        Dialog dialog = new Dialog(Submit.this);

        dialog.requestWindowFeature(Window.FEATURE_LEFT_ICON);
        dialog.setFeatureDrawableResource(Window.FEATURE_LEFT_ICON, R.color.colorWhite);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog.setContentView(R.layout.submission_not_successful);
        dialog.setTitle("Dialog Title");

        dialog.show();


    }

    private void successDialog() {
        Dialog dialog = new Dialog(Submit.this);

        dialog.requestWindowFeature(Window.FEATURE_LEFT_ICON);
        dialog.setFeatureDrawableResource(Window.FEATURE_LEFT_ICON, R.color.colorWhite);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog.setContentView(R.layout.submission_successful);
        dialog.setTitle("Dialog Title");

        dialog.show();
    }


    public void postData(final String fname, final String lname, final String emailString, final String gitLink) {

        progressDialog.show();
        StringRequest request = new StringRequest(
                Request.Method.POST,
                Constants.url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("TAG", "Response: " + response);
                        if (response.length() > 0) {

                            successDialog();

                            firstName.setText(null);
                            lastName.setText(null);
                            email.setText(null);
                            githubLink.setText(null);
                        } else {

                            failureDialog();
                        }
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                failureDialog();

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put(Constants.firstNameField, fname);
                params.put(Constants.lastNameField, lname);
                params.put(Constants.emailField, emailString);
                params.put(Constants.gitHubLinkField, gitLink);
                return params;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(
                50000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return  true;
    }
}