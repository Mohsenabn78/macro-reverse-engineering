package com.arlosoft.macrodroid.action.activities;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.BuildConfig;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MacroDroidVariableStore;
import com.arlosoft.macrodroid.common.NonAppActivity;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.MacroListUtils;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VoiceInputActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class VoiceInputActivity extends NonAppActivity {
    @NotNull
    public static final String EXTRA_VARIABLE_NAME = "variable_name";
    public static final int REQUEST_CODE = 1;

    /* renamed from: d  reason: collision with root package name */
    private String f2965d;

    /* renamed from: e  reason: collision with root package name */
    private long f2966e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2967f;

    /* renamed from: g  reason: collision with root package name */
    private int f2968g;

    /* renamed from: h  reason: collision with root package name */
    private Stack<Integer> f2969h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2970i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private ResumeMacroInfo f2971j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private TriggerContextInfo f2972k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private Trigger f2973l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private DictionaryKeys f2974m;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: VoiceInputActivity.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final MacroDroidVariable h(Macro macro, String str) {
        for (MacroDroidVariable macroDroidVariable : macro.getLocalVariables()) {
            if (Intrinsics.areEqual(macroDroidVariable.getName(), str)) {
                return macroDroidVariable;
            }
        }
        return MacroDroidVariableStore.getInstance().getVariableByName(str);
    }

    private final void i(Macro macro) {
        Stack<Integer> stack;
        Stack<Integer> stack2 = this.f2969h;
        if (stack2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skipEndifIndexStack");
            stack2 = null;
        }
        if (!stack2.isEmpty()) {
            Stack<Integer> stack3 = this.f2969h;
            if (stack3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("skipEndifIndexStack");
                stack3 = null;
            }
            Integer peek = stack3.peek();
            if (peek != null && peek.intValue() == 0) {
                Stack<Integer> stack4 = this.f2969h;
                if (stack4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("skipEndifIndexStack");
                    stack4 = null;
                }
                stack4.pop();
            }
        }
        int endIfIndex = MacroListUtils.getEndIfIndex(macro.getActions(), this.f2968g - 1);
        Stack<Integer> stack5 = this.f2969h;
        if (stack5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skipEndifIndexStack");
            stack5 = null;
        }
        stack5.push(Integer.valueOf(endIfIndex));
        finish();
        if (!this.f2970i) {
            macro.setTriggerThatInvoked(this.f2973l);
            ArrayList<Action> actions = macro.getActions();
            int i4 = this.f2968g;
            TriggerContextInfo triggerContextInfo = this.f2972k;
            boolean z3 = this.f2967f;
            Stack<Integer> stack6 = this.f2969h;
            if (stack6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("skipEndifIndexStack");
                stack = null;
            } else {
                stack = stack6;
            }
            macro.invokeActions(actions, i4, triggerContextInfo, z3, stack, this.f2971j);
        }
    }

    private final void j(List<String> list) {
        boolean z3;
        List<String> emptyList;
        Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(this.f2966e);
        if (macroByGUID == null) {
            SystemLog.logError("Macro not found for voice input prompt: " + this.f2966e, this.f2966e);
            finish();
            return;
        }
        List<String> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            SystemLog.logWarning("No text identified");
        } else {
            String str = this.f2965d;
            String str2 = null;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("varName");
                str = null;
            }
            MacroDroidVariable h4 = h(macroByGUID, str);
            if (h4 == null) {
                String str3 = this.f2965d;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("varName");
                } else {
                    str2 = str3;
                }
                SystemLog.logError("No variable found with name: " + str2, this.f2966e);
            } else {
                DictionaryKeys dictionaryKeys = this.f2974m;
                if (dictionaryKeys == null || (emptyList = dictionaryKeys.getKeys()) == null) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                }
                macroByGUID.variableUpdate(h4, new VariableValue.StringValue(list.get(0), VariableHelper.applyMagicTextToDictionaryKeys(this, emptyList, this.f2972k, macroByGUID)));
            }
        }
        i(macroByGUID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        if (i4 == 1) {
            if (i5 == -1 && intent != null) {
                j(intent.getStringArrayListExtra("android.speech.extra.RESULTS"));
            } else if (i5 == 0) {
                finish();
            }
        }
        super.onActivityResult(i4, i5, intent);
    }

    @Override // com.arlosoft.macrodroid.common.NonAppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        boolean z3;
        Stack<Integer> stack;
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra(EXTRA_VARIABLE_NAME);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.f2965d = stringExtra;
        this.f2966e = getIntent().getLongExtra(Constants.EXTRA_MACRO_GUID, -1L);
        Bundle extras = getIntent().getExtras();
        int i4 = 0;
        if (extras != null) {
            z3 = extras.getBoolean(Constants.EXTRA_IS_TEST);
        } else {
            z3 = false;
        }
        this.f2970i = z3;
        Bundle extras2 = getIntent().getExtras();
        if (extras2 != null) {
            i4 = extras2.getInt(Constants.EXTRA_NEXT_ACTION_INDEX);
        }
        this.f2968g = i4;
        if (getIntent().hasExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX)) {
            Serializable serializableExtra = getIntent().getSerializableExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX);
            Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>");
            stack = Util.deserializeStack((ArrayList) serializableExtra);
            Intrinsics.checkNotNullExpressionValue(stack, "{\n            Util.deser…ArrayList<Int>)\n        }");
        } else {
            stack = new Stack<>();
        }
        this.f2969h = stack;
        this.f2972k = (TriggerContextInfo) getIntent().getParcelableExtra(Constants.EXTRA_TRIGGER_CONTEXT_INFO);
        this.f2973l = (Trigger) getIntent().getParcelableExtra(Constants.EXTRA_TRIGGER_THAT_INVOKED);
        this.f2971j = (ResumeMacroInfo) getIntent().getParcelableExtra(Constants.EXTRA_RESUME_MACRO_INFO);
        this.f2974m = (DictionaryKeys) getIntent().getParcelableExtra("dictionary_keys");
        try {
            Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
            intent.putExtra("calling_package", BuildConfig.APPLICATION_ID);
            intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
            intent.putExtra("android.speech.extra.MAX_RESULTS", 1);
            startActivityForResult(intent, 1);
        } catch (ActivityNotFoundException unused) {
            String string = getString(R.string.feature_requires_google_app_installed);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.featu…res_google_app_installed)");
            SystemLog.logError(string);
            ToastCompat.makeText((Context) this, (CharSequence) getString(R.string.feature_requires_google_app_installed), 1).show();
            try {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.android.googlequicksearchbox")));
            } catch (ActivityNotFoundException unused2) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.googlequicksearchbox")));
            }
        }
    }
}
