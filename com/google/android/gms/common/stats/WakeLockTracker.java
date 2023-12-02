package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
@Deprecated
/* loaded from: classes4.dex */
public class WakeLockTracker {

    /* renamed from: a  reason: collision with root package name */
    private static WakeLockTracker f20714a = new WakeLockTracker();

    @NonNull
    @KeepForSdk
    public static WakeLockTracker getInstance() {
        return f20714a;
    }

    @KeepForSdk
    public void registerEvent(@NonNull Context context, @NonNull String str, int i4, @NonNull String str2, @NonNull String str3, @NonNull String str4, int i5, @NonNull List<String> list) {
    }

    @KeepForSdk
    public void registerEvent(@NonNull Context context, @NonNull String str, int i4, @NonNull String str2, @NonNull String str3, @NonNull String str4, int i5, @NonNull List<String> list, long j4) {
    }

    @KeepForSdk
    public void registerReleaseEvent(@NonNull Context context, @NonNull Intent intent) {
    }

    @KeepForSdk
    public void registerAcquireEvent(@NonNull Context context, @NonNull Intent intent, @NonNull String str, @NonNull String str2, @NonNull String str3, int i4, @NonNull String str4) {
    }

    @KeepForSdk
    public void registerDeadlineEvent(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3, int i4, @NonNull List<String> list, boolean z3, long j4) {
    }
}
