package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzle {

    /* renamed from: a  reason: collision with root package name */
    com.google.android.gms.internal.measurement.zzgd f22034a;

    /* renamed from: b  reason: collision with root package name */
    List f22035b;

    /* renamed from: c  reason: collision with root package name */
    List f22036c;

    /* renamed from: d  reason: collision with root package name */
    long f22037d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzlh f22038e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzle(zzlh zzlhVar, zzld zzldVar) {
        this.f22038e = zzlhVar;
    }

    private static final long b(com.google.android.gms.internal.measurement.zzft zzftVar) {
        return ((zzftVar.zzd() / 1000) / 60) / 60;
    }

    public final boolean a(long j4, com.google.android.gms.internal.measurement.zzft zzftVar) {
        Preconditions.checkNotNull(zzftVar);
        if (this.f22036c == null) {
            this.f22036c = new ArrayList();
        }
        if (this.f22035b == null) {
            this.f22035b = new ArrayList();
        }
        if (!this.f22036c.isEmpty() && b((com.google.android.gms.internal.measurement.zzft) this.f22036c.get(0)) != b(zzftVar)) {
            return false;
        }
        long zzbz = this.f22037d + zzftVar.zzbz();
        this.f22038e.zzg();
        if (zzbz >= Math.max(0, ((Integer) zzeg.zzi.zza(null)).intValue())) {
            return false;
        }
        this.f22037d = zzbz;
        this.f22036c.add(zzftVar);
        this.f22035b.add(Long.valueOf(j4));
        int size = this.f22036c.size();
        this.f22038e.zzg();
        if (size >= Math.max(1, ((Integer) zzeg.zzj.zza(null)).intValue())) {
            return false;
        }
        return true;
    }
}
