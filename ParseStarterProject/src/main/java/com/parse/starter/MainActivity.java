/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ParseUser  user = ParseUser.getCurrentUser();
        if(user == null)
        {
            Toast.makeText(this,"USer is null",Toast.LENGTH_LONG).show();
            user = new ParseUser();
            user.setUsername("User1");
            user.setPassword("Pass1");
            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if(e==null)
                    {
                        Log.i("Signp!","Successful");
                    }
                    else
                    {
                        Log.i("Signp!","Failed "+e.getMessage());
                    }
                }
            });
        }
        else
        {
            Toast toast = Toast.makeText(getApplicationContext(), "tidak ada chart yang dipilih", Toast.LENGTH_LONG);
            //toast.getView().setBackgroundColor(Color.YELLOW);
            //TextView text = (TextView) toast.getView().findViewById(android.R.id.message);
           // text.setTextColor(Color.BLACK);
            toast.show();

        }
    ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }

}