package com.example.hermes.hackupc.speedinterviewing;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class Challenge extends AppCompatActivity {

    String challenges_s = "[\n" +
            "  {\n" +
            "    \"id\": 0,\n" +
            "    \"questions\": [\n" +
            "      {\n" +
            "        \"question\": \"What will i and j equal after the code below is executed?   int i = 5;  int j = i++;\",\n" +
            "        \"a\": \"After the above code executes, i will equal 6, but j will equal 5\",\n" +
            "        \"b\": \"After the above code executes, i will equal 5, but j will equal 6\",\n" +
            "        \"c\": \"After the above code executes, i will equal 6, but j will equal 6\",\n" +
            "        \"d\": \"The code will never compile\",\n" +
            "        \"correct\": \"a\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"question\": \"Is there a difference between class and struct in C++?\",\n" +
            "        \"a\": \"It's the same\",\n" +
            "        \"b\": \"The only difference between a class and struct are the space required on memory. Class will it need to save the functions\",\n" +
            "        \"c\": \"The only difference between a class and struct are the access modifiers. Struct members are private by default; class members are public\",\n" +
            "        \"d\": \"The only difference between a class and struct are the access modifiers. Struct members are public by default; class members are private\",\n" +
            "        \"correct\": \"d\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"question\": \"The pointer which stores always the current active object address is __\",\n" +
            "        \"a\": \"auto_ptr\",\n" +
            "        \"b\": \"p\",\n" +
            "        \"c\": \"this\",\n" +
            "        \"d\": \"none of the above\",\n" +
            "        \"correct\": \"c\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"question\": \"Choose the operator which cannot be overloaded\",\n" +
            "        \"a\": \"::\",\n" +
            "        \"b\": \"/\",\n" +
            "        \"c\": \"()\",\n" +
            "        \"d\": \"%\",\n" +
            "        \"correct\": \"a\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"question\": \"A C++ program statements can be commented using\",\n" +
            "        \"a\": \"Single line comment\",\n" +
            "        \"b\": \"Both (a) and (b)\",\n" +
            "        \"c\": \"Multi line comment\",\n" +
            "        \"d\": \"Either (a) or (b)\",\n" +
            "        \"correct\": \"b\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 1,\n" +
            "    \"questions\": [\n" +
            "      {\n" +
            "        \"question\": \"How can we swap two numbers a = 10, b = 20 in python without using third variable?\",\n" +
            "        \"a\": \"a = b  b = a\",\n" +
            "        \"b\": \"a,b = b,a\",\n" +
            "        \"c\": \"both a & b\",\n" +
            "        \"d\": \"b = a  a = b\",\n" +
            "        \"correct\": \"c\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"question\": \"In the following options which are python libraries which are used for data analysis and scientific computations\",\n" +
            "        \"a\": \"Numpy\",\n" +
            "        \"b\": \"Scipy\",\n" +
            "        \"c\": \"Pandas\",\n" +
            "        \"d\": \" All the above\",\n" +
            "        \"correct\": \"d\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"question\": \"What is output for: 2 * 2 **3\",\n" +
            "        \"a\": \"12\",\n" +
            "        \"b\": \"64\",\n" +
            "        \"c\": \"16\",\n" +
            "        \"d\": \"36\",\n" +
            "        \"correct\": \"c\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"question\": \"Suppose we are given with two sets(s1&s2) then what is the output of the code: S1 + S2\",\n" +
            "        \"a\": \"Adds the elements of the both the sets.\",\n" +
            "        \"b\": \"Removes the repeating elements and adds both the sets.\",\n" +
            "        \"c\": \"It is an illegal command.\",\n" +
            "        \"d\": \"Output will be stored in S1.\",\n" +
            "        \"correct\": \"c\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"question\": \"Which can be an Identifier among them in Python?\",\n" +
            "        \"a\": \"1abc\",\n" +
            "        \"b\": \"$12a\",\n" +
            "        \"c\": \"_xy1\",\n" +
            "        \"d\": \"@python\",\n" +
            "        \"correct\": \"c\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "]";

    JSONArray challenges;
    JSONObject challange;
    int counter = 0;
    JSONArray questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        final Context context = this;


        try {
            challenges = new JSONArray(challenges_s);
            challange = challenges.getJSONObject(0);
            questions = challange.getJSONArray("questions");

            final TextView question = findViewById(R.id.question);
            final TextView a = findViewById(R.id.a);
            final TextView b= findViewById(R.id.b);
            final TextView c = findViewById(R.id.c);
            final TextView d= findViewById(R.id.d);

            question.setText(questions.getJSONObject(counter).getString("question"));
            a.setText(questions.getJSONObject(counter).getString("a"));
            a.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    v.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                }
            });
            b.setText(questions.getJSONObject(counter).getString("b"));
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                }
            });
            c.setText(questions.getJSONObject(counter).getString("c"));
            c.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    v.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                }
            });
            d.setText(questions.getJSONObject(counter).getString("d"));
            d.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    v.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                }
            });

            findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ++ counter;

                    try {
                        question.setText(questions.getJSONObject(counter).getString("question"));
                        a.setText(questions.getJSONObject(counter).getString("a"));
                        b.setText(questions.getJSONObject(counter).getString("b"));
                        c.setText(questions.getJSONObject(counter).getString("c"));
                        d.setText(questions.getJSONObject(counter).getString("d"));
                        a.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                        b.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                        c.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                        d.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    } catch (JSONException e) {
//                        startActivity(new Intent(context, videocall.class));

                         String url = "https://appr.tc/r/204057864";
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.setPackage("com.android.chrome");
                    startActivity(i);
                        e.printStackTrace();

                    }

                }
            });

































        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
