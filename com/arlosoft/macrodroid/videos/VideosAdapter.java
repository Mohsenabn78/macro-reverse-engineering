package com.arlosoft.macrodroid.videos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.databinding.ViewVideosEntryBinding;
import com.arlosoft.macrodroid.videos.VideosAdapter;
import com.arlosoft.macrodroid.videos.data.VideoInfo;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.card.MaterialCardView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: VideosAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class VideosAdapter extends RecyclerView.Adapter<VideoViewHolder> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List<VideoInfo> f16427a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final VideoClickedListener f16428b;

    /* compiled from: VideosAdapter.kt */
    @StabilityInferred(parameters = 0)
    @SourceDebugExtension({"SMAP\nVideosAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VideosAdapter.kt\ncom/arlosoft/macrodroid/videos/VideosAdapter$VideoViewHolder\n+ 2 Click.kt\nsplitties/views/ClickKt\n*L\n1#1,52:1\n16#2:53\n*S KotlinDebug\n*F\n+ 1 VideosAdapter.kt\ncom/arlosoft/macrodroid/videos/VideosAdapter$VideoViewHolder\n*L\n23#1:53\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class VideoViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final ViewVideosEntryBinding f16429a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final VideoClickedListener f16430b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VideoViewHolder(@NotNull ViewVideosEntryBinding binding, @NotNull VideoClickedListener videoClickedListener) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(videoClickedListener, "videoClickedListener");
            this.f16429a = binding;
            this.f16430b = videoClickedListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(VideoViewHolder this$0, VideoInfo video, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(video, "$video");
            this$0.f16430b.onVideoClicked(video);
        }

        public final void bind(@NotNull final VideoInfo video) {
            Intrinsics.checkNotNullParameter(video, "video");
            MaterialCardView materialCardView = this.f16429a.container;
            Intrinsics.checkNotNullExpressionValue(materialCardView, "binding.container");
            materialCardView.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.videos.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideosAdapter.VideoViewHolder.b(VideosAdapter.VideoViewHolder.this, video, view);
                }
            });
            this.f16429a.title.setText(video.getTitle());
            Glide.with(this.f16429a.image.getContext()).m4161load(video.getImage()).apply((BaseRequestOptions<?>) new RequestOptions().centerCrop()).into(this.f16429a.image);
        }
    }

    public VideosAdapter(@NotNull List<VideoInfo> videos, @NotNull VideoClickedListener videoClickedListener) {
        Intrinsics.checkNotNullParameter(videos, "videos");
        Intrinsics.checkNotNullParameter(videoClickedListener, "videoClickedListener");
        this.f16427a = videos;
        this.f16428b = videoClickedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f16427a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull VideoViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.f16427a.get(i4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public VideoViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewVideosEntryBinding inflate = ViewVideosEntryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new VideoViewHolder(inflate, this.f16428b);
    }
}
