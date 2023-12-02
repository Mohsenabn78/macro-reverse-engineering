package com.google.android.gms.nearby.presence;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@ShowFirstParty
@RequiresApi(26)
@SafeParcelable.Class(creator = "SequenceNumberCreator")
/* loaded from: classes4.dex */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new zzl();
    @SafeParcelable.Field(getter = "getValue", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final int f22506a;

    @SafeParcelable.Constructor
    public zzk(@SafeParcelable.Param(id = 1) int i4) {
        boolean z3 = false;
        if (i4 >= 0 && i4 <= 15) {
            z3 = true;
        }
        Preconditions.checkArgument(z3, "Sequence number should be 4 bits.");
        this.f22506a = i4;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof zzk) || this.f22506a != ((zzk) obj).f22506a) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{19, Integer.valueOf(this.f22506a)});
    }

    public final String toString() {
        return String.format(Locale.US, "DataElement<type: %s, value: %d>", "ContextSequenceNumber", Integer.valueOf(this.f22506a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f22506a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
