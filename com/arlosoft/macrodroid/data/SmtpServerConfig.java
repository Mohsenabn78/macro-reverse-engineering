package com.arlosoft.macrodroid.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SmtpServerConfig.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
@Parcelize
/* loaded from: classes3.dex */
public final class SmtpServerConfig implements Parcelable {
    public static final int $stable = 0;
    @NotNull
    public static final Parcelable.Creator<SmtpServerConfig> CREATOR = new Creator();
    @NotNull
    private final String password;
    @NotNull
    private final String serverAddress;
    @NotNull
    private final String serverPort;
    private final boolean startTlsEnabled;
    private final boolean useAuthentication;
    @NotNull
    private final String username;

    /* compiled from: SmtpServerConfig.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<SmtpServerConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SmtpServerConfig createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SmtpServerConfig(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SmtpServerConfig[] newArray(int i4) {
            return new SmtpServerConfig[i4];
        }
    }

    public SmtpServerConfig(@NotNull String serverAddress, @NotNull String serverPort, boolean z3, @NotNull String username, @NotNull String password, boolean z4) {
        Intrinsics.checkNotNullParameter(serverAddress, "serverAddress");
        Intrinsics.checkNotNullParameter(serverPort, "serverPort");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        this.useAuthentication = z3;
        this.username = username;
        this.password = password;
        this.startTlsEnabled = z4;
    }

    public static /* synthetic */ SmtpServerConfig copy$default(SmtpServerConfig smtpServerConfig, String str, String str2, boolean z3, String str3, String str4, boolean z4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = smtpServerConfig.serverAddress;
        }
        if ((i4 & 2) != 0) {
            str2 = smtpServerConfig.serverPort;
        }
        String str5 = str2;
        if ((i4 & 4) != 0) {
            z3 = smtpServerConfig.useAuthentication;
        }
        boolean z5 = z3;
        if ((i4 & 8) != 0) {
            str3 = smtpServerConfig.username;
        }
        String str6 = str3;
        if ((i4 & 16) != 0) {
            str4 = smtpServerConfig.password;
        }
        String str7 = str4;
        if ((i4 & 32) != 0) {
            z4 = smtpServerConfig.startTlsEnabled;
        }
        return smtpServerConfig.copy(str, str5, z5, str6, str7, z4);
    }

    @NotNull
    public final String component1() {
        return this.serverAddress;
    }

    @NotNull
    public final String component2() {
        return this.serverPort;
    }

    public final boolean component3() {
        return this.useAuthentication;
    }

    @NotNull
    public final String component4() {
        return this.username;
    }

    @NotNull
    public final String component5() {
        return this.password;
    }

    public final boolean component6() {
        return this.startTlsEnabled;
    }

    @NotNull
    public final SmtpServerConfig copy(@NotNull String serverAddress, @NotNull String serverPort, boolean z3, @NotNull String username, @NotNull String password, boolean z4) {
        Intrinsics.checkNotNullParameter(serverAddress, "serverAddress");
        Intrinsics.checkNotNullParameter(serverPort, "serverPort");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        return new SmtpServerConfig(serverAddress, serverPort, z3, username, password, z4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SmtpServerConfig)) {
            return false;
        }
        SmtpServerConfig smtpServerConfig = (SmtpServerConfig) obj;
        if (Intrinsics.areEqual(this.serverAddress, smtpServerConfig.serverAddress) && Intrinsics.areEqual(this.serverPort, smtpServerConfig.serverPort) && this.useAuthentication == smtpServerConfig.useAuthentication && Intrinsics.areEqual(this.username, smtpServerConfig.username) && Intrinsics.areEqual(this.password, smtpServerConfig.password) && this.startTlsEnabled == smtpServerConfig.startTlsEnabled) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getPassword() {
        return this.password;
    }

    @NotNull
    public final String getServerAddress() {
        return this.serverAddress;
    }

    @NotNull
    public final String getServerPort() {
        return this.serverPort;
    }

    public final boolean getStartTlsEnabled() {
        return this.startTlsEnabled;
    }

    public final boolean getUseAuthentication() {
        return this.useAuthentication;
    }

    @NotNull
    public final String getUsername() {
        return this.username;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.serverAddress.hashCode() * 31) + this.serverPort.hashCode()) * 31;
        boolean z3 = this.useAuthentication;
        int i4 = 1;
        int i5 = z3;
        if (z3 != 0) {
            i5 = 1;
        }
        int hashCode2 = (((((hashCode + i5) * 31) + this.username.hashCode()) * 31) + this.password.hashCode()) * 31;
        boolean z4 = this.startTlsEnabled;
        if (!z4) {
            i4 = z4 ? 1 : 0;
        }
        return hashCode2 + i4;
    }

    public final boolean isValid() {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (this.serverAddress.length() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            if (this.serverPort.length() > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                if (!this.useAuthentication) {
                    return true;
                }
                if (this.username.length() > 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z5) {
                    if (this.password.length() > 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (z6) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @NotNull
    public String toString() {
        String str = this.serverAddress;
        String str2 = this.serverPort;
        boolean z3 = this.useAuthentication;
        String str3 = this.username;
        String str4 = this.password;
        boolean z4 = this.startTlsEnabled;
        return "SmtpServerConfig(serverAddress=" + str + ", serverPort=" + str2 + ", useAuthentication=" + z3 + ", username=" + str3 + ", password=" + str4 + ", startTlsEnabled=" + z4 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.serverAddress);
        out.writeString(this.serverPort);
        out.writeInt(this.useAuthentication ? 1 : 0);
        out.writeString(this.username);
        out.writeString(this.password);
        out.writeInt(this.startTlsEnabled ? 1 : 0);
    }
}
