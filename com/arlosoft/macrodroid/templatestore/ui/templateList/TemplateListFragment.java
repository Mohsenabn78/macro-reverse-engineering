package com.arlosoft.macrodroid.templatestore.ui.templateList;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseFragment;
import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.data.OrderByOption;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.database.room.MacroSubscription;
import com.arlosoft.macrodroid.database.room.UserSubscription;
import com.arlosoft.macrodroid.databinding.FragmentTemplateStoreListBinding;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.templatestore.common.FlagProvider;
import com.arlosoft.macrodroid.templatestore.model.MacroTemplate;
import com.arlosoft.macrodroid.templatestore.translation.TemplatesTranslationHelper;
import com.arlosoft.macrodroid.templatestore.ui.TemplateStoreFragment;
import com.arlosoft.macrodroid.templatestore.ui.TemplateStoreList;
import com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsActivity;
import com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsDataRepository;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.templatestore.ui.search.TemplateSearchActivity;
import com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.arlosoft.macrodroid.upgrade.UpgradeActivity2;
import com.google.android.material.snackbar.SnackbarAnimate;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TemplateListFragment.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nTemplateListFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TemplateListFragment.kt\ncom/arlosoft/macrodroid/templatestore/ui/templateList/TemplateListFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,529:1\n262#2,2:530\n262#2,2:532\n262#2,2:534\n262#2,2:536\n262#2,2:538\n262#2,2:540\n262#2,2:542\n262#2,2:544\n262#2,2:546\n262#2,2:548\n262#2,2:550\n262#2,2:552\n262#2,2:554\n262#2,2:556\n262#2,2:558\n262#2,2:560\n262#2,2:562\n262#2,2:564\n262#2,2:566\n262#2,2:568\n262#2,2:570\n262#2,2:572\n262#2,2:574\n262#2,2:576\n*S KotlinDebug\n*F\n+ 1 TemplateListFragment.kt\ncom/arlosoft/macrodroid/templatestore/ui/templateList/TemplateListFragment\n*L\n171#1:530,2\n172#1:532,2\n173#1:534,2\n174#1:536,2\n224#1:538,2\n225#1:540,2\n226#1:542,2\n227#1:544,2\n228#1:546,2\n232#1:548,2\n233#1:550,2\n234#1:552,2\n235#1:554,2\n236#1:556,2\n240#1:558,2\n241#1:560,2\n242#1:562,2\n243#1:564,2\n244#1:566,2\n248#1:568,2\n249#1:570,2\n250#1:572,2\n251#1:574,2\n252#1:576,2\n*E\n"})
/* loaded from: classes3.dex */
public final class TemplateListFragment extends MacroDroidDaggerBaseFragment implements TemplateStoreListViewContract, TemplateStoreList {

    /* renamed from: b */
    private TemplateListAdapter f13978b;

    /* renamed from: c */
    private int f13979c;

    /* renamed from: d */
    private int f13980d;
    @Nullable

    /* renamed from: e */
    private AppCompatDialog f13981e;
    @Nullable

    /* renamed from: f */
    private AppCompatDialog f13982f;
    @Inject
    public FlagProvider flagProvider;

    /* renamed from: g */
    private boolean f13983g;

    /* renamed from: h */
    private boolean f13984h;

    /* renamed from: i */
    private boolean f13985i;

    /* renamed from: j */
    private FragmentTemplateStoreListBinding f13986j;
    @Inject
    public LocalTemplateOverrideStore localTemplateOverrideStore;
    @Inject
    public TemplateListPresenter presenter;
    @Inject
    public ProfileImageProvider profileImageProvider;
    @Inject
    public MacroDroidRoomDatabase roomDatabase;
    @Inject
    public ScreenLoader screenLoader;
    @Inject
    public TemplateCommentsDataRepository templateCommentsDataRepository;
    @Inject
    public TemplatesTranslationHelper translationHelper;
    @Inject
    public UserProvider userProvider;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: TemplateListFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ TemplateListFragment newInstance$default(Companion companion, int i4, int i5, boolean z3, boolean z4, boolean z5, boolean z6, int i6, Object obj) {
            int i7;
            boolean z7;
            boolean z8;
            boolean z9;
            boolean z10 = false;
            if ((i6 & 2) != 0) {
                i7 = 0;
            } else {
                i7 = i5;
            }
            if ((i6 & 4) != 0) {
                z7 = true;
            } else {
                z7 = z3;
            }
            if ((i6 & 8) != 0) {
                z8 = false;
            } else {
                z8 = z4;
            }
            if ((i6 & 16) != 0) {
                z9 = false;
            } else {
                z9 = z5;
            }
            if ((i6 & 32) == 0) {
                z10 = z6;
            }
            return companion.newInstance(i4, i7, z7, z8, z9, z10);
        }

