package com.arlosoft.macrodroid.selectableitemlist.classic;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.selectableitemlist.SelectableItemChosenListener;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.List;

/* loaded from: classes3.dex */
public class SelectTriggerAdapter extends SelectableItemAdapter {
    public SelectTriggerAdapter(Activity activity, Macro macro, boolean z3, @NonNull SelectableItemChosenListener selectableItemChosenListener) {
        super(activity, macro, z3, selectableItemChosenListener, 0, false);
        refresh();
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.classic.SelectableItemAdapter
    protected List<SelectableItemInfo> f() {
        return Trigger.getAllTriggersInfo(this.f13379h.getApplicationContext());
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.classic.SelectableItemAdapter
    protected int g() {
        return R.drawable.circular_icon_background_trigger;
    }
}
