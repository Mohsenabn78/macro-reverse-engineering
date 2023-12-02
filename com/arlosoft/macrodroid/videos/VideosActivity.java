package com.arlosoft.macrodroid.videos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.AppCompatButton;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.databinding.ActivityVideosBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.videos.data.VideosData;
import javax.inject.Inject;
import kotlin.Function;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VideosActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nVideosActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VideosActivity.kt\ncom/arlosoft/macrodroid/videos/VideosActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,70:1\n262#2,2:71\n262#2,2:73\n262#2,2:75\n*S KotlinDebug\n*F\n+ 1 VideosActivity.kt\ncom/arlosoft/macrodroid/videos/VideosActivity\n*L\n53#1:71,2\n57#1:73,2\n59#1:75,2\n*E\n"})
/* loaded from: classes3.dex */
public final class VideosActivity extends MacroDroidDaggerBaseActivity {

    /* renamed from: f  reason: collision with root package name */
    private ActivityVideosBinding f16423f;
    @Inject
    public VideosViewModel viewModel;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: VideosActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void launch(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            activity.startActivity(new Intent(activity, VideosActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideosActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<VideosData, Unit> {
        a() {
            super(1);
        }

        public final void a(@Nullable VideosData videosData) {
            VideosActivity.this.n(videosData);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(VideosData videosData) {
            a(videosData);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: VideosActivity.kt */
    @SourceDebugExtension({"SMAP\nVideosActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VideosActivity.kt\ncom/arlosoft/macrodroid/videos/VideosActivity$onCreate$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,70:1\n262#2,2:71\n262#2,2:73\n*S KotlinDebug\n*F\n+ 1 VideosActivity.kt\ncom/arlosoft/macrodroid/videos/VideosActivity$onCreate$1\n*L\n39#1:71,2\n40#1:73,2\n*E\n"})
    /* loaded from: classes3.dex */
    static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        b(Continuation<? super b> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActivityVideosBinding activityVideosBinding = VideosActivity.this.f16423f;
                ActivityVideosBinding activityVideosBinding2 = null;
                if (activityVideosBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityVideosBinding = null;
                }
                FrameLayout frameLayout = activityVideosBinding.loadingView;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingView");
                frameLayout.setVisibility(0);
                ActivityVideosBinding activityVideosBinding3 = VideosActivity.this.f16423f;
                if (activityVideosBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityVideosBinding2 = activityVideosBinding3;
                }
                FrameLayout frameLayout2 = activityVideosBinding2.errorView;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.errorView");
                frameLayout2.setVisibility(8);
                VideosActivity.this.getViewModel().requestVideoData();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideosActivity.kt */
    /* loaded from: classes3.dex */
    public static final class c implements Observer, FunctionAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f16424a;

        c(Function1 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            this.f16424a = function;
        }

        public final boolean equals(@Nullable Object obj) {
            if (!(obj instanceof Observer) || !(obj instanceof FunctionAdapter)) {
                return false;
            }
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f16424a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f16424a.invoke(obj);
        }
    }

    private final void m() {
        getViewModel().getVideos().observe(this, new c(new a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(VideosData videosData) {
        ActivityVideosBinding activityVideosBinding = this.f16423f;
        ActivityVideosBinding activityVideosBinding2 = null;
        if (activityVideosBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVideosBinding = null;
        }
        FrameLayout frameLayout = activityVideosBinding.loadingView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingView");
        frameLayout.setVisibility(8);
        if (videosData != null) {
            ActivityVideosBinding activityVideosBinding3 = this.f16423f;
            if (activityVideosBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityVideosBinding3 = null;
            }
            activityVideosBinding3.videoEntries.setLayoutManager(new GridLayoutManager(this, 2));
            ActivityVideosBinding activityVideosBinding4 = this.f16423f;
            if (activityVideosBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityVideosBinding4 = null;
            }
            activityVideosBinding4.videoEntries.setAdapter(new VideosAdapter(videosData.getVideoList(), getViewModel()));
            ActivityVideosBinding activityVideosBinding5 = this.f16423f;
            if (activityVideosBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityVideosBinding2 = activityVideosBinding5;
            }
            RecyclerView recyclerView = activityVideosBinding2.videoEntries;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.videoEntries");
            recyclerView.setVisibility(0);
            return;
        }
        ActivityVideosBinding activityVideosBinding6 = this.f16423f;
        if (activityVideosBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityVideosBinding2 = activityVideosBinding6;
        }
        FrameLayout frameLayout2 = activityVideosBinding2.errorView;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.errorView");
        frameLayout2.setVisibility(0);
    }

    @NotNull
    public final VideosViewModel getViewModel() {
        VideosViewModel videosViewModel = this.viewModel;
        if (videosViewModel != null) {
            return videosViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityVideosBinding inflate = ActivityVideosBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f16423f = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        ActivityVideosBinding activityVideosBinding = this.f16423f;
        if (activityVideosBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVideosBinding = null;
        }
        setSupportActionBar(activityVideosBinding.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setTitle(R.string.tile_videos_title);
        }
        ActivityVideosBinding activityVideosBinding2 = this.f16423f;
        if (activityVideosBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVideosBinding2 = null;
        }
        AppCompatButton appCompatButton = activityVideosBinding2.retryButton;
        Intrinsics.checkNotNullExpressionValue(appCompatButton, "binding.retryButton");
        ViewExtensionsKt.onClick$default(appCompatButton, null, new b(null), 1, null);
        m();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == 16908332) {
            finish();
            return true;
        }
        return true;
    }

    public final void setViewModel(@NotNull VideosViewModel videosViewModel) {
        Intrinsics.checkNotNullParameter(videosViewModel, "<set-?>");
        this.viewModel = videosViewModel;
    }
}
