package com.miguelyeisonappgmail.rusia2018;


import android.os.Bundle;
import android.app.Fragment;
import android.provider.Browser;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class Inicio extends Fragment {


    public Inicio() {
        // Required empty public constructor
    }


    WebView browser;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);
        browser = (WebView) view.findViewById(R.id.webView);
        browser.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        browser.loadUrl("https://es.fifa.com/worldcup/groups/");
        return view;
    }

}
