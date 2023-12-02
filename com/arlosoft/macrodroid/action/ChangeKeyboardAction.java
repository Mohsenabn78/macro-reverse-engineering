package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.ContentResolver;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.action.info.ChangeKeyboardActionInfo;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChangeKeyboardAction.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nChangeKeyboardAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChangeKeyboardAction.kt\ncom/arlosoft/macrodroid/action/ChangeKeyboardAction\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,118:1\n37#2,2:119\n*S KotlinDebug\n*F\n+ 1 ChangeKeyboardAction.kt\ncom/arlosoft/macrodroid/action/ChangeKeyboardAction\n*L\n83#1:119,2\n*E\n"})
/* loaded from: classes2.dex */
public final class ChangeKeyboardAction extends Action {
    @NotNull
    private String keyboardId;
    @NotNull
    private String keyboardName;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ChangeKeyboardAction> CREATOR = new Parcelable.Creator<ChangeKeyboardAction>() { // from class: com.arlosoft.macrodroid.action.ChangeKeyboardAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ChangeKeyboardAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ChangeKeyboardAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ChangeKeyboardAction[] newArray(int i4) {
            return new ChangeKeyboardAction[i4];
        }
    };

    public /* synthetic */ ChangeKeyboardAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final List<InputMethodInfo> M() {
        Object systemService = getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        List<InputMethodInfo> enabledInputMethodList = ((InputMethodManager) systemService).getEnabledInputMethodList();
        Intrinsics.checkNotNullExpressionValue(enabledInputMethodList, "imeManager.enabledInputMethodList");
        return enabledInputMethodList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        List<InputMethodInfo> M = M();
        String id = M.get(i4).getId();
        Intrinsics.checkNotNullExpressionValue(id, "keyboards[item].id");
        this.keyboardId = id;
        this.keyboardName = M.get(i4).loadLabel(getContext().getPackageManager()).toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        List<InputMethodInfo> M = M();
        int size = M.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (Intrinsics.areEqual(M.get(i4).getId(), this.keyboardId)) {
                return i4;
            }
        }
        this.keyboardName = M.get(0).loadLabel(getContext().getPackageManager()).toString();
        String id = M.get(0).getId();
        Intrinsics.checkNotNullExpressionValue(id, "keyboards[0].id");
        this.keyboardId = id;
        return 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        return this.keyboardName;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return ChangeKeyboardActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String configuredName = getConfiguredName();
        String extendedDetail = getExtendedDetail();
        return configuredName + " (" + extendedDetail + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
        boolean contains$default;
        boolean z3 = true;
        boolean z4 = false;
        if (!RootToolsHelper.isAccessGiven()) {
            try {
                String currentSettings = Settings.Secure.getString(getContext().getContentResolver(), "enabled_input_methods");
                Intrinsics.checkNotNullExpressionValue(currentSettings, "currentSettings");
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) currentSettings, (CharSequence) this.keyboardId, false, 2, (Object) null);
                if (!contains$default) {
                    ContentResolver contentResolver = getContext().getContentResolver();
                    String str = this.keyboardId;
                    z3 = true & Settings.Secure.putString(contentResolver, "enabled_input_methods", currentSettings + ":" + str);
                }
                z4 = z3 & Settings.Secure.putString(getContext().getContentResolver(), "default_input_method", this.keyboardId);
            } catch (Exception unused) {
            }
            if (!z4) {
                Long macroGuid = getMacroGuid();
                Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                SystemLog.logError("Could not set default keyboard, you need to grant permission via adb with the command: adb shell pm grant com.arlosoft.macrodroid android.permission.WRITE_SECURE_SETTINGS", macroGuid.longValue());
                return;
            }
            return;
        }
        String str2 = this.keyboardId;
        Util.runAsRoot(new String[]{"settings put secure enabled_input_methods " + str2});
        String str3 = this.keyboardId;
        Util.runAsRoot(new String[]{"settings put secure default_input_method " + str3});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String[] o() {
        List<InputMethodInfo> M = M();
        ArrayList arrayList = new ArrayList();
        for (InputMethodInfo inputMethodInfo : M) {
            arrayList.add(inputMethodInfo.loadLabel(getContext().getPackageManager()).toString());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.keyboardId);
        out.writeString(this.keyboardName);
    }

    public ChangeKeyboardAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public ChangeKeyboardAction() {
        this.keyboardId = "";
        this.keyboardName = "";
    }

    private ChangeKeyboardAction(Parcel parcel) {
        super(parcel);
        this.keyboardId = "";
        this.keyboardName = "";
        String readString = parcel.readString();
        Intrinsics.checkNotNull(readString);
        this.keyboardId = readString;
        String readString2 = parcel.readString();
        Intrinsics.checkNotNull(readString2);
        this.keyboardName = readString2;
    }

    /* compiled from: ChangeKeyboardAction.kt */
    /* loaded from: classes2.dex */
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
