package es.cice.jcreadingjson;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import es.cice.jcreadingjson.model.Person;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    TextView txtMsg;
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        txtMsg = (TextView) findViewById(R.id.txtMsg);
        gson = new Gson();

        slowWorkerThread.start();

    }

    //Nos permite introducir informacion al TXTView

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            txtMsg.append("\n"+(String) msg.obj);
            progressBar.setVisibility(View.INVISIBLE);

        }
    };

    //Varios Hilos
    Thread slowWorkerThread = new Thread() {
        @Override
        public void run() {
            super.run();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String text = "";
            Person person0 = new Person("Daenerys", 20);

            //Serialized
            String json = gson.toJson(person0);
            text = "\n(LOCAL)Json serialized object:\n"+json;
            handler.sendMessage(handler.obtainMessage(1, (String) text));

            ArrayList<Person> lstPerson = new ArrayList<>();
            lstPerson.add(person0);
            lstPerson.add(new Person("Arya", 12));
            lstPerson.add(new Person("Cersei", 35));

            String jsonList = gson.toJson(lstPerson);
            text = "\n(LOCAL)Json serialized list:\n"+jsonList;
            handler.sendMessage(handler.obtainMessage(1, (String) text));

            //Deserialized

            Type arrayPersonType = new TypeToken<ArrayList<Person>>(){}.getType();
            ArrayList<Person> lst2 = gson.fromJson(jsonList, arrayPersonType);

            int cont = 0;
            for ( Person aux : lst2) {

                Person p = aux;
                text = "\n"+ cont++ +"-(LOCAL) Person From Deserialized List:\n"+p.toString()
                + "\n name:"+p.getName()
                + "\n age:"+p.getAge();

                handler.sendMessage(handler.obtainMessage(1, (String) text));
            }

            //Remote
            try {

                URL url = new URL("https://api.themoviedb.org/3/movie/popular?api_key=e4190e0e5981362e0722c17cfd44da57");
                Scanner scanner = new Scanner(url.openStream());
                StringBuffer data=new StringBuffer();

                while (scanner.hasNext()) {
                    data.append(scanner.nextLine());
                }

                //handler.sendMessage(handler.obtainMessage(1, "\nFROM REMOTE SERVER\n"+text));

                JSONObject jsonObject = new JSONObject(data.toString());
                JSONArray results = jsonObject.getJSONArray("results");

                for (int i = 0; i< results.length(); i++) {
                    JSONObject jsonMovie = results.getJSONObject(i);
                    String title = jsonMovie.getString("original_title");
                    String estreno = jsonMovie.getString("release_date");

                    text = "\n"+ i+ "-(REMOTE) Person From Deserialized\nTitulo: "+title
                            + "\nEstreno:"+estreno;

                    handler.sendMessage(handler.obtainMessage(1, (String) text));
                }


            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    };

}
