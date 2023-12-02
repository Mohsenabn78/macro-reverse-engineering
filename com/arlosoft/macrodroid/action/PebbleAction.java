package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.PebbleActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.PebbleHelper;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.Vibrate;
import com.getpebble.android.kit.PebbleKit;
import com.getpebble.android.kit.util.PebbleDictionary;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class PebbleAction extends Action implements SupportsMagicText {
    public static final Parcelable.Creator<PebbleAction> CREATOR = new c();
    private static final int PEBBLE_COMMAND_CLOSE_APP = 2;
    private static final int PEBBLE_COMMAND_DISPLAY_NOTIFICATION = 0;
    private static final int PEBBLE_COMMAND_DISPLAY_TEXT = 5;
    private static final int PEBBLE_COMMAND_DISPLAY_TEXT_OPTION_KEY = 997;
    public static final int PEBBLE_COMMAND_KEY = 999;
    public static final int PEBBLE_COMMAND_LIGHT_ON = 4;
    public static final int PEBBLE_COMMAND_REFRESH_BATTERY = 6;
    private static final int PEBBLE_COMMAND_START_APP = 1;
    private static final int PEBBLE_COMMAND_VIBRATE = 3;
    private static final int PEBBLE_COMMAND_VIBRATE_OPTION_KEY = 998;
    private static final int PEBBLE_DISPLAY_TEXT_DURATION_OPTION_KEY = 995;
    private static final int PEBBLE_DISPLAY_TEXT_SIZE_OPTION_KEY = 996;
    private int m_command;
    private String m_notificationMessage;
    private String m_notificationTitle;
    private String m_onScreenText;
    private int m_onScreenTextDurationSeconds;
    private int m_onScreenTextSize;
    private int m_vibrateOption;

    /* loaded from: classes2.dex */
    class c implements Parcelable.Creator<PebbleAction> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PebbleAction createFromParcel(Parcel parcel) {
            return new PebbleAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public PebbleAction[] newArray(int i4) {
            return new PebbleAction[i4];
        }
    }

    /* synthetic */ PebbleAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void f0() {
        boolean z3;
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.configure_pebble_notification);
        appCompatDialog.setTitle(getName());
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.configure_pebble_notification_text);
        final EditText editText2 = (EditText) appCompatDialog.findViewById(R.id.configure_pebble_subject_text);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.configure_pebble_magic_subject_button);
        Button button4 = (Button) appCompatDialog.findViewById(R.id.configure_pebble_magic_text_button);
        String str = this.m_notificationMessage;
        if (str != null) {
            editText.setText(str);
            editText.setSelection(editText.length());
        }
        String str2 = this.m_notificationTitle;
        if (str2 != null) {
            editText2.setText(str2);
            editText2.setSelection(editText2.length());
        }
        a aVar = new a(button, editText, editText2);
        editText.addTextChangedListener(aVar);
        editText2.addTextChangedListener(aVar);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ye
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PebbleAction.this.i0(appCompatDialog, editText, editText2, view);
            }
        });
        if (editText.getText().length() > 0 && editText2.getText().length() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        button.setEnabled(z3);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ze
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.af
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                PebbleAction.k0(editText2, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.bf
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PebbleAction.this.l0(activity, magicTextListener, view);
            }
        });
        final MagicText.MagicTextListener magicTextListener2 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.cf
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                PebbleAction.m0(editText, magicTextPair);
            }
        };
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.df
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PebbleAction.this.n0(activity, magicTextListener2, view);
            }
        });
        appCompatDialog.show();
    }

    private void g0() {
        boolean z3;
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.configure_pebble_text);
        appCompatDialog.setTitle(R.string.action_pebble_display_text);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        final Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.configure_pebble_text_text);
        RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.configure_pebble_text_set_radio_button);
        final RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.configure_pebble_text_clear_radio_button);
        final Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.configure_pebble_text_spinner_duration);
        final Spinner spinner2 = (Spinner) appCompatDialog.findViewById(R.id.configure_pebble_text_spinner_size);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.configure_pebble_text_magic_text_button);
        boolean z4 = true;
        if (this.m_onScreenText != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        radioButton.setChecked(z3);
        radioButton2.setChecked(false);
        String str = this.m_onScreenText;
        if (str != null) {
            editText.setText(str);
            editText.setSelection(editText.length());
        }
        spinner.setSelection(this.m_onScreenTextDurationSeconds);
        spinner2.setSelection(this.m_onScreenTextSize);
        editText.setEnabled(radioButton.isChecked());
        spinner.setEnabled(radioButton.isChecked());
        spinner2.setEnabled(radioButton.isChecked());
        if (radioButton.isChecked() && editText.length() <= 0) {
            z4 = false;
        }
        button.setEnabled(z4);
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.te
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
                PebbleAction.o0(editText, spinner, spinner2, button, compoundButton, z5);
            }
        });
        editText.addTextChangedListener(new b(button, radioButton, editText));
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.ue
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                PebbleAction.p0(editText, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ve
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PebbleAction.this.q0(activity, magicTextListener, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.we
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PebbleAction.this.r0(radioButton2, editText, spinner2, spinner, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.xe
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.action_pebble_notification), MacroDroidApplication.getInstance().getString(R.string.action_pebble_open_app), MacroDroidApplication.getInstance().getString(R.string.action_pebble_close_app), MacroDroidApplication.getInstance().getString(R.string.action_pebble_vibrate), MacroDroidApplication.getInstance().getString(R.string.action_pebble_light_on), MacroDroidApplication.getInstance().getString(R.string.action_pebble_display_text)};
    }

    private void h0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.action_pebble_vibrate_pattern);
        builder.setSingleChoiceItems(Vibrate.getPatternNames(), this.m_vibrateOption, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ef
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PebbleAction.this.u0(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ff
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PebbleAction.this.v0(dialogInterface, i4);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.gf
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PebbleAction.this.w0(dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.se
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                PebbleAction.this.t0(dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(AppCompatDialog appCompatDialog, EditText editText, EditText editText2, View view) {
        appCompatDialog.cancel();
        this.m_notificationMessage = editText.getText().toString();
        this.m_notificationTitle = editText2.getText().toString();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
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
    public /* synthetic */ void n0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o0(EditText editText, Spinner spinner, Spinner spinner2, Button button, CompoundButton compoundButton, boolean z3) {
        boolean z4;
        editText.setEnabled(z3);
        spinner.setEnabled(z3);
        spinner2.setEnabled(z3);
        if (z3 && editText.length() <= 0) {
            z4 = false;
        } else {
            z4 = true;
        }
        button.setEnabled(z4);
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
    public /* synthetic */ void r0(RadioButton radioButton, EditText editText, Spinner spinner, Spinner spinner2, AppCompatDialog appCompatDialog, View view) {
        if (radioButton.isChecked()) {
            this.m_onScreenText = null;
        } else {
            this.m_onScreenText = editText.getText().toString();
            this.m_onScreenTextSize = spinner.getSelectedItemPosition();
            this.m_onScreenTextDurationSeconds = spinner2.getSelectedItemPosition();
        }
        super.secondaryItemConfirmed();
        appCompatDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(DialogInterface dialogInterface, int i4) {
        this.m_vibrateOption = i4;
        Vibrate.vibrateDevice(getContext(), this.m_vibrateOption);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(DialogInterface dialogInterface, int i4) {
        super.secondaryItemConfirmed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0() {
        super.handleItemSelected();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_command = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_command;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        int i4 = this.m_command;
        if (i4 == 3) {
            return getOptions()[this.m_command] + ": " + Vibrate.getPatternNames()[this.m_vibrateOption];
        } else if (i4 == 5) {
            return getOptions()[this.m_command] + ": " + this.m_onScreenText;
        } else {
            return getOptions()[this.m_command];
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return PebbleActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_notificationTitle, this.m_notificationMessage, this.m_onScreenText};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        if (Settings.getShownPebbleInfo(getContext())) {
            super.handleItemSelected();
        } else {
            PebbleHelper.displayPebbleInfo(getActivity(), new PebbleHelper.PebbleDialogHandler() { // from class: com.arlosoft.macrodroid.action.re
                @Override // com.arlosoft.macrodroid.common.PebbleHelper.PebbleDialogHandler
                public final void continueSelected() {
                    PebbleAction.this.x0();
                }
            });
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        int i4 = this.m_command;
        if (i4 == 0) {
            Intent intent = new Intent("com.getpebble.action.SEND_NOTIFICATION");
            String replaceMagicText = MagicText.replaceMagicText(getContext(), this.m_notificationTitle, triggerContextInfo, getMacro());
            String replaceMagicText2 = MagicText.replaceMagicText(getContext(), this.m_notificationMessage, triggerContextInfo, getMacro());
            HashMap hashMap = new HashMap();
            hashMap.put("title", replaceMagicText);
            hashMap.put("body", replaceMagicText2);
            String jSONArray = new JSONArray().put(new JSONObject(hashMap)).toString();
            intent.putExtra("messageType", "PEBBLE_ALERT");
            intent.putExtra("sender", "MyAndroidApp");
            intent.putExtra("notificationData", jSONArray);
            getContext().sendBroadcast(intent);
        } else if (i4 == 1) {
            PebbleKit.startAppOnPebble(getContext(), Constants.PEBBLE_APP_UUID);
        } else if (i4 == 2) {
            PebbleKit.closeAppOnPebble(getContext(), Constants.PEBBLE_APP_UUID);
        } else {
            PebbleDictionary pebbleDictionary = new PebbleDictionary();
            pebbleDictionary.addUint8(999, (byte) this.m_command);
            if (this.m_command == 3) {
                pebbleDictionary.addUint8(PEBBLE_COMMAND_VIBRATE_OPTION_KEY, (byte) this.m_vibrateOption);
            }
            if (this.m_command == 5) {
                try {
                    pebbleDictionary.addString(PEBBLE_COMMAND_DISPLAY_TEXT_OPTION_KEY, MagicText.replaceMagicText(getContext(), this.m_onScreenText, triggerContextInfo, getMacro()).replace("\\n", "\n"));
                    pebbleDictionary.addUint8(PEBBLE_DISPLAY_TEXT_SIZE_OPTION_KEY, (byte) this.m_onScreenTextSize);
                    TypedArray obtainTypedArray = getContext().getResources().obtainTypedArray(R.array.set_pebble_text_duration_values);
                    pebbleDictionary.addInt32(PEBBLE_DISPLAY_TEXT_DURATION_OPTION_KEY, obtainTypedArray.getInt(this.m_onScreenTextDurationSeconds, 5));
                    obtainTypedArray.recycle();
                } catch (Exception e4) {
                    FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("PebbleAction: Error encoding UTF-8: " + e4.toString()));
                }
            }
            PebbleKit.sendDataToPebble(getContext(), Constants.PEBBLE_APP_UUID, pebbleDictionary);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        int i4 = this.m_command;
        if (i4 == 0) {
            f0();
        } else if (i4 == 3) {
            h0();
        } else if (i4 == 5) {
            g0();
        } else {
            super.secondaryItemConfirmed();
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 3) {
            this.m_notificationTitle = strArr[0];
            this.m_notificationMessage = strArr[1];
            this.m_onScreenText = strArr[2];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_command);
        parcel.writeString(this.m_notificationTitle);
        parcel.writeString(this.m_notificationMessage);
        parcel.writeString(this.m_onScreenText);
        parcel.writeInt(this.m_vibrateOption);
        parcel.writeInt(this.m_onScreenTextDurationSeconds);
        parcel.writeInt(this.m_onScreenTextSize);
    }

    public PebbleAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private PebbleAction() {
        this.m_onScreenText = "";
    }

    private PebbleAction(Parcel parcel) {
        super(parcel);
        this.m_command = parcel.readInt();
        this.m_notificationTitle = parcel.readString();
        this.m_notificationMessage = parcel.readString();
        this.m_onScreenText = parcel.readString();
        this.m_vibrateOption = parcel.readInt();
        this.m_onScreenTextDurationSeconds = parcel.readInt();
        this.m_onScreenTextSize = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2408a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2409b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditText f2410c;

        a(Button button, EditText editText, EditText editText2) {
            this.f2408a = button;
            this.f2409b = editText;
            this.f2410c = editText2;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2408a;
            if (this.f2409b.getText().length() > 0 && this.f2410c.getText().length() > 0) {
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
    public class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2412a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RadioButton f2413b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditText f2414c;

        b(Button button, RadioButton radioButton, EditText editText) {
            this.f2412a = button;
            this.f2413b = radioButton;
            this.f2414c = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2412a;
            if (this.f2413b.isChecked() && this.f2414c.length() <= 0) {
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
}
