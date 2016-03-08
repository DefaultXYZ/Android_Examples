package default_xyz.playground.rest;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.net.ConnectException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

import default_xyz.playground.R;
import default_xyz.playground.rest.model.User;
import default_xyz.playground.rest.service.Rest;
import default_xyz.playground.rest.service.ServiceGenerator;

public class RestActivity extends AppCompatActivity {

    public static LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest);
        linearLayout = (LinearLayout) findViewById(R.id.rest_container);
        //System.setProperty("jsse.enableSNIExtension", "false");
        List<User> users = new ArrayList<>();
        try {
            AsyncTask<Void, Void, List<User>> result = new RestAsyncTask().execute();
            users = result.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        for(User user : users) {
            TextView textView = new TextView(this);
            textView.setText(user.getUsername());
            linearLayout.addView(textView);
        }
    }
}

class RestAsyncTask extends AsyncTask<Void, Void, List<User>> {

    @Override
    protected List<User> doInBackground(Void... params) {
        Rest rest = ServiceGenerator.createService(Rest.class);
        List<User> users = new ArrayList<>();
        try {
            users = rest.getUsers().execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
