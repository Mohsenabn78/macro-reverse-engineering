package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class Store {

    /* renamed from: a  reason: collision with root package name */
    final SharedPreferences f31725a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class Token {

        /* renamed from: d  reason: collision with root package name */
        private static final long f31726d = TimeUnit.DAYS.toMillis(7);

        /* renamed from: a  reason: collision with root package name */
        final String f31727a;

        /* renamed from: b  reason: collision with root package name */
        final String f31728b;

        /* renamed from: c  reason: collision with root package name */
        final long f31729c;

        private Token(String str, String str2, long j4) {
            this.f31727a = str;
            this.f31728b = str2;
            this.f31729c = j4;
        }

        static String a(String str, String str2, long j4) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", str);
                jSONObject.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, str2);
                jSONObject.put("timestamp", j4);
                return jSONObject.toString();
            } catch (JSONException e4) {
                Log.w(Constants.TAG, "Failed to encode token: " + e4);
                return null;
            }
        }

        static Token c(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.startsWith("{")) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    return new Token(jSONObject.getString("token"), jSONObject.getString(RemoteConfigConstants.RequestFieldKey.APP_VERSION), jSONObject.getLong("timestamp"));
                } catch (JSONException e4) {
                    Log.w(Constants.TAG, "Failed to parse token: " + e4);
                    return null;
                }
            }
            return new Token(str, null, 0L);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean b(String str) {
            if (System.currentTimeMillis() <= this.f31729c + f31726d && str.equals(this.f31728b)) {
                return false;
            }
            return true;
        }
    }

    public Store(Context context) {
        this.f31725a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        a(context, "com.google.android.gms.appid-no-backup");
    }

    private void a(Context context, String str) {
        File file = new File(ContextCompat.getNoBackupFilesDir(context), str);
        if (file.exists()) {
            return;
        }
        try {
            if (file.createNewFile() && !f()) {
                Log.i(Constants.TAG, "App restored, clearing state");
                c();
            }
        } catch (IOException e4) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Error creating file in no backup dir: ");
                sb.append(e4.getMessage());
            }
        }
    }

    private String b(String str, String str2) {
        return str + "|T|" + str2 + "|*";
    }

    public synchronized void c() {
        this.f31725a.edit().clear().commit();
    }

    public synchronized void d(String str, String str2) {
        String b4 = b(str, str2);
        SharedPreferences.Editor edit = this.f31725a.edit();
        edit.remove(b4);
        edit.commit();
    }

    public synchronized Token e(String str, String str2) {
        return Token.c(this.f31725a.getString(b(str, str2), null));
    }

    public synchronized boolean f() {
        return this.f31725a.getAll().isEmpty();
    }

    public synchronized void g(String str, String str2, String str3, String str4) {
        String a4 = Token.a(str3, str4, System.currentTimeMillis());
        if (a4 == null) {
            return;
        }
        SharedPreferences.Editor edit = this.f31725a.edit();
        edit.putString(b(str, str2), a4);
        edit.commit();
    }
}
