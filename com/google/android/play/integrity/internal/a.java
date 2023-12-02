package com.google.android.play.integrity.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes5.dex */
public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f25331a;

    /* renamed from: b  reason: collision with root package name */
    private final String f25332b = "com.google.android.play.core.integrity.protocol.IIntegrityService";

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IBinder iBinder, String str) {
        this.f25331a = iBinder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f25332b);
        return obtain;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f25331a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(int i4, Parcel parcel) throws RemoteException {
        try {
            this.f25331a.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
