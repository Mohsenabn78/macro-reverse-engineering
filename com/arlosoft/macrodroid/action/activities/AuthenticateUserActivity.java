package com.arlosoft.macrodroid.action.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.NonAppActivity;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableValue;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.Executor;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AuthenticateUserActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class AuthenticateUserActivity extends NonAppActivity {

    /* renamed from: d  reason: collision with root package name */
    private boolean f2788d;

    /* renamed from: e  reason: collision with root package name */
    private int f2789e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private TriggerContextInfo f2790f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private Stack<Integer> f2791g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private ResumeMacroInfo f2792h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2793i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private Macro f2794j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private SelectableItem f2795k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private BiometricPrompt f2796l;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: AuthenticateUserActivity.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void show(@NotNull Context context, @NotNull String title, @NotNull String subtitle, @Nullable String str, @Nullable DictionaryKeys dictionaryKeys, long j4, long j5, @Nullable TriggerContextInfo triggerContextInfo, int i4, @NotNull Stack<Integer> skipEndifIndexStack, boolean z3, boolean z4, boolean z5, @Nullable ResumeMacroInfo resumeMacroInfo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(subtitle, "subtitle");
            Intrinsics.checkNotNullParameter(skipEndifIndexStack, "skipEndifIndexStack");
            Intent intent = new Intent(context, AuthenticateUserActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("title", title);
            intent.putExtra("subtitle", subtitle);
            intent.putExtra("varName", str);
            intent.putExtra(VariableValuePrompt.EXTRA_DICTIONARY_KEYS, dictionaryKeys);
            intent.putExtra(Constants.EXTRA_MACRO_GUID, j4);
            intent.putExtra("selectableItemGuid", j5);
            intent.putExtra(Constants.EXTRA_TRIGGER_CONTEXT_INFO, triggerContextInfo);
            intent.putExtra(Constants.EXTRA_NEXT_ACTION_INDEX, i4);
            intent.putExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX, skipEndifIndexStack);
            intent.putExtra(Constants.EXTRA_IS_TEST, z3);
            intent.putExtra(Constants.EXTRA_FORCE_IF_NOT_ENABLED, z4);
            intent.putExtra(Constants.EXTRA_RESUME_MACRO_INFO, resumeMacroInfo);
            intent.putExtra("allowPinOrSwipe", z5);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(boolean z3, String str, DictionaryKeys dictionaryKeys) {
        List<String> emptyList;
        BiometricPrompt biometricPrompt = this.f2796l;
        if (biometricPrompt != null) {
            biometricPrompt.cancelAuthentication();
        }
        this.f2796l = null;
        SelectableItem selectableItem = this.f2795k;
        Intrinsics.checkNotNull(selectableItem);
        MacroDroidVariable variableByName = selectableItem.getVariableByName(str);
        SelectableItem selectableItem2 = this.f2795k;
        Intrinsics.checkNotNull(selectableItem2);
        if (dictionaryKeys == null || (emptyList = dictionaryKeys.getKeys()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        selectableItem2.variableUpdate(variableByName, new VariableValue.BooleanValue(z3, emptyList));
        Macro macro = this.f2794j;
        Intrinsics.checkNotNull(macro);
        Macro macro2 = this.f2794j;
        Intrinsics.checkNotNull(macro2);
        macro.invokeActions(macro2.getActions(), this.f2789e, this.f2790f, this.f2793i, this.f2791g, this.f2792h);
        finish();
    }

    private final void i(String str, String str2, final String str3, final DictionaryKeys dictionaryKeys, boolean z3) {
        int i4;
        BiometricManager from = BiometricManager.from(this);
        Intrinsics.checkNotNullExpressionValue(from, "from(this)");
        if (from.canAuthenticate(255) == 0) {
            i4 = 255;
        } else {
            i4 = 0;
        }
        if (from.canAuthenticate(32768) != 0) {
            i4 |= 32768;
        }
        if (i4 == 0) {
            ToastCompat.makeText(this, (int) R.string.device_does_not_support_authentication, 1).show();
            finish();
            return;
        }
        BiometricPrompt.PromptInfo.Builder confirmationRequired = new BiometricPrompt.PromptInfo.Builder().setTitle(str).setSubtitle(str2).setConfirmationRequired(true);
        Intrinsics.checkNotNullExpressionValue(confirmationRequired, "Builder()\n              …onfirmationRequired(true)");
        if (z3) {
            confirmationRequired.setAllowedAuthenticators(33023);
        } else {
            confirmationRequired.setNegativeButtonText(getString(17039360));
            confirmationRequired.setAllowedAuthenticators(255);
        }
        BiometricPrompt.PromptInfo build = confirmationRequired.build();
        Intrinsics.checkNotNullExpressionValue(build, "promptBuilder.build()");
        Executor mainExecutor = ContextCompat.getMainExecutor(this);
        Intrinsics.checkNotNullExpressionValue(mainExecutor, "getMainExecutor(this)");
        BiometricPrompt biometricPrompt = new BiometricPrompt(this, mainExecutor, new BiometricPrompt.AuthenticationCallback() { // from class: com.arlosoft.macrodroid.action.activities.AuthenticateUserActivity$showPinCode$1
            @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
            public void onAuthenticationError(int i5, @NotNull CharSequence errString) {
                Intrinsics.checkNotNullParameter(errString, "errString");
                super.onAuthenticationError(i5, errString);
                SystemLog.logError("Authenticate User action failed: " + ((Object) errString));
                AuthenticateUserActivity.this.h(false, str3, dictionaryKeys);
            }

            @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                AuthenticateUserActivity.this.h(false, str3, dictionaryKeys);
            }

            @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
            public void onAuthenticationSucceeded(@NotNull BiometricPrompt.AuthenticationResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                super.onAuthenticationSucceeded(result);
                AuthenticateUserActivity.this.h(true, str3, dictionaryKeys);
            }
        });
        this.f2796l = biometricPrompt;
        biometricPrompt.authenticate(build);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.NonAppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        String str;
        String str2;
        String str3;
        SelectableItem selectableItem;
        Stack<Integer> stack;
        List emptyList;
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("title");
        if (stringExtra == null) {
            str = "";
        } else {
            str = stringExtra;
        }
        String stringExtra2 = getIntent().getStringExtra("subtitle");
        if (stringExtra2 == null) {
            str2 = "";
        } else {
            str2 = stringExtra2;
        }
        String stringExtra3 = getIntent().getStringExtra("varName");
        if (stringExtra3 == null) {
            str3 = "";
        } else {
            str3 = stringExtra3;
        }
        DictionaryKeys dictionaryKeys = (DictionaryKeys) getIntent().getParcelableExtra(VariableValuePrompt.EXTRA_DICTIONARY_KEYS);
        if (dictionaryKeys == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            dictionaryKeys = new DictionaryKeys(emptyList);
        }
        DictionaryKeys dictionaryKeys2 = dictionaryKeys;
        boolean booleanExtra = getIntent().getBooleanExtra("allowPinOrSwipe", true);
        Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(getIntent().getLongExtra(Constants.EXTRA_MACRO_GUID, 0L));
        this.f2794j = macroByGUID;
        if (macroByGUID != null) {
            selectableItem = macroByGUID.findChildByGUID(getIntent().getLongExtra("selectableItemGuid", 0L));
        } else {
            selectableItem = null;
        }
        this.f2795k = selectableItem;
        this.f2788d = getIntent().getBooleanExtra(Constants.EXTRA_IS_TEST, false);
        Bundle extras = getIntent().getExtras();
        Intrinsics.checkNotNull(extras);
        this.f2789e = extras.getInt(Constants.EXTRA_NEXT_ACTION_INDEX);
        Bundle extras2 = getIntent().getExtras();
        Intrinsics.checkNotNull(extras2);
        this.f2790f = (TriggerContextInfo) extras2.getParcelable(Constants.EXTRA_TRIGGER_CONTEXT_INFO);
        this.f2792h = (ResumeMacroInfo) getIntent().getParcelableExtra(Constants.EXTRA_RESUME_MACRO_INFO);
        this.f2793i = getIntent().getBooleanExtra(Constants.EXTRA_FORCE_IF_NOT_ENABLED, false);
        if (getIntent().hasExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX)) {
            Serializable serializableExtra = getIntent().getSerializableExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX);
            Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.Int> }");
            stack = Util.deserializeStack((ArrayList) serializableExtra);
        } else {
            stack = new Stack<>();
        }
        this.f2791g = stack;
        if (this.f2794j != null && this.f2795k != null && this.f2790f != null) {
            i(str, str2, str3, dictionaryKeys2, booleanExtra);
            return;
        }
        SystemLog.logError("Could not find macro/context info in Authenticate User action");
        finish();
    }
}