        @NotNull
        public final TemplateListFragment newInstance(@OrderByOption int i4, int i5, boolean z3, boolean z4, boolean z5, boolean z6) {
            TemplateListFragment templateListFragment = new TemplateListFragment();
            Bundle bundle = new Bundle(1);
            bundle.putInt("orderBy", i4);
            bundle.putInt("userId", i5);
            bundle.putBoolean("showReportCount", z4);
            bundle.putBoolean("swipeRefresh", z3);
            bundle.putBoolean("hideZeroReports", z5);
            bundle.putBoolean("disableProfileLinks", z6);
            templateListFragment.setArguments(bundle);
            return templateListFragment;
        }
    }

    /* compiled from: TemplateListFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TemplatesTranslationHelper $translationHelperToPass;
        Object L$0;
        int label;

        /* compiled from: TemplateListFragment.kt */
        /* renamed from: com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateListFragment$a$a */
        /* loaded from: classes3.dex */
        public static final class C0120a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<MacroSubscription> $macroSubscriptions;
            final /* synthetic */ TemplatesTranslationHelper $translationHelperToPass;
            final /* synthetic */ List<UserSubscription> $userSubscriptions;
            int label;
            final /* synthetic */ TemplateListFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0120a(TemplateListFragment templateListFragment, TemplatesTranslationHelper templatesTranslationHelper, List<MacroSubscription> list, List<UserSubscription> list2, Continuation<? super C0120a> continuation) {
                super(2, continuation);
                this.this$0 = templateListFragment;
                this.$translationHelperToPass = templatesTranslationHelper;
                this.$macroSubscriptions = list;
                this.$userSubscriptions = list2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C0120a(this.this$0, this.$translationHelperToPass, this.$macroSubscriptions, this.$userSubscriptions, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.f13978b = new TemplateListAdapter(this.this$0.getPresenter(), this.this$0.getProfileImageProvider(), this.this$0.getLocalTemplateOverrideStore(), this.this$0.getUserProvider(), this.this$0.getFlagProvider(), Settings.getTemplateStoreCompactMode(this.this$0.requireContext()), this.this$0.f13983g, this.this$0.f13984h, this.$translationHelperToPass, this.$macroSubscriptions, this.$userSubscriptions);
                    FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding = this.this$0.f13986j;
                    if (fragmentTemplateStoreListBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        fragmentTemplateStoreListBinding = null;
                    }
                    RecyclerView recyclerView = fragmentTemplateStoreListBinding.updatesList;
                    TemplateListAdapter templateListAdapter = this.this$0.f13978b;
                    if (templateListAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        templateListAdapter = null;
                    }
                    recyclerView.setAdapter(templateListAdapter);
                    TemplateListPresenter.loadCategory$default(this.this$0.getPresenter(), false, 1, null);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((C0120a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(TemplatesTranslationHelper templatesTranslationHelper, Continuation<? super a> continuation) {
            super(2, continuation);
            TemplateListFragment.this = r1;
            this.$translationHelperToPass = templatesTranslationHelper;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(this.$translationHelperToPass, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:45:0x0075 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2a
                if (r1 == r4) goto L26
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                kotlin.ResultKt.throwOnFailure(r10)
                goto L76
            L15:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L1d:
                java.lang.Object r1 = r9.L$0
                java.util.List r1 = (java.util.List) r1
                kotlin.ResultKt.throwOnFailure(r10)
            L24:
                r6 = r1
                goto L58
            L26:
                kotlin.ResultKt.throwOnFailure(r10)
                goto L40
            L2a:
                kotlin.ResultKt.throwOnFailure(r10)
                com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateListFragment r10 = com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateListFragment.this
                com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase r10 = r10.getRoomDatabase()
                com.arlosoft.macrodroid.database.room.MacroSubscriptionDao r10 = r10.macroSubscriptionDao()
                r9.label = r4
                java.lang.Object r10 = r10.getAllMacroSubscriptions(r9)
                if (r10 != r0) goto L40
                return r0
            L40:
                r1 = r10
                java.util.List r1 = (java.util.List) r1
                com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateListFragment r10 = com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateListFragment.this
                com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase r10 = r10.getRoomDatabase()
                com.arlosoft.macrodroid.database.room.UserSubscriptionDao r10 = r10.userSubscriptionDao()
                r9.L$0 = r1
                r9.label = r3
                java.lang.Object r10 = r10.getAllUserSubscriptions(r9)
                if (r10 != r0) goto L24
                return r0
            L58:
                r7 = r10
                java.util.List r7 = (java.util.List) r7
                kotlinx.coroutines.MainCoroutineDispatcher r10 = kotlinx.coroutines.Dispatchers.getMain()
                com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateListFragment$a$a r1 = new com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateListFragment$a$a
                com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateListFragment r4 = com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateListFragment.this
                com.arlosoft.macrodroid.templatestore.translation.TemplatesTranslationHelper r5 = r9.$translationHelperToPass
                r8 = 0
                r3 = r1
                r3.<init>(r4, r5, r6, r7, r8)
                r3 = 0
                r9.L$0 = r3
                r9.label = r2
                java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r10, r1, r9)
                if (r10 != r0) goto L76
                return r0
            L76:
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateListFragment.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: TemplateListFragment.kt */
    /* loaded from: classes3.dex */
    static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Continuation<? super b> continuation) {
            super(3, continuation);
            TemplateListFragment.this = r1;
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
                TemplateListPresenter.loadCategory$default(TemplateListFragment.this.getPresenter(), false, 1, null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: TemplateListFragment.kt */
    /* loaded from: classes3.dex */
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        /* compiled from: TemplateListFragment.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<MacroSubscription> $macroSubscriptions;
            final /* synthetic */ List<UserSubscription> $userSubscriptions;
            int label;
            final /* synthetic */ TemplateListFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(TemplateListFragment templateListFragment, List<MacroSubscription> list, List<UserSubscription> list2, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = templateListFragment;
                this.$macroSubscriptions = list;
                this.$userSubscriptions = list2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, this.$macroSubscriptions, this.$userSubscriptions, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    TemplateListAdapter templateListAdapter = this.this$0.f13978b;
                    TemplateListAdapter templateListAdapter2 = null;
                    if (templateListAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        templateListAdapter = null;
                    }
                    templateListAdapter.updateMacroSubscriptions(this.$macroSubscriptions);
                    TemplateListAdapter templateListAdapter3 = this.this$0.f13978b;
                    if (templateListAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        templateListAdapter3 = null;
                    }
                    templateListAdapter3.updateUserSubscriptions(this.$userSubscriptions);
                    TemplateListAdapter templateListAdapter4 = this.this$0.f13978b;
                    if (templateListAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    } else {
                        templateListAdapter2 = templateListAdapter4;
                    }
                    templateListAdapter2.notifyDataSetChanged();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Continuation<? super c> continuation) {
            super(2, continuation);
            TemplateListFragment.this = r1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new c(continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x006f A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L29
                if (r1 == r4) goto L25
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                kotlin.ResultKt.throwOnFailure(r8)
                goto L70
            L15:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1d:
                java.lang.Object r1 = r7.L$0
                java.util.List r1 = (java.util.List) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L57
            L25:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L3f
            L29:
                kotlin.ResultKt.throwOnFailure(r8)
                com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateListFragment r8 = com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateListFragment.this
                com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase r8 = r8.getRoomDatabase()
                com.arlosoft.macrodroid.database.room.MacroSubscriptionDao r8 = r8.macroSubscriptionDao()
                r7.label = r4
                java.lang.Object r8 = r8.getAllMacroSubscriptions(r7)
                if (r8 != r0) goto L3f
                return r0
            L3f:
                r1 = r8
                java.util.List r1 = (java.util.List) r1
                com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateListFragment r8 = com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateListFragment.this
                com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase r8 = r8.getRoomDatabase()
                com.arlosoft.macrodroid.database.room.UserSubscriptionDao r8 = r8.userSubscriptionDao()
                r7.L$0 = r1
                r7.label = r3
                java.lang.Object r8 = r8.getAllUserSubscriptions(r7)
                if (r8 != r0) goto L57
                return r0
            L57:
                java.util.List r8 = (java.util.List) r8
                kotlinx.coroutines.MainCoroutineDispatcher r3 = kotlinx.coroutines.Dispatchers.getMain()
                com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateListFragment$c$a r4 = new com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateListFragment$c$a
                com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateListFragment r5 = com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateListFragment.this
                r6 = 0
                r4.<init>(r5, r1, r8, r6)
                r7.L$0 = r6
                r7.label = r2
                java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r3, r4, r7)
                if (r8 != r0) goto L70
                return r0
            L70:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateListFragment.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: TemplateListFragment.kt */
    /* loaded from: classes3.dex */
    /* synthetic */ class d extends FunctionReferenceImpl implements Function2<MacroTemplate, String, Unit> {
        d(Object obj) {
            super(2, obj, TemplateListPresenter.class, "updateMacroDescription", "updateMacroDescription(Lcom/arlosoft/macrodroid/templatestore/model/MacroTemplate;Ljava/lang/String;)V", 0);
        }

        public final void a(@NotNull MacroTemplate p02, @NotNull String p12) {
            Intrinsics.checkNotNullParameter(p02, "p0");
            Intrinsics.checkNotNullParameter(p12, "p1");
            ((TemplateListPresenter) this.receiver).updateMacroDescription(p02, p12);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: invoke */
        public /* bridge */ /* synthetic */ Unit mo1invoke(MacroTemplate macroTemplate, String str) {
            a(macroTemplate, str);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: TemplateListFragment.kt */
    /* loaded from: classes3.dex */
    /* synthetic */ class e extends FunctionReferenceImpl implements Function2<MacroTemplate, String, Unit> {
        e(Object obj) {
            super(2, obj, TemplateListPresenter.class, "updateMacroName", "updateMacroName(Lcom/arlosoft/macrodroid/templatestore/model/MacroTemplate;Ljava/lang/String;)V", 0);
        }

        public final void a(@NotNull MacroTemplate p02, @NotNull String p12) {
            Intrinsics.checkNotNullParameter(p02, "p0");
            Intrinsics.checkNotNullParameter(p12, "p1");
            ((TemplateListPresenter) this.receiver).updateMacroName(p02, p12);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: invoke */
        public /* bridge */ /* synthetic */ Unit mo1invoke(MacroTemplate macroTemplate, String str) {
            a(macroTemplate, str);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: TemplateListFragment.kt */
    /* loaded from: classes3.dex */
    public static final class f extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ EditText $descriptionText;
        final /* synthetic */ MacroTemplate $macroTemplate;
        final /* synthetic */ Function2<MacroTemplate, String, Object> $presenterMethod;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        f(Function2<? super MacroTemplate, ? super String, ? extends Object> function2, MacroTemplate macroTemplate, EditText editText, Continuation<? super f> continuation) {
            super(3, continuation);
            this.$presenterMethod = function2;
            this.$macroTemplate = macroTemplate;
            this.$descriptionText = editText;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new f(this.$presenterMethod, this.$macroTemplate, this.$descriptionText, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Editable editable;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Function2<MacroTemplate, String, Object> function2 = this.$presenterMethod;
                MacroTemplate macroTemplate = this.$macroTemplate;
                EditText editText = this.$descriptionText;
                if (editText != null) {
                    editable = editText.getText();
                } else {
                    editable = null;
                }
                function2.mo1invoke(macroTemplate, String.valueOf(editable));
                EditText editText2 = this.$descriptionText;
                if (editText2 != null) {
                    ViewExtensionsKt.hideKeyboard(editText2);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: TemplateListFragment.kt */
    /* loaded from: classes3.dex */
    public static final class g extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(Continuation<? super g> continuation) {
            super(3, continuation);
            TemplateListFragment.this = r1;
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
                AppCompatDialog appCompatDialog = TemplateListFragment.this.f13981e;
                if (appCompatDialog != null) {
                    appCompatDialog.dismiss();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: TemplateListFragment.kt */
    /* loaded from: classes3.dex */
    public static final class h extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(AppCompatDialog appCompatDialog, Continuation<? super h> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new h(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: TemplateListFragment.kt */
    /* loaded from: classes3.dex */
    public static final class i extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(AppCompatDialog appCompatDialog, Continuation<? super i> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new i(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: TemplateListFragment.kt */
    /* loaded from: classes3.dex */
    public static final class j extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        final /* synthetic */ String $link;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(String str, AppCompatDialog appCompatDialog, Continuation<? super j> continuation) {
            super(3, continuation);
            TemplateListFragment.this = r1;
            this.$link = str;
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new j(this.$link, this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object obj2;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FragmentActivity activity = TemplateListFragment.this.getActivity();
                Context context = null;
                if (activity != null) {
                    obj2 = activity.getSystemService("clipboard");
                } else {
                    obj2 = null;
                }
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.content.ClipboardManager");
                ((ClipboardManager) obj2).setText(this.$link);
                FragmentActivity activity2 = TemplateListFragment.this.getActivity();
                if (activity2 != null) {
                    context = activity2.getApplicationContext();
                }
                ToastCompat.makeText(context, (int) R.string.link_copied_to_clipboard, 0).show();
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: TemplateListFragment.kt */
    /* loaded from: classes3.dex */
    static final class k extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MacroTemplate $macroTemplate;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(MacroTemplate macroTemplate, Continuation<? super k> continuation) {
            super(3, continuation);
            TemplateListFragment.this = r1;
            this.$macroTemplate = macroTemplate;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new k(this.$macroTemplate, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            EditText editText;
            RadioGroup radioGroup;
            int i4;
            View view;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AppCompatDialog appCompatDialog = TemplateListFragment.this.f13982f;
                Editable editable = null;
                if (appCompatDialog != null) {
                    editText = (EditText) appCompatDialog.findViewById(R.id.justificationText);
                } else {
                    editText = null;
                }
                AppCompatDialog appCompatDialog2 = TemplateListFragment.this.f13982f;
                if (appCompatDialog2 != null) {
                    radioGroup = (RadioGroup) appCompatDialog2.findViewById(R.id.radioGroup);
                } else {
                    radioGroup = null;
                }
                if (radioGroup != null) {
                    AppCompatDialog appCompatDialog3 = TemplateListFragment.this.f13982f;
                    if (appCompatDialog3 != null) {
                        view = appCompatDialog3.findViewById(radioGroup.getCheckedRadioButtonId());
                    } else {
                        view = null;
                    }
                    i4 = radioGroup.indexOfChild(view);
                } else {
                    i4 = 0;
                }
                if (editText != null) {
                    editable = editText.getText();
                }
                String valueOf = String.valueOf(editable);
                if (editText != null) {
                    ViewExtensionsKt.hideKeyboard(editText);
                }
                TemplateListFragment.this.getPresenter().reportTemplate(this.$macroTemplate, i4, valueOf);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: TemplateListFragment.kt */
    /* loaded from: classes3.dex */
    static final class l extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(Continuation<? super l> continuation) {
            super(3, continuation);
            TemplateListFragment.this = r1;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new l(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AppCompatDialog appCompatDialog = TemplateListFragment.this.f13982f;
                if (appCompatDialog != null) {
                    appCompatDialog.dismiss();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final void k(TemplateListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getPresenter().onSwipeToRefresh();
    }

    public static final ColorFilter l(LottieFrameInfo lottieFrameInfo) {
        return new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    }

    private final void m(final MacroTemplate macroTemplate) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity(), R.style.Theme_App_Dialog_Template);
        builder.setTitle(R.string.template_store_block_macro);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.template_store_block_macro_description);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.templ…_block_macro_description)");
        String format = String.format(string, Arrays.copyOf(new Object[]{macroTemplate.getUsername()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        builder.setMessage(format);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                TemplateListFragment.n(TemplateListFragment.this, macroTemplate, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public static final void n(TemplateListFragment this$0, MacroTemplate macroTemplate, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(macroTemplate, "$macroTemplate");
        this$0.getPresenter().blockMacro(macroTemplate.getId(), macroTemplate.getName());
    }

    private final void o(final MacroTemplate macroTemplate) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity(), R.style.Theme_App_Dialog_Template);
        builder.setTitle(R.string.template_store_block_user);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.template_store_block_user_description_with_username);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.templ…escription_with_username)");
        String format = String.format(string, Arrays.copyOf(new Object[]{macroTemplate.getUsername()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        builder.setMessage(format);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                TemplateListFragment.p(TemplateListFragment.this, macroTemplate, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public static final void p(TemplateListFragment this$0, MacroTemplate macroTemplate, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(macroTemplate, "$macroTemplate");
        this$0.getPresenter().blockUser(macroTemplate.getUserId(), macroTemplate.getUsername());
    }

    public static final void q(TemplateListFragment this$0, MacroTemplate macroTemplate, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(macroTemplate, "$macroTemplate");
        this$0.getPresenter().deleteTemplate(macroTemplate);
    }

    private final void r(MacroTemplate macroTemplate, String str, String str2, Function2<? super MacroTemplate, ? super String, ? extends Object> function2) {
        EditText editText;
        Window window;
        Button button;
        Button button2;
        AppCompatDialog appCompatDialog = new AppCompatDialog(requireActivity(), R.style.Theme_App_Dialog_Template);
        this.f13981e = appCompatDialog;
        appCompatDialog.setCancelable(false);
        AppCompatDialog appCompatDialog2 = this.f13981e;
        if (appCompatDialog2 != null) {
            appCompatDialog2.setContentView(R.layout.dialog_update_macro_text);
        }
        AppCompatDialog appCompatDialog3 = this.f13981e;
        if (appCompatDialog3 != null) {
            appCompatDialog3.setCanceledOnTouchOutside(false);
        }
        AppCompatDialog appCompatDialog4 = this.f13981e;
        if (appCompatDialog4 != null) {
            appCompatDialog4.setTitle(str);
        }
        AppCompatDialog appCompatDialog5 = this.f13981e;
        Window window2 = null;
        if (appCompatDialog5 != null) {
            editText = (EditText) appCompatDialog5.findViewById(R.id.commentText);
        } else {
            editText = null;
        }
        if (editText != null) {
            editText.setHint(getString(R.string.enter_text));
        }
        if (editText != null) {
            editText.setText(str2);
        }
        if (editText != null) {
            ViewExtensionsKt.setCursorAtEnd(editText);
        }
        AppCompatDialog appCompatDialog6 = this.f13981e;
        if (appCompatDialog6 != null && (button2 = (Button) appCompatDialog6.findViewById(R.id.okButton)) != null) {
            ViewExtensionsKt.onClick$default(button2, null, new f(function2, macroTemplate, editText, null), 1, null);
        }
        AppCompatDialog appCompatDialog7 = this.f13981e;
        if (appCompatDialog7 != null && (button = (Button) appCompatDialog7.findViewById(R.id.cancelButton)) != null) {
            ViewExtensionsKt.onClick$default(button, null, new g(null), 1, null);
        }
        AppCompatDialog appCompatDialog8 = this.f13981e;
        if (appCompatDialog8 != null) {
            appCompatDialog8.setCancelable(true);
        }
        AppCompatDialog appCompatDialog9 = this.f13981e;
        if (appCompatDialog9 != null) {
            DialogExtensionsKt.setWidthToParent(appCompatDialog9, getResources().getDimensionPixelSize(R.dimen.margin_medium));
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        AppCompatDialog appCompatDialog10 = this.f13981e;
        if (appCompatDialog10 != null) {
            window = appCompatDialog10.getWindow();
        } else {
            window = null;
        }
        Intrinsics.checkNotNull(window);
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = Resources.getSystem().getDisplayMetrics().widthPixels - (getResources().getDimensionPixelSize(R.dimen.margin_medium) * 2);
        AppCompatDialog appCompatDialog11 = this.f13981e;
        if (appCompatDialog11 != null) {
            window2 = appCompatDialog11.getWindow();
        }
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(layoutParams);
        AppCompatDialog appCompatDialog12 = this.f13981e;
        if (appCompatDialog12 != null) {
            appCompatDialog12.show();
        }
    }

    private final void s(MacroTemplate macroTemplate) {
        WindowManager.LayoutParams layoutParams;
        AppCompatDialog appCompatDialog = new AppCompatDialog(requireActivity(), R.style.Theme_App_Dialog_Template);
        appCompatDialog.setContentView(R.layout.dialog_template_link);
        appCompatDialog.setTitle(macroTemplate.getName());
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        layoutParams2.copyFrom(layoutParams);
        layoutParams2.width = -1;
        Window window2 = appCompatDialog.getWindow();
        if (window2 != null) {
            window2.setAttributes(layoutParams2);
        }
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.copyButton);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.dialog_template_link_text);
        String str = "https://www.macrodroidlink.com/macrostore?id=" + macroTemplate.getId();
        if (textView != null) {
            textView.setText(str);
        }
        if (button != null) {
            ViewExtensionsKt.onClick$default(button, null, new h(appCompatDialog, null), 1, null);
        }
        if (button2 != null) {
            ViewExtensionsKt.onClick$default(button2, null, new i(appCompatDialog, null), 1, null);
        }
        if (button3 != null) {
            ViewExtensionsKt.onClick$default(button3, null, new j(str, appCompatDialog, null), 1, null);
        }
        appCompatDialog.show();
    }

    private final void signIn() {
        if (getParentFragment() != null) {
            Fragment parentFragment = getParentFragment();
            Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.arlosoft.macrodroid.templatestore.ui.TemplateStoreFragment");
            ((TemplateStoreFragment) parentFragment).signIn();
        } else if (requireActivity() instanceof TemplateSearchActivity) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNull(requireActivity, "null cannot be cast to non-null type com.arlosoft.macrodroid.templatestore.ui.search.TemplateSearchActivity");
            ((TemplateSearchActivity) requireActivity).signIn();
        } else {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Could not sign in - parent fragment is null"));
        }
    }

    public static final void t(String[] options, TemplateListFragment this$0, MacroTemplate macroTemplate, String editMacroString, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(options, "$options");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(macroTemplate, "$macroTemplate");
        Intrinsics.checkNotNullParameter(editMacroString, "$editMacroString");
        String str = options[i4];
        Intrinsics.checkNotNullExpressionValue(str, "options[index]");
        if (Intrinsics.areEqual(str, this$0.getString(R.string.edit_name))) {
            this$0.getPresenter().onEditTitlePressed(macroTemplate);
        } else if (Intrinsics.areEqual(str, this$0.getString(R.string.template_store_block_macro))) {
            this$0.m(macroTemplate);
        } else if (Intrinsics.areEqual(str, this$0.getString(R.string.template_store_block_user))) {
            this$0.o(macroTemplate);
        } else if (Intrinsics.areEqual(str, this$0.getString(R.string.edit_description))) {
            this$0.getPresenter().onEditDescriptionPressed(macroTemplate);
        } else if (Intrinsics.areEqual(str, editMacroString)) {
            this$0.getPresenter().onEditMacroPressed(macroTemplate);
        } else if (Intrinsics.areEqual(str, this$0.getString(R.string.delete))) {
            this$0.getPresenter().onDeletePressed(macroTemplate);
        } else if (Intrinsics.areEqual(str, this$0.getString(R.string.report_macro))) {
            this$0.getPresenter().onReportMacro(macroTemplate);
        } else if (Intrinsics.areEqual(str, this$0.getString(R.string.get_macro_link))) {
            this$0.s(macroTemplate);
        } else if (Intrinsics.areEqual(str, this$0.getString(R.string.template_store_moderator_options))) {
            this$0.getScreenLoader().loadReportMacroScreen(macroTemplate);
        }
    }

    public static final void u(TemplateListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.signIn();
    }

    private final void v(String str, int i4, View view) {
        SnackbarAnimate make = SnackbarAnimate.make(view, str, 0);
        Intrinsics.checkNotNullExpressionValue(make, "make(parentView, text, S…ckbarAnimate.LENGTH_LONG)");
        make.getView().setBackgroundResource(i4);
        View findViewById = make.getView().findViewById(R.id.snackbar_text);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setTextColor(-1);
        View findViewById2 = make.getView().findViewById(R.id.snackbar_action);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById2).setTextColor(-1);
        make.show();
    }

    static /* synthetic */ void w(TemplateListFragment templateListFragment, String str, int i4, View view, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            view = templateListFragment.requireView();
            Intrinsics.checkNotNullExpressionValue(view, "requireView()");
        }
        templateListFragment.v(str, i4, view);
    }

    public static final void x(TemplateListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requireActivity().startActivity(new Intent(this$0.getActivity(), UpgradeActivity2.class));
    }

    public static final void y(TemplateListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.signIn();
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void clearEditTextDialog() {
        AppCompatDialog appCompatDialog = this.f13981e;
        if (appCompatDialog != null) {
            appCompatDialog.dismiss();
        }
    }

    @NotNull
    public final FlagProvider getFlagProvider() {
        FlagProvider flagProvider = this.flagProvider;
        if (flagProvider != null) {
            return flagProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("flagProvider");
        return null;
    }

    @NotNull
    public final LocalTemplateOverrideStore getLocalTemplateOverrideStore() {
        LocalTemplateOverrideStore localTemplateOverrideStore = this.localTemplateOverrideStore;
        if (localTemplateOverrideStore != null) {
            return localTemplateOverrideStore;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localTemplateOverrideStore");
        return null;
    }

    @NotNull
    public final TemplateListPresenter getPresenter() {
        TemplateListPresenter templateListPresenter = this.presenter;
        if (templateListPresenter != null) {
            return templateListPresenter;
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
    public final ScreenLoader getScreenLoader() {
        ScreenLoader screenLoader = this.screenLoader;
        if (screenLoader != null) {
            return screenLoader;
        }
        Intrinsics.throwUninitializedPropertyAccessException("screenLoader");
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
    public final TemplatesTranslationHelper getTranslationHelper() {
        TemplatesTranslationHelper templatesTranslationHelper = this.translationHelper;
        if (templatesTranslationHelper != null) {
            return templatesTranslationHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("translationHelper");
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

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void initialiseList() {
        TemplatesTranslationHelper templatesTranslationHelper;
        if (Intrinsics.areEqual(Settings.getTemplateStoreAutoTranslateLanguage(requireContext()), Locale.getDefault().getLanguage())) {
            templatesTranslationHelper = getTranslationHelper();
        } else {
            templatesTranslationHelper = null;
        }
        kotlinx.coroutines.e.e(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new a(templatesTranslationHelper, null), 2, null);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void loadCommentsScreen(@NotNull MacroTemplate macroTemplate) {
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        getTemplateCommentsDataRepository().setMacroTemplate(macroTemplate.clearJsonData());
        TemplateCommentsActivity.Companion companion = TemplateCommentsActivity.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        startActivityForResult(companion.createIntent(requireContext), 101);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(R.anim.up_from_bottom, R.anim.no_change);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onActivityCreated(@org.jetbrains.annotations.Nullable android.os.Bundle r9) {
        /*
            r8 = this;
            super.onActivityCreated(r9)
            android.os.Bundle r9 = r8.getArguments()
            r0 = 0
            if (r9 == 0) goto L11
            java.lang.String r1 = "userId"
            int r9 = r9.getInt(r1)
            goto L12
        L11:
            r9 = 0
        L12:
            r8.f13979c = r9
            android.os.Bundle r9 = r8.getArguments()
            if (r9 == 0) goto L20
            java.lang.String r0 = "orderBy"
            int r0 = r9.getInt(r0)
        L20:
            r8.f13980d = r0
            androidx.fragment.app.Fragment r9 = r8.getParentFragment()
            java.lang.String r0 = "null cannot be cast to non-null type com.arlosoft.macrodroid.templatestore.ui.SearchTermProvider"
            r1 = 0
            if (r9 == 0) goto L36
            androidx.fragment.app.Fragment r9 = r8.getParentFragment()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9, r0)
            com.arlosoft.macrodroid.templatestore.ui.SearchTermProvider r9 = (com.arlosoft.macrodroid.templatestore.ui.SearchTermProvider) r9
        L34:
            r4 = r9
            goto L49
        L36:
            androidx.fragment.app.FragmentActivity r9 = r8.requireActivity()
            boolean r9 = r9 instanceof com.arlosoft.macrodroid.templatestore.ui.SearchTermProvider
            if (r9 == 0) goto L48
            androidx.fragment.app.FragmentActivity r9 = r8.requireActivity()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9, r0)
            com.arlosoft.macrodroid.templatestore.ui.SearchTermProvider r9 = (com.arlosoft.macrodroid.templatestore.ui.SearchTermProvider) r9
            goto L34
        L48:
            r4 = r1
        L49:
            r8.initialiseList()
            com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter r2 = r8.getPresenter()
            int r5 = r8.f13979c
            int r6 = r8.f13980d
            r7 = 1
            r3 = r8
            r2.takeView(r3, r4, r5, r6, r7)
            com.arlosoft.macrodroid.databinding.FragmentTemplateStoreListBinding r9 = r8.f13986j
            java.lang.String r0 = "binding"
            if (r9 != 0) goto L63
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r9 = r1
        L63:
            androidx.appcompat.widget.AppCompatButton r9 = r9.retryButton
            java.lang.String r2 = "binding.retryButton"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r2)
            com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateListFragment$b r2 = new com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateListFragment$b
            r2.<init>(r1)
            r3 = 1
            com.arlosoft.macrodroid.extensions.ViewExtensionsKt.onClick$default(r9, r1, r2, r3, r1)
            com.arlosoft.macrodroid.databinding.FragmentTemplateStoreListBinding r9 = r8.f13986j
            if (r9 != 0) goto L7b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r9 = r1
        L7b:
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout r9 = r9.swipeRefresh
            if (r9 == 0) goto L87
            com.arlosoft.macrodroid.templatestore.ui.templateList.g r2 = new com.arlosoft.macrodroid.templatestore.ui.templateList.g
            r2.<init>()
            r9.setOnRefreshListener(r2)
        L87:
            android.content.res.Resources r9 = r8.getResources()
            r2 = 2131034125(0x7f05000d, float:1.7678759E38)
            boolean r9 = r9.getBoolean(r2)
            if (r9 == 0) goto Lb6
            com.arlosoft.macrodroid.databinding.FragmentTemplateStoreListBinding r9 = r8.f13986j
            if (r9 != 0) goto L9c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L9d
        L9c:
            r1 = r9
        L9d:
            com.airbnb.lottie.LottieAnimationView r9 = r1.cryingAnimation
            if (r9 == 0) goto Lb6
            com.airbnb.lottie.model.KeyPath r0 = new com.airbnb.lottie.model.KeyPath
            java.lang.String r1 = "**"
            java.lang.String[] r1 = new java.lang.String[]{r1}
            r0.<init>(r1)
            android.graphics.ColorFilter r1 = com.airbnb.lottie.LottieProperty.COLOR_FILTER
            com.arlosoft.macrodroid.templatestore.ui.templateList.h r2 = new com.arlosoft.macrodroid.templatestore.ui.templateList.h
            r2.<init>()
            r9.addValueCallback(r0, r1, r2)
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateListFragment.onActivityCreated(android.os.Bundle):void");
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        super.onActivityResult(i4, i5, intent);
        if (i4 == 101 && i5 == -1) {
            boolean z3 = false;
            if (intent != null && intent.getBooleanExtra(TemplateCommentsActivity.EXTRA_SIGN_IN, false)) {
                z3 = true;
            }
            if (z3) {
                signIn();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Bundle arguments = getArguments();
        if (arguments != null) {
            z3 = arguments.getBoolean("swipeRefresh", false);
        } else {
            z3 = true;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            z4 = arguments2.getBoolean("showReportCount", false);
        } else {
            z4 = false;
        }
        this.f13983g = z4;
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            z5 = arguments3.getBoolean("hideZeroReports", false);
        } else {
            z5 = false;
        }
        this.f13984h = z5;
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            z6 = arguments4.getBoolean("disableProfileLinks", false);
        } else {
            z6 = false;
        }
        this.f13985i = z6;
        FragmentTemplateStoreListBinding inflate = FragmentTemplateStoreListBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.f13986j = inflate;
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding = null;
        if (!z3) {
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                inflate = null;
            }
            inflate.swipeRefresh.setEnabled(false);
        }
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding2 = this.f13986j;
        if (fragmentTemplateStoreListBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTemplateStoreListBinding = fragmentTemplateStoreListBinding2;
        }
        return fragmentTemplateStoreListBinding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        getPresenter().dropView();
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding = this.f13986j;
        if (fragmentTemplateStoreListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListBinding = null;
        }
        fragmentTemplateStoreListBinding.updatesList.setAdapter(null);
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding2 = this.f13986j;
        if (fragmentTemplateStoreListBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListBinding2 = null;
        }
        SwipeRefreshLayout swipeRefreshLayout = fragmentTemplateStoreListBinding2.swipeRefresh;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setOnRefreshListener(null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        refresh();
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void refresh() {
        if (this.f13978b != null) {
            kotlinx.coroutines.e.e(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new c(null), 2, null);
        }
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.TemplateStoreList
    public void scrollToTop() {
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding = this.f13986j;
        if (fragmentTemplateStoreListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListBinding = null;
        }
        fragmentTemplateStoreListBinding.updatesList.smoothScrollToPosition(0);
    }

    public final void setFlagProvider(@NotNull FlagProvider flagProvider) {
        Intrinsics.checkNotNullParameter(flagProvider, "<set-?>");
        this.flagProvider = flagProvider;
    }

    public final void setLocalTemplateOverrideStore(@NotNull LocalTemplateOverrideStore localTemplateOverrideStore) {
        Intrinsics.checkNotNullParameter(localTemplateOverrideStore, "<set-?>");
        this.localTemplateOverrideStore = localTemplateOverrideStore;
    }

    public final void setPresenter(@NotNull TemplateListPresenter templateListPresenter) {
        Intrinsics.checkNotNullParameter(templateListPresenter, "<set-?>");
        this.presenter = templateListPresenter;
    }

    public final void setProfileImageProvider(@NotNull ProfileImageProvider profileImageProvider) {
        Intrinsics.checkNotNullParameter(profileImageProvider, "<set-?>");
        this.profileImageProvider = profileImageProvider;
    }

    public final void setRoomDatabase(@NotNull MacroDroidRoomDatabase macroDroidRoomDatabase) {
        Intrinsics.checkNotNullParameter(macroDroidRoomDatabase, "<set-?>");
        this.roomDatabase = macroDroidRoomDatabase;
    }

    public final void setScreenLoader(@NotNull ScreenLoader screenLoader) {
        Intrinsics.checkNotNullParameter(screenLoader, "<set-?>");
        this.screenLoader = screenLoader;
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void setSwipeRefreshVisible(boolean z3) {
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding = this.f13986j;
        if (fragmentTemplateStoreListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListBinding = null;
        }
        SwipeRefreshLayout swipeRefreshLayout = fragmentTemplateStoreListBinding.swipeRefresh;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(z3);
        }
    }

    public final void setTemplateCommentsDataRepository(@NotNull TemplateCommentsDataRepository templateCommentsDataRepository) {
        Intrinsics.checkNotNullParameter(templateCommentsDataRepository, "<set-?>");
        this.templateCommentsDataRepository = templateCommentsDataRepository;
    }

    public final void setTranslationHelper(@NotNull TemplatesTranslationHelper templatesTranslationHelper) {
        Intrinsics.checkNotNullParameter(templatesTranslationHelper, "<set-?>");
        this.translationHelper = templatesTranslationHelper;
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void setUpdatingText(boolean z3) {
        ViewFlipper viewFlipper;
        AppCompatDialog appCompatDialog = this.f13981e;
        if (appCompatDialog != null) {
            viewFlipper = (ViewFlipper) appCompatDialog.findViewById(R.id.viewFlipper);
        } else {
            viewFlipper = null;
        }
        if (viewFlipper != null) {
            viewFlipper.setDisplayedChild(z3 ? 1 : 0);
        }
    }

    public final void setUserProvider(@NotNull UserProvider userProvider) {
        Intrinsics.checkNotNullParameter(userProvider, "<set-?>");
        this.userProvider = userProvider;
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void showConfirmDelete(@NotNull final MacroTemplate macroTemplate) {
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity(), R.style.Theme_App_Dialog_Template);
        builder.setTitle(macroTemplate.getName());
        builder.setMessage(getString(R.string.delete_template_confirm));
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                TemplateListFragment.q(TemplateListFragment.this, macroTemplate, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void showContent() {
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding = this.f13986j;
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding2 = null;
        if (fragmentTemplateStoreListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListBinding = null;
        }
        RecyclerView recyclerView = fragmentTemplateStoreListBinding.updatesList;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.updatesList");
        recyclerView.setVisibility(0);
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding3 = this.f13986j;
        if (fragmentTemplateStoreListBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListBinding3 = null;
        }
        LinearLayout linearLayout = fragmentTemplateStoreListBinding3.emptyView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.emptyView");
        linearLayout.setVisibility(8);
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding4 = this.f13986j;
        if (fragmentTemplateStoreListBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListBinding4 = null;
        }
        LinearLayout linearLayout2 = fragmentTemplateStoreListBinding4.errorView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.errorView");
        linearLayout2.setVisibility(8);
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding5 = this.f13986j;
        if (fragmentTemplateStoreListBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListBinding5 = null;
        }
        LottieAnimationView lottieAnimationView = fragmentTemplateStoreListBinding5.loadingView;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "binding.loadingView");
        lottieAnimationView.setVisibility(8);
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding6 = this.f13986j;
        if (fragmentTemplateStoreListBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTemplateStoreListBinding2 = fragmentTemplateStoreListBinding6;
        }
        LinearLayout linearLayout3 = fragmentTemplateStoreListBinding2.pirateView;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.pirateView");
        linearLayout3.setVisibility(8);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void showDeleteFailed() {
        String string = getString(R.string.template_delete_failed);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.template_delete_failed)");
        w(this, string, R.color.snack_bar_error, null, 4, null);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void showDeleteSuccess() {
        String string = getString(R.string.template_is_deleted);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.template_is_deleted)");
        w(this, string, R.color.md_green_500, null, 4, null);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void showEditDescriptionDialog(@NotNull MacroTemplate macroTemplate) {
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        String string = getString(R.string.edit_description);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.edit_description)");
        r(macroTemplate, string, macroTemplate.getDescription(), new d(getPresenter()));
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void showEditNameDialog(@NotNull MacroTemplate macroTemplate) {
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        String string = getString(R.string.edit_name);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.edit_name)");
        r(macroTemplate, string, macroTemplate.getName(), new e(getPresenter()));
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void showEmptyState() {
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding = this.f13986j;
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding2 = null;
        if (fragmentTemplateStoreListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListBinding = null;
        }
        RecyclerView recyclerView = fragmentTemplateStoreListBinding.updatesList;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.updatesList");
        recyclerView.setVisibility(8);
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding3 = this.f13986j;
        if (fragmentTemplateStoreListBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListBinding3 = null;
        }
        LinearLayout linearLayout = fragmentTemplateStoreListBinding3.emptyView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.emptyView");
        linearLayout.setVisibility(0);
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding4 = this.f13986j;
        if (fragmentTemplateStoreListBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListBinding4 = null;
        }
        LinearLayout linearLayout2 = fragmentTemplateStoreListBinding4.errorView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.errorView");
        linearLayout2.setVisibility(8);
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding5 = this.f13986j;
        if (fragmentTemplateStoreListBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListBinding5 = null;
        }
        LottieAnimationView lottieAnimationView = fragmentTemplateStoreListBinding5.loadingView;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "binding.loadingView");
        lottieAnimationView.setVisibility(8);
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding6 = this.f13986j;
        if (fragmentTemplateStoreListBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTemplateStoreListBinding2 = fragmentTemplateStoreListBinding6;
        }
        LinearLayout linearLayout3 = fragmentTemplateStoreListBinding2.pirateView;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.pirateView");
        linearLayout3.setVisibility(8);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void showInvalidText(boolean z3) {
        int i4;
        if (z3) {
            i4 = R.string.macro_name_length_info;
        } else {
            i4 = R.string.macro_description_length_info;
        }
        String string = getString(i4);
        Intrinsics.checkNotNullExpressionValue(string, "getString(if (isName) {\n…on_length_info\n        })");
        w(this, string, R.color.snack_bar_error, null, 4, null);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void showLoadDataError() {
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding = this.f13986j;
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding2 = null;
        if (fragmentTemplateStoreListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListBinding = null;
        }
        LinearLayout linearLayout = fragmentTemplateStoreListBinding.emptyView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.emptyView");
        linearLayout.setVisibility(8);
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding3 = this.f13986j;
        if (fragmentTemplateStoreListBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListBinding3 = null;
        }
        LinearLayout linearLayout2 = fragmentTemplateStoreListBinding3.errorView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.errorView");
        linearLayout2.setVisibility(0);
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding4 = this.f13986j;
        if (fragmentTemplateStoreListBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListBinding4 = null;
        }
        LottieAnimationView lottieAnimationView = fragmentTemplateStoreListBinding4.loadingView;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "binding.loadingView");
        lottieAnimationView.setVisibility(8);
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding5 = this.f13986j;
        if (fragmentTemplateStoreListBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListBinding5 = null;
        }
        RecyclerView recyclerView = fragmentTemplateStoreListBinding5.updatesList;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.updatesList");
        recyclerView.setVisibility(8);
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding6 = this.f13986j;
        if (fragmentTemplateStoreListBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTemplateStoreListBinding2 = fragmentTemplateStoreListBinding6;
        }
        LinearLayout linearLayout3 = fragmentTemplateStoreListBinding2.pirateView;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.pirateView");
        linearLayout3.setVisibility(8);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void showLoadingState() {
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding = this.f13986j;
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding2 = null;
        if (fragmentTemplateStoreListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListBinding = null;
        }
        LinearLayout linearLayout = fragmentTemplateStoreListBinding.emptyView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.emptyView");
        linearLayout.setVisibility(8);
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding3 = this.f13986j;
        if (fragmentTemplateStoreListBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListBinding3 = null;
        }
        LinearLayout linearLayout2 = fragmentTemplateStoreListBinding3.errorView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.errorView");
        linearLayout2.setVisibility(8);
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding4 = this.f13986j;
        if (fragmentTemplateStoreListBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListBinding4 = null;
        }
        LottieAnimationView lottieAnimationView = fragmentTemplateStoreListBinding4.loadingView;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "binding.loadingView");
        lottieAnimationView.setVisibility(0);
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding5 = this.f13986j;
        if (fragmentTemplateStoreListBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTemplateStoreListBinding2 = fragmentTemplateStoreListBinding5;
        }
        RecyclerView recyclerView = fragmentTemplateStoreListBinding2.updatesList;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.updatesList");
        recyclerView.setVisibility(8);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void showOptionsMenu(@NotNull final MacroTemplate macroTemplate, boolean z3, boolean z4) {
        final String capitalize;
        final String[] strArr;
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        String string = getString(R.string.edit_macro);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.edit_macro)");
        String lowerCase = string.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        capitalize = kotlin.text.m.capitalize(lowerCase);
        if (z3) {
            strArr = new String[]{getString(R.string.edit_name), getString(R.string.edit_description), capitalize, getString(R.string.delete), getString(R.string.get_macro_link)};
        } else {
            strArr = z4 ? new String[]{getString(R.string.report_macro), getString(R.string.template_store_block_macro), getString(R.string.template_store_block_user), getString(R.string.get_macro_link), getString(R.string.template_store_moderator_options)} : new String[]{getString(R.string.report_macro), getString(R.string.template_store_block_macro), getString(R.string.template_store_block_user), getString(R.string.get_macro_link)};
        }
        new AlertDialog.Builder(requireActivity(), R.style.Theme_App_Dialog_Template).setTitle(macroTemplate.getNameToDisplay()).setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                TemplateListFragment.t(strArr, this, macroTemplate, capitalize, dialogInterface, i4);
            }
        }).show();
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void showOwnMacroStarMessage() {
        Context context;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            context = activity.getApplicationContext();
        } else {
            context = null;
        }
        ToastCompat.makeText(context, (int) R.string.cannot_star_own_macros, 0).show();
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void showPirateVersionError() {
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding = this.f13986j;
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding2 = null;
        if (fragmentTemplateStoreListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListBinding = null;
        }
        LinearLayout linearLayout = fragmentTemplateStoreListBinding.emptyView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.emptyView");
        linearLayout.setVisibility(8);
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding3 = this.f13986j;
        if (fragmentTemplateStoreListBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListBinding3 = null;
        }
        LinearLayout linearLayout2 = fragmentTemplateStoreListBinding3.errorView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.errorView");
        linearLayout2.setVisibility(8);
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding4 = this.f13986j;
        if (fragmentTemplateStoreListBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListBinding4 = null;
        }
        LottieAnimationView lottieAnimationView = fragmentTemplateStoreListBinding4.loadingView;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "binding.loadingView");
        lottieAnimationView.setVisibility(8);
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding5 = this.f13986j;
        if (fragmentTemplateStoreListBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListBinding5 = null;
        }
        RecyclerView recyclerView = fragmentTemplateStoreListBinding5.updatesList;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.updatesList");
        recyclerView.setVisibility(8);
        FragmentTemplateStoreListBinding fragmentTemplateStoreListBinding6 = this.f13986j;
        if (fragmentTemplateStoreListBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTemplateStoreListBinding2 = fragmentTemplateStoreListBinding6;
        }
        LinearLayout linearLayout3 = fragmentTemplateStoreListBinding2.pirateView;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.pirateView");
        linearLayout3.setVisibility(0);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void showReportFailed() {
        View view;
        AppCompatDialog appCompatDialog = this.f13982f;
        if (appCompatDialog != null) {
            view = appCompatDialog.findViewById(R.id.scrollView);
        } else {
            view = null;
        }
        if (view != null) {
            String string = getString(R.string.upload_failed);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.upload_failed)");
            v(string, R.color.snack_bar_error, view);
        }
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void showReportMacroDialog(@NotNull MacroTemplate macroTemplate) {
        Button button;
        Button button2;
        Button button3;
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        AppCompatDialog appCompatDialog = new AppCompatDialog(requireActivity(), R.style.Theme_App_Dialog_Template);
        this.f13982f = appCompatDialog;
        appCompatDialog.setContentView(R.layout.dialog_report_template);
        AppCompatDialog appCompatDialog2 = this.f13982f;
        if (appCompatDialog2 != null) {
            appCompatDialog2.setTitle(R.string.report_macro);
        }
        AppCompatDialog appCompatDialog3 = this.f13982f;
        if (appCompatDialog3 != null) {
            DialogExtensionsKt.setWidthToParent(appCompatDialog3, getResources().getDimensionPixelSize(R.dimen.margin_medium));
        }
        AppCompatDialog appCompatDialog4 = this.f13982f;
        if (appCompatDialog4 != null) {
            appCompatDialog4.setCanceledOnTouchOutside(false);
        }
        AppCompatDialog appCompatDialog5 = this.f13982f;
        if (appCompatDialog5 != null) {
            button = (Button) appCompatDialog5.findViewById(R.id.okButton);
        } else {
            button = null;
        }
        if (button != null) {
            button.setText(getString(R.string.report_macro));
        }
        AppCompatDialog appCompatDialog6 = this.f13982f;
        if (appCompatDialog6 != null && (button3 = (Button) appCompatDialog6.findViewById(R.id.okButton)) != null) {
            ViewExtensionsKt.onClick$default(button3, null, new k(macroTemplate, null), 1, null);
        }
        AppCompatDialog appCompatDialog7 = this.f13982f;
        if (appCompatDialog7 != null && (button2 = (Button) appCompatDialog7.findViewById(R.id.cancelButton)) != null) {
            ViewExtensionsKt.onClick$default(button2, null, new l(null), 1, null);
        }
        AppCompatDialog appCompatDialog8 = this.f13982f;
        if (appCompatDialog8 != null) {
            appCompatDialog8.show();
        }
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void showReportUploading(boolean z3) {
        ViewFlipper viewFlipper;
        AppCompatDialog appCompatDialog = this.f13982f;
        if (appCompatDialog != null) {
            viewFlipper = (ViewFlipper) appCompatDialog.findViewById(R.id.viewFlipper);
        } else {
            viewFlipper = null;
        }
        if (viewFlipper != null) {
            viewFlipper.setDisplayedChild(z3 ? 1 : 0);
        }
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void showReported() {
        AppCompatDialog appCompatDialog = this.f13982f;
        if (appCompatDialog != null) {
            appCompatDialog.dismiss();
        }
        String string = getString(R.string.report_submitted);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.report_submitted)");
        w(this, string, R.color.md_green_500, null, 4, null);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void showRequiresSignIn() {
        SnackbarAnimate make = SnackbarAnimate.make(requireView(), (int) R.string.please_sign_in_template_store, 5000);
        Intrinsics.checkNotNullExpressionValue(make, "make(requireView(), R.st…_in_template_store, 5000)");
        make.getView().setBackgroundResource(R.color.md_light_blue_600);
        View findViewById = make.getView().findViewById(R.id.snackbar_text);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setTextColor(-1);
        View findViewById2 = make.getView().findViewById(R.id.snackbar_action);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById2).setTextColor(-1);
        make.setAction(R.string.sign_in, new View.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TemplateListFragment.u(TemplateListFragment.this, view);
            }
        });
        make.show();
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void showSubscriptionProOnly() {
        SnackbarAnimate make = SnackbarAnimate.make(requireView(), (int) R.string.template_store_sorry_subsribe_macros_pro_only, 5000);
        Intrinsics.checkNotNullExpressionValue(make, "make(requireView(), R.st…be_macros_pro_only, 5000)");
        make.getView().setBackgroundResource(R.color.md_light_blue_600);
        View findViewById = make.getView().findViewById(R.id.snackbar_text);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setTextColor(-1);
        View findViewById2 = make.getView().findViewById(R.id.snackbar_action);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById2).setTextColor(-1);
        make.setAction(R.string.upgrade, new View.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TemplateListFragment.x(TemplateListFragment.this, view);
            }
        });
        make.show();
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void showSubscriptionSignedInOnly() {
        SnackbarAnimate make = SnackbarAnimate.make(requireView(), (int) R.string.template_store_sorry_subsribe_users_must_sign_in, 5000);
        Intrinsics.checkNotNullExpressionValue(make, "make(requireView(), R.st…users_must_sign_in, 5000)");
        make.getView().setBackgroundResource(R.color.md_light_blue_600);
        View findViewById = make.getView().findViewById(R.id.snackbar_text);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setTextColor(-1);
        View findViewById2 = make.getView().findViewById(R.id.snackbar_action);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById2).setTextColor(-1);
        make.setAction(R.string.sign_in, new View.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TemplateListFragment.y(TemplateListFragment.this, view);
            }
        });
        make.show();
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void showUpdateFailed() {
        View view;
        AppCompatDialog appCompatDialog = this.f13981e;
        if (appCompatDialog != null) {
            view = appCompatDialog.findViewById(R.id.scrollView);
        } else {
            view = null;
        }
        if (view != null) {
            String string = getString(R.string.update_failed);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.update_failed)");
            v(string, R.color.snack_bar_error, view);
        }
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract
    public void updateList(@Nullable PagedList<MacroTemplate> pagedList) {
        boolean z3 = false;
        if (pagedList != null && !pagedList.isEmpty()) {
            z3 = true;
        }
        if (z3) {
            TemplateListAdapter templateListAdapter = this.f13978b;
            if (templateListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                templateListAdapter = null;
            }
            templateListAdapter.submitList(pagedList);
        }
    }
}
