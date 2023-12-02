package com.google.android.play.core.appupdate.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
public class zza implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f25168a;

    /* renamed from: b  reason: collision with root package name */
    private final String f25169b = "com.google.android.play.core.appupdate.protocol.IAppUpdateService";

    /* JADX INFO: Access modifiers changed from: protected */
    public zza(IBinder iBinder, String str) {
        this.f25168a = iBinder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f25169b);
        return obtain;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f25168a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(int i4, Parcel parcel) throws RemoteException {
        try {
            this.f25168a.transact(i4, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
