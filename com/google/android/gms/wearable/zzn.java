package com.google.android.gms.wearable;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzn extends com.google.android.gms.internal.wearable.zzi {

    /* renamed from: a  reason: collision with root package name */
    private boolean f22868a;

    /* renamed from: b  reason: collision with root package name */
    private final zzm f22869b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ WearableListenerService f22870c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzn(WearableListenerService wearableListenerService, Looper looper) {
        super(looper);
        this.f22870c = wearableListenerService;
        this.f22869b = new zzm(wearableListenerService, null);
    }

    private final synchronized void b() {
        Intent intent;
        ComponentName componentName;
        if (this.f22868a) {
            return;
        }
        if (Log.isLoggable("WearableLS", 2)) {
            componentName = this.f22870c.f22649a;
            "bindService: ".concat(String.valueOf(componentName));
        }
        WearableListenerService wearableListenerService = this.f22870c;
        intent = wearableListenerService.f22652d;
        wearableListenerService.bindService(intent, this.f22869b, 1);
        this.f22868a = true;
    }

    private final synchronized void c(String str) {
        ComponentName componentName;
        if (!this.f22868a) {
            return;
        }
        if (Log.isLoggable("WearableLS", 2)) {
            componentName = this.f22870c.f22649a;
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder();
            sb.append("unbindService: ");
            sb.append(str);
            sb.append(", ");
            sb.append(valueOf);
        }
        try {
            this.f22870c.unbindService(this.f22869b);
        } catch (RuntimeException e4) {
            Log.e("WearableLS", "Exception when unbinding from local service", e4);
        }
        this.f22868a = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        getLooper().quit();
        c("quit");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.wearable.zzi
    public final void zza(Message message) {
        b();
        try {
            super.zza(message);
            if (!hasMessages(0)) {
                c("dispatch");
            }
        } catch (Throwable th) {
            if (!hasMessages(0)) {
                c("dispatch");
            }
            throw th;
        }
    }
}
