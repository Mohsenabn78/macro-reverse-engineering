package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.HeadphonesConnectionConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes3.dex */
public class HeadphonesConnectionConstraint extends Constraint {
    public static final Parcelable.Creator<HeadphonesConnectionConstraint> CREATOR = new a();
    private boolean m_connected;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<HeadphonesConnectionConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public HeadphonesConnectionConstraint createFromParcel(Parcel parcel) {
            return new HeadphonesConnectionConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public HeadphonesConnectionConstraint[] newArray(int i4) {
            return new HeadphonesConnectionConstraint[i4];
        }
    }

    /* synthetic */ HeadphonesConnectionConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.constraint_headphones_connection_in), MacroDroidApplication.getInstance().getString(R.string.constraint_headphones_connection_out)};
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
        this.m_connected = z3;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        AudioDeviceInfo[] devices;
        boolean z3;
        int type;
        int type2;
        int type3;
        if (Build.VERSION.SDK_INT < 23) {
            if (this.m_connected == ((AudioManager) getContext().getSystemService("audio")).isWiredHeadsetOn()) {
                return true;
            }
            return false;
        }
        AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
        devices = audioManager.getDevices(2);
        for (AudioDeviceInfo audioDeviceInfo : devices) {
            type = audioDeviceInfo.getType();
            if (type != 3) {
                type2 = audioDeviceInfo.getType();
                if (type2 != 4) {
                    type3 = audioDeviceInfo.getType();
                    if (type3 != 8) {
                    }
                }
            }
            z3 = true;
        }
        z3 = false;
        if (!z3) {
            z3 = audioManager.isWiredHeadsetOn();
        }
        if (this.m_connected == z3) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_connected ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        Context context;
        int i4;
        if (this.m_connected) {
            context = getContext();
            i4 = R.string.constraint_headphones_connection_in;
        } else {
            context = getContext();
            i4 = R.string.constraint_headphones_connection_out;
        }
        return context.getString(i4);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return HeadphonesConnectionConstraintInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return getContext().getString(R.string.constraint_headphones_connection_select_state);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_connected ? 1 : 0);
    }

    public HeadphonesConnectionConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public HeadphonesConnectionConstraint() {
        this.m_connected = true;
    }

    private HeadphonesConnectionConstraint(Parcel parcel) {
        super(parcel);
        this.m_connected = parcel.readInt() != 0;
    }
}
