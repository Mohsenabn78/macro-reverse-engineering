package com.google.firebase.iid;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.messaging.Constants;
import com.google.firebase.platforminfo.UserAgentPublisher;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
@KeepForSdk
/* loaded from: classes5.dex */
public class GmsRpc {
    @KeepForSdk
    public static final String ERROR_INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";
    @KeepForSdk
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseApp f31469a;

    /* renamed from: b  reason: collision with root package name */
    private final Metadata f31470b;

    /* renamed from: c  reason: collision with root package name */
    private final Rpc f31471c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<UserAgentPublisher> f31472d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<HeartBeatInfo> f31473e;

    /* renamed from: f  reason: collision with root package name */
    private final FirebaseInstallationsApi f31474f;

    @VisibleForTesting
    GmsRpc(FirebaseApp firebaseApp, Metadata metadata, Rpc rpc, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this.f31469a = firebaseApp;
        this.f31470b = metadata;
        this.f31471c = rpc;
        this.f31472d = provider;
        this.f31473e = provider2;
        this.f31474f = firebaseInstallationsApi;
    }

    private static String a(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    private Task<String> b(Task<Bundle> task) {
        return task.continueWith(FirebaseIidExecutors.a(), new Continuation(this) { // from class: com.google.firebase.iid.GmsRpc$$Lambda$0

            /* renamed from: a  reason: collision with root package name */
            private final GmsRpc f31475a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f31475a = this;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public Object then(Task task2) {
                return this.f31475a.f(task2);
            }
        });
    }

    private String c() {
        try {
            return a(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA1).digest(this.f31469a.getName().getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    @AnyThread
    private String d(Bundle bundle) throws IOException {
        if (bundle != null) {
            String string = bundle.getString("registration_id");
            if (string != null) {
                return string;
            }
            String string2 = bundle.getString("unregistered");
            if (string2 != null) {
                return string2;
            }
            String string3 = bundle.getString(Constants.IPC_BUNDLE_KEY_SEND_ERROR);
            if (!"RST".equals(string3)) {
                if (string3 != null) {
                    throw new IOException(string3);
                }
                String valueOf = String.valueOf(bundle);
                StringBuilder sb = new StringBuilder(valueOf.length() + 21);
                sb.append("Unexpected response: ");
                sb.append(valueOf);
                Log.w("FirebaseInstanceId", sb.toString(), new Throwable());
                throw new IOException(ERROR_SERVICE_NOT_AVAILABLE);
            }
            throw new IOException("INSTANCE_ID_RESET");
        }
        throw new IOException(ERROR_SERVICE_NOT_AVAILABLE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(String str) {
        if (!ERROR_SERVICE_NOT_AVAILABLE.equals(str) && !ERROR_INTERNAL_SERVER_ERROR.equals(str) && !"InternalServerError".equals(str)) {
            return false;
        }
        return true;
    }

    private Bundle g(String str, String str2, String str3, Bundle bundle) {
        HeartBeatInfo.HeartBeat heartBeatCode;
        bundle.putString("scope", str3);
        bundle.putString("sender", str2);
        bundle.putString("subtype", str2);
        bundle.putString("appid", str);
        bundle.putString("gmp_app_id", this.f31469a.getOptions().getApplicationId());
        bundle.putString("gmsv", Integer.toString(this.f31470b.getGmsVersionCode()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f31470b.getAppVersionCode());
        bundle.putString("app_ver_name", this.f31470b.getAppVersionName());
        bundle.putString("firebase-app-name-hash", c());
        try {
            String token = ((InstallationTokenResult) Tasks.await(this.f31474f.getToken(false))).getToken();
            if (!TextUtils.isEmpty(token)) {
                bundle.putString("Goog-Firebase-Installations-Auth", token);
            } else {
                Log.w("FirebaseInstanceId", "FIS auth token is empty");
            }
        } catch (InterruptedException | ExecutionException e4) {
            Log.e("FirebaseInstanceId", "Failed to get FIS auth token", e4);
        }
        bundle.putString("cliv", "fiid-21.1.0");
        HeartBeatInfo heartBeatInfo = this.f31473e.get();
        UserAgentPublisher userAgentPublisher = this.f31472d.get();
        if (heartBeatInfo != null && userAgentPublisher != null && (heartBeatCode = heartBeatInfo.getHeartBeatCode("fire-iid")) != HeartBeatInfo.HeartBeat.NONE) {
            bundle.putString("Firebase-Client-Log-Type", Integer.toString(heartBeatCode.getCode()));
            bundle.putString("Firebase-Client", userAgentPublisher.getUserAgent());
        }
        return bundle;
    }

    private Task<Bundle> h(String str, String str2, String str3, Bundle bundle) {
        g(str, str2, str3, bundle);
        return this.f31471c.send(bundle);
    }

    public Task<?> deleteInstanceId(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("iid-operation", "delete");
        bundle.putString("delete", "1");
        return b(h(str, "*", "*", bundle));
    }

    public Task<?> deleteToken(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("delete", "1");
        return b(h(str, str2, str3, bundle));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String f(Task task) throws Exception {
        return d((Bundle) task.getResult(IOException.class));
    }

    public Task<String> getToken(String str, String str2, String str3) {
        return b(h(str, str2, str3, new Bundle()));
    }

    @KeepForSdk
    public Task<?> subscribeToTopic(String str, String str2, String str3) {
        String str4;
        String str5;
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        if (valueOf.length() != 0) {
            str4 = "/topics/".concat(valueOf);
        } else {
            str4 = new String("/topics/");
        }
        bundle.putString("gcm.topic", str4);
        String valueOf2 = String.valueOf(str3);
        if (valueOf2.length() != 0) {
            str5 = "/topics/".concat(valueOf2);
        } else {
            str5 = new String("/topics/");
        }
        return b(h(str, str2, str5, bundle));
    }

    @KeepForSdk
    public Task<?> unsubscribeFromTopic(String str, String str2, String str3) {
        String str4;
        String str5;
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        if (valueOf.length() != 0) {
            str4 = "/topics/".concat(valueOf);
        } else {
            str4 = new String("/topics/");
        }
        bundle.putString("gcm.topic", str4);
        bundle.putString("delete", "1");
        String valueOf2 = String.valueOf(str3);
        if (valueOf2.length() != 0) {
            str5 = "/topics/".concat(valueOf2);
        } else {
            str5 = new String("/topics/");
        }
        return b(h(str, str2, str5, bundle));
    }

    public GmsRpc(FirebaseApp firebaseApp, Metadata metadata, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this(firebaseApp, metadata, new Rpc(firebaseApp.getApplicationContext()), provider, provider2, firebaseInstallationsApi);
    }
}
