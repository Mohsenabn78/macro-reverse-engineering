package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public final class zzbx extends com.google.android.gms.internal.maps.zza implements IUiSettingsDelegate {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IUiSettingsDelegate");
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final boolean isCompassEnabled() throws RemoteException {
        Parcel zza = zza(10, zza());
        boolean zza2 = com.google.android.gms.internal.maps.zzc.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final boolean isIndoorLevelPickerEnabled() throws RemoteException {
        Parcel zza = zza(17, zza());
        boolean zza2 = com.google.android.gms.internal.maps.zzc.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final boolean isMapToolbarEnabled() throws RemoteException {
        Parcel zza = zza(19, zza());
        boolean zza2 = com.google.android.gms.internal.maps.zzc.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final boolean isMyLocationButtonEnabled() throws RemoteException {
        Parcel zza = zza(11, zza());
        boolean zza2 = com.google.android.gms.internal.maps.zzc.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final boolean isRotateGesturesEnabled() throws RemoteException {
        Parcel zza = zza(15, zza());
        boolean zza2 = com.google.android.gms.internal.maps.zzc.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final boolean isScrollGesturesEnabled() throws RemoteException {
        Parcel zza = zza(12, zza());
        boolean zza2 = com.google.android.gms.internal.maps.zzc.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final boolean isScrollGesturesEnabledDuringRotateOrZoom() throws RemoteException {
        Parcel zza = zza(21, zza());
        boolean zza2 = com.google.android.gms.internal.maps.zzc.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final boolean isTiltGesturesEnabled() throws RemoteException {
        Parcel zza = zza(14, zza());
        boolean zza2 = com.google.android.gms.internal.maps.zzc.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final boolean isZoomControlsEnabled() throws RemoteException {
        Parcel zza = zza(9, zza());
        boolean zza2 = com.google.android.gms.internal.maps.zzc.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final boolean isZoomGesturesEnabled() throws RemoteException {
        Parcel zza = zza(13, zza());
        boolean zza2 = com.google.android.gms.internal.maps.zzc.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setAllGesturesEnabled(boolean z3) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.writeBoolean(zza, z3);
        zzb(8, zza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setCompassEnabled(boolean z3) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.writeBoolean(zza, z3);
        zzb(2, zza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setIndoorLevelPickerEnabled(boolean z3) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.writeBoolean(zza, z3);
        zzb(16, zza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setMapToolbarEnabled(boolean z3) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.writeBoolean(zza, z3);
        zzb(18, zza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setMyLocationButtonEnabled(boolean z3) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.writeBoolean(zza, z3);
        zzb(3, zza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setRotateGesturesEnabled(boolean z3) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.writeBoolean(zza, z3);
        zzb(7, zza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setScrollGesturesEnabled(boolean z3) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.writeBoolean(zza, z3);
        zzb(4, zza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setScrollGesturesEnabledDuringRotateOrZoom(boolean z3) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.writeBoolean(zza, z3);
        zzb(20, zza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setTiltGesturesEnabled(boolean z3) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.writeBoolean(zza, z3);
        zzb(6, zza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setZoomControlsEnabled(boolean z3) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.writeBoolean(zza, z3);
        zzb(1, zza);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setZoomGesturesEnabled(boolean z3) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.writeBoolean(zza, z3);
        zzb(5, zza);
    }
}
