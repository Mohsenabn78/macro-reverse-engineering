package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.VoiceSearchActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class VoiceSearchAction extends Action {
    public static final Parcelable.Creator<VoiceSearchAction> CREATOR = new a();

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<VoiceSearchAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public VoiceSearchAction createFromParcel(Parcel parcel) {
            return new VoiceSearchAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public VoiceSearchAction[] newArray(int i4) {
            return new VoiceSearchAction[i4];
        }
    }

    /* synthetic */ VoiceSearchAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return VoiceSearchActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean hasOptions() {
        return false;
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        intent.addFlags(268435456);
        try {
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            ToastCompat.makeText(getContext().getApplicationContext(), (CharSequence) SelectableItem.r(R.string.voice_search_not_available), 0).show();
        }
    }

    public VoiceSearchAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private VoiceSearchAction() {
    }

    private VoiceSearchAction(Parcel parcel) {
        super(parcel);
    }
}
