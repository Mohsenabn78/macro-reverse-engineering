package com.google.android.gms.nearby.presence;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@ShowFirstParty
@RequiresApi(26)
@SafeParcelable.Class(creator = "UwbConnectivityCapabilityCreator")
/* loaded from: classes4.dex */
public final class zzm extends AbstractSafeParcelable {
    @SafeParcelable.Field(getter = "isStaticStsSupported", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final boolean f22507a;
    @SafeParcelable.Field(getter = "isProvisionedStsSupported", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final boolean f22508b;
    public static final zzm zza = new zzm(false, false);
    public static final Parcelable.Creator<zzm> CREATOR = new zzn();

    @SafeParcelable.Constructor
    public zzm(@SafeParcelable.Param(id = 1) boolean z3, @SafeParcelable.Param(id = 2) boolean z4) {
        this.f22507a = z3;
        this.f22508b = z4;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzm)) {
            return false;
        }
        zzm zzmVar = (zzm) obj;
        if (this.f22507a == zzmVar.f22507a && this.f22508b == zzmVar.f22508b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f22507a), Boolean.valueOf(this.f22508b)});
    }

    public final String toString() {
        return String.format(Locale.US, "UwbConnectivityCapability<S-STS: %s, P-STS: %s>", Boolean.valueOf(this.f22507a), Boolean.valueOf(this.f22508b));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.f22507a);
        SafeParcelWriter.writeBoolean(parcel, 2, this.f22508b);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
