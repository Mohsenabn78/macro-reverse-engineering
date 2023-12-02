package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
/* loaded from: classes4.dex */
public final class zzt {

    /* renamed from: a  reason: collision with root package name */
    private final Context f19927a;
    @GuardedBy("this")

    /* renamed from: b  reason: collision with root package name */
    private int f19928b;
    @GuardedBy("this")

    /* renamed from: c  reason: collision with root package name */
    private int f19929c = 0;

    public zzt(Context context) {
        this.f19927a = context;
    }

    public final synchronized int zza() {
        PackageInfo packageInfo;
        if (this.f19928b == 0) {
            try {
                packageInfo = Wrappers.packageManager(this.f19927a).getPackageInfo("com.google.android.gms", 0);
            } catch (PackageManager.NameNotFoundException e4) {
                String valueOf = String.valueOf(e4);
                StringBuilder sb = new StringBuilder(valueOf.length() + 23);
                sb.append("Failed to find package ");
                sb.append(valueOf);
                Log.w("Metadata", sb.toString());
                packageInfo = null;
            }
            if (packageInfo != null) {
                this.f19928b = packageInfo.versionCode;
            }
        }
        return this.f19928b;
    }

    public final synchronized int zzb() {
        int i4 = this.f19929c;
        if (i4 != 0) {
            return i4;
        }
        PackageManager packageManager = this.f19927a.getPackageManager();
        if (Wrappers.packageManager(this.f19927a).checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("Metadata", "Google Play services missing or without correct permission.");
            return 0;
        }
        int i5 = 1;
        if (!PlatformVersion.isAtLeastO()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.f19929c = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
            this.f19929c = 2;
            return 2;
        }
        Log.w("Metadata", "Failed to resolve IID implementation package, falling back");
        if (PlatformVersion.isAtLeastO()) {
            this.f19929c = 2;
            i5 = 2;
        } else {
            this.f19929c = 1;
        }
        return i5;
    }
}
