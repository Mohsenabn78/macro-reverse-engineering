package com.arlosoft.macrodroid.utils;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.email.EmailOauthConfigureActivity;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.settings.Settings;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.services.gmail.GmailScopes;
import java.util.Arrays;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class GmailHelper {
    public static final int REQUEST_ACCOUNT_PICKER = 1000;

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f16035d = {GmailScopes.GMAIL_SEND};

    /* renamed from: e  reason: collision with root package name */
    private static GmailHelper f16036e;

    /* renamed from: a  reason: collision with root package name */
    private final String f16037a = "GmailHelper";

    /* renamed from: b  reason: collision with root package name */
    private final Context f16038b;

    /* renamed from: c  reason: collision with root package name */
    private GoogleAccountCredential f16039c;

    /* loaded from: classes3.dex */
    class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f16040a;

        a(String str) {
            this.f16040a = str;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                AccountManager.get(GmailHelper.this.f16038b).getAuthToken(new Account(this.f16040a, "com.google"), "oauth2:https://www.googleapis.com/auth/gmail.send", (Bundle) null, true, (AccountManagerCallback<Bundle>) null, (Handler) null);
            } catch (Exception unused) {
            }
        }
    }

    private GmailHelper(Context context) {
        this.f16038b = context;
    }

    private boolean b() {
        return true;
    }

    public static GmailHelper getInstance(Context context) {
        if (f16036e == null) {
            f16036e = new GmailHelper(context);
        }
        return f16036e;
    }

    public void chooseAccount(GoogleAccountCredential googleAccountCredential, Activity activity) {
        try {
            activity.startActivityForResult(googleAccountCredential.newChooseAccountIntent(), 1000);
        } catch (ActivityNotFoundException e4) {
            ToastCompat.makeText(this.f16038b.getApplicationContext(), (CharSequence) String.format(this.f16038b.getString(R.string.common_google_play_services_unsupported_text), this.f16038b.getString(R.string.send_email)), 0).show();
            SystemLog.logError("No activity found for REQUEST_ACCOUNT_PICKER: " + e4.toString());
        }
    }

    public GoogleAccountCredential getCredentials() {
        if (this.f16039c == null) {
            this.f16039c = GoogleAccountCredential.usingOAuth2(this.f16038b.getApplicationContext(), Arrays.asList(f16035d)).setBackOff(new ExponentialBackOff()).setSelectedAccountName(this.f16038b.getSharedPreferences("GmailHelper", 0).getString("accountName", null));
        }
        return this.f16039c;
    }

    public boolean handleActivityResult(int i4, int i5, Intent intent) {
        if (this.f16039c == null) {
            this.f16039c = GoogleAccountCredential.usingOAuth2(this.f16038b.getApplicationContext(), Arrays.asList(f16035d)).setBackOff(new ExponentialBackOff()).setSelectedAccountName(this.f16038b.getSharedPreferences("GmailHelper", 0).getString("accountName", null));
        }
        if (i4 != 1000) {
            if (i4 == 1002 && i5 != -1) {
                b();
            }
        } else if (i5 == -1 && intent != null && intent.getExtras() != null) {
            String stringExtra = intent.getStringExtra("authAccount");
            if (stringExtra == null) {
                return false;
            }
            this.f16039c.setSelectedAccountName(stringExtra);
            SharedPreferences.Editor edit = this.f16038b.getSharedPreferences("GmailHelper", 0).edit();
            edit.putString("accountName", stringExtra);
            edit.apply();
            Settings.setEmailGmailAddress(this.f16038b, stringExtra);
            new a(stringExtra).start();
            return true;
        }
        return true;
    }

    public void showAccountNotConfiguredNotification() {
        NotificationManagerCompat.from(this.f16038b).notify(787434, new NotificationCompat.Builder(this.f16038b).setSmallIcon(R.drawable.ic_warning_white_24dp).setContentTitle(this.f16038b.getString(R.string.gmail_config_required)).setContentText(this.f16038b.getString(R.string.click_to_configure_gmail)).setContentIntent(PendingIntent.getActivity(this.f16038b, 0, new Intent(this.f16038b, EmailOauthConfigureActivity.class), 268435456 | PendingIntentHelper.FLAG_IMMUTABLE)).setPriority(2).setDefaults(-1).setChannelId(Constants.NOTIFICATION_CHANNEL_INFO).setAutoCancel(true).build());
    }

    public void showAuthorizatinRequireNotification(Intent intent) {
        NotificationManagerCompat.from(this.f16038b).notify(787434, new NotificationCompat.Builder(this.f16038b).setSmallIcon(R.drawable.ic_warning_white_24dp).setContentTitle(this.f16038b.getString(R.string.gmail_config_required)).setContentText(this.f16038b.getString(R.string.click_to_authorize_gmail)).setContentIntent(PendingIntent.getActivity(this.f16038b, 0, intent, 268435456 | PendingIntentHelper.FLAG_IMMUTABLE)).setPriority(2).setDefaults(-1).setChannelId(Constants.NOTIFICATION_CHANNEL_INFO).setAutoCancel(true).build());
    }

    public void updateAccountName(String str) {
        SharedPreferences.Editor edit = this.f16038b.getSharedPreferences("GmailHelper", 0).edit();
        edit.putString("accountName", str);
        edit.apply();
        this.f16039c = GoogleAccountCredential.usingOAuth2(this.f16038b.getApplicationContext(), Arrays.asList(f16035d)).setBackOff(new ExponentialBackOff()).setSelectedAccountName(str);
    }

    public void useDefaultGoogleAccount() {
        Account account;
        Account[] accountsByType = AccountManager.get(this.f16038b).getAccountsByType("com.google");
        if (accountsByType.length > 0) {
            account = accountsByType[0];
        } else {
            account = null;
        }
        if (account != null) {
            SharedPreferences.Editor edit = this.f16038b.getSharedPreferences("GmailHelper", 0).edit();
            edit.putString("accountName", account.name);
            edit.apply();
        }
    }
}
