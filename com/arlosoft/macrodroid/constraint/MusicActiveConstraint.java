package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.MusicActiveConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes3.dex */
public class MusicActiveConstraint extends Constraint {
    public static final Parcelable.Creator<MusicActiveConstraint> CREATOR = new a();
    private boolean m_musicActive;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<MusicActiveConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MusicActiveConstraint createFromParcel(Parcel parcel) {
            return new MusicActiveConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MusicActiveConstraint[] newArray(int i4) {
            return new MusicActiveConstraint[i4];
        }
    }

    /* synthetic */ MusicActiveConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.constraint_music_active_playing), MacroDroidApplication.getInstance().getString(R.string.constraint_music_active_not_playing)};
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
        this.m_musicActive = z3;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        if (this.m_musicActive == ((AudioManager) getContext().getSystemService("audio")).isMusicActive()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_musicActive ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        Context context;
        int i4;
        if (this.m_musicActive) {
            context = getContext();
            i4 = R.string.constraint_music_active_playing;
        } else {
            context = getContext();
            i4 = R.string.constraint_music_active_not_playing;
        }
        return context.getString(i4);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return MusicActiveConstraintInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return getContext().getString(R.string.constraint_music_active);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_musicActive ? 1 : 0);
    }

    public MusicActiveConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private MusicActiveConstraint() {
        this.m_musicActive = true;
    }

    private MusicActiveConstraint(Parcel parcel) {
        super(parcel);
        this.m_musicActive = parcel.readInt() != 0;
    }
}
