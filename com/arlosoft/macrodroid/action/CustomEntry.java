package com.arlosoft.macrodroid.action;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.ColorInt;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SelectionDialogAction.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
@Parcelize
/* loaded from: classes2.dex */
public final class CustomEntry implements Parcelable {
    public static final int $stable = 0;
    @NotNull
    public static final Parcelable.Creator<CustomEntry> CREATOR = new Creator();
    private final int color;
    private final boolean isBold;
    private final boolean isItalic;
    @NotNull
    private final String text;

    /* compiled from: SelectionDialogAction.kt */
    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<CustomEntry> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CustomEntry createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CustomEntry(parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CustomEntry[] newArray(int i4) {
            return new CustomEntry[i4];
        }
    }

    public CustomEntry() {
        this(null, 0, false, false, 15, null);
    }

    public static /* synthetic */ CustomEntry copy$default(CustomEntry customEntry, String str, int i4, boolean z3, boolean z4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = customEntry.text;
        }
        if ((i5 & 2) != 0) {
            i4 = customEntry.color;
        }
        if ((i5 & 4) != 0) {
            z3 = customEntry.isBold;
        }
        if ((i5 & 8) != 0) {
            z4 = customEntry.isItalic;
        }
        return customEntry.copy(str, i4, z3, z4);
    }

    @NotNull
    public final String component1() {
        return this.text;
    }

    public final int component2() {
        return this.color;
    }

    public final boolean component3() {
        return this.isBold;
    }

    public final boolean component4() {
        return this.isItalic;
    }

    @NotNull
    public final CustomEntry copy(@NotNull String text, @ColorInt int i4, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new CustomEntry(text, i4, z3, z4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomEntry)) {
            return false;
        }
        CustomEntry customEntry = (CustomEntry) obj;
        if (Intrinsics.areEqual(this.text, customEntry.text) && this.color == customEntry.color && this.isBold == customEntry.isBold && this.isItalic == customEntry.isItalic) {
            return true;
        }
        return false;
    }

    public final int getColor() {
        return this.color;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.text.hashCode() * 31) + this.color) * 31;
        boolean z3 = this.isBold;
        int i4 = 1;
        int i5 = z3;
        if (z3 != 0) {
            i5 = 1;
        }
        int i6 = (hashCode + i5) * 31;
        boolean z4 = this.isItalic;
        if (!z4) {
            i4 = z4 ? 1 : 0;
        }
        return i6 + i4;
    }

    public final boolean isBold() {
        return this.isBold;
    }

    public final boolean isItalic() {
        return this.isItalic;
    }

    @NotNull
    public String toString() {
        String str = this.text;
        int i4 = this.color;
        boolean z3 = this.isBold;
        boolean z4 = this.isItalic;
        return "CustomEntry(text=" + str + ", color=" + i4 + ", isBold=" + z3 + ", isItalic=" + z4 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.text);
        out.writeInt(this.color);
        out.writeInt(this.isBold ? 1 : 0);
        out.writeInt(this.isItalic ? 1 : 0);
    }

    public CustomEntry(@NotNull String text, @ColorInt int i4, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.color = i4;
        this.isBold = z3;
        this.isItalic = z4;
    }

    public /* synthetic */ CustomEntry(String str, int i4, boolean z3, boolean z4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? "" : str, (i5 & 2) != 0 ? 0 : i4, (i5 & 4) != 0 ? false : z3, (i5 & 8) != 0 ? false : z4);
    }
}
