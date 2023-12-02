package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.UDPCommandActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.interfaces.HasDictionaryKeys;
import com.arlosoft.macrodroid.interfaces.HasStringVariableName;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.UdpSender;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import java.util.ArrayList;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class UDPCommandAction extends Action implements SupportsMagicText, HasStringVariableName, HasDictionaryKeys {
    public static final Parcelable.Creator<UDPCommandAction> CREATOR = new c();
    private String m_destination;
    private String m_message;
    private int m_port;
    private String m_portVariableName;
    private DictionaryKeys varDictionaryKeys;
    private transient DictionaryKeys workingDictionaryKeys;
    private transient String workingVariableName;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements VariableHelper.VariableSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditText f2711a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Button f2712b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditText f2713c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ EditText f2714d;

        a(EditText editText, Button button, EditText editText2, EditText editText3) {
            this.f2711a = editText;
            this.f2712b = button;
            this.f2713c = editText2;
            this.f2714d = editText3;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void customItemSelected(int i4, @NonNull String str) {
            boolean z3 = false;
            this.f2711a.setVisibility(0);
            UDPCommandAction.this.workingVariableName = null;
            UDPCommandAction.this.workingDictionaryKeys = null;
            Button button = this.f2712b;
            if (this.f2713c.length() > 0 && this.f2711a.length() > 0 && this.f2714d.length() > 0) {
                z3 = true;
            }
            button.setEnabled(z3);
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void variableSelected(@NonNull MacroDroidVariable macroDroidVariable, List<String> list) {
            DictionaryKeys dictionaryKeys;
            boolean z3;
            this.f2711a.setVisibility(8);
            UDPCommandAction.this.workingVariableName = macroDroidVariable.getName();
            UDPCommandAction uDPCommandAction = UDPCommandAction.this;
            if (list != null) {
                dictionaryKeys = new DictionaryKeys(list);
            } else {
                dictionaryKeys = null;
            }
            uDPCommandAction.workingDictionaryKeys = dictionaryKeys;
            Button button = this.f2712b;
            if (this.f2713c.length() > 0 && this.f2714d.length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            button.setEnabled(z3);
        }
    }

    /* loaded from: classes2.dex */
    class c implements Parcelable.Creator<UDPCommandAction> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public UDPCommandAction createFromParcel(Parcel parcel) {
            return new UDPCommandAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public UDPCommandAction[] newArray(int i4) {
            return new UDPCommandAction[i4];
        }
    }

    /* synthetic */ UDPCommandAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean V(Spinner spinner, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || spinner.getCount() != 0) {
            return false;
        }
        ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.no_integer_variables_defined, 0).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(EditText editText, EditText editText2, EditText editText3, Spinner spinner, AppCompatDialog appCompatDialog, View view) {
        this.m_message = editText.getText().toString();
        this.m_destination = editText2.getText().toString();
        try {
            this.m_port = Integer.valueOf(editText3.getText().toString()).intValue();
        } catch (Exception unused) {
            this.m_port = 0;
        }
        spinner.getSelectedItemPosition();
        this.m_portVariableName = this.workingVariableName;
        this.varDictionaryKeys = this.workingDictionaryKeys;
        appCompatDialog.cancel();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Y(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    @Nullable
    public DictionaryKeys getDictionaryKeys() {
        return this.varDictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        Object valueOf;
        StringBuilder sb = new StringBuilder();
        sb.append(this.m_destination);
        sb.append(":");
        if (this.m_portVariableName != null) {
            valueOf = this.m_portVariableName + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys);
        } else {
            valueOf = Integer.valueOf(this.m_port);
        }
        sb.append(valueOf);
        sb.append(" - ");
        sb.append(this.m_message);
        return sb.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return UDPCommandActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_message, this.m_destination};
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    public String getVariableName() {
        return this.m_portVariableName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        String str;
        String str2;
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_udp_configure);
        appCompatDialog.setTitle(R.string.action_udp_command);
        this.workingVariableName = this.m_portVariableName;
        this.workingDictionaryKeys = this.varDictionaryKeys;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.dialog_udp_destination);
        final EditText editText2 = (EditText) appCompatDialog.findViewById(R.id.dialog_udp_port);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText3 = (EditText) appCompatDialog.findViewById(R.id.dialog_udp_message);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.dialog_udp_magic_text_button);
        Button button4 = (Button) appCompatDialog.findViewById(R.id.dialog_udp_magic_text_destination);
        final Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.variablesSpinner);
        String str3 = this.m_message;
        String str4 = "";
        if (str3 == null) {
            str3 = "";
        }
        editText3.setText(str3);
        editText3.setSelection(editText3.length());
        int i4 = this.m_port;
        if (i4 == 0) {
            str = "";
        } else {
            str = String.valueOf(i4);
        }
        editText2.setText(str);
        editText2.setSelection(editText2.length());
        String str5 = this.m_destination;
        if (str5 != null) {
            str4 = str5;
        }
        editText.setText(str4);
        editText.setSelection(editText.length());
        ArrayList arrayList = new ArrayList();
        arrayList.add(SelectableItem.r(R.string.enter_value));
        Activity activity2 = getActivity();
        Macro macro = getMacro();
        if (this.workingVariableName != null) {
            str2 = this.workingVariableName + VariableHelper.getFormattedDictionaryKeys(this.workingDictionaryKeys);
        } else {
            str2 = null;
        }
        VariableHelper.configureNumberVarSpinner(activity2, R.style.Theme_App_Dialog_Action, this, spinner, macro, arrayList, str2, "", false, new a(editText2, button, editText, editText3));
        spinner.setOnTouchListener(new View.OnTouchListener() { // from class: com.arlosoft.macrodroid.action.qr
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean V;
                V = UDPCommandAction.this.V(spinner, view, motionEvent);
                return V;
            }
        });
        boolean z3 = false;
        if (this.workingVariableName == null) {
            editText2.setVisibility(0);
        } else {
            editText2.setVisibility(8);
        }
        if (editText.length() > 0 && ((editText2.length() > 0 || spinner.getSelectedItemPosition() > 0) && editText3.length() > 0)) {
            z3 = true;
        }
        button.setEnabled(z3);
        b bVar = new b(button, editText, editText2, spinner, editText3);
        editText3.addTextChangedListener(bVar);
        editText.addTextChangedListener(bVar);
        editText2.addTextChangedListener(bVar);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.rr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UDPCommandAction.this.W(editText3, editText, editText2, spinner, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.sr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.tr
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                UDPCommandAction.Y(editText3, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ur
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UDPCommandAction.this.Z(activity, magicTextListener, view);
            }
        });
        final MagicText.MagicTextListener magicTextListener2 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.vr
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                UDPCommandAction.a0(editText, magicTextPair);
            }
        };
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.wr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UDPCommandAction.this.b0(activity, magicTextListener2, view);
            }
        });
        appCompatDialog.show();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        try {
            String replaceMagicText = MagicText.replaceMagicText(getContext(), this.m_message, triggerContextInfo, false, getMacro());
            String replaceMagicText2 = MagicText.replaceMagicText(getContext(), this.m_destination, triggerContextInfo, true, getMacro());
            int i4 = this.m_port;
            String str = this.m_portVariableName;
            if (str != null) {
                MacroDroidVariable variableByName = getVariableByName(str);
                if (variableByName == null) {
                    SystemLog.logError("UDP action, variable for port does not exist (" + this.m_portVariableName + ")", getMacroGuid().longValue());
                    return;
                }
                Long longValue = variableByName.getLongValue(this.varDictionaryKeys);
                if (longValue != null) {
                    i4 = longValue.intValue();
                } else {
                    SystemLog.logError("UDP action, variable for port does not exist (" + this.m_portVariableName + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys) + ")", getMacroGuid().longValue());
                    return;
                }
            }
            new UdpSender().SendTo(getContext(), replaceMagicText2, i4, replaceMagicText);
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Could not send UDP command: " + this.m_message + " Exception:" + e4.getMessage()));
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    public void setDictionaryKeys(@Nullable DictionaryKeys dictionaryKeys) {
        this.varDictionaryKeys = dictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 2) {
            this.m_message = strArr[0];
            this.m_destination = strArr[1];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    public void setVariableName(String str) {
        this.m_portVariableName = str;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_message);
        parcel.writeString(this.m_destination);
        parcel.writeInt(this.m_port);
        parcel.writeString(this.m_portVariableName);
        parcel.writeParcelable(this.varDictionaryKeys, i4);
    }

    public UDPCommandAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private UDPCommandAction() {
    }

    private UDPCommandAction(Parcel parcel) {
        super(parcel);
        this.m_message = parcel.readString();
        this.m_destination = parcel.readString();
        this.m_port = parcel.readInt();
        this.m_portVariableName = parcel.readString();
        this.varDictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
    }

    /* loaded from: classes2.dex */
    class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2716a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2717b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditText f2718c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Spinner f2719d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ EditText f2720e;

        b(Button button, EditText editText, EditText editText2, Spinner spinner, EditText editText3) {
            this.f2716a = button;
            this.f2717b = editText;
            this.f2718c = editText2;
            this.f2719d = spinner;
            this.f2720e = editText3;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2716a;
            if (this.f2717b.length() > 0 && ((this.f2718c.length() > 0 || this.f2719d.getSelectedItemPosition() > 0) && this.f2720e.length() > 0)) {
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
