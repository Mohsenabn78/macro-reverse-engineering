package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzb  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzb extends ContextCompat {
    @Nullable
    @Deprecated
    public static Intent zza(Context context, @Nullable BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        int i4;
        Intent registerReceiver;
        if (zza.zza()) {
            if (true != zza.zza()) {
                i4 = 0;
            } else {
                i4 = 2;
            }
            registerReceiver = context.registerReceiver(broadcastReceiver, intentFilter, i4);
            return registerReceiver;
        }
        return context.registerReceiver(broadcastReceiver, intentFilter);
    }
}
