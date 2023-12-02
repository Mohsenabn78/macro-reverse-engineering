package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.HeadphonesTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.HeadphonesTriggerReceiver;

/* loaded from: classes3.dex */
public class HeadphonesTrigger extends Trigger {
    public static final Parcelable.Creator<HeadphonesTrigger> CREATOR = new a();
    public static final int HEADPHONE_OPTION_ANY = 0;
    public static final int HEADPHONE_OPTION_NO_MIC = 1;
    private static HeadphonesTriggerReceiver s_headphonesTriggerReceiver;
    private static int s_triggerCounter;
    public int HEADPHONE_OPTION_WITH_MIC;
    private boolean m_headphonesConnected;
    private int m_micOption;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<HeadphonesTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public HeadphonesTrigger createFromParcel(Parcel parcel) {
            return new HeadphonesTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public HeadphonesTrigger[] newArray(int i4) {
            return new HeadphonesTrigger[i4];
        }
    }

    /* synthetic */ HeadphonesTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] Q() {
        return new String[]{SelectableItem.r(R.string.any), SelectableItem.r(R.string.no_microphone), SelectableItem.r(R.string.with_microphone)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(DialogInterface dialogInterface, int i4) {
        this.m_micOption = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(DialogInterface dialogInterface, int i4) {
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.trigger_headphones_inserted), MacroDroidApplication.getInstance().getString(R.string.trigger_headphones_removed)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        boolean z3;
        if (i4 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.m_headphonesConnected = z3;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(s_headphonesTriggerReceiver);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            s_headphonesTriggerReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_headphonesTriggerReceiver = new HeadphonesTriggerReceiver();
            MacroDroidApplication.getInstance().registerReceiver(s_headphonesTriggerReceiver, new IntentFilter("android.intent.action.HEADSET_PLUG"));
        }
        s_triggerCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_headphonesConnected ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_headphonesConnected) {
            return getOptions()[0];
        }
        return getOptions()[1];
    }

    public boolean getConnected() {
        return this.m_headphonesConnected;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        if (this.m_headphonesConnected) {
            return Q()[this.m_micOption];
        }
        return "";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return HeadphonesTriggerInfo.getInstance();
    }

    public int getMicOption() {
        return this.m_micOption;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (!this.m_headphonesConnected) {
            itemComplete();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(p());
        builder.setSingleChoiceItems(Q(), this.m_micOption, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.k3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                HeadphonesTrigger.this.R(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.l3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                HeadphonesTrigger.this.S(dialogInterface, i4);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.m3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                HeadphonesTrigger.this.T(dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.triggers.n3
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                HeadphonesTrigger.this.U(dialogInterface);
            }
        });
    }

    public void setConnected(boolean z3) {
        this.m_headphonesConnected = z3;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_headphonesConnected ? 1 : 0);
        parcel.writeInt(this.m_micOption);
    }

    public HeadphonesTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public HeadphonesTrigger() {
        this.HEADPHONE_OPTION_WITH_MIC = 2;
        this.m_headphonesConnected = true;
    }

    private HeadphonesTrigger(Parcel parcel) {
        super(parcel);
        this.HEADPHONE_OPTION_WITH_MIC = 2;
        this.m_headphonesConnected = parcel.readInt() != 0;
        this.m_micOption = parcel.readInt();
    }
}
