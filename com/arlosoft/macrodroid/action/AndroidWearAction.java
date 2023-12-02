package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.afollestad.materialdialogs.MaterialDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.AndroidWearAction;
import com.arlosoft.macrodroid.action.info.AndroidWearActionInfo;
import com.arlosoft.macrodroid.action.services.AndroidWearService;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.activities.selecticon.IconSelectActivity;
import com.arlosoft.macrodroid.utils.AndroidWearConstants;
import com.arlosoft.macrodroid.utils.Vibrate;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.Wearable;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class AndroidWearAction extends Action implements MessageApi.MessageListener, SupportsMagicText {
    private static final int ANDROID_WEAR_BRIGHTNESS = 3;
    private static final int ANDROID_WEAR_NOTIFICATION = 1;
    private static final int ANDROID_WEAR_OPEN_APP = 0;
    private static final int ANDROID_WEAR_VIBRATE = 2;
    private static final int ANDROID_WEAR_WAKE_SCREEN = 4;
    private static final int ANDROID_WEAR_WIFI = 5;
    private static final int NUM_ACTIONS = 4;
    private static final int REQUEST_CODE_ICON_FOR_ACTION = 1;
    private static final int REQUEST_CODE_ICON_FOR_NOTIFICATION = 0;
    private boolean[] m_actionEnabledStates;
    private String[] m_actionIcons;
    private transient int m_actionIndex;
    private long[] m_actionMacroGuids;
    private String[] m_actionNames;
    private String m_applicationName;
    private int m_brightness;
    private transient GoogleApiClient m_googleApiClient;
    private transient ImageView m_iconImage;
    private transient ImageView m_iconImageAction;
    private String m_imageResourceName;
    private String m_notificationSubject;
    private String m_notificationText;
    private int m_option;
    private String m_packageToLaunch;
    private transient MaterialDialog m_progressDialog;
    private int m_vibratePattern;
    private int m_wifiOption;
    private static final String[] s_brightnessOptions = {"1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6"};
    public static final Parcelable.Creator<AndroidWearAction> CREATOR = new c();

    /* loaded from: classes2.dex */
    class c implements Parcelable.Creator<AndroidWearAction> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AndroidWearAction createFromParcel(Parcel parcel) {
            return new AndroidWearAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AndroidWearAction[] newArray(int i4) {
            return new AndroidWearAction[i4];
        }
    }

    /* synthetic */ AndroidWearAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(DialogInterface dialogInterface, int i4) {
        this.m_brightness = i4 + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(DialogInterface dialogInterface, int i4) {
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(int i4, Activity activity, View view) {
        this.m_actionIndex = i4;
        Intent intent = new Intent(activity, IconSelectActivity.class);
        intent.putExtra(IconSelectActivity.EXTRA_DISPLAY_APP_ICONS, false);
        activity.startActivityForResult(intent, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0(AppCompatDialog appCompatDialog, int i4, RadioButton radioButton, EditText editText, List list, Spinner spinner, ImageView imageView, View view) {
        float f4;
        appCompatDialog.cancel();
        this.m_actionEnabledStates[i4] = radioButton.isChecked();
        this.m_actionNames[i4] = editText.getText().toString();
        this.m_actionMacroGuids[i4] = ((Macro) list.get(spinner.getSelectedItemPosition())).getGUID();
        int resId = Util.getResId(getContext(), this.m_actionIcons[i4]);
        if (resId != -1) {
            if (this.m_actionEnabledStates[i4]) {
                f4 = 1.0f;
            } else {
                f4 = 0.25f;
            }
            imageView.setAlpha(f4);
            imageView.setImageResource(resId);
        }
        this.m_iconImageAction = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(AppCompatDialog appCompatDialog, View view) {
        this.m_iconImageAction = null;
        appCompatDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0(int i4, ImageView[] imageViewArr, int i5, View view) {
        u0(i4, imageViewArr[i4], i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void H0(Activity activity, View view) {
        Intent intent = new Intent(activity, IconSelectActivity.class);
        intent.putExtra(IconSelectActivity.EXTRA_DISPLAY_APP_ICONS, false);
        activity.startActivityForResult(intent, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I0(AppCompatDialog appCompatDialog, EditText editText, EditText editText2, View view) {
        appCompatDialog.cancel();
        this.m_notificationText = editText.getText().toString();
        this.m_notificationSubject = editText2.getText().toString();
        this.m_iconImage = null;
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J0(AppCompatDialog appCompatDialog, View view) {
        this.m_iconImage = null;
        appCompatDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void K0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void M0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O0(DialogInterface dialogInterface, int i4) {
        this.m_vibratePattern = i4;
        Vibrate.vibrateDevice(getContext(), this.m_vibratePattern);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(DialogInterface dialogInterface, int i4) {
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(DialogInterface dialogInterface, int i4) {
        this.m_wifiOption = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(DialogInterface dialogInterface, int i4) {
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U0(DialogInterface dialogInterface, int i4) {
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V0(Activity activity, AlertDialog.Builder builder) {
        if (!((MacroDroidBaseActivity) activity).isDestroyedOrFinishing()) {
            builder.create().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W0() {
        try {
            MaterialDialog materialDialog = this.m_progressDialog;
            if (materialDialog != null) {
                materialDialog.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X0(String[] strArr, String[] strArr2, DialogInterface dialogInterface, int i4) {
        this.m_packageToLaunch = strArr[i4];
        this.m_applicationName = strArr2[i4];
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.action_android_wear_open_app), MacroDroidApplication.getInstance().getString(R.string.action_android_wear_notification), MacroDroidApplication.getInstance().getString(R.string.action_android_wear_vibrate_device), MacroDroidApplication.getInstance().getString(R.string.action_android_wear_set_brightness), MacroDroidApplication.getInstance().getString(R.string.action_android_wear_wake_screen), MacroDroidApplication.getInstance().getString(R.string.action_set_wifi)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        new d(AndroidWearConstants.REQUEST_INSTALLED_APPS_PATH).execute((Object[]) null);
    }

    private void s0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.action_set_brightness);
        builder.setSingleChoiceItems(s_brightnessOptions, this.m_brightness - 1, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.c0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                AndroidWearAction.this.A0(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.d0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                AndroidWearAction.B0(dialogInterface, i4);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.f0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                AndroidWearAction.this.C0(dialogInterface, i4);
            }
        });
        builder.create().show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0086, code lost:
        if (getContext().getResources().getDrawable(r2) == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void t0(com.arlosoft.macrodroid.triggers.TriggerContextInfo r14) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.AndroidWearAction.t0(com.arlosoft.macrodroid.triggers.TriggerContextInfo):void");
    }

    private void u0(final int i4, final ImageView imageView, int i5) {
        boolean z3;
        String name;
        int resId;
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.android_wear_notification_action);
        appCompatDialog.setTitle(getName());
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.android_wear_notification_action_title);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.android_wear_notification_action_enabled_radio_button);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.android_wear_notification_action_change_icon_button);
        this.m_iconImageAction = (ImageView) appCompatDialog.findViewById(R.id.android_wear_notification_action_icon);
        ((RadioButton) appCompatDialog.findViewById(R.id.android_wear_notification_action_disabled_radio_button)).setChecked(!this.m_actionEnabledStates[i4]);
        radioButton.setChecked(this.m_actionEnabledStates[i4]);
        editText.setText(this.m_actionNames[i4]);
        editText.setSelection(editText.length());
        String[] strArr = this.m_actionIcons;
        if (strArr != null && strArr[i4] != null && (resId = Util.getResId(getContext(), this.m_actionIcons[i4])) != -1) {
            this.m_iconImage.setImageResource(resId);
        }
        final Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.android_wear_notification_action_macro_spinner);
        final List<Macro> allCompletedMacrosSorted = MacroStore.getInstance().getAllCompletedMacrosSorted(true);
        String[] strArr2 = new String[allCompletedMacrosSorted.size()];
        int i6 = 0;
        for (int i7 = 0; i7 < allCompletedMacrosSorted.size(); i7++) {
            if (this.m_actionMacroGuids[i4] == allCompletedMacrosSorted.get(i7).getGUID()) {
                i6 = i7;
            }
            if (allCompletedMacrosSorted.get(i7).getIsFavourite()) {
                name = "⭐ " + allCompletedMacrosSorted.get(i7).getName();
            } else {
                name = allCompletedMacrosSorted.get(i7).getName();
            }
            strArr2[i7] = name;
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(activity, 17367048, strArr2);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner.setSelection(i6);
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AndroidWearAction.this.D0(i4, activity, view);
            }
        });
        editText.addTextChangedListener(new b(button, editText, spinner));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AndroidWearAction.this.E0(appCompatDialog, i4, radioButton, editText, allCompletedMacrosSorted, spinner, imageView, view);
            }
        });
        if (editText.getText().length() > 0 && spinner.getAdapter().getCount() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        button.setEnabled(z3);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AndroidWearAction.this.F0(appCompatDialog, view);
            }
        });
        appCompatDialog.show();
    }

    private void v0() {
        int resId;
        float f4;
        int resId2;
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.android_wear_notification);
        appCompatDialog.setTitle(getName());
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.android_wear_notification_notification_text);
        final EditText editText2 = (EditText) appCompatDialog.findViewById(R.id.android_wear_notification_subject_text);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.android_wear_notification_change_icon_button);
        Button button4 = (Button) appCompatDialog.findViewById(R.id.android_wear_notification_magic_subject_button);
        Button button5 = (Button) appCompatDialog.findViewById(R.id.android_wear_notification_magic_text_button);
        this.m_iconImage = (ImageView) appCompatDialog.findViewById(R.id.android_wear_notification_preview_image);
        boolean z3 = true;
        ImageView[] imageViewArr = {(ImageView) appCompatDialog.findViewById(R.id.android_wear_notification_action_1), (ImageView) appCompatDialog.findViewById(R.id.android_wear_notification_action_2), (ImageView) appCompatDialog.findViewById(R.id.android_wear_notification_action_3), (ImageView) appCompatDialog.findViewById(R.id.android_wear_notification_action_4)};
        final ImageView[] imageViewArr2 = {(ImageView) appCompatDialog.findViewById(R.id.android_wear_notification_icon_action_1), (ImageView) appCompatDialog.findViewById(R.id.android_wear_notification_icon_action_2), (ImageView) appCompatDialog.findViewById(R.id.android_wear_notification_icon_action_3), (ImageView) appCompatDialog.findViewById(R.id.android_wear_notification_icon_action_4)};
        for (final int i4 = 0; i4 < 4; i4++) {
            final int identifier = getContext().getResources().getIdentifier(this.m_actionIcons[i4], "string", getContext().getPackageName());
            if (identifier == 0) {
                identifier = R.string.fa_cog;
            }
            imageViewArr[i4].setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.m0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AndroidWearAction.this.G0(i4, imageViewArr2, identifier, view);
                }
            });
            String[] strArr = this.m_actionIcons;
            if (strArr != null && strArr[i4] != null && (resId2 = Util.getResId(getContext(), this.m_actionIcons[i4])) != -1) {
                imageViewArr2[i4].setImageResource(resId2);
            }
            ImageView imageView = imageViewArr2[i4];
            if (this.m_actionEnabledStates[i4]) {
                f4 = 1.0f;
            } else {
                f4 = 0.25f;
            }
            imageView.setAlpha(f4);
        }
        if (this.m_imageResourceName != null && (resId = Util.getResId(getContext(), this.m_imageResourceName)) != -1) {
            this.m_iconImage.setImageResource(resId);
        }
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AndroidWearAction.H0(activity, view);
            }
        });
        String str = this.m_notificationText;
        if (str != null) {
            editText.setText(str);
            editText.setSelection(editText.length());
        }
        String str2 = this.m_notificationSubject;
        if (str2 != null) {
            editText2.setText(str2);
            editText2.setSelection(editText2.length());
        }
        a aVar = new a(button, editText, editText2);
        editText.addTextChangedListener(aVar);
        editText2.addTextChangedListener(aVar);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AndroidWearAction.this.I0(appCompatDialog, editText, editText2, view);
            }
        });
        button.setEnabled((editText.getText().length() <= 0 || editText2.getText().length() <= 0) ? false : false);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AndroidWearAction.this.J0(appCompatDialog, view);
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.q0
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                AndroidWearAction.K0(editText2, magicTextPair);
            }
        };
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AndroidWearAction.this.L0(activity, magicTextListener, view);
            }
        });
        final MagicText.MagicTextListener magicTextListener2 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.v
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                AndroidWearAction.M0(editText, magicTextPair);
            }
        };
        button5.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AndroidWearAction.this.N0(activity, magicTextListener2, view);
            }
        });
        appCompatDialog.show();
    }

    private void w0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.action_pebble_vibrate_pattern);
        builder.setSingleChoiceItems(Vibrate.getPatternNames(), this.m_vibratePattern, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.x
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                AndroidWearAction.this.O0(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.y
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                AndroidWearAction.P0(dialogInterface, i4);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.z
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                AndroidWearAction.this.Q0(dialogInterface, i4);
            }
        });
        builder.create().show();
    }

    private void x0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.action_set_wifi);
        builder.setSingleChoiceItems(y0(), this.m_wifiOption, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.a0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                AndroidWearAction.this.R0(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.b0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                AndroidWearAction.this.S0(dialogInterface, i4);
            }
        });
        builder.create().show();
    }

    private String[] y0() {
        return new String[]{SelectableItem.r(R.string.action_set_wifi_enable), SelectableItem.r(R.string.action_set_wifi_disable), SelectableItem.r(R.string.action_set_wifi_toggle)};
    }

    private void z0(byte[] bArr) {
        String str;
        final Activity activity = getActivity();
        activity.runOnUiThread(new Runnable() { // from class: com.arlosoft.macrodroid.action.t
            @Override // java.lang.Runnable
            public final void run() {
                AndroidWearAction.this.W0();
            }
        });
        try {
            try {
                str = new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                str = null;
            }
            String[] split = str.split(":");
            if (split != null && split.length == 2) {
                int i4 = 0;
                final String[] split2 = split[0].split(",");
                final String[] split3 = split[1].split(",");
                if (this.m_packageToLaunch != null) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= split2.length) {
                            break;
                        } else if (this.m_packageToLaunch.equals(split2[i5])) {
                            i4 = i5;
                            break;
                        } else {
                            i5++;
                        }
                    }
                }
                final AlertDialog.Builder builder = new AlertDialog.Builder(activity, m());
                builder.setTitle(p());
                builder.setSingleChoiceItems(split3, i4, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.e0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i6) {
                        AndroidWearAction.this.X0(split2, split3, dialogInterface, i6);
                    }
                });
                builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.j0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i6) {
                        AndroidWearAction.T0(dialogInterface, i6);
                    }
                });
                builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.k0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i6) {
                        AndroidWearAction.this.U0(dialogInterface, i6);
                    }
                });
                activity.runOnUiThread(new Runnable() { // from class: com.arlosoft.macrodroid.action.l0
                    @Override // java.lang.Runnable
                    public final void run() {
                        AndroidWearAction.V0(activity, builder);
                    }
                });
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        int i4 = this.m_option;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            if (i4 != 5) {
                                return null;
                            }
                            return SelectableItem.r(R.string.action_set_wifi) + ": " + y0()[this.m_wifiOption];
                        }
                        return SelectableItem.r(R.string.action_android_wear_wake_screen);
                    }
                    return SelectableItem.r(R.string.action_android_wear_set_brightness) + ": " + this.m_brightness;
                }
                return SelectableItem.r(R.string.action_android_wear_vibrate_device) + ": " + Vibrate.getPatternNames()[this.m_vibratePattern];
            }
            return SelectableItem.r(R.string.action_android_wear_notification) + ": " + this.m_notificationSubject;
        }
        return SelectableItem.r(R.string.action_android_wear_open_app) + ": " + this.m_applicationName;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return AndroidWearActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + " (" + getExtendedDetail() + ")";
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_notificationText, this.m_notificationSubject};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        setActivity(activity);
        if (i5 != 0) {
            if (i4 == 0) {
                this.m_imageResourceName = intent.getStringExtra(Util.DRAWABLE_NAME_EXTRA);
                if (this.m_iconImage != null) {
                    this.m_iconImage.setImageResource(Util.getResId(getContext(), this.m_imageResourceName));
                }
            } else if (i4 == 1) {
                this.m_actionIcons[this.m_actionIndex] = intent.getStringExtra(Util.DRAWABLE_NAME_EXTRA);
                int resId = Util.getResId(getContext(), this.m_actionIcons[this.m_actionIndex]);
                ImageView imageView = this.m_iconImageAction;
                if (imageView != null) {
                    imageView.setImageResource(resId);
                }
            }
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        int i4 = this.m_option;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            if (i4 == 5) {
                                AndroidWearService.requestSetWifi(getContext(), this.m_wifiOption);
                                return;
                            }
                            return;
                        }
                        AndroidWearService.requestWakeScreen(getContext());
                        return;
                    }
                    AndroidWearService.requestSetBrightness(getContext(), this.m_brightness);
                    return;
                }
                AndroidWearService.requestVibrate(getContext(), this.m_vibratePattern);
                return;
            }
            t0(triggerContextInfo);
            return;
        }
        AndroidWearService.requestOpenApp(getContext(), this.m_packageToLaunch);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.google.android.gms.wearable.MessageApi.MessageListener
    public void onMessageReceived(MessageEvent messageEvent) {
        if (messageEvent.getPath().equals(AndroidWearConstants.RESPONSE_INSTALLED_APPS_PATH)) {
            z0(messageEvent.getData());
            Wearable.MessageApi.removeListener(this.m_googleApiClient, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        int i4 = this.m_option;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            if (i4 != 5) {
                                super.secondaryItemConfirmed();
                                return;
                            } else {
                                x0();
                                return;
                            }
                        }
                        super.secondaryItemConfirmed();
                        return;
                    }
                    s0();
                    return;
                }
                w0();
                return;
            }
            v0();
            return;
        }
        r0();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 2) {
            this.m_notificationText = strArr[0];
            this.m_notificationSubject = strArr[1];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
        parcel.writeString(this.m_packageToLaunch);
        parcel.writeString(this.m_applicationName);
        parcel.writeInt(this.m_vibratePattern);
        parcel.writeInt(this.m_brightness);
        parcel.writeString(this.m_notificationText);
        parcel.writeString(this.m_notificationSubject);
        parcel.writeString(this.m_imageResourceName);
        parcel.writeStringArray(this.m_actionNames);
        parcel.writeStringArray(this.m_actionIcons);
        parcel.writeLongArray(this.m_actionMacroGuids);
        parcel.writeBooleanArray(this.m_actionEnabledStates);
        parcel.writeInt(this.m_wifiOption);
    }

    public AndroidWearAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
        this.m_option = 0;
        this.m_actionNames = new String[4];
        this.m_actionMacroGuids = new long[4];
        this.m_actionEnabledStates = new boolean[4];
        String r4 = SelectableItem.r(R.string.fa_cog);
        this.m_actionIcons = new String[]{r4, r4, r4, r4};
    }

    private AndroidWearAction() {
    }

    private AndroidWearAction(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
        this.m_packageToLaunch = parcel.readString();
        this.m_applicationName = parcel.readString();
        this.m_vibratePattern = parcel.readInt();
        this.m_brightness = parcel.readInt();
        this.m_notificationText = parcel.readString();
        this.m_notificationSubject = parcel.readString();
        this.m_imageResourceName = parcel.readString();
        String[] strArr = new String[4];
        this.m_actionNames = strArr;
        parcel.readStringArray(strArr);
        String[] strArr2 = new String[4];
        this.m_actionIcons = strArr2;
        parcel.readStringArray(strArr2);
        long[] jArr = new long[4];
        this.m_actionMacroGuids = jArr;
        parcel.readLongArray(jArr);
        boolean[] zArr = new boolean[4];
        this.m_actionEnabledStates = zArr;
        parcel.readBooleanArray(zArr);
        this.m_wifiOption = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d extends AsyncTask<Void, Void, Integer> {

        /* renamed from: a  reason: collision with root package name */
        private final String f2087a;

        /* renamed from: b  reason: collision with root package name */
        private int f2088b;

        public d(String str) {
            this.f2087a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(DialogInterface dialogInterface, int i4) {
            AndroidWearAction.this.r0();
            dialogInterface.cancel();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c */
        public Integer doInBackground(Void... voidArr) {
            this.f2088b = 0;
            AndroidWearAction androidWearAction = AndroidWearAction.this;
            androidWearAction.m_googleApiClient = new GoogleApiClient.Builder(androidWearAction.getContext()).addApi(Wearable.API).build();
            if (!AndroidWearAction.this.m_googleApiClient.blockingConnect(30L, TimeUnit.SECONDS).isSuccess()) {
                Log.e(((SelectableItem) AndroidWearAction.this).m_classType, "Failed to connect to GoogleApiClient.");
                return 0;
            }
            HashSet hashSet = new HashSet();
            for (Node node : Wearable.NodeApi.getConnectedNodes(AndroidWearAction.this.m_googleApiClient).await().getNodes()) {
                hashSet.add(node.getId());
            }
            if (hashSet.size() > 0) {
                MessageApi messageApi = Wearable.MessageApi;
                messageApi.addListener(AndroidWearAction.this.m_googleApiClient, AndroidWearAction.this);
                MessageApi.SendMessageResult await = messageApi.sendMessage(AndroidWearAction.this.m_googleApiClient, (String) hashSet.iterator().next(), AndroidWearConstants.REQUEST_INSTALLED_APPS_PATH, null).await();
                if (!await.getStatus().isSuccess()) {
                    String str = ((SelectableItem) AndroidWearAction.this).m_classType;
                    Log.e(str, "ERROR: failed to send Message: " + await.getStatus());
                    messageApi.removeListener(AndroidWearAction.this.m_googleApiClient, AndroidWearAction.this);
                    this.f2088b = 2;
                } else {
                    String unused = ((SelectableItem) AndroidWearAction.this).m_classType;
                    StringBuilder sb = new StringBuilder();
                    sb.append("SENT: sent Message: ");
                    sb.append(await.getStatus());
                    return 3;
                }
            } else {
                this.f2088b = 2;
            }
            AndroidWearAction.this.m_googleApiClient.disconnect();
            return Integer.valueOf(this.f2088b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: f */
        public void onPostExecute(Integer num) {
            Activity activity = AndroidWearAction.this.getActivity();
            if (num.intValue() != 3) {
                try {
                    if (AndroidWearAction.this.checkActivityAlive()) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(activity, AndroidWearAction.this.m());
                        builder.setTitle(R.string.action_android_wear_connection_failed);
                        builder.setMessage(R.string.action_android_wear_could_not_connect);
                        builder.setPositiveButton(R.string.retry, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.r0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i4) {
                                AndroidWearAction.d.this.d(dialogInterface, i4);
                            }
                        });
                        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.s0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i4) {
                                dialogInterface.cancel();
                            }
                        });
                        builder.show();
                    }
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            Activity activity = AndroidWearAction.this.getActivity();
            AndroidWearAction.this.m_progressDialog = new MaterialDialog.Builder(activity).title(R.string.please_wait).content(R.string.action_android_wear_obtaining_app_list).progress(true, 0).cancelable(true).widgetColor(ContextCompat.getColor(AndroidWearAction.this.getActivity(), R.color.actions_primary)).show();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: g */
        public void onProgressUpdate(Void... voidArr) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B0(DialogInterface dialogInterface, int i4) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P0(DialogInterface dialogInterface, int i4) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void T0(DialogInterface dialogInterface, int i4) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2079a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2080b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditText f2081c;

        a(Button button, EditText editText, EditText editText2) {
            this.f2079a = button;
            this.f2080b = editText;
            this.f2081c = editText2;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2079a;
            if (this.f2080b.getText().length() > 0 && this.f2081c.getText().length() > 0) {
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
        final /* synthetic */ Button f2083a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2084b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Spinner f2085c;

        b(Button button, EditText editText, Spinner spinner) {
            this.f2083a = button;
            this.f2084b = editText;
            this.f2085c = spinner;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2083a;
            if (this.f2084b.getText().length() > 0 && this.f2085c.getAdapter().getCount() > 0) {
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
