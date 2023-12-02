package com.arlosoft.macrodroid.confirmation.validation;

import android.app.Activity;
import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.email.api.UpgradeApi;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.extensions.StringExtensionsKt;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApiKt;
import com.arlosoft.macrodroid.upgrade.UpgradeHelper;
import com.arlosoft.macrodroid.upgrade.model.UpgradeResponse;
import com.arlosoft.macrodroid.utils.SingleLiveEvent;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ValidatePurchaseViewModel.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ValidatePurchaseViewModel extends ViewModel {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final UpgradeApi f10135a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final UpgradeHelper f10136b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Context f10137c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final MutableLiveData<Boolean> f10138d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final LiveData<Boolean> f10139e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final SingleLiveEvent<Void> f10140f;

    /* compiled from: ValidatePurchaseViewModel.kt */
    /* loaded from: classes3.dex */
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ String $auth;
        final /* synthetic */ String $email;
        final /* synthetic */ String $serial;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ValidatePurchaseViewModel.kt */
        /* renamed from: com.arlosoft.macrodroid.confirmation.validation.ValidatePurchaseViewModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0096a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Activity $activity;
            final /* synthetic */ String $email;
            int label;
            final /* synthetic */ ValidatePurchaseViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0096a(ValidatePurchaseViewModel validatePurchaseViewModel, Activity activity, String str, Continuation<? super C0096a> continuation) {
                super(2, continuation);
                this.this$0 = validatePurchaseViewModel;
                this.$activity = activity;
                this.$email = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C0096a(this.this$0, this.$activity, this.$email, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.f10136b.showInvalidCredentialsDialog(this.$activity, this.$email, R.style.Theme_App_Dialog_Invert_Upgrade);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((C0096a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ValidatePurchaseViewModel.kt */
        /* loaded from: classes3.dex */
        public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Activity $activity;
            final /* synthetic */ String $email;
            int label;
            final /* synthetic */ ValidatePurchaseViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(ValidatePurchaseViewModel validatePurchaseViewModel, Activity activity, String str, Continuation<? super b> continuation) {
                super(2, continuation);
                this.this$0 = validatePurchaseViewModel;
                this.$activity = activity;
                this.$email = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new b(this.this$0, this.$activity, this.$email, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.f10136b.showInvalidCredentialsDialog(this.$activity, this.$email, R.style.Theme_App_Dialog_Invert_Upgrade);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, String str2, String str3, Activity activity, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$auth = str;
            this.$email = str2;
            this.$serial = str3;
            this.$activity = activity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(this.$auth, this.$email, this.$serial, this.$activity, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            try {
            } catch (Exception unused) {
                String str = this.$serial;
                SystemLog.logError("Failed to validate serial: " + str);
                MainCoroutineDispatcher main = Dispatchers.getMain();
                b bVar = new b(ValidatePurchaseViewModel.this, this.$activity, this.$email, null);
                this.label = 3;
                if (BuildersKt.withContext(main, bVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 == 3) {
                            ResultKt.throwOnFailure(obj);
                            ValidatePurchaseViewModel.this.f10138d.postValue(Boxing.boxBoolean(false));
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    ValidatePurchaseViewModel.this.f10138d.postValue(Boxing.boxBoolean(false));
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                ValidatePurchaseViewModel.this.f10138d.postValue(Boxing.boxBoolean(true));
                UpgradeApi upgradeApi = ValidatePurchaseViewModel.this.f10135a;
                String str2 = this.$auth;
                String str3 = this.$email;
                String str4 = this.$serial;
                this.label = 1;
                obj = upgradeApi.activateProCoroutine(str2, str3, str4, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            UpgradeResponse upgradeResponse = (UpgradeResponse) obj;
            String str5 = this.$email;
            String str6 = this.$serial;
            if (Intrinsics.areEqual(upgradeResponse.getUpgradeAuth(), StringExtensionsKt.sha256FromString(str5 + str6 + TemplateStoreApiKt.TEMPLATE_API_SALT + str6))) {
                Settings.setUpgradeSerial(this.$activity, this.$serial);
                Settings.setPurchaseInvalidated(this.$activity, false);
                Settings.setShowValidationWarning(ValidatePurchaseViewModel.this.f10137c, false);
                ValidatePurchaseViewModel.this.getPurchaseValidatedEvent().postValue(null);
            } else {
                String upgradeAuth = upgradeResponse.getUpgradeAuth();
                SystemLog.logError("Invalid auth code from server when attempting to upgrade: " + upgradeAuth);
                MainCoroutineDispatcher main2 = Dispatchers.getMain();
                C0096a c0096a = new C0096a(ValidatePurchaseViewModel.this, this.$activity, this.$email, null);
                this.label = 2;
                if (BuildersKt.withContext(main2, c0096a, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            ValidatePurchaseViewModel.this.f10138d.postValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Inject
    public ValidatePurchaseViewModel(@NotNull UpgradeApi upgradeApi, @NotNull UpgradeHelper upgradeHelper, @ApplicationContext @NotNull Context context) {
        Intrinsics.checkNotNullParameter(upgradeApi, "upgradeApi");
        Intrinsics.checkNotNullParameter(upgradeHelper, "upgradeHelper");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f10135a = upgradeApi;
        this.f10136b = upgradeHelper;
        this.f10137c = context;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(Boolean.FALSE);
        this.f10138d = mutableLiveData;
        this.f10139e = mutableLiveData;
        this.f10140f = new SingleLiveEvent<>();
    }

    @NotNull
    public final LiveData<Boolean> getLoadingBlockerActive() {
        return this.f10139e;
    }

    @NotNull
    public final SingleLiveEvent<Void> getPurchaseValidatedEvent() {
        return this.f10140f;
    }

    public final void onRevertToFreeClicked() {
        Settings.setShowValidationWarning(this.f10137c, false);
        Settings.setUpgradeSerial(this.f10137c, null);
        Settings.setProDefault(this.f10137c, false);
    }

    public final void onUpgradeWithSerial(@NotNull Activity activity, @NotNull String email, @NotNull String serial) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(serial, "serial");
        e.e(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new a(StringExtensionsKt.sha256FromString(TemplateStoreApiKt.TEMPLATE_API_SALT + serial + email), email, serial, activity, null), 2, null);
    }
}
