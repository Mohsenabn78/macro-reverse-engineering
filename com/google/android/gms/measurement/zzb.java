package com.google.android.gms.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzhf;
import com.google.android.gms.measurement.internal.zzhg;
import com.google.android.gms.measurement.internal.zzil;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
final class zzb extends zzd {

    /* renamed from: a  reason: collision with root package name */
    private final zzil f22114a;

    public zzb(zzil zzilVar) {
        super(null);
        Preconditions.checkNotNull(zzilVar);
        this.f22114a = zzilVar;
    }

    @Override // com.google.android.gms.measurement.zzd
    public final Boolean a() {
        return (Boolean) this.f22114a.zzg(4);
    }

    @Override // com.google.android.gms.measurement.zzd
    public final Double b() {
        return (Double) this.f22114a.zzg(2);
    }

    @Override // com.google.android.gms.measurement.zzd
    public final Integer c() {
        return (Integer) this.f22114a.zzg(3);
    }

    @Override // com.google.android.gms.measurement.zzd
    public final Long d() {
        return (Long) this.f22114a.zzg(1);
    }

    @Override // com.google.android.gms.measurement.zzd
    public final String e() {
        return (String) this.f22114a.zzg(0);
    }

    @Override // com.google.android.gms.measurement.zzd
    public final Map f(boolean z3) {
        return this.f22114a.zzo(null, null, z3);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final int zza(String str) {
        return this.f22114a.zza(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final long zzb() {
        return this.f22114a.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final Object zzg(int i4) {
        return this.f22114a.zzg(i4);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final String zzh() {
        return this.f22114a.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final String zzi() {
        return this.f22114a.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final String zzj() {
        return this.f22114a.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final String zzk() {
        return this.f22114a.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final List zzm(String str, String str2) {
        return this.f22114a.zzm(str, str2);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final Map zzo(String str, String str2, boolean z3) {
        return this.f22114a.zzo(str, str2, z3);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzp(String str) {
        this.f22114a.zzp(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzq(String str, String str2, Bundle bundle) {
        this.f22114a.zzq(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzr(String str) {
        this.f22114a.zzr(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzs(String str, String str2, Bundle bundle) {
        this.f22114a.zzs(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzt(String str, String str2, Bundle bundle, long j4) {
        this.f22114a.zzt(str, str2, bundle, j4);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzu(zzhg zzhgVar) {
        this.f22114a.zzu(zzhgVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzv(Bundle bundle) {
        this.f22114a.zzv(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzw(zzhf zzhfVar) {
        this.f22114a.zzw(zzhfVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzx(zzhg zzhgVar) {
        this.f22114a.zzx(zzhgVar);
    }
}
