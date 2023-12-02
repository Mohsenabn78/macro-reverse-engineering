package com.arlosoft.macrodroid.plugins.comments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.paging.DataSource;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.comments.CommentsAdapter;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.databinding.ActivityPluginCommentsBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.plugins.comments.PluginCommentsViewModel;
import com.arlosoft.macrodroid.plugins.data.PluginDetail;
import com.arlosoft.macrodroid.templatestore.common.LoadState;
import com.arlosoft.macrodroid.templatestore.model.Comment;
import com.arlosoft.macrodroid.templatestore.model.User;
import com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsActivity;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.snackbar.SnackbarAnimate;
import java.util.List;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PluginCommentsActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nPluginCommentsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PluginCommentsActivity.kt\ncom/arlosoft/macrodroid/plugins/comments/PluginCommentsActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,244:1\n262#2,2:245\n262#2,2:247\n262#2,2:249\n262#2,2:251\n262#2,2:253\n262#2,2:255\n262#2,2:257\n262#2,2:259\n262#2,2:261\n262#2,2:263\n262#2,2:265\n262#2,2:267\n262#2,2:269\n262#2,2:271\n262#2,2:273\n*S KotlinDebug\n*F\n+ 1 PluginCommentsActivity.kt\ncom/arlosoft/macrodroid/plugins/comments/PluginCommentsActivity\n*L\n110#1:245,2\n111#1:247,2\n114#1:249,2\n115#1:251,2\n145#1:253,2\n150#1:255,2\n154#1:257,2\n158#1:259,2\n170#1:261,2\n171#1:263,2\n173#1:265,2\n174#1:267,2\n179#1:269,2\n188#1:271,2\n221#1:273,2\n*E\n"})
/* loaded from: classes3.dex */
public final class PluginCommentsActivity extends MacroDroidDaggerBaseActivity {
    @NotNull
    public static final String EXTRA_PLUGIN_DETAIL = "plugin";

    /* renamed from: f  reason: collision with root package name */
    private LinearLayoutManager f13114f;

    /* renamed from: g  reason: collision with root package name */
    private CommentsAdapter f13115g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private AppCompatDialog f13116h;

