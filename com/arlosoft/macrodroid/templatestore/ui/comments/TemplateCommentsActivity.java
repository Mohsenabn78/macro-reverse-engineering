package com.arlosoft.macrodroid.templatestore.ui.comments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.paging.DataSource;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.avatar.views.AvatarView;
import com.arlosoft.macrodroid.comments.CommentsAdapter;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.database.room.BlockedUser;
import com.arlosoft.macrodroid.database.room.BlockedUserDao;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.databinding.ActivityTemplateCommentsBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.common.LoadState;
import com.arlosoft.macrodroid.templatestore.model.Comment;
import com.arlosoft.macrodroid.templatestore.model.MacroTemplate;
import com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsActivity;
import com.arlosoft.macrodroid.templatestore.ui.comments.data.CommentsViewModel;
import com.arlosoft.macrodroid.templatestore.ui.comments.presenter.TemplateCommentsPresenter;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.google.android.material.snackbar.SnackbarAnimate;
import java.util.List;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TemplateCommentsActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nTemplateCommentsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TemplateCommentsActivity.kt\ncom/arlosoft/macrodroid/templatestore/ui/comments/TemplateCommentsActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,351:1\n262#2,2:352\n262#2,2:354\n262#2,2:356\n262#2,2:358\n262#2,2:360\n262#2,2:362\n*S KotlinDebug\n*F\n+ 1 TemplateCommentsActivity.kt\ncom/arlosoft/macrodroid/templatestore/ui/comments/TemplateCommentsActivity\n*L\n142#1:352,2\n143#1:354,2\n244#1:356,2\n249#1:358,2\n253#1:360,2\n274#1:362,2\n*E\n"})
/* loaded from: classes3.dex */
public final class TemplateCommentsActivity extends MacroDroidDaggerBaseActivity implements TemplateCommentsViewContract {
    @NotNull
    public static final String EXTRA_CLEAR_UPDATE_SUBSCRIPTION_ID = "clear_update_subscription_id";
    @NotNull
    public static final String EXTRA_MACRO_ID = "macro_id";
    @NotNull
    public static final String EXTRA_SIGN_IN = "sign_in";
    public CommentsAdapter adapter;
    @Inject
    public TemplateStoreApi api;
    public CommentsViewModel commentsViewModel;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private AppCompatDialog f13733f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayoutManager f13734g;

