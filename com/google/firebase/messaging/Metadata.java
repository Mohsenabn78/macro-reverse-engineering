package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import androidx.annotation.GuardedBy;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.firebase.FirebaseApp;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class Metadata {

    /* renamed from: a  reason: collision with root package name */
    private final Context f31674a;
    @GuardedBy("this")

    /* renamed from: b  reason: collision with root package name */
    private String f31675b;
    @GuardedBy("this")

    /* renamed from: c  reason: collision with root package name */
    private String f31676c;
    @GuardedBy("this")

    /* renamed from: d  reason: collision with root package name */
    private int f31677d;
    @GuardedBy("this")

    /* renamed from: e  reason: collision with root package name */
    private int f31678e = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Metadata(Context context) {
        this.f31674a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(FirebaseApp firebaseApp) {
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

    private PackageInfo f(String str) {
        try {
            return this.f31674a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e4) {
            Log.w(Constants.TAG, "Failed to find package " + e4);
            return null;
        }
    }

    private synchronized void h() {
        PackageInfo f4 = f(this.f31674a.getPackageName());
        if (f4 != null) {
            this.f31675b = Integer.toString(f4.versionCode);
            this.f31676c = f4.versionName;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String a() {
        if (this.f31675b == null) {
            h();
        }
        return this.f31675b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String b() {
        if (this.f31676c == null) {
            h();
        }
        return this.f31676c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int d() {
        PackageInfo f4;
        if (this.f31677d == 0 && (f4 = f("com.google.android.gms")) != null) {
            this.f31677d = f4.versionCode;
        }
        return this.f31677d;
    }

    synchronized int e() {
        int i4 = this.f31678e;
        if (i4 != 0) {
            return i4;
        }
        PackageManager packageManager = this.f31674a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e(Constants.TAG, "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!PlatformVersion.isAtLeastO()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.f31678e = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
            this.f31678e = 2;
            return 2;
        }
        Log.w(Constants.TAG, "Failed to resolve IID implementation package, falling back");
        if (PlatformVersion.isAtLeastO()) {
            this.f31678e = 2;
        } else {
            this.f31678e = 1;
        }
        return this.f31678e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        if (e() != 0) {
            return true;
        }
        return false;
    }
}
