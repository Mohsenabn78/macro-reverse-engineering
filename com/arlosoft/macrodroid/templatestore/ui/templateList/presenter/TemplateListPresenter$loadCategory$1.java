package com.arlosoft.macrodroid.templatestore.ui.templateList.presenter;

import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import com.arlosoft.macrodroid.templatestore.common.LoadState;
import com.arlosoft.macrodroid.templatestore.model.MacroTemplate;
import com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract;
import com.arlosoft.macrodroid.templatestore.ui.templateList.data.TemplateViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TemplateListPresenter.kt */
/* loaded from: classes3.dex */
public final class TemplateListPresenter$loadCategory$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $language;
    final /* synthetic */ int $queryingUserId;
    final /* synthetic */ String $searchTerm;
    Object L$0;
    int label;
    final /* synthetic */ TemplateListPresenter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateListPresenter.kt */
    /* renamed from: com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter$loadCategory$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ TemplateListPresenter this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TemplateListPresenter.kt */
        /* renamed from: com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter$loadCategory$1$1$a */
        /* loaded from: classes3.dex */
        public static final class a implements Observer<PagedList<MacroTemplate>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ TemplateStoreListViewContract f14092a;

            a(TemplateStoreListViewContract templateStoreListViewContract) {
                this.f14092a = templateStoreListViewContract;
            }

            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public final void onChanged(@NotNull PagedList<MacroTemplate> list) {
                Intrinsics.checkNotNullParameter(list, "list");
                this.f14092a.updateList(list);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TemplateListPresenter templateListPresenter, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = templateListPresenter;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            TemplateViewModel templateViewModel;
            TemplateViewModel templateViewModel2;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                TemplateStoreListViewContract view = this.this$0.getView();
                TemplateViewModel templateViewModel3 = null;
                if (view != null) {
                    templateViewModel2 = this.this$0.f14085r;
                    if (templateViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("templatesViewModel");
                        templateViewModel2 = null;
                    }
                    templateViewModel2.getTemplateList().observe(view, new a(view));
                }
                final TemplateStoreListViewContract view2 = this.this$0.getView();
                if (view2 != null) {
                    final TemplateListPresenter templateListPresenter = this.this$0;
                    templateViewModel = templateListPresenter.f14085r;
                    if (templateViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("templatesViewModel");
                    } else {
                        templateViewModel3 = templateViewModel;
                    }
                    templateViewModel3.getLoadState().observe(view2, new Observer<LoadState>() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter$loadCategory$1$1$2$1

                        /* compiled from: TemplateListPresenter.kt */
                        /* loaded from: classes3.dex */
                        public /* synthetic */ class WhenMappings {
                            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                            static {
                                int[] iArr = new int[LoadState.values().length];
                                try {
                                    iArr[LoadState.LOADING.ordinal()] = 1;
                                } catch (NoSuchFieldError unused) {
                                }
                                try {
                                    iArr[LoadState.ERROR.ordinal()] = 2;
                                } catch (NoSuchFieldError unused2) {
                                }
                                try {
                                    iArr[LoadState.PIRATE_VERSION.ordinal()] = 3;
                                } catch (NoSuchFieldError unused3) {
                                }
                                try {
                                    iArr[LoadState.HAS_DATA.ordinal()] = 4;
                                } catch (NoSuchFieldError unused4) {
                                }
                                try {
                                    iArr[LoadState.EMPTY.ordinal()] = 5;
                                } catch (NoSuchFieldError unused5) {
                                }
                                $EnumSwitchMapping$0 = iArr;
                            }
                        }

                        @Override // androidx.lifecycle.Observer
                        /* renamed from: a */
                        public final void onChanged(LoadState loadState) {
                            int i4;
                            if (loadState == null) {
                                i4 = -1;
                            } else {
                                i4 = WhenMappings.$EnumSwitchMapping$0[loadState.ordinal()];
                            }
                            if (i4 != 1) {
                                if (i4 != 2) {
                                    if (i4 != 3) {
                                        if (i4 != 4) {
                                            if (i4 == 5) {
                                                TemplateStoreListViewContract.this.showEmptyState();
                                                TemplateStoreListViewContract view3 = templateListPresenter.getView();
                                                if (view3 != null) {
                                                    view3.setSwipeRefreshVisible(false);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        TemplateStoreListViewContract.this.showContent();
                                        TemplateStoreListViewContract view4 = templateListPresenter.getView();
                                        if (view4 != null) {
                                            view4.setSwipeRefreshVisible(false);
                                            return;
                                        }
                                        return;
                                    }
                                    TemplateStoreListViewContract.this.showPirateVersionError();
                                    TemplateStoreListViewContract view5 = templateListPresenter.getView();
                                    if (view5 != null) {
                                        view5.setSwipeRefreshVisible(false);
                                        return;
                                    }
                                    return;
                                }
                                TemplateStoreListViewContract.this.showLoadDataError();
                                TemplateStoreListViewContract view6 = templateListPresenter.getView();
                                if (view6 != null) {
                                    view6.setSwipeRefreshVisible(false);
                                    return;
                                }
                                return;
                            }
                            TemplateStoreListViewContract.this.showLoadingState();
                        }
                    });
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemplateListPresenter$loadCategory$1(TemplateListPresenter templateListPresenter, int i4, String str, String str2, Continuation<? super TemplateListPresenter$loadCategory$1> continuation) {
        super(2, continuation);
        this.this$0 = templateListPresenter;
        this.$queryingUserId = i4;
        this.$searchTerm = str;
        this.$language = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TemplateListPresenter$loadCategory$1(this.this$0, this.$queryingUserId, this.$searchTerm, this.$language, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00df A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r21) {
        /*
            r20 = this;
            r0 = r20
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L32
            if (r2 == r5) goto L2c
            if (r2 == r4) goto L20
            if (r2 != r3) goto L18
            kotlin.ResultKt.throwOnFailure(r21)
            goto Le0
        L18:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L20:
            java.lang.Object r2 = r0.L$0
            java.util.List r2 = (java.util.List) r2
            kotlin.ResultKt.throwOnFailure(r21)
            r6 = r21
        L29:
            r18 = r2
            goto L5f
        L2c:
            kotlin.ResultKt.throwOnFailure(r21)
            r2 = r21
            goto L48
        L32:
            kotlin.ResultKt.throwOnFailure(r21)
            com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter r2 = r0.this$0
            com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase r2 = com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter.access$getRoomDatabase$p(r2)
            com.arlosoft.macrodroid.database.room.BlockedUserDao r2 = r2.blockedUserDao()
            r0.label = r5
            java.lang.Object r2 = r2.getAllBlockedUsers(r0)
            if (r2 != r1) goto L48
            return r1
        L48:
            java.util.List r2 = (java.util.List) r2
            com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter r6 = r0.this$0
            com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase r6 = com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter.access$getRoomDatabase$p(r6)
            com.arlosoft.macrodroid.database.room.BlockedMacroDao r6 = r6.blockedMacroDao()
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r6 = r6.getAllBlockedMacro(r0)
            if (r6 != r1) goto L29
            return r1
        L5f:
            r19 = r6
            java.util.List r19 = (java.util.List) r19
            com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter r2 = r0.this$0
            com.arlosoft.macrodroid.templatestore.ui.templateList.data.TemplateViewModel r6 = new com.arlosoft.macrodroid.templatestore.ui.templateList.data.TemplateViewModel
            com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter r7 = r0.this$0
            com.google.gson.Gson r8 = com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter.access$getGson$p(r7)
            com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter r7 = r0.this$0
            com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi r9 = com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter.access$getApi$p(r7)
            com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter r7 = r0.this$0
            int r10 = com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter.access$getUserId$p(r7)
            int r11 = r0.$queryingUserId
            com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter r7 = r0.this$0
            com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateCategoryManager r7 = com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter.access$getCategoryManager$p(r7)
            int r12 = r7.getCategoryId()
            com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter r7 = r0.this$0
            int r13 = com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter.access$getOrderBy$p(r7)
            java.lang.String r14 = r0.$searchTerm
            com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter r7 = r0.this$0
            com.arlosoft.macrodroid.settings.AppPreferences r15 = com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter.access$getAppPreferences$p(r7)
            com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter r7 = r0.this$0
            com.arlosoft.macrodroid.categories.CategoriesHelper r16 = com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter.access$getCategoriesHelper$p(r7)
            java.lang.String r7 = r0.$language
            r5 = 0
            if (r7 == 0) goto La8
            int r7 = r7.length()
            if (r7 != 0) goto La5
            goto La8
        La5:
            r17 = 0
            goto Laa
        La8:
            r17 = 1
        Laa:
            if (r17 != 0) goto Lbd
            java.lang.String r7 = r0.$language
            java.lang.String r3 = "language"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r3)
            java.lang.String r3 = r7.substring(r5, r4)
            java.lang.String r4 = "this as java.lang.String…ing(startIndex, endIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            goto Lbf
        Lbd:
            java.lang.String r3 = "en"
        Lbf:
            r17 = r3
            r7 = r6
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter.access$setTemplatesViewModel$p(r2, r6)
            kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getMain()
            com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter$loadCategory$1$1 r3 = new com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter$loadCategory$1$1
            com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter r4 = r0.this$0
            r5 = 0
            r3.<init>(r4, r5)
            r0.L$0 = r5
            r4 = 3
            r0.label = r4
            java.lang.Object r2 = kotlinx.coroutines.BuildersKt.withContext(r2, r3, r0)
            if (r2 != r1) goto Le0
            return r1
        Le0:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter$loadCategory$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TemplateListPresenter$loadCategory$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
