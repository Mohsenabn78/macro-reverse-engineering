package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.inputmethod.InputMethodManager;
import com.arlosoft.macrodroid.action.activities.SetKeyboardPieActivity;
import com.arlosoft.macrodroid.action.info.SetKeyboardActionInfo;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes2.dex */
public class SetKeyboardAction extends Action {
    public static final Parcelable.Creator<SetKeyboardAction> CREATOR = new a();

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SetKeyboardAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SetKeyboardAction createFromParcel(Parcel parcel) {
            return new SetKeyboardAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SetKeyboardAction[] newArray(int i4) {
            return new SetKeyboardAction[i4];
        }
    }

    /* synthetic */ SetKeyboardAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SetKeyboardActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean hasOptions() {
        return false;
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        if (Build.VERSION.SDK_INT < 27) {
            ((InputMethodManager) getContext().getSystemService("input_method")).showInputMethodPicker();
            return;
        }
        Intent intent = new Intent(getContext(), SetKeyboardPieActivity.class);
        intent.addFlags(268435456);
        getContext().startActivity(intent);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresCanDrawOverlays() {
        if (Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        return false;
    }

    public SetKeyboardAction(Activity activity, Macro macro) {
        setActivity(activity);
        this.m_macro = macro;
    }

    public SetKeyboardAction() {
    }

    private SetKeyboardAction(Parcel parcel) {
        super(parcel);
    }
}
