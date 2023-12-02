package com.arlosoft.macrodroid.templatestore.reportmacro;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.arlosoft.macrodroid.extensions.StringExtensionsKt;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApiKt;
import com.arlosoft.macrodroid.templatestore.model.MacroTemplate;
import com.arlosoft.macrodroid.templatestore.reportmacro.UiEvent;
import com.arlosoft.macrodroid.templatestore.ui.templateList.LocalTemplateOverrideStore;
import com.arlosoft.macrodroid.utils.SingleLiveEvent;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReportMacroViewModel.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ReportMacroViewModel extends ViewModel {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final TemplateStoreApi f13670a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final LocalTemplateOverrideStore f13671b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final ReportMacroRepository f13672c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final MutableLiveData<MacroReportData> f13673d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final LiveData<MacroReportData> f13674e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final SingleLiveEvent<UiEvent> f13675f;

    /* renamed from: g  reason: collision with root package name */
    private MacroTemplate f13676g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReportMacroViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            MacroTemplate macroTemplate = null;
            try {
                if (i4 != 0) {
                    if (i4 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    MacroTemplate macroTemplate2 = ReportMacroViewModel.this.f13676g;
                    if (macroTemplate2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("macroTemplate");
                        macroTemplate2 = null;
                    }
                    int userId = macroTemplate2.getUserId();
                    MacroTemplate macroTemplate3 = ReportMacroViewModel.this.f13676g;
                    if (macroTemplate3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("macroTemplate");
                        macroTemplate3 = null;
                    }
                    String sha256 = StringExtensionsKt.sha256(userId + TemplateStoreApiKt.TEMPLATE_API_SALT + macroTemplate3.getId());
                    TemplateStoreApi templateStoreApi = ReportMacroViewModel.this.f13670a;
                    MacroTemplate macroTemplate4 = ReportMacroViewModel.this.f13676g;
                    if (macroTemplate4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("macroTemplate");
                        macroTemplate4 = null;
                    }
                    int id = macroTemplate4.getId();
                    MacroTemplate macroTemplate5 = ReportMacroViewModel.this.f13676g;
                    if (macroTemplate5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("macroTemplate");
                        macroTemplate5 = null;
                    }
                    int userId2 = macroTemplate5.getUserId();
                    this.label = 1;
                    if (templateStoreApi.deleteReports(sha256, id, userId2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                MacroTemplate macroTemplate6 = ReportMacroViewModel.this.f13676g;
                if (macroTemplate6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macroTemplate");
                    macroTemplate6 = null;
                }
                MacroTemplate flagCount = macroTemplate6.setFlagCount(0);
                LocalTemplateOverrideStore localTemplateOverrideStore = ReportMacroViewModel.this.f13671b;
                MacroTemplate macroTemplate7 = ReportMacroViewModel.this.f13676g;
                if (macroTemplate7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macroTemplate");
                } else {
                    macroTemplate = macroTemplate7;
                }
                localTemplateOverrideStore.addLocalOverride(macroTemplate.getId(), flagCount);
                ReportMacroViewModel.this.getUiEvent().postValue(UiEvent.CloseScreen.INSTANCE);
            } catch (Exception unused) {
                ReportMacroViewModel.this.getUiEvent().postValue(UiEvent.FailedOperationError.INSTANCE);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReportMacroViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new b(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            MacroTemplate macroTemplate = null;
            try {
                if (i4 != 0) {
                    if (i4 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    MacroTemplate macroTemplate2 = ReportMacroViewModel.this.f13676g;
                    if (macroTemplate2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("macroTemplate");
                        macroTemplate2 = null;
                    }
                    int userId = macroTemplate2.getUserId();
                    MacroTemplate macroTemplate3 = ReportMacroViewModel.this.f13676g;
                    if (macroTemplate3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("macroTemplate");
                        macroTemplate3 = null;
                    }
                    String sha256 = StringExtensionsKt.sha256(userId + TemplateStoreApiKt.TEMPLATE_API_SALT + macroTemplate3.getId());
                    TemplateStoreApi templateStoreApi = ReportMacroViewModel.this.f13670a;
                    MacroTemplate macroTemplate4 = ReportMacroViewModel.this.f13676g;
                    if (macroTemplate4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("macroTemplate");
                        macroTemplate4 = null;
                    }
                    int id = macroTemplate4.getId();
                    MacroTemplate macroTemplate5 = ReportMacroViewModel.this.f13676g;
                    if (macroTemplate5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("macroTemplate");
                        macroTemplate5 = null;
                    }
                    int userId2 = macroTemplate5.getUserId();
                    this.label = 1;
                    if (templateStoreApi.deleteMacroCoroutine(sha256, id, userId2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                LocalTemplateOverrideStore localTemplateOverrideStore = ReportMacroViewModel.this.f13671b;
                MacroTemplate macroTemplate6 = ReportMacroViewModel.this.f13676g;
                if (macroTemplate6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macroTemplate");
                    macroTemplate6 = null;
                }
                int id2 = macroTemplate6.getId();
                MacroTemplate macroTemplate7 = ReportMacroViewModel.this.f13676g;
                if (macroTemplate7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macroTemplate");
                } else {
                    macroTemplate = macroTemplate7;
                }
                localTemplateOverrideStore.addLocalOverride(id2, macroTemplate.setDeleted());
                ReportMacroViewModel.this.getUiEvent().postValue(UiEvent.CloseScreen.INSTANCE);
            } catch (Exception unused) {
                ReportMacroViewModel.this.getUiEvent().postValue(UiEvent.FailedOperationError.INSTANCE);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Inject
    public ReportMacroViewModel(@NotNull TemplateStoreApi templateStoreApi, @NotNull LocalTemplateOverrideStore localTemplateOverrideStore, @NotNull ReportMacroRepository reportMacroRepository) {
        Intrinsics.checkNotNullParameter(templateStoreApi, "templateStoreApi");
        Intrinsics.checkNotNullParameter(localTemplateOverrideStore, "localTemplateOverrideStore");
        Intrinsics.checkNotNullParameter(reportMacroRepository, "reportMacroRepository");
        this.f13670a = templateStoreApi;
        this.f13671b = localTemplateOverrideStore;
        this.f13672c = reportMacroRepository;
        MutableLiveData<MacroReportData> mutableLiveData = new MutableLiveData<>();
        this.f13673d = mutableLiveData;
        this.f13674e = mutableLiveData;
        this.f13675f = new SingleLiveEvent<>();
    }

    private final void a(MacroTemplate macroTemplate) {
        e.e(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new ReportMacroViewModel$getReportData$1(this, macroTemplate, null), 2, null);
    }

    public final void clearReports() {
        e.e(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new a(null), 2, null);
    }

    public final void deleteMacro() {
        e.e(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new b(null), 2, null);
    }

    @NotNull
    public final LiveData<MacroReportData> getMacroReportData() {
        return this.f13674e;
    }

    @NotNull
    public final SingleLiveEvent<UiEvent> getUiEvent() {
        return this.f13675f;
    }

    public final void setMacroTemplate(@NotNull MacroTemplate macroTemplate) {
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        this.f13676g = macroTemplate;
        a(macroTemplate);
    }
}
