package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.OptionDialogAction;
import com.arlosoft.macrodroid.action.activities.OptionDialogActivity;
import com.arlosoft.macrodroid.action.info.OptionDialogActionInfo;
import com.arlosoft.macrodroid.actionblock.common.ActionBlockConfigDialog;
import com.arlosoft.macrodroid.actionblock.common.ActionBlockData;
import com.arlosoft.macrodroid.actionblock.common.ActionBlockMacroAdapter;
import com.arlosoft.macrodroid.actionblock.common.RunnableItem;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.interfaces.BlockingAction;
import com.arlosoft.macrodroid.interfaces.ReferenceSelfGUIDs;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.interfaces.UsesActionBlocks;
import com.arlosoft.macrodroid.macro.ActionBlockStore;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public class OptionDialogAction extends Action implements BlockingAction, UsesActionBlocks, SupportsMagicText, ReferenceSelfGUIDs {
    public static final Parcelable.Creator<OptionDialogAction> CREATOR = new g();
    public static final long GUID_IGNORE_CANCEL = 2;
    public static final long GUID_IGNORE_CONTINUE = 1;
    private static final int NUM_BUTTONS = 3;
    private ActionBlockData[] actionBlockData;
    protected boolean blockNextAction;
    private long[] m_actionMacroGuids;
    private String[] m_buttonNames;
    private int m_defaultButton;
    private int m_defaultTimeOutSecs;
    private String m_message;
    private String m_title;
    private boolean preventBackButtonClosing;
    private transient ActionBlockData[] workingActionBlockData;

    /* loaded from: classes2.dex */
    class g implements Parcelable.Creator<OptionDialogAction> {
        g() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public OptionDialogAction createFromParcel(Parcel parcel) {
            return new OptionDialogAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public OptionDialogAction[] newArray(int i4) {
            return new OptionDialogAction[i4];
        }
    }

    /* synthetic */ OptionDialogAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ActionBlockStore e0() {
        return MacroStore.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(EditText editText, EditText editText2, SeekBar seekBar, Spinner spinner, CheckBox checkBox, CheckBox checkBox2, AppCompatDialog appCompatDialog, EditText editText3, EditText editText4, EditText editText5, List list, Spinner spinner2, Spinner spinner3, Spinner spinner4, View view) {
        this.actionBlockData = this.workingActionBlockData;
        this.m_title = editText.getText().toString();
        this.m_message = editText2.getText().toString();
        this.m_defaultTimeOutSecs = (seekBar.getProgress() + 1) * 5;
        this.m_defaultButton = spinner.getSelectedItemPosition();
        this.preventBackButtonClosing = checkBox.isChecked();
        this.blockNextAction = checkBox2.isChecked();
        appCompatDialog.cancel();
        itemComplete();
        this.m_buttonNames = new String[]{editText3.getText().toString(), editText4.getText().toString(), editText5.getText().toString()};
        this.m_actionMacroGuids = new long[]{((RunnableItem) list.get(spinner2.getSelectedItemPosition())).getGuid(), ((RunnableItem) list.get(spinner3.getSelectedItemPosition())).getGuid(), ((RunnableItem) list.get(spinner4.getSelectedItemPosition())).getGuid()};
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
    public static /* synthetic */ void m0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
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
    public /* synthetic */ void q0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t0(TextView textView, TextView textView2, EditText[] editTextArr, Spinner[] spinnerArr) {
        if (textView.getText().length() != 0 && textView2.getText().length() != 0) {
            for (int i4 = 0; i4 < editTextArr.length; i4++) {
                if (editTextArr[i4].getText().length() > 0 && spinnerArr[i4].getSelectedItemPosition() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.interfaces.UsesActionBlocks
    @NonNull
    public List<String> getActionBlockNames() {
        ActionBlockData[] actionBlockDataArr;
        ArrayList arrayList = new ArrayList();
        for (ActionBlockData actionBlockData : this.actionBlockData) {
            if (actionBlockData != null) {
                arrayList.add(actionBlockData.getActionBlockName());
            }
        }
        return arrayList;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return this.m_title + ": " + this.m_message;
    }

    @Override // com.arlosoft.macrodroid.interfaces.ReferenceSelfGUIDs
    @NonNull
    public ArrayList<Long> getGUIDs() {
        ArrayList<Long> arrayList = new ArrayList<>();
        for (long j4 : this.m_actionMacroGuids) {
            arrayList.add(Long.valueOf(j4));
        }
        return arrayList;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return OptionDialogActionInfo.getInstance();
    }

    public String getMessage() {
        return this.m_message;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        ActionBlockData[] actionBlockDataArr;
        String str;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.m_message);
        for (ActionBlockData actionBlockData : this.actionBlockData) {
            if (actionBlockData != null) {
                HashMap<String, String> inputVarsMap = actionBlockData.getInputVarsMap();
                for (String str2 : inputVarsMap.keySet()) {
                    if (inputVarsMap.get(str2) == null) {
                        str = "";
                    } else {
                        str = inputVarsMap.get(str2);
                    }
                    arrayList.add(str);
                }
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public String getTitle() {
        return this.m_title;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        int i4;
        Spinner[] spinnerArr;
        ActionBlockData[] actionBlockDataArr = this.actionBlockData;
        this.workingActionBlockData = (ActionBlockData[]) Arrays.copyOf(actionBlockDataArr, actionBlockDataArr.length);
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.configure_option_dialog);
        appCompatDialog.setTitle(R.string.action_option_dialog);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.configure_option_dialog_title);
        final EditText editText2 = (EditText) appCompatDialog.findViewById(R.id.configure_option_dialog_message);
        final EditText editText3 = (EditText) appCompatDialog.findViewById(R.id.configure_option_dialog_1);
        final EditText editText4 = (EditText) appCompatDialog.findViewById(R.id.configure_option_dialog_2);
        final EditText editText5 = (EditText) appCompatDialog.findViewById(R.id.configure_option_dialog_3);
        final Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.configure_option_dialog_spinner_1);
        final Spinner spinner2 = (Spinner) appCompatDialog.findViewById(R.id.configure_option_dialog_spinner_2);
        final Spinner spinner3 = (Spinner) appCompatDialog.findViewById(R.id.configure_option_dialog_spinner_3);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.option_dialog_title_magic_text_button);
        Button button4 = (Button) appCompatDialog.findViewById(R.id.option_dialog_message_magic_text_button);
        Button button5 = (Button) appCompatDialog.findViewById(R.id.option_dialog_button1_magic_text_button);
        Button button6 = (Button) appCompatDialog.findViewById(R.id.option_dialog_button2_magic_text_button);
        Button button7 = (Button) appCompatDialog.findViewById(R.id.option_dialog_button3_magic_text_button);
        final Spinner spinner4 = (Spinner) appCompatDialog.findViewById(R.id.default_option_spinner);
        final SeekBar seekBar = (SeekBar) appCompatDialog.findViewById(R.id.timeout_seekbar);
        ViewGroup viewGroup = (ViewGroup) appCompatDialog.findViewById(R.id.timeout_options);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.seconds_value);
        ScrollView scrollView = (ScrollView) appCompatDialog.findViewById(R.id.scroll_view);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.prevent_back_button_checkbox);
        final CheckBox checkBox2 = (CheckBox) appCompatDialog.findViewById(R.id.block_next_actions);
        Button button8 = (Button) appCompatDialog.findViewById(R.id.configInputOutputParams1);
        Button button9 = (Button) appCompatDialog.findViewById(R.id.configInputOutputParams2);
        Button button10 = (Button) appCompatDialog.findViewById(R.id.configInputOutputParams3);
        ArrayAdapter arrayAdapter = new ArrayAdapter(activity, 17367048, new String[]{SelectableItem.r(R.string.none), SelectableItem.r(R.string.left_button), SelectableItem.r(R.string.center_button), SelectableItem.r(R.string.right_button)});
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner4.setSelection(this.m_defaultButton, false);
        if (this.m_defaultButton == 0) {
            i4 = 8;
        } else {
            i4 = 0;
        }
        viewGroup.setVisibility(i4);
        spinner4.setOnItemSelectedListener(new a(viewGroup, scrollView));
        seekBar.setProgress((this.m_defaultTimeOutSecs / 5) - 1);
        textView.setText(this.m_defaultTimeOutSecs + SelectableItem.r(R.string.seconds_one_char));
        seekBar.setOnSeekBarChangeListener(new b(textView));
        List<Macro> allCompletedMacrosSorted = MacroStore.getInstance().getAllCompletedMacrosSorted(false);
        List<ActionBlock> allActionBlocksSorted = e0().getAllActionBlocksSorted();
        final ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(this.m_title)) {
            editText.setText(R.string.select_option);
        } else {
            editText.setText(this.m_title);
        }
        editText.setSelection(editText.length());
        if (TextUtils.isEmpty(this.m_message)) {
            editText2.setText(R.string.choose_option);
        } else {
            editText2.setText(this.m_message);
        }
        editText2.setSelection(editText2.length());
        editText3.setText(this.m_buttonNames[0]);
        editText4.setText(this.m_buttonNames[1]);
        editText5.setText(this.m_buttonNames[2]);
        arrayList.add(new RunnableItem("(" + getContext().getString(R.string.button_off) + ")", 0L, false));
        arrayList.add(new RunnableItem(getContext().getString(R.string.option_dialog_option_ignore_continue_macro), 1L, false));
        arrayList.add(new RunnableItem(getContext().getString(R.string.option_dialog_option_ignore_cancel_macro), 2L, false));
        for (int i5 = 0; i5 < allActionBlocksSorted.size(); i5++) {
            ActionBlock actionBlock = allActionBlocksSorted.get(i5);
            arrayList.add(new RunnableItem(actionBlock.getName(), actionBlock.getGUID(), true));
        }
        for (int i6 = 0; i6 < allCompletedMacrosSorted.size(); i6++) {
            Macro macro = allCompletedMacrosSorted.get(i6);
            arrayList.add(new RunnableItem(macro.getName(), macro.getGUID(), false));
        }
        SpinnerAdapter actionBlockMacroAdapter = new ActionBlockMacroAdapter(activity, arrayList);
        SpinnerAdapter actionBlockMacroAdapter2 = new ActionBlockMacroAdapter(activity, arrayList);
        SpinnerAdapter actionBlockMacroAdapter3 = new ActionBlockMacroAdapter(activity, arrayList);
        spinner.setAdapter(actionBlockMacroAdapter);
        spinner2.setAdapter(actionBlockMacroAdapter2);
        spinner3.setAdapter(actionBlockMacroAdapter3);
        button9.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.zd
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OptionDialogAction.f0(view);
            }
        });
        button10.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ie
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OptionDialogAction.g0(view);
            }
        });
        EditText[] editTextArr = {editText3, editText4, editText5};
        Spinner[] spinnerArr2 = {spinner, spinner2, spinner3};
        TextWatcher cVar = new c(button, editText, editText2, editTextArr, spinnerArr2);
        int i7 = 0;
        while (true) {
            long[] jArr = this.m_actionMacroGuids;
            if (i7 < jArr.length) {
                long j4 = jArr[i7];
                int i8 = 0;
                while (true) {
                    if (i8 < arrayList.size()) {
                        if (j4 == ((RunnableItem) arrayList.get(i8)).getGuid()) {
                            spinnerArr = spinnerArr2;
                            spinnerArr[i7].setSelection(i8);
                            break;
                        }
                        i8++;
                    } else {
                        spinnerArr = spinnerArr2;
                        break;
                    }
                }
                i7++;
                spinnerArr2 = spinnerArr;
            } else {
                Spinner[] spinnerArr3 = spinnerArr2;
                AdapterView.OnItemSelectedListener dVar = new d(button, editText, editText2, editTextArr, spinnerArr3, arrayList, button8, activity);
                AdapterView.OnItemSelectedListener eVar = new e(button, editText, editText2, editTextArr, spinnerArr3, arrayList, button9, activity);
                AdapterView.OnItemSelectedListener fVar = new f(button, editText, editText2, editTextArr, spinnerArr3, arrayList, button10, activity);
                spinner.setOnItemSelectedListener(dVar);
                spinner2.setOnItemSelectedListener(eVar);
                spinner3.setOnItemSelectedListener(fVar);
                editText.addTextChangedListener(cVar);
                editText2.addTextChangedListener(cVar);
                editText3.addTextChangedListener(cVar);
                editText4.addTextChangedListener(cVar);
                editText5.addTextChangedListener(cVar);
                final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.je
                    @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
                    public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                        OptionDialogAction.l0(editText, magicTextPair);
                    }
                };
                final MagicText.MagicTextListener magicTextListener2 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.ke
                    @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
                    public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                        OptionDialogAction.m0(editText2, magicTextPair);
                    }
                };
                final MagicText.MagicTextListener magicTextListener3 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.le
                    @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
                    public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                        OptionDialogAction.n0(editText3, magicTextPair);
                    }
                };
                final MagicText.MagicTextListener magicTextListener4 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.me
                    @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
                    public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                        OptionDialogAction.o0(editText4, magicTextPair);
                    }
                };
                final MagicText.MagicTextListener magicTextListener5 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.ae
                    @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
                    public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                        OptionDialogAction.p0(editText5, magicTextPair);
                    }
                };
                button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.be
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        OptionDialogAction.this.q0(activity, magicTextListener, view);
                    }
                });
                button4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ce
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        OptionDialogAction.this.r0(activity, magicTextListener2, view);
                    }
                });
                button5.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.de
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        OptionDialogAction.this.s0(activity, magicTextListener3, view);
                    }
                });
                button6.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ee
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        OptionDialogAction.this.h0(activity, magicTextListener4, view);
                    }
                });
                button7.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.fe
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        OptionDialogAction.this.i0(activity, magicTextListener5, view);
                    }
                });
                checkBox.setChecked(this.preventBackButtonClosing);
                checkBox2.setChecked(this.blockNextAction);
                button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ge
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        OptionDialogAction.this.j0(editText, editText2, seekBar, spinner4, checkBox, checkBox2, appCompatDialog, editText3, editText4, editText5, arrayList, spinner, spinner2, spinner3, view);
                    }
                });
                button.setEnabled(t0(editText, editText2, editTextArr, spinnerArr2));
                button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.he
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AppCompatDialog.this.cancel();
                    }
                });
                appCompatDialog.show();
                return;
            }
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresCanDrawOverlays() {
        if (Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.interfaces.ReferenceSelfGUIDs
    public void setGUIDs(@NonNull ArrayList<Long> arrayList) {
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            this.m_actionMacroGuids[i4] = arrayList.get(i4).longValue();
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        ActionBlockData[] actionBlockDataArr;
        String str;
        this.m_message = strArr[0];
        int i4 = 1;
        for (ActionBlockData actionBlockData : this.actionBlockData) {
            if (actionBlockData != null) {
                HashMap<String, String> inputVarsMap = actionBlockData.getInputVarsMap();
                for (String str2 : inputVarsMap.keySet()) {
                    if (strArr[i4].equals("")) {
                        str = null;
                    } else {
                        str = strArr[i4];
                    }
                    inputVarsMap.put(str2, str);
                    i4++;
                }
            }
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_title);
        parcel.writeString(this.m_message);
        parcel.writeStringArray(this.m_buttonNames);
        parcel.writeLongArray(this.m_actionMacroGuids);
        parcel.writeParcelableArray(this.actionBlockData, i4);
        parcel.writeInt(this.m_defaultButton);
        parcel.writeInt(this.m_defaultTimeOutSecs);
        parcel.writeInt(this.blockNextAction ? 1 : 0);
        parcel.writeInt(this.preventBackButtonClosing ? 1 : 0);
    }

    public OptionDialogAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    @Override // com.arlosoft.macrodroid.interfaces.BlockingAction
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo, int i4, boolean z3, @NotNull Stack<Integer> stack, @Nullable ResumeMacroInfo resumeMacroInfo, boolean z4) {
        OptionDialogActivity.showOptionDialog(getContext(), this.m_title, this.m_message, this.m_actionMacroGuids, this.actionBlockData, this.m_buttonNames, this.m_defaultButton, this.m_defaultTimeOutSecs, triggerContextInfo, this.m_macro.getGUID(), this.m_macro.getTriggerThatInvoked(), i4, stack, z3, z4, resumeMacroInfo, this.blockNextAction, this.preventBackButtonClosing);
    }

    private OptionDialogAction() {
        this.blockNextAction = false;
        this.preventBackButtonClosing = false;
        this.m_actionMacroGuids = new long[3];
        this.m_buttonNames = new String[3];
        this.actionBlockData = new ActionBlockData[3];
        this.workingActionBlockData = new ActionBlockData[3];
        this.m_defaultTimeOutSecs = 30;
    }

    private OptionDialogAction(Parcel parcel) {
        super(parcel);
        this.blockNextAction = false;
        this.preventBackButtonClosing = false;
        this.m_title = parcel.readString();
        this.m_message = parcel.readString();
        String[] strArr = new String[3];
        this.m_buttonNames = strArr;
        parcel.readStringArray(strArr);
        long[] jArr = new long[3];
        this.m_actionMacroGuids = jArr;
        parcel.readLongArray(jArr);
        Parcelable[] readParcelableArray = parcel.readParcelableArray(ActionBlockData.class.getClassLoader());
        if (readParcelableArray != null) {
            this.actionBlockData = (ActionBlockData[]) Arrays.copyOf(readParcelableArray, readParcelableArray.length, ActionBlockData[].class);
        }
        this.m_defaultButton = parcel.readInt();
        this.m_defaultTimeOutSecs = parcel.readInt();
        this.blockNextAction = parcel.readInt() != 0;
        this.preventBackButtonClosing = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2367a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ScrollView f2368b;

        a(ViewGroup viewGroup, ScrollView scrollView) {
            this.f2367a = viewGroup;
            this.f2368b = scrollView;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            int i5;
            ViewGroup viewGroup = this.f2367a;
            if (i4 == 0) {
                i5 = 8;
            } else {
                i5 = 0;
            }
            viewGroup.setVisibility(i5);
            if (i4 > 0) {
                final ScrollView scrollView = this.f2368b;
                scrollView.post(new Runnable() { // from class: com.arlosoft.macrodroid.action.ne
                    @Override // java.lang.Runnable
                    public final void run() {
                        scrollView.fullScroll(130);
                    }
                });
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* loaded from: classes2.dex */
    class b implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f2370a;

        b(TextView textView) {
            this.f2370a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
            TextView textView = this.f2370a;
            textView.setText(((i4 + 1) * 5) + SelectableItem.r(R.string.seconds_one_char));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2378a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2379b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditText f2380c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ EditText[] f2381d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Spinner[] f2382e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ List f2383f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Button f2384g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Activity f2385h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a implements Function1<ActionBlockData, Unit> {
            a() {
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public Unit invoke(ActionBlockData actionBlockData) {
                OptionDialogAction.this.workingActionBlockData[0] = actionBlockData;
                return null;
            }
        }

        d(Button button, EditText editText, EditText editText2, EditText[] editTextArr, Spinner[] spinnerArr, List list, Button button2, Activity activity) {
            this.f2378a = button;
            this.f2379b = editText;
            this.f2380c = editText2;
            this.f2381d = editTextArr;
            this.f2382e = spinnerArr;
            this.f2383f = list;
            this.f2384g = button2;
            this.f2385h = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Activity activity, ActionBlock actionBlock, View view) {
            ActionBlockConfigDialog.displayConfigurationDialog(activity, actionBlock, OptionDialogAction.this.workingActionBlockData[0], OptionDialogAction.this, new a());
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            int i5;
            ActionBlockData actionBlockData;
            this.f2378a.setEnabled(OptionDialogAction.this.t0(this.f2379b, this.f2380c, this.f2381d, this.f2382e));
            RunnableItem runnableItem = (RunnableItem) this.f2383f.get(i4);
            Button button = this.f2384g;
            if (runnableItem.isActionBlock()) {
                i5 = 0;
            } else {
                i5 = 8;
            }
            button.setVisibility(i5);
            if (runnableItem.isActionBlock()) {
                final ActionBlock actionBlockByGuid = OptionDialogAction.this.e0().getActionBlockByGuid(runnableItem.getGuid());
                ActionBlockData[] actionBlockDataArr = OptionDialogAction.this.workingActionBlockData;
                if (OptionDialogAction.this.workingActionBlockData[0] != null) {
                    actionBlockData = OptionDialogAction.this.workingActionBlockData[0];
                } else {
                    actionBlockData = new ActionBlockData(actionBlockByGuid.getName(), actionBlockByGuid.getGUID(), new HashMap(), new HashMap());
                }
                actionBlockDataArr[0] = actionBlockData;
                Button button2 = this.f2384g;
                final Activity activity = this.f2385h;
                button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.oe
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        OptionDialogAction.d.this.b(activity, actionBlockByGuid, view2);
                    }
                });
                return;
            }
            OptionDialogAction.this.workingActionBlockData[0] = null;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2388a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2389b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditText f2390c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ EditText[] f2391d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Spinner[] f2392e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ List f2393f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Button f2394g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Activity f2395h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a implements Function1<ActionBlockData, Unit> {
            a() {
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public Unit invoke(ActionBlockData actionBlockData) {
                OptionDialogAction.this.workingActionBlockData[1] = actionBlockData;
                return null;
            }
        }

        e(Button button, EditText editText, EditText editText2, EditText[] editTextArr, Spinner[] spinnerArr, List list, Button button2, Activity activity) {
            this.f2388a = button;
            this.f2389b = editText;
            this.f2390c = editText2;
            this.f2391d = editTextArr;
            this.f2392e = spinnerArr;
            this.f2393f = list;
            this.f2394g = button2;
            this.f2395h = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Activity activity, ActionBlock actionBlock, View view) {
            ActionBlockConfigDialog.displayConfigurationDialog(activity, actionBlock, OptionDialogAction.this.workingActionBlockData[1], OptionDialogAction.this, new a());
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            int i5;
            ActionBlockData actionBlockData;
            this.f2388a.setEnabled(OptionDialogAction.this.t0(this.f2389b, this.f2390c, this.f2391d, this.f2392e));
            RunnableItem runnableItem = (RunnableItem) this.f2393f.get(i4);
            Button button = this.f2394g;
            if (runnableItem.isActionBlock()) {
                i5 = 0;
            } else {
                i5 = 8;
            }
            button.setVisibility(i5);
            if (runnableItem.isActionBlock()) {
                final ActionBlock actionBlockByGuid = OptionDialogAction.this.e0().getActionBlockByGuid(runnableItem.getGuid());
                ActionBlockData[] actionBlockDataArr = OptionDialogAction.this.workingActionBlockData;
                if (OptionDialogAction.this.workingActionBlockData[1] != null) {
                    actionBlockData = OptionDialogAction.this.workingActionBlockData[1];
                } else {
                    actionBlockData = new ActionBlockData(actionBlockByGuid.getName(), actionBlockByGuid.getGUID(), new HashMap(), new HashMap());
                }
                actionBlockDataArr[1] = actionBlockData;
                Button button2 = this.f2394g;
                final Activity activity = this.f2395h;
                button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.pe
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        OptionDialogAction.e.this.b(activity, actionBlockByGuid, view2);
                    }
                });
                return;
            }
            OptionDialogAction.this.workingActionBlockData[1] = null;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2398a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2399b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditText f2400c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ EditText[] f2401d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Spinner[] f2402e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ List f2403f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Button f2404g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Activity f2405h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a implements Function1<ActionBlockData, Unit> {
            a() {
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public Unit invoke(ActionBlockData actionBlockData) {
                OptionDialogAction.this.workingActionBlockData[2] = actionBlockData;
                return null;
            }
        }

        f(Button button, EditText editText, EditText editText2, EditText[] editTextArr, Spinner[] spinnerArr, List list, Button button2, Activity activity) {
            this.f2398a = button;
            this.f2399b = editText;
            this.f2400c = editText2;
            this.f2401d = editTextArr;
            this.f2402e = spinnerArr;
            this.f2403f = list;
            this.f2404g = button2;
            this.f2405h = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Activity activity, ActionBlock actionBlock, View view) {
            ActionBlockConfigDialog.displayConfigurationDialog(activity, actionBlock, OptionDialogAction.this.workingActionBlockData[2], OptionDialogAction.this, new a());
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            int i5;
            ActionBlockData actionBlockData;
            this.f2398a.setEnabled(OptionDialogAction.this.t0(this.f2399b, this.f2400c, this.f2401d, this.f2402e));
            RunnableItem runnableItem = (RunnableItem) this.f2403f.get(i4);
            Button button = this.f2404g;
            if (runnableItem.isActionBlock()) {
                i5 = 0;
            } else {
                i5 = 8;
            }
            button.setVisibility(i5);
            if (runnableItem.isActionBlock()) {
                final ActionBlock actionBlockByGuid = OptionDialogAction.this.e0().getActionBlockByGuid(runnableItem.getGuid());
                ActionBlockData[] actionBlockDataArr = OptionDialogAction.this.workingActionBlockData;
                if (OptionDialogAction.this.workingActionBlockData[2] != null) {
                    actionBlockData = OptionDialogAction.this.workingActionBlockData[2];
                } else {
                    actionBlockData = new ActionBlockData(actionBlockByGuid.getName(), actionBlockByGuid.getGUID(), new HashMap(), new HashMap());
                }
                actionBlockDataArr[2] = actionBlockData;
                Button button2 = this.f2404g;
                final Activity activity = this.f2405h;
                button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.qe
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        OptionDialogAction.f.this.b(activity, actionBlockByGuid, view2);
                    }
                });
                return;
            }
            OptionDialogAction.this.workingActionBlockData[2] = null;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g0(View view) {
    }

    /* loaded from: classes2.dex */
    class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2372a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2373b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditText f2374c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ EditText[] f2375d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Spinner[] f2376e;

        c(Button button, EditText editText, EditText editText2, EditText[] editTextArr, Spinner[] spinnerArr) {
            this.f2372a = button;
            this.f2373b = editText;
            this.f2374c = editText2;
            this.f2375d = editTextArr;
            this.f2376e = spinnerArr;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            this.f2372a.setEnabled(OptionDialogAction.this.t0(this.f2373b, this.f2374c, this.f2375d, this.f2376e));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
