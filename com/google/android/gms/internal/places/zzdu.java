package com.google.android.gms.internal.places;

import java.io.IOException;

/* loaded from: classes4.dex */
final class zzdu extends zzds<zzdr, zzdr> {
    private static void zzb(Object obj, zzdr zzdrVar) {
        ((zzbc) obj).zzih = zzdrVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.places.zzds
    public final void zzd(Object obj) {
        ((zzbc) obj).zzih.zzab();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.places.zzds
    public final /* synthetic */ zzdr zzdk() {
        return zzdr.zzdi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.places.zzds
    public final /* synthetic */ void zzf(Object obj, zzdr zzdrVar) {
        zzb(obj, zzdrVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.places.zzds
    public final /* synthetic */ void zzg(Object obj, zzdr zzdrVar) {
        zzb(obj, zzdrVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.places.zzds
    public final /* synthetic */ zzdr zzh(zzdr zzdrVar, zzdr zzdrVar2) {
        zzdr zzdrVar3 = zzdrVar;
        zzdr zzdrVar4 = zzdrVar2;
        if (zzdrVar4.equals(zzdr.zzdh())) {
            return zzdrVar3;
        }
        return zzdr.zzb(zzdrVar3, zzdrVar4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.places.zzds
    public final /* synthetic */ int zzn(zzdr zzdrVar) {
        return zzdrVar.zzbh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.places.zzds
    public final /* synthetic */ zzdr zzr(Object obj) {
        return ((zzbc) obj).zzih;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.places.zzds
    public final /* synthetic */ int zzs(zzdr zzdrVar) {
        return zzdrVar.zzdj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.places.zzds
    public final /* synthetic */ void zzb(zzdr zzdrVar, zzel zzelVar) throws IOException {
        zzdrVar.zzc(zzelVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.places.zzds
    public final /* synthetic */ void zzd(zzdr zzdrVar, zzel zzelVar) throws IOException {
        zzdrVar.zzb(zzelVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.places.zzds
    public final /* synthetic */ void zzb(zzdr zzdrVar, int i4, zzw zzwVar) {
        zzdrVar.zzc((i4 << 3) | 2, zzwVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.places.zzds
    public final /* synthetic */ void zzb(zzdr zzdrVar, int i4, long j4) {
        zzdrVar.zzc(i4 << 3, Long.valueOf(j4));
    }
}
