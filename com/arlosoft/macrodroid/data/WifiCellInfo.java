package com.arlosoft.macrodroid.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WifiCellInfo.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class WifiCellInfo implements Parcelable {
    public static final int $stable = 0;
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    @Nullable
    private final String bssid;
    @NotNull
    private final String displayName;
    @NotNull
    private final String ssid;

    /* compiled from: WifiCellInfo.kt */
    /* loaded from: classes3.dex */
    public static final class CREATOR implements Parcelable.Creator<WifiCellInfo> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public WifiCellInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WifiCellInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public WifiCellInfo[] newArray(int i4) {
            return new WifiCellInfo[i4];
        }
    }

    public WifiCellInfo(@NotNull String ssid, @Nullable String str, @NotNull String displayName) {
        Intrinsics.checkNotNullParameter(ssid, "ssid");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        this.ssid = ssid;
        this.bssid = str;
        this.displayName = displayName;
    }

    public static /* synthetic */ WifiCellInfo copy$default(WifiCellInfo wifiCellInfo, String str, String str2, String str3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = wifiCellInfo.ssid;
        }
        if ((i4 & 2) != 0) {
            str2 = wifiCellInfo.bssid;
        }
        if ((i4 & 4) != 0) {
            str3 = wifiCellInfo.displayName;
        }
        return wifiCellInfo.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.ssid;
    }

    @Nullable
    public final String component2() {
        return this.bssid;
    }

    @NotNull
    public final String component3() {
        return this.displayName;
    }

    @NotNull
    public final WifiCellInfo copy(@NotNull String ssid, @Nullable String str, @NotNull String displayName) {
        Intrinsics.checkNotNullParameter(ssid, "ssid");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        return new WifiCellInfo(ssid, str, displayName);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WifiCellInfo)) {
            return false;
        }
        WifiCellInfo wifiCellInfo = (WifiCellInfo) obj;
        if (Intrinsics.areEqual(this.ssid, wifiCellInfo.ssid) && Intrinsics.areEqual(this.bssid, wifiCellInfo.bssid) && Intrinsics.areEqual(this.displayName, wifiCellInfo.displayName)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getBssid() {
        return this.bssid;
    }

    @NotNull
    public final String getDisplayName() {
        return this.displayName;
    }

    @NotNull
    public final String getSsid() {
        return this.ssid;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.ssid.hashCode() * 31;
        String str = this.bssid;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((hashCode2 + hashCode) * 31) + this.displayName.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.ssid;
        String str2 = this.bssid;
        String str3 = this.displayName;
        return "WifiCellInfo(ssid=" + str + ", bssid=" + str2 + ", displayName=" + str3 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i4) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.ssid);
        parcel.writeString(this.bssid);
        parcel.writeString(this.displayName);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public WifiCellInfo(@org.jetbrains.annotations.NotNull android.os.Parcel r4) {
        /*
            r3 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = r4.readString()
            java.lang.String r1 = ""
            if (r0 != 0) goto Le
            r0 = r1
        Le:
            java.lang.String r2 = r4.readString()
            java.lang.String r4 = r4.readString()
            if (r4 != 0) goto L19
            goto L1a
        L19:
            r1 = r4
        L1a:
            r3.<init>(r0, r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.data.WifiCellInfo.<init>(android.os.Parcel):void");
    }
}
