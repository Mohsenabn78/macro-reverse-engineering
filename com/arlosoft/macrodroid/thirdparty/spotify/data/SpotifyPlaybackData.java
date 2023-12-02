package com.arlosoft.macrodroid.thirdparty.spotify.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SpotifyPlaybackData.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
@Parcelize
/* loaded from: classes3.dex */
public final class SpotifyPlaybackData implements Parcelable {
    public static final int $stable = 0;
    @NotNull
    public static final Parcelable.Creator<SpotifyPlaybackData> CREATOR = new Creator();
    @Nullable
    private final String albumName;
    @Nullable
    private final String artistName;
    @Nullable
    private final String id;
    private final boolean isPlaying;
    private final int trackLengthSeconds;
    @Nullable
    private final String trackName;

    /* compiled from: SpotifyPlaybackData.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<SpotifyPlaybackData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SpotifyPlaybackData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SpotifyPlaybackData(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SpotifyPlaybackData[] newArray(int i4) {
            return new SpotifyPlaybackData[i4];
        }
    }

    public SpotifyPlaybackData(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i4, boolean z3) {
        this.id = str;
        this.artistName = str2;
        this.albumName = str3;
        this.trackName = str4;
        this.trackLengthSeconds = i4;
        this.isPlaying = z3;
    }

    public static /* synthetic */ SpotifyPlaybackData copy$default(SpotifyPlaybackData spotifyPlaybackData, String str, String str2, String str3, String str4, int i4, boolean z3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = spotifyPlaybackData.id;
        }
        if ((i5 & 2) != 0) {
            str2 = spotifyPlaybackData.artistName;
        }
        String str5 = str2;
        if ((i5 & 4) != 0) {
            str3 = spotifyPlaybackData.albumName;
        }
        String str6 = str3;
        if ((i5 & 8) != 0) {
            str4 = spotifyPlaybackData.trackName;
        }
        String str7 = str4;
        if ((i5 & 16) != 0) {
            i4 = spotifyPlaybackData.trackLengthSeconds;
        }
        int i6 = i4;
        if ((i5 & 32) != 0) {
            z3 = spotifyPlaybackData.isPlaying;
        }
        return spotifyPlaybackData.copy(str, str5, str6, str7, i6, z3);
    }

    @Nullable
    public final String component1() {
        return this.id;
    }

    @Nullable
    public final String component2() {
        return this.artistName;
    }

    @Nullable
    public final String component3() {
        return this.albumName;
    }

    @Nullable
    public final String component4() {
        return this.trackName;
    }

    public final int component5() {
        return this.trackLengthSeconds;
    }

    public final boolean component6() {
        return this.isPlaying;
    }

    @NotNull
    public final SpotifyPlaybackData copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i4, boolean z3) {
        return new SpotifyPlaybackData(str, str2, str3, str4, i4, z3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpotifyPlaybackData)) {
            return false;
        }
        SpotifyPlaybackData spotifyPlaybackData = (SpotifyPlaybackData) obj;
        if (Intrinsics.areEqual(this.id, spotifyPlaybackData.id) && Intrinsics.areEqual(this.artistName, spotifyPlaybackData.artistName) && Intrinsics.areEqual(this.albumName, spotifyPlaybackData.albumName) && Intrinsics.areEqual(this.trackName, spotifyPlaybackData.trackName) && this.trackLengthSeconds == spotifyPlaybackData.trackLengthSeconds && this.isPlaying == spotifyPlaybackData.isPlaying) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getAlbumName() {
        return this.albumName;
    }

    @Nullable
    public final String getArtistName() {
        return this.artistName;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    public final int getTrackLengthSeconds() {
        return this.trackLengthSeconds;
    }

    @Nullable
    public final String getTrackName() {
        return this.trackName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        String str = this.id;
        int i4 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i5 = hashCode * 31;
        String str2 = this.artistName;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i6 = (i5 + hashCode2) * 31;
        String str3 = this.albumName;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i7 = (i6 + hashCode3) * 31;
        String str4 = this.trackName;
        if (str4 != null) {
            i4 = str4.hashCode();
        }
        int i8 = (((i7 + i4) * 31) + this.trackLengthSeconds) * 31;
        boolean z3 = this.isPlaying;
        int i9 = z3;
        if (z3 != 0) {
            i9 = 1;
        }
        return i8 + i9;
    }

    public final boolean isPlaying() {
        return this.isPlaying;
    }

    @NotNull
    public String toString() {
        String str = this.id;
        String str2 = this.artistName;
        String str3 = this.albumName;
        String str4 = this.trackName;
        int i4 = this.trackLengthSeconds;
        boolean z3 = this.isPlaying;
        return "SpotifyPlaybackData(id=" + str + ", artistName=" + str2 + ", albumName=" + str3 + ", trackName=" + str4 + ", trackLengthSeconds=" + i4 + ", isPlaying=" + z3 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.id);
        out.writeString(this.artistName);
        out.writeString(this.albumName);
        out.writeString(this.trackName);
        out.writeInt(this.trackLengthSeconds);
        out.writeInt(this.isPlaying ? 1 : 0);
    }
}
