package com.google.android.gms.ads.internal.util;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.google.android.gms.internal.ads.zzbbm;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcg {

    /* renamed from: d  reason: collision with root package name */
    private boolean f19324d;

    /* renamed from: e  reason: collision with root package name */
    private Context f19325e;

    /* renamed from: c  reason: collision with root package name */
    private boolean f19323c = false;

    /* renamed from: b  reason: collision with root package name */
    private final Map f19322b = new WeakHashMap();

    /* renamed from: a  reason: collision with root package name */
    private final BroadcastReceiver f19321a = new zzcf(this);

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void b(Context context, Intent intent) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.f19322b.entrySet()) {
            if (((IntentFilter) entry.getValue()).hasAction(intent.getAction())) {
                arrayList.add((BroadcastReceiver) entry.getKey());
            }
        }
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((BroadcastReceiver) arrayList.get(i4)).onReceive(context, intent);
        }
    }

    @SuppressLint({"UnprotectedReceiver"})
    public final synchronized void zzb(Context context) {
        if (this.f19323c) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.f19325e = applicationContext;
        if (applicationContext == null) {
            this.f19325e = context;
        }
        zzbbm.zza(this.f19325e);
        this.f19324d = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdz)).booleanValue();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzjA)).booleanValue() && Build.VERSION.SDK_INT >= 33) {
            this.f19325e.registerReceiver(this.f19321a, intentFilter, 4);
        } else {
            this.f19325e.registerReceiver(this.f19321a, intentFilter);
        }
        this.f19323c = true;
    }

    @SuppressLint({"UnprotectedReceiver"})
    public final synchronized void zzc(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (this.f19324d) {
            this.f19322b.put(broadcastReceiver, intentFilter);
            return;
        }
        zzbbm.zza(context);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzjA)).booleanValue() && Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(broadcastReceiver, intentFilter, 4);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public final synchronized void zzd(Context context, BroadcastReceiver broadcastReceiver) {
        if (this.f19324d) {
            this.f19322b.remove(broadcastReceiver);
        } else {
            context.unregisterReceiver(broadcastReceiver);
        }
    }
}
