package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzag {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f20549a = new Object();
    @GuardedBy("sLock")

    /* renamed from: b  reason: collision with root package name */
    private static boolean f20550b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static String f20551c;

    /* renamed from: d  reason: collision with root package name */
    private static int f20552d;

    private static void a(Context context) {
        Bundle bundle;
        synchronized (f20549a) {
            if (f20550b) {
                return;
            }
            f20550b = true;
            try {
                bundle = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException e4) {
                Log.wtf("MetadataValueReader", "This should never happen.", e4);
            }
            if (bundle == null) {
                return;
            }
            f20551c = bundle.getString("com.google.app.id");
            f20552d = bundle.getInt("com.google.android.gms.version");
        }
    }

    public static int zza(Context context) {
        a(context);
        return f20552d;
    }

    @Nullable
    public static String zzb(Context context) {
        a(context);
        return f20551c;
    }
}
