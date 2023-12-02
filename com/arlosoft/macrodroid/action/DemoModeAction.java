package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.DemoModeActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sun.mail.imap.IMAPStore;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DemoModeAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class DemoModeAction extends Action {
    private int state;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<DemoModeAction> CREATOR = new Parcelable.Creator<DemoModeAction>() { // from class: com.arlosoft.macrodroid.action.DemoModeAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public DemoModeAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DemoModeAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public DemoModeAction[] newArray(int i4) {
            return new DemoModeAction[i4];
        }
    };

    public /* synthetic */ DemoModeAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
        if (android.provider.Settings.Global.getInt(getContext().getContentResolver(), "sysui_tuner_demo_on") == 0) goto L6;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void N() {
        /*
            r8 = this;
            java.lang.String r0 = "sysui_tuner_demo_on"
            r1 = 0
            r2 = 1
            int r3 = r8.state     // Catch: java.lang.Exception -> L1d
            if (r3 != 0) goto La
            goto L1e
        La:
            if (r3 != r2) goto Le
        Lc:
            r3 = 0
            goto L1f
        Le:
            android.content.Context r3 = r8.getContext()     // Catch: java.lang.Exception -> L1d
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch: java.lang.Exception -> L1d
            int r3 = android.provider.Settings.Global.getInt(r3, r0)     // Catch: java.lang.Exception -> L1d
            if (r3 != 0) goto Lc
            goto L1e
        L1d:
        L1e:
            r3 = 1
        L1f:
            boolean r4 = com.arlosoft.macrodroid.root.RootToolsHelper.isAccessGiven()
            if (r4 == 0) goto Lae
            android.content.Context r0 = r8.getContext()
            java.lang.String r4 = "android.permission.DUMP"
            int r0 = androidx.core.content.ContextCompat.checkSelfPermission(r0, r4)
            java.lang.String r4 = "settings put global sysui_tuner_demo_on "
            java.lang.String r5 = "settings put global sysui_demo_allowed "
            if (r0 == 0) goto L7e
            java.lang.String r0 = "pm grant com.arlosoft.macrodroid android.permission.DUMP"
            java.lang.String[] r0 = new java.lang.String[]{r0}
            com.arlosoft.macrodroid.common.Util.runAsRoot(r0)
            android.os.Handler r0 = new android.os.Handler
            android.os.Looper r6 = android.os.Looper.getMainLooper()
            r0.<init>(r6)
            java.lang.String[] r6 = new java.lang.String[r2]
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r5)
            r7.append(r3)
            java.lang.String r5 = r7.toString()
            r6[r1] = r5
            com.arlosoft.macrodroid.common.Util.runAsRoot(r6)
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            r5.append(r3)
            java.lang.String r4 = r5.toString()
            r2[r1] = r4
            com.arlosoft.macrodroid.common.Util.runAsRoot(r2)
            com.arlosoft.macrodroid.action.t4 r1 = new com.arlosoft.macrodroid.action.t4
            r1.<init>()
            r2 = 1000(0x3e8, double:4.94E-321)
            r0.postDelayed(r1, r2)
            goto Ldd
        L7e:
            java.lang.String[] r0 = new java.lang.String[r2]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            r6.append(r3)
            java.lang.String r5 = r6.toString()
            r0[r1] = r5
            com.arlosoft.macrodroid.common.Util.runAsRoot(r0)
            java.lang.String[] r0 = new java.lang.String[r2]
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0[r1] = r2
            com.arlosoft.macrodroid.common.Util.runAsRoot(r0)
            r8.P(r3)
            goto Ldd
        Lae:
            android.content.Context r1 = r8.getContext()     // Catch: java.lang.Exception -> Lc8
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Exception -> Lc8
            java.lang.String r2 = "sysui_demo_allowed"
            android.provider.Settings.Global.putInt(r1, r2, r3)     // Catch: java.lang.Exception -> Lc8
            android.content.Context r1 = r8.getContext()     // Catch: java.lang.Exception -> Lc8
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Exception -> Lc8
            android.provider.Settings.Global.putInt(r1, r0, r3)     // Catch: java.lang.Exception -> Lc8
            goto Lda
        Lc8:
            java.lang.Long r0 = r8.getMacroGuid()
            java.lang.String r1 = "macroGuid"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            long r0 = r0.longValue()
            java.lang.String r2 = "Could not set demo mode, you need to grant permission via adb with the command: adb shell pm grant com.arlosoft.macrodroid android.permission.WRITE_SECURE_SETTINGS"
            com.arlosoft.macrodroid.logging.systemlog.SystemLog.logError(r2, r0)
        Lda:
            r8.P(r3)
        Ldd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.DemoModeAction.N():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(DemoModeAction this$0, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P(i4);
    }

    private final void P(int i4) {
        String format;
        String str;
        try {
            if (i4 == 0) {
                Intent intent = new Intent("com.android.systemui.demo");
                intent.putExtra(IMAPStore.ID_COMMAND, "exit");
                getContext().sendBroadcast(intent);
                return;
            }
            String version = Build.VERSION.RELEASE;
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmm");
            try {
                Intrinsics.checkNotNullExpressionValue(version, "version");
                if (Integer.parseInt(version) < 24) {
                    if (version.length() == 1) {
                        str = "0";
                    } else {
                        str = version;
                    }
                    format = str + "00";
                } else {
                    format = simpleDateFormat.format(calendar.getTime());
                }
            } catch (Exception unused) {
                format = simpleDateFormat.format(calendar.getTime());
            }
            Intent intent2 = new Intent("com.android.systemui.demo");
            intent2.putExtra(IMAPStore.ID_COMMAND, "clock");
            intent2.putExtra("hhmm", format);
            getContext().sendBroadcast(intent2);
            Intent intent3 = new Intent("com.android.systemui.demo");
            intent3.putExtra(IMAPStore.ID_COMMAND, "battery");
            intent3.putExtra(FirebaseAnalytics.Param.LEVEL, "100");
            intent3.putExtra("plugged", "false");
            getContext().sendBroadcast(intent3);
            Intent intent4 = new Intent("com.android.systemui.demo");
            intent4.putExtra(IMAPStore.ID_COMMAND, "network");
            intent4.putExtra("mobile", "show");
            intent4.putExtra("datatype", "hide");
            intent4.putExtra(FirebaseAnalytics.Param.LEVEL, "4");
            getContext().sendBroadcast(intent4);
            Intent intent5 = new Intent("com.android.systemui.demo");
            intent5.putExtra(IMAPStore.ID_COMMAND, "network");
            intent5.putExtra("fully", "true");
            getContext().sendBroadcast(intent5);
            Intent intent6 = new Intent("com.android.systemui.demo");
            intent6.putExtra(IMAPStore.ID_COMMAND, "network");
            intent6.putExtra("wifi", "show");
            intent6.putExtra(FirebaseAnalytics.Param.LEVEL, "4");
            getContext().sendBroadcast(intent6);
            Intent intent7 = new Intent("com.android.systemui.demo");
            intent7.putExtra(IMAPStore.ID_COMMAND, "network");
            intent7.putExtra("airplane", "hide");
            intent7.putExtra("nosim", "hide");
            intent7.putExtra("sims", 1);
            getContext().sendBroadcast(intent7);
            Intent intent8 = new Intent("com.android.systemui.demo");
            intent8.putExtra(IMAPStore.ID_COMMAND, "notifications");
            intent8.putExtra("visible", "false");
            getContext().sendBroadcast(intent8);
            Intent intent9 = new Intent("com.android.systemui.demo");
            intent9.putExtra(IMAPStore.ID_COMMAND, NotificationCompat.CATEGORY_STATUS);
            intent9.putExtra("bluetooth", "hide");
            intent9.putExtra("volume", "hide");
            intent9.putExtra("mute", "hide");
            getContext().sendBroadcast(intent9);
        } catch (Exception e4) {
            Long macroGuid = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logError("Failed to enable demo mode: " + e4, macroGuid.longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.state = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.state;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String str = Companion.a()[this.state];
        Intrinsics.checkNotNullExpressionValue(str, "getOptions()[state]");
        return str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return DemoModeActionInfo.Companion.getInstance();
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
        N();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String[] o() {
        return Companion.a();
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.state);
    }

    public DemoModeAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public DemoModeAction() {
    }

    private DemoModeAction(Parcel parcel) {
        super(parcel);
        this.state = parcel.readInt();
    }

    /* compiled from: DemoModeAction.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String[] a() {
            return new String[]{SelectableItem.r(R.string.on), SelectableItem.r(R.string.off), SelectableItem.r(R.string.toggle)};
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
