package com.arlosoft.macrodroid.upgrade;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.MacroDroidDialogBaseActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.email.api.UpgradeApi;
import com.arlosoft.macrodroid.common.SerialCalculator;
import com.arlosoft.macrodroid.databinding.ActivityUpgradeHelp2Binding;
import com.arlosoft.macrodroid.extensions.StringExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApiKt;
import com.arlosoft.macrodroid.upgrade.model.UpgradeResponse;
import com.google.android.gms.common.AccountPicker;
import com.tbruyelle.rxpermissions2.RxPermissions;
import dagger.android.AndroidInjection;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.anko.sdk27.coroutines.Sdk27CoroutinesListenersWithCoroutinesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.HttpException;

/* compiled from: UpgradeSupportActivity2.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nUpgradeSupportActivity2.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UpgradeSupportActivity2.kt\ncom/arlosoft/macrodroid/upgrade/UpgradeSupportActivity2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,339:1\n262#2,2:340\n*S KotlinDebug\n*F\n+ 1 UpgradeSupportActivity2.kt\ncom/arlosoft/macrodroid/upgrade/UpgradeSupportActivity2\n*L\n219#1:340,2\n*E\n"})
/* loaded from: classes3.dex */
public final class UpgradeSupportActivity2 extends MacroDroidDialogBaseActivity {
    public static final int $stable = 8;

    /* renamed from: d  reason: collision with root package name */
    private ActivityUpgradeHelp2Binding f15895d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private Account[] f15896e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final CompositeDisposable f15897f = new CompositeDisposable();

