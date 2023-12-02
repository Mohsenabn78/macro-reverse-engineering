package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@ShowFirstParty
@SafeParcelable.Class(creator = "MessageOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class MessageOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<MessageOptions> CREATOR = new zzf();
    public static final int MESSAGE_PRIORITY_HIGH = 1;
    public static final int MESSAGE_PRIORITY_LOW = 0;
    @SafeParcelable.Field(getter = "getPriority", id = 2)

    /* renamed from: a  reason: collision with root package name */
    private final int f22635a;

    @SafeParcelable.Constructor
    public MessageOptions(@SafeParcelable.Param(id = 2) int i4) {
        this.f22635a = i4;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof MessageOptions) || this.f22635a != ((MessageOptions) obj).f22635a) {
            return false;
        }
        return true;
    }

    public int getPriority() {
        return this.f22635a;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f22635a));
    }

    @NonNull
    public String toString() {
        return "MessageOptions[ priority=" + this.f22635a + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, getPriority());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
