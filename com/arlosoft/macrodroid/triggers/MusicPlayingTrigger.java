package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.MusicPlayingTriggerInfo;
import com.arlosoft.macrodroid.triggers.services.DetectMusicService;

/* loaded from: classes3.dex */
public class MusicPlayingTrigger extends Trigger {
    public static final Parcelable.Creator<MusicPlayingTrigger> CREATOR = new a();
    public static final int STARTED = 0;
    public static final int STOPPED = 1;
    private static int s_triggerCounter;
    private int option;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<MusicPlayingTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MusicPlayingTrigger createFromParcel(Parcel parcel) {
            return new MusicPlayingTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MusicPlayingTrigger[] newArray(int i4) {
            return new MusicPlayingTrigger[i4];
        }
    }

    /* synthetic */ MusicPlayingTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.music_or_sound_started), SelectableItem.r(R.string.music_or_sound_stopped)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.option = i4;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            getContext().stopService(new Intent(getContext(), DetectMusicService.class));
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            getContext().startService(new Intent(getContext(), DetectMusicService.class));
        }
        s_triggerCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return getOption();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return getOptions()[getOption()];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return MusicPlayingTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getName() + " (" + getExtendedDetail() + ")";
    }

    public int getOption() {
        int i4 = this.option;
        if (i4 > 1) {
            return 0;
        }
        return i4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean hasOptions() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.option);
    }

    public MusicPlayingTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private MusicPlayingTrigger() {
    }

    private MusicPlayingTrigger(Parcel parcel) {
        super(parcel);
        this.option = parcel.readInt();
    }
}
