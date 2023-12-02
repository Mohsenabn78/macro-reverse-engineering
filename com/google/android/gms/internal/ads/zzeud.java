package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeud implements zzgwe {
    public static zzerb zza(Context context, zzbyo zzbyoVar, zzbyp zzbypVar, Object obj, zzert zzertVar, zzetj zzetjVar, zzgvy zzgvyVar, zzgvy zzgvyVar2, zzgvy zzgvyVar3, zzgvy zzgvyVar4, zzgvy zzgvyVar5, zzgvy zzgvyVar6, zzgvy zzgvyVar7, zzgvy zzgvyVar8, zzgvy zzgvyVar9, Executor executor, zzffy zzffyVar, zzdqa zzdqaVar) {
        HashSet hashSet = new HashSet();
        hashSet.add((zzetc) obj);
        hashSet.add(zzertVar);
        hashSet.add(zzetjVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfx)).booleanValue()) {
            hashSet.add((zzeqy) zzgvyVar.zzb());
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfy)).booleanValue()) {
            hashSet.add((zzeqy) zzgvyVar2.zzb());
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfz)).booleanValue()) {
            hashSet.add((zzeqy) zzgvyVar3.zzb());
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfA)).booleanValue()) {
            hashSet.add((zzeqy) zzgvyVar4.zzb());
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfE)).booleanValue()) {
            hashSet.add((zzeqy) zzgvyVar6.zzb());
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfF)).booleanValue()) {
            hashSet.add((zzeqy) zzgvyVar7.zzb());
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcA)).booleanValue()) {
            hashSet.add((zzeqy) zzgvyVar9.zzb());
        }
        return new zzerb(context, executor, hashSet, zzffyVar, zzdqaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    public final /* bridge */ /* synthetic */ Object zzb() {
        throw null;
    }
}
