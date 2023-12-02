package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.SetVariableAction;
import com.arlosoft.macrodroid.action.activities.VariableValuePrompt;
import com.arlosoft.macrodroid.action.info.SetVariableActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MacroDroidVariableStore;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.interfaces.HasDictionaryKeyStrings;
import com.arlosoft.macrodroid.interfaces.HasDictionaryKeys;
import com.arlosoft.macrodroid.interfaces.HasVariableNames;
import com.arlosoft.macrodroid.interfaces.HasVariables;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.ExpressionUtils;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.arlosoft.macrodroid.variables.VariableWithDictionaryKeys;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class SetVariableAction extends Action implements HasVariables, HasVariableNames, SupportsMagicText, HasDictionaryKeyStrings, HasDictionaryKeys {
    public static final Parcelable.Creator<SetVariableAction> CREATOR = new b();
    private static final int DARK_MODE_NOT_SET = -1;
    private static final int DARK_MODE_OFF = 1;
    private static final int DARK_MODE_ON = 0;
    private static final int DICTIONARY_OR_ARRAY_TYPE_NOT_SET = -1;
    private DictionaryKeys booleanDictionaryKeys;
    @Inject

    /* renamed from: c  reason: collision with root package name */
    transient PremiumStatusHandler f2497c;
    private VariableWithDictionaryKeys copyDictionaryLocation;
    private boolean createVar;
    private ArrayList<String> dictionaryKeys;
    private int dictionaryOrArrayType;
    private boolean m_booleanInvert;
    private int m_darkMode;
    private double m_doubleRandomMax;
    private double m_doubleRandomMin;
    private String m_expression;
    private String m_falseLabel;
    private boolean m_intExpression;
    private boolean m_intRandom;
    private int m_intRandomMax;
    private int m_intRandomMin;
    private boolean m_intValueDecrement;
    private boolean m_intValueIncrement;
    private boolean m_newBooleanValue;
    private double m_newDoubleValue;
    private long m_newIntValue;
    private String m_newStringValue;
    private MacroDroidVariable m_otherBooleanVariable;
    private transient int m_selectedIndex;
    private transient String m_selectedVarName;
    private String m_trueLabel;
    private boolean m_userPrompt;
    private boolean m_userPromptEmptyAtStart;
    private String m_userPromptMessage;
    private boolean m_userPromptPassword;
    private boolean m_userPromptShowCancel;
    private boolean m_userPromptStopAfterCancel;
    private String m_userPromptTitle;
    private MacroDroidVariable m_variable;
    private transient DictionaryKeys workingBooleanDictionaryKeys;
    private transient MacroDroidVariable workingBooleanVariable;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f2498a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RadioButton f2499b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RadioButton f2500c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RadioButton f2501d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ RadioButton f2502e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ List f2503f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ RadioButton f2504g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ RadioButton f2505h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ RadioButton f2506i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ RadioButton f2507j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ RadioButton f2508k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ RadioButton f2509l;

        /* renamed from: m  reason: collision with root package name */
        final /* synthetic */ EditText f2510m;

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ EditText f2511n;

        /* renamed from: o  reason: collision with root package name */
        final /* synthetic */ EditText f2512o;

        /* renamed from: p  reason: collision with root package name */
        final /* synthetic */ EditText f2513p;

        /* renamed from: q  reason: collision with root package name */
        final /* synthetic */ Activity f2514q;

        /* renamed from: r  reason: collision with root package name */
        final /* synthetic */ RadioButton f2515r;

        /* renamed from: s  reason: collision with root package name */
        final /* synthetic */ EditText f2516s;

        /* renamed from: t  reason: collision with root package name */
        final /* synthetic */ MacroDroidVariable f2517t;

        /* renamed from: u  reason: collision with root package name */
        final /* synthetic */ AppCompatDialog f2518u;

        /* renamed from: v  reason: collision with root package name */
        final /* synthetic */ int f2519v;

        /* renamed from: w  reason: collision with root package name */
        final /* synthetic */ ArrayList f2520w;

        a(int i4, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, List list, RadioButton radioButton5, RadioButton radioButton6, RadioButton radioButton7, RadioButton radioButton8, RadioButton radioButton9, RadioButton radioButton10, EditText editText, EditText editText2, EditText editText3, EditText editText4, Activity activity, RadioButton radioButton11, EditText editText5, MacroDroidVariable macroDroidVariable, AppCompatDialog appCompatDialog, int i5, ArrayList arrayList) {
            this.f2498a = i4;
            this.f2499b = radioButton;
            this.f2500c = radioButton2;
            this.f2501d = radioButton3;
            this.f2502e = radioButton4;
            this.f2503f = list;
            this.f2504g = radioButton5;
            this.f2505h = radioButton6;
            this.f2506i = radioButton7;
            this.f2507j = radioButton8;
            this.f2508k = radioButton9;
            this.f2509l = radioButton10;
            this.f2510m = editText;
            this.f2511n = editText2;
            this.f2512o = editText3;
            this.f2513p = editText4;
            this.f2514q = activity;
            this.f2515r = radioButton11;
            this.f2516s = editText5;
            this.f2517t = macroDroidVariable;
            this.f2518u = appCompatDialog;
            this.f2519v = i5;
            this.f2520w = arrayList;
        }

        @Override // com.arlosoft.macrodroid.action.SetVariableAction.k
        public void a() {
            int i4 = this.f2498a;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 == 3) {
                            SetVariableAction.this.m_userPrompt = this.f2504g.isChecked();
                            SetVariableAction.this.m_intExpression = this.f2508k.isChecked();
                            SetVariableAction.this.m_intRandom = this.f2507j.isChecked();
                            SetVariableAction.this.m_expression = null;
                            try {
                                if (this.f2509l.isChecked()) {
                                    SetVariableAction.this.m_newDoubleValue = Double.valueOf(this.f2510m.getText().toString()).doubleValue();
                                } else if (this.f2507j.isChecked()) {
                                    SetVariableAction.this.m_doubleRandomMin = Double.valueOf(this.f2511n.getText().toString()).doubleValue();
                                    SetVariableAction.this.m_doubleRandomMax = Double.valueOf(this.f2512o.getText().toString()).doubleValue();
                                } else if (this.f2508k.isChecked()) {
                                    SetVariableAction.this.m_expression = this.f2513p.getText().toString();
                                }
                            } catch (Exception unused) {
                                ToastCompat.makeText(this.f2514q.getApplicationContext(), (int) R.string.invalid_value, 0).show();
                                return;
                            }
                        }
                    } else {
                        SetVariableAction.this.m_userPrompt = this.f2515r.isChecked();
                        SetVariableAction.this.m_newStringValue = this.f2516s.getText().toString();
                    }
                } else {
                    SetVariableAction.this.m_userPrompt = this.f2504g.isChecked();
                    SetVariableAction.this.m_intValueIncrement = this.f2505h.isChecked();
                    SetVariableAction.this.m_intValueDecrement = this.f2506i.isChecked();
                    SetVariableAction.this.m_intRandom = this.f2507j.isChecked();
                    SetVariableAction.this.m_intExpression = this.f2508k.isChecked();
                    SetVariableAction.this.m_expression = null;
                    try {
                        if (this.f2509l.isChecked()) {
                            SetVariableAction.this.m_newIntValue = Long.parseLong(this.f2510m.getText().toString());
                        } else if (this.f2507j.isChecked()) {
                            SetVariableAction.this.m_intRandomMin = Integer.valueOf(this.f2511n.getText().toString()).intValue();
                            SetVariableAction.this.m_intRandomMax = Integer.valueOf(this.f2512o.getText().toString()).intValue();
                        } else if (this.f2508k.isChecked()) {
                            SetVariableAction.this.m_expression = this.f2513p.getText().toString();
                        }
                    } catch (Exception unused2) {
                        ToastCompat.makeText(this.f2514q.getApplicationContext(), (int) R.string.invalid_value, 0).show();
                        return;
                    }
                }
            } else {
                SetVariableAction.this.m_userPrompt = this.f2499b.isChecked();
                SetVariableAction.this.m_booleanInvert = this.f2500c.isChecked();
                SetVariableAction.this.m_newBooleanValue = this.f2501d.isChecked();
                if (!this.f2502e.isChecked()) {
                    SetVariableAction.this.m_otherBooleanVariable = null;
                    SetVariableAction.this.booleanDictionaryKeys = null;
                } else if (this.f2503f.size() == 0) {
                    ToastCompat.makeText(SetVariableAction.this.getContext(), (int) R.string.action_set_bluetooth_invalid, 0).show();
                    return;
                } else {
                    SetVariableAction setVariableAction = SetVariableAction.this;
                    setVariableAction.m_otherBooleanVariable = setVariableAction.workingBooleanVariable;
                    SetVariableAction setVariableAction2 = SetVariableAction.this;
                    setVariableAction2.booleanDictionaryKeys = setVariableAction2.workingBooleanDictionaryKeys;
                }
            }
            SetVariableAction.this.m_variable = this.f2517t;
            this.f2518u.dismiss();
            SetVariableAction.this.dictionaryOrArrayType = this.f2519v;
            SetVariableAction.this.dictionaryKeys = this.f2520w;
            if (SetVariableAction.this.m_userPrompt) {
                SetVariableAction.this.Z0();
                return;
            }
            SetVariableAction.this.copyDictionaryLocation = null;
            SetVariableAction.this.itemComplete();
        }
    }

    /* loaded from: classes2.dex */
    class b implements Parcelable.Creator<SetVariableAction> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SetVariableAction createFromParcel(Parcel parcel) {
            return new SetVariableAction(parcel, (c) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SetVariableAction[] newArray(int i4) {
            return new SetVariableAction[i4];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements VariableHelper.NewVariableCreationListener {
        c() {
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.NewVariableCreationListener
        public void newVariableCreated(@NonNull MacroDroidVariable macroDroidVariable, boolean z3) {
            macroDroidVariable.setIsInput(false);
            if (z3) {
                SetVariableAction.this.addVariable(macroDroidVariable);
            }
            SetVariableAction.this.createVar = true;
            SetVariableAction.this.G1(macroDroidVariable);
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.NewVariableCreationListener
        public boolean validateVariableName(@NonNull String str) {
            if (SetVariableAction.this.getMacro().findLocalVariableByName(str) == null) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements Function1<Pair<String, Integer>, Unit> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f2530a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MacroDroidVariable f2531b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f2532c;

        e(ArrayList arrayList, MacroDroidVariable macroDroidVariable, int i4) {
            this.f2530a = arrayList;
            this.f2531b = macroDroidVariable;
            this.f2532c = i4;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(Pair<String, Integer> pair) {
            String first = pair.getFirst();
            Integer second = pair.getSecond();
            if (second.intValue() == 5) {
                ArrayList arrayList = this.f2530a;
                arrayList.add(MacroDroidVariable.ARRAY_KEY_HEADING_USER_FRIENDLY + first);
            } else {
                this.f2530a.add(first);
            }
            VariableValue.DictionaryEntry dictionaryEntry = new VariableValue.DictionaryEntry(first, VariableValue.createForType(pair.getSecond().intValue()), null);
            this.f2531b.setVariableValue(dictionaryEntry, false, null, null);
            if (second.intValue() == 4 || second.intValue() == 5) {
                SetVariableAction.this.K1(this.f2531b, (VariableValue.Dictionary) dictionaryEntry.getVariable(), this.f2530a, false, this.f2532c);
            } else {
                SetVariableAction.this.H1(this.f2531b, this.f2530a, second.intValue());
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements Function1<List<String>, Unit> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MacroDroidVariable f2534a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MacroDroidVariable f2535b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DialogInterface f2536c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f2537d;

        f(MacroDroidVariable macroDroidVariable, MacroDroidVariable macroDroidVariable2, DialogInterface dialogInterface, ArrayList arrayList) {
            this.f2534a = macroDroidVariable;
            this.f2535b = macroDroidVariable2;
            this.f2536c = dialogInterface;
            this.f2537d = arrayList;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(List<String> list) {
            SetVariableAction.this.copyDictionaryLocation = new VariableWithDictionaryKeys(this.f2534a.getName(), new DictionaryKeys(list));
            SetVariableAction.this.m_variable = this.f2535b;
            this.f2536c.dismiss();
            SetVariableAction.this.dictionaryOrArrayType = -1;
            SetVariableAction.this.dictionaryKeys = this.f2537d;
            SetVariableAction.this.itemComplete();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface k {
        void a();
    }

    /* synthetic */ SetVariableAction(Parcel parcel, c cVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void A1(EditText editText, RadioButton radioButton, Button button, CompoundButton compoundButton, boolean z3) {
        editText.setEnabled(!radioButton.isChecked());
        button.setEnabled(!radioButton.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean B1(TextView textView, int i4, KeyEvent keyEvent) {
        if (i4 != 6 && i4 != 0) {
            return false;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).toggleSoftInput(2, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C1(RadioButton radioButton, Button button, LinearLayout linearLayout, EditText editText, LinearLayout linearLayout2, LinearLayout linearLayout3, RadioButton radioButton2, RadioButton radioButton3, EditText editText2, EditText editText3, RadioButton radioButton4, EditText editText4, CompoundButton compoundButton, boolean z3) {
        if (radioButton.isChecked()) {
            button.setEnabled(true);
            linearLayout.setVisibility(8);
            editText.setVisibility(8);
            linearLayout2.setVisibility(8);
            linearLayout3.setVisibility(8);
        } else if (radioButton2.isChecked()) {
            button.setEnabled(editText.getText().length() > 0);
            editText.setVisibility(0);
            linearLayout.setVisibility(8);
            linearLayout2.setVisibility(8);
            linearLayout3.setVisibility(8);
        } else if (radioButton3.isChecked()) {
            button.setEnabled((editText2.getText().length() <= 0 || editText3.getText().length() <= 0) ? false : false);
            linearLayout.setVisibility(0);
            editText.setVisibility(8);
            linearLayout2.setVisibility(8);
            linearLayout3.setVisibility(8);
        } else if (radioButton4.isChecked()) {
            linearLayout.setVisibility(8);
            editText.setVisibility(8);
            linearLayout2.setVisibility(0);
            linearLayout3.setVisibility(0);
            editText4.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.actions_accent)));
            button.setEnabled(editText4.length() > 0);
            if (editText4.length() > 0) {
                button.setTextColor(ContextCompat.getColor(getContext(), R.color.actions_accent));
                try {
                    ExpressionUtils.calculateExpression(getContext(), getMacro(), editText4.getText().toString(), new TriggerContextInfo(this.m_macro.getTriggerList().size() > 0 ? this.m_macro.getTriggerList().get(0) : null));
                    button.setTag(Boolean.TRUE);
                    return;
                } catch (IllegalArgumentException | IndexOutOfBoundsException unused) {
                    button.setTag(Boolean.FALSE);
                    button.setTextColor(ContextCompat.getColor(getContext(), R.color.action_ok_button_error));
                    editText4.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.action_ok_button_error)));
                    return;
                }
            }
            button.setTextColor(ContextCompat.getColor(getContext(), R.color.action_ok_button_disabled));
        } else {
            button.setEnabled(true);
            editText.setVisibility(8);
            linearLayout.setVisibility(8);
            linearLayout2.setVisibility(8);
            linearLayout3.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E1(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F1(List list, int i4, MacroDroidVariable macroDroidVariable, ArrayList arrayList, DialogInterface dialogInterface, int i5) {
        VariableHelper.ShowThisDictionaryOption showThisDictionaryOption;
        MacroDroidVariable macroDroidVariable2 = (MacroDroidVariable) list.get(((AlertDialog) dialogInterface).getListView().getCheckedItemPosition());
        if (i4 == 5) {
            showThisDictionaryOption = VariableHelper.ShowThisDictionaryOption.SHOW_ARRAYS_ONLY;
        } else {
            showThisDictionaryOption = VariableHelper.ShowThisDictionaryOption.SHOW_DICTIONARIES_ONLY;
        }
        VariableHelper.showSelectKeyDialog(getActivity(), R.style.Theme_App_Dialog_Action, macroDroidVariable2, null, false, macroDroidVariable2.getDictionary(), null, new ArrayList(), 0, showThisDictionaryOption, false, null, true, new f(macroDroidVariable2, macroDroidVariable, dialogInterface, arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G1(@NonNull MacroDroidVariable macroDroidVariable) {
        int type = macroDroidVariable.getType();
        if (type != 4 && type != 5) {
            H1(macroDroidVariable, new ArrayList<>(), -1);
        } else {
            K1(macroDroidVariable, macroDroidVariable.getDictionary(), new ArrayList<>(), true, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x06bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void H1(@androidx.annotation.NonNull final com.arlosoft.macrodroid.common.MacroDroidVariable r67, @androidx.annotation.NonNull final java.util.ArrayList<java.lang.String> r68, final int r69) {
        /*
            Method dump skipped, instructions count: 1729
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.SetVariableAction.H1(com.arlosoft.macrodroid.common.MacroDroidVariable, java.util.ArrayList, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I1(final MacroDroidVariable macroDroidVariable, final ArrayList<String> arrayList, VariableValue.Dictionary dictionary, final int i4) {
        ArrayList<MacroDroidVariable> allDictionaryVariables;
        if (!checkActivityAlive()) {
            return;
        }
        if (i4 == 5) {
            allDictionaryVariables = getAllArrayVariables();
        } else {
            allDictionaryVariables = getAllDictionaryVariables();
        }
        final ArrayList<MacroDroidVariable> arrayList2 = allDictionaryVariables;
        new VariableWithDictionaryKeys(macroDroidVariable.getName(), new DictionaryKeys(arrayList));
        int size = arrayList2.size();
        String[] strArr = new String[size];
        int i5 = 0;
        for (int i6 = 0; i6 < arrayList2.size(); i6++) {
            VariableWithDictionaryKeys variableWithDictionaryKeys = this.copyDictionaryLocation;
            if (variableWithDictionaryKeys != null && variableWithDictionaryKeys.equals(arrayList2.get(i6))) {
                i5 = i6;
            }
            strArr[i6] = arrayList2.get(i6).getName();
        }
        if (size == 0) {
            ToastCompat.makeText(getActivity(), (int) R.string.no_variables, 1).show();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        if (i4 == 5) {
            builder.setTitle(R.string.variable_select_array);
        } else {
            builder.setTitle(R.string.variable_select_dictionary);
        }
        builder.setSingleChoiceItems(strArr, i5, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.tk
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i7) {
                SetVariableAction.D1(dialogInterface, i7);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.el
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i7) {
                SetVariableAction.this.E1(dialogInterface, i7);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.kl
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i7) {
                SetVariableAction.this.F1(arrayList2, i4, macroDroidVariable, arrayList, dialogInterface, i7);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(create.getWindow().getAttributes());
        layoutParams.width = -1;
        create.getWindow().setAttributes(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J1(MacroDroidVariable macroDroidVariable, ArrayList<String> arrayList, VariableValue.Dictionary dictionary, int i4) {
        VariableHelper.showAddEntryDialogDictionaryValue(getActivity(), R.style.Theme_App_Dialog_Action, macroDroidVariable, dictionary, getMacro(), isChildOfIterateDictionary(), new e(arrayList, macroDroidVariable, i4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K1(MacroDroidVariable macroDroidVariable, VariableValue.Dictionary dictionary, ArrayList<String> arrayList, boolean z3, int i4) {
        String str;
        if (this.dictionaryKeys.size() > i4) {
            str = this.dictionaryKeys.get(i4);
        } else {
            str = null;
        }
        VariableHelper.showSelectKeyDialog(getActivity(), R.style.Theme_App_Dialog_Action, dictionary, null, str, true, new VariableHelper.ManualKeyOption(true, this.dictionaryKeys), true, VariableHelper.ShowThisDictionaryOption.DONT_SHOW, true, new d(macroDroidVariable, dictionary, arrayList, z3, i4));
    }

    private void L1(MacroDroidVariable macroDroidVariable, TriggerContextInfo triggerContextInfo, ArrayList<String> arrayList) {
        if (macroDroidVariable.getType() != 4 && macroDroidVariable.getType() != 5) {
            variableUpdate(macroDroidVariable, g1(macroDroidVariable, macroDroidVariable.getType(), null, triggerContextInfo));
        } else if (this.copyDictionaryLocation != null) {
            X0(macroDroidVariable, triggerContextInfo, arrayList);
        } else {
            variableUpdate(macroDroidVariable, g1(macroDroidVariable, this.dictionaryOrArrayType, arrayList, triggerContextInfo));
        }
    }

    private void W0(int i4, RadioButton radioButton, Button button, final k kVar) {
        if ((i4 == 1 || i4 == 3) && radioButton.isChecked() && button.getTag() != null && !((Boolean) button.getTag()).booleanValue()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.Theme_App_Dialog_Variables);
            builder.setTitle(R.string.expression);
            builder.setMessage(R.string.expression_does_not_evaluate_to_a_valid_number);
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.xk
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i5) {
                    SetVariableAction.k.this.a();
                }
            });
            builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
            builder.show();
            return;
        }
        kVar.a();
    }

    private void X0(MacroDroidVariable macroDroidVariable, TriggerContextInfo triggerContextInfo, ArrayList<String> arrayList) {
        boolean z3;
        MacroDroidVariable variableByName = getVariableByName(this.copyDictionaryLocation.getVariableName());
        if (variableByName == null) {
            SystemLog.logError("Could not copy from: " + macroDroidVariable.getName() + VariableHelper.getFormattedDictionaryKeys(this.copyDictionaryLocation.getKeys()));
            return;
        }
        if (variableByName.getType() == 5) {
            z3 = true;
        } else {
            z3 = false;
        }
        VariableValue.Dictionary dictionaryFromKeyList = macroDroidVariable.getDictionaryFromKeyList(arrayList, true, z3);
        if (dictionaryFromKeyList != null) {
            VariableValue.Dictionary dictionaryFromKeyList2 = variableByName.getDictionaryFromKeyList(this.copyDictionaryLocation.getKeys().getKeys(), false, z3);
            if (dictionaryFromKeyList2 != null) {
                VariableHelper.copyDictionary(dictionaryFromKeyList, dictionaryFromKeyList2);
                if (macroDroidVariable.isLocalVar()) {
                    MacroStore.getInstance().persistMacro(getMacro());
                    getMacro().notifyVariableListenersOnCorrectThread(macroDroidVariable, dictionaryFromKeyList2, dictionaryFromKeyList);
                    return;
                }
                MacroDroidVariableStore.getInstance().persistData();
                return;
            }
            SystemLog.logError("Could not copy from: " + this.copyDictionaryLocation.getVariableName() + VariableHelper.getFormattedDictionaryKeys(this.copyDictionaryLocation.getKeys()));
            return;
        }
        SystemLog.logError("Could not update variable: " + macroDroidVariable.getName() + VariableHelper.getFormattedDictionaryKeys(arrayList));
    }

    private void Y0() {
        VariableHelper.createNewVariable(getActivity(), this.f2497c.getPremiumStatus().isPro(), true, R.style.Theme_App_Dialog_Action, true, true, R.layout.simple_spinner_dropdown_item_2_lines, "#999999", true, getMacro(), null, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0() {
        int i4;
        if (!checkActivityAlive()) {
            return;
        }
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_variable_user_prompt_options);
        appCompatDialog.setTitle(R.string.user_prompt_text);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.user_prompt_title);
        final EditText editText2 = (EditText) appCompatDialog.findViewById(R.id.user_prompt_description);
        final EditText editText3 = (EditText) appCompatDialog.findViewById(R.id.true_label);
        final EditText editText4 = (EditText) appCompatDialog.findViewById(R.id.false_label);
        ViewGroup viewGroup = (ViewGroup) appCompatDialog.findViewById(R.id.true_label_layout);
        ViewGroup viewGroup2 = (ViewGroup) appCompatDialog.findViewById(R.id.false_label_layout);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.title_magic_text_button);
        Button button4 = (Button) appCompatDialog.findViewById(R.id.description_magic_text_button);
        Button button5 = (Button) appCompatDialog.findViewById(R.id.true_label_magic_text_button);
        Button button6 = (Button) appCompatDialog.findViewById(R.id.false_label_magic_text_button);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.password_field);
        final CheckBox checkBox2 = (CheckBox) appCompatDialog.findViewById(R.id.existing_value);
        final CheckBox checkBox3 = (CheckBox) appCompatDialog.findViewById(R.id.allow_cancel_checkbox);
        final CheckBox checkBox4 = (CheckBox) appCompatDialog.findViewById(R.id.cancel_stops_running_checkbox);
        final CheckBox checkBox5 = (CheckBox) appCompatDialog.findViewById(R.id.dark_mode_checkbox);
        checkBox5.setChecked(a1());
        checkBox3.setChecked(this.m_userPromptShowCancel);
        checkBox4.setChecked(this.m_userPromptStopAfterCancel);
        checkBox4.setEnabled(this.m_userPromptShowCancel);
        checkBox.setChecked(this.m_userPromptPassword);
        checkBox2.setChecked(!this.m_userPromptEmptyAtStart);
        int i5 = 0;
        if (this.m_variable.isBooleanValue(this.dictionaryKeys)) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        viewGroup.setVisibility(i4);
        if (!this.m_variable.isBooleanValue(this.dictionaryKeys)) {
            i5 = 8;
        }
        viewGroup2.setVisibility(i5);
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.yk
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                checkBox4.setEnabled(z3);
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.al
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                SetVariableAction.j1(editText, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.bl
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetVariableAction.this.k1(activity, magicTextListener, view);
            }
        });
        final MagicText.MagicTextListener magicTextListener2 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.cl
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                SetVariableAction.l1(editText2, magicTextPair);
            }
        };
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.dl
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetVariableAction.this.m1(activity, magicTextListener2, view);
            }
        });
        final MagicText.MagicTextListener magicTextListener3 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.fl
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                SetVariableAction.n1(editText3, magicTextPair);
            }
        };
        button5.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.gl
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetVariableAction.this.o1(activity, magicTextListener3, view);
            }
        });
        final MagicText.MagicTextListener magicTextListener4 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.hl
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                SetVariableAction.p1(editText4, magicTextPair);
            }
        };
        button6.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.il
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetVariableAction.this.q1(activity, magicTextListener4, view);
            }
        });
        editText.setText(this.m_userPromptTitle);
        editText.setSelection(editText.length());
        editText2.setText(this.m_userPromptMessage);
        editText2.setSelection(editText2.length());
        editText3.setText(this.m_trueLabel);
        editText3.setSelection(editText3.length());
        editText4.setText(this.m_falseLabel);
        editText4.setSelection(editText4.length());
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.jl
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.zk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetVariableAction.this.s1(editText, editText2, checkBox3, checkBox4, checkBox, checkBox2, editText3, editText4, checkBox5, appCompatDialog, view);
            }
        });
        appCompatDialog.show();
    }

    private boolean a1() {
        int parseInt;
        int i4 = this.m_darkMode;
        if (i4 == 0) {
            return true;
        }
        if (i4 == 1 || (parseInt = Integer.parseInt(Settings.getDarkMode(getContext()))) == 1) {
            return false;
        }
        if (parseInt == 2 || (getContext().getResources().getConfiguration().uiMode & 48) == 32) {
            return true;
        }
        return false;
    }

    private String b1(int i4) {
        int i5;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        return "";
                    }
                    if (this.m_userPrompt) {
                        return SelectableItem.r(R.string.user_prompt);
                    }
                    if (this.m_intExpression) {
                        return this.m_expression;
                    }
                    if (this.m_intRandom) {
                        return SelectableItem.r(R.string.action_set_variable_random) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_doubleRandomMin + " -> " + this.m_doubleRandomMax;
                    }
                    return String.valueOf(this.m_newDoubleValue);
                } else if (this.m_userPrompt) {
                    return SelectableItem.r(R.string.user_prompt);
                } else {
                    if (TextUtils.isEmpty(this.m_newStringValue)) {
                        return "(" + SelectableItem.r(R.string.empty) + ")";
                    }
                    return this.m_newStringValue;
                }
            } else if (this.m_userPrompt) {
                return SelectableItem.r(R.string.user_prompt);
            } else {
                if (this.m_intValueIncrement) {
                    return "(+1)";
                }
                if (this.m_intValueDecrement) {
                    return "(-1)";
                }
                if (this.m_intRandom) {
                    return SelectableItem.r(R.string.action_set_variable_random) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_intRandomMin + " -> " + this.m_intRandomMax;
                } else if (this.m_intExpression) {
                    return this.m_expression;
                } else {
                    return String.valueOf(this.m_newIntValue);
                }
            }
        } else if (this.m_userPrompt) {
            return SelectableItem.r(R.string.user_prompt);
        } else {
            if (this.m_booleanInvert) {
                return "(" + SelectableItem.r(R.string.action_set_variable_invert) + ")";
            } else if (this.m_intRandom) {
                return SelectableItem.r(R.string.action_set_variable_random) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_doubleRandomMin + " -> " + this.m_doubleRandomMax;
            } else if (this.m_otherBooleanVariable != null) {
                return this.m_otherBooleanVariable.getName() + VariableHelper.getFormattedDictionaryKeys(this.booleanDictionaryKeys);
            } else {
                if (this.m_newBooleanValue) {
                    i5 = R.string.true_label;
                } else {
                    i5 = R.string.false_label;
                }
                return SelectableItem.r(i5);
            }
        }
    }

    private VariableValue.BooleanValue c1(boolean z3, @Nullable List<String> list, TriggerContextInfo triggerContextInfo) {
        boolean z4;
        if (this.m_booleanInvert) {
            z4 = !z3;
        } else {
            MacroDroidVariable macroDroidVariable = this.m_otherBooleanVariable;
            if (macroDroidVariable != null) {
                MacroDroidVariable variableByName = getVariableByName(macroDroidVariable.getName());
                if (variableByName != null) {
                    if (this.booleanDictionaryKeys == null) {
                        list = null;
                        z4 = variableByName.getBooleanValue((List<String>) null);
                    } else {
                        z4 = variableByName.getBooleanValue(VariableHelper.applyMagicTextToDictionaryKeys(getContext(), this.booleanDictionaryKeys.getKeys(), triggerContextInfo, getMacro()));
                    }
                } else {
                    SystemLog.logError(this.m_otherBooleanVariable.getName() + " does not exist", getMacroGuid().longValue());
                    z4 = false;
                }
            } else {
                z4 = this.m_newBooleanValue;
            }
        }
        return new VariableValue.BooleanValue(z4, list);
    }

    private VariableValue.DecimalValue d1(TriggerContextInfo triggerContextInfo, @Nullable List<String> list) {
        double d4;
        if (this.m_intRandom) {
            double nextDouble = new Random().nextDouble();
            double d5 = this.m_doubleRandomMax;
            double d6 = this.m_doubleRandomMin;
            d4 = ((d5 - d6) * nextDouble) + d6;
        } else if (this.m_intExpression) {
            try {
                d4 = ExpressionUtils.calculateExpression(getContext(), getMacro(), this.m_expression, triggerContextInfo);
            } catch (IllegalArgumentException unused) {
                d4 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            }
        } else {
            d4 = this.m_newDoubleValue;
        }
        return new VariableValue.DecimalValue(d4, list);
    }

    private VariableValue.IntegerValue e1(long j4, TriggerContextInfo triggerContextInfo, @Nullable List<String> list) {
        long j5;
        if (this.m_intRandom) {
            j5 = new Random().nextInt(Math.max(1, (this.m_intRandomMax - this.m_intRandomMin) + 1)) + this.m_intRandomMin;
        } else if (this.m_intValueIncrement) {
            j5 = j4 + 1;
        } else if (this.m_intValueDecrement) {
            j5 = j4 - 1;
        } else if (this.m_intExpression) {
            try {
                j5 = ExpressionUtils.calculateExpressionLong(getContext(), getMacro(), this.m_expression, triggerContextInfo);
            } catch (IllegalArgumentException unused) {
                j5 = 0;
            }
        } else {
            j5 = this.m_newIntValue;
        }
        return new VariableValue.IntegerValue(j5, list);
    }

    private VariableValue.StringValue f1(TriggerContextInfo triggerContextInfo, @Nullable List<String> list) {
        String str;
        if (this.m_newStringValue != null) {
            str = MagicText.replaceMagicText(getContext(), this.m_newStringValue, triggerContextInfo, getMacro()).replace("\\n", "\n");
        } else {
            str = "";
        }
        return new VariableValue.StringValue(str, list);
    }

    private VariableValue g1(MacroDroidVariable macroDroidVariable, int i4, @Nullable List<String> list, TriggerContextInfo triggerContextInfo) {
        long longValue;
        boolean z3 = false;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        SystemLog.logError("Variable type undefined for variable: " + macroDroidVariable + " (Defaulting to String)");
                        return f1(triggerContextInfo, list);
                    }
                    return d1(triggerContextInfo, list);
                }
                return f1(triggerContextInfo, list);
            }
            VariableValue.DictionaryEntry targetDictionaryEntry = macroDroidVariable.getTargetDictionaryEntry(list, false);
            if (targetDictionaryEntry instanceof VariableValue.DictionaryEntry) {
                VariableValue variable = targetDictionaryEntry.getVariable();
                if (variable instanceof VariableValue.IntegerValue) {
                    longValue = ((VariableValue.IntegerValue) variable).getIntValue();
                } else {
                    longValue = 0;
                }
            } else {
                longValue = macroDroidVariable.getLongValue();
            }
            return e1(longValue, triggerContextInfo, list);
        }
        VariableValue.DictionaryEntry targetDictionaryEntry2 = macroDroidVariable.getTargetDictionaryEntry(list, false);
        if (targetDictionaryEntry2 instanceof VariableValue.DictionaryEntry) {
            VariableValue variable2 = targetDictionaryEntry2.getVariable();
            if (variable2 instanceof VariableValue.BooleanValue) {
                z3 = ((VariableValue.BooleanValue) variable2).getBooleanValue();
            }
        } else {
            z3 = macroDroidVariable.getBooleanValue();
        }
        return c1(z3, list, triggerContextInfo);
    }

    private void init() {
        MacroDroidApplication.appComponentInstance.inject(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j1(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k1(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), false, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l1(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m1(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n1(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o1(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p1(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q1(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s1(EditText editText, EditText editText2, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, EditText editText3, EditText editText4, CheckBox checkBox5, AppCompatDialog appCompatDialog, View view) {
        this.m_userPromptTitle = editText.getText().toString();
        this.m_userPromptMessage = editText2.getText().toString();
        this.m_userPromptShowCancel = checkBox.isChecked();
        this.m_userPromptStopAfterCancel = checkBox2.isChecked();
        this.m_userPromptPassword = checkBox3.isChecked();
        this.m_userPromptEmptyAtStart = !checkBox4.isChecked();
        this.m_trueLabel = editText3.getText().toString();
        this.m_falseLabel = editText4.getText().toString();
        this.m_darkMode = !checkBox5.isChecked();
        this.copyDictionaryLocation = null;
        itemComplete();
        appCompatDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t1(int i4, RadioButton radioButton, Button button, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, List list, RadioButton radioButton6, RadioButton radioButton7, RadioButton radioButton8, RadioButton radioButton9, RadioButton radioButton10, EditText editText, EditText editText2, EditText editText3, EditText editText4, Activity activity, RadioButton radioButton11, EditText editText5, MacroDroidVariable macroDroidVariable, AppCompatDialog appCompatDialog, int i5, ArrayList arrayList, View view) {
        W0(i4, radioButton, button, new a(i4, radioButton2, radioButton3, radioButton4, radioButton5, list, radioButton6, radioButton7, radioButton8, radioButton9, radioButton, radioButton10, editText, editText2, editText3, editText4, activity, radioButton11, editText5, macroDroidVariable, appCompatDialog, i5, arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v1(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w1(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x1(EditText editText, MagicText.MagicTextPair magicTextPair) {
        editText.setKeyListener(null);
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
        editText.setInputType(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y1(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displayNumberVariableSelectionDialog(activity, getMacro(), magicTextListener, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z1(Spinner spinner, CompoundButton compoundButton, boolean z3) {
        int i4;
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        spinner.setVisibility(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_selectedIndex = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        ArrayList<MacroDroidVariable> allOutputVariables = getAllOutputVariables();
        if (this.m_variable != null) {
            for (int i4 = 0; i4 < allOutputVariables.size(); i4++) {
                if (allOutputVariables.get(i4).getName().equals(this.m_variable.getName())) {
                    int i5 = i4 + 1;
                    this.m_selectedIndex = i5;
                    return i5;
                }
            }
        }
        this.m_selectedIndex = 0;
        return 0;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeyStrings
    @Nullable
    public List<String> getDictionaryKeyStrings() {
        return this.dictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    @Nullable
    public DictionaryKeys getDictionaryKeys() {
        VariableWithDictionaryKeys variableWithDictionaryKeys = this.copyDictionaryLocation;
        if (variableWithDictionaryKeys != null) {
            return variableWithDictionaryKeys.getKeys();
        }
        return null;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        MacroDroidVariable macroDroidVariable = this.m_variable;
        if (macroDroidVariable != null) {
            int type = macroDroidVariable.getType();
            if (type != 4 && type != 5) {
                return this.m_variable.getName() + ": " + b1(this.m_variable.getType());
            } else if (this.copyDictionaryLocation != null) {
                return this.m_variable.getName() + VariableHelper.getFormattedDictionaryKeys(this.dictionaryKeys) + ": " + this.copyDictionaryLocation.getVariableName() + VariableHelper.getFormattedDictionaryKeys(this.copyDictionaryLocation.getKeys());
            } else {
                return this.m_variable.getName() + VariableHelper.getFormattedDictionaryKeys(this.dictionaryKeys) + ": " + b1(this.dictionaryOrArrayType);
            }
        }
        return "";
    }

    public String getFalseLabel() {
        return MagicText.replaceMagicText(getContext(), this.m_falseLabel, null, getMacro()).replace("\\n", "\n");
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SetVariableActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getName() + " (" + MDTextUtils.truncateIfRequired(getExtendedDetail(), 20) + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getName() {
        return SelectableItem.r(R.string.action_set_variable);
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        ArrayList arrayList = new ArrayList(Arrays.asList(this.m_newStringValue, this.m_expression, this.m_userPromptTitle, this.m_userPromptMessage, this.m_trueLabel, this.m_falseLabel));
        arrayList.addAll(this.dictionaryKeys);
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        MacroDroidVariable macroDroidVariable = this.m_variable;
        if (macroDroidVariable != null && macroDroidVariable.getType() == 2) {
            if (this.m_userPrompt) {
                return getName() + " (" + this.m_variable.getName() + ": " + SelectableItem.r(R.string.user_prompt) + ")";
            } else if (TextUtils.isEmpty(this.m_newStringValue)) {
                return getName() + " (" + this.m_variable.getName() + ": " + SelectableItem.r(R.string.empty) + ")";
            } else {
                String str = this.m_newStringValue;
                if (str.length() > 2000) {
                    str = this.m_newStringValue.substring(0, 2000);
                }
                return getName() + " (" + this.m_variable.getName() + ": " + g(str, triggerContextInfo) + ")";
            }
        }
        return getName() + " (" + getExtendedDetail() + ")";
    }

    public String getTrueLabel() {
        return MagicText.replaceMagicText(getContext(), this.m_trueLabel, null, getMacro()).replace("\\n", "\n");
    }

    public boolean getUserPrompt() {
        return this.m_userPrompt;
    }

    public String getUserPromptMessage() {
        return MagicText.replaceMagicText(getContext(), this.m_userPromptMessage, null, getMacro()).replace("\\n", "\n");
    }

    public String getUserPromptTitle() {
        String replace = MagicText.replaceMagicText(getContext(), this.m_userPromptTitle, null, getMacro()).replace("\\n", "\n");
        if (TextUtils.isEmpty(replace)) {
            return SelectableItem.r(R.string.action_set_variable_set) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_variable.getName();
        }
        return replace;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    public String[] getVariableNames() {
        String str;
        String[] strArr = new String[1];
        VariableWithDictionaryKeys variableWithDictionaryKeys = this.copyDictionaryLocation;
        if (variableWithDictionaryKeys != null) {
            str = variableWithDictionaryKeys.getVariableName();
        } else {
            str = "";
        }
        strArr[0] = str;
        return strArr;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    public Integer[] getVariableTypes() {
        return new Integer[]{2};
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariables
    public List<MacroDroidVariable> getVariables() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.m_variable);
        MacroDroidVariable macroDroidVariable = this.m_otherBooleanVariable;
        if (macroDroidVariable != null) {
            arrayList.add(macroDroidVariable);
        }
        return arrayList;
    }

    public void invokeAction(@NonNull TriggerContextInfo triggerContextInfo, int i4, Stack<Integer> stack, boolean z3, @Nullable ResumeMacroInfo resumeMacroInfo) {
        Intent intent = new Intent(MacroDroidApplication.getInstance(), VariableValuePrompt.class);
        intent.putExtra(VariableValuePrompt.EXTRA_VARIABLE_NAME, this.m_variable.getName());
        intent.putExtra("MacroId", this.m_macro.getId());
        intent.putExtra(Constants.EXTRA_TRIGGER_CONTEXT_INFO, triggerContextInfo);
        intent.putExtra(Constants.EXTRA_NEXT_ACTION_INDEX, i4);
        intent.putExtra(Constants.EXTRA_FORCE_IF_NOT_ENABLED, z3);
        intent.putExtra("title", getUserPromptTitle());
        intent.putExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX, stack);
        intent.putExtra("message", getUserPromptMessage());
        intent.putExtra(VariableValuePrompt.EXTRA_TRUE_LABEL, getTrueLabel());
        intent.putExtra(VariableValuePrompt.EXTRA_FALSE_LABEL, getFalseLabel());
        intent.putExtra(VariableValuePrompt.EXTRA_SHOW_CANCEL, this.m_userPromptShowCancel);
        intent.putExtra(VariableValuePrompt.EXTRA_STOP_AFTER_CANCEL, this.m_userPromptStopAfterCancel);
        intent.putExtra(VariableValuePrompt.EXTRA_DARK_MODE, a1());
        intent.putExtra(VariableValuePrompt.EXTRA_PASSWORD_MASK, this.m_userPromptPassword);
        intent.putExtra(VariableValuePrompt.EXTRA_INITIALISE_EMPTY, this.m_userPromptEmptyAtStart);
        intent.putExtra(VariableValuePrompt.EXTRA_DICTIONARY_KEYS, this.dictionaryKeys);
        intent.putExtra(VariableValuePrompt.EXTRA_DICTIONARY_OR_ARRAY_TYPE, this.dictionaryOrArrayType);
        intent.putExtra(Constants.EXTRA_RESUME_MACRO_INFO, resumeMacroInfo);
        intent.addFlags(268435456);
        MacroDroidApplication.getInstance().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        ArrayList<MacroDroidVariable> allOutputVariables = getAllOutputVariables();
        String[] strArr = new String[allOutputVariables.size() + 1];
        int i4 = 0;
        strArr[0] = SelectableItem.r(R.string.new_variable);
        while (i4 < allOutputVariables.size()) {
            int i5 = i4 + 1;
            strArr[i5] = allOutputVariables.get(i4).getName();
            i4 = i5;
        }
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return getContext().getString(R.string.action_set_variable_select);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresCanDrawOverlays() {
        if (this.m_userPrompt && Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (this.m_selectedIndex == 0) {
            Y0();
            return;
        }
        ArrayList<MacroDroidVariable> allOutputVariables = getAllOutputVariables();
        if (this.m_selectedIndex > allOutputVariables.size()) {
            ToastCompat.makeText(getContext(), (int) R.string.variable_does_not_exit, 0).show();
        } else {
            G1(allOutputVariables.get(this.m_selectedIndex - 1));
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeyStrings
    public void setDictionaryKeyStrings(@Nullable List<String> list) {
        if (list != null) {
            this.dictionaryKeys = new ArrayList<>(list);
        } else {
            this.dictionaryKeys = new ArrayList<>();
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    public void setDictionaryKeys(@Nullable DictionaryKeys dictionaryKeys) {
        if (dictionaryKeys != null) {
            this.copyDictionaryLocation = new VariableWithDictionaryKeys(this.copyDictionaryLocation.getVariableName(), dictionaryKeys);
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length >= 6) {
            this.m_newStringValue = strArr[0];
            this.m_expression = strArr[1];
            this.m_userPromptTitle = strArr[2];
            this.m_userPromptMessage = strArr[3];
            this.m_trueLabel = strArr[4];
            this.m_falseLabel = strArr[5];
            this.dictionaryKeys = new ArrayList<>();
            for (int i4 = 6; i4 < strArr.length; i4++) {
                this.dictionaryKeys.add(strArr[i4]);
            }
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    public void setVariableNames(String[] strArr) {
        DictionaryKeys dictionaryKeys;
        if (!TextUtils.isEmpty(strArr[0])) {
            String str = strArr[0];
            VariableWithDictionaryKeys variableWithDictionaryKeys = this.copyDictionaryLocation;
            if (variableWithDictionaryKeys != null) {
                dictionaryKeys = variableWithDictionaryKeys.getKeys();
            } else {
                dictionaryKeys = new DictionaryKeys(new ArrayList());
            }
            this.copyDictionaryLocation = new VariableWithDictionaryKeys(str, dictionaryKeys);
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeParcelable(this.m_variable, i4);
        parcel.writeParcelable(this.m_otherBooleanVariable, i4);
        parcel.writeLong(this.m_newIntValue);
        parcel.writeInt(this.m_newBooleanValue ? 1 : 0);
        parcel.writeString(this.m_newStringValue);
        parcel.writeInt(this.m_intValueIncrement ? 1 : 0);
        parcel.writeInt(this.m_intValueDecrement ? 1 : 0);
        parcel.writeInt(this.m_booleanInvert ? 1 : 0);
        parcel.writeInt(this.m_intRandom ? 1 : 0);
        parcel.writeInt(this.m_intRandomMin);
        parcel.writeInt(this.m_intRandomMax);
        parcel.writeInt(this.m_userPrompt ? 1 : 0);
        parcel.writeInt(this.m_intExpression ? 1 : 0);
        parcel.writeString(this.m_expression);
        parcel.writeDouble(this.m_newDoubleValue);
        parcel.writeDouble(this.m_doubleRandomMin);
        parcel.writeDouble(this.m_doubleRandomMax);
        parcel.writeString(this.m_userPromptTitle);
        parcel.writeString(this.m_userPromptMessage);
        parcel.writeInt(this.m_userPromptShowCancel ? 1 : 0);
        parcel.writeInt(this.m_userPromptStopAfterCancel ? 1 : 0);
        parcel.writeString(this.m_trueLabel);
        parcel.writeString(this.m_falseLabel);
        parcel.writeInt(this.m_darkMode);
        parcel.writeInt(this.m_userPromptPassword ? 1 : 0);
        parcel.writeInt(this.m_userPromptEmptyAtStart ? 1 : 0);
        parcel.writeInt(this.dictionaryOrArrayType);
        parcel.writeStringList(this.dictionaryKeys);
        parcel.writeParcelable(this.copyDictionaryLocation, i4);
        parcel.writeInt(this.createVar ? 1 : 0);
        parcel.writeParcelable(this.booleanDictionaryKeys, i4);
    }

    public SetVariableAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
        this.m_selectedIndex = 0;
        this.m_userPrompt = false;
    }

    private SetVariableAction() {
        this.m_trueLabel = SelectableItem.r(R.string.true_label);
        this.m_falseLabel = SelectableItem.r(R.string.false_label);
        this.m_darkMode = -1;
        this.dictionaryOrArrayType = -1;
        this.createVar = true;
        this.booleanDictionaryKeys = new DictionaryKeys(new ArrayList());
        this.dictionaryKeys = new ArrayList<>();
        init();
        this.m_intValueIncrement = false;
        this.m_intValueDecrement = false;
        this.m_booleanInvert = false;
        this.m_userPromptShowCancel = true;
        this.m_userPromptStopAfterCancel = Settings.getUserPromptCancelActions(getContext());
    }

    private SetVariableAction(Parcel parcel) {
        super(parcel);
        this.m_trueLabel = SelectableItem.r(R.string.true_label);
        this.m_falseLabel = SelectableItem.r(R.string.false_label);
        this.m_darkMode = -1;
        this.dictionaryOrArrayType = -1;
        this.createVar = true;
        this.booleanDictionaryKeys = new DictionaryKeys(new ArrayList());
        this.dictionaryKeys = new ArrayList<>();
        init();
        this.m_variable = (MacroDroidVariable) parcel.readParcelable(MacroDroidVariable.class.getClassLoader());
        this.m_otherBooleanVariable = (MacroDroidVariable) parcel.readParcelable(MacroDroidVariable.class.getClassLoader());
        this.m_newIntValue = parcel.readLong();
        this.m_newBooleanValue = parcel.readInt() != 0;
        this.m_newStringValue = parcel.readString();
        this.m_intValueIncrement = parcel.readInt() != 0;
        this.m_intValueDecrement = parcel.readInt() != 0;
        this.m_booleanInvert = parcel.readInt() != 0;
        this.m_intRandom = parcel.readInt() != 0;
        this.m_intRandomMin = parcel.readInt();
        this.m_intRandomMax = parcel.readInt();
        this.m_userPrompt = parcel.readInt() != 0;
        this.m_intExpression = parcel.readInt() != 0;
        this.m_expression = parcel.readString();
        this.m_newDoubleValue = parcel.readDouble();
        this.m_doubleRandomMin = parcel.readDouble();
        this.m_doubleRandomMax = parcel.readDouble();
        this.m_userPromptTitle = parcel.readString();
        this.m_userPromptMessage = parcel.readString();
        this.m_userPromptShowCancel = parcel.readInt() != 0;
        this.m_userPromptStopAfterCancel = parcel.readInt() != 0;
        this.m_trueLabel = parcel.readString();
        this.m_falseLabel = parcel.readString();
        this.m_darkMode = parcel.readInt();
        this.m_userPromptPassword = parcel.readInt() != 0;
        this.m_userPromptEmptyAtStart = parcel.readInt() != 0;
        this.dictionaryOrArrayType = parcel.readInt();
        ArrayList<String> arrayList = new ArrayList<>();
        this.dictionaryKeys = arrayList;
        parcel.readStringList(arrayList);
        this.copyDictionaryLocation = (VariableWithDictionaryKeys) parcel.readParcelable(VariableWithDictionaryKeys.class.getClassLoader());
        this.createVar = parcel.readInt() != 0;
        this.booleanDictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements VariableHelper.KeyDialogOptionChosenCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MacroDroidVariable f2523a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ VariableValue.Dictionary f2524b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f2525c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f2526d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f2527e;

        /* loaded from: classes2.dex */
        class a implements Function1<VariableHelper.ManualKeyData, Unit> {
            a() {
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public Unit invoke(VariableHelper.ManualKeyData manualKeyData) {
                d.this.f2525c.clear();
                d.this.f2525c.addAll(manualKeyData.getKeys());
                if (manualKeyData.getVarType().intValue() != 4 && manualKeyData.getVarType().intValue() != 5) {
                    d dVar = d.this;
                    SetVariableAction.this.H1(dVar.f2523a, dVar.f2525c, manualKeyData.getVarType().intValue());
                    return null;
                }
                d dVar2 = d.this;
                SetVariableAction.this.I1(dVar2.f2523a, dVar2.f2525c, dVar2.f2524b, manualKeyData.getVarType().intValue());
                return null;
            }
        }

        d(MacroDroidVariable macroDroidVariable, VariableValue.Dictionary dictionary, ArrayList arrayList, boolean z3, int i4) {
            this.f2523a = macroDroidVariable;
            this.f2524b = dictionary;
            this.f2525c = arrayList;
            this.f2526d = z3;
            this.f2527e = i4;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
        public void addKeyChosen() {
            SetVariableAction.this.J1(this.f2523a, this.f2525c, this.f2524b, this.f2527e);
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
        public void copyAllChosen() {
            SetVariableAction setVariableAction = SetVariableAction.this;
            MacroDroidVariable macroDroidVariable = this.f2523a;
            ArrayList arrayList = this.f2525c;
            VariableValue.Dictionary dictionary = this.f2524b;
            setVariableAction.I1(macroDroidVariable, arrayList, dictionary, dictionary.getVariableType());
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
        public void keyChosen(@NonNull VariableValue.DictionaryEntry dictionaryEntry) {
            this.f2525c.add(dictionaryEntry.getKey());
            if (dictionaryEntry.getVariable() instanceof VariableValue.Dictionary) {
                SetVariableAction.this.K1(this.f2523a, (VariableValue.Dictionary) dictionaryEntry.getVariable(), this.f2525c, this.f2526d, this.f2527e + 1);
            } else {
                SetVariableAction.this.H1(this.f2523a, this.f2525c, dictionaryEntry.getVariable().getVariableType());
            }
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
        public void manualKeyEntryChosen(@Nullable List<String> list) {
            VariableHelper.defineKeysManually(SetVariableAction.this.getActivity(), R.style.Theme_App_Dialog_Action, this.f2523a, this.f2524b, ((SelectableItem) SetVariableAction.this).m_macro, this.f2525c, list, true, SetVariableAction.this, this.f2526d, new a());
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
        public void thisDictionaryChosen() {
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        String replaceMagicText = MagicText.replaceMagicText(getContext(), this.m_variable.getName(), triggerContextInfo, getMacro());
        MacroDroidVariable variableByName = getVariableByName(replaceMagicText);
        if (variableByName == null) {
            if (this.createVar) {
                MacroDroidVariable macroDroidVariable = new MacroDroidVariable(this.m_variable.getType(), this.m_variable.getName(), this.m_variable.isLocalVar());
                macroDroidVariable.setName(replaceMagicText);
                addVariable(macroDroidVariable);
                variableByName = getVariableByName(replaceMagicText);
            } else {
                SystemLog.logError("Variable not found: " + replaceMagicText);
                return;
            }
        }
        if (this.m_userPrompt) {
            invokeAction(triggerContextInfo, -1, new Stack<>(), true, null);
        } else {
            L1(variableByName, triggerContextInfo, VariableHelper.applyMagicTextToDictionaryKeys(getContext(), this.dictionaryKeys, triggerContextInfo, getMacro()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements VariableHelper.VariableSelectedListener {
        g() {
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void variableSelected(@NonNull MacroDroidVariable macroDroidVariable, @Nullable List<String> list) {
            DictionaryKeys dictionaryKeys;
            SetVariableAction.this.workingBooleanVariable = macroDroidVariable;
            SetVariableAction setVariableAction = SetVariableAction.this;
            if (list != null) {
                dictionaryKeys = new DictionaryKeys(list);
            } else {
                dictionaryKeys = null;
            }
            setVariableAction.workingBooleanDictionaryKeys = dictionaryKeys;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void customItemSelected(int i4, @NonNull String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D1(DialogInterface dialogInterface, int i4) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2540a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RadioButton f2541b;

        h(Button button, RadioButton radioButton) {
            this.f2540a = button;
            this.f2541b = radioButton;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2540a;
            if (editable.length() <= 0 && !this.f2541b.isChecked()) {
                z3 = false;
            } else {
                z3 = true;
            }
            button.setEnabled(z3);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class i implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2543a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2544b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditText f2545c;

        i(Button button, EditText editText, EditText editText2) {
            this.f2543a = button;
            this.f2544b = editText;
            this.f2545c = editText2;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2543a;
            if (this.f2544b.getText().length() > 0 && this.f2545c.getText().length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            button.setEnabled(z3);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class j implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditText f2547a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Button f2548b;

        j(EditText editText, Button button) {
            this.f2547a = editText;
            this.f2548b = button;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Trigger trigger;
            this.f2547a.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(SetVariableAction.this.getContext(), R.color.actions_accent)));
            Button button = this.f2548b;
            if (editable.length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            button.setEnabled(z3);
            if (editable.length() > 0) {
                this.f2548b.setTextColor(ContextCompat.getColor(SetVariableAction.this.getContext(), R.color.actions_accent));
                this.f2548b.setTag(Boolean.TRUE);
                try {
                    if (((SelectableItem) SetVariableAction.this).m_macro != null && ((SelectableItem) SetVariableAction.this).m_macro.getTriggerList().size() > 0) {
                        trigger = ((SelectableItem) SetVariableAction.this).m_macro.getTriggerList().get(0);
                    } else {
                        trigger = null;
                    }
                    ExpressionUtils.calculateExpression(SetVariableAction.this.getContext(), SetVariableAction.this.getMacro(), editable.toString(), new TriggerContextInfo(trigger));
                    return;
                } catch (IllegalArgumentException | IndexOutOfBoundsException unused) {
                    this.f2547a.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(SetVariableAction.this.getContext(), R.color.action_ok_button_error)));
                    this.f2548b.setTextColor(ContextCompat.getColor(SetVariableAction.this.getContext(), R.color.action_ok_button_error));
                    this.f2548b.setTag(Boolean.FALSE);
                    return;
                }
            }
            this.f2548b.setTextColor(ContextCompat.getColor(SetVariableAction.this.getContext(), R.color.action_ok_button_disabled));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
