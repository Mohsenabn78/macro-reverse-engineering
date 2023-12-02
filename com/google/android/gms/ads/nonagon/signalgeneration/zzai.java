package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzcul;
import com.google.android.gms.internal.ads.zzfef;
import com.google.android.gms.internal.ads.zzfel;
import com.google.android.gms.internal.ads.zzgwe;
import com.google.android.gms.internal.ads.zzgwr;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzai implements zzgwe {

    /* renamed from: a  reason: collision with root package name */
    private final zzgwr f19544a;

    /* renamed from: b  reason: collision with root package name */
    private final zzgwr f19545b;

    /* renamed from: c  reason: collision with root package name */
    private final zzgwr f19546c;

    public zzai(zzgwr zzgwrVar, zzgwr zzgwrVar2, zzgwr zzgwrVar3) {
        this.f19544a = zzgwrVar;
        this.f19545b = zzgwrVar2;
        this.f19546c = zzgwrVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    public final /* bridge */ /* synthetic */ Object zzb() {
        return ((zzfel) this.f19544a.zzb()).zzb(zzfef.GENERATE_SIGNALS, ((zzcul) this.f19546c).zzb().zzc()).zzf(((zzal) this.f19545b).zzb()).zzi(((Integer) zzba.zzc().zzb(zzbbm.zzfm)).intValue(), TimeUnit.SECONDS).zza();
    }
}
