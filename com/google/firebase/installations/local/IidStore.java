package com.google.firebase.installations.local;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.common.base.Ascii;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class IidStore {

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f31564c = {"*", FirebaseMessaging.INSTANCE_ID_SCOPE, "GCM", ""};
    @GuardedBy("iidPrefs")

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f31565a;

    /* renamed from: b  reason: collision with root package name */
    private final String f31566b;

    public IidStore(@NonNull FirebaseApp firebaseApp) {
        this.f31565a = firebaseApp.getApplicationContext().getSharedPreferences("com.google.android.gms.appid", 0);
        this.f31566b = b(firebaseApp);
    }

    private String a(@NonNull String str, @NonNull String str2) {
        return "|T|" + str + "|" + str2;
    }

    private static String b(FirebaseApp firebaseApp) {
        String gcmSenderId = firebaseApp.getOptions().getGcmSenderId();
        if (gcmSenderId != null) {
            return gcmSenderId;
        }
        String applicationId = firebaseApp.getOptions().getApplicationId();
        if (!applicationId.startsWith("1:") && !applicationId.startsWith("2:")) {
            return applicationId;
        }
        String[] split = applicationId.split(":");
        if (split.length != 4) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    @Nullable
    private static String c(@NonNull PublicKey publicKey) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(publicKey.getEncoded());
            digest[0] = (byte) (((digest[0] & Ascii.SI) + 112) & 255);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            Log.w("ContentValues", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    private String d(String str) {
        try {
            return new JSONObject(str).getString("token");
        } catch (JSONException unused) {
            return null;
        }
    }

    @Nullable
    private PublicKey e(String str) {
        try {
            return KeyFactory.getInstance(KeyPropertiesCompact.KEY_ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 8)));
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e4) {
            Log.w("ContentValues", "Invalid key stored " + e4);
            return null;
        }
    }

    @Nullable
    private String f() {
        String string;
        synchronized (this.f31565a) {
            string = this.f31565a.getString("|S|id", null);
        }
        return string;
    }

    @Nullable
    private String g() {
        synchronized (this.f31565a) {
            String string = this.f31565a.getString("|S||P|", null);
            if (string == null) {
                return null;
            }
            PublicKey e4 = e(string);
            if (e4 == null) {
                return null;
            }
            return c(e4);
        }
    }

    @Nullable
    public String readIid() {
        synchronized (this.f31565a) {
            String f4 = f();
            if (f4 != null) {
                return f4;
            }
            return g();
        }
    }

    @Nullable
    public String readToken() {
        synchronized (this.f31565a) {
            for (String str : f31564c) {
                String string = this.f31565a.getString(a(this.f31566b, str), null);
                if (string != null && !string.isEmpty()) {
                    if (string.startsWith("{")) {
                        string = d(string);
                    }
                    return string;
                }
            }
            return null;
        }
    }

    @VisibleForTesting
    public IidStore(@NonNull SharedPreferences sharedPreferences, @Nullable String str) {
        this.f31565a = sharedPreferences;
        this.f31566b = str;
    }
}
