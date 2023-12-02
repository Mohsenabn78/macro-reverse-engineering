package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzpz;
import com.google.android.gms.internal.measurement.zzqu;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
final class zzgq implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzau f21716a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f21717b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzgv f21718c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgq(zzgv zzgvVar, zzau zzauVar, String str) {
        this.f21718c = zzgvVar;
        this.f21716a = zzauVar;
        this.f21717b = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzlh zzlhVar;
        zzlh zzlhVar2;
        zzlm zzlmVar;
        zzh zzhVar;
        com.google.android.gms.internal.measurement.zzga zzgaVar;
        String str;
        Bundle bundle;
        com.google.android.gms.internal.measurement.zzgc zzgcVar;
        String str2;
        zzaq c4;
        long j4;
        byte[] bArr;
        zzlh zzlhVar3;
        zzlhVar = this.f21718c.f21731a;
        zzlhVar.a();
        zzlhVar2 = this.f21718c.f21731a;
        zzip zzr = zzlhVar2.zzr();
        zzau zzauVar = this.f21716a;
        String str3 = this.f21717b;
        zzr.zzg();
        zzgd.h();
        Preconditions.checkNotNull(zzauVar);
        Preconditions.checkNotEmpty(str3);
        if (!zzr.f21734a.zzf().zzs(str3, zzeg.zzU)) {
            zzr.f21734a.zzaA().zzc().zzb("Generating ScionPayload disabled. packageName", str3);
            return new byte[0];
        } else if (!"_iap".equals(zzauVar.zza) && !"_iapx".equals(zzauVar.zza)) {
            zzr.f21734a.zzaA().zzc().zzc("Generating a payload for this event is not available. package_name, event_name", str3, zzauVar.zza);
            return null;
        } else {
            com.google.android.gms.internal.measurement.zzga zza = com.google.android.gms.internal.measurement.zzgb.zza();
            zzr.f22016b.zzh().zzw();
            try {
                zzh I = zzr.f22016b.zzh().I(str3);
                if (I == null) {
                    zzr.f21734a.zzaA().zzc().zzb("Log and bundle not available. package_name", str3);
                    bArr = new byte[0];
                    zzlhVar3 = zzr.f22016b;
                } else if (!I.O()) {
                    zzr.f21734a.zzaA().zzc().zzb("Log and bundle disabled. package_name", str3);
                    bArr = new byte[0];
                    zzlhVar3 = zzr.f22016b;
                } else {
                    com.google.android.gms.internal.measurement.zzgc zzu = com.google.android.gms.internal.measurement.zzgd.zzu();
                    zzu.zzad(1);
                    zzu.zzZ("android");
                    if (!TextUtils.isEmpty(I.l0())) {
                        zzu.zzD(I.l0());
                    }
                    if (!TextUtils.isEmpty(I.n0())) {
                        zzu.zzF((String) Preconditions.checkNotNull(I.n0()));
                    }
                    if (!TextUtils.isEmpty(I.o0())) {
                        zzu.zzG((String) Preconditions.checkNotNull(I.o0()));
                    }
                    if (I.R() != -2147483648L) {
                        zzu.zzH((int) I.R());
                    }
                    zzu.zzV(I.c0());
                    zzu.zzP(I.a0());
                    String a4 = I.a();
                    String j02 = I.j0();
                    if (!TextUtils.isEmpty(a4)) {
                        zzu.zzU(a4);
                    } else if (!TextUtils.isEmpty(j02)) {
                        zzu.zzC(j02);
                    }
                    zzpz.zzc();
                    if (zzr.f21734a.zzf().zzs(null, zzeg.zzaE)) {
                        zzu.zzaj(I.h0());
                    }
                    zzhb P = zzr.f22016b.P(str3);
                    zzu.zzM(I.Z());
                    if (zzr.f21734a.zzJ() && zzr.f21734a.zzf().zzt(zzu.zzaq()) && P.zzj(zzha.AD_STORAGE) && !TextUtils.isEmpty(null)) {
                        zzu.zzO(null);
                    }
                    zzu.zzL(P.zzi());
                    if (P.zzj(zzha.AD_STORAGE) && I.N()) {
                        Pair e4 = zzr.f22016b.zzs().e(I.l0(), P);
                        if (I.N() && !TextUtils.isEmpty((CharSequence) e4.first)) {
                            try {
                                zzu.zzae(zzip.zza((String) e4.first, Long.toString(zzauVar.zzd)));
                                Object obj = e4.second;
                                if (obj != null) {
                                    zzu.zzX(((Boolean) obj).booleanValue());
                                }
                            } catch (SecurityException e5) {
                                zzr.f21734a.zzaA().zzc().zzb("Resettable device id encryption failed", e5.getMessage());
                                bArr = new byte[0];
                                zzlhVar3 = zzr.f22016b;
                            }
                        }
                    }
                    zzr.f21734a.zzg().c();
                    zzu.zzN(Build.MODEL);
                    zzr.f21734a.zzg().c();
                    zzu.zzY(Build.VERSION.RELEASE);
                    zzu.zzak((int) zzr.f21734a.zzg().zzb());
                    zzu.zzao(zzr.f21734a.zzg().zzc());
                    try {
                        if (P.zzj(zzha.ANALYTICS_STORAGE) && I.m0() != null) {
                            zzu.zzE(zzip.zza((String) Preconditions.checkNotNull(I.m0()), Long.toString(zzauVar.zzd)));
                        }
                        if (!TextUtils.isEmpty(I.p0())) {
                            zzu.zzT((String) Preconditions.checkNotNull(I.p0()));
                        }
                        String l02 = I.l0();
                        List S = zzr.f22016b.zzh().S(l02);
                        Iterator it = S.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                zzlmVar = null;
                                break;
                            }
                            zzlmVar = (zzlm) it.next();
                            if ("_lte".equals(zzlmVar.f22070c)) {
                                break;
                            }
                        }
                        if (zzlmVar == null || zzlmVar.f22072e == null) {
                            zzlm zzlmVar2 = new zzlm(l02, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lte", zzr.f21734a.zzax().currentTimeMillis(), 0L);
                            S.add(zzlmVar2);
                            zzr.f22016b.zzh().o(zzlmVar2);
                        }
                        zzlj zzu2 = zzr.f22016b.zzu();
                        zzu2.f21734a.zzaA().zzj().zza("Checking account type status for ad personalization signals");
                        if (zzu2.f21734a.zzg().f()) {
                            String l03 = I.l0();
                            Preconditions.checkNotNull(l03);
                            if (I.N() && zzu2.f22016b.zzm().s(l03)) {
                                zzu2.f21734a.zzaA().zzc().zza("Turning off ad personalization due to account type");
                                Iterator it2 = S.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    } else if ("_npa".equals(((zzlm) it2.next()).f22070c)) {
                                        it2.remove();
                                        break;
                                    }
                                }
                                S.add(new zzlm(l03, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_npa", zzu2.f21734a.zzax().currentTimeMillis(), 1L));
                            }
                        }
                        com.google.android.gms.internal.measurement.zzgm[] zzgmVarArr = new com.google.android.gms.internal.measurement.zzgm[S.size()];
                        for (int i4 = 0; i4 < S.size(); i4++) {
                            com.google.android.gms.internal.measurement.zzgl zzd = com.google.android.gms.internal.measurement.zzgm.zzd();
                            zzd.zzf(((zzlm) S.get(i4)).f22070c);
                            zzd.zzg(((zzlm) S.get(i4)).f22071d);
                            zzr.f22016b.zzu().D(zzd, ((zzlm) S.get(i4)).f22072e);
                            zzgmVarArr[i4] = (com.google.android.gms.internal.measurement.zzgm) zzd.zzaD();
                        }
                        zzu.zzj(Arrays.asList(zzgmVarArr));
                        zzeu zzb = zzeu.zzb(zzauVar);
                        zzr.f21734a.zzv().k(zzb.zzd, zzr.f22016b.zzh().H(str3));
                        zzr.f21734a.zzv().m(zzb, zzr.f21734a.zzf().zzd(str3));
                        Bundle bundle2 = zzb.zzd;
                        bundle2.putLong("_c", 1L);
                        zzr.f21734a.zzaA().zzc().zza("Marking in-app purchase as real-time");
                        bundle2.putLong("_r", 1L);
                        bundle2.putString("_o", zzauVar.zzc);
                        if (zzr.f21734a.zzv().y(zzu.zzaq())) {
                            zzr.f21734a.zzv().o(bundle2, "_dbg", 1L);
                            zzr.f21734a.zzv().o(bundle2, "_r", 1L);
                        }
                        zzaq M = zzr.f22016b.zzh().M(str3, zzauVar.zza);
                        if (M == null) {
                            zzgcVar = zzu;
                            zzhVar = I;
                            zzgaVar = zza;
                            str = str3;
                            bundle = bundle2;
                            str2 = null;
                            c4 = new zzaq(str3, zzauVar.zza, 0L, 0L, 0L, zzauVar.zzd, 0L, null, null, null, null);
                            j4 = 0;
                        } else {
                            zzhVar = I;
                            zzgaVar = zza;
                            str = str3;
                            bundle = bundle2;
                            zzgcVar = zzu;
                            str2 = null;
                            long j5 = M.f21476f;
                            c4 = M.c(zzauVar.zzd);
                            j4 = j5;
                        }
                        zzr.f22016b.zzh().h(c4);
                        zzap zzapVar = new zzap(zzr.f21734a, zzauVar.zzc, str, zzauVar.zza, zzauVar.zzd, j4, bundle);
                        com.google.android.gms.internal.measurement.zzfs zze = com.google.android.gms.internal.measurement.zzft.zze();
                        zze.zzm(zzapVar.f21468d);
                        zze.zzi(zzapVar.f21466b);
                        zze.zzl(zzapVar.f21469e);
                        zzar zzarVar = new zzar(zzapVar.f21470f);
                        while (zzarVar.hasNext()) {
                            String next = zzarVar.next();
                            com.google.android.gms.internal.measurement.zzfw zze2 = com.google.android.gms.internal.measurement.zzfx.zze();
                            zze2.zzj(next);
                            Object e6 = zzapVar.f21470f.e(next);
                            if (e6 != null) {
                                zzr.f22016b.zzu().C(zze2, e6);
                                zze.zze(zze2);
                            }
                        }
                        com.google.android.gms.internal.measurement.zzgc zzgcVar2 = zzgcVar;
                        zzgcVar2.zzk(zze);
                        com.google.android.gms.internal.measurement.zzge zza2 = com.google.android.gms.internal.measurement.zzgg.zza();
                        com.google.android.gms.internal.measurement.zzfu zza3 = com.google.android.gms.internal.measurement.zzfv.zza();
                        zza3.zza(c4.f21473c);
                        zza3.zzb(zzauVar.zza);
                        zza2.zza(zza3);
                        zzgcVar2.zzaa(zza2);
                        zzgcVar2.zzf(zzr.f22016b.zzf().d(zzhVar.l0(), Collections.emptyList(), zzgcVar2.zzau(), Long.valueOf(zze.zzc()), Long.valueOf(zze.zzc())));
                        if (zze.zzq()) {
                            zzgcVar2.zzai(zze.zzc());
                            zzgcVar2.zzQ(zze.zzc());
                        }
                        long d02 = zzhVar.d0();
                        int i5 = (d02 > 0L ? 1 : (d02 == 0L ? 0 : -1));
                        if (i5 != 0) {
                            zzgcVar2.zzab(d02);
                        }
                        long f02 = zzhVar.f0();
                        if (f02 != 0) {
                            zzgcVar2.zzac(f02);
                        } else if (i5 != 0) {
                            zzgcVar2.zzac(d02);
                        }
                        String d4 = zzhVar.d();
                        zzqu.zzc();
                        String str4 = str;
                        if (zzr.f21734a.zzf().zzs(str4, zzeg.zzao) && d4 != null) {
                            zzgcVar2.zzah(d4);
                        }
                        zzhVar.g();
                        zzgcVar2.zzI((int) zzhVar.e0());
                        zzr.f21734a.zzf().zzh();
                        zzgcVar2.zzam(79000L);
                        zzgcVar2.zzal(zzr.f21734a.zzax().currentTimeMillis());
                        zzgcVar2.zzag(true);
                        if (zzr.f21734a.zzf().zzs(str2, zzeg.zzas)) {
                            zzr.f22016b.c(zzgcVar2.zzaq(), zzgcVar2);
                        }
                        com.google.android.gms.internal.measurement.zzga zzgaVar2 = zzgaVar;
                        zzgaVar2.zza(zzgcVar2);
                        zzh zzhVar2 = zzhVar;
                        zzhVar2.E(zzgcVar2.zzd());
                        zzhVar2.C(zzgcVar2.zzc());
                        zzr.f22016b.zzh().g(zzhVar2);
                        zzr.f22016b.zzh().f();
                        zzr.f22016b.zzh().zzx();
                        try {
                            return zzr.f22016b.zzu().H(((com.google.android.gms.internal.measurement.zzgb) zzgaVar2.zzaD()).zzbx());
                        } catch (IOException e7) {
                            zzr.f21734a.zzaA().zzd().zzc("Data loss. Failed to bundle and serialize. appId", zzet.f(str4), e7);
                            return str2;
                        }
                    } catch (SecurityException e8) {
                        zzr.f21734a.zzaA().zzc().zzb("app instance id encryption failed", e8.getMessage());
                        byte[] bArr2 = new byte[0];
                        zzr.f22016b.zzh().zzx();
                        return bArr2;
                    }
                }
                zzlhVar3.zzh().zzx();
                return bArr;
            } catch (Throwable th) {
                zzr.f22016b.zzh().zzx();
                throw th;
            }
        }
    }
}
