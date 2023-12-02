package com.google.android.gms.measurement;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzgd;
import com.google.android.gms.measurement.internal.zzhf;
import com.google.android.gms.measurement.internal.zzhg;
import com.google.android.gms.measurement.internal.zzik;
import com.google.android.gms.measurement.internal.zzlk;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
final class zza extends zzd {

    /* renamed from: a  reason: collision with root package name */
    private final zzgd f22112a;

    /* renamed from: b  reason: collision with root package name */
    private final zzik f22113b;

    public zza(@NonNull zzgd zzgdVar) {
        super(null);
        Preconditions.checkNotNull(zzgdVar);
        this.f22112a = zzgdVar;
        this.f22113b = zzgdVar.zzq();
    }

    @Override // com.google.android.gms.measurement.zzd
    public final Boolean a() {
        return this.f22113b.zzi();
    }

    @Override // com.google.android.gms.measurement.zzd
    public final Double b() {
        return this.f22113b.zzj();
    }

    @Override // com.google.android.gms.measurement.zzd
    public final Integer c() {
        return this.f22113b.zzl();
    }

    @Override // com.google.android.gms.measurement.zzd
    public final Long d() {
        return this.f22113b.zzm();
    }

    @Override // com.google.android.gms.measurement.zzd
    public final String e() {
        return this.f22113b.zzr();
    }

    @Override // com.google.android.gms.measurement.zzd
    public final Map f(boolean z3) {
        List<zzlk> zzt = this.f22113b.zzt(z3);
        ArrayMap arrayMap = new ArrayMap(zzt.size());
        for (zzlk zzlkVar : zzt) {
            Object zza = zzlkVar.zza();
            if (zza != null) {
                arrayMap.put(zzlkVar.zzb, zza);
            }
        }
        return arrayMap;
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final int zza(String str) {
        this.f22113b.zzh(str);
        return 25;
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final long zzb() {
        return this.f22112a.zzv().zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final Object zzg(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        return this.f22113b.zzi();
                    }
                    return this.f22113b.zzl();
                }
                return this.f22113b.zzj();
            }
            return this.f22113b.zzm();
        }
        return this.f22113b.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final String zzh() {
        return this.f22113b.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final String zzi() {
        return this.f22113b.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final String zzj() {
        return this.f22113b.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final String zzk() {
        return this.f22113b.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final List zzm(String str, String str2) {
        return this.f22113b.zzs(str, str2);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final Map zzo(String str, String str2, boolean z3) {
        return this.f22113b.zzu(str, str2, z3);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzp(String str) {
        this.f22112a.zzd().zzd(str, this.f22112a.zzax().elapsedRealtime());
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzq(String str, String str2, Bundle bundle) {
        this.f22112a.zzq().zzA(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzr(String str) {
        this.f22112a.zzd().zze(str, this.f22112a.zzax().elapsedRealtime());
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzs(String str, String str2, Bundle bundle) {
        this.f22113b.zzD(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzt(String str, String str2, Bundle bundle, long j4) {
        this.f22113b.zzE(str, str2, bundle, true, false, j4);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzu(zzhg zzhgVar) {
        this.f22113b.zzJ(zzhgVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzv(Bundle bundle) {
        this.f22113b.zzP(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzw(zzhf zzhfVar) {
        this.f22113b.zzT(zzhfVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzx(zzhg zzhgVar) {
        this.f22113b.zzZ(zzhgVar);
    }
}
