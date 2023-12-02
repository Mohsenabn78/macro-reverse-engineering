package com.arlosoft.macrodroid.variables;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.action.activities.VariableValuePrompt;
import com.arlosoft.macrodroid.common.DontObfuscate;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VariableWithDictionaryKeys.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
@Parcelize
/* loaded from: classes3.dex */
public final class VariableWithDictionaryKeys implements Parcelable {
    public static final int $stable = 8;
    @NotNull
    public static final Parcelable.Creator<VariableWithDictionaryKeys> CREATOR = new Creator();
    @SerializedName(alternate = {"b"}, value = UserMetadata.KEYDATA_FILENAME)
    @NotNull
    private final DictionaryKeys keys;
    @SerializedName(alternate = {"a"}, value = VariableValuePrompt.EXTRA_VARIABLE_NAME)
    @NotNull
    private final String variableName;

    /* compiled from: VariableWithDictionaryKeys.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<VariableWithDictionaryKeys> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VariableWithDictionaryKeys createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VariableWithDictionaryKeys(parcel.readString(), DictionaryKeys.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VariableWithDictionaryKeys[] newArray(int i4) {
            return new VariableWithDictionaryKeys[i4];
        }
    }

    public VariableWithDictionaryKeys(@NotNull String variableName, @NotNull DictionaryKeys keys) {
        Intrinsics.checkNotNullParameter(variableName, "variableName");
        Intrinsics.checkNotNullParameter(keys, "keys");
        this.variableName = variableName;
        this.keys = keys;
    }

    public static /* synthetic */ VariableWithDictionaryKeys copy$default(VariableWithDictionaryKeys variableWithDictionaryKeys, String str, DictionaryKeys dictionaryKeys, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = variableWithDictionaryKeys.variableName;
        }
        if ((i4 & 2) != 0) {
            dictionaryKeys = variableWithDictionaryKeys.keys;
        }
        return variableWithDictionaryKeys.copy(str, dictionaryKeys);
    }

    @NotNull
    public final String component1() {
        return this.variableName;
    }

    @NotNull
    public final DictionaryKeys component2() {
        return this.keys;
    }

    @NotNull
    public final VariableWithDictionaryKeys copy(@NotNull String variableName, @NotNull DictionaryKeys keys) {
        Intrinsics.checkNotNullParameter(variableName, "variableName");
        Intrinsics.checkNotNullParameter(keys, "keys");
        return new VariableWithDictionaryKeys(variableName, keys);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VariableWithDictionaryKeys)) {
            return false;
        }
        VariableWithDictionaryKeys variableWithDictionaryKeys = (VariableWithDictionaryKeys) obj;
        if (Intrinsics.areEqual(this.variableName, variableWithDictionaryKeys.variableName) && Intrinsics.areEqual(this.keys, variableWithDictionaryKeys.keys)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final DictionaryKeys getKeys() {
        return this.keys;
    }

    @NotNull
    public final String getVariableName() {
        return this.variableName;
    }

    public int hashCode() {
        return (this.variableName.hashCode() * 31) + this.keys.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.variableName;
        DictionaryKeys dictionaryKeys = this.keys;
        return "VariableWithDictionaryKeys(variableName=" + str + ", keys=" + dictionaryKeys + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.variableName);
        this.keys.writeToParcel(out, i4);
    }
}
