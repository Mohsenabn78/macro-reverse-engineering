package com.arlosoft.macrodroid.triggers.receivers;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SpotifyReceiver.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class SpotifyData {
    public static final int $stable = 0;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final String f15357a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final String f15358b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final String f15359c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final String f15360d;

    /* renamed from: e  reason: collision with root package name */
    private final int f15361e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f15362f;

    public SpotifyData(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i4, boolean z3) {
        this.f15357a = str;
        this.f15358b = str2;
        this.f15359c = str3;
        this.f15360d = str4;
        this.f15361e = i4;
        this.f15362f = z3;
    }

    public static /* synthetic */ SpotifyData copy$default(SpotifyData spotifyData, String str, String str2, String str3, String str4, int i4, boolean z3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = spotifyData.f15357a;
        }
        if ((i5 & 2) != 0) {
            str2 = spotifyData.f15358b;
        }
        String str5 = str2;
        if ((i5 & 4) != 0) {
            str3 = spotifyData.f15359c;
        }
        String str6 = str3;
        if ((i5 & 8) != 0) {
            str4 = spotifyData.f15360d;
        }
        String str7 = str4;
        if ((i5 & 16) != 0) {
            i4 = spotifyData.f15361e;
        }
        int i6 = i4;
        if ((i5 & 32) != 0) {
            z3 = spotifyData.f15362f;
        }
        return spotifyData.copy(str, str5, str6, str7, i6, z3);
    }

    @Nullable
    public final String component1() {
        return this.f15357a;
    }

    @Nullable
    public final String component2() {
        return this.f15358b;
    }

    @Nullable
    public final String component3() {
        return this.f15359c;
    }

    @Nullable
    public final String component4() {
        return this.f15360d;
    }

    public final int component5() {
        return this.f15361e;
    }

    public final boolean component6() {
        return this.f15362f;
    }

    @NotNull
    public final SpotifyData copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i4, boolean z3) {
        return new SpotifyData(str, str2, str3, str4, i4, z3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpotifyData)) {
            return false;
        }
        SpotifyData spotifyData = (SpotifyData) obj;
        if (Intrinsics.areEqual(this.f15357a, spotifyData.f15357a) && Intrinsics.areEqual(this.f15358b, spotifyData.f15358b) && Intrinsics.areEqual(this.f15359c, spotifyData.f15359c) && Intrinsics.areEqual(this.f15360d, spotifyData.f15360d) && this.f15361e == spotifyData.f15361e && this.f15362f == spotifyData.f15362f) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getAlbumName() {
        return this.f15359c;
    }

    @Nullable
    public final String getArtistName() {
        return this.f15358b;
    }

    @Nullable
    public final String getTrackId() {
        return this.f15357a;
    }

    public final int getTrackLengthSeconds() {
        return this.f15361e;
    }

    @Nullable
    public final String getTrackName() {
        return this.f15360d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        String str = this.f15357a;
        int i4 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i5 = hashCode * 31;
        String str2 = this.f15358b;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i6 = (i5 + hashCode2) * 31;
        String str3 = this.f15359c;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i7 = (i6 + hashCode3) * 31;
        String str4 = this.f15360d;
        if (str4 != null) {
            i4 = str4.hashCode();
        }
        int i8 = (((i7 + i4) * 31) + this.f15361e) * 31;
        boolean z3 = this.f15362f;
        int i9 = z3;
        if (z3 != 0) {
            i9 = 1;
        }
        return i8 + i9;
    }

    public final boolean isPlaying() {
        return this.f15362f;
    }

    @NotNull
    public String toString() {
        String str = this.f15357a;
        String str2 = this.f15358b;
        String str3 = this.f15359c;
        String str4 = this.f15360d;
        int i4 = this.f15361e;
        boolean z3 = this.f15362f;
        return "SpotifyData(trackId=" + str + ", artistName=" + str2 + ", albumName=" + str3 + ", trackName=" + str4 + ", trackLengthSeconds=" + i4 + ", isPlaying=" + z3 + ")";
    }
}
