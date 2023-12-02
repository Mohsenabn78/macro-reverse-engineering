package com.arlosoft.macrodroid.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LockedCategories.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
@Parcelize
/* loaded from: classes3.dex */
public final class LockedCategories implements Parcelable {
    public static final int $stable = 8;
    @NotNull
    public static final Parcelable.Creator<LockedCategories> CREATOR = new Creator();
    @NotNull
    private final Map<String, String> categoryPasswordMap;

    /* compiled from: LockedCategories.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<LockedCategories> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LockedCategories createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            for (int i4 = 0; i4 != readInt; i4++) {
                linkedHashMap.put(parcel.readString(), parcel.readString());
            }
            return new LockedCategories(linkedHashMap);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LockedCategories[] newArray(int i4) {
            return new LockedCategories[i4];
        }
    }

    public LockedCategories(@NotNull Map<String, String> categoryPasswordMap) {
        Intrinsics.checkNotNullParameter(categoryPasswordMap, "categoryPasswordMap");
        this.categoryPasswordMap = categoryPasswordMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LockedCategories copy$default(LockedCategories lockedCategories, Map map, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            map = lockedCategories.categoryPasswordMap;
        }
        return lockedCategories.copy(map);
    }

    @NotNull
    public final Map<String, String> component1() {
        return this.categoryPasswordMap;
    }

    @NotNull
    public final LockedCategories copy(@NotNull Map<String, String> categoryPasswordMap) {
        Intrinsics.checkNotNullParameter(categoryPasswordMap, "categoryPasswordMap");
        return new LockedCategories(categoryPasswordMap);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof LockedCategories) && Intrinsics.areEqual(this.categoryPasswordMap, ((LockedCategories) obj).categoryPasswordMap)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Map<String, String> getCategoryPasswordMap() {
        return this.categoryPasswordMap;
    }

    public int hashCode() {
        return this.categoryPasswordMap.hashCode();
    }

    @NotNull
    public String toString() {
        Map<String, String> map = this.categoryPasswordMap;
        return "LockedCategories(categoryPasswordMap=" + map + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        Map<String, String> map = this.categoryPasswordMap;
        out.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            out.writeString(entry.getKey());
            out.writeString(entry.getValue());
        }
    }
}
