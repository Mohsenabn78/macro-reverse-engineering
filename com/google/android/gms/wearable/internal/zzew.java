package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public abstract class zzew extends com.google.android.gms.internal.wearable.zzb implements zzex {
    public zzew() {
        super("com.google.android.gms.wearable.internal.IWearableCallbacks");
    }

    @Override // com.google.android.gms.internal.wearable.zzb
    protected final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        switch (i4) {
            case 2:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzr((zzed) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzed.CREATOR));
                break;
            case 3:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzC((zzgu) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzgu.CREATOR));
                break;
            case 4:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzu((zzej) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzej.CREATOR));
                break;
            case 5:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzh((DataHolder) com.google.android.gms.internal.wearable.zzc.zza(parcel, DataHolder.CREATOR));
                break;
            case 6:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzi((zzdl) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzdl.CREATOR));
                break;
            case 7:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzE((zzhc) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzhc.CREATOR));
                break;
            case 8:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzw((zzen) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzen.CREATOR));
                break;
            case 9:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzx((zzep) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzep.CREATOR));
                break;
            case 10:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzt((zzeh) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzeh.CREATOR));
                break;
            case 11:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzG((Status) com.google.android.gms.internal.wearable.zzc.zza(parcel, Status.CREATOR));
                break;
            case 12:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzz((zzhg) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzhg.CREATOR));
                break;
            case 13:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzs((zzef) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzef.CREATOR));
                break;
            case 14:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzA((zzgo) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzgo.CREATOR));
                break;
            case 15:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzf((zzcc) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzcc.CREATOR));
                break;
            case 16:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzg((zzcc) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzcc.CREATOR));
                break;
            case 17:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzl((zzdr) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzdr.CREATOR));
                break;
            case 18:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzm((zzdt) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzdt.CREATOR));
                break;
            case 19:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzd((zzbw) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzbw.CREATOR));
                break;
            case 20:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zze((zzby) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzby.CREATOR));
                break;
            case 21:
            case 24:
            case 25:
            case 31:
            case 32:
            case 33:
            default:
                return false;
            case 22:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzk((zzdp) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzdp.CREATOR));
                break;
            case 23:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzj((zzdn) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzdn.CREATOR));
                break;
            case 26:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzb((zzf) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzf.CREATOR));
                break;
            case 27:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzD((zzgy) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzgy.CREATOR));
                break;
            case 28:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzn((zzdw) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzdw.CREATOR));
                break;
            case 29:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzp((zzea) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzea.CREATOR));
                break;
            case 30:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzo((zzdy) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzdy.CREATOR));
                break;
            case 34:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzF((zzha) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzha.CREATOR));
                break;
            case 35:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzv((zzel) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzel.CREATOR));
                break;
            case 36:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzB((zzgs) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzgs.CREATOR));
                break;
            case 37:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzq((zzeb) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzeb.CREATOR));
                break;
            case 38:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzH((zzcf) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzcf.CREATOR));
                break;
            case 39:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzy((zzer) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzer.CREATOR));
                break;
            case 40:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzc((zzq) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzq.CREATOR));
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
