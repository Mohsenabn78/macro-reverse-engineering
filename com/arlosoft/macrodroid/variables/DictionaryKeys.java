package com.arlosoft.macrodroid.variables;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DictionaryKeys.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
@Parcelize
/* loaded from: classes3.dex */
public final class DictionaryKeys implements Parcelable {
    public static final int $stable = 8;
    @NotNull
    public static final Parcelable.Creator<DictionaryKeys> CREATOR = new Creator();
    @SerializedName(alternate = {"a"}, value = UserMetadata.KEYDATA_FILENAME)
    @NotNull
    private final List<String> keys;

    /* compiled from: DictionaryKeys.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<DictionaryKeys> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DictionaryKeys createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DictionaryKeys(parcel.createStringArrayList());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DictionaryKeys[] newArray(int i4) {
            return new DictionaryKeys[i4];
        }
    }

    public DictionaryKeys(@NotNull List<String> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        this.keys = keys;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DictionaryKeys copy$default(DictionaryKeys dictionaryKeys, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = dictionaryKeys.keys;
        }
        return dictionaryKeys.copy(list);
    }

    @NotNull
    public final List<String> component1() {
        return this.keys;
    }

    @NotNull
    public final DictionaryKeys copy(@NotNull List<String> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        return new DictionaryKeys(keys);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof DictionaryKeys) && Intrinsics.areEqual(this.keys, ((DictionaryKeys) obj).keys)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<String> getKeys() {
        return this.keys;
    }

    public int hashCode() {
        return this.keys.hashCode();
    }

    @NotNull
    public String toString() {
        List<String> list = this.keys;
        return "DictionaryKeys(keys=" + list + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeStringList(this.keys);
    }
}
