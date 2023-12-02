package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@SafeParcelable.Class(creator = "GassResponseParcelCreator")
/* loaded from: classes4.dex */
public final class zzfkl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfkl> CREATOR = new zzfkm();
    @SafeParcelable.VersionField(id = 1)
    public final int zza;
    @SafeParcelable.Field(getter = "getAfmaSignalsAsBytes", id = 2, type = "byte[]")
    private zzaon zzb = null;
    private byte[] zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzfkl(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) byte[] bArr) {
        this.zza = i4;
        this.zzc = bArr;
        zzb();
    }

    private final void zzb() {
        zzaon zzaonVar = this.zzb;
        if (zzaonVar == null && this.zzc != null) {
            return;
        }
        if (zzaonVar != null && this.zzc == null) {
            return;
        }
        if (zzaonVar != null && this.zzc != null) {
            throw new IllegalStateException("Invalid internal representation - full");
        }
        if (zzaonVar == null && this.zzc == null) {
            throw new IllegalStateException("Invalid internal representation - empty");
        }
        throw new IllegalStateException("Impossible");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        byte[] bArr = this.zzc;
        if (bArr == null) {
            bArr = this.zzb.zzax();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzaon zza() {
        if (this.zzb == null) {
            try {
                this.zzb = zzaon.zze(this.zzc, zzgoy.zza());
                this.zzc = null;
            } catch (zzgpy | NullPointerException e4) {
                throw new IllegalStateException(e4);
            }
        }
        zzb();
        return this.zzb;
    }
}
