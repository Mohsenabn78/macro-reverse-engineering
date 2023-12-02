package com.google.android.play.core.appupdate;

import android.content.Context;
import androidx.annotation.NonNull;

/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
public final class AppUpdateManagerFactory {
    private AppUpdateManagerFactory() {
    }

    @NonNull
    public static AppUpdateManager create(@NonNull Context context) {
        return zzb.a(context).zza();
    }
}
