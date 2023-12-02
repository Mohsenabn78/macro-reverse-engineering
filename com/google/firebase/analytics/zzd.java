package com.google.firebase.analytics;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.measurement.zzef;
import com.google.android.gms.measurement.internal.zzhf;
import com.google.android.gms.measurement.internal.zzhg;
import com.google.android.gms.measurement.internal.zzil;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.3.0 */
/* loaded from: classes5.dex */
final class zzd implements zzil {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzef f28775a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzd(zzef zzefVar) {
        this.f28775a = zzefVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final int zza(String str) {
        return this.f28775a.zza(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final long zzb() {
        return this.f28775a.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    @Nullable
    public final Object zzg(int i4) {
        return this.f28775a.zzi(i4);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    @Nullable
    public final String zzh() {
        return this.f28775a.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    @Nullable
    public final String zzi() {
        return this.f28775a.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    @Nullable
    public final String zzj() {
        return this.f28775a.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    @Nullable
    public final String zzk() {
        return this.f28775a.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final List zzm(@Nullable String str, @Nullable String str2) {
        return this.f28775a.zzq(str, str2);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final Map zzo(@Nullable String str, @Nullable String str2, boolean z3) {
        return this.f28775a.zzr(str, str2, z3);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzp(String str) {
        this.f28775a.zzv(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzq(String str, @Nullable String str2, @Nullable Bundle bundle) {
        this.f28775a.zzw(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzr(String str) {
        this.f28775a.zzx(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzs(String str, String str2, Bundle bundle) {
        this.f28775a.zzz(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzt(String str, String str2, Bundle bundle, long j4) {
        this.f28775a.zzA(str, str2, bundle, j4);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzu(zzhg zzhgVar) {
        this.f28775a.zzC(zzhgVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzv(Bundle bundle) {
        this.f28775a.zzE(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzw(zzhf zzhfVar) {
        this.f28775a.zzK(zzhfVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final void zzx(zzhg zzhgVar) {
        this.f28775a.zzP(zzhgVar);
    }
}
