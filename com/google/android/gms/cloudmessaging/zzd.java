package com.google.android.gms.cloudmessaging;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
/* loaded from: classes4.dex */
public final class zzd implements Parcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new zzb();

    /* renamed from: a  reason: collision with root package name */
    Messenger f19908a;

    /* renamed from: b  reason: collision with root package name */
    IMessengerCompat f19909b;

    public zzd(IBinder iBinder) {
        this.f19908a = new Messenger(iBinder);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return zza().equals(((zzd) obj).zza());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public final int hashCode() {
        return zza().hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        Messenger messenger = this.f19908a;
        if (messenger != null) {
            parcel.writeStrongBinder(messenger.getBinder());
        } else {
            parcel.writeStrongBinder(this.f19909b.asBinder());
        }
    }

    public final IBinder zza() {
        Messenger messenger = this.f19908a;
        if (messenger != null) {
            return messenger.getBinder();
        }
        return this.f19909b.asBinder();
    }

    public final void zzb(Message message) throws RemoteException {
        Messenger messenger = this.f19908a;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.f19909b.send(message);
        }
    }
}
