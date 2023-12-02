package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes3.dex */
public final class ApplicationVersionSignature {

    /* renamed from: a  reason: collision with root package name */
    private static final ConcurrentMap<String, Key> f17554a = new ConcurrentHashMap();

    private ApplicationVersionSignature() {
    }

    @Nullable
    private static PackageInfo a(@NonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e4) {
            Log.e("AppVersionSignature", "Cannot resolve info for" + context.getPackageName(), e4);
            return null;
        }
    }

    @NonNull
    private static String b(@Nullable PackageInfo packageInfo) {
        if (packageInfo != null) {
            return String.valueOf(packageInfo.versionCode);
        }
        return UUID.randomUUID().toString();
    }

    @NonNull
    private static Key c(@NonNull Context context) {
        return new ObjectKey(b(a(context)));
    }

    @NonNull
    public static Key obtain(@NonNull Context context) {
        String packageName = context.getPackageName();
        ConcurrentMap<String, Key> concurrentMap = f17554a;
        Key key = concurrentMap.get(packageName);
        if (key == null) {
            Key c4 = c(context);
            Key putIfAbsent = concurrentMap.putIfAbsent(packageName, c4);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
            return c4;
        }
        return key;
    }
}
