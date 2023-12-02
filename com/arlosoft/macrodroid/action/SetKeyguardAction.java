package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SetKeyguardActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class SetKeyguardAction extends Action {
    public static final Parcelable.Creator<SetKeyguardAction> CREATOR = new a();
    public static final int DISABLE_PATTERN_LOCK = 11;
    public static final int ENABLE_PATTERN_LOCK = 10;
    private static KeyguardManager.KeyguardLock s_keyguardLock;
    private boolean m_keyguardOn;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SetKeyguardAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SetKeyguardAction createFromParcel(Parcel parcel) {
            return new SetKeyguardAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SetKeyguardAction[] newArray(int i4) {
            return new SetKeyguardAction[i4];
        }
    }

    /* synthetic */ SetKeyguardAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(DialogInterface dialogInterface, int i4) {
        dialogInterface.dismiss();
        k();
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_set_keyguard_lock_on), SelectableItem.r(R.string.action_set_keyguard_lock_off)};
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
        this.m_keyguardOn = z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_keyguardOn ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_keyguardOn) {
            return getOptions()[0];
        }
        return getOptions()[1];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SetKeyguardActionInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.action_set_keyguard);
        builder.setMessage(R.string.action_set_keyguard_warning);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.pj
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SetKeyguardAction.this.N(dialogInterface, i4);
            }
        });
        builder.show();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        try {
            if (this.m_keyguardOn) {
                s_keyguardLock.reenableKeyguard();
                Settings.setKeyGuardState(getContext(), 1);
            } else {
                s_keyguardLock.reenableKeyguard();
                s_keyguardLock.disableKeyguard();
                Settings.setKeyGuardState(getContext(), 2);
            }
        } catch (SecurityException unused) {
            ToastCompat.makeText(getContext().getApplicationContext(), (CharSequence) SelectableItem.r(R.string.keyguard_security_exception), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    public void setKeyguardEnabled(boolean z3) {
        this.m_keyguardOn = z3;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_keyguardOn ? 1 : 0);
    }

    public SetKeyguardAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public SetKeyguardAction() {
        this.m_keyguardOn = true;
        if (s_keyguardLock == null) {
            s_keyguardLock = ((KeyguardManager) getContext().getSystemService("keyguard")).newKeyguardLock("MacroDroid");
        }
    }

    private SetKeyguardAction(Parcel parcel) {
        super(parcel);
        this.m_keyguardOn = parcel.readInt() != 0;
    }
}
