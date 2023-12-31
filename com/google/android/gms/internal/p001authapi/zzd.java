package com.google.android.gms.internal.p001authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* renamed from: com.google.android.gms.internal.auth-api.zzd  reason: invalid package */
/* loaded from: classes4.dex */
public class zzd implements IInterface {
    private final IBinder zzd;
    private final String zze;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzd(IBinder iBinder, String str) {
        this.zzd = iBinder;
        this.zze = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel zzc() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zze);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzc(int i4, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.zzd.transact(i4, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