    /* renamed from: g  reason: collision with root package name */
    private boolean f15898g;
    @Inject
    public UpgradeApi upgradeApi;
    @Inject
    public UpgradeHelper upgradeHelper;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UpgradeSupportActivity2.kt */
    @SourceDebugExtension({"SMAP\nUpgradeSupportActivity2.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UpgradeSupportActivity2.kt\ncom/arlosoft/macrodroid/upgrade/UpgradeSupportActivity2$attemptUpgradeByApi$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,339:1\n262#2,2:340\n*S KotlinDebug\n*F\n+ 1 UpgradeSupportActivity2.kt\ncom/arlosoft/macrodroid/upgrade/UpgradeSupportActivity2$attemptUpgradeByApi$1\n*L\n226#1:340,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<UpgradeResponse, Unit> {
        final /* synthetic */ String $email;
        final /* synthetic */ String $serial;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, String str2) {
            super(1);
            this.$email = str;
            this.$serial = str2;
        }

        public final void a(UpgradeResponse upgradeResponse) {
            String component1 = upgradeResponse.component1();
            ActivityUpgradeHelp2Binding activityUpgradeHelp2Binding = UpgradeSupportActivity2.this.f15895d;
            if (activityUpgradeHelp2Binding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityUpgradeHelp2Binding = null;
            }
            RelativeLayout relativeLayout = activityUpgradeHelp2Binding.loadingView;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.loadingView");
            relativeLayout.setVisibility(8);
            String str = this.$email;
            String str2 = this.$serial;
            if (Intrinsics.areEqual(component1, StringExtensionsKt.sha256FromString(str + str2 + TemplateStoreApiKt.TEMPLATE_API_SALT + str2))) {
                Settings.setUpgradeSerial(UpgradeSupportActivity2.this, this.$serial);
                UpgradeSupportActivity2.this.getUpgradeHelper().showUpgradeSuccessDialog(UpgradeSupportActivity2.this, R.style.Theme_App_Dialog_Invert_Upgrade, this.$email, this.$serial);
                return;
            }
            SystemLog.logError("Invalid auth code from server when attempting to upgrade: " + component1);
            UpgradeSupportActivity2.this.getUpgradeHelper().showInvalidCredentialsDialog(UpgradeSupportActivity2.this, this.$email, R.style.Theme_App_Dialog_Invert_Upgrade);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(UpgradeResponse upgradeResponse) {
            a(upgradeResponse);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UpgradeSupportActivity2.kt */
    @SourceDebugExtension({"SMAP\nUpgradeSupportActivity2.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UpgradeSupportActivity2.kt\ncom/arlosoft/macrodroid/upgrade/UpgradeSupportActivity2$attemptUpgradeByApi$2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,339:1\n262#2,2:340\n*S KotlinDebug\n*F\n+ 1 UpgradeSupportActivity2.kt\ncom/arlosoft/macrodroid/upgrade/UpgradeSupportActivity2$attemptUpgradeByApi$2\n*L\n237#1:340,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ String $email;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.$email = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            ActivityUpgradeHelp2Binding activityUpgradeHelp2Binding = UpgradeSupportActivity2.this.f15895d;
            if (activityUpgradeHelp2Binding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityUpgradeHelp2Binding = null;
            }
            RelativeLayout relativeLayout = activityUpgradeHelp2Binding.loadingView;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.loadingView");
            relativeLayout.setVisibility(8);
            if (th instanceof HttpException) {
                if (((HttpException) th).code() == 403) {
                    UpgradeSupportActivity2.this.getUpgradeHelper().showActivationLimitReachedDialog(UpgradeSupportActivity2.this, this.$email, R.style.Theme_App_Dialog_Invert_Upgrade);
                    return;
                } else {
                    UpgradeSupportActivity2.this.getUpgradeHelper().showInvalidCredentialsDialog(UpgradeSupportActivity2.this, this.$email, R.style.Theme_App_Dialog_Invert_Upgrade);
                    return;
                }
            }
            UpgradeSupportActivity2.this.getUpgradeHelper().showGenericErrorDialog(UpgradeSupportActivity2.this, this.$email, R.style.Theme_App_Dialog_Invert_Upgrade);
        }
    }

    /* compiled from: UpgradeSupportActivity2.kt */
    /* loaded from: classes3.dex */
    static final class c extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        c(Continuation<? super c> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new c(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                UpgradeSupportActivity2.this.y(null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: UpgradeSupportActivity2.kt */
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
                UpgradeSupportActivity2.this.u();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: UpgradeSupportActivity2.kt */
    /* loaded from: classes3.dex */
    static final class e extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
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
                UpgradeSupportActivity2.this.t();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: UpgradeSupportActivity2.kt */
    /* loaded from: classes3.dex */
    static final class f extends SuspendLambda implements Function4<CoroutineScope, View, Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;

        f(Continuation<? super f> continuation) {
            super(4, continuation);
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @NotNull View view, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            f fVar = new f(continuation);
            fVar.Z$0 = z3;
            return fVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, View view, Boolean bool, Continuation<? super Unit> continuation) {
            return a(coroutineScope, view, bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.Z$0 && !UpgradeSupportActivity2.this.f15898g) {
                    UpgradeSupportActivity2.this.w();
                    UpgradeSupportActivity2.this.f15898g = true;
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UpgradeSupportActivity2.kt */
    /* loaded from: classes3.dex */
    public static final class g extends Lambda implements Function1<Boolean, Unit> {
        g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean granted) {
            Intrinsics.checkNotNullExpressionValue(granted, "granted");
            if (granted.booleanValue()) {
                UpgradeSupportActivity2.this.v();
                Account[] accountArr = UpgradeSupportActivity2.this.f15896e;
                if (accountArr != null) {
                    UpgradeSupportActivity2 upgradeSupportActivity2 = UpgradeSupportActivity2.this;
                    if (!(accountArr.length == 0)) {
                        ActivityUpgradeHelp2Binding activityUpgradeHelp2Binding = upgradeSupportActivity2.f15895d;
                        if (activityUpgradeHelp2Binding == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            activityUpgradeHelp2Binding = null;
                        }
                        activityUpgradeHelp2Binding.upgradeEmail.setText(accountArr[0].name);
                    }
                }
            }
        }
    }

    private final void A() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog_Invert_Upgrade);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.upgrade.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                UpgradeSupportActivity2.B(UpgradeSupportActivity2.this, dialogInterface, i4);
            }
        });
        builder.setTitle(R.string.no_purchase_found_title);
        builder.setMessage(R.string.clear_data_play_store_app_details);
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(UpgradeSupportActivity2 this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:com.android.vending"));
            this$0.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            this$0.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        }
    }

    private final void n(String str) {
        final boolean z3;
        String string = Settings.Secure.getString(getContentResolver(), "android_id");
        String calculateSerialCode = SerialCalculator.calculateSerialCode(str);
        String calculateSerialCode2 = SerialCalculator.calculateSerialCode(string);
        ActivityUpgradeHelp2Binding activityUpgradeHelp2Binding = this.f15895d;
        if (activityUpgradeHelp2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpgradeHelp2Binding = null;
        }
        String valueOf = String.valueOf(activityUpgradeHelp2Binding.upgradeSerial.getText());
        if (!Intrinsics.areEqual(valueOf, calculateSerialCode) && !Intrinsics.areEqual(valueOf, calculateSerialCode2)) {
            z3 = false;
        } else {
            com.arlosoft.macrodroid.settings.Settings.setUpgradeSerial(this, valueOf);
            z3 = true;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog_Invert_Upgrade);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.upgrade.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                UpgradeSupportActivity2.o(z3, this, dialogInterface, i4);
            }
        });
        if (z3) {
            builder.setTitle(R.string.upgrade_complete);
            builder.setMessage(R.string.thanks_for_purchasing);
            setResult(-1);
        } else {
            builder.setTitle(R.string.invalid_serial);
            builder.setMessage(R.string.value_entered_is_not_recognised);
            setResult(0);
        }
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(boolean z3, UpgradeSupportActivity2 this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        if (z3) {
            this$0.finish();
        }
    }

