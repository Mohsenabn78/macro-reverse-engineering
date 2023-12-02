package com.google.firebase.messaging;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.platforminfo.UserAgentPublisher;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class GmsRpc {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseApp f31665a;

    /* renamed from: b  reason: collision with root package name */
    private final Metadata f31666b;

    /* renamed from: c  reason: collision with root package name */
    private final Rpc f31667c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<UserAgentPublisher> f31668d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<HeartBeatInfo> f31669e;

    /* renamed from: f  reason: collision with root package name */
    private final FirebaseInstallationsApi f31670f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GmsRpc(FirebaseApp firebaseApp, Metadata metadata, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this(firebaseApp, metadata, new Rpc(firebaseApp.getApplicationContext()), provider, provider2, firebaseInstallationsApi);
    }

    private static String b(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    private Task<String> d(Task<Bundle> task) {
        return task.continueWith(new androidx.biometric.auth.a(), new Continuation() { // from class: com.google.firebase.messaging.v
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                String i4;
                i4 = GmsRpc.this.i(task2);
                return i4;
            }
        });
    }

    private String e() {
        try {
            return b(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA1).digest(this.f31665a.getName().getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    @AnyThread
    private String g(Bundle bundle) throws IOException {
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
                Log.w(Constants.TAG, "Unexpected response: " + bundle, new Throwable());
                throw new IOException(com.google.firebase.iid.GmsRpc.ERROR_SERVICE_NOT_AVAILABLE);
            }
            throw new IOException("INSTANCE_ID_RESET");
        }
        throw new IOException(com.google.firebase.iid.GmsRpc.ERROR_SERVICE_NOT_AVAILABLE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h(String str) {
        if (!com.google.firebase.iid.GmsRpc.ERROR_SERVICE_NOT_AVAILABLE.equals(str) && !com.google.firebase.iid.GmsRpc.ERROR_INTERNAL_SERVER_ERROR.equals(str) && !"InternalServerError".equals(str)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String i(Task task) throws Exception {
        return g((Bundle) task.getResult(IOException.class));
    }

    private void j(String str, String str2, Bundle bundle) throws ExecutionException, InterruptedException {
        HeartBeatInfo.HeartBeat heartBeatCode;
        bundle.putString("scope", str2);
        bundle.putString("sender", str);
        bundle.putString("subtype", str);
        bundle.putString("gmp_app_id", this.f31665a.getOptions().getApplicationId());
        bundle.putString("gmsv", Integer.toString(this.f31666b.d()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f31666b.a());
        bundle.putString("app_ver_name", this.f31666b.b());
        bundle.putString("firebase-app-name-hash", e());
        try {
            String token = ((InstallationTokenResult) Tasks.await(this.f31670f.getToken(false))).getToken();
            if (!TextUtils.isEmpty(token)) {
                bundle.putString("Goog-Firebase-Installations-Auth", token);
            } else {
                Log.w(Constants.TAG, "FIS auth token is empty");
            }
        } catch (InterruptedException | ExecutionException e4) {
            Log.e(Constants.TAG, "Failed to get FIS auth token", e4);
        }
        bundle.putString("appid", (String) Tasks.await(this.f31670f.getId()));
        bundle.putString("cliv", "fcm-" + BuildConfig.VERSION_NAME);
        HeartBeatInfo heartBeatInfo = this.f31669e.get();
        UserAgentPublisher userAgentPublisher = this.f31668d.get();
        if (heartBeatInfo != null && userAgentPublisher != null && (heartBeatCode = heartBeatInfo.getHeartBeatCode("fire-iid")) != HeartBeatInfo.HeartBeat.NONE) {
            bundle.putString("Firebase-Client-Log-Type", Integer.toString(heartBeatCode.getCode()));
            bundle.putString("Firebase-Client", userAgentPublisher.getUserAgent());
        }
    }

    private Task<Bundle> k(String str, String str2, Bundle bundle) {
        try {
            j(str, str2, bundle);
            return this.f31667c.send(bundle);
        } catch (InterruptedException | ExecutionException e4) {
            return Tasks.forException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<?> c() {
        Bundle bundle = new Bundle();
        bundle.putString("delete", "1");
        return d(k(Metadata.c(this.f31665a), "*", bundle));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<String> f() {
        return d(k(Metadata.c(this.f31665a), "*", new Bundle()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<?> l(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        return d(k(str, "/topics/" + str2, bundle));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<?> m(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        bundle.putString("delete", "1");
        return d(k(str, "/topics/" + str2, bundle));
    }

    @VisibleForTesting
    GmsRpc(FirebaseApp firebaseApp, Metadata metadata, Rpc rpc, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this.f31665a = firebaseApp;
        this.f31666b = metadata;
        this.f31667c = rpc;
        this.f31668d = provider;
        this.f31669e = provider2;
        this.f31670f = firebaseInstallationsApi;
    }
}
