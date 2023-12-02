package com.arlosoft.macrodroid.action.outputservices;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import com.afollestad.materialdialogs.MaterialDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.outputservices.TwitterOutput;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import java.io.InputStream;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

/* loaded from: classes2.dex */
public class TwitterOutput {

    /* renamed from: a  reason: collision with root package name */
    private static RequestToken f4546a;

    /* renamed from: b  reason: collision with root package name */
    private static Twitter f4547b;

    /* loaded from: classes2.dex */
    public interface TwitterAuthListener {
        void twitterAuthOK();
    }

    /* loaded from: classes2.dex */
    public enum TwitterStatus {
        Ok,
        ConnectionFailure,
        AuthenticationFailure,
        AlreadyUploaded
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        private Activity f4549a;

        /* renamed from: b  reason: collision with root package name */
        private final Context f4550b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f4551c;

        /* renamed from: d  reason: collision with root package name */
        private final TwitterAuthListener f4552d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f4553e;

        /* renamed from: f  reason: collision with root package name */
        private MaterialDialog f4554f;

        public a(Context context, TwitterAuthListener twitterAuthListener) {
            this.f4549a = null;
            this.f4550b = context;
            if (context instanceof Activity) {
                this.f4549a = (Activity) context;
            }
            this.f4551c = false;
            this.f4552d = twitterAuthListener;
            this.f4553e = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(DialogInterface dialogInterface) {
            this.f4553e = true;
            dialogInterface.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c */
        public Void doInBackground(Void... voidArr) {
            MacroDroidApplication macroDroidApplication = MacroDroidApplication.getInstance();
            try {
                Twitter unused = TwitterOutput.f4547b = new TwitterFactory().getInstance();
                CookieSyncManager.createInstance(macroDroidApplication);
                CookieManager.getInstance().removeSessionCookie();
                TwitterOutput.f4547b.setOAuthAccessToken(null);
            } catch (Exception unused2) {
            }
            TwitterOutput.f4547b.setOAuthConsumer("trfRjDyxtteiIGveHUmMAFoyt", "cvxTiGth538SF0jqOSXPd3wEGY8WFdmPTaI4QNVggjvIvnHH1f");
            try {
                RequestToken unused3 = TwitterOutput.f4546a = TwitterOutput.f4547b.getOAuthRequestToken(macroDroidApplication.getResources().getString(R.string.twitter_callback));
                if (!this.f4553e) {
                    Intent intent = new Intent(macroDroidApplication, TwitterWebViewActivity.class);
                    intent.putExtra("URL", TwitterOutput.f4546a.getAuthenticationURL() + "&force_login=true");
                    intent.addFlags(268435456);
                    this.f4550b.startActivity(intent);
                }
            } catch (TwitterException e4) {
                Log.w("TwitterOutput", "Failed Twitter Auth request: " + e4.getMessage());
                this.f4551c = true;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: f */
        public void onPostExecute(Void r4) {
            try {
                if (!this.f4553e && this.f4549a != null) {
                    this.f4554f.dismiss();
                    if (this.f4551c) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(this.f4549a, R.style.Theme_App_Dialog);
                        builder.setTitle(this.f4549a.getString(R.string.twitter_connection_failed));
                        builder.setMessage(this.f4549a.getString(R.string.check_internet_before_retrying)).setCancelable(false).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.outputservices.a
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i4) {
                                dialogInterface.cancel();
                            }
                        });
                        builder.create().show();
                    } else {
                        TwitterAuthListener twitterAuthListener = this.f4552d;
                        if (twitterAuthListener != null) {
                            twitterAuthListener.twitterAuthOK();
                        }
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            Activity activity = this.f4549a;
            if (activity != null) {
                MaterialDialog show = new MaterialDialog.Builder(activity).title(R.string.please_wait).content(R.string.initialising_twitter).progress(true, 0).cancelable(false).widgetColor(ContextCompat.getColor(this.f4549a, R.color.actions_primary)).show();
                this.f4554f = show;
                show.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.outputservices.b
                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface) {
                        TwitterOutput.a.this.e(dialogInterface);
                    }
                });
            }
        }
    }

