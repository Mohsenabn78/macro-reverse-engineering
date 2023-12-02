package com.arlosoft.macrodroid.action.services;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ScreenContentElement.kt */
@StabilityInferred(parameters = 0)
@Parcelize
/* loaded from: classes2.dex */
public final class ScreenContentElement implements Parcelable {
    public static final int $stable = 8;
    @NotNull
    public static final Parcelable.Creator<ScreenContentElement> CREATOR = new Creator();
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final String f4890a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f4891b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Rect f4892c;

    /* compiled from: ScreenContentElement.kt */
    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<ScreenContentElement> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ScreenContentElement createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ScreenContentElement(parcel.readString(), parcel.readString(), (Rect) parcel.readParcelable(ScreenContentElement.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ScreenContentElement[] newArray(int i4) {
            return new ScreenContentElement[i4];
        }
    }

    public ScreenContentElement(@Nullable String str, @NotNull String text, @NotNull Rect bounds) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        this.f4890a = str;
        this.f4891b = text;
        this.f4892c = bounds;
    }

    public static /* synthetic */ ScreenContentElement copy$default(ScreenContentElement screenContentElement, String str, String str2, Rect rect, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = screenContentElement.f4890a;
        }
        if ((i4 & 2) != 0) {
            str2 = screenContentElement.f4891b;
        }
        if ((i4 & 4) != 0) {
            rect = screenContentElement.f4892c;
        }
        return screenContentElement.copy(str, str2, rect);
    }

    @Nullable
    public final String component1() {
        return this.f4890a;
    }

    @NotNull
    public final String component2() {
        return this.f4891b;
    }

    @NotNull
    public final Rect component3() {
        return this.f4892c;
    }

    @NotNull
    public final ScreenContentElement copy(@Nullable String str, @NotNull String text, @NotNull Rect bounds) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        return new ScreenContentElement(str, text, bounds);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScreenContentElement)) {
            return false;
        }
        ScreenContentElement screenContentElement = (ScreenContentElement) obj;
        if (Intrinsics.areEqual(this.f4890a, screenContentElement.f4890a) && Intrinsics.areEqual(this.f4891b, screenContentElement.f4891b) && Intrinsics.areEqual(this.f4892c, screenContentElement.f4892c)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Rect getBounds() {
        return this.f4892c;
    }

    @NotNull
    public final String getText() {
        return this.f4891b;
    }

    @Nullable
    public final String getViewId() {
        return this.f4890a;
    }

    public int hashCode() {
        int hashCode;
        String str = this.f4890a;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return (((hashCode * 31) + this.f4891b.hashCode()) * 31) + this.f4892c.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.f4890a;
        String str2 = this.f4891b;
        Rect rect = this.f4892c;
        return "ScreenContentElement(viewId=" + str + ", text=" + str2 + ", bounds=" + rect + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.f4890a);
        out.writeString(this.f4891b);
        out.writeParcelable(this.f4892c, i4);
    }
}
