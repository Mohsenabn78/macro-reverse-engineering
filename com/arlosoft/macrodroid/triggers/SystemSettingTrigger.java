package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.info.SystemSettingTriggerInfo;
import com.arlosoft.macrodroid.utils.WildCardHelper;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SystemSettingTrigger.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class SystemSettingTrigger extends Trigger implements SupportsMagicText {
    private static int triggerCount;
    @Nullable
    private transient SettingsContentObserver contentObserver;
    private boolean globalEnabled;
    private boolean regexEnabled;
    private boolean secureEnabled;
    @NotNull
    private String settingPattern;
    private boolean systemEnabled;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SystemSettingTrigger> CREATOR = new Parcelable.Creator<SystemSettingTrigger>() { // from class: com.arlosoft.macrodroid.triggers.SystemSettingTrigger$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SystemSettingTrigger createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SystemSettingTrigger(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SystemSettingTrigger[] newArray(int i4) {
            return new SystemSettingTrigger[i4];
        }
    };

    /* compiled from: SystemSettingTrigger.kt */
    /* loaded from: classes3.dex */
    public static final class SettingsContentObserver extends ContentObserver {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SettingsContentObserver(@NotNull Handler h4) {
            super(h4);
            Intrinsics.checkNotNullParameter(h4, "h");
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z3, @Nullable Uri uri, int i4) {
            boolean startsWith$default;
            String substringAfter$default;
            boolean startsWith$default2;
            String substringAfter$default2;
            boolean startsWith$default3;
            String substringAfter$default3;
            super.onChange(z3, uri, i4);
            if (uri != null) {
                ArrayList arrayList = new ArrayList();
                for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                    Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                    while (it.hasNext()) {
                        Trigger next = it.next();
                        if (next instanceof SystemSettingTrigger) {
                            SystemSettingTrigger systemSettingTrigger = (SystemSettingTrigger) next;
                            if (systemSettingTrigger.isSystemEnabled()) {
                                String uri2 = uri.toString();
                                Intrinsics.checkNotNullExpressionValue(uri2, "it.toString()");
                                startsWith$default3 = kotlin.text.m.startsWith$default(uri2, "content://settings/system", false, 2, null);
                                if (startsWith$default3) {
                                    String uri3 = uri.toString();
                                    Intrinsics.checkNotNullExpressionValue(uri3, "it.toString()");
                                    substringAfter$default3 = StringsKt__StringsKt.substringAfter$default(uri3, "content://settings/system/", (String) null, 2, (Object) null);
                                    if (systemSettingTrigger.matchesPattern(substringAfter$default3)) {
                                        try {
                                            TriggerContextInfo createSystemSettingContextInfo = TriggerContextInfo.createSystemSettingContextInfo(next, "System", substringAfter$default3, Settings.System.getString(MacroDroidApplication.Companion.getInstance().getContentResolver(), substringAfter$default3));
                                            if (next.constraintsMet(createSystemSettingContextInfo)) {
                                                macro.setTriggerThatInvoked(next);
                                                macro.setTriggerContextInfo(createSystemSettingContextInfo);
                                                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                                    arrayList.add(macro);
                                                }
                                            }
                                        } catch (Exception e4) {
                                            SystemLog.logWarning("Could not read value " + substringAfter$default3 + ": " + e4);
                                        }
                                    }
                                }
                            }
                            if (systemSettingTrigger.isGlobalEnabled()) {
                                String uri4 = uri.toString();
                                Intrinsics.checkNotNullExpressionValue(uri4, "it.toString()");
                                startsWith$default2 = kotlin.text.m.startsWith$default(uri4, "content://settings/global", false, 2, null);
                                if (startsWith$default2) {
                                    String uri5 = uri.toString();
                                    Intrinsics.checkNotNullExpressionValue(uri5, "it.toString()");
                                    substringAfter$default2 = StringsKt__StringsKt.substringAfter$default(uri5, "content://settings/global/", (String) null, 2, (Object) null);
                                    if (systemSettingTrigger.matchesPattern(substringAfter$default2)) {
                                        try {
                                            TriggerContextInfo createSystemSettingContextInfo2 = TriggerContextInfo.createSystemSettingContextInfo(next, "Global", substringAfter$default2, Settings.Global.getString(MacroDroidApplication.Companion.getInstance().getContentResolver(), substringAfter$default2));
                                            if (next.constraintsMet(createSystemSettingContextInfo2)) {
                                                macro.setTriggerThatInvoked(next);
                                                macro.setTriggerContextInfo(createSystemSettingContextInfo2);
                                                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                                    arrayList.add(macro);
                                                }
                                            }
                                        } catch (Exception e5) {
                                            SystemLog.logWarning("Could not read value " + substringAfter$default2 + ": " + e5);
                                        }
                                    }
                                }
                            }
                            if (systemSettingTrigger.isSecureEnabled()) {
                                String uri6 = uri.toString();
                                Intrinsics.checkNotNullExpressionValue(uri6, "it.toString()");
                                startsWith$default = kotlin.text.m.startsWith$default(uri6, "content://settings/secure", false, 2, null);
                                if (startsWith$default) {
                                    String uri7 = uri.toString();
                                    Intrinsics.checkNotNullExpressionValue(uri7, "it.toString()");
                                    substringAfter$default = StringsKt__StringsKt.substringAfter$default(uri7, "content://settings/secure/", (String) null, 2, (Object) null);
                                    if (systemSettingTrigger.matchesPattern(substringAfter$default)) {
                                        try {
                                            TriggerContextInfo createSystemSettingContextInfo3 = TriggerContextInfo.createSystemSettingContextInfo(next, "Secure", substringAfter$default, Settings.Secure.getString(MacroDroidApplication.Companion.getInstance().getContentResolver(), substringAfter$default));
                                            if (next.constraintsMet(createSystemSettingContextInfo3)) {
                                                macro.setTriggerThatInvoked(next);
                                                macro.setTriggerContextInfo(createSystemSettingContextInfo3);
                                                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                                    arrayList.add(macro);
                                                }
                                                arrayList.add(macro);
                                            }
                                        } catch (Exception e6) {
                                            SystemLog.logWarning("Could not read value " + substringAfter$default + ": " + e6);
                                        }
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
    }

    public /* synthetic */ SystemSettingTrigger(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(EditText patternText, MagicText.MagicTextPair pair) {
        int coerceAtLeast;
        int coerceAtLeast2;
        int coerceAtMost;
        int coerceAtLeast3;
        Intrinsics.checkNotNullParameter(patternText, "$patternText");
        Intrinsics.checkNotNullParameter(pair, "pair");
        coerceAtLeast = kotlin.ranges.h.coerceAtLeast(patternText.getSelectionStart(), 0);
        coerceAtLeast2 = kotlin.ranges.h.coerceAtLeast(patternText.getSelectionEnd(), 0);
        Editable text = patternText.getText();
        coerceAtMost = kotlin.ranges.h.coerceAtMost(coerceAtLeast, coerceAtLeast2);
        coerceAtLeast3 = kotlin.ranges.h.coerceAtLeast(coerceAtLeast, coerceAtLeast2);
        String str = pair.magicText;
        text.replace(coerceAtMost, coerceAtLeast3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(SystemSettingTrigger this$0, MagicText.MagicTextListener magicTextListener, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        MagicText.displaySelectionDialog(this$0.getActivity(), magicTextListener, this$0.getMacro(), false, true, true, R.style.Theme_App_Dialog_Trigger_SmallText, this$0.isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(CheckBox systemCheckbox, CheckBox globalCheckbox, CheckBox secureCheckbox, SystemSettingTrigger this$0, AppCompatDialog dialog, CheckBox regexCheckbox, EditText patternText, View view) {
        Intrinsics.checkNotNullParameter(systemCheckbox, "$systemCheckbox");
        Intrinsics.checkNotNullParameter(globalCheckbox, "$globalCheckbox");
        Intrinsics.checkNotNullParameter(secureCheckbox, "$secureCheckbox");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(regexCheckbox, "$regexCheckbox");
        Intrinsics.checkNotNullParameter(patternText, "$patternText");
        if (!systemCheckbox.isChecked() && !globalCheckbox.isChecked() && !secureCheckbox.isChecked()) {
            ToastCompat.makeText(this$0.getContext(), (int) R.string.action_set_bluetooth_invalid, 0).show();
            return;
        }
        dialog.dismiss();
        this$0.systemEnabled = systemCheckbox.isChecked();
        this$0.globalEnabled = globalCheckbox.isChecked();
        this$0.secureEnabled = secureCheckbox.isChecked();
        this$0.regexEnabled = regexCheckbox.isChecked();
        this$0.settingPattern = patternText.getText().toString();
        this$0.itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.cancel();
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    protected void disableTrigger() {
        SettingsContentObserver settingsContentObserver;
        int i4 = triggerCount - 1;
        triggerCount = i4;
        if (i4 == 0 && (settingsContentObserver = this.contentObserver) != null) {
            getContext().getApplicationContext().getContentResolver().unregisterContentObserver(settingsContentObserver);
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    protected void enableTrigger() {
        if (triggerCount == 0) {
            SettingsContentObserver settingsContentObserver = new SettingsContentObserver(new Handler());
            getContext().getApplicationContext().getContentResolver().registerContentObserver(Uri.parse("content://settings"), true, settingsContentObserver);
            this.contentObserver = settingsContentObserver;
        }
        triggerCount++;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        boolean z3;
        String str = this.settingPattern;
        if (str != null && str.length() != 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            String r4 = SelectableItem.r(R.string.any);
            Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.any)");
            return r4;
        }
        return this.settingPattern;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return SystemSettingTriggerInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        return new String[]{this.settingPattern};
    }

    public final boolean isGlobalEnabled() {
        return this.globalEnabled;
    }

    public final boolean isSecureEnabled() {
        return this.secureEnabled;
    }

    public final boolean isSystemEnabled() {
        return this.systemEnabled;
    }

    public final boolean matchesPattern(@NotNull String settingText) {
        Intrinsics.checkNotNullParameter(settingText, "settingText");
        if (TextUtils.isEmpty(this.settingPattern)) {
            return true;
        }
        return WildCardHelper.matches(MagicText.replaceMagicText(getContext(), settingText, null, getMacro()), WildCardHelper.getRegexContainsPattern(this.settingPattern, this.regexEnabled, false), this.regexEnabled, false);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void onItemSelected() {
        if (!checkActivityAlive()) {
            return;
        }
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setTitle(R.string.trigger_system_setting_change);
        appCompatDialog.setContentView(R.layout.dialog_system_setting_trigger);
        DialogExtensionsKt.setWidthToParent(appCompatDialog, 0);
        View findViewById = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById);
        Button button = (Button) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById2);
        Button button2 = (Button) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.systemCheckbox);
        Intrinsics.checkNotNull(findViewById3);
        final CheckBox checkBox = (CheckBox) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.globalCheckbox);
        Intrinsics.checkNotNull(findViewById4);
        final CheckBox checkBox2 = (CheckBox) findViewById4;
        View findViewById5 = appCompatDialog.findViewById(R.id.secureCheckbox);
        Intrinsics.checkNotNull(findViewById5);
        final CheckBox checkBox3 = (CheckBox) findViewById5;
        View findViewById6 = appCompatDialog.findViewById(R.id.patternText);
        Intrinsics.checkNotNull(findViewById6);
        final EditText editText = (EditText) findViewById6;
        View findViewById7 = appCompatDialog.findViewById(R.id.magicTextButton);
        Intrinsics.checkNotNull(findViewById7);
        View findViewById8 = appCompatDialog.findViewById(R.id.regexCheckbox);
        Intrinsics.checkNotNull(findViewById8);
        final CheckBox checkBox4 = (CheckBox) findViewById8;
        checkBox.setChecked(this.systemEnabled);
        checkBox2.setChecked(this.globalEnabled);
        checkBox3.setChecked(this.secureEnabled);
        checkBox4.setChecked(this.regexEnabled);
        editText.setText(this.settingPattern);
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.triggers.o8
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                SystemSettingTrigger.Q(editText, magicTextPair);
            }
        };
        ((Button) findViewById7).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.p8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SystemSettingTrigger.R(SystemSettingTrigger.this, magicTextListener, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.q8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SystemSettingTrigger.S(checkBox, checkBox2, checkBox3, this, appCompatDialog, checkBox4, editText, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.r8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SystemSettingTrigger.T(AppCompatDialog.this, view);
            }
        });
        appCompatDialog.show();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@NotNull String[] magicText) {
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        if (magicText.length == 1) {
            this.settingPattern = magicText[0];
            return;
        }
        String str = this.m_classType;
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + str + ")"));
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.systemEnabled ? 1 : 0);
        out.writeInt(this.globalEnabled ? 1 : 0);
        out.writeInt(this.secureEnabled ? 1 : 0);
        out.writeInt(this.regexEnabled ? 1 : 0);
        out.writeString(this.settingPattern);
    }

    public SystemSettingTrigger(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public SystemSettingTrigger() {
        this.systemEnabled = true;
        this.globalEnabled = true;
        this.secureEnabled = true;
        this.settingPattern = "";
    }

    private SystemSettingTrigger(Parcel parcel) {
        super(parcel);
        this.systemEnabled = true;
        this.globalEnabled = true;
        this.secureEnabled = true;
        this.settingPattern = "";
        this.systemEnabled = parcel.readInt() != 0;
        this.globalEnabled = parcel.readInt() != 0;
        this.secureEnabled = parcel.readInt() != 0;
        this.regexEnabled = parcel.readInt() != 0;
        String readString = parcel.readString();
        this.settingPattern = readString != null ? readString : "";
    }

    /* compiled from: SystemSettingTrigger.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