    /* renamed from: i  reason: collision with root package name */
    private ActivityPluginCommentsBinding f13117i;
    @Inject
    public PremiumStatusHandler premiumStatusHandler;
    @Inject
    public ProfileImageProvider profileImageProvider;
    @Inject
    public UserProvider userProvider;
    @Inject
    public PluginCommentsViewModel viewModel;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: PluginCommentsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent createIntent(@NotNull Context context, @NotNull PluginDetail pluginDetail) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(pluginDetail, "pluginDetail");
            Intent intent = new Intent(context, PluginCommentsActivity.class);
            intent.putExtra(PluginCommentsActivity.EXTRA_PLUGIN_DETAIL, pluginDetail);
            return intent;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginCommentsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Observer<LoadState> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(LoadState it) {
            PluginCommentsActivity pluginCommentsActivity = PluginCommentsActivity.this;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            pluginCommentsActivity.r(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginCommentsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class b implements Observer<PagedList<Comment>> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(PagedList<Comment> pagedList) {
            CommentsAdapter commentsAdapter = PluginCommentsActivity.this.f13115g;
            if (commentsAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                commentsAdapter = null;
            }
            commentsAdapter.submitList(pagedList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginCommentsActivity.kt */
    @SourceDebugExtension({"SMAP\nPluginCommentsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PluginCommentsActivity.kt\ncom/arlosoft/macrodroid/plugins/comments/PluginCommentsActivity$configureViewModelObservers$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,244:1\n1#2:245\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class c implements Observer<PluginCommentsViewModel.UiState> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(@Nullable PluginCommentsViewModel.UiState uiState) {
            if (uiState != null) {
                PluginCommentsActivity.this.o(uiState);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginCommentsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class d extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        d(Continuation<? super d> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new d(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                PluginCommentsActivity.this.showSendingComment();
                PluginCommentsActivity.this.setCommentEnabledState(false);
                PluginCommentsViewModel viewModel = PluginCommentsActivity.this.getViewModel();
                ActivityPluginCommentsBinding activityPluginCommentsBinding = PluginCommentsActivity.this.f13117i;
                if (activityPluginCommentsBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityPluginCommentsBinding = null;
                }
                viewModel.sendComment(String.valueOf(activityPluginCommentsBinding.commentText.getText()));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginCommentsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class e extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        e(Continuation<? super e> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new e(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CommentsAdapter commentsAdapter = PluginCommentsActivity.this.f13115g;
                if (commentsAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    commentsAdapter = null;
                }
                commentsAdapter.notifyDataSetChanged();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginCommentsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class f extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        f(Continuation<? super f> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new f(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginCommentsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class g extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        g(Continuation<? super g> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new g(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Intent intent = new Intent();
                intent.putExtra(TemplateCommentsActivity.EXTRA_SIGN_IN, true);
                PluginCommentsActivity.this.setResult(-1, intent);
                PluginCommentsActivity.this.finish();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: PluginCommentsActivity.kt */
    /* loaded from: classes3.dex */
    static final class h extends Lambda implements Function1<Comment, Unit> {
        h() {
            super(1);
        }

        public final void a(@NotNull Comment it) {
            Intrinsics.checkNotNullParameter(it, "it");
            PluginCommentsActivity.this.showCommentOptions(it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Comment comment) {
            a(comment);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: PluginCommentsActivity.kt */
    /* loaded from: classes3.dex */
    static final class i extends Lambda implements Function1<Comment, Unit> {

        /* renamed from: d  reason: collision with root package name */
        public static final i f13121d = new i();

        i() {
            super(1);
        }

        public final void a(@NotNull Comment it) {
            Intrinsics.checkNotNullParameter(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Comment comment) {
            a(comment);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: PluginCommentsActivity.kt */
    /* loaded from: classes3.dex */
    static final class j extends Lambda implements Function2<Comment, Boolean, Unit> {

        /* renamed from: d  reason: collision with root package name */
        public static final j f13122d = new j();

        j() {
            super(2);
        }

        public final void a(@NotNull Comment comment, boolean z3) {
            Intrinsics.checkNotNullParameter(comment, "<anonymous parameter 0>");
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: invoke */
        public /* bridge */ /* synthetic */ Unit mo1invoke(Comment comment, Boolean bool) {
            a(comment, bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginCommentsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class k extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Comment $comment;
        final /* synthetic */ EditText $commentText;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(Comment comment, EditText editText, Continuation<? super k> continuation) {
            super(3, continuation);
            this.$comment = comment;
            this.$commentText = editText;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new k(this.$comment, this.$commentText, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Editable editable;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                PluginCommentsActivity.this.setDialogCommentEnabledState(false);
                PluginCommentsViewModel viewModel = PluginCommentsActivity.this.getViewModel();
                Comment comment = this.$comment;
                EditText editText = this.$commentText;
                if (editText != null) {
                    editable = editText.getText();
                } else {
                    editable = null;
                }
                viewModel.updateComment(comment, String.valueOf(editable));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void n() {
        getViewModel().getLoadState().observe(this, new a());
        getViewModel().getCommentsList().observe(this, new b());
        getViewModel().getUiState().observe(this, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(PluginCommentsViewModel.UiState uiState) {
        DataSource<?, Comment> dataSource;
        ActivityPluginCommentsBinding activityPluginCommentsBinding = null;
        if (uiState instanceof PluginCommentsViewModel.UiState.CommentUploaded) {
            ActivityPluginCommentsBinding activityPluginCommentsBinding2 = this.f13117i;
            if (activityPluginCommentsBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityPluginCommentsBinding2 = null;
            }
            activityPluginCommentsBinding2.commentText.setText("");
            setCommentEnabledState(true);
            ActivityPluginCommentsBinding activityPluginCommentsBinding3 = this.f13117i;
            if (activityPluginCommentsBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityPluginCommentsBinding = activityPluginCommentsBinding3;
            }
            LinearLayout linearLayout = activityPluginCommentsBinding.uploadingLayout;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.uploadingLayout");
            linearLayout.setVisibility(8);
            return;
        }
        boolean z3 = uiState instanceof PluginCommentsViewModel.UiState.CommentUploadFailed;
        int i4 = R.string.not_allowed_to_post_comment;
        if (z3) {
            if (!((PluginCommentsViewModel.UiState.CommentUploadFailed) uiState).getNotAllowed()) {
                i4 = R.string.upload_failed;
            }
            String string = getString(i4);
            Intrinsics.checkNotNullExpressionValue(string, "getString(if (uiState.no…e R.string.upload_failed)");
            t(string);
            setCommentEnabledState(true);
            ActivityPluginCommentsBinding activityPluginCommentsBinding4 = this.f13117i;
            if (activityPluginCommentsBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityPluginCommentsBinding = activityPluginCommentsBinding4;
            }
            LinearLayout linearLayout2 = activityPluginCommentsBinding.uploadingLayout;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.uploadingLayout");
            linearLayout2.setVisibility(8);
        } else if (uiState instanceof PluginCommentsViewModel.UiState.CommentUpdated) {
            CommentsAdapter commentsAdapter = this.f13115g;
            if (commentsAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                commentsAdapter = null;
            }
            PagedList<Comment> currentList = commentsAdapter.getCurrentList();
            if (currentList != null && (dataSource = currentList.getDataSource()) != null) {
                dataSource.invalidate();
            }
            ActivityPluginCommentsBinding activityPluginCommentsBinding5 = this.f13117i;
            if (activityPluginCommentsBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityPluginCommentsBinding = activityPluginCommentsBinding5;
            }
            LinearLayout linearLayout3 = activityPluginCommentsBinding.uploadingLayout;
            Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.uploadingLayout");
            linearLayout3.setVisibility(8);
            AppCompatDialog appCompatDialog = this.f13116h;
            if (appCompatDialog != null) {
                appCompatDialog.dismiss();
            }
        } else if (uiState instanceof PluginCommentsViewModel.UiState.CommentUpdateFailed) {
            ActivityPluginCommentsBinding activityPluginCommentsBinding6 = this.f13117i;
            if (activityPluginCommentsBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityPluginCommentsBinding = activityPluginCommentsBinding6;
            }
            LinearLayout linearLayout4 = activityPluginCommentsBinding.uploadingLayout;
            Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.uploadingLayout");
            linearLayout4.setVisibility(8);
            setDialogCommentEnabledState(true);
            if (!((PluginCommentsViewModel.UiState.CommentUpdateFailed) uiState).getNotAllowed()) {
                i4 = R.string.upload_failed;
            }
            String string2 = getString(i4);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(if (uiState.no…e R.string.upload_failed)");
            t(string2);
        } else if (uiState instanceof PluginCommentsViewModel.UiState.DeleteFailed) {
            String string3 = getString(R.string.delete_failed);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.delete_failed)");
            t(string3);
        }
    }

    private final void p(PluginDetail pluginDetail) {
        ActivityPluginCommentsBinding activityPluginCommentsBinding = this.f13117i;
        ActivityPluginCommentsBinding activityPluginCommentsBinding2 = null;
        if (activityPluginCommentsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginCommentsBinding = null;
        }
        activityPluginCommentsBinding.macroNameText.setText(pluginDetail.getName());
        RequestBuilder<Drawable> apply = Glide.with((FragmentActivity) this).m4161load(pluginDetail.getIconUrl()).apply((BaseRequestOptions<?>) new RequestOptions().fitCenter());
        ActivityPluginCommentsBinding activityPluginCommentsBinding3 = this.f13117i;
        if (activityPluginCommentsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginCommentsBinding3 = null;
        }
        apply.into(activityPluginCommentsBinding3.pluginIcon);
        ActivityPluginCommentsBinding activityPluginCommentsBinding4 = this.f13117i;
        if (activityPluginCommentsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginCommentsBinding4 = null;
        }
        activityPluginCommentsBinding4.developerName.setText(pluginDetail.getDeveloperName());
        ActivityPluginCommentsBinding activityPluginCommentsBinding5 = this.f13117i;
        if (activityPluginCommentsBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginCommentsBinding5 = null;
        }
        ImageView imageView = activityPluginCommentsBinding5.sendCommentButton;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.sendCommentButton");
        ViewExtensionsKt.onClick$default(imageView, null, new d(null), 1, null);
        ActivityPluginCommentsBinding activityPluginCommentsBinding6 = this.f13117i;
        if (activityPluginCommentsBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginCommentsBinding6 = null;
        }
        AppCompatButton appCompatButton = activityPluginCommentsBinding6.retryButton;
        Intrinsics.checkNotNullExpressionValue(appCompatButton, "binding.retryButton");
        ViewExtensionsKt.onClick$default(appCompatButton, null, new e(null), 1, null);
        if (!getPremiumStatusHandler().getPremiumStatus().isPro()) {
            ActivityPluginCommentsBinding activityPluginCommentsBinding7 = this.f13117i;
            if (activityPluginCommentsBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityPluginCommentsBinding7 = null;
            }
            LinearLayout linearLayout = activityPluginCommentsBinding7.addCommentLayout;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.addCommentLayout");
            linearLayout.setVisibility(8);
            ActivityPluginCommentsBinding activityPluginCommentsBinding8 = this.f13117i;
            if (activityPluginCommentsBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityPluginCommentsBinding8 = null;
            }
            TextView textView = activityPluginCommentsBinding8.proVersionText;
            Intrinsics.checkNotNullExpressionValue(textView, "binding. proVersionText");
            textView.setVisibility(0);
            ActivityPluginCommentsBinding activityPluginCommentsBinding9 = this.f13117i;
            if (activityPluginCommentsBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityPluginCommentsBinding9 = null;
            }
            TextView textView2 = activityPluginCommentsBinding9.proVersionText;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.proVersionText");
            ViewExtensionsKt.onClick$default(textView2, null, new f(null), 1, null);
        } else if (getUserProvider().getUser().isGuest()) {
            ActivityPluginCommentsBinding activityPluginCommentsBinding10 = this.f13117i;
            if (activityPluginCommentsBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityPluginCommentsBinding10 = null;
            }
            LinearLayout linearLayout2 = activityPluginCommentsBinding10.addCommentLayout;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.addCommentLayout");
            linearLayout2.setVisibility(8);
            ActivityPluginCommentsBinding activityPluginCommentsBinding11 = this.f13117i;
            if (activityPluginCommentsBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityPluginCommentsBinding11 = null;
            }
            TextView textView3 = activityPluginCommentsBinding11.proVersionText;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.proVersionText");
            textView3.setVisibility(0);
            ActivityPluginCommentsBinding activityPluginCommentsBinding12 = this.f13117i;
            if (activityPluginCommentsBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityPluginCommentsBinding12 = null;
            }
            TextView textView4 = activityPluginCommentsBinding12.proVersionText;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.proVersionText");
            ViewExtensionsKt.onClick$default(textView4, null, new g(null), 1, null);
            ActivityPluginCommentsBinding activityPluginCommentsBinding13 = this.f13117i;
            if (activityPluginCommentsBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityPluginCommentsBinding2 = activityPluginCommentsBinding13;
            }
            activityPluginCommentsBinding2.proVersionText.setText(getString(R.string.comments_signed_in_users_only));
        }
    }

    private final void q(Comment comment) {
        EditText editText;
        Window window;
        ImageView imageView;
        AppCompatDialog appCompatDialog = new AppCompatDialog(this, R.style.Theme_App_Dialog_Plugins_NoTitle);
        this.f13116h = appCompatDialog;
        appCompatDialog.setCancelable(false);
        AppCompatDialog appCompatDialog2 = this.f13116h;
        if (appCompatDialog2 != null) {
            appCompatDialog2.setContentView(R.layout.dialog_edit_comment);
        }
        AppCompatDialog appCompatDialog3 = this.f13116h;
        Window window2 = null;
        if (appCompatDialog3 != null) {
            editText = (EditText) appCompatDialog3.findViewById(R.id.commentText);
        } else {
            editText = null;
        }
        if (editText != null) {
            editText.setText(comment.getText());
        }
        if (editText != null) {
            Editable text = editText.getText();
            Intrinsics.checkNotNull(text);
            editText.setSelection(text.length());
        }
        AppCompatDialog appCompatDialog4 = this.f13116h;
        if (appCompatDialog4 != null && (imageView = (ImageView) appCompatDialog4.findViewById(R.id.updateCommentButton)) != null) {
            ViewExtensionsKt.onClick$default(imageView, null, new k(comment, editText, null), 1, null);
        }
        AppCompatDialog appCompatDialog5 = this.f13116h;
        if (appCompatDialog5 != null) {
            appCompatDialog5.setCancelable(true);
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        AppCompatDialog appCompatDialog6 = this.f13116h;
        if (appCompatDialog6 != null) {
            window = appCompatDialog6.getWindow();
        } else {
            window = null;
        }
        Intrinsics.checkNotNull(window);
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = Resources.getSystem().getDisplayMetrics().widthPixels - (getResources().getDimensionPixelSize(R.dimen.margin_medium) * 2);
        AppCompatDialog appCompatDialog7 = this.f13116h;
        if (appCompatDialog7 != null) {
            window2 = appCompatDialog7.getWindow();
        }
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(layoutParams);
        AppCompatDialog appCompatDialog8 = this.f13116h;
        if (appCompatDialog8 != null) {
            appCompatDialog8.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(LoadState loadState) {
        boolean z3;
        int i4 = 0;
        ActivityPluginCommentsBinding activityPluginCommentsBinding = null;
        if (loadState == LoadState.LOADING) {
            ActivityPluginCommentsBinding activityPluginCommentsBinding2 = this.f13117i;
            if (activityPluginCommentsBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityPluginCommentsBinding2 = null;
            }
            LottieAnimationView lottieAnimationView = activityPluginCommentsBinding2.loadingView;
            Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "binding.loadingView");
            lottieAnimationView.setVisibility(0);
            ActivityPluginCommentsBinding activityPluginCommentsBinding3 = this.f13117i;
            if (activityPluginCommentsBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityPluginCommentsBinding = activityPluginCommentsBinding3;
            }
            TextView textView = activityPluginCommentsBinding.noCommentsLabel;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.noCommentsLabel");
            textView.setVisibility(8);
            return;
        }
        ActivityPluginCommentsBinding activityPluginCommentsBinding4 = this.f13117i;
        if (activityPluginCommentsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginCommentsBinding4 = null;
        }
        LottieAnimationView lottieAnimationView2 = activityPluginCommentsBinding4.loadingView;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView2, "binding.loadingView");
        lottieAnimationView2.setVisibility(8);
        ActivityPluginCommentsBinding activityPluginCommentsBinding5 = this.f13117i;
        if (activityPluginCommentsBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityPluginCommentsBinding = activityPluginCommentsBinding5;
        }
        TextView textView2 = activityPluginCommentsBinding.noCommentsLabel;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.noCommentsLabel");
        if (loadState == LoadState.EMPTY) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            i4 = 8;
        }
        textView2.setVisibility(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(String[] options, PluginCommentsActivity this$0, Comment comment, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(options, "$options");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(comment, "$comment");
        String str = options[i4];
        Intrinsics.checkNotNullExpressionValue(str, "options[index]");
        if (Intrinsics.areEqual(str, this$0.getString(R.string.edit_comment))) {
            this$0.q(comment);
        } else if (Intrinsics.areEqual(str, this$0.getString(R.string.delete))) {
            this$0.getViewModel().deleteComment(comment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCommentEnabledState(boolean z3) {
        float f4;
        ActivityPluginCommentsBinding activityPluginCommentsBinding = this.f13117i;
        ActivityPluginCommentsBinding activityPluginCommentsBinding2 = null;
        if (activityPluginCommentsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginCommentsBinding = null;
        }
        activityPluginCommentsBinding.commentText.setEnabled(z3);
        ActivityPluginCommentsBinding activityPluginCommentsBinding3 = this.f13117i;
        if (activityPluginCommentsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginCommentsBinding3 = null;
        }
        AppCompatEditText appCompatEditText = activityPluginCommentsBinding3.commentText;
        float f5 = 1.0f;
        if (z3) {
            f4 = 1.0f;
        } else {
            f4 = 0.5f;
        }
        appCompatEditText.setAlpha(f4);
        ActivityPluginCommentsBinding activityPluginCommentsBinding4 = this.f13117i;
        if (activityPluginCommentsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginCommentsBinding4 = null;
        }
        activityPluginCommentsBinding4.sendCommentButton.setEnabled(z3);
        ActivityPluginCommentsBinding activityPluginCommentsBinding5 = this.f13117i;
        if (activityPluginCommentsBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityPluginCommentsBinding2 = activityPluginCommentsBinding5;
        }
        ImageView imageView = activityPluginCommentsBinding2.sendCommentButton;
        if (!z3) {
            f5 = 0.5f;
        }
        imageView.setAlpha(f5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDialogCommentEnabledState(boolean z3) {
        View view;
        View view2;
        float f4;
        int i4;
        AppCompatDialog appCompatDialog = this.f13116h;
        View view3 = null;
        if (appCompatDialog != null) {
            view = appCompatDialog.findViewById(R.id.commentText);
        } else {
            view = null;
        }
        AppCompatDialog appCompatDialog2 = this.f13116h;
        if (appCompatDialog2 != null) {
            view2 = appCompatDialog2.findViewById(R.id.updateCommentButton);
        } else {
            view2 = null;
        }
        AppCompatDialog appCompatDialog3 = this.f13116h;
        if (appCompatDialog3 != null) {
            view3 = appCompatDialog3.findViewById(R.id.uploadingLayout);
        }
        if (view3 != null) {
            if (!z3) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            view3.setVisibility(i4);
        }
        if (view != null) {
            view.setEnabled(z3);
        }
        float f5 = 1.0f;
        if (view != null) {
            if (z3) {
                f4 = 1.0f;
            } else {
                f4 = 0.5f;
            }
            view.setAlpha(f4);
        }
        if (view2 != null) {
            view2.setEnabled(z3);
        }
        if (view2 != null) {
            if (!z3) {
                f5 = 0.5f;
            }
            view2.setAlpha(f5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCommentOptions(final Comment comment) {
        final String[] strArr = {getString(R.string.edit_comment), getString(R.string.delete)};
        new AlertDialog.Builder(this, R.style.Theme_App_Dialog_Template).setTitle(R.string.select_option).setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.plugins.comments.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PluginCommentsActivity.s(strArr, this, comment, dialogInterface, i4);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSendingComment() {
        ActivityPluginCommentsBinding activityPluginCommentsBinding = this.f13117i;
        ActivityPluginCommentsBinding activityPluginCommentsBinding2 = null;
        if (activityPluginCommentsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginCommentsBinding = null;
        }
        AppCompatEditText appCompatEditText = activityPluginCommentsBinding.commentText;
        Intrinsics.checkNotNullExpressionValue(appCompatEditText, "binding.commentText");
        ViewExtensionsKt.hideKeyboard(appCompatEditText);
        ActivityPluginCommentsBinding activityPluginCommentsBinding3 = this.f13117i;
        if (activityPluginCommentsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityPluginCommentsBinding2 = activityPluginCommentsBinding3;
        }
        LinearLayout linearLayout = activityPluginCommentsBinding2.uploadingLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.uploadingLayout");
        linearLayout.setVisibility(0);
    }

    private final void t(String str) {
        ActivityPluginCommentsBinding activityPluginCommentsBinding = this.f13117i;
        if (activityPluginCommentsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginCommentsBinding = null;
        }
        LinearLayout linearLayout = activityPluginCommentsBinding.uploadingLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.uploadingLayout");
        linearLayout.setVisibility(8);
        SnackbarAnimate make = SnackbarAnimate.make(findViewById(R.id.coordinatorLayout), str, 0);
        Intrinsics.checkNotNullExpressionValue(make, "make(findViewById(R.id.c…ckbarAnimate.LENGTH_LONG)");
        make.getView().setBackgroundResource(R.color.snack_bar_error);
        View findViewById = make.getView().findViewById(R.id.snackbar_text);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setTextColor(-1);
        make.show();
    }

    @NotNull
    public final PremiumStatusHandler getPremiumStatusHandler() {
        PremiumStatusHandler premiumStatusHandler = this.premiumStatusHandler;
        if (premiumStatusHandler != null) {
            return premiumStatusHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("premiumStatusHandler");
        return null;
    }

    @NotNull
    public final ProfileImageProvider getProfileImageProvider() {
        ProfileImageProvider profileImageProvider = this.profileImageProvider;
        if (profileImageProvider != null) {
            return profileImageProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("profileImageProvider");
        return null;
    }

    @NotNull
    public final UserProvider getUserProvider() {
        UserProvider userProvider = this.userProvider;
        if (userProvider != null) {
            return userProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userProvider");
        return null;
    }

    @NotNull
    public final PluginCommentsViewModel getViewModel() {
        PluginCommentsViewModel pluginCommentsViewModel = this.viewModel;
        if (pluginCommentsViewModel != null) {
            return pluginCommentsViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
        overridePendingTransition(0, R.anim.out_to_bottom);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        List emptyList;
        super.onCreate(bundle);
        ActivityPluginCommentsBinding inflate = ActivityPluginCommentsBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f13117i = inflate;
        LinearLayoutManager linearLayoutManager = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        Parcelable parcelableExtra = getIntent().getParcelableExtra(EXTRA_PLUGIN_DETAIL);
        Intrinsics.checkNotNull(parcelableExtra);
        PluginDetail pluginDetail = (PluginDetail) parcelableExtra;
        getViewModel().initialiseWithPluginId(pluginDetail);
        n();
        h hVar = new h();
        i iVar = i.f13121d;
        j jVar = j.f13122d;
        User user = getUserProvider().getUser();
        ProfileImageProvider profileImageProvider = getProfileImageProvider();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.f13115g = new CommentsAdapter(pluginDetail, hVar, iVar, jVar, user, profileImageProvider, emptyList);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        this.f13114f = linearLayoutManager2;
        linearLayoutManager2.setReverseLayout(true);
        LinearLayoutManager linearLayoutManager3 = this.f13114f;
        if (linearLayoutManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            linearLayoutManager3 = null;
        }
        linearLayoutManager3.setStackFromEnd(true);
        ActivityPluginCommentsBinding activityPluginCommentsBinding = this.f13117i;
        if (activityPluginCommentsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginCommentsBinding = null;
        }
        RecyclerView recyclerView = activityPluginCommentsBinding.recyclerView;
        CommentsAdapter commentsAdapter = this.f13115g;
        if (commentsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            commentsAdapter = null;
        }
        recyclerView.setAdapter(commentsAdapter);
        ActivityPluginCommentsBinding activityPluginCommentsBinding2 = this.f13117i;
        if (activityPluginCommentsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginCommentsBinding2 = null;
        }
        RecyclerView recyclerView2 = activityPluginCommentsBinding2.recyclerView;
        LinearLayoutManager linearLayoutManager4 = this.f13114f;
        if (linearLayoutManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        } else {
            linearLayoutManager = linearLayoutManager4;
        }
        recyclerView2.setLayoutManager(linearLayoutManager);
        p(pluginDetail);
    }

    public final void setPremiumStatusHandler(@NotNull PremiumStatusHandler premiumStatusHandler) {
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "<set-?>");
        this.premiumStatusHandler = premiumStatusHandler;
    }

    public final void setProfileImageProvider(@NotNull ProfileImageProvider profileImageProvider) {
        Intrinsics.checkNotNullParameter(profileImageProvider, "<set-?>");
        this.profileImageProvider = profileImageProvider;
    }

    public final void setUserProvider(@NotNull UserProvider userProvider) {
        Intrinsics.checkNotNullParameter(userProvider, "<set-?>");
        this.userProvider = userProvider;
    }

    public final void setViewModel(@NotNull PluginCommentsViewModel pluginCommentsViewModel) {
        Intrinsics.checkNotNullParameter(pluginCommentsViewModel, "<set-?>");
        this.viewModel = pluginCommentsViewModel;
    }
}
