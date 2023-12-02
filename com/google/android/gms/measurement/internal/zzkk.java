package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzqo;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzkk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final long f21994a;

    /* renamed from: b  reason: collision with root package name */
    final long f21995b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzkl f21996c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkk(zzkl zzklVar, long j4, long j5) {
        this.f21996c = zzklVar;
        this.f21994a = j4;
        this.f21995b = j5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21996c.f21998b.f21734a.zzaB().zzp(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkj
            @Override // java.lang.Runnable
            public final void run() {
                zzkk zzkkVar = zzkk.this;
                zzkl zzklVar = zzkkVar.f21996c;
                long j4 = zzkkVar.f21994a;
                long j5 = zzkkVar.f21995b;
                zzklVar.f21998b.zzg();
                zzklVar.f21998b.f21734a.zzaA().zzc().zza("Application going to the background");
                zzklVar.f21998b.f21734a.zzm().f21606r.zza(true);
                zzklVar.f21998b.h(true);
                if (!zzklVar.f21998b.f21734a.zzf().zzu()) {
                    zzklVar.f21998b.f22008f.b(j5);
                    zzklVar.f21998b.f22008f.d(false, false, j5);
                }
                zzqo.zzc();
                if (zzklVar.f21998b.f21734a.zzf().zzs(null, zzeg.zzaB)) {
                    zzklVar.f21998b.f21734a.zzaA().zzi().zzb("Application backgrounded at: timestamp_millis", Long.valueOf(j4));
                } else {
                    zzklVar.f21998b.f21734a.zzq().f(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ab", j4, new Bundle());
                }
            }
        });
    }
}
