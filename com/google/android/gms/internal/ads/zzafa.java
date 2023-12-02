package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzafa implements zzby {
    public static final Parcelable.Creator<zzafa> CREATOR = new zzaey();
    public final long zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;

    public zzafa(long j4, long j5, long j6, long j7, long j8) {
        this.zza = j4;
        this.zzb = j5;
        this.zzc = j6;
        this.zzd = j7;
        this.zze = j8;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzafa.class == obj.getClass()) {
            zzafa zzafaVar = (zzafa) obj;
            if (this.zza == zzafaVar.zza && this.zzb == zzafaVar.zzb && this.zzc == zzafaVar.zzc && this.zzd == zzafaVar.zzd && this.zze == zzafaVar.zze) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.zza;
        long j5 = j4 ^ (j4 >>> 32);
        long j6 = this.zzb;
        long j7 = j6 ^ (j6 >>> 32);
        long j8 = this.zzc;
        long j9 = j8 ^ (j8 >>> 32);
        long j10 = this.zzd;
        long j11 = j10 ^ (j10 >>> 32);
        long j12 = this.zze;
        return ((((((((((int) j5) + 527) * 31) + ((int) j7)) * 31) + ((int) j9)) * 31) + ((int) j11)) * 31) + ((int) (j12 ^ (j12 >>> 32)));
    }

    public final String toString() {
        long j4 = this.zza;
        long j5 = this.zzb;
        long j6 = this.zzc;
        long j7 = this.zzd;
        long j8 = this.zze;
        return "Motion photo metadata: photoStartPosition=" + j4 + ", photoSize=" + j5 + ", photoPresentationTimestampUs=" + j6 + ", videoStartPosition=" + j7 + ", videoSize=" + j8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeLong(this.zza);
        parcel.writeLong(this.zzb);
        parcel.writeLong(this.zzc);
        parcel.writeLong(this.zzd);
        parcel.writeLong(this.zze);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzafa(Parcel parcel, zzaez zzaezVar) {
        this.zza = parcel.readLong();
        this.zzb = parcel.readLong();
        this.zzc = parcel.readLong();
        this.zzd = parcel.readLong();
        this.zze = parcel.readLong();
    }

    @Override // com.google.android.gms.internal.ads.zzby
    public final /* synthetic */ void zza(zzbt zzbtVar) {
    }
}
