package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SetDigitalAssistantActionInfo;
import com.arlosoft.macrodroid.common.AppInfo;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SetDigitalAssistantAction.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nSetDigitalAssistantAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SetDigitalAssistantAction.kt\ncom/arlosoft/macrodroid/action/SetDigitalAssistantAction\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,131:1\n1549#2:132\n1620#2,3:133\n350#2,7:138\n37#3,2:136\n*S KotlinDebug\n*F\n+ 1 SetDigitalAssistantAction.kt\ncom/arlosoft/macrodroid/action/SetDigitalAssistantAction\n*L\n103#1:132\n103#1:133,3\n107#1:138,7\n103#1:136,2\n*E\n"})
/* loaded from: classes2.dex */
public final class SetDigitalAssistantAction extends Action {
    @NotNull
    private transient ArrayList<AppInfo> appInfoList;
    @Nullable
    private String assistantName;
    @Nullable
    private String assistantPackageAndService;
    private transient int selectedIndex;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SetDigitalAssistantAction> CREATOR = new Parcelable.Creator<SetDigitalAssistantAction>() { // from class: com.arlosoft.macrodroid.action.SetDigitalAssistantAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SetDigitalAssistantAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SetDigitalAssistantAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SetDigitalAssistantAction[] newArray(int i4) {
            return new SetDigitalAssistantAction[i4];
        }
    };

    public /* synthetic */ SetDigitalAssistantAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(SetDigitalAssistantAction this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        super.handleItemSelected();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.selectedIndex = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        int coerceAtLeast;
        Iterator<AppInfo> it = this.appInfoList.iterator();
        int i4 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().packageName, this.assistantPackageAndService)) {
                    break;
                }
                i4++;
            } else {
                i4 = -1;
                break;
            }
        }
        coerceAtLeast = kotlin.ranges.h.coerceAtLeast(i4, 0);
        this.selectedIndex = coerceAtLeast;
        return coerceAtLeast;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String str = this.assistantName;
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return SetDigitalAssistantActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String configuredName = getConfiguredName();
        String extendedDetail = getExtendedDetail();
        return configuredName + " (" + extendedDetail + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(getName());
        builder.setMessage(getHelpInfo());
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.gj
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SetDigitalAssistantAction.N(SetDigitalAssistantAction.this, dialogInterface, i4);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // com.arlosoft.macrodroid.action.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void invokeAction(@org.jetbrains.annotations.Nullable com.arlosoft.macrodroid.triggers.TriggerContextInfo r6) {
        /*
            r5 = this;
            r6 = 0
            android.content.Context r0 = r5.getContext()     // Catch: java.lang.Exception -> L27
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Exception -> L27
            java.lang.String r1 = "assistant"
            java.lang.String r2 = r5.assistantPackageAndService     // Catch: java.lang.Exception -> L27
            boolean r0 = android.provider.Settings.Secure.putString(r0, r1, r2)     // Catch: java.lang.Exception -> L27
            if (r0 == 0) goto L4a
            android.content.Context r1 = r5.getContext()     // Catch: java.lang.Exception -> L25
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Exception -> L25
            java.lang.String r2 = "voice_interaction_service"
            java.lang.String r3 = r5.assistantPackageAndService     // Catch: java.lang.Exception -> L25
            boolean r0 = android.provider.Settings.Secure.putString(r1, r2, r3)     // Catch: java.lang.Exception -> L25
            goto L4a
        L25:
            goto L29
        L27:
            r0 = 0
        L29:
            boolean r1 = com.arlosoft.macrodroid.root.RootToolsHelper.isAccessGiven()
            if (r1 == 0) goto L4a
            r0 = 1
            java.lang.String[] r1 = new java.lang.String[r0]
            java.lang.String r2 = r5.assistantPackageAndService
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "settings put secure enabled_accessibility_services "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1[r6] = r2
            com.arlosoft.macrodroid.common.Util.runAsRoot(r1)
        L4a:
            if (r0 != 0) goto L5e
            java.lang.Long r6 = r5.getMacroGuid()
            java.lang.String r0 = "macroGuid"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            long r0 = r6.longValue()
            java.lang.String r6 = "Could not set digital assistant, you need to grant permission via adb with the command: adb shell pm grant com.arlosoft.macrodroid android.permission.WRITE_SECURE_SETTINGS"
            com.arlosoft.macrodroid.logging.systemlog.SystemLog.logError(r6, r0)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.SetDigitalAssistantAction.invokeAction(com.arlosoft.macrodroid.triggers.TriggerContextInfo):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String[] o() {
        int collectionSizeOrDefault;
        Intent intent = new Intent();
        intent.setAction("android.service.voice.VoiceInteractionService");
        List<ResolveInfo> queryIntentServices = getContext().getPackageManager().queryIntentServices(intent, 0);
        Intrinsics.checkNotNullExpressionValue(queryIntentServices, "context.packageManager.q…ntServices(sendIntent, 0)");
        this.appInfoList.clear();
        AppInfo appInfo = new AppInfo();
        appInfo.applicationName = getContext().getString(R.string.none);
        appInfo.packageName = "";
        this.appInfoList.add(appInfo);
        for (ResolveInfo resolveInfo : queryIntentServices) {
            AppInfo appInfo2 = new AppInfo();
            ServiceInfo serviceInfo = resolveInfo.serviceInfo;
            String str = serviceInfo.name;
            String str2 = serviceInfo.packageName;
            appInfo2.packageName = str2 + RemoteSettings.FORWARD_SLASH_STRING + str;
            appInfo2.applicationName = resolveInfo.serviceInfo.applicationInfo.loadLabel(getContext().getPackageManager()).toString();
            this.appInfoList.add(appInfo2);
        }
        ArrayList<AppInfo> arrayList = this.appInfoList;
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (AppInfo appInfo3 : arrayList) {
            arrayList2.add(appInfo3.applicationName);
        }
        return (String[]) arrayList2.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        this.assistantName = this.appInfoList.get(this.selectedIndex).applicationName;
        this.assistantPackageAndService = this.appInfoList.get(this.selectedIndex).packageName;
        itemComplete();
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.assistantName);
        out.writeString(this.assistantPackageAndService);
    }

    public SetDigitalAssistantAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public SetDigitalAssistantAction() {
        this.appInfoList = new ArrayList<>();
    }

    private SetDigitalAssistantAction(Parcel parcel) {
        super(parcel);
        this.appInfoList = new ArrayList<>();
        this.assistantName = parcel.readString();
        this.assistantPackageAndService = parcel.readString();
    }

    /* compiled from: SetDigitalAssistantAction.kt */
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
