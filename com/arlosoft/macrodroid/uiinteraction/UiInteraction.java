package com.arlosoft.macrodroid.uiinteraction;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.animation.a;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UiInteraction.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
@Parcelize
/* loaded from: classes3.dex */
public final class UiInteraction implements Parcelable {
    public static final int $stable = 8;
    @NotNull
    public static final Parcelable.Creator<UiInteraction> CREATOR = new Creator();
    @NotNull
    private final String contentDescription;
    private final int eventType;
    private final int hashCode;
    @NotNull
    private final String packageName;
    @NotNull
    private final Point screenXY;
    private final long timestamp;
    @NotNull
    private final String viewIdResourceName;
    @NotNull
    private final String viewText;

    /* compiled from: UiInteraction.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<UiInteraction> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UiInteraction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UiInteraction(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), (Point) parcel.readParcelable(UiInteraction.class.getClassLoader()), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UiInteraction[] newArray(int i4) {
            return new UiInteraction[i4];
        }
    }

    public UiInteraction(@NotNull String packageName, int i4, @NotNull String viewIdResourceName, @NotNull String viewText, @NotNull String contentDescription, int i5, @NotNull Point screenXY, long j4) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(viewIdResourceName, "viewIdResourceName");
        Intrinsics.checkNotNullParameter(viewText, "viewText");
        Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
        Intrinsics.checkNotNullParameter(screenXY, "screenXY");
        this.packageName = packageName;
        this.eventType = i4;
        this.viewIdResourceName = viewIdResourceName;
        this.viewText = viewText;
        this.contentDescription = contentDescription;
        this.hashCode = i5;
        this.screenXY = screenXY;
        this.timestamp = j4;
    }

    public static /* synthetic */ UiInteraction copy$default(UiInteraction uiInteraction, String str, int i4, String str2, String str3, String str4, int i5, Point point, long j4, int i6, Object obj) {
        String str5;
        int i7;
        String str6;
        String str7;
        String str8;
        int i8;
        Point point2;
        long j5;
        if ((i6 & 1) != 0) {
            str5 = uiInteraction.packageName;
        } else {
            str5 = str;
        }
        if ((i6 & 2) != 0) {
            i7 = uiInteraction.eventType;
        } else {
            i7 = i4;
        }
        if ((i6 & 4) != 0) {
            str6 = uiInteraction.viewIdResourceName;
        } else {
            str6 = str2;
        }
        if ((i6 & 8) != 0) {
            str7 = uiInteraction.viewText;
        } else {
            str7 = str3;
        }
        if ((i6 & 16) != 0) {
            str8 = uiInteraction.contentDescription;
        } else {
            str8 = str4;
        }
        if ((i6 & 32) != 0) {
            i8 = uiInteraction.hashCode;
        } else {
            i8 = i5;
        }
        if ((i6 & 64) != 0) {
            point2 = uiInteraction.screenXY;
        } else {
            point2 = point;
        }
        if ((i6 & 128) != 0) {
            j5 = uiInteraction.timestamp;
        } else {
            j5 = j4;
        }
        return uiInteraction.copy(str5, i7, str6, str7, str8, i8, point2, j5);
    }

    @NotNull
    public final String component1() {
        return this.packageName;
    }

    public final int component2() {
        return this.eventType;
    }

    @NotNull
    public final String component3() {
        return this.viewIdResourceName;
    }

    @NotNull
    public final String component4() {
        return this.viewText;
    }

    @NotNull
    public final String component5() {
        return this.contentDescription;
    }

    public final int component6() {
        return this.hashCode;
    }

    @NotNull
    public final Point component7() {
        return this.screenXY;
    }

    public final long component8() {
        return this.timestamp;
    }

    @NotNull
    public final UiInteraction copy(@NotNull String packageName, int i4, @NotNull String viewIdResourceName, @NotNull String viewText, @NotNull String contentDescription, int i5, @NotNull Point screenXY, long j4) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(viewIdResourceName, "viewIdResourceName");
        Intrinsics.checkNotNullParameter(viewText, "viewText");
        Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
        Intrinsics.checkNotNullParameter(screenXY, "screenXY");
        return new UiInteraction(packageName, i4, viewIdResourceName, viewText, contentDescription, i5, screenXY, j4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UiInteraction)) {
            return false;
        }
        UiInteraction uiInteraction = (UiInteraction) obj;
        if (Intrinsics.areEqual(this.packageName, uiInteraction.packageName) && this.eventType == uiInteraction.eventType && Intrinsics.areEqual(this.viewIdResourceName, uiInteraction.viewIdResourceName) && Intrinsics.areEqual(this.viewText, uiInteraction.viewText) && Intrinsics.areEqual(this.contentDescription, uiInteraction.contentDescription) && this.hashCode == uiInteraction.hashCode && Intrinsics.areEqual(this.screenXY, uiInteraction.screenXY) && this.timestamp == uiInteraction.timestamp) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getContentDescription() {
        return this.contentDescription;
    }

    public final int getEventType() {
        return this.eventType;
    }

    public final int getHashCode() {
        return this.hashCode;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    public final Point getScreenXY() {
        return this.screenXY;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    public final String getViewIdResourceName() {
        return this.viewIdResourceName;
    }

    @NotNull
    public final String getViewText() {
        return this.viewText;
    }

    public int hashCode() {
        return (((((((((((((this.packageName.hashCode() * 31) + this.eventType) * 31) + this.viewIdResourceName.hashCode()) * 31) + this.viewText.hashCode()) * 31) + this.contentDescription.hashCode()) * 31) + this.hashCode) * 31) + this.screenXY.hashCode()) * 31) + a.a(this.timestamp);
    }

    @NotNull
    public String toString() {
        String str = this.packageName;
        int i4 = this.eventType;
        String str2 = this.viewIdResourceName;
        String str3 = this.viewText;
        String str4 = this.contentDescription;
        int i5 = this.hashCode;
        Point point = this.screenXY;
        long j4 = this.timestamp;
        return "UiInteraction(packageName=" + str + ", eventType=" + i4 + ", viewIdResourceName=" + str2 + ", viewText=" + str3 + ", contentDescription=" + str4 + ", hashCode=" + i5 + ", screenXY=" + point + ", timestamp=" + j4 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.packageName);
        out.writeInt(this.eventType);
        out.writeString(this.viewIdResourceName);
        out.writeString(this.viewText);
        out.writeString(this.contentDescription);
        out.writeInt(this.hashCode);
        out.writeParcelable(this.screenXY, i4);
        out.writeLong(this.timestamp);
    }
}
