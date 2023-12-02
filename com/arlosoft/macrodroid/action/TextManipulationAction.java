package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.TextManipulationActionInfo;
import com.arlosoft.macrodroid.action.textmanipulation.TextManipulation;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.extensions.ParcelableExtensionsKt;
import com.arlosoft.macrodroid.interfaces.HasDictionaryKeys;
import com.arlosoft.macrodroid.interfaces.HasStringVariableName;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.upgrade.UpgradeActivity2;
import com.arlosoft.macrodroid.utils.VariablesHelper;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableOrOption;
import com.arlosoft.macrodroid.variables.VariableValue;
import es.dmoral.toasty.Toasty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class TextManipulationAction extends Action implements HasStringVariableName, SupportsMagicText, HasDictionaryKeys {
    public static final Parcelable.Creator<TextManipulationAction> CREATOR = new h();
    @Inject

    /* renamed from: c  reason: collision with root package name */
    transient PremiumStatusHandler f2630c;
    private int m_option;
    private String m_text;
    private TextManipulation m_textManipulation;
    private MacroDroidVariable m_variable;
    private DictionaryKeys varDictionaryKeys;
    private String variableName;
    private transient DictionaryKeys workingDictionaryKeys;
    private transient String workingVariableName;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AlertDialog f2631a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2632b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f2633c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Spinner f2634d;

        a(AlertDialog alertDialog, EditText editText, List list, Spinner spinner) {
            this.f2631a = alertDialog;
            this.f2632b = editText;
            this.f2633c = list;
            this.f2634d = spinner;
        }

        @Override // com.arlosoft.macrodroid.action.TextManipulationAction.i
        public void a() {
            TextManipulationAction.this.x0(this.f2631a.getButton(-1), this.f2632b, this.f2633c, this.f2634d, TextManipulationAction.this.workingVariableName);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AlertDialog f2636a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2637b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f2638c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Spinner f2639d;

        b(AlertDialog alertDialog, EditText editText, List list, Spinner spinner) {
            this.f2636a = alertDialog;
            this.f2637b = editText;
            this.f2638c = list;
            this.f2639d = spinner;
        }

        @Override // com.arlosoft.macrodroid.action.TextManipulationAction.i
        public void a() {
            TextManipulationAction.this.x0(this.f2636a.getButton(-1), this.f2637b, this.f2638c, this.f2639d, TextManipulationAction.this.workingVariableName);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements VariablesHelper.VariableCreatedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Spinner f2641a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AlertDialog f2642b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditText f2643c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ List f2644d;

        /* loaded from: classes2.dex */
        class a implements i {
            a() {
            }

            @Override // com.arlosoft.macrodroid.action.TextManipulationAction.i
            public void a() {
                c cVar = c.this;
                TextManipulationAction textManipulationAction = TextManipulationAction.this;
                Button button = cVar.f2642b.getButton(-1);
                c cVar2 = c.this;
                textManipulationAction.x0(button, cVar2.f2643c, cVar2.f2644d, cVar2.f2641a, TextManipulationAction.this.workingVariableName);
            }
        }

        c(Spinner spinner, AlertDialog alertDialog, EditText editText, List list) {
            this.f2641a = spinner;
            this.f2642b = alertDialog;
            this.f2643c = editText;
            this.f2644d = list;
        }

        @Override // com.arlosoft.macrodroid.utils.VariablesHelper.VariableCreatedListener
        public void variableCreated(MacroDroidVariable macroDroidVariable) {
            TextManipulationAction.this.workingVariableName = macroDroidVariable.getName();
            TextManipulationAction.this.workingDictionaryKeys = null;
            TextManipulationAction.this.h0(this.f2641a, new a());
            TextManipulationAction.this.x0(this.f2642b.getButton(-1), this.f2643c, this.f2644d, this.f2641a, TextManipulationAction.this.workingVariableName);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements VariableHelper.VariableSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f2657a;

        f(i iVar) {
            this.f2657a = iVar;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void customItemSelected(int i4, @NonNull String str) {
            TextManipulationAction.this.workingDictionaryKeys = null;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void variableSelected(@NonNull MacroDroidVariable macroDroidVariable, List<String> list) {
            DictionaryKeys dictionaryKeys;
            TextManipulationAction.this.workingVariableName = macroDroidVariable.getName();
            TextManipulationAction textManipulationAction = TextManipulationAction.this;
            if (list != null) {
                dictionaryKeys = new DictionaryKeys(list);
            } else {
                dictionaryKeys = null;
            }
            textManipulationAction.workingDictionaryKeys = dictionaryKeys;
            this.f2657a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements VariableHelper.VariableSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f2659a;

        g(i iVar) {
            this.f2659a = iVar;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void customItemSelected(int i4, @NonNull String str) {
            TextManipulationAction.this.workingDictionaryKeys = null;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void variableSelected(@NonNull MacroDroidVariable macroDroidVariable, List<String> list) {
            DictionaryKeys dictionaryKeys;
            TextManipulationAction.this.workingVariableName = macroDroidVariable.getName();
            TextManipulationAction textManipulationAction = TextManipulationAction.this;
            if (list != null) {
                dictionaryKeys = new DictionaryKeys(list);
            } else {
                dictionaryKeys = null;
            }
            textManipulationAction.workingDictionaryKeys = dictionaryKeys;
            this.f2659a.a();
        }
    }

    /* loaded from: classes2.dex */
    class h implements Parcelable.Creator<TextManipulationAction> {
        h() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TextManipulationAction createFromParcel(Parcel parcel) {
            return new TextManipulationAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public TextManipulationAction[] newArray(int i4) {
            return new TextManipulationAction[i4];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface i {
        void a();
    }

    /* synthetic */ TextManipulationAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0202  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e0(final int r25, final com.arlosoft.macrodroid.action.textmanipulation.TextManipulation r26) {
        /*
            Method dump skipped, instructions count: 856
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.TextManipulationAction.e0(int, com.arlosoft.macrodroid.action.textmanipulation.TextManipulation):void");
    }

    private void f0() {
        final List<TextManipulation> allTextManipulations = TextManipulation.getAllTextManipulations();
        String[] strArr = new String[allTextManipulations.size()];
        for (int i4 = 0; i4 < allTextManipulations.size(); i4++) {
            strArr[i4] = SelectableItem.r(allTextManipulations.get(i4).getName());
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(p());
        builder.setSingleChoiceItems(strArr, this.m_option, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.zp
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                TextManipulationAction.this.s0(dialogInterface, i5);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.dq
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                TextManipulationAction.this.t0(allTextManipulations, dialogInterface, i5);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.eq
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                TextManipulationAction.this.u0(dialogInterface);
            }
        });
    }

    private void g0(Spinner spinner, i iVar) {
        ArrayList arrayList;
        String str;
        if (getAllArrayVariables().isEmpty()) {
            arrayList = new ArrayList(Arrays.asList(SelectableItem.r(R.string.action_set_variable_select)));
        } else {
            arrayList = new ArrayList();
        }
        ArrayList arrayList2 = arrayList;
        Activity activity = getActivity();
        Macro macro = getMacro();
        if (this.workingVariableName != null) {
            str = this.workingVariableName + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys);
        } else {
            str = null;
        }
        VariableHelper.configureArrayVarSpinner(activity, R.style.Theme_App_Dialog_Action, this, spinner, macro, arrayList2, str, new g(iVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(Spinner spinner, i iVar) {
        ArrayList arrayList;
        String str;
        if (getAllStringVariables().isEmpty()) {
            arrayList = new ArrayList(Arrays.asList(SelectableItem.r(R.string.action_set_variable_select)));
        } else {
            arrayList = new ArrayList();
        }
        ArrayList arrayList2 = arrayList;
        Activity activity = getActivity();
        Macro macro = getMacro();
        if (this.workingVariableName != null) {
            str = this.workingVariableName + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys);
        } else {
            str = null;
        }
        VariableHelper.configureStringVarSpinner(activity, R.style.Theme_App_Dialog_Action, this, spinner, macro, arrayList2, str, true, null, new f(iVar));
    }

    private void init() {
        MacroDroidApplication.appComponentInstance.inject(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(int i4, List list, TextManipulation textManipulation, EditText editText, DialogInterface dialogInterface, int i5) {
        this.m_option = i4;
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < list.size(); i6++) {
            if (list.get(i6) instanceof EditText) {
                arrayList.add(((EditText) list.get(i6)).getText().toString());
            } else if (list.get(i6) instanceof ViewGroup) {
                RadioGroup radioGroup = (RadioGroup) list.get(i6);
                arrayList.add(String.valueOf(radioGroup.indexOfChild(radioGroup.findViewById(radioGroup.getCheckedRadioButtonId()))));
            }
        }
        this.varDictionaryKeys = this.workingDictionaryKeys;
        this.variableName = this.workingVariableName;
        textManipulation.setParams(arrayList);
        this.m_textManipulation = textManipulation;
        this.m_text = editText.getText().toString();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(TextManipulation textManipulation, Spinner spinner, AlertDialog alertDialog, EditText editText, List list, Context context, View view) {
        int i4;
        if (textManipulation.isArray() && !this.f2630c.getPremiumStatus().isPro()) {
            ToastCompat.makeText(context, (int) R.string.pro_version_required, 1).show();
            UpgradeActivity2.animateInUpgradeSceen(getActivity());
            return;
        }
        Activity activity = getActivity();
        if (textManipulation.isArray()) {
            i4 = 5;
        } else {
            i4 = 2;
        }
        VariablesHelper.createNewVariable(activity, spinner, this, (int) R.style.Theme_App_Dialog_Action, i4, new c(spinner, alertDialog, editText, list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(getActivity(), magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n0(EditText editText, MagicText.MagicTextPair magicTextPair) {
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
    public /* synthetic */ void o0(MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displayNumberVariableSelectionDialog(getActivity(), getMacro(), magicTextListener, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(getActivity(), magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(TextManipulation textManipulation, List list, EditText editText, View view) {
        TextManipulation textManipulation2 = (TextManipulation) ParcelableExtensionsKt.deepClone(textManipulation);
        if (textManipulation2 != null) {
            textManipulation = textManipulation2;
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (list.get(i4) instanceof EditText) {
                arrayList.add(MagicText.replaceMagicText(getContext(), ((EditText) list.get(i4)).getText().toString(), null, getMacro()));
            } else if (list.get(i4) instanceof ViewGroup) {
                RadioGroup radioGroup = (RadioGroup) list.get(i4);
                arrayList.add(String.valueOf(radioGroup.indexOfChild(radioGroup.findViewById(radioGroup.getCheckedRadioButtonId()))));
            }
        }
        textManipulation.setParams(arrayList);
        try {
            if (textManipulation.isArray()) {
                VariableValue.Dictionary w02 = w0(editText.getText().toString(), textManipulation, null, getMacro());
                w02.toString();
                Toasty.custom(getContext(), w02.toString(), null, 1, false).show();
            } else {
                ToastCompat.makeText(getContext().getApplicationContext(), (CharSequence) v0(editText.getText().toString(), textManipulation, null, getMacro()), 1).show();
            }
        } catch (Exception e4) {
            Context applicationContext = getContext().getApplicationContext();
            ToastCompat.makeText(applicationContext, (CharSequence) (SelectableItem.r(R.string.error) + ": " + e4.toString()), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(List list, DialogInterface dialogInterface, int i4) {
        int checkedItemPosition = ((AlertDialog) dialogInterface).getListView().getCheckedItemPosition();
        TextManipulation textManipulation = this.m_textManipulation;
        if (textManipulation != null && textManipulation.getClass().equals(((TextManipulation) list.get(checkedItemPosition)).getClass())) {
            e0(checkedItemPosition, this.m_textManipulation);
        } else {
            e0(checkedItemPosition, (TextManipulation) list.get(checkedItemPosition));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    private String v0(String str, TextManipulation textManipulation, TriggerContextInfo triggerContextInfo, Macro macro) {
        return textManipulation.apply(MagicText.replaceMagicText(MacroDroidApplication.getInstance(), str, triggerContextInfo, macro), macro, triggerContextInfo);
    }

    private VariableValue.Dictionary w0(String str, TextManipulation textManipulation, TriggerContextInfo triggerContextInfo, Macro macro) {
        return textManipulation.applyArray(MagicText.replaceMagicText(MacroDroidApplication.getInstance(), str, triggerContextInfo, macro), macro, triggerContextInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(Button button, EditText editText, List<EditText> list, Spinner spinner, String str) {
        boolean z3;
        boolean z4;
        VariableOrOption variableOrOption;
        Iterator<EditText> it = list.iterator();
        while (true) {
            z3 = false;
            if (it.hasNext()) {
                if (it.next().getText().length() == 0) {
                    z4 = false;
                    break;
                }
            } else {
                z4 = true;
                break;
            }
        }
        if (spinner.getSelectedItem() == null) {
            variableOrOption = null;
        } else {
            variableOrOption = (VariableOrOption) spinner.getSelectedItem();
        }
        boolean z5 = variableOrOption instanceof VariableOrOption.Variable;
        if (z4 && editText.length() > 0 && (z5 || str != null)) {
            z3 = true;
        }
        button.setEnabled(z3);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void configureOnImport() {
        MacroDroidVariable macroDroidVariable = this.m_variable;
        if (macroDroidVariable != null) {
            this.variableName = macroDroidVariable.getName();
            this.m_variable = null;
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    @Nullable
    public DictionaryKeys getDictionaryKeys() {
        return this.varDictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        TextManipulation textManipulation = this.m_textManipulation;
        if (textManipulation != null) {
            return textManipulation.getExtendedInfo(this.m_text);
        }
        return "";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return TextManipulationActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        TextManipulation textManipulation = this.m_textManipulation;
        if (textManipulation != null) {
            return SelectableItem.r(textManipulation.getName());
        }
        return getConfiguredName();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        if (this.m_textManipulation != null) {
            ArrayList arrayList = new ArrayList(this.m_textManipulation.getParams());
            arrayList.add(0, this.m_text);
            return (String[]) arrayList.toArray(new String[0]);
        }
        return new String[0];
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    @Nullable
    public String getVariableName() {
        return this.variableName;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        f0();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        TextManipulation textManipulation = this.m_textManipulation;
        if (textManipulation != null) {
            try {
                ArrayList<String> arrayList = null;
                if (textManipulation.isArray()) {
                    VariableValue.Dictionary w02 = w0(this.m_text, this.m_textManipulation, triggerContextInfo, getMacro());
                    MacroDroidVariable variableByName = getVariableByName(this.variableName);
                    if (variableByName != null) {
                        if (this.varDictionaryKeys != null) {
                            arrayList = VariableHelper.applyMagicTextToDictionaryKeys(getContext(), this.varDictionaryKeys.getKeys(), triggerContextInfo, getMacro());
                        }
                        variableUpdate(variableByName, new VariableValue.Dictionary(w02.getEntries(), true, arrayList));
                        return;
                    }
                    SystemLog.logError("Text manipulation failed variable does not exist: " + this.m_variable.getName());
                    return;
                }
                String v02 = v0(this.m_text, this.m_textManipulation, triggerContextInfo, getMacro());
                MacroDroidVariable variableByName2 = getVariableByName(this.variableName);
                if (variableByName2 != null) {
                    if (this.varDictionaryKeys != null) {
                        arrayList = VariableHelper.applyMagicTextToDictionaryKeys(getContext(), this.varDictionaryKeys.getKeys(), triggerContextInfo, getMacro());
                    }
                    variableUpdate(variableByName2, new VariableValue.StringValue(v02, arrayList));
                    return;
                }
                SystemLog.logError("Text manipulation failed variable does not exist: " + this.variableName);
            } catch (Exception e4) {
                SystemLog.logError("Error with text manipulation: " + e4.toString());
            }
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    public void setDictionaryKeys(@Nullable DictionaryKeys dictionaryKeys) {
        this.varDictionaryKeys = dictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (this.m_textManipulation != null) {
            this.m_text = strArr[0];
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(Arrays.asList(strArr).subList(1, strArr.length));
            this.m_textManipulation.setParams(arrayList);
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    public void setVariableName(@Nullable String str) {
        this.variableName = str;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
        parcel.writeParcelable(this.m_textManipulation, i4);
        parcel.writeString(this.m_text);
        parcel.writeString(this.variableName);
        parcel.writeParcelable(this.varDictionaryKeys, i4);
    }

    public TextManipulationAction() {
        init();
    }

    public TextManipulationAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private TextManipulationAction(Parcel parcel) {
        super(parcel);
        init();
        this.m_option = parcel.readInt();
        this.m_textManipulation = (TextManipulation) parcel.readParcelable(TextManipulation.class.getClassLoader());
        this.m_text = parcel.readString();
        this.variableName = parcel.readString();
        this.varDictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i0(DialogInterface dialogInterface, int i4) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AlertDialog f2647a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2648b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f2649c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Spinner f2650d;

        d(AlertDialog alertDialog, EditText editText, List list, Spinner spinner) {
            this.f2647a = alertDialog;
            this.f2648b = editText;
            this.f2649c = list;
            this.f2650d = spinner;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextManipulationAction.this.x0(this.f2647a.getButton(-1), this.f2648b, this.f2649c, this.f2650d, TextManipulationAction.this.workingVariableName);
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
    public class e implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AlertDialog f2652a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2653b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f2654c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Spinner f2655d;

        e(AlertDialog alertDialog, EditText editText, List list, Spinner spinner) {
            this.f2652a = alertDialog;
            this.f2653b = editText;
            this.f2654c = list;
            this.f2655d = spinner;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextManipulationAction.this.x0(this.f2652a.getButton(-1), this.f2653b, this.f2654c, this.f2655d, TextManipulationAction.this.workingVariableName);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
