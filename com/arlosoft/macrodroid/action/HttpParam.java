package com.arlosoft.macrodroid.action;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HttpRequestAction.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
@Parcelize
/* loaded from: classes2.dex */
public final class HttpParam implements Parcelable {
    public static final int $stable = 0;
    @NotNull
    public static final Parcelable.Creator<HttpParam> CREATOR = new Creator();
    @NotNull
    private final String paramName;
    @NotNull
    private final String paramValue;

    /* compiled from: HttpRequestAction.kt */
    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<HttpParam> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final HttpParam createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new HttpParam(parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final HttpParam[] newArray(int i4) {
            return new HttpParam[i4];
        }
    }

    public HttpParam(@NotNull String paramName, @NotNull String paramValue) {
        Intrinsics.checkNotNullParameter(paramName, "paramName");
        Intrinsics.checkNotNullParameter(paramValue, "paramValue");
        this.paramName = paramName;
        this.paramValue = paramValue;
    }

    public static /* synthetic */ HttpParam copy$default(HttpParam httpParam, String str, String str2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = httpParam.paramName;
        }
        if ((i4 & 2) != 0) {
            str2 = httpParam.paramValue;
        }
        return httpParam.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.paramName;
    }

    @NotNull
    public final String component2() {
        return this.paramValue;
    }

    @NotNull
    public final HttpParam copy(@NotNull String paramName, @NotNull String paramValue) {
        Intrinsics.checkNotNullParameter(paramName, "paramName");
        Intrinsics.checkNotNullParameter(paramValue, "paramValue");
        return new HttpParam(paramName, paramValue);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpParam)) {
            return false;
        }
        HttpParam httpParam = (HttpParam) obj;
        if (Intrinsics.areEqual(this.paramName, httpParam.paramName) && Intrinsics.areEqual(this.paramValue, httpParam.paramValue)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getParamName() {
        return this.paramName;
    }

    @NotNull
    public final String getParamValue() {
        return this.paramValue;
    }

    public int hashCode() {
        return (this.paramName.hashCode() * 31) + this.paramValue.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.paramName;
        String str2 = this.paramValue;
        return "HttpParam(paramName=" + str + ", paramValue=" + str2 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.paramName);
        out.writeString(this.paramValue);
    }
}
