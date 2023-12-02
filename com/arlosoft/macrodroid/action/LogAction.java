package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.LogActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.LogUpdateEvent;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes2.dex */
public class LogAction extends Action implements SupportsMagicText {
    public static final String LOG_FILE_NAME = "MacroDroidUserLog.txt";
    private boolean m_logDateAndTime;
    private String m_logText;
    private static final Object s_logLock = new Object();
    public static final Parcelable.Creator<LogAction> CREATOR = new b();

    /* loaded from: classes2.dex */
    class b implements Parcelable.Creator<LogAction> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public LogAction createFromParcel(Parcel parcel) {
            return new LogAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public LogAction[] newArray(int i4) {
            return new LogAction[i4];
        }
    }

    /* synthetic */ LogAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void Q() {
        boolean z3;
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, R.style.Theme_App_Dialog_Action);
        appCompatDialog.setContentView(R.layout.configure_log_message);
        appCompatDialog.setTitle(getName());
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.configure_log_message_text);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.configure_log_message_magic_text_button);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.configure_log_date_and_time);
        checkBox.setChecked(this.m_logDateAndTime);
        String str = this.m_logText;
        if (str != null) {
            editText.setText(str);
            editText.setSelection(editText.getText().length());
        }
        editText.addTextChangedListener(new a(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.s9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LogAction.this.R(appCompatDialog, editText, checkBox, view);
            }
        });
        if (editText.getText().length() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        button.setEnabled(z3);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.t9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.u9
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                LogAction.T(editText, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.v9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LogAction.this.U(activity, magicTextListener, view);
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(AppCompatDialog appCompatDialog, EditText editText, CheckBox checkBox, View view) {
        appCompatDialog.cancel();
        this.m_logText = editText.getText().toString();
        this.m_logDateAndTime = checkBox.isChecked();
        itemComplete();
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
    public /* synthetic */ void U(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return this.m_logText;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return LogActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_logText};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        return getName() + ": " + g(this.m_logText, triggerContextInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        Q();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        FileOutputStream fileOutputStream;
        String str = "";
        if (this.m_logDateAndTime) {
            str = "[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "] - ";
        }
        String g4 = g(this.m_logText, triggerContextInfo);
        synchronized (s_logLock) {
            OutputStreamWriter outputStreamWriter = null;
            try {
                try {
                    fileOutputStream = MacroDroidApplication.getInstance().openFileOutput(LOG_FILE_NAME, 32768);
                    try {
                        try {
                            OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(fileOutputStream, "UTF-8");
                            try {
                                outputStreamWriter2.write(str + g4 + "\n");
                                outputStreamWriter2.close();
                                EventBusUtils.getEventBus().post(new LogUpdateEvent());
                                outputStreamWriter2.close();
                            } catch (Exception e4) {
                                e = e4;
                                outputStreamWriter = outputStreamWriter2;
                                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("ERROR - Writing to log: " + e.getMessage()));
                                outputStreamWriter.close();
                                fileOutputStream.close();
                            } catch (Throwable th) {
                                th = th;
                                outputStreamWriter = outputStreamWriter2;
                                try {
                                    outputStreamWriter.close();
                                    fileOutputStream.close();
                                } catch (Exception unused) {
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception e5) {
                        e = e5;
                    }
                } catch (Exception e6) {
                    e = e6;
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
                fileOutputStream.close();
            } catch (Exception unused2) {
            }
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 1) {
            this.m_logText = strArr[0];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_logText);
        parcel.writeInt(this.m_logDateAndTime ? 1 : 0);
    }

    public LogAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private LogAction() {
        this.m_logDateAndTime = true;
    }

    private LogAction(Parcel parcel) {
        super(parcel);
        this.m_logText = parcel.readString();
        this.m_logDateAndTime = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2297a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2298b;

        a(Button button, EditText editText) {
            this.f2297a = button;
            this.f2298b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2297a;
            if (this.f2298b.getText().length() > 0) {
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
