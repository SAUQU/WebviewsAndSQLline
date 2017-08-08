package com.example.segundoauqui.webviewsandsqlline;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private static final String TAG = "Hello";
    private WebView webView;

    Button btnSave;
    Button btnDisplay;
    EditText  etName;
    EditText etNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnDisplay = (Button) findViewById(R.id.btnDisplay);



//        webView = (WebView) findViewById(R.id.webView);
//        WebViewClient webViewClient = new WebViewClient();
//
//        WebSettings webSettings = webView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        webView.setWebViewClient(webViewClient);
//
//        webView.loadUrl("https://developer.android.com");



        etName = (EditText) findViewById(R.id.etName);
        etNumber = (EditText) findViewById(R.id.etNumber);




        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
        dataBaseHelper.saveNewContact("Jonh", "23423423432");
        dataBaseHelper.getContacts();


    }

    public void SaveNameNumber(View view) {

        MyContac contac = new MyContac(etName.getText().toString(), etNumber.getText().toString());
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
        dataBaseHelper.saveNewContact(contac);




    }

    public void displayNameNumber(View view) {

        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
        List<MyContac> contacts = dataBaseHelper.getContacts();

        for(MyContac contac : contacts){

            Log.d(TAG, "displayNameNumber: " + contac.getName() + " ");



        }




    }
}
