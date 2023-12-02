package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.CancelActiveMacroActionInfo;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.ContinuePausedActionsHandler;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class CancelActiveMacroAction extends Action implements SupportsMagicText {
    public static final Parcelable.Creator<CancelActiveMacroAction> CREATOR = new b();
    private static final long THIS_MACRO_GUID = 111;
    private boolean getByName;
    private long m_GUID;
    private transient List<Macro> m_macroList;
    private String m_macroName;
    private transient boolean tempGetByName;

    /* loaded from: classes2.dex */
    class b implements Parcelable.Creator<CancelActiveMacroAction> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CancelActiveMacroAction createFromParcel(Parcel parcel) {
            return new CancelActiveMacroAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CancelActiveMacroAction[] newArray(int i4) {
            return new CancelActiveMacroAction[i4];
        }
    }

    /* synthetic */ CancelActiveMacroAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void Q() {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_enter_macro_name);
        appCompatDialog.setTitle(R.string.enter_macro_name);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.text);
        Button button = (Button) appCompatDialog.findViewById(R.id.magic_text_button);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.m1
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                CancelActiveMacroAction.T(editText, magicTextPair);
            }
        };
        String str = this.m_macroName;
        if (str != null && !str.equals(R()) && !this.m_macroName.equals(S())) {
            editText.setText(this.m_macroName);
        }
        button2.setEnabled(!TextUtils.isEmpty(this.m_macroName));
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.n1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CancelActiveMacroAction.this.U(editText, appCompatDialog, view);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.o1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.p1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CancelActiveMacroAction.this.W(magicTextListener, view);
            }
        });
        editText.addTextChangedListener(new a(button2, editText));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        appCompatDialog.show();
    }

    private static final String R() {
        return "[" + MacroDroidApplication.getInstance().getString(R.string.enter_macro_name) + "]";
    }

    private static final String S() {
        return MacroDroidApplication.getInstance().getString(R.string.constraint_last_run_time_this_macro);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void T(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(EditText editText, AppCompatDialog appCompatDialog, View view) {
        this.m_macroName = editText.getText().toString();
        this.getByName = true;
        itemComplete();
        appCompatDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(getActivity(), magicTextListener, getMacro(), false, true, false, R.style.Theme_App_Dialog_SmallText, IteratorType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        if (i4 == 0) {
            this.tempGetByName = true;
        } else if (i4 == 1) {
            this.tempGetByName = false;
            this.getByName = false;
            this.m_GUID = THIS_MACRO_GUID;
            this.m_macroName = S();
        } else {
            this.tempGetByName = false;
            this.getByName = false;
            int i5 = i4 - 1;
            this.m_GUID = this.m_macroList.get(i5).getGUID();
            this.m_macroName = this.m_macroList.get(i5).getName();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        if (this.tempGetByName) {
            return 0;
        }
        long j4 = this.m_GUID;
        if (j4 == 0 || j4 == THIS_MACRO_GUID) {
            return 1;
        }
        List<Macro> allCompletedMacrosSorted = MacroStore.getInstance().getAllCompletedMacrosSorted(true);
        this.m_macroList = allCompletedMacrosSorted;
        Iterator<Macro> it = allCompletedMacrosSorted.iterator();
        while (it.hasNext()) {
            if (getMacro().getGUID() == it.next().getGUID()) {
                it.remove();
            }
        }
        this.m_macroList.add(0, getMacro());
        for (int i4 = 0; i4 < this.m_macroList.size(); i4++) {
            if (this.m_GUID == this.m_macroList.get(i4).getGUID()) {
                return i4 + 1;
            }
        }
        this.m_GUID = THIS_MACRO_GUID;
        this.m_macroName = S();
        return 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        if (this.getByName) {
            return this.m_macroName;
        }
        if (this.m_GUID == THIS_MACRO_GUID) {
            return S();
        }
        Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(this.m_GUID);
        if (macroByGUID != null) {
            return macroByGUID.getName();
        }
        return this.m_macroName;
    }

    public long getGUIDToCancel() {
        return this.m_GUID;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return CancelActiveMacroActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + " (" + getExtendedDetail() + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getMacroName() {
        return this.m_macroName;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_macroName};
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        Macro macroByGUID;
        if (this.getByName) {
            macroByGUID = MacroStore.getInstance().getMacroByName(MagicText.replaceMagicText(getContext(), this.m_macroName, triggerContextInfo, getMacro()));
        } else if (this.m_GUID == THIS_MACRO_GUID) {
            macroByGUID = getMacro();
        } else {
            macroByGUID = MacroStore.getInstance().getMacroByGUID(this.m_GUID);
        }
        if (macroByGUID != null) {
            macroByGUID.cancelActiveMacro(getContext());
            ContinuePausedActionsHandler.cancelAlarmsForMacro(getContext(), macroByGUID);
            return;
        }
        SystemLog.logWarning("Attempt to cancel macro that does not exist: " + this.m_macroName + " (Ignoring)");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        String name;
        this.tempGetByName = this.getByName;
        List<Macro> allCompletedMacrosSorted = MacroStore.getInstance().getAllCompletedMacrosSorted(true);
        this.m_macroList = allCompletedMacrosSorted;
        Iterator<Macro> it = allCompletedMacrosSorted.iterator();
        while (it.hasNext()) {
            if (getMacro().getGUID() == it.next().getGUID()) {
                it.remove();
            }
        }
        this.m_macroList.add(0, getMacro());
        String[] strArr = new String[this.m_macroList.size() + 1];
        strArr[0] = R();
        for (int i4 = 0; i4 < this.m_macroList.size(); i4++) {
            if (getMacro().getGUID() == this.m_macroList.get(i4).getGUID()) {
                strArr[i4 + 1] = S();
            } else {
                int i5 = i4 + 1;
                if (this.m_macroList.get(i4).getIsFavourite()) {
                    name = "⭐ " + this.m_macroList.get(i4).getName();
                } else {
                    name = this.m_macroList.get(i4).getName();
                }
                strArr[i5] = name;
            }
        }
        if (this.m_GUID == 0 && this.m_macroList.size() > 0) {
            this.m_GUID = THIS_MACRO_GUID;
            this.m_macroName = S();
        }
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (this.tempGetByName) {
            Q();
        } else {
            super.secondaryItemConfirmed();
        }
    }

    public void setMacroName(String str) {
        long j4 = this.m_GUID;
        if (j4 != 0 && j4 != getMacro().getGUID()) {
            this.m_macroName = str;
        } else {
            this.m_macroName = S();
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 1) {
            this.m_macroName = strArr[0];
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_macroName);
        parcel.writeLong(this.m_GUID);
        parcel.writeInt(this.getByName ? 1 : 0);
    }

    public CancelActiveMacroAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private CancelActiveMacroAction() {
        this.getByName = false;
        this.tempGetByName = false;
    }

    private CancelActiveMacroAction(Parcel parcel) {
        super(parcel);
        this.getByName = false;
        this.tempGetByName = false;
        this.m_macroName = parcel.readString();
        this.m_GUID = parcel.readLong();
        this.getByName = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2106a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2107b;

        a(Button button, EditText editText) {
            this.f2106a = button;
            this.f2107b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2106a;
            if (this.f2107b.getText().length() > 0) {
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
}
