package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.common.Util;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
@ShowFirstParty
@SafeParcelable.Class(creator = "DocumentSectionCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzk extends AbstractSafeParcelable {
    private static final zzs zzf;
    @Nullable
    @SafeParcelable.Field(id = 1)
    public final String zzb;
    @SafeParcelable.Field(id = 3)
    final zzs zzc;
    @SafeParcelable.Field(defaultValue = Util.ANY_CONTACT_ID, id = 4)
    public final int zzd;
    @Nullable
    @SafeParcelable.Field(id = 5)
    public final byte[] zze;
    public static final int zza = Integer.parseInt(Util.ANY_CONTACT_ID);
    public static final Parcelable.Creator<zzk> CREATOR = new zzl();

    static {
        zzr zzrVar = new zzr("SsbContext");
        zzrVar.zzb(true);
        zzrVar.zza("blob");
        zzf = zzrVar.zze();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzk(@Nullable @SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 3) zzs zzsVar, @SafeParcelable.Param(id = 4) int i4, @Nullable @SafeParcelable.Param(id = 5) byte[] bArr) {
        String str2;
        int i5 = zza;
        boolean z3 = true;
        if (i4 != i5 && zzq.zza(i4) == null) {
            z3 = false;
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append("Invalid section type ");
        sb.append(i4);
        Preconditions.checkArgument(z3, sb.toString());
        this.zzb = str;
        this.zzc = zzsVar;
        this.zzd = i4;
        this.zze = bArr;
        if (i4 == i5 || zzq.zza(i4) != null) {
            str2 = (str == null || bArr == null) ? null : "Both content and blobContent set";
        } else {
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append("Invalid section type ");
            sb2.append(i4);
            str2 = sb2.toString();
        }
        if (str2 != null) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static zzk zza(byte[] bArr) {
        return new zzk(null, zzf, zza, bArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i4, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeByteArray(parcel, 5, this.zze, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzk(byte[] bArr, zzs zzsVar) {
        this(null, zzsVar, zza, bArr);
    }
}