    public static void clearTwitterAccount(Context context) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.remove("twitter_access_token");
        edit.remove("twitter_access_token_secret");
        edit.apply();
    }

    public static RequestToken getRequestToken() {
        return f4546a;
    }

    public static Twitter getTwitter() {
        return f4547b;
    }

    public static boolean isTwitterAccountConfigured(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String string = defaultSharedPreferences.getString("twitter_access_token", "");
        String string2 = defaultSharedPreferences.getString("twitter_access_token_secret", "");
        if (string != null && string2 != null && string.length() > 0 && string2.length() > 0) {
            return true;
        }
        return false;
    }

    public static void setupTwitter(Context context, TwitterAuthListener twitterAuthListener) {
        new a(context, twitterAuthListener).execute((Object[]) null);
    }

    public static TwitterStatus uploadMessage(Context context, String str) {
        TwitterStatus twitterStatus;
        TwitterStatus twitterStatus2 = TwitterStatus.Ok;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String string = defaultSharedPreferences.getString("twitter_access_token", "");
        try {
            new TwitterFactory(new ConfigurationBuilder().setOAuthConsumerKey("trfRjDyxtteiIGveHUmMAFoyt").setOAuthConsumerSecret("cvxTiGth538SF0jqOSXPd3wEGY8WFdmPTaI4QNVggjvIvnHH1f").setOAuthAccessToken(string).setOAuthAccessTokenSecret(defaultSharedPreferences.getString("twitter_access_token_secret", "")).build()).getInstance().updateStatus(str);
            return twitterStatus2;
        } catch (TwitterException e4) {
            SystemLog.logError("Twitter upload failed: " + e4.getErrorMessage());
            String errorMessage = e4.getErrorMessage();
            if (errorMessage != null && errorMessage.contains("duplicate")) {
                twitterStatus = TwitterStatus.AlreadyUploaded;
            } else if (e4.getStatusCode() != 401 && e4.getStatusCode() != 403) {
                if (errorMessage != null && errorMessage.contains("not authenticate")) {
                    twitterStatus = TwitterStatus.AuthenticationFailure;
                } else {
                    twitterStatus = TwitterStatus.ConnectionFailure;
                }
            } else {
                clearTwitterAccount(context);
                SystemLog.logError("Please re-configure the action");
                twitterStatus = TwitterStatus.AuthenticationFailure;
            }
            return twitterStatus;
        } catch (Exception e5) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Unexpected Twitter Failure: " + e5.getMessage()));
            return twitterStatus2;
        }
    }

    public static TwitterStatus uploadPhoto(Context context, Uri uri) {
        TwitterStatus twitterStatus;
        TwitterStatus twitterStatus2 = TwitterStatus.Ok;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String string = defaultSharedPreferences.getString("twitter_access_token", "");
        String string2 = defaultSharedPreferences.getString("twitter_access_token_secret", "");
        if (string.length() != 0 && string2.length() != 0) {
            Configuration build = new ConfigurationBuilder().setOAuthConsumerKey("trfRjDyxtteiIGveHUmMAFoyt").setOAuthConsumerSecret("cvxTiGth538SF0jqOSXPd3wEGY8WFdmPTaI4QNVggjvIvnHH1f").setOAuthAccessToken(string).setOAuthAccessTokenSecret(string2).build();
            InputStream inputStream = null;
            try {
                try {
                    inputStream = context.getContentResolver().openInputStream(uri);
                    Twitter twitterFactory = new TwitterFactory(build).getInstance();
                    StatusUpdate statusUpdate = new StatusUpdate("");
                    statusUpdate.setMedia("", inputStream);
                    twitterFactory.updateStatus(statusUpdate);
                } catch (Exception e4) {
                    String message = e4.getMessage();
                    Log.w("TwitterOutput", "Twitter upload photo failed: " + message);
                    if (message != null && message.contains("duplicate")) {
                        twitterStatus = TwitterStatus.AlreadyUploaded;
                    } else if (message != null && message.contains("not authenticate")) {
                        twitterStatus = TwitterStatus.AuthenticationFailure;
                    } else {
                        twitterStatus = TwitterStatus.ConnectionFailure;
                    }
                    twitterStatus2 = twitterStatus;
                }
                try {
                    inputStream.close();
                } catch (Exception unused) {
                    return twitterStatus2;
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } else {
            return TwitterStatus.AuthenticationFailure;
        }
    }
}
