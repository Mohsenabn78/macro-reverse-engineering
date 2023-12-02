package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.DialNumberTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.DialNumberTriggerReceiver;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

/* loaded from: classes3.dex */
public class DialNumberTrigger extends Trigger {
    public static final Parcelable.Creator<DialNumberTrigger> CREATOR = new b();
    private static DialNumberTriggerReceiver s_dialNumberTriggerReceiver;
    private static int s_triggerCounter;
    private boolean m_makeCall;
    private String m_numberToDial;

    /* loaded from: classes3.dex */
    class b implements Parcelable.Creator<DialNumberTrigger> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DialNumberTrigger createFromParcel(Parcel parcel) {
            return new DialNumberTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public DialNumberTrigger[] newArray(int i4) {
            return new DialNumberTrigger[i4];
        }
    }

    /* synthetic */ DialNumberTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(EditText editText, RadioButton radioButton, AppCompatDialog appCompatDialog, View view) {
        this.m_numberToDial = editText.getText().toString();
        this.m_makeCall = radioButton.isChecked();
        appCompatDialog.cancel();
        itemComplete();
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(s_dialNumberTriggerReceiver);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            s_dialNumberTriggerReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_dialNumberTriggerReceiver = new DialNumberTriggerReceiver();
            MacroDroidApplication.getInstance().registerReceiver(s_dialNumberTriggerReceiver, new IntentFilter("android.intent.action.NEW_OUTGOING_CALL"));
        }
        s_triggerCounter++;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return SelectableItem.r(R.string.trigger_dial_number) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_numberToDial;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return DialNumberTriggerInfo.getInstance();
    }

    public String getNumber() {
        return this.m_numberToDial;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        return new String[]{"android.permission.PROCESS_OUTGOING_CALLS"};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        boolean z3;
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dial_number_dialog);
        appCompatDialog.setTitle(SelectableItem.r(R.string.trigger_dial_number_title));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.dial_number_dialog_phone_number);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.dial_number_dialog_make_call);
        editText.setText(this.m_numberToDial);
        editText.setSelection(editText.length());
        radioButton.setChecked(this.m_makeCall);
        editText.addTextChangedListener(new a(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.n2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialNumberTrigger.this.O(editText, radioButton, appCompatDialog, view);
            }
        });
        if (editText.getText().length() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        button.setEnabled(z3);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.o2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    public boolean shouldMakeCall() {
        return this.m_makeCall;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_numberToDial);
        parcel.writeInt(this.m_makeCall ? 1 : 0);
    }

    public DialNumberTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private DialNumberTrigger() {
        this.m_makeCall = false;
    }

    private DialNumberTrigger(Parcel parcel) {
        super(parcel);
        this.m_numberToDial = parcel.readString();
        this.m_makeCall = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f14355a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f14356b;

        a(Button button, EditText editText) {
            this.f14355a = button;
            this.f14356b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f14355a;
            if (this.f14356b.getText().length() > 0) {
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