    private final void p(String str, String str2) {
        String sha256FromString = StringExtensionsKt.sha256FromString(TemplateStoreApiKt.TEMPLATE_API_SALT + str2 + str);
        ActivityUpgradeHelp2Binding activityUpgradeHelp2Binding = this.f15895d;
        if (activityUpgradeHelp2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpgradeHelp2Binding = null;
        }
        RelativeLayout relativeLayout = activityUpgradeHelp2Binding.loadingView;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.loadingView");
        relativeLayout.setVisibility(0);
        CompositeDisposable compositeDisposable = this.f15897f;
        Single<UpgradeResponse> observeOn = getUpgradeApi().activatePro(sha256FromString, str, str2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final a aVar = new a(str, str2);
        Consumer<? super UpgradeResponse> consumer = new Consumer() { // from class: com.arlosoft.macrodroid.upgrade.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UpgradeSupportActivity2.q(Function1.this, obj);
            }
        };
        final b bVar = new b(str);
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: com.arlosoft.macrodroid.upgrade.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UpgradeSupportActivity2.r(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean s() {
        boolean z3;
        String androidId = Settings.Secure.getString(getContentResolver(), "android_id");
        String calculateSerialCode = SerialCalculator.calculateSerialCode(androidId);
        ActivityUpgradeHelp2Binding activityUpgradeHelp2Binding = this.f15895d;
        if (activityUpgradeHelp2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpgradeHelp2Binding = null;
        }
        String valueOf = String.valueOf(activityUpgradeHelp2Binding.upgradeSerial.getText());
        if (Intrinsics.areEqual(valueOf, calculateSerialCode)) {
            com.arlosoft.macrodroid.settings.Settings.setUpgradeSerial(this, valueOf);
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            UpgradeHelper upgradeHelper = getUpgradeHelper();
            Intrinsics.checkNotNullExpressionValue(androidId, "androidId");
            upgradeHelper.showUpgradeSuccessDialog(this, R.style.Theme_App_Dialog_Invert_Upgrade, androidId, valueOf);
        }
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void u() {
        /*
            r7 = this;
            boolean r0 = r7.s()
            if (r0 == 0) goto L7
            return
        L7:
            com.arlosoft.macrodroid.databinding.ActivityUpgradeHelp2Binding r0 = r7.f15895d
            r1 = 0
            java.lang.String r2 = "binding"
            if (r0 != 0) goto L12
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r1
        L12:
            androidx.appcompat.widget.AppCompatEditText r0 = r0.upgradeSerial
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            com.arlosoft.macrodroid.databinding.ActivityUpgradeHelp2Binding r3 = r7.f15895d
            if (r3 != 0) goto L24
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L25
        L24:
            r1 = r3
        L25:
            androidx.appcompat.widget.AppCompatEditText r1 = r1.upgradeEmail
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "android.permission.GET_ACCOUNTS"
            int r2 = androidx.core.content.ContextCompat.checkSelfPermission(r7, r2)
            java.lang.String r3 = "this as java.lang.String).toLowerCase(Locale.ROOT)"
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L75
            int r2 = r0.length()
            if (r2 <= 0) goto L43
            r2 = 1
            goto L44
        L43:
            r2 = 0
        L44:
            if (r2 == 0) goto Le6
            int r2 = r1.length()
            if (r2 <= 0) goto L4d
            goto L4e
        L4d:
            r4 = 0
        L4e:
            if (r4 == 0) goto Le6
            java.util.Locale r2 = java.util.Locale.ROOT
            java.lang.String r1 = r1.toLowerCase(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            java.lang.CharSequence r1 = kotlin.text.StringsKt.trim(r1)
            java.lang.String r1 = r1.toString()
            java.lang.String r0 = r0.toLowerCase(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            java.lang.CharSequence r0 = kotlin.text.StringsKt.trim(r0)
            java.lang.String r0 = r0.toString()
            r7.p(r1, r0)
            goto Le6
        L75:
            int r2 = r0.length()
            if (r2 <= 0) goto L7d
            r2 = 1
            goto L7e
        L7d:
            r2 = 0
        L7e:
            if (r2 == 0) goto Ldc
            android.accounts.Account[] r2 = r7.f15896e
            if (r2 == 0) goto L8f
            int r6 = r2.length
            if (r6 != 0) goto L89
            r6 = 1
            goto L8a
        L89:
            r6 = 0
        L8a:
            r6 = r6 ^ r4
            if (r6 != r4) goto L8f
            r6 = 1
            goto L90
        L8f:
            r6 = 0
        L90:
            if (r6 == 0) goto La3
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r2 = r2[r5]
            java.lang.String r2 = r2.name
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r2 == 0) goto La3
            r7.n(r1)
            goto Le6
        La3:
            int r2 = r1.length()
            if (r2 <= 0) goto Laa
            goto Lab
        Laa:
            r4 = 0
        Lab:
            if (r4 == 0) goto Ld1
            java.util.Locale r2 = java.util.Locale.ROOT
            java.lang.String r1 = r1.toLowerCase(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            java.lang.CharSequence r1 = kotlin.text.StringsKt.trim(r1)
            java.lang.String r1 = r1.toString()
            java.lang.String r0 = r0.toLowerCase(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            java.lang.CharSequence r0 = kotlin.text.StringsKt.trim(r0)
            java.lang.String r0 = r0.toString()
            r7.p(r1, r0)
            goto Le6
        Ld1:
            r0 = 2131953278(0x7f13067e, float:1.9543022E38)
            android.widget.Toast r0 = me.drakeet.support.toast.ToastCompat.makeText(r7, r0, r5)
            r0.show()
            goto Le6
        Ldc:
            r0 = 2131953298(0x7f130692, float:1.9543063E38)
            android.widget.Toast r0 = me.drakeet.support.toast.ToastCompat.makeText(r7, r0, r5)
            r0.show()
        Le6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.upgrade.UpgradeSupportActivity2.u():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        this.f15896e = AccountManager.get(this).getAccountsByType("com.google");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Intent newChooseAccountIntent = AccountPicker.newChooseAccountIntent(null, null, new String[]{"com.google"}, false, null, null, null, null);
                Intrinsics.checkNotNullExpressionValue(newChooseAccountIntent, "newChooseAccountIntent(n…, null, null, null, null)");
                startActivityForResult(newChooseAccountIntent, 3);
                return;
            } catch (ActivityNotFoundException unused) {
                return;
            }
        }
        RxPermissions rxPermissions = new RxPermissions(this);
        CompositeDisposable compositeDisposable = this.f15897f;
        Observable<Boolean> observeOn = rxPermissions.request("android.permission.GET_ACCOUNTS").observeOn(AndroidSchedulers.mainThread());
        final g gVar = new g();
        compositeDisposable.add(observeOn.subscribe(new Consumer() { // from class: com.arlosoft.macrodroid.upgrade.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UpgradeSupportActivity2.x(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(String str) {
        String str2;
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog_Invert_Upgrade);
        builder.setTitle(R.string.request_upgrade_support);
        View inflate = LayoutInflater.from(new ContextThemeWrapper(this, (int) R.style.Theme_App_Dialog_Invert_Upgrade)).inflate(R.layout.dialog_email, (ViewGroup) null);
        builder.setView(inflate);
        final EditText editText = (EditText) inflate.findViewById(R.id.email);
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        editText.setText(str2);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.upgrade.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                UpgradeSupportActivity2.z(UpgradeSupportActivity2.this, editText, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        Window window = create.getWindow();
        if (window != null) {
            window.setSoftInputMode(4);
        }
        create.show();
        final Button button = create.getButton(-1);
        button.setEnabled(isValidEmail(str));
        editText.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.upgrade.UpgradeSupportActivity2$showEmailDialog$2
            @Override // android.text.TextWatcher
            public void afterTextChanged(@NotNull Editable s3) {
                Intrinsics.checkNotNullParameter(s3, "s");
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@NotNull CharSequence s3, int i4, int i5, int i6) {
                Intrinsics.checkNotNullParameter(s3, "s");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@NotNull CharSequence s3, int i4, int i5, int i6) {
                Intrinsics.checkNotNullParameter(s3, "s");
                button.setEnabled(this.isValidEmail(s3.toString()));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(UpgradeSupportActivity2 this$0, EditText editText, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object systemService = this$0.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(editText.getWindowToken(), 0);
        UpgradeHelper upgradeHelper = this$0.getUpgradeHelper();
        String obj = editText.getText().toString();
        ActivityUpgradeHelp2Binding activityUpgradeHelp2Binding = this$0.f15895d;
        if (activityUpgradeHelp2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpgradeHelp2Binding = null;
        }
        RelativeLayout relativeLayout = activityUpgradeHelp2Binding.loadingView;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.loadingView");
        upgradeHelper.generateSupportEmail(obj, this$0, relativeLayout);
    }

    @NotNull
    public final UpgradeApi getUpgradeApi() {
        UpgradeApi upgradeApi = this.upgradeApi;
        if (upgradeApi != null) {
            return upgradeApi;
        }
        Intrinsics.throwUninitializedPropertyAccessException("upgradeApi");
        return null;
    }

    @NotNull
    public final UpgradeHelper getUpgradeHelper() {
        UpgradeHelper upgradeHelper = this.upgradeHelper;
        if (upgradeHelper != null) {
            return upgradeHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("upgradeHelper");
        return null;
    }

    public final boolean isValidEmail(@Nullable String str) {
        if (!TextUtils.isEmpty(str) && Patterns.EMAIL_ADDRESS.matcher(str).matches()) {
            return true;
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        super.onActivityResult(i4, i5, intent);
        ActivityUpgradeHelp2Binding activityUpgradeHelp2Binding = null;
        if (i4 == 2) {
            if (i5 == -1) {
                Intrinsics.checkNotNull(intent);
                y(intent.getStringExtra("authAccount"));
                return;
            }
            y(null);
        } else if (i4 == 3 && i5 == -1) {
            ActivityUpgradeHelp2Binding activityUpgradeHelp2Binding2 = this.f15895d;
            if (activityUpgradeHelp2Binding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityUpgradeHelp2Binding = activityUpgradeHelp2Binding2;
            }
            AppCompatEditText appCompatEditText = activityUpgradeHelp2Binding.upgradeEmail;
            Intrinsics.checkNotNull(intent);
            appCompatEditText.setText(intent.getStringExtra("authAccount"));
        }
    }

    @Override // com.arlosoft.macrodroid.MacroDroidDialogBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityUpgradeHelp2Binding inflate = ActivityUpgradeHelp2Binding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f15895d = inflate;
        AndroidInjection.inject(this);
        supportRequestWindowFeature(1);
        ActivityUpgradeHelp2Binding activityUpgradeHelp2Binding = this.f15895d;
        if (activityUpgradeHelp2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpgradeHelp2Binding = null;
        }
        setContentView(activityUpgradeHelp2Binding.getRoot());
        getWindow().setLayout(-1, -2);
        ActivityUpgradeHelp2Binding activityUpgradeHelp2Binding2 = this.f15895d;
        if (activityUpgradeHelp2Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpgradeHelp2Binding2 = null;
        }
        Button button = activityUpgradeHelp2Binding2.requestUpgradeSupportButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.requestUpgradeSupportButton");
        ViewExtensionsKt.onClick$default(button, null, new c(null), 1, null);
        ActivityUpgradeHelp2Binding activityUpgradeHelp2Binding3 = this.f15895d;
        if (activityUpgradeHelp2Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpgradeHelp2Binding3 = null;
        }
        Button button2 = activityUpgradeHelp2Binding3.upgradeButton;
        Intrinsics.checkNotNullExpressionValue(button2, "binding.upgradeButton");
        ViewExtensionsKt.onClick$default(button2, null, new d(null), 1, null);
        ActivityUpgradeHelp2Binding activityUpgradeHelp2Binding4 = this.f15895d;
        if (activityUpgradeHelp2Binding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpgradeHelp2Binding4 = null;
        }
        Button button3 = activityUpgradeHelp2Binding4.restorePurchaseButton;
        Intrinsics.checkNotNullExpressionValue(button3, "binding.restorePurchaseButton");
        ViewExtensionsKt.onClick$default(button3, null, new e(null), 1, null);
        ActivityUpgradeHelp2Binding activityUpgradeHelp2Binding5 = this.f15895d;
        if (activityUpgradeHelp2Binding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpgradeHelp2Binding5 = null;
        }
        AppCompatEditText appCompatEditText = activityUpgradeHelp2Binding5.upgradeEmail;
        Intrinsics.checkNotNullExpressionValue(appCompatEditText, "binding.upgradeEmail");
        Sdk27CoroutinesListenersWithCoroutinesKt.onFocusChange$default(appCompatEditText, null, new f(null), 1, null);
    }

    @Override // com.arlosoft.macrodroid.MacroDroidDialogBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f15897f.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = Math.max(attributes.width, (getResources().getDisplayMetrics().widthPixels * 90) / 100);
        getWindow().setAttributes(attributes);
    }

    public final void setUpgradeApi(@NotNull UpgradeApi upgradeApi) {
        Intrinsics.checkNotNullParameter(upgradeApi, "<set-?>");
        this.upgradeApi = upgradeApi;
    }

    public final void setUpgradeHelper(@NotNull UpgradeHelper upgradeHelper) {
        Intrinsics.checkNotNullParameter(upgradeHelper, "<set-?>");
        this.upgradeHelper = upgradeHelper;
    }
}
