package com.arlosoft.macrodroid.triggers;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.clipboard.ClipboardReadActivity;
import com.arlosoft.macrodroid.clipboard.logcat.LogcatClipboardDetector;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.info.ClipboardChangeTriggerInfo;
import com.arlosoft.macrodroid.utils.AdbHelperUtil;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import com.arlosoft.macrodroid.utils.WildCardHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ClipboardChangeTrigger extends Trigger implements SupportsMagicText {
    public static final Parcelable.Creator<ClipboardChangeTrigger> CREATOR = new b();
    private static LogcatClipboardDetector logcatClipboardDetector;
    private static c s_clipboardListener;
    private static int s_triggerCounter;
    private boolean enableRegex;
    private boolean ignoreCase;
    private boolean isConfigured;
    private String m_text;
    private boolean useAccessibilityService;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements LogcatClipboardDetector.Listener {
        a() {
        }

        @Override // com.arlosoft.macrodroid.clipboard.logcat.LogcatClipboardDetector.Listener
        public void onClipboardEvent() {
            ClipboardReadActivity.startIfRequired(ClipboardChangeTrigger.this.getContext());
        }
    }

    /* loaded from: classes3.dex */
    class b implements Parcelable.Creator<ClipboardChangeTrigger> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ClipboardChangeTrigger createFromParcel(Parcel parcel) {
            return new ClipboardChangeTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ClipboardChangeTrigger[] newArray(int i4) {
            return new ClipboardChangeTrigger[i4];
        }
    }

    /* loaded from: classes3.dex */
    private static class c implements ClipboardManager.OnPrimaryClipChangedListener {

        /* renamed from: a  reason: collision with root package name */
        private final ClipboardManager f14351a;

        /* renamed from: b  reason: collision with root package name */
        private final Context f14352b;

        public c(Context context, ClipboardManager clipboardManager) {
            this.f14351a = clipboardManager;
            this.f14352b = context;
        }

        @Override // android.content.ClipboardManager.OnPrimaryClipChangedListener
        public void onPrimaryClipChanged() {
            String str;
            ClipData.Item itemAt;
            ClipData primaryClip = this.f14351a.getPrimaryClip();
            if (primaryClip != null && (itemAt = primaryClip.getItemAt(0)) != null) {
                str = itemAt.coerceToText(this.f14352b).toString();
            } else {
                str = null;
            }
            if (str == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                while (it.hasNext()) {
                    Trigger next = it.next();
                    if (next instanceof ClipboardChangeTrigger) {
                        ClipboardChangeTrigger clipboardChangeTrigger = (ClipboardChangeTrigger) next;
                        String regexPattern = WildCardHelper.getRegexPattern(MagicText.replaceMagicText(this.f14352b, clipboardChangeTrigger.getText(), null, macro), clipboardChangeTrigger.enableRegex, clipboardChangeTrigger.ignoreCase);
                        if (TextUtils.isEmpty(clipboardChangeTrigger.getText()) || WildCardHelper.matches(str, regexPattern, clipboardChangeTrigger.enableRegex, clipboardChangeTrigger.ignoreCase)) {
                            if (next.constraintsMet()) {
                                macro.setTriggerThatInvoked(next);
                                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                    arrayList.add(macro);
                                }
                            }
                        }
                    }
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Macro macro2 = (Macro) it2.next();
                macro2.invokeActions(macro2.getTriggerContextInfo());
            }
        }
    }

    /* synthetic */ ClipboardChangeTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void T(CheckBox checkBox, CompoundButton compoundButton, boolean z3) {
        checkBox.setEnabled(!z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(CheckBox checkBox, Activity activity, EditText editText, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, AppCompatDialog appCompatDialog, View view) {
        if (Build.VERSION.SDK_INT >= 29 && checkBox.isChecked() && ContextCompat.checkSelfPermission(getContext(), "android.permission.READ_LOGS") != 0) {
            if (RootToolsHelper.isAccessGiven()) {
                Util.runAsRoot(new String[]{"pm grant com.arlosoft.macrodroid android.permission.READ_LOGS"});
            } else {
                AdbHelperUtil.showAdbHackDetails(activity, Collections.singletonList("android.permission.READ_LOGS"));
                return;
            }
        }
        this.m_text = editText.getText().toString();
        this.enableRegex = checkBox2.isChecked();
        this.ignoreCase = checkBox3.isChecked();
        this.useAccessibilityService = checkBox4.isChecked();
        this.isConfigured = true;
        Settings.setClipboardTriggerUseLogcat(getContext(), checkBox.isChecked());
        appCompatDialog.cancel();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void W(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), false, true, true, R.style.Theme_App_Dialog_Trigger_SmallText, IteratorType.NONE);
    }

    @TargetApi(29)
    private void Y() {
        if (logcatClipboardDetector == null) {
            if (ContextCompat.checkSelfPermission(getContext(), "android.permission.READ_LOGS") != 0) {
                if (RootToolsHelper.isAccessGiven()) {
                    Util.runAsRoot(new String[]{"pm grant com.arlosoft.macrodroid android.permission.READ_LOGS"});
                } else {
                    SystemLog.logError("Could not initialise Clipboard logcat listener, you need to grant permission via adb with the command: adb shell pm grant com.arlosoft.macrodroid android.permission.READ_LOGS", getMacroGuid().longValue());
                    return;
                }
            }
            LogcatClipboardDetector logcatClipboardDetector2 = new LogcatClipboardDetector(getContext());
            logcatClipboardDetector = logcatClipboardDetector2;
            logcatClipboardDetector2.registerListener(new a());
            SystemLog.logVerbose("Listening to logcat for clipboard events");
            logcatClipboardDetector.startDetecting();
        }
    }

    public static int getActiveTriggerCounter() {
        return s_triggerCounter;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        LogcatClipboardDetector logcatClipboardDetector2;
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            try {
                ((ClipboardManager) getContext().getApplicationContext().getSystemService("clipboard")).removePrimaryClipChangedListener(s_clipboardListener);
                s_clipboardListener = null;
            } catch (Exception unused) {
            }
            if (Build.VERSION.SDK_INT >= 29 && (logcatClipboardDetector2 = logcatClipboardDetector) != null) {
                logcatClipboardDetector2.stopDetecting();
                logcatClipboardDetector.dispose();
                logcatClipboardDetector = null;
            }
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
            c cVar = new c(getContext().getApplicationContext(), clipboardManager);
            s_clipboardListener = cVar;
            clipboardManager.addPrimaryClipChangedListener(cVar);
            if (Build.VERSION.SDK_INT >= 29 && Settings.getClipboardTriggerUseLogcat(getContext())) {
                Y();
            }
        }
        s_triggerCounter++;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public List<String> getAdbHackPermissionRequired() {
        if (this.isConfigured && Build.VERSION.SDK_INT >= 29 && Settings.getClipboardTriggerUseLogcat(getContext())) {
            return Collections.singletonList("android.permission.READ_LOGS");
        }
        return new ArrayList();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getEditModeWarning() {
        if (!isValid()) {
            return SelectableItem.r(R.string.clipboard_android_10_warning);
        }
        return null;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        if (TextUtils.isEmpty(this.m_text)) {
            return SelectableItem.r(R.string.any);
        }
        return this.m_text;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ClipboardChangeTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + " (" + MDTextUtils.truncateIfRequired(getExtendedDetail(), 20) + ")";
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_text};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        return getConfiguredName() + " (" + MDTextUtils.truncateIfRequired(getExtendedDetail(), 200) + ")";
    }

    public String getText() {
        return this.m_text;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        int i4;
        int i5;
        if (!checkActivityAlive()) {
            return;
        }
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_clipboard_change_trigger);
        appCompatDialog.setTitle(R.string.trigger_clipboard_change);
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
        final CheckBox checkBox3 = (CheckBox) appCompatDialog.findViewById(R.id.useAccessibilityCheckbox);
        final CheckBox checkBox4 = (CheckBox) appCompatDialog.findViewById(R.id.useLogcatCheckbox);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.useAccessibilityInfo);
        TextView textView2 = (TextView) appCompatDialog.findViewById(R.id.useLogcatInfo);
        String str = this.m_text;
        if (str != null) {
            editText.setText(str);
            editText.setSelection(editText.length());
        }
        checkBox2.setEnabled(!this.enableRegex);
        checkBox2.setChecked(this.ignoreCase);
        checkBox.setChecked(this.enableRegex);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.h2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                ClipboardChangeTrigger.T(checkBox2, compoundButton, z3);
            }
        });
        checkBox3.setChecked(this.useAccessibilityService);
        checkBox4.setChecked(Settings.getClipboardTriggerUseLogcat(getContext()));
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 29) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        checkBox4.setVisibility(i4);
        if (i6 >= 29) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        textView2.setVisibility(i5);
        checkBox3.setVisibility(8);
        textView.setVisibility(8);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.i2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClipboardChangeTrigger.this.U(checkBox4, activity, editText, checkBox, checkBox2, checkBox3, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.j2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.triggers.k2
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                ClipboardChangeTrigger.W(editText, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.l2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClipboardChangeTrigger.this.X(activity, magicTextListener, view);
            }
        });
        appCompatDialog.show();
    }

    public boolean isEnableRegex() {
        return this.enableRegex;
    }

    public boolean isIgnoreCase() {
        return this.ignoreCase;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isRootOnly() {
        if (this.isConfigured && Build.VERSION.SDK_INT >= 29 && Settings.getClipboardTriggerUseLogcat(getContext())) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresCanDrawOverlays() {
        if (Build.VERSION.SDK_INT >= 29 && Settings.getClipboardTriggerUseLogcat(getContext())) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresUIInteractionAccessibility() {
        if (this.isConfigured && Build.VERSION.SDK_INT >= 29 && this.useAccessibilityService) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 1) {
            this.m_text = strArr[0];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_text);
        parcel.writeInt(this.enableRegex ? 1 : 0);
        parcel.writeInt(this.useAccessibilityService ? 1 : 0);
        parcel.writeInt(this.isConfigured ? 1 : 0);
        parcel.writeInt(this.ignoreCase ? 1 : 0);
    }

    public ClipboardChangeTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private ClipboardChangeTrigger() {
        this.ignoreCase = true;
        this.useAccessibilityService = false;
        this.isConfigured = false;
        this.m_text = "";
    }

    private ClipboardChangeTrigger(Parcel parcel) {
        super(parcel);
        this.ignoreCase = true;
        this.useAccessibilityService = false;
        this.isConfigured = false;
        this.m_text = parcel.readString();
        this.enableRegex = parcel.readInt() != 0;
        this.useAccessibilityService = parcel.readInt() != 0;
        this.isConfigured = parcel.readInt() != 0;
        this.ignoreCase = parcel.readInt() != 0;
    }
}
