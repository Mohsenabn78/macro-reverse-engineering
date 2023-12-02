package com.arlosoft.macrodroid.action.activities;

import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MacroDroidVariableStore;
import com.arlosoft.macrodroid.common.NonAppActivity;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.UIUtils;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* loaded from: classes2.dex */
public class VariableValuePrompt extends NonAppActivity {
    public static final String EXTRA_DARK_MODE = "darkMode";
    public static final String EXTRA_DICTIONARY_KEYS = "dictionaryKeys";
    public static final String EXTRA_DICTIONARY_OR_ARRAY_TYPE = "dictionaryOrArrayType";
    public static final String EXTRA_FALSE_LABEL = "falseLabel";
    public static final String EXTRA_INITIALISE_EMPTY = "initialiseEmpty";
    public static final String EXTRA_MESSAGE = "message";
    public static final String EXTRA_PASSWORD_MASK = "passwordMask";
    public static final String EXTRA_SHOW_CANCEL = "showCancel";
    public static final String EXTRA_STOP_AFTER_CANCEL = "stopAfterCancel";
    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_TRUE_LABEL = "trueLabel";
    public static final String EXTRA_VARIABLE_NAME = "variableName";

    /* renamed from: d  reason: collision with root package name */
    private Macro f2948d;

    /* renamed from: e  reason: collision with root package name */
    private int f2949e;

    /* renamed from: f  reason: collision with root package name */
    private Stack<Integer> f2950f;

    /* renamed from: g  reason: collision with root package name */
    private TriggerContextInfo f2951g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2952h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2953i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f2954j;

    /* renamed from: k  reason: collision with root package name */
    private ResumeMacroInfo f2955k;

    /* renamed from: l  reason: collision with root package name */
    private EditText f2956l;

    /* renamed from: m  reason: collision with root package name */
    private RadioButton f2957m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VariableValuePrompt variableValuePrompt = VariableValuePrompt.this;
            variableValuePrompt.u(variableValuePrompt.f2948d, VariableValuePrompt.this.f2949e, VariableValuePrompt.this.f2951g, VariableValuePrompt.this.f2952h, VariableValuePrompt.this.f2950f, VariableValuePrompt.this.f2955k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VariableValuePrompt variableValuePrompt = VariableValuePrompt.this;
            variableValuePrompt.u(variableValuePrompt.f2948d, VariableValuePrompt.this.f2949e, VariableValuePrompt.this.f2951g, VariableValuePrompt.this.f2952h, VariableValuePrompt.this.f2950f, VariableValuePrompt.this.f2955k);
        }
    }

    /* loaded from: classes2.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((InputMethodManager) VariableValuePrompt.this.getSystemService("input_method")).showSoftInput(VariableValuePrompt.this.f2956l, 1);
        }
    }

    /* loaded from: classes2.dex */
    class e extends OnBackPressedCallback {
        e(boolean z3) {
            super(z3);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            if (!VariableValuePrompt.this.f2953i) {
                return;
            }
            if (!VariableValuePrompt.this.f2954j) {
                VariableValuePrompt variableValuePrompt = VariableValuePrompt.this;
                variableValuePrompt.u(variableValuePrompt.f2948d, VariableValuePrompt.this.f2949e, VariableValuePrompt.this.f2951g, VariableValuePrompt.this.f2952h, VariableValuePrompt.this.f2950f, VariableValuePrompt.this.f2955k);
            }
            VariableValuePrompt.this.finish();
        }
    }

    private MacroDroidVariable t(Macro macro, String str) {
        if (macro != null) {
            for (MacroDroidVariable macroDroidVariable : macro.getLocalVariables()) {
                if (macroDroidVariable.getName().equals(str)) {
                    return macroDroidVariable;
                }
            }
        }
        return MacroDroidVariableStore.getInstance().getVariableByName(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Macro macro, int i4, TriggerContextInfo triggerContextInfo, boolean z3, Stack<Integer> stack, @Nullable ResumeMacroInfo resumeMacroInfo) {
        if (macro != null && i4 != -1) {
            macro.invokeActions(macro.getActions(), i4, triggerContextInfo, z3, stack, resumeMacroInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(MacroDroidVariable macroDroidVariable, int i4, ArrayList arrayList, int i5, View view) {
        finish();
        if (macroDroidVariable.getType() == 0) {
            this.f2948d.variableUpdate(macroDroidVariable, new VariableValue.BooleanValue(this.f2957m.isChecked(), null));
        } else if (macroDroidVariable.getType() != 1 && macroDroidVariable.getType() != 3 && macroDroidVariable.getType() != 2) {
            if (macroDroidVariable.getType() == 4 || macroDroidVariable.getType() == 5) {
                macroDroidVariable.getDictionaryEntryFromKeyList(arrayList);
                x(this.f2948d, macroDroidVariable, i5, VariableHelper.applyMagicTextToDictionaryKeys(this, arrayList, this.f2951g, this.f2948d), this.f2951g);
            }
        } else {
            this.f2948d.variableUpdate(macroDroidVariable, VariableValue.fromTextValueForType(this.f2956l.getText().toString(), i4, null));
        }
        new Handler(Looper.getMainLooper()).post(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(View view) {
        finish();
        if (!this.f2954j) {
            new Handler(Looper.getMainLooper()).post(new c());
        }
    }

    private void x(Macro macro, MacroDroidVariable macroDroidVariable, int i4, List<String> list, TriggerContextInfo triggerContextInfo) {
        if (i4 == 0) {
            macro.variableUpdate(macroDroidVariable, new VariableValue.BooleanValue(this.f2957m.isChecked(), list));
        } else {
            macro.variableUpdate(macroDroidVariable, VariableValue.fromTextValueForType(this.f2956l.getText().toString(), i4, list));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0345  */
    @Override // com.arlosoft.macrodroid.common.NonAppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r18) {
        /*
            Method dump skipped, instructions count: 868
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.activities.VariableValuePrompt.onCreate(android.os.Bundle):void");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        UIUtils.hideKeyboard(this);
        super.onStop();
    }

    /* loaded from: classes2.dex */
    class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f2958a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Button f2959b;

        a(int i4, Button button) {
            this.f2958a = i4;
            this.f2959b = button;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            int i7 = this.f2958a;
            boolean z3 = true;
            if (i7 == 3 || i7 == 1) {
                Button button = this.f2959b;
                if (charSequence.length() <= 0) {
                    z3 = false;
                }
                button.setEnabled(z3);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
