package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
/* loaded from: classes5.dex */
public class Store {

    /* renamed from: a  reason: collision with root package name */
    final SharedPreferences f31494a;

    /* renamed from: b  reason: collision with root package name */
    final Context f31495b;
    @GuardedBy("this")

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Long> f31496c = new ArrayMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
    /* loaded from: classes5.dex */
    public static class Token {

        /* renamed from: d  reason: collision with root package name */
        private static final long f31497d = TimeUnit.DAYS.toMillis(7);

        /* renamed from: a  reason: collision with root package name */
        final String f31498a;

        /* renamed from: b  reason: collision with root package name */
        final String f31499b;

        /* renamed from: c  reason: collision with root package name */
        final long f31500c;

        private Token(String str, String str2, long j4) {
            this.f31498a = str;
            this.f31499b = str2;
            this.f31500c = j4;
        }

        static String a(String str, String str2, long j4) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", str);
                jSONObject.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, str2);
                jSONObject.put("timestamp", j4);
                return jSONObject.toString();
            } catch (JSONException e4) {
                String valueOf = String.valueOf(e4);
                StringBuilder sb = new StringBuilder(valueOf.length() + 24);
                sb.append("Failed to encode token: ");
                sb.append(valueOf);
                Log.w("FirebaseInstanceId", sb.toString());
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static String b(@Nullable Token token) {
            if (token == null) {
                return null;
            }
            return token.f31498a;
        }

        static Token d(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.startsWith("{")) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    return new Token(jSONObject.getString("token"), jSONObject.getString(RemoteConfigConstants.RequestFieldKey.APP_VERSION), jSONObject.getLong("timestamp"));
                } catch (JSONException e4) {
                    String valueOf = String.valueOf(e4);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 23);
                    sb.append("Failed to parse token: ");
                    sb.append(valueOf);
                    Log.w("FirebaseInstanceId", sb.toString());
                    return null;
                }
            }
            return new Token(str, null, 0L);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean c(String str) {
            if (System.currentTimeMillis() <= this.f31500c + f31497d && str.equals(this.f31499b)) {
                return false;
            }
            return true;
        }
    }

    public Store(Context context) {
        this.f31495b = context;
        this.f31494a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        a("com.google.android.gms.appid-no-backup");
    }

    private void a(String str) {
        File file = new File(ContextCompat.getNoBackupFilesDir(this.f31495b), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (file.createNewFile() && !i()) {
                Log.i("FirebaseInstanceId", "App restored, clearing state");
                d();
            }
        } catch (IOException e4) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e4.getMessage());
                if (valueOf.length() != 0) {
                    "Error creating file in no backup dir: ".concat(valueOf);
                }
            }
        }
    }

    static String b(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 6);
        sb.append(str);
        sb.append("|S|cre");
        return sb.toString();
    }

    private String c(String str, String str2, String str3) {
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        return sb.toString();
    }

    private long g(String str) {
        String string = this.f31494a.getString(b(str, "cre"), null);
        if (string != null) {
            try {
                return Long.parseLong(string);
            } catch (NumberFormatException unused) {
                return 0L;
            }
        }
        return 0L;
    }

    private long l(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f31494a.contains(b(str, "cre"))) {
            SharedPreferences.Editor edit = this.f31494a.edit();
            edit.putString(b(str, "cre"), String.valueOf(currentTimeMillis));
            edit.commit();
            return currentTimeMillis;
        }
        return g(str);
    }

    public synchronized void d() {
        this.f31496c.clear();
        this.f31494a.edit().clear().commit();
    }

    public synchronized void e(String str, String str2, String str3) {
        String c4 = c(str, str2, str3);
        SharedPreferences.Editor edit = this.f31494a.edit();
        edit.remove(c4);
        edit.commit();
    }

    public synchronized long f(String str) {
        Long l4 = this.f31496c.get(str);
        if (l4 != null) {
            return l4.longValue();
        }
        return g(str);
    }

    public synchronized Token h(String str, String str2, String str3) {
        return Token.d(this.f31494a.getString(c(str, str2, str3), null));
    }

    public synchronized boolean i() {
        return this.f31494a.getAll().isEmpty();
    }

    public synchronized void j(String str, String str2, String str3, String str4, String str5) {
        String a4 = Token.a(str4, str5, System.currentTimeMillis());
        if (a4 == null) {
            return;
        }
        SharedPreferences.Editor edit = this.f31494a.edit();
        edit.putString(c(str, str2, str3), a4);
        edit.commit();
    }

    public synchronized long k(String str) {
        long l4;
        l4 = l(str);
        this.f31496c.put(str, Long.valueOf(l4));
        return l4;
    }
}
