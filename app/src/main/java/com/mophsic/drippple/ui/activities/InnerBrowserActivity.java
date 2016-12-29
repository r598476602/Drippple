package com.mophsic.drippple.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mophsic.drippple.R;
import com.mophsic.drippple.utils.NetworkState;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InnerBrowserActivity extends AppCompatActivity {

    public static final String URL = "url";
    private String mUrl;

    @BindView(R.id.pb_inner)
    ProgressBar mProgressBar;
    @BindView(R.id.webview)
    WebView mWebView;
    @BindView(R.id.iv_error)
    ImageView mNetworkImage;
    @BindView(R.id.text_view)
    TextView mNetworkErrorText;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    public static void toHere(Context activity, String url) {
        Intent intent = new Intent(activity, InnerBrowserActivity.class);
        intent.putExtra(URL, url);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_browser);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        if (getIntent() != null) {
            mUrl = getIntent().getStringExtra(URL);
        }

        mWebView.getSettings().setBuiltInZoomControls(false);
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                changeProgress(newProgress);
            }
        });

        mWebView.setWebViewClient(new WebViewClient(){

            // 不在此页面加载 drippple://drippple-callback 的网址
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Uri uri = request.getUrl();
                if ("drippple".equals(uri.getScheme())) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(uri);
                    startActivity(intent);
                    return true;
                } else {
                    view.loadUrl(uri.toString());
                    return true;
                }
            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                mWebView.setVisibility(View.GONE);
                mNetworkImage.setVisibility(View.VISIBLE);
                mNetworkErrorText.setVisibility(View.VISIBLE);
                mNetworkErrorText.setText(error.getErrorCode() + ":" + error.getDescription());
                mNetworkImage.setOnClickListener(v -> {
                    NetworkState.networkConnected(InnerBrowserActivity.this.getApplicationContext());
                    mWebView.setVisibility(View.VISIBLE);
                    mWebView.loadUrl(mUrl);
                    mNetworkImage.setVisibility(View.GONE);
                    mNetworkErrorText.setVisibility(View.GONE);
                });
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                mProgressBar.setVisibility(View.GONE);
            }
        });

        mWebView.loadUrl(mUrl);
    }

    private void changeProgress(int progress){
        mProgressBar.setVisibility(View.VISIBLE);
        mProgressBar.setMax(100);
        mProgressBar.setProgress(progress);
    }
}
