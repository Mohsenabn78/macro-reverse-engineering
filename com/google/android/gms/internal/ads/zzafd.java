package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzafd implements zzby {
    public static final Parcelable.Creator<zzafd> CREATOR = new zzafb();
    public final float zza;
    public final int zzb;

    public zzafd(float f4, int i4) {
        this.zza = f4;
        this.zzb = i4;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzafd.class == obj.getClass()) {
            zzafd zzafdVar = (zzafd) obj;
            if (this.zza == zzafdVar.zza && this.zzb == zzafdVar.zzb) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.valueOf(this.zza).hashCode() + 527) * 31) + this.zzb;
    }

    public final String toString() {
        float f4 = this.zza;
        int i4 = this.zzb;
        return "smta: captureFrameRate=" + f4 + ", svcTemporalLayerCount=" + i4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeFloat(this.zza);
        parcel.writeInt(this.zzb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzafd(Parcel parcel, zzafc zzafcVar) {
        this.zza = parcel.readFloat();
        this.zzb = parcel.readInt();
    }

    @Override // com.google.android.gms.internal.ads.zzby
    public final /* synthetic */ void zza(zzbt zzbtVar) {
    }
}
