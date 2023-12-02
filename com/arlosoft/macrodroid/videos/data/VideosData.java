package com.arlosoft.macrodroid.videos.data;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VideosData.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class VideosData {
    public static final int $stable = 8;
    @NotNull
    private final List<VideoInfo> videoList;

    public VideosData(@NotNull List<VideoInfo> videoList) {
        Intrinsics.checkNotNullParameter(videoList, "videoList");
        this.videoList = videoList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VideosData copy$default(VideosData videosData, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = videosData.videoList;
        }
        return videosData.copy(list);
    }

    @NotNull
    public final List<VideoInfo> component1() {
        return this.videoList;
    }

    @NotNull
    public final VideosData copy(@NotNull List<VideoInfo> videoList) {
        Intrinsics.checkNotNullParameter(videoList, "videoList");
        return new VideosData(videoList);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof VideosData) && Intrinsics.areEqual(this.videoList, ((VideosData) obj).videoList)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<VideoInfo> getVideoList() {
        return this.videoList;
    }

    public int hashCode() {
        return this.videoList.hashCode();
    }

    @NotNull
    public String toString() {
        List<VideoInfo> list = this.videoList;
        return "VideosData(videoList=" + list + ")";
    }
}
