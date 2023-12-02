package com.arlosoft.macrodroid.action.outputservices;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;

/* loaded from: classes2.dex */
public class TwitterWebViewActivity extends AppCompatActivity {

    /* loaded from: classes2.dex */
    class a extends WebViewClient {
        a() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.contains(TwitterWebViewActivity.this.getResources().getString(R.string.twitter_callback))) {
                new b(str).execute((Object[]) null);
                return false;
            }
            return false;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.twitterwebview);
        WebView webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new a());
        webView.loadUrl((String) getIntent().getExtras().get("URL"));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* loaded from: classes2.dex */
    private class b extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        private final String f4556a;

        public b(String str) {
            this.f4556a = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            Twitter twitter = TwitterOutput.getTwitter();
            try {
                AccessToken oAuthAccessToken = twitter.getOAuthAccessToken(TwitterOutput.getRequestToken(), Uri.parse(this.f4556a).getQueryParameter("oauth_verifier"));
                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(TwitterWebViewActivity.this).edit();
                edit.putString("twitter_access_token", oAuthAccessToken.getToken());
                edit.putString("twitter_access_token_secret", oAuthAccessToken.getTokenSecret());
                edit.apply();
                return null;
            } catch (TwitterException e4) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("TwitterWebViewActivity: Error in RequestTokenTask: " + e4.getMessage()));
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r12) {
            TwitterWebViewActivity.this.finish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Void... voidArr) {
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
    }
}
