package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "StrategyCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class Strategy extends AbstractSafeParcelable {
    @SafeParcelable.Field(getter = "getConnectionType", id = 3)

    /* renamed from: a  reason: collision with root package name */
    private final int f22222a;
    @SafeParcelable.Field(getter = "getTopology", id = 4)

    /* renamed from: b  reason: collision with root package name */
    private final int f22223b;
    @NonNull
    public static final Parcelable.Creator<Strategy> CREATOR = new zzy();
    @NonNull
    public static final Strategy P2P_CLUSTER = new Strategy(1, 3);
    @NonNull
    public static final Strategy P2P_STAR = new Strategy(1, 2);
    @NonNull
    public static final Strategy P2P_POINT_TO_POINT = new Strategy(1, 1);

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public Strategy(@SafeParcelable.Param(id = 3) int i4, @SafeParcelable.Param(id = 4) int i5) {
        this.f22222a = i4;
        this.f22223b = i5;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Strategy)) {
            return false;
        }
        Strategy strategy = (Strategy) obj;
        if (this.f22222a == strategy.f22222a && this.f22223b == strategy.f22223b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f22222a), Integer.valueOf(this.f22223b));
    }

    @NonNull
    public String toString() {
        String str;
        Locale locale = Locale.US;
        Object[] objArr = new Object[3];
        if (P2P_CLUSTER.equals(this)) {
            str = "P2P_CLUSTER";
        } else if (P2P_STAR.equals(this)) {
            str = "P2P_STAR";
        } else if (P2P_POINT_TO_POINT.equals(this)) {
            str = "P2P_POINT_TO_POINT";
        } else {
            str = "UNKNOWN";
        }
        objArr[0] = str;
        objArr[1] = Integer.valueOf(this.f22222a);
        objArr[2] = Integer.valueOf(this.f22223b);
        return String.format(locale, "Strategy(%s){connectionType=%d, topology=%d}", objArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 3, this.f22222a);
        SafeParcelWriter.writeInt(parcel, 4, this.f22223b);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
