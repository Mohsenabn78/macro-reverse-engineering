package com.arlosoft.macrodroid.triggers.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.GeofenceTrigger;
import com.arlosoft.macrodroid.triggers.TriggerInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class GeofenceTriggerInfo extends TriggerInfo {

    /* renamed from: g  reason: collision with root package name */
    private static SelectableItemInfo f14975g;

    public static SelectableItemInfo getInstance() {
        if (f14975g == null) {
            f14975g = new GeofenceTriggerInfo();
        }
        return f14975g;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public SelectableItem constructItem(Activity activity, Macro macro) {
        return new GeofenceTrigger(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public List<Integer> getAdditionalSearchTerms() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf((int) R.string.location_lat_lng));
        return arrayList;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getHelpInfo() {
        return R.string.trigger_geofence_help;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return R.drawable.ic_map_marker_circle_white_24dp;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getName() {
        return R.string.trigger_geofence;
    }
}
