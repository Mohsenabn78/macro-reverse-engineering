package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.firebase.FirebaseApp;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
@KeepForSdk
/* loaded from: classes5.dex */
public class Metadata {

    /* renamed from: a  reason: collision with root package name */
    private final Context f31478a;
    @GuardedBy("this")

    /* renamed from: b  reason: collision with root package name */
    private String f31479b;
    @GuardedBy("this")

    /* renamed from: c  reason: collision with root package name */
    private String f31480c;
    @GuardedBy("this")

    /* renamed from: d  reason: collision with root package name */
    private int f31481d;
    @GuardedBy("this")

    /* renamed from: e  reason: collision with root package name */
    private int f31482e = 0;

    public Metadata(Context context) {
        this.f31478a = context;
    }

    private PackageInfo a(String str) {
        try {
            return this.f31478a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e4) {
            String valueOf = String.valueOf(e4);
            StringBuilder sb = new StringBuilder(valueOf.length() + 23);
            sb.append("Failed to find package ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    private synchronized void b() {
        PackageInfo a4 = a(this.f31478a.getPackageName());
        if (a4 != null) {
            this.f31479b = Integer.toString(a4.versionCode);
            this.f31480c = a4.versionName;
        }
    }

    public static String getDefaultSenderId(FirebaseApp firebaseApp) {
        String gcmSenderId = firebaseApp.getOptions().getGcmSenderId();
        if (gcmSenderId != null) {
            return gcmSenderId;
        }
        String applicationId = firebaseApp.getOptions().getApplicationId();
        if (!applicationId.startsWith("1:")) {
            return applicationId;
        }
        String[] split = applicationId.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    public synchronized String getAppVersionCode() {
        if (this.f31479b == null) {
            b();
        }
        return this.f31479b;
    }

    public synchronized String getAppVersionName() {
        if (this.f31480c == null) {
            b();
        }
        return this.f31480c;
    }

    public synchronized int getGmsVersionCode() {
        PackageInfo a4;
        if (this.f31481d == 0 && (a4 = a("com.google.android.gms")) != null) {
            this.f31481d = a4.versionCode;
        }
        return this.f31481d;
    }

    public synchronized int getIidImplementation() {
        int i4 = this.f31482e;
        if (i4 != 0) {
            return i4;
        }
        PackageManager packageManager = this.f31478a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseInstanceId", "Google Play services missing or without correct permission.");
            return 0;
        }
        int i5 = 1;
        if (!PlatformVersion.isAtLeastO()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.f31482e = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
            this.f31482e = 2;
            return 2;
        }
        Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
        if (PlatformVersion.isAtLeastO()) {
            this.f31482e = 2;
            i5 = 2;
        } else {
            this.f31482e = 1;
        }
        return i5;
    }

    @KeepForSdk
    public boolean isGmscorePresent() {
        if (getIidImplementation() != 0) {
            return true;
        }
        return false;
    }
}
