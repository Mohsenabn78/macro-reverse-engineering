package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.media.AudioManager;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.SearchView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.ControlMediaActionInfo;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.applications.ApplicationAdapter;
import com.arlosoft.macrodroid.common.AppInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.sun.mail.imap.IMAPStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes2.dex */
public class ControlMediaAction extends Action {
    private static final String ANY_PACKAGE = "any.package";
    private static final int OPTION_NEXT = 2;
    private static final int OPTION_PAUSE = 4;
    private static final int OPTION_PLAY = 3;
    private static final int OPTION_PLAY_PAUSE = 0;
    private static final int OPTION_PREVIOUS = 1;
    private static final int OPTION_STOP = 5;
    private String m_applicationName;
    private String m_option;
    private String m_packageName;
    private boolean m_sendMediaPlayerCommands;
    private boolean m_simulateMediaButton;
    private int optionInt;
    private static final String ANY_APP = "<" + SelectableItem.r(R.string.action_control_media_attempt_foreground_app) + ">";
    public static final Parcelable.Creator<ControlMediaAction> CREATOR = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i4) {
            ControlMediaAction.this.itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements SearchView.OnQueryTextListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ApplicationAdapter f2159a;

        b(ApplicationAdapter applicationAdapter) {
            this.f2159a = applicationAdapter;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            this.f2159a.getFilter().filter((CharSequence) str, false);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    class c implements Parcelable.Creator<ControlMediaAction> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ControlMediaAction createFromParcel(Parcel parcel) {
            return new ControlMediaAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ControlMediaAction[] newArray(int i4) {
            return new ControlMediaAction[i4];
        }
    }

    /* synthetic */ ControlMediaAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private static rf[] O() {
        return new rf[]{new rf(S(), 3), new rf(R(), 4), new rf(U(), 1), new rf(Q(), 2), new rf(V(), 5)};
    }

    private static rf[] P() {
        return new rf[]{new rf(T(), 0), new rf(U(), 1), new rf(Q(), 2), new rf(S(), 3), new rf(R(), 4), new rf(V(), 5)};
    }

    private static final String Q() {
        return MacroDroidApplication.getInstance().getString(R.string.action_control_media_next);
    }

    private static final String R() {
        return MacroDroidApplication.getInstance().getString(R.string.action_control_media_pause);
    }

    private static final String S() {
        return MacroDroidApplication.getInstance().getString(R.string.action_control_media_play);
    }

    private static final String T() {
        return MacroDroidApplication.getInstance().getString(R.string.action_control_media_play_pause);
    }

    private static final String U() {
        return MacroDroidApplication.getInstance().getString(R.string.action_control_media_previous);
    }

    private static final String V() {
        return MacroDroidApplication.getInstance().getString(R.string.action_control_media_stop);
    }

    private static rf[] W() {
        return new rf[]{new rf(T(), 0), new rf(U(), 1), new rf(Q(), 2), new rf(S(), 3), new rf(R(), 4), new rf(V(), 5)};
    }

    private static String[] X() {
        return new String[]{SelectableItem.r(R.string.action_control_media_simulate_media_button), SelectableItem.r(R.string.action_control_media_default_media_player), SelectableItem.r(R.string.action_control_media_send_media_player_commands)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(rf[] rfVarArr, DialogInterface dialogInterface, int i4) {
        rf rfVar = rfVarArr[((AlertDialog) dialogInterface).getListView().getCheckedItemPosition()];
        this.optionInt = rfVar.f4782b;
        this.m_option = rfVar.f4781a;
        if (this.m_simulateMediaButton) {
            a0();
            return;
        }
        this.m_applicationName = null;
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(AppCompatDialog appCompatDialog, Activity activity, AppInfo appInfo) {
        getContext().getApplicationContext().getPackageManager();
        if (appInfo.packageName.equals(ANY_PACKAGE)) {
            this.m_applicationName = null;
            this.m_packageName = null;
        } else {
            this.m_applicationName = appInfo.applicationName;
            this.m_packageName = appInfo.packageName;
        }
        appCompatDialog.dismiss();
        new AlertDialog.Builder(activity, m()).setTitle(R.string.action_control_media).setMessage(R.string.action_control_media_foreground_app_info).setPositiveButton(17039370, new a()).show();
    }

    private void a0() {
        final Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        PackageManager packageManager = getContext().getPackageManager();
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        ArrayList<ResolveInfo> arrayList = new ArrayList();
        arrayList.addAll(queryBroadcastReceivers);
        arrayList.addAll(queryIntentServices);
        Collections.sort(arrayList, new ResolveInfo.DisplayNameComparator(packageManager));
        if (arrayList.isEmpty()) {
            this.m_packageName = null;
            this.m_applicationName = null;
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        AppInfo appInfo = new AppInfo();
        appInfo.applicationName = ANY_APP;
        appInfo.packageName = ANY_PACKAGE;
        arrayList2.add(appInfo);
        HashSet hashSet = new HashSet();
        for (ResolveInfo resolveInfo : arrayList) {
            AppInfo appInfo2 = new AppInfo();
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (activityInfo != null) {
                appInfo2.packageName = activityInfo.packageName;
                appInfo2.applicationName = activityInfo.applicationInfo.loadLabel(packageManager).toString();
            } else {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                if (serviceInfo != null) {
                    appInfo2.packageName = serviceInfo.packageName;
                    appInfo2.applicationName = serviceInfo.applicationInfo.loadLabel(packageManager).toString();
                }
            }
            appInfo2.launchable = true;
            if (!hashSet.contains(appInfo2.packageName)) {
                hashSet.add(appInfo2.packageName);
                arrayList2.add(appInfo2);
            }
        }
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_app_chooser);
        appCompatDialog.setTitle(R.string.select_application);
        ((ViewGroup) appCompatDialog.findViewById(R.id.button_bar)).setVisibility(8);
        ApplicationAdapter applicationAdapter = new ApplicationAdapter(activity, arrayList2, null, new ApplicationAdapter.AppSelectionListener() { // from class: com.arlosoft.macrodroid.action.s4
            @Override // com.arlosoft.macrodroid.applications.ApplicationAdapter.AppSelectionListener
            public final void appSelected(AppInfo appInfo3) {
                ControlMediaAction.this.Z(appCompatDialog, activity, appInfo3);
            }
        });
        ((ListView) appCompatDialog.findViewById(R.id.application_list)).setAdapter((ListAdapter) applicationAdapter);
        ((SearchView) appCompatDialog.findViewById(R.id.searchView)).setOnQueryTextListener(new b(applicationAdapter));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        appCompatDialog.show();
        appCompatDialog.getWindow().setAttributes(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_sendMediaPlayerCommands = false;
        this.m_simulateMediaButton = false;
        if (i4 != 0) {
            if (i4 == 2) {
                this.m_sendMediaPlayerCommands = true;
                return;
            }
            return;
        }
        this.m_simulateMediaButton = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        int i4;
        if (this.m_sendMediaPlayerCommands) {
            i4 = 2;
        } else if (this.m_simulateMediaButton) {
            i4 = 0;
        } else {
            i4 = 1;
        }
        if (i4 >= X().length) {
            this.m_sendMediaPlayerCommands = false;
            return 0;
        }
        return i4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        rf[] O;
        if (this.m_sendMediaPlayerCommands) {
            O = W();
        } else if (this.m_simulateMediaButton) {
            O = P();
        } else {
            O = O();
        }
        for (rf rfVar : O) {
            if (rfVar.f4782b == this.optionInt) {
                return getContext().getString(R.string.action_control_media_media) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + rfVar.f4781a;
            }
        }
        return getContext().getString(R.string.action_control_media_media) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        int i4;
        String str;
        int i5 = 0;
        if (this.m_sendMediaPlayerCommands) {
            i4 = 2;
        } else if (this.m_simulateMediaButton) {
            i4 = 0;
        } else {
            i4 = 1;
        }
        if (i4 >= X().length) {
            this.m_sendMediaPlayerCommands = false;
        } else {
            i5 = i4;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(X()[i5]);
        if (TextUtils.isEmpty(this.m_applicationName)) {
            str = "";
        } else {
            str = " (" + this.m_applicationName + ")";
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ControlMediaActionInfo.getInstance();
    }

    public int getKeyCode(boolean z3) {
        AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
        int i4 = this.optionInt;
        if (i4 >= 0) {
            if (i4 != 0) {
                if (i4 == 1) {
                    return 88;
                }
                if (i4 == 2) {
                    return 87;
                }
                if (i4 == 3) {
                    return 126;
                }
                if (i4 == 4) {
                    return 127;
                }
                if (i4 != 5) {
                    return -1;
                }
                return 86;
            } else if (z3) {
                return 85;
            } else {
                if (audioManager.isMusicActive()) {
                    return 127;
                }
                return 126;
            }
        } else if (this.m_option.equals(T())) {
            if (audioManager.isMusicActive()) {
                return 127;
            }
            return 126;
        } else if (this.m_option.equals(Q())) {
            return 87;
        } else {
            if (this.m_option.equals(U())) {
                return 88;
            }
            if (this.m_option.equals(S())) {
                return 126;
            }
            if (this.m_option.equals(R())) {
                return 127;
            }
            if (!this.m_option.equals(V())) {
                return -1;
            }
            return 86;
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.m_sendMediaPlayerCommands) {
            AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
            int keyCode = getKeyCode(false);
            if (keyCode < 0) {
                SystemLog.logError("Invalid configuration for Control Media action - please reconfigure the action");
                return;
            }
            audioManager.dispatchMediaKeyEvent(new KeyEvent(uptimeMillis, uptimeMillis, 0, keyCode, 0));
            long j4 = uptimeMillis + 100;
            audioManager.dispatchMediaKeyEvent(new KeyEvent(j4, j4, 1, keyCode, 0));
        } else if (this.m_simulateMediaButton) {
            int keyCode2 = getKeyCode(true);
            if (keyCode2 < 0) {
                SystemLog.logError("Invalid configuration for Control Media action - please reconfigure the action");
                return;
            }
            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
            String str = this.m_packageName;
            if (str != null) {
                intent.setPackage(str);
            }
            intent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(uptimeMillis, uptimeMillis, 0, keyCode2, 0));
            intent.putExtra(Util.MEDIA_BUTTON_MACRODROID, true);
            try {
                getContext().sendOrderedBroadcast(intent, null);
            } catch (Exception unused) {
            }
            Intent intent2 = new Intent("android.intent.action.MEDIA_BUTTON");
            String str2 = this.m_packageName;
            if (str2 != null) {
                intent2.setPackage(str2);
            }
            long j5 = uptimeMillis + 100;
            intent2.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(j5, j5, 1, keyCode2, 0));
            intent2.putExtra(Util.MEDIA_BUTTON_MACRODROID, true);
            try {
                getContext().sendOrderedBroadcast(intent2, null);
            } catch (Exception unused2) {
            }
        } else {
            Intent intent3 = new Intent("com.android.music.musicservicecommand");
            int i4 = this.optionInt;
            String str3 = "previous";
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            if (i4 != 5) {
                                if (!this.m_option.equals(S())) {
                                    if (!this.m_option.equals(R())) {
                                        if (!this.m_option.equals(U())) {
                                            if (!this.m_option.equals(Q())) {
                                                if (!this.m_option.equals(V())) {
                                                    str3 = "";
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            str3 = "stop";
                        }
                        str3 = "pause";
                    }
                    str3 = "play";
                }
                str3 = "next";
            }
            if (str3.equals("")) {
                SystemLog.logError("Invalid configuration for Control Media action - please reconfigure the action");
                return;
            }
            intent3.putExtra(IMAPStore.ID_COMMAND, str3);
            getContext().sendBroadcast(intent3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return X();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return getContext().getString(R.string.action_control_media_select_type);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        final rf[] O;
        Activity activity = getActivity();
        if (this.m_sendMediaPlayerCommands) {
            O = W();
        } else if (this.m_simulateMediaButton) {
            O = P();
        } else {
            O = O();
        }
        String[] strArr = new String[O.length];
        int i4 = 0;
        for (int i5 = 0; i5 < O.length; i5++) {
            strArr[i5] = O[i5].f4781a;
            int i6 = this.optionInt;
            if (i6 > 0) {
                if (i6 != O[i5].f4782b) {
                }
                i4 = i5;
            } else {
                if (!this.m_option.equals(O[i5].f4781a)) {
                }
                i4 = i5;
            }
        }
        if (i4 == 0) {
            rf rfVar = O[0];
            this.optionInt = rfVar.f4782b;
            this.m_option = rfVar.f4781a;
        }
        String string = getContext().getString(R.string.select_option);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, m());
        builder.setTitle(string);
        builder.setSingleChoiceItems(strArr, i4, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.r4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i7) {
                ControlMediaAction.this.Y(O, dialogInterface, i7);
            }
        });
        builder.create().show();
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_option);
        parcel.writeInt(!this.m_simulateMediaButton ? 1 : 0);
        parcel.writeInt(!this.m_sendMediaPlayerCommands ? 1 : 0);
        parcel.writeString(this.m_packageName);
        parcel.writeString(this.m_applicationName);
        parcel.writeInt(this.optionInt);
    }

    public ControlMediaAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public ControlMediaAction() {
        this.optionInt = -1;
        this.m_option = P()[0].f4781a;
        this.m_simulateMediaButton = true;
        this.m_sendMediaPlayerCommands = false;
    }

    private ControlMediaAction(Parcel parcel) {
        super(parcel);
        this.optionInt = -1;
        this.m_option = parcel.readString();
        this.m_simulateMediaButton = parcel.readInt() == 0;
        this.m_sendMediaPlayerCommands = parcel.readInt() == 0;
        this.m_packageName = parcel.readString();
        this.m_applicationName = parcel.readString();
        this.optionInt = parcel.readInt();
    }
}
