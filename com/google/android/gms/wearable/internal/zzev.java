package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzev extends com.google.android.gms.internal.wearable.zza {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzev(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.wearable.internal.IRpcResponseCallback");
    }

    public final void zzd(boolean z3, byte[] bArr) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.wearable.zzc.zzc(zza, z3);
        zza.writeByteArray(bArr);
        zzK(1, zza);
    }
}
