package com.arlosoft.macrodroid.videos.data;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VideoInfo.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class VideoInfo {
    public static final int $stable = 0;
    @NotNull
    private final String description;
    @NotNull
    private final String image;
    private final boolean isOfficial;
    @NotNull
    private final String title;
    @NotNull
    private final String url;
    @NotNull
    private final String user;

    public VideoInfo(@NotNull String user, @NotNull String url, @NotNull String title, @NotNull String description, boolean z3, @NotNull String image) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(image, "image");
        this.user = user;
        this.url = url;
        this.title = title;
        this.description = description;
        this.isOfficial = z3;
        this.image = image;
    }

    public static /* synthetic */ VideoInfo copy$default(VideoInfo videoInfo, String str, String str2, String str3, String str4, boolean z3, String str5, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = videoInfo.user;
        }
        if ((i4 & 2) != 0) {
            str2 = videoInfo.url;
        }
        String str6 = str2;
        if ((i4 & 4) != 0) {
            str3 = videoInfo.title;
        }
        String str7 = str3;
        if ((i4 & 8) != 0) {
            str4 = videoInfo.description;
        }
        String str8 = str4;
        if ((i4 & 16) != 0) {
            z3 = videoInfo.isOfficial;
        }
        boolean z4 = z3;
        if ((i4 & 32) != 0) {
            str5 = videoInfo.image;
        }
        return videoInfo.copy(str, str6, str7, str8, z4, str5);
    }

    @NotNull
    public final String component1() {
        return this.user;
    }

    @NotNull
    public final String component2() {
        return this.url;
    }

    @NotNull
    public final String component3() {
        return this.title;
    }

    @NotNull
    public final String component4() {
        return this.description;
    }

    public final boolean component5() {
        return this.isOfficial;
    }

    @NotNull
    public final String component6() {
        return this.image;
    }

    @NotNull
    public final VideoInfo copy(@NotNull String user, @NotNull String url, @NotNull String title, @NotNull String description, boolean z3, @NotNull String image) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(image, "image");
        return new VideoInfo(user, url, title, description, z3, image);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoInfo)) {
            return false;
        }
        VideoInfo videoInfo = (VideoInfo) obj;
        if (Intrinsics.areEqual(this.user, videoInfo.user) && Intrinsics.areEqual(this.url, videoInfo.url) && Intrinsics.areEqual(this.title, videoInfo.title) && Intrinsics.areEqual(this.description, videoInfo.description) && this.isOfficial == videoInfo.isOfficial && Intrinsics.areEqual(this.image, videoInfo.image)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getImage() {
        return this.image;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final String getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.user.hashCode() * 31) + this.url.hashCode()) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31;
        boolean z3 = this.isOfficial;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        return ((hashCode + i4) * 31) + this.image.hashCode();
    }

    public final boolean isOfficial() {
        return this.isOfficial;
    }

    @NotNull
    public String toString() {
        String str = this.user;
        String str2 = this.url;
        String str3 = this.title;
        String str4 = this.description;
        boolean z3 = this.isOfficial;
        String str5 = this.image;
        return "VideoInfo(user=" + str + ", url=" + str2 + ", title=" + str3 + ", description=" + str4 + ", isOfficial=" + z3 + ", image=" + str5 + ")";
    }
}
