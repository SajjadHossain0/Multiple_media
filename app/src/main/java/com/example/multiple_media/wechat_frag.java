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
 * Use the {@link wechat_frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class wechat_frag extends Fragment implements OnBackPressedListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public wechat_frag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment wechat_frag.
     */
    // TODO: Rename and change types and number of parameters
    public static wechat_frag newInstance(String param1, String param2) {
        wechat_frag fragment = new wechat_frag();
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
        View view = inflater.inflate(R.layout.fragment_wechat_frag, container, false);

        WebView wechatWeb = (WebView) view.findViewById(R.id.wechatWeb);
        WebSettings webSettings = wechatWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wechatWeb.setWebViewClient(new WebViewClient());
        wechatWeb.loadUrl("https://www.wechat.com/");

        return view;
    }

    @Override
    public void onBackPressed() {
        WebView youtubeWeb = getView().findViewById(R.id.youtubeWeb);
        if (youtubeWeb.canGoBack()) {
            youtubeWeb.goBack();
        }
    }
}