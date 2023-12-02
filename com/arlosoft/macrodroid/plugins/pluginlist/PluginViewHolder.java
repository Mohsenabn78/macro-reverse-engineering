package com.arlosoft.macrodroid.plugins.pluginlist;

import android.text.format.DateUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.text.util.LinkifyCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.avatar.views.AvatarView;
import com.arlosoft.macrodroid.databinding.ViewPluginDetailsBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.plugins.data.PluginDetail;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.firestore.util.ExponentialBackoff;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.varunest.sparkbutton.SparkButton2;
import com.varunest.sparkbutton.SparkEventListener;
import java.util.Calendar;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PluginListAdapter.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nPluginListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PluginListAdapter.kt\ncom/arlosoft/macrodroid/plugins/pluginlist/PluginViewHolder\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,114:1\n262#2,2:115\n262#2,2:117\n*S KotlinDebug\n*F\n+ 1 PluginListAdapter.kt\ncom/arlosoft/macrodroid/plugins/pluginlist/PluginViewHolder\n*L\n34#1:115,2\n36#1:117,2\n*E\n"})
/* loaded from: classes3.dex */
public final class PluginViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final ViewPluginDetailsBinding f13236a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final PluginListViewModel f13237b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final ProfileImageProvider f13238c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginListAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ PluginDetail $pluginDetail;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(PluginDetail pluginDetail, Continuation<? super a> continuation) {
            super(3, continuation);
            this.$pluginDetail = pluginDetail;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(this.$pluginDetail, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                PluginViewHolder.this.f13237b.onLoadCommentClicked(this.$pluginDetail);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginListAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ PluginDetail $pluginDetail;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(PluginDetail pluginDetail, Continuation<? super b> continuation) {
            super(3, continuation);
            this.$pluginDetail = pluginDetail;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(this.$pluginDetail, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                PluginViewHolder.this.f13237b.onOverflowClicked(this.$pluginDetail);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginViewHolder(@NotNull ViewPluginDetailsBinding binding, @NotNull PluginListViewModel viewModel, @NotNull ProfileImageProvider profileImageProvider) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(profileImageProvider, "profileImageProvider");
        this.f13236a = binding;
        this.f13237b = viewModel;
        this.f13238c = profileImageProvider;
    }

    public final void bind(@NotNull final PluginDetail pluginDetail) {
        boolean z3;
        boolean contains$default;
        String str;
        Intrinsics.checkNotNullParameter(pluginDetail, "pluginDetail");
        this.f13236a.pluginName.setText(pluginDetail.getName());
        String developerName = pluginDetail.getDeveloperName();
        if (developerName != null && developerName.length() != 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            TextView textView = this.f13236a.developerName;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.developerName");
            textView.setVisibility(8);
        } else {
            TextView textView2 = this.f13236a.developerName;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.developerName");
            textView2.setVisibility(0);
            this.f13236a.developerName.setText(pluginDetail.getDeveloperName());
        }
        this.f13236a.description.setText(pluginDetail.getDescription());
        this.f13236a.link.setText(pluginDetail.getDownloadLink());
        LinkifyCompat.addLinks(this.f13236a.link, 1);
        this.f13236a.starRating.setText(String.valueOf(pluginDetail.getStarCount()));
        this.f13236a.commentCount.setText(String.valueOf(pluginDetail.getCommentCount()));
        FrameLayout frameLayout = this.f13236a.commentsButton;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.commentsButton");
        ViewExtensionsKt.onClick$default(frameLayout, null, new a(pluginDetail, null), 1, null);
        this.f13236a.usernameEdit.setText(pluginDetail.getUsername());
        this.f13236a.timeLabel.setText(String.valueOf(DateUtils.getRelativeTimeSpanString(pluginDetail.getTimestamp(), Calendar.getInstance().getTimeInMillis(), (long) ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS)));
        ProfileImageProvider profileImageProvider = this.f13238c;
        AvatarView avatarView = this.f13236a.avatarImage;
        Intrinsics.checkNotNullExpressionValue(avatarView, "binding.avatarImage");
        profileImageProvider.loadImageFromUrl(avatarView, pluginDetail.getUserImage(), pluginDetail.getUsername());
        ImageView imageView = this.f13236a.overflowButton;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.overflowButton");
        ViewExtensionsKt.onClick$default(imageView, null, new b(pluginDetail, null), 1, null);
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) pluginDetail.getIconUrl(), (CharSequence) RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) null);
        if (contains$default) {
            str = pluginDetail.getIconUrl();
        } else {
            str = "https://backend.macrodroid.com/profilepics/" + pluginDetail.getIconUrl();
        }
        Glide.with(this.f13236a.getRoot().getContext()).m4161load(str).apply((BaseRequestOptions<?>) new RequestOptions().fitCenter()).into(this.f13236a.pluginIcon);
        this.f13236a.starRating.setTag(Integer.valueOf(pluginDetail.getStarCount()));
        this.f13236a.starIcon.setChecked(pluginDetail.getStarred());
        SparkButton2 sparkButton2 = this.f13236a.starIcon;
        Intrinsics.checkNotNullExpressionValue(sparkButton2, "binding.starIcon");
        ViewExtensionsKt.expandTouchArea(sparkButton2, this.itemView.getContext().getResources().getDimensionPixelOffset(R.dimen.margin_small));
        this.f13236a.starIcon.setEventListener(new SparkEventListener() { // from class: com.arlosoft.macrodroid.plugins.pluginlist.PluginViewHolder$bind$3
            @Override // com.varunest.sparkbutton.SparkEventListener
            public void onEvent(@NotNull ImageView button, boolean z4) {
                ViewPluginDetailsBinding viewPluginDetailsBinding;
                ViewPluginDetailsBinding viewPluginDetailsBinding2;
                ViewPluginDetailsBinding viewPluginDetailsBinding3;
                ViewPluginDetailsBinding viewPluginDetailsBinding4;
                ViewPluginDetailsBinding viewPluginDetailsBinding5;
                Intrinsics.checkNotNullParameter(button, "button");
                PluginViewHolder.this.f13237b.starClicked(pluginDetail);
                viewPluginDetailsBinding = PluginViewHolder.this.f13236a;
                Object tag = viewPluginDetailsBinding.starRating.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
                int intValue = ((Integer) tag).intValue();
                if (z4) {
                    viewPluginDetailsBinding4 = PluginViewHolder.this.f13236a;
                    int i4 = intValue + 1;
                    viewPluginDetailsBinding4.starRating.setTag(Integer.valueOf(i4));
                    viewPluginDetailsBinding5 = PluginViewHolder.this.f13236a;
                    viewPluginDetailsBinding5.starRating.setText(String.valueOf(i4));
                    return;
                }
                viewPluginDetailsBinding2 = PluginViewHolder.this.f13236a;
                int i5 = intValue - 1;
                viewPluginDetailsBinding2.starRating.setTag(Integer.valueOf(i5));
                viewPluginDetailsBinding3 = PluginViewHolder.this.f13236a;
                viewPluginDetailsBinding3.starRating.setText(String.valueOf(i5));
            }

            @Override // com.varunest.sparkbutton.SparkEventListener
            public void onEventAnimationEnd(@Nullable ImageView imageView2, boolean z4) {
            }

            @Override // com.varunest.sparkbutton.SparkEventListener
            public void onEventAnimationStart(@Nullable ImageView imageView2, boolean z4) {
            }
        });
    }
}
