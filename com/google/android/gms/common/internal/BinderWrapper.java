package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
@KeepName
/* loaded from: classes4.dex */
public final class BinderWrapper implements Parcelable {
    @NonNull
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new zzh();

    /* renamed from: a  reason: collision with root package name */
    private IBinder f20422a;

    @KeepForSdk
    public BinderWrapper(@NonNull IBinder iBinder) {
        this.f20422a = iBinder;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i4) {
        parcel.writeStrongBinder(this.f20422a);
    }
}
