package com.arlosoft.macrodroid.beacons;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import com.getpebble.android.kit.Constants;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BeaconWithName.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
@Parcelize
/* loaded from: classes3.dex */
public final class BeaconWithName implements Parcelable {
    public static final int $stable = 0;
    @NotNull
    public static final Parcelable.Creator<BeaconWithName> CREATOR = new Creator();
    @SerializedName(alternate = {"b"}, value = "name")
    @Nullable
    private final String name;
    @SerializedName(alternate = {"a"}, value = Constants.APP_UUID)
    @NotNull
    private final String uuid;

    /* compiled from: BeaconWithName.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<BeaconWithName> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BeaconWithName createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BeaconWithName(parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BeaconWithName[] newArray(int i4) {
            return new BeaconWithName[i4];
        }
    }

    public BeaconWithName(@NotNull String uuid, @Nullable String str) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.uuid = uuid;
        this.name = str;
    }

    public static /* synthetic */ BeaconWithName copy$default(BeaconWithName beaconWithName, String str, String str2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = beaconWithName.uuid;
        }
        if ((i4 & 2) != 0) {
            str2 = beaconWithName.name;
        }
        return beaconWithName.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.uuid;
    }

    @Nullable
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final BeaconWithName copy(@NotNull String uuid, @Nullable String str) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return new BeaconWithName(uuid, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof BeaconWithName) {
            return Intrinsics.areEqual(((BeaconWithName) obj).uuid, this.uuid);
        }
        return false;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        return this.uuid.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.uuid;
        String str2 = this.name;
        return "BeaconWithName(uuid=" + str + ", name=" + str2 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.uuid);
        out.writeString(this.name);
    }

    public /* synthetic */ BeaconWithName(String str, String str2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i4 & 2) != 0 ? "" : str2);
    }
}
