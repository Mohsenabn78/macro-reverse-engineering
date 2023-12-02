package com.google.mlkit.nl.translate.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes5.dex */
final class zzg extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzi f33104a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(zzi zziVar, zzi zziVar2) {
        this.f33104a = zziVar2;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Handler handler = MLTaskExecutor.getInstance().getHandler();
        final zzi zziVar = this.f33104a;
        handler.post(new Runnable() { // from class: com.google.mlkit.nl.translate.internal.zzf
            @Override // java.lang.Runnable
            public final void run() {
                zzi.this.g();
            }
        });
    }
}
