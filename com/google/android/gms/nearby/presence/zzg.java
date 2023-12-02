package com.google.android.gms.nearby.presence;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@RequiresApi(26)
@SafeParcelable.Class(creator = "PresenceActionCreator")
/* loaded from: classes4.dex */
public final class zzg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzg> CREATOR = new zzh();
    @SafeParcelable.Field(getter = "getActionIdentifier", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final int f22490a;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzg(@SafeParcelable.Param(id = 1) int i4) {
        this.f22490a = i4;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof zzg) || this.f22490a != ((zzg) obj).f22490a) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f22490a));
    }

    public final String toString() {
        return "PresenceAction[action=" + this.f22490a + ']';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f22490a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
