package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.LaunchActivityActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.applications.ApplicationAdapter;
import com.arlosoft.macrodroid.common.AppInfo;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.GetAppListTask;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.AppUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class LaunchActivityAction extends Action implements GetAppListTask.AppListListener, SupportsMagicText {
    private static final int OPTION_LAUNCH_BY_APP_CHOOSER = 0;
    private static final int OPTION_LAUNCH_BY_PACKAGE_NAME = 1;
    private String launchByPackageName;
    protected String m_activityName;
    protected String m_activityToLaunch;
    protected transient List<AppInfo> m_appInfoList;
    protected String m_applicationName;
    private boolean m_excludeFromRecents;
    protected String m_packageToLaunch;
    protected boolean m_startNew;
    private int option;
    protected static final String SELECT_APPLICATION = MacroDroidApplication.getInstance().getString(R.string.select_app);
    public static final Parcelable.Creator<LaunchActivityAction> CREATOR = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i4) {
            SparseBooleanArray checkedItemPositions = ((AlertDialog) dialogInterface).getListView().getCheckedItemPositions();
            LaunchActivityAction.this.m_startNew = checkedItemPositions.get(0, false);
            LaunchActivityAction.this.m_excludeFromRecents = checkedItemPositions.get(1, false);
            LaunchActivityAction.this.itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements SearchView.OnQueryTextListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ApplicationAdapter f2285a;

        b(ApplicationAdapter applicationAdapter) {
            this.f2285a = applicationAdapter;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            this.f2285a.getFilter().filter((CharSequence) str, false);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    class d implements Parcelable.Creator<LaunchActivityAction> {
        d() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public LaunchActivityAction createFromParcel(Parcel parcel) {
            return new LaunchActivityAction(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public LaunchActivityAction[] newArray(int i4) {
            return new LaunchActivityAction[i4];
        }
    }

    public LaunchActivityAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private String[] V() {
        return new String[]{SelectableItem.r(R.string.select_application), SelectableItem.r(R.string.action_launch_activity_option_enter_package_name)};
    }

    private String[] W() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.action_launch_activity_force_new), MacroDroidApplication.getInstance().getString(R.string.exclude_from_recents)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(AppCompatDialog appCompatDialog, AppInfo appInfo) {
        PackageManager packageManager = getContext().getPackageManager();
        List<ResolveInfo> launchableActivities = AppUtils.getLaunchableActivities(packageManager, appInfo.packageName);
        if (launchableActivities != null && launchableActivities.size() >= 2) {
            h0(packageManager, launchableActivities, appInfo.packageName, appInfo.applicationName);
        } else {
            this.m_applicationName = appInfo.applicationName;
            this.m_packageToLaunch = appInfo.packageName;
            this.m_activityToLaunch = null;
            this.m_activityName = null;
            f0();
        }
        appCompatDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(String str, String str2, List list, String[] strArr, DialogInterface dialogInterface, int i4) {
        this.m_applicationName = str;
        this.m_packageToLaunch = str2;
        int checkedItemPosition = ((AlertDialog) dialogInterface).getListView().getCheckedItemPosition();
        this.m_activityToLaunch = ((ResolveInfo) list.get(checkedItemPosition)).activityInfo.name;
        this.m_activityName = strArr[checkedItemPosition];
        f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(AppCompatDialog appCompatDialog, EditText editText, View view) {
        appCompatDialog.dismiss();
        this.launchByPackageName = editText.getText().toString();
        g0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    private void e0(TriggerContextInfo triggerContextInfo) {
        String replaceMagicText = MagicText.replaceMagicText(getContext(), this.launchByPackageName, triggerContextInfo, getMacro());
        Intent launchIntentForPackage = getContext().getPackageManager().getLaunchIntentForPackage(replaceMagicText);
        if (launchIntentForPackage != null) {
            if (this.m_excludeFromRecents) {
                launchIntentForPackage.addFlags(8388608);
            }
            if (this.m_startNew) {
                launchIntentForPackage.addFlags(32768);
            } else {
                launchIntentForPackage.addFlags(2097152);
            }
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
            launchIntentForPackage.addFlags(270532608);
            try {
                getContext().startActivity(launchIntentForPackage);
                return;
            } catch (Exception e4) {
                SystemLog.logError("Could not launch: " + this.m_applicationName + ". Error details: " + e4.toString(), getMacroGuid().longValue());
                return;
            }
        }
        SystemLog.logError("Could not launch: " + replaceMagicText + ". The package or a launchable activity was not found", getMacroGuid().longValue());
    }

    private void h0(@NonNull PackageManager packageManager, @NonNull final List<ResolveInfo> list, @NonNull final String str, @NonNull final String str2) {
        final String[] strArr = new String[list.size()];
        for (int i4 = 0; i4 < list.size(); i4++) {
            strArr[i4] = list.get(i4).activityInfo.loadLabel(packageManager).toString();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.select_option);
        builder.setSingleChoiceItems(strArr, 0, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.y8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                LaunchActivityAction.this.Z(str2, str, list, strArr, dialogInterface, i5);
            }
        });
        builder.create().show();
    }

    private void i0() {
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_package_name);
        appCompatDialog.setTitle(getContext().getString(R.string.action_launch_activity_option_enter_package_name));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        if (!activity.getResources().getBoolean(R.bool.is_tablet)) {
            layoutParams.width = -1;
        }
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.packageText);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.magicTextButton);
        String str = this.launchByPackageName;
        if (str != null) {
            editText.setText(str);
            editText.setSelection(this.launchByPackageName.length());
        }
        if (editText.getText().length() > 0) {
            button.setEnabled(true);
        }
        editText.addTextChangedListener(new c(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.z8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaunchActivityAction.this.a0(appCompatDialog, editText, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.a9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.b9
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                LaunchActivityAction.c0(editText, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.c9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaunchActivityAction.this.d0(activity, magicTextListener, view);
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.option = i4;
    }

    protected AlertDialog U() {
        Activity activity = getActivity();
        if (activity == null) {
            return null;
        }
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_app_chooser);
        appCompatDialog.setTitle(R.string.select_application);
        ListView listView = (ListView) appCompatDialog.findViewById(R.id.application_list);
        SearchView searchView = (SearchView) appCompatDialog.findViewById(R.id.searchView);
        ((ViewGroup) appCompatDialog.findViewById(R.id.button_bar)).setVisibility(8);
        ArrayList arrayList = new ArrayList(this.m_appInfoList);
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AppInfo appInfo = (AppInfo) it.next();
            if (appInfo.packageName.equals(this.m_packageToLaunch)) {
                arrayList.add(0, appInfo);
                break;
            }
        }
        ApplicationAdapter applicationAdapter = new ApplicationAdapter(activity, arrayList, null, new ApplicationAdapter.AppSelectionListener() { // from class: com.arlosoft.macrodroid.action.w8
            @Override // com.arlosoft.macrodroid.applications.ApplicationAdapter.AppSelectionListener
            public final void appSelected(AppInfo appInfo2) {
                LaunchActivityAction.this.X(appCompatDialog, appInfo2);
            }
        });
        listView.setAdapter((ListAdapter) applicationAdapter);
        searchView.setOnQueryTextListener(new b(applicationAdapter));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        appCompatDialog.show();
        appCompatDialog.getWindow().setAttributes(layoutParams);
        return null;
    }

    @Override // com.arlosoft.macrodroid.common.GetAppListTask.AppListListener
    public void appListUpdate(List<AppInfo> list, boolean z3) {
        this.m_appInfoList = list;
        U();
    }

    protected void f0() {
        g0();
    }

    protected void g0() {
        Activity activity = getActivity();
        if (!checkActivityAlive()) {
            return;
        }
        boolean[] zArr = {this.m_startNew, this.m_excludeFromRecents};
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, m());
        builder.setTitle(SelectableItem.r(R.string.action_launch_activity_select_launch_options));
        builder.setMultiChoiceItems(W(), zArr, (DialogInterface.OnMultiChoiceClickListener) null);
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new a());
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.x8
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                LaunchActivityAction.this.Y(dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.option == 0) {
            return SelectableItem.r(R.string.action_launch_activity_launch) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_applicationName;
        }
        return SelectableItem.r(R.string.action_launch_activity_launch) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.launchByPackageName;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getEditModeWarning() {
        String str;
        if (this.option == 1 || (str = this.m_packageToLaunch) == null || str.equals(Constants.CAMERA_APP_PACKAGE) || getContext().getPackageManager().getLaunchIntentForPackage(this.m_packageToLaunch) != null) {
            return null;
        }
        return String.format(SelectableItem.r(R.string.requires_application), this.m_applicationName);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        StringBuilder sb = new StringBuilder();
        if (this.m_startNew) {
            sb.append(W()[0]);
        }
        if (this.m_excludeFromRecents) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(W()[1]);
        }
        return sb.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return LaunchActivityActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.launchByPackageName};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        if (this.launchByPackageName != null) {
            return getName() + " (" + g(this.launchByPackageName, triggerContextInfo) + ")";
        }
        return super.getSystemLogEntryName(triggerContextInfo);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleWarningClick() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.m_packageToLaunch));
            intent.addFlags(268435456);
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + this.m_packageToLaunch));
            intent2.addFlags(268435456);
            getContext().startActivity(intent2);
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        if (this.option == 1) {
            e0(triggerContextInfo);
            return;
        }
        PackageManager packageManager = getContext().getPackageManager();
        if (Constants.CAMERA_APP_PACKAGE.equals(this.m_packageToLaunch)) {
            try {
                ResolveInfo resolveActivity = packageManager.resolveActivity(new Intent("android.media.action.IMAGE_CAPTURE"), 0);
                Intent intent = new Intent();
                ActivityInfo activityInfo = resolveActivity.activityInfo;
                intent.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                intent.setAction("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.addFlags(270532608);
                if (this.m_excludeFromRecents) {
                    intent.addFlags(8388608);
                }
                getContext().startActivity(intent);
                return;
            } catch (Exception unused) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("LaunchActiviity Action: Failed to launch camera App"));
                return;
            }
        }
        try {
            if (this.m_activityName == null) {
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(this.m_packageToLaunch);
                if (launchIntentForPackage != null) {
                    if (this.m_excludeFromRecents) {
                        launchIntentForPackage.addFlags(8388608);
                    }
                    if (this.m_startNew) {
                        launchIntentForPackage.addFlags(32768);
                    } else {
                        launchIntentForPackage.addFlags(2097152);
                    }
                    launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
                    launchIntentForPackage.addFlags(270532608);
                    try {
                        getContext().startActivity(launchIntentForPackage);
                        return;
                    } catch (Exception e4) {
                        Context context = getContext();
                        String string = getContext().getString(R.string.error);
                        Util.displayNotification(context, string, getContext().getString(R.string.action_launch_activity_failed_to_launch) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_applicationName, false);
                        SystemLog.logError("Could not launch: " + this.m_applicationName + ". Error details: " + e4.toString(), getMacroGuid().longValue());
                        return;
                    }
                }
                Context context2 = getContext();
                Util.displayNotification(context2, getContext().getString(R.string.action_launch_activity_failed_to_launch) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_applicationName, getContext().getString(R.string.action_launch_activity_has_removed), false);
                return;
            }
            Intent intent2 = new Intent("android.intent.action.MAIN");
            intent2.setPackage(this.m_packageToLaunch);
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setClassName(this.m_packageToLaunch, this.m_activityToLaunch);
            if (this.m_excludeFromRecents) {
                intent2.addFlags(8388608);
            }
            if (this.m_startNew) {
                intent2.addFlags(32768);
            } else {
                intent2.addFlags(2097152);
            }
            intent2.addFlags(268435456);
            getContext().startActivity(intent2);
        } catch (ActivityNotFoundException unused2) {
            if (Constants.CAMERA_APP_PACKAGE.equals(this.m_packageToLaunch)) {
                Intent intent3 = new Intent();
                intent3.setComponent(new ComponentName(Constants.CAMERA_APP_PACKAGE, "com.android.camera.CameraEntry"));
                intent3.addFlags(268435456);
                if (this.m_excludeFromRecents) {
                    intent3.addFlags(8388608);
                }
                getContext().startActivity(intent3);
                return;
            }
            Context context3 = getContext();
            Util.displayNotification(context3, getContext().getString(R.string.action_launch_activity_failed_to_launch) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_applicationName, getContext().getString(R.string.action_launch_activity_could_not_start), false);
        } catch (IllegalArgumentException unused3) {
            Context context4 = getContext();
            Util.displayNotification(context4, getContext().getString(R.string.action_launch_activity_failed_to_launch) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_applicationName, getContext().getString(R.string.action_launch_activity_could_not_start), false);
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        if (this.option == 1) {
            return true;
        }
        String str = this.m_applicationName;
        if (str != null && !str.equals(SELECT_APPLICATION)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return V();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresCanDrawOverlays() {
        if (Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (this.option == 0) {
            new GetAppListTask(this, getActivity(), true, true, ContextCompat.getColor(getActivity(), R.color.actions_accent)).execute((Object[]) null);
        } else {
            i0();
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 1) {
            this.launchByPackageName = strArr[0];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_packageToLaunch);
        parcel.writeString(this.m_applicationName);
        parcel.writeString(this.m_activityToLaunch);
        parcel.writeString(this.m_activityName);
        parcel.writeInt(this.m_startNew ? 1 : 0);
        parcel.writeInt(this.m_excludeFromRecents ? 1 : 0);
        parcel.writeInt(this.option);
        parcel.writeString(this.launchByPackageName);
    }

    public LaunchActivityAction() {
        this.m_startNew = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LaunchActivityAction(Parcel parcel) {
        super(parcel);
        this.m_packageToLaunch = parcel.readString();
        this.m_applicationName = parcel.readString();
        this.m_activityToLaunch = parcel.readString();
        this.m_activityName = parcel.readString();
        this.m_startNew = parcel.readInt() != 0;
        this.m_excludeFromRecents = parcel.readInt() != 0;
        this.option = parcel.readInt();
        this.launchByPackageName = parcel.readString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2287a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2288b;

        c(Button button, EditText editText) {
            this.f2287a = button;
            this.f2288b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2287a;
            if (this.f2288b.getText().length() > 0) {
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
