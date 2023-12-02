package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public abstract class zzez extends com.google.android.gms.internal.wearable.zzb implements zzfa {
    public zzez() {
        super("com.google.android.gms.wearable.internal.IWearableListener");
    }

    @Override // com.google.android.gms.internal.wearable.zzb
    protected final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        zzev zzevVar;
        if (i4 != 13) {
            if (i4 != 14) {
                switch (i4) {
                    case 1:
                        com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                        zze((DataHolder) com.google.android.gms.internal.wearable.zzc.zza(parcel, DataHolder.CREATOR));
                        return true;
                    case 2:
                        com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                        zzg((zzfx) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzfx.CREATOR));
                        return true;
                    case 3:
                        com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                        zzi((zzgm) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzgm.CREATOR));
                        return true;
                    case 4:
                        com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                        zzj((zzgm) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzgm.CREATOR));
                        return true;
                    case 5:
                        ArrayList createTypedArrayList = parcel.createTypedArrayList(zzgm.CREATOR);
                        com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                        zzd(createTypedArrayList);
                        return true;
                    case 6:
                        com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                        zzh((zzl) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzl.CREATOR));
                        return true;
                    case 7:
                        com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                        zzb((zzbf) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzbf.CREATOR));
                        return true;
                    case 8:
                        com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                        zzc((zzao) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzao.CREATOR));
                        return true;
                    case 9:
                        com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                        zzf((zzi) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzi.CREATOR));
                        return true;
                    default:
                        return false;
                }
            }
            zzcf zzcfVar = (zzcf) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzcf.CREATOR);
            com.google.android.gms.internal.wearable.zzc.zzb(parcel);
            return true;
        }
        zzfx zzfxVar = (zzfx) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzfx.CREATOR);
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            zzevVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IRpcResponseCallback");
            if (queryLocalInterface instanceof zzev) {
                zzevVar = (zzev) queryLocalInterface;
            } else {
                zzevVar = new zzev(readStrongBinder);
            }
        }
        com.google.android.gms.internal.wearable.zzc.zzb(parcel);
        zzl(zzfxVar, zzevVar);
        return true;
    }
}
