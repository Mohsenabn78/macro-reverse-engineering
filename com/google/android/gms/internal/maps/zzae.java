package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public final class zzae extends zza implements zzac {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzae(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzac
    public final void clearTileCache() throws RemoteException {
        zzb(2, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzac
    public final boolean getFadeIn() throws RemoteException {
        Parcel zza = zza(11, zza());
        boolean zza2 = zzc.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.maps.zzac
    public final String getId() throws RemoteException {
        Parcel zza = zza(3, zza());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.maps.zzac
    public final float getTransparency() throws RemoteException {
        Parcel zza = zza(13, zza());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.maps.zzac
    public final float getZIndex() throws RemoteException {
        Parcel zza = zza(5, zza());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.maps.zzac
    public final boolean isVisible() throws RemoteException {
        Parcel zza = zza(7, zza());
        boolean zza2 = zzc.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.maps.zzac
    public final void remove() throws RemoteException {
        zzb(1, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzac
    public final void setFadeIn(boolean z3) throws RemoteException {
        Parcel zza = zza();
        zzc.writeBoolean(zza, z3);
        zzb(10, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzac
    public final void setTransparency(float f4) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f4);
        zzb(12, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzac
    public final void setVisible(boolean z3) throws RemoteException {
        Parcel zza = zza();
        zzc.writeBoolean(zza, z3);
        zzb(6, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzac
    public final void setZIndex(float f4) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f4);
        zzb(4, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzac
    public final boolean zza(zzac zzacVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, zzacVar);
        Parcel zza2 = zza(8, zza);
        boolean zza3 = zzc.zza(zza2);
        zza2.recycle();
        return zza3;
    }

    @Override // com.google.android.gms.internal.maps.zzac
    public final int zzj() throws RemoteException {
        Parcel zza = zza(9, zza());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }
}