    /* renamed from: h  reason: collision with root package name */
    private int f13735h = -1;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final TemplateCommentsActivity$dataObserver$1 f13736i = new RecyclerView.AdapterDataObserver() { // from class: com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsActivity$dataObserver$1
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i4, int i5) {
            if (i4 == 0) {
                LinearLayoutManager linearLayoutManager = TemplateCommentsActivity.this.f13734g;
                if (linearLayoutManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
                    linearLayoutManager = null;
                }
                linearLayoutManager.scrollToPositionWithOffset(0, 0);
            }
        }
    };

    /* renamed from: j  reason: collision with root package name */
    private ActivityTemplateCommentsBinding f13737j;
    public MacroTemplate macroTemplate;
    @Inject
    public PremiumStatusHandler premiumStatusHandler;
    @Inject
    public TemplateCommentsPresenter presenter;
    @Inject
    public ProfileImageProvider profileImageProvider;
    @Inject
    public MacroDroidRoomDatabase roomDatabase;
    @Inject
    public TemplateCommentsDataRepository templateCommentsDataRepository;
    @Inject
    public UserProvider userProvider;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: TemplateCommentsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent createIntent(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, TemplateCommentsActivity.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateCommentsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $idToClear;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i4, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$idToClear = i4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(this.$idToClear, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (TemplateCommentsActivity.this.getRoomDatabase().subscriptionUpdateItemDao().deleteSubscriptionUpdateItem(this.$idToClear, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: TemplateCommentsActivity.kt */
    /* loaded from: classes3.dex */
    static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Comment $comment;
        final /* synthetic */ EditText $commentText;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Comment comment, EditText editText, Continuation<? super b> continuation) {
            super(3, continuation);
            this.$comment = comment;
            this.$commentText = editText;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(this.$comment, this.$commentText, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Editable editable;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                TemplateCommentsPresenter presenter = TemplateCommentsActivity.this.getPresenter();
                Comment comment = this.$comment;
                EditText editText = this.$commentText;
                if (editText != null) {
                    editable = editText.getText();
                } else {
                    editable = null;
                }
                presenter.updateComment(comment, String.valueOf(editable));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateCommentsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TemplateCommentsActivity.kt */
        @SourceDebugExtension({"SMAP\nTemplateCommentsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TemplateCommentsActivity.kt\ncom/arlosoft/macrodroid/templatestore/ui/comments/TemplateCommentsActivity$initialiseMacroTemplate$1$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,351:1\n262#2,2:352\n262#2,2:354\n262#2,2:356\n262#2,2:358\n*S KotlinDebug\n*F\n+ 1 TemplateCommentsActivity.kt\ncom/arlosoft/macrodroid/templatestore/ui/comments/TemplateCommentsActivity$initialiseMacroTemplate$1$1\n*L\n201#1:352,2\n202#1:354,2\n205#1:356,2\n206#1:358,2\n*E\n"})
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<BlockedUser> $blockedUsers;
            int label;
            final /* synthetic */ TemplateCommentsActivity this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: TemplateCommentsActivity.kt */
            /* renamed from: com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsActivity$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public static final class C0116a extends Lambda implements Function1<Comment, Unit> {
                final /* synthetic */ TemplateCommentsActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0116a(TemplateCommentsActivity templateCommentsActivity) {
                    super(1);
                    this.this$0 = templateCommentsActivity;
                }

                public final void a(@NotNull Comment it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    this.this$0.getPresenter().onCommentEditClicked(it);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Comment comment) {
                    a(comment);
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: TemplateCommentsActivity.kt */
            /* loaded from: classes3.dex */
            public static final class b extends Lambda implements Function1<Comment, Unit> {
                final /* synthetic */ TemplateCommentsActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(TemplateCommentsActivity templateCommentsActivity) {
                    super(1);
                    this.this$0 = templateCommentsActivity;
                }

                public final void a(@NotNull Comment it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    this.this$0.getPresenter().onUserClicked(it);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Comment comment) {
                    a(comment);
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: TemplateCommentsActivity.kt */
            /* renamed from: com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsActivity$c$a$c  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public static final class C0117c extends Lambda implements Function2<Comment, Boolean, Unit> {
                final /* synthetic */ TemplateCommentsActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0117c(TemplateCommentsActivity templateCommentsActivity) {
                    super(2);
                    this.this$0 = templateCommentsActivity;
                }

                public final void a(@NotNull Comment comment, boolean z3) {
                    Intrinsics.checkNotNullParameter(comment, "comment");
                    this.this$0.s(comment, z3);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ Unit mo1invoke(Comment comment, Boolean bool) {
                    a(comment, bool.booleanValue());
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: TemplateCommentsActivity.kt */
            /* loaded from: classes3.dex */
            public static final class d implements Observer<PagedList<Comment>> {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ TemplateCommentsActivity f13738a;

                d(TemplateCommentsActivity templateCommentsActivity) {
                    this.f13738a = templateCommentsActivity;
                }

                @Override // androidx.lifecycle.Observer
                /* renamed from: a */
                public final void onChanged(@NotNull PagedList<Comment> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    this.f13738a.getAdapter().submitList(it);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: TemplateCommentsActivity.kt */
            @SourceDebugExtension({"SMAP\nTemplateCommentsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TemplateCommentsActivity.kt\ncom/arlosoft/macrodroid/templatestore/ui/comments/TemplateCommentsActivity$initialiseMacroTemplate$1$1$5\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,351:1\n262#2,2:352\n262#2,2:354\n262#2,2:356\n262#2,2:358\n*S KotlinDebug\n*F\n+ 1 TemplateCommentsActivity.kt\ncom/arlosoft/macrodroid/templatestore/ui/comments/TemplateCommentsActivity$initialiseMacroTemplate$1$1$5\n*L\n179#1:352,2\n180#1:354,2\n182#1:356,2\n183#1:358,2\n*E\n"})
            /* loaded from: classes3.dex */
            public static final class e implements Observer<LoadState> {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ TemplateCommentsActivity f13739a;

                e(TemplateCommentsActivity templateCommentsActivity) {
                    this.f13739a = templateCommentsActivity;
                }

                @Override // androidx.lifecycle.Observer
                /* renamed from: a */
                public final void onChanged(LoadState loadState) {
                    boolean z3;
                    int i4 = 0;
                    ActivityTemplateCommentsBinding activityTemplateCommentsBinding = null;
                    if (loadState == LoadState.LOADING) {
                        ActivityTemplateCommentsBinding activityTemplateCommentsBinding2 = this.f13739a.f13737j;
                        if (activityTemplateCommentsBinding2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            activityTemplateCommentsBinding2 = null;
                        }
                        LottieAnimationView lottieAnimationView = activityTemplateCommentsBinding2.loadingView;
                        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "binding.loadingView");
                        lottieAnimationView.setVisibility(0);
                        ActivityTemplateCommentsBinding activityTemplateCommentsBinding3 = this.f13739a.f13737j;
                        if (activityTemplateCommentsBinding3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            activityTemplateCommentsBinding = activityTemplateCommentsBinding3;
                        }
                        TextView textView = activityTemplateCommentsBinding.noCommentsLabel;
                        Intrinsics.checkNotNullExpressionValue(textView, "binding.noCommentsLabel");
                        textView.setVisibility(8);
                        return;
                    }
                    ActivityTemplateCommentsBinding activityTemplateCommentsBinding4 = this.f13739a.f13737j;
                    if (activityTemplateCommentsBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityTemplateCommentsBinding4 = null;
                    }
                    LottieAnimationView lottieAnimationView2 = activityTemplateCommentsBinding4.loadingView;
                    Intrinsics.checkNotNullExpressionValue(lottieAnimationView2, "binding.loadingView");
                    lottieAnimationView2.setVisibility(8);
                    ActivityTemplateCommentsBinding activityTemplateCommentsBinding5 = this.f13739a.f13737j;
                    if (activityTemplateCommentsBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityTemplateCommentsBinding = activityTemplateCommentsBinding5;
                    }
                    TextView textView2 = activityTemplateCommentsBinding.noCommentsLabel;
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
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: TemplateCommentsActivity.kt */
            /* loaded from: classes3.dex */
            public static final class f extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ TemplateCommentsActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                f(TemplateCommentsActivity templateCommentsActivity, Continuation<? super f> continuation) {
                    super(3, continuation);
                    this.this$0 = templateCommentsActivity;
                }

                @Override // kotlin.jvm.functions.Function3
                @Nullable
                /* renamed from: a */
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                    return new f(this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.this$0.getPresenter().onUpgradePressed();
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: TemplateCommentsActivity.kt */
            /* loaded from: classes3.dex */
            public static final class g extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ TemplateCommentsActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                g(TemplateCommentsActivity templateCommentsActivity, Continuation<? super g> continuation) {
                    super(3, continuation);
                    this.this$0 = templateCommentsActivity;
                }

                @Override // kotlin.jvm.functions.Function3
                @Nullable
                /* renamed from: a */
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                    return new g(this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        Settings.setTemplateStoreAccount(this.this$0, null);
                        Intent intent = new Intent();
                        intent.putExtra(TemplateCommentsActivity.EXTRA_SIGN_IN, true);
                        this.this$0.setResult(-1, intent);
                        this.this$0.finish();
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(TemplateCommentsActivity templateCommentsActivity, List<BlockedUser> list, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = templateCommentsActivity;
                this.$blockedUsers = list;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void b(TemplateCommentsActivity templateCommentsActivity, View view) {
                TemplateCommentsPresenter presenter = templateCommentsActivity.getPresenter();
                ActivityTemplateCommentsBinding activityTemplateCommentsBinding = templateCommentsActivity.f13737j;
                if (activityTemplateCommentsBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityTemplateCommentsBinding = null;
                }
                presenter.addComment(String.valueOf(activityTemplateCommentsBinding.commentText.getText()));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, this.$blockedUsers, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.setAdapter(new CommentsAdapter(this.this$0.getMacroTemplate(), new C0116a(this.this$0), new b(this.this$0), new C0117c(this.this$0), this.this$0.getUserProvider().getUser(), this.this$0.getProfileImageProvider(), this.$blockedUsers));
                    LiveData<PagedList<Comment>> commentsList = this.this$0.getCommentsViewModel().getCommentsList();
                    TemplateCommentsActivity templateCommentsActivity = this.this$0;
                    commentsList.observe(templateCommentsActivity, new d(templateCommentsActivity));
                    LiveData<LoadState> loadState = this.this$0.getCommentsViewModel().getLoadState();
                    TemplateCommentsActivity templateCommentsActivity2 = this.this$0;
                    loadState.observe(templateCommentsActivity2, new e(templateCommentsActivity2));
                    TemplateCommentsActivity templateCommentsActivity3 = this.this$0;
                    templateCommentsActivity3.f13734g = new LinearLayoutManager(templateCommentsActivity3);
                    LinearLayoutManager linearLayoutManager = this.this$0.f13734g;
                    ActivityTemplateCommentsBinding activityTemplateCommentsBinding = null;
                    if (linearLayoutManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
                        linearLayoutManager = null;
                    }
                    linearLayoutManager.setReverseLayout(true);
                    LinearLayoutManager linearLayoutManager2 = this.this$0.f13734g;
                    if (linearLayoutManager2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
                        linearLayoutManager2 = null;
                    }
                    linearLayoutManager2.setStackFromEnd(true);
                    ActivityTemplateCommentsBinding activityTemplateCommentsBinding2 = this.this$0.f13737j;
                    if (activityTemplateCommentsBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityTemplateCommentsBinding2 = null;
                    }
                    activityTemplateCommentsBinding2.recyclerView.setAdapter(this.this$0.getAdapter());
                    ActivityTemplateCommentsBinding activityTemplateCommentsBinding3 = this.this$0.f13737j;
                    if (activityTemplateCommentsBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityTemplateCommentsBinding3 = null;
                    }
                    RecyclerView recyclerView = activityTemplateCommentsBinding3.recyclerView;
                    LinearLayoutManager linearLayoutManager3 = this.this$0.f13734g;
                    if (linearLayoutManager3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
                        linearLayoutManager3 = null;
                    }
                    recyclerView.setLayoutManager(linearLayoutManager3);
                    this.this$0.getAdapter().registerAdapterDataObserver(this.this$0.f13736i);
                    ActivityTemplateCommentsBinding activityTemplateCommentsBinding4 = this.this$0.f13737j;
                    if (activityTemplateCommentsBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityTemplateCommentsBinding4 = null;
                    }
                    activityTemplateCommentsBinding4.userName.setText(this.this$0.getMacroTemplate().getUsername());
                    ActivityTemplateCommentsBinding activityTemplateCommentsBinding5 = this.this$0.f13737j;
                    if (activityTemplateCommentsBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityTemplateCommentsBinding5 = null;
                    }
                    ImageView imageView = activityTemplateCommentsBinding5.addCommentButton;
                    final TemplateCommentsActivity templateCommentsActivity4 = this.this$0;
                    imageView.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.comments.d
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            TemplateCommentsActivity.c.a.b(TemplateCommentsActivity.this, view);
                        }
                    });
                    this.this$0.getPresenter().setTemplate(this.this$0.getMacroTemplate());
                    if (!this.this$0.getPremiumStatusHandler().getPremiumStatus().isPro()) {
                        ActivityTemplateCommentsBinding activityTemplateCommentsBinding6 = this.this$0.f13737j;
                        if (activityTemplateCommentsBinding6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            activityTemplateCommentsBinding6 = null;
                        }
                        LinearLayout linearLayout = activityTemplateCommentsBinding6.addCommentLayout;
                        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.addCommentLayout");
                        linearLayout.setVisibility(8);
                        ActivityTemplateCommentsBinding activityTemplateCommentsBinding7 = this.this$0.f13737j;
                        if (activityTemplateCommentsBinding7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            activityTemplateCommentsBinding7 = null;
                        }
                        TextView textView = activityTemplateCommentsBinding7.proVersionText;
                        Intrinsics.checkNotNullExpressionValue(textView, "binding.proVersionText");
                        textView.setVisibility(0);
                        ActivityTemplateCommentsBinding activityTemplateCommentsBinding8 = this.this$0.f13737j;
                        if (activityTemplateCommentsBinding8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            activityTemplateCommentsBinding8 = null;
                        }
                        TextView textView2 = activityTemplateCommentsBinding8.proVersionText;
                        Intrinsics.checkNotNullExpressionValue(textView2, "binding. proVersionText");
                        ViewExtensionsKt.onClick$default(textView2, null, new f(this.this$0, null), 1, null);
                    } else if (this.this$0.getUserProvider().getUser().isGuest()) {
                        ActivityTemplateCommentsBinding activityTemplateCommentsBinding9 = this.this$0.f13737j;
                        if (activityTemplateCommentsBinding9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            activityTemplateCommentsBinding9 = null;
                        }
                        LinearLayout linearLayout2 = activityTemplateCommentsBinding9.addCommentLayout;
                        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.addCommentLayout");
                        linearLayout2.setVisibility(8);
                        ActivityTemplateCommentsBinding activityTemplateCommentsBinding10 = this.this$0.f13737j;
                        if (activityTemplateCommentsBinding10 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            activityTemplateCommentsBinding10 = null;
                        }
                        TextView textView3 = activityTemplateCommentsBinding10.proVersionText;
                        Intrinsics.checkNotNullExpressionValue(textView3, "binding.proVersionText");
                        textView3.setVisibility(0);
                        ActivityTemplateCommentsBinding activityTemplateCommentsBinding11 = this.this$0.f13737j;
                        if (activityTemplateCommentsBinding11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            activityTemplateCommentsBinding11 = null;
                        }
                        TextView textView4 = activityTemplateCommentsBinding11.proVersionText;
                        Intrinsics.checkNotNullExpressionValue(textView4, "binding.proVersionText");
                        ViewExtensionsKt.onClick$default(textView4, null, new g(this.this$0, null), 1, null);
                        ActivityTemplateCommentsBinding activityTemplateCommentsBinding12 = this.this$0.f13737j;
                        if (activityTemplateCommentsBinding12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            activityTemplateCommentsBinding = activityTemplateCommentsBinding12;
                        }
                        activityTemplateCommentsBinding.proVersionText.setText(this.this$0.getString(R.string.comments_signed_in_users_only));
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new c(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                BlockedUserDao blockedUserDao = TemplateCommentsActivity.this.getRoomDatabase().blockedUserDao();
                this.label = 1;
                obj = blockedUserDao.getAllBlockedUsers(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            MainCoroutineDispatcher main = Dispatchers.getMain();
            a aVar = new a(TemplateCommentsActivity.this, (List) obj, null);
            this.label = 2;
            if (BuildersKt.withContext(main, aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: TemplateCommentsActivity.kt */
    @SourceDebugExtension({"SMAP\nTemplateCommentsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TemplateCommentsActivity.kt\ncom/arlosoft/macrodroid/templatestore/ui/comments/TemplateCommentsActivity$showTemplateError$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,351:1\n262#2,2:352\n*S KotlinDebug\n*F\n+ 1 TemplateCommentsActivity.kt\ncom/arlosoft/macrodroid/templatestore/ui/comments/TemplateCommentsActivity$showTemplateError$1\n*L\n145#1:352,2\n*E\n"})
    /* loaded from: classes3.dex */
    static final class d extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
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
                ActivityTemplateCommentsBinding activityTemplateCommentsBinding = TemplateCommentsActivity.this.f13737j;
                if (activityTemplateCommentsBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityTemplateCommentsBinding = null;
                }
                LinearLayout linearLayout = activityTemplateCommentsBinding.errorView;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.errorView");
                linearLayout.setVisibility(8);
                TemplateCommentsActivity.this.getPresenter().loadTemplate(TemplateCommentsActivity.this.f13735h);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void p(int i4) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new a(i4, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(TemplateCommentsActivity this$0, Comment comment, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(comment, "$comment");
        this$0.getPresenter().deleteComment(comment);
    }

    private final void r(MacroTemplate macroTemplate) {
        String name;
        setMacroTemplate(macroTemplate);
        ActivityTemplateCommentsBinding activityTemplateCommentsBinding = this.f13737j;
        if (activityTemplateCommentsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTemplateCommentsBinding = null;
        }
        TextView textView = activityTemplateCommentsBinding.macroNameText;
        if (getMacroTemplate().getUseTranslatedText()) {
            name = getMacroTemplate().getNameTranslated();
            if (name == null) {
                name = getMacroTemplate().getName();
            }
        } else {
            name = getMacroTemplate().getName();
        }
        textView.setText(name);
        ProfileImageProvider profileImageProvider = getProfileImageProvider();
        ActivityTemplateCommentsBinding activityTemplateCommentsBinding2 = this.f13737j;
        if (activityTemplateCommentsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTemplateCommentsBinding2 = null;
        }
        AvatarView avatarView = activityTemplateCommentsBinding2.avatarImage;
        Intrinsics.checkNotNullExpressionValue(avatarView, "binding.avatarImage");
        profileImageProvider.loadImageFromUrl(avatarView, getMacroTemplate().getUserImage(), getMacroTemplate().getUsername());
        setCommentsViewModel(new CommentsViewModel(getApi(), getMacroTemplate().getId()));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new c(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(final Comment comment, boolean z3) {
        int i4;
        final String[] strArr = new String[1];
        if (z3) {
            i4 = R.string.template_store_unblock_user;
        } else {
            i4 = R.string.template_store_block_user;
        }
        strArr[0] = getString(i4);
        new AlertDialog.Builder(this, R.style.Theme_App_Dialog_Template).setTitle(R.string.select_option).setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.comments.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                TemplateCommentsActivity.t(strArr, this, comment, dialogInterface, i5);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(String[] options, TemplateCommentsActivity this$0, Comment comment, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(options, "$options");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(comment, "$comment");
        String str = options[i4];
        Intrinsics.checkNotNullExpressionValue(str, "options[index]");
        if (Intrinsics.areEqual(str, this$0.getString(R.string.template_store_block_user))) {
            this$0.getPresenter().onBlockUser(comment);
        } else if (Intrinsics.areEqual(str, this$0.getString(R.string.template_store_unblock_user))) {
            this$0.getPresenter().onUnblockUser(comment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(String[] options, TemplateCommentsActivity this$0, Comment comment, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(options, "$options");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(comment, "$comment");
        String str = options[i4];
        Intrinsics.checkNotNullExpressionValue(str, "options[index]");
        if (Intrinsics.areEqual(str, this$0.getString(R.string.edit_comment))) {
            this$0.getPresenter().onEditPressed(comment);
        } else if (Intrinsics.areEqual(str, this$0.getString(R.string.delete))) {
            this$0.getPresenter().deleteComment(comment);
        }
    }

    private final void v(String str) {
        ActivityTemplateCommentsBinding activityTemplateCommentsBinding = this.f13737j;
        if (activityTemplateCommentsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTemplateCommentsBinding = null;
        }
        LinearLayout linearLayout = activityTemplateCommentsBinding.uploadingLayout;
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

    @Override // com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsViewContract
    public void clearCommentText() {
        ActivityTemplateCommentsBinding activityTemplateCommentsBinding = this.f13737j;
        ActivityTemplateCommentsBinding activityTemplateCommentsBinding2 = null;
        if (activityTemplateCommentsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTemplateCommentsBinding = null;
        }
        activityTemplateCommentsBinding.commentText.setText("");
        ActivityTemplateCommentsBinding activityTemplateCommentsBinding3 = this.f13737j;
        if (activityTemplateCommentsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTemplateCommentsBinding2 = activityTemplateCommentsBinding3;
        }
        AppCompatEditText appCompatEditText = activityTemplateCommentsBinding2.commentText;
        Intrinsics.checkNotNullExpressionValue(appCompatEditText, "binding.commentText");
        ViewExtensionsKt.hideKeyboard(appCompatEditText);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsViewContract
    public void clearUpdateDialog() {
        AppCompatDialog appCompatDialog = this.f13733f;
        if (appCompatDialog != null) {
            appCompatDialog.dismiss();
        }
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsViewContract
    public void commentsUpdated() {
        DataSource<?, Comment> dataSource;
        PagedList<Comment> currentList = getAdapter().getCurrentList();
        if (currentList != null && (dataSource = currentList.getDataSource()) != null) {
            dataSource.invalidate();
        }
        ActivityTemplateCommentsBinding activityTemplateCommentsBinding = this.f13737j;
        if (activityTemplateCommentsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTemplateCommentsBinding = null;
        }
        LinearLayout linearLayout = activityTemplateCommentsBinding.uploadingLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.uploadingLayout");
        linearLayout.setVisibility(8);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsViewContract
    public void confirmDelete(@NotNull final Comment comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.delete);
        builder.setMessage(R.string.are_you_sure_delete_comment).setCancelable(true).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.comments.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                TemplateCommentsActivity.q(TemplateCommentsActivity.this, comment, dialogInterface, i4);
            }
        }).setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsViewContract
    public void editComment(@NotNull Comment comment) {
        EditText editText;
        Window window;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(comment, "comment");
        AppCompatDialog appCompatDialog = new AppCompatDialog(this, R.style.Theme_App_Dialog_Template_NoTitle);
        this.f13733f = appCompatDialog;
        appCompatDialog.setCancelable(false);
        AppCompatDialog appCompatDialog2 = this.f13733f;
        if (appCompatDialog2 != null) {
            appCompatDialog2.setContentView(R.layout.dialog_edit_comment);
        }
        AppCompatDialog appCompatDialog3 = this.f13733f;
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
        AppCompatDialog appCompatDialog4 = this.f13733f;
        if (appCompatDialog4 != null && (imageView = (ImageView) appCompatDialog4.findViewById(R.id.updateCommentButton)) != null) {
            ViewExtensionsKt.onClick$default(imageView, null, new b(comment, editText, null), 1, null);
        }
        AppCompatDialog appCompatDialog5 = this.f13733f;
        if (appCompatDialog5 != null) {
            appCompatDialog5.setCancelable(true);
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        AppCompatDialog appCompatDialog6 = this.f13733f;
        if (appCompatDialog6 != null) {
            window = appCompatDialog6.getWindow();
        } else {
            window = null;
        }
        Intrinsics.checkNotNull(window);
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = Resources.getSystem().getDisplayMetrics().widthPixels - (getResources().getDimensionPixelSize(R.dimen.margin_medium) * 2);
        AppCompatDialog appCompatDialog7 = this.f13733f;
        if (appCompatDialog7 != null) {
            window2 = appCompatDialog7.getWindow();
        }
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(layoutParams);
        AppCompatDialog appCompatDialog8 = this.f13733f;
        if (appCompatDialog8 != null) {
            appCompatDialog8.show();
        }
    }

    @NotNull
    public final CommentsAdapter getAdapter() {
        CommentsAdapter commentsAdapter = this.adapter;
        if (commentsAdapter != null) {
            return commentsAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        return null;
    }

    @NotNull
    public final TemplateStoreApi getApi() {
        TemplateStoreApi templateStoreApi = this.api;
        if (templateStoreApi != null) {
            return templateStoreApi;
        }
        Intrinsics.throwUninitializedPropertyAccessException("api");
        return null;
    }

    @NotNull
    public final CommentsViewModel getCommentsViewModel() {
        CommentsViewModel commentsViewModel = this.commentsViewModel;
        if (commentsViewModel != null) {
            return commentsViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("commentsViewModel");
        return null;
    }

    @NotNull
    public final MacroTemplate getMacroTemplate() {
        MacroTemplate macroTemplate = this.macroTemplate;
        if (macroTemplate != null) {
            return macroTemplate;
        }
        Intrinsics.throwUninitializedPropertyAccessException("macroTemplate");
        return null;
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
    public final TemplateCommentsPresenter getPresenter() {
        TemplateCommentsPresenter templateCommentsPresenter = this.presenter;
        if (templateCommentsPresenter != null) {
            return templateCommentsPresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
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
    public final MacroDroidRoomDatabase getRoomDatabase() {
        MacroDroidRoomDatabase macroDroidRoomDatabase = this.roomDatabase;
        if (macroDroidRoomDatabase != null) {
            return macroDroidRoomDatabase;
        }
        Intrinsics.throwUninitializedPropertyAccessException("roomDatabase");
        return null;
    }

    @NotNull
    public final TemplateCommentsDataRepository getTemplateCommentsDataRepository() {
        TemplateCommentsDataRepository templateCommentsDataRepository = this.templateCommentsDataRepository;
        if (templateCommentsDataRepository != null) {
            return templateCommentsDataRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("templateCommentsDataRepository");
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

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
        overridePendingTransition(0, R.anim.out_to_bottom);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityTemplateCommentsBinding inflate = ActivityTemplateCommentsBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f13737j = inflate;
        ActivityTemplateCommentsBinding activityTemplateCommentsBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        getPresenter().takeView(this);
        MacroTemplate macroTemplate = getTemplateCommentsDataRepository().getMacroTemplate();
        if (macroTemplate == null) {
            int intExtra = getIntent().getIntExtra(EXTRA_MACRO_ID, -1);
            this.f13735h = intExtra;
            if (intExtra != 0) {
                ActivityTemplateCommentsBinding activityTemplateCommentsBinding2 = this.f13737j;
                if (activityTemplateCommentsBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityTemplateCommentsBinding = activityTemplateCommentsBinding2;
                }
                activityTemplateCommentsBinding.topContainer.setBackgroundColor(ContextCompat.getColor(this, R.color.default_background));
                getPresenter().loadTemplate(this.f13735h);
            } else {
                finish();
                return;
            }
        } else {
            r(macroTemplate);
        }
        int intExtra2 = getIntent().getIntExtra("clear_update_subscription_id", 0);
        if (intExtra2 > 0) {
            p(intExtra2);
        }
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        getPresenter().dropView();
        if (this.adapter != null) {
            getAdapter().unregisterAdapterDataObserver(this.f13736i);
        }
    }

    public final void setAdapter(@NotNull CommentsAdapter commentsAdapter) {
        Intrinsics.checkNotNullParameter(commentsAdapter, "<set-?>");
        this.adapter = commentsAdapter;
    }

    public final void setApi(@NotNull TemplateStoreApi templateStoreApi) {
        Intrinsics.checkNotNullParameter(templateStoreApi, "<set-?>");
        this.api = templateStoreApi;
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsViewContract
    public void setCommentEnabledState(boolean z3) {
        float f4;
        ActivityTemplateCommentsBinding activityTemplateCommentsBinding = this.f13737j;
        ActivityTemplateCommentsBinding activityTemplateCommentsBinding2 = null;
        if (activityTemplateCommentsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTemplateCommentsBinding = null;
        }
        activityTemplateCommentsBinding.commentText.setEnabled(z3);
        ActivityTemplateCommentsBinding activityTemplateCommentsBinding3 = this.f13737j;
        if (activityTemplateCommentsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTemplateCommentsBinding3 = null;
        }
        AppCompatEditText appCompatEditText = activityTemplateCommentsBinding3.commentText;
        float f5 = 1.0f;
        if (z3) {
            f4 = 1.0f;
        } else {
            f4 = 0.5f;
        }
        appCompatEditText.setAlpha(f4);
        ActivityTemplateCommentsBinding activityTemplateCommentsBinding4 = this.f13737j;
        if (activityTemplateCommentsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTemplateCommentsBinding4 = null;
        }
        activityTemplateCommentsBinding4.addCommentButton.setEnabled(z3);
        ActivityTemplateCommentsBinding activityTemplateCommentsBinding5 = this.f13737j;
        if (activityTemplateCommentsBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTemplateCommentsBinding2 = activityTemplateCommentsBinding5;
        }
        ImageView imageView = activityTemplateCommentsBinding2.addCommentButton;
        if (!z3) {
            f5 = 0.5f;
        }
        imageView.setAlpha(f5);
    }

    public final void setCommentsViewModel(@NotNull CommentsViewModel commentsViewModel) {
        Intrinsics.checkNotNullParameter(commentsViewModel, "<set-?>");
        this.commentsViewModel = commentsViewModel;
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsViewContract
    public void setDialogCommentEnabledState(boolean z3) {
        View view;
        float f4;
        AppCompatDialog appCompatDialog = this.f13733f;
        View view2 = null;
        if (appCompatDialog != null) {
            view = appCompatDialog.findViewById(R.id.commentText);
        } else {
            view = null;
        }
        AppCompatDialog appCompatDialog2 = this.f13733f;
        if (appCompatDialog2 != null) {
            view2 = appCompatDialog2.findViewById(R.id.updateCommentButton);
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

    public final void setMacroTemplate(@NotNull MacroTemplate macroTemplate) {
        Intrinsics.checkNotNullParameter(macroTemplate, "<set-?>");
        this.macroTemplate = macroTemplate;
    }

    public final void setPremiumStatusHandler(@NotNull PremiumStatusHandler premiumStatusHandler) {
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "<set-?>");
        this.premiumStatusHandler = premiumStatusHandler;
    }

    public final void setPresenter(@NotNull TemplateCommentsPresenter templateCommentsPresenter) {
        Intrinsics.checkNotNullParameter(templateCommentsPresenter, "<set-?>");
        this.presenter = templateCommentsPresenter;
    }

    public final void setProfileImageProvider(@NotNull ProfileImageProvider profileImageProvider) {
        Intrinsics.checkNotNullParameter(profileImageProvider, "<set-?>");
        this.profileImageProvider = profileImageProvider;
    }

    public final void setRoomDatabase(@NotNull MacroDroidRoomDatabase macroDroidRoomDatabase) {
        Intrinsics.checkNotNullParameter(macroDroidRoomDatabase, "<set-?>");
        this.roomDatabase = macroDroidRoomDatabase;
    }

    public final void setTemplateCommentsDataRepository(@NotNull TemplateCommentsDataRepository templateCommentsDataRepository) {
        Intrinsics.checkNotNullParameter(templateCommentsDataRepository, "<set-?>");
        this.templateCommentsDataRepository = templateCommentsDataRepository;
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsViewContract
    public void setUpdatingComment(boolean z3) {
        View view;
        int i4;
        AppCompatDialog appCompatDialog = this.f13733f;
        if (appCompatDialog != null) {
            view = appCompatDialog.findViewById(R.id.uploadingLayout);
        } else {
            view = null;
        }
        if (view != null) {
            if (z3) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
    }

    public final void setUserProvider(@NotNull UserProvider userProvider) {
        Intrinsics.checkNotNullParameter(userProvider, "<set-?>");
        this.userProvider = userProvider;
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsViewContract
    public void showCommentOptions(@NotNull final Comment comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        final String[] strArr = {getString(R.string.edit_comment), getString(R.string.delete)};
        new AlertDialog.Builder(this, R.style.Theme_App_Dialog_Template).setTitle(R.string.select_option).setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.comments.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                TemplateCommentsActivity.u(strArr, this, comment, dialogInterface, i4);
            }
        }).show();
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsViewContract
    public void showCommentUploadFailed(boolean z3) {
        int i4;
        if (z3) {
            i4 = R.string.not_allowed_to_post_comment;
        } else {
            i4 = R.string.upload_failed;
        }
        String string = getString(i4);
        Intrinsics.checkNotNullExpressionValue(string, "getString(if (notAllowed…e R.string.upload_failed)");
        v(string);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsViewContract
    public void showDeleteFailed() {
        String string = getString(R.string.delete_failed);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.delete_failed)");
        v(string);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsViewContract
    public void showMacroTemplate(@NotNull MacroTemplate macroTemplate) {
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        r(macroTemplate);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsViewContract
    public void showSendingComment() {
        ActivityTemplateCommentsBinding activityTemplateCommentsBinding = this.f13737j;
        ActivityTemplateCommentsBinding activityTemplateCommentsBinding2 = null;
        if (activityTemplateCommentsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTemplateCommentsBinding = null;
        }
        AppCompatEditText appCompatEditText = activityTemplateCommentsBinding.commentText;
        Intrinsics.checkNotNullExpressionValue(appCompatEditText, "binding.commentText");
        ViewExtensionsKt.hideKeyboard(appCompatEditText);
        ActivityTemplateCommentsBinding activityTemplateCommentsBinding3 = this.f13737j;
        if (activityTemplateCommentsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTemplateCommentsBinding2 = activityTemplateCommentsBinding3;
        }
        LinearLayout linearLayout = activityTemplateCommentsBinding2.uploadingLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.uploadingLayout");
        linearLayout.setVisibility(0);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsViewContract
    public void showTemplateError() {
        ActivityTemplateCommentsBinding activityTemplateCommentsBinding = this.f13737j;
        if (activityTemplateCommentsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTemplateCommentsBinding = null;
        }
        LinearLayout linearLayout = activityTemplateCommentsBinding.errorView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.errorView");
        linearLayout.setVisibility(0);
        ActivityTemplateCommentsBinding activityTemplateCommentsBinding2 = this.f13737j;
        if (activityTemplateCommentsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTemplateCommentsBinding2 = null;
        }
        LottieAnimationView lottieAnimationView = activityTemplateCommentsBinding2.loadingView;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "binding.loadingView");
        lottieAnimationView.setVisibility(8);
        ActivityTemplateCommentsBinding activityTemplateCommentsBinding3 = this.f13737j;
        if (activityTemplateCommentsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTemplateCommentsBinding3 = null;
        }
        AppCompatButton appCompatButton = activityTemplateCommentsBinding3.retryButton;
        Intrinsics.checkNotNullExpressionValue(appCompatButton, "binding.retryButton");
        ViewExtensionsKt.onClick$default(appCompatButton, null, new d(null), 1, null);
    }
}
