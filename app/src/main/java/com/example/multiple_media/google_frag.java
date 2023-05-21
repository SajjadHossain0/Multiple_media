package com.example.multiple_media;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link google_frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class google_frag extends Fragment implements OnBackPressedListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public google_frag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment google_frag.
     */
    // TODO: Rename and change types and number of parameters
    public static google_frag newInstance(String param1, String param2) {
        google_frag fragment = new google_frag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_google_frag, container, false);

        WebView googleWeb = (WebView) view.findViewById(R.id.googleWeb);
        WebSettings webSettings = googleWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        googleWeb.setWebViewClient(new WebViewClient());
        googleWeb.loadUrl("https://www.google.com/");

        return view;
    }

    @Override
    public void onBackPressed() {
        WebView googleWeb = getView().findViewById(R.id.googleWeb);
        if (googleWeb.canGoBack()) {
            googleWeb.goBack();
        }
    }
}