package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.SystemLogTriggerInfo;

/* loaded from: classes3.dex */
public class SystemLogTrigger extends Trigger {
    public static final Parcelable.Creator<SystemLogTrigger> CREATOR = new b();
    private static int MATCH_OPTION_CONTAINS = 1;
    private static int MATCH_OPTION_MATCH;
    private static int s_triggerCounter;
    private boolean enableRegex;
    private boolean ignoreCase;
    private int matchOption;
    private String text;

    /* loaded from: classes3.dex */
    class b implements Parcelable.Creator<SystemLogTrigger> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SystemLogTrigger createFromParcel(Parcel parcel) {
            return new SystemLogTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SystemLogTrigger[] newArray(int i4) {
            return new SystemLogTrigger[i4];
        }
    }

    /* synthetic */ SystemLogTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void R(CheckBox checkBox, CompoundButton compoundButton, boolean z3) {
        checkBox.setEnabled(!z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(EditText editText, CheckBox checkBox, CheckBox checkBox2, RadioButton radioButton, AppCompatDialog appCompatDialog, View view) {
        int i4;
        this.text = editText.getText().toString();
        this.enableRegex = checkBox.isChecked();
        this.ignoreCase = checkBox2.isChecked();
        if (radioButton.isChecked()) {
            i4 = MATCH_OPTION_MATCH;
        } else {
            i4 = MATCH_OPTION_CONTAINS;
        }
        this.matchOption = i4;
        appCompatDialog.cancel();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void U(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), false, true, true, R.style.Theme_App_Dialog_Trigger_SmallText, IteratorType.NONE);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return this.text;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SystemLogTriggerInfo.Companion.getInstance();
    }

    public String getText() {
        return MagicText.replaceMagicText(getContext(), this.text, null, getMacro());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        boolean z3;
        if (!checkActivityAlive()) {
            return;
        }
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_system_log_trigger);
        appCompatDialog.setTitle(R.string.trigger_system_log);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.dialog_clipboard_change_trigger_text);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.dialog_clipboard_change_trigger_magic_text_button);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.enable_regex);
        final CheckBox checkBox2 = (CheckBox) appCompatDialog.findViewById(R.id.ignore_case);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.matches_radio_button);
        RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.contains_radio_button);
        String str = this.text;
        if (str != null) {
            editText.setText(str);
            editText.setSelection(editText.length());
        }
        boolean z4 = true;
        checkBox2.setEnabled(!this.enableRegex);
        checkBox2.setChecked(this.ignoreCase);
        checkBox.setChecked(this.enableRegex);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.j8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
                SystemLogTrigger.R(checkBox2, compoundButton, z5);
            }
        });
        button.setEnabled(!TextUtils.isEmpty(this.text));
        if (this.matchOption == MATCH_OPTION_MATCH) {
            z3 = true;
        } else {
            z3 = false;
        }
        radioButton.setChecked(z3);
        if (this.matchOption != MATCH_OPTION_CONTAINS) {
            z4 = false;
        }
        radioButton2.setChecked(z4);
        editText.addTextChangedListener(new a(button));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.k8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SystemLogTrigger.this.S(editText, checkBox, checkBox2, radioButton, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.l8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.triggers.m8
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                SystemLogTrigger.U(editText, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.n8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SystemLogTrigger.this.V(activity, magicTextListener, view);
            }
        });
        appCompatDialog.show();
    }

    public boolean isContains() {
        if (this.matchOption == MATCH_OPTION_CONTAINS) {
            return true;
        }
        return false;
    }

    public boolean isEnableRegex() {
        return this.enableRegex;
    }

    public boolean isIgnoreCase() {
        return this.ignoreCase;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.text);
        parcel.writeInt(this.enableRegex ? 1 : 0);
        parcel.writeInt(this.matchOption);
        parcel.writeInt(this.ignoreCase ? 1 : 0);
    }

    public SystemLogTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private SystemLogTrigger() {
        this.ignoreCase = true;
    }

    private SystemLogTrigger(Parcel parcel) {
        super(parcel);
        this.ignoreCase = true;
        this.text = parcel.readString();
        this.enableRegex = parcel.readInt() != 0;
        this.matchOption = parcel.readInt();
        this.ignoreCase = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f14429a;

        a(Button button) {
            this.f14429a = button;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            boolean z3;
            Button button = this.f14429a;
            if (charSequence.length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            button.setEnabled(z3);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
    }
}
