package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SpeakerPhoneActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes2.dex */
public class SpeakerPhoneAction extends Action {
    public static final Parcelable.Creator<SpeakerPhoneAction> CREATOR = new b();
    private int m_state;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AudioManager f2620a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f2621b;

        a(AudioManager audioManager, boolean z3) {
            this.f2620a = audioManager;
            this.f2621b = z3;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int i4;
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException unused) {
            }
            AudioManager audioManager = this.f2620a;
            if (this.f2621b) {
                i4 = 2;
            } else {
                i4 = 0;
            }
            audioManager.setMode(i4);
            this.f2620a.setSpeakerphoneOn(this.f2621b);
        }
    }

    /* loaded from: classes2.dex */
    class b implements Parcelable.Creator<SpeakerPhoneAction> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SpeakerPhoneAction createFromParcel(Parcel parcel) {
            return new SpeakerPhoneAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SpeakerPhoneAction[] newArray(int i4) {
            return new SpeakerPhoneAction[i4];
        }
    }

    /* synthetic */ SpeakerPhoneAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(DialogInterface dialogInterface, int i4) {
        super.onItemSelected();
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_speaker_phone_on), SelectableItem.r(R.string.action_speaker_phone_off), SelectableItem.r(R.string.action_speaker_phone_toggle)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_state = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_state;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return getOptions()[this.m_state];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SpeakerPhoneActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
        int i4 = this.m_state;
        int i5 = 2;
        boolean z3 = true;
        if (i4 != 0) {
            if (i4 == 1 || i4 != 2) {
                z3 = false;
            } else {
                z3 = true ^ audioManager.isSpeakerphoneOn();
            }
        }
        if (!z3) {
            i5 = 0;
        }
        audioManager.setMode(i5);
        audioManager.setSpeakerphoneOn(z3);
        new a(audioManager, z3).start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void onItemSelected() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.action_speaker_phone_android_10_warning).setTitle(R.string.action_speaker_phone).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.qo
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SpeakerPhoneAction.this.N(dialogInterface, i4);
            }
        });
        builder.show();
    }

    public void setState(int i4) {
        this.m_state = i4;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_state);
    }

    public SpeakerPhoneAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public SpeakerPhoneAction() {
    }

    private SpeakerPhoneAction(Parcel parcel) {
        super(parcel);
        this.m_state = parcel.readInt();
    }
}
