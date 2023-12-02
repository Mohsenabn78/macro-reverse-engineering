package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.activities.CalibrateTouchDeviceActivity;
import com.arlosoft.macrodroid.action.info.LaunchAndPressActionInfo;
import com.arlosoft.macrodroid.action.services.RecordInputService;
import com.arlosoft.macrodroid.action.services.ReplayTouchesService;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.selectableitemlist.AddActionActivity;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.wizard.WizardActivity;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class LaunchAndPressAction extends LaunchActivityAction {
    public static final Parcelable.Creator<LaunchAndPressAction> CREATOR = new a();
    private static final int REQUEST_CODE = 3245;
    private ArrayList<String> m_eventList;
    protected String m_secondaryClassType;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<LaunchAndPressAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public LaunchAndPressAction createFromParcel(Parcel parcel) {
            return new LaunchAndPressAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public LaunchAndPressAction[] newArray(int i4) {
            return new LaunchAndPressAction[i4];
        }
    }

    /* synthetic */ LaunchAndPressAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(Activity activity, DialogInterface dialogInterface, int i4) {
        dialogInterface.dismiss();
        if (!Settings.getTouchScreenDevice(getContext()).equals("")) {
            super.handleItemSelected();
            return;
        }
        Util.copySocatBinary(getContext());
        activity.startActivityForResult(new Intent(getContext(), CalibrateTouchDeviceActivity.class), REQUEST_CODE);
    }

    @Override // com.arlosoft.macrodroid.action.LaunchActivityAction
    protected void f0() {
        Intent launchIntentForPackage = getContext().getPackageManager().getLaunchIntentForPackage(this.m_packageToLaunch);
        int i4 = 0;
        if (launchIntentForPackage != null) {
            Intent intent = new Intent(getContext(), RecordInputService.class);
            intent.putExtra("action", this);
            intent.putExtra("Macro", this.m_macro);
            Activity activity = getActivity();
            if (!(activity instanceof WizardActivity)) {
                if (activity instanceof AddActionActivity) {
                    i4 = 1;
                } else {
                    i4 = 2;
                }
            }
            intent.putExtra(RecordInputService.EXTRA_FROM_ACTIVITY, i4);
            getContext().startService(intent);
            launchIntentForPackage.addFlags(67108864);
            getContext().startActivity(launchIntentForPackage);
            return;
        }
        String str = this.m_classType;
        Log.w(str, "Cannot launch: " + this.m_packageToLaunch);
        Context context = getContext();
        Util.displayNotification(context, "Failed to launch " + this.m_applicationName, "Has the application been removed?", false);
    }

    @Override // com.arlosoft.macrodroid.action.LaunchActivityAction, com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return LaunchAndPressActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        if (i4 == REQUEST_CODE && i5 != 0) {
            super.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        final Activity activity = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, m());
        builder.setTitle(R.string.action_launch_and_press);
        builder.setMessage(R.string.action_launch_and_press_instructions);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.d9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                LaunchAndPressAction.this.l0(activity, dialogInterface, i4);
            }
        });
        builder.show();
    }

    @Override // com.arlosoft.macrodroid.action.LaunchActivityAction, com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        Iterator<String> it = this.m_eventList.iterator();
        while (it.hasNext()) {
            it.next();
        }
        try {
            Intent intent = new Intent(getContext(), ReplayTouchesService.class);
            intent.putStringArrayListExtra("events", this.m_eventList);
            getContext().startService(intent);
        } catch (Exception unused) {
            SystemLog.logError("Failed to launch replay service, data exceeded maximum allowed length", getMacroGuid().longValue());
        }
        super.invokeAction(triggerContextInfo);
    }

    @Override // com.arlosoft.macrodroid.action.LaunchActivityAction, com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresCanDrawOverlays() {
        return true;
    }

    public void setEventList(ArrayList<String> arrayList) {
        this.m_eventList = arrayList;
    }

    @Override // com.arlosoft.macrodroid.action.LaunchActivityAction, com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeStringList(this.m_eventList);
    }

    public LaunchAndPressAction(Activity activity, Macro macro) {
        super(activity, macro);
        this.m_secondaryClassType = "LaunchAndPressAction";
        this.m_eventList = new ArrayList<>();
    }

    public LaunchAndPressAction() {
        this.m_secondaryClassType = "LaunchAndPressAction";
        this.m_eventList = new ArrayList<>();
    }

    private LaunchAndPressAction(Parcel parcel) {
        super(parcel);
        this.m_secondaryClassType = "LaunchAndPressAction";
        ArrayList<String> arrayList = new ArrayList<>();
        this.m_eventList = arrayList;
        parcel.readStringList(arrayList);
    }
}
