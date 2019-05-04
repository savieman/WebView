package com.example.saviel.webview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SubredditFragment extends Fragment {
    private final static String redditURL = "www.reddit.com";


    public SubredditFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subreddit, container, false);
        WebView webView = view.findViewById(R.id.webview);

        webView.loadUrl(redditURL);

        return view;
    }

}
