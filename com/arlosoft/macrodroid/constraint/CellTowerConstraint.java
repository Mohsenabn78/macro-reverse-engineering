package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.celltowers.CellTowerGroupStore;
import com.arlosoft.macrodroid.celltowers.CellTowerListActivity;
import com.arlosoft.macrodroid.celltowers.CellTowerUtils;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.CellTowerConstraintInfo;
import com.arlosoft.macrodroid.data.CellTowerGroup;
import com.arlosoft.macrodroid.database.Database;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.selectableitemlist.AddConditionActivity;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class CellTowerConstraint extends Constraint {
    public static final Parcelable.Creator<CellTowerConstraint> CREATOR = new a();
    private static final int REQUEST_CODE_PICK_CELL_TOWER = 38234444;
    private String m_cellGroupName;
    private ArrayList<String> m_cellIds;
    private boolean m_inRange;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<CellTowerConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CellTowerConstraint createFromParcel(Parcel parcel) {
            return new CellTowerConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CellTowerConstraint[] newArray(int i4) {
            return new CellTowerConstraint[i4];
        }
    }

    /* synthetic */ CellTowerConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private boolean O(String str, List<CellTowerUtils.CellTowerInfo> list) {
        for (CellTowerUtils.CellTowerInfo cellTowerInfo : list) {
            if (cellTowerInfo.id.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.constraint_cell_towers_in_range), MacroDroidApplication.getInstance().getString(R.string.constraint_cell_towers_out_of_range)};
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
        this.m_inRange = z3;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        boolean z3;
        List<CellTowerUtils.CellTowerInfo> cellTowersInRange = CellTowerUtils.getCellTowersInRange(getContext());
        Set<String> ignoreCellTowerSet = Database.getInstance().getIgnoreCellTowerSet();
        CellTowerGroup groupByName = CellTowerGroupStore.getInstance().getGroupByName(this.m_cellGroupName);
        if (groupByName != null) {
            Iterator<String> it = groupByName.getCellTowerIds().iterator();
            while (true) {
                if (it.hasNext()) {
                    String next = it.next();
                    if (!ignoreCellTowerSet.contains(next) && !groupByName.isIgnore(next) && O(next, cellTowersInRange)) {
                        SystemLog.logVerbose("Cell Tower constraint - found cellId: " + next + " matches group: " + groupByName.getName(), getMacroGuid().longValue());
                        z3 = true;
                        break;
                    }
                } else {
                    z3 = false;
                    break;
                }
            }
            SystemLog.logVerbose("Cell Tower constraint - no tower found from group: " + groupByName.getName(), getMacroGuid().longValue());
            SystemLog.logVerbose("Cell Towers found: " + cellTowersInRange, getMacroGuid().longValue());
        } else {
            Iterator<String> it2 = this.m_cellIds.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (O(it2.next(), cellTowersInRange)) {
                        z3 = true;
                        break;
                    }
                } else {
                    z3 = false;
                    break;
                }
            }
        }
        if (this.m_inRange == z3) {
            return true;
        }
        return false;
    }

    public String getCellGroupName() {
        return this.m_cellGroupName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_inRange ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_inRange) {
            return getOptions()[0];
        }
        return getOptions()[1];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return this.m_cellGroupName;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return CellTowerConstraintInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + " (" + getExtendedDetail() + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        return new String[]{"android.permission.ACCESS_COARSE_LOCATION"};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        if (i4 == REQUEST_CODE_PICK_CELL_TOWER && i5 == -1) {
            setActivity(activity);
            this.m_cellGroupName = intent.getStringExtra("CellTowerGroupName");
            this.m_cellIds = intent.getStringArrayListExtra(CellTowerListActivity.EXTRA_CELL_TOWER_LIST);
            itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    public void replaceLegacyIds() {
        if (this.m_cellIds != null) {
            for (int i4 = 0; i4 < this.m_cellIds.size(); i4++) {
                ArrayList<String> arrayList = this.m_cellIds;
                arrayList.set(i4, CellTowerGroup.convertLegacyCellTowerId(arrayList.get(i4)));
            }
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresLocationServicesEnabled() {
        if (Build.VERSION.SDK_INT > 26) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        int i4;
        Activity activity = getActivity();
        Intent intent = new Intent(activity, CellTowerListActivity.class);
        if (activity instanceof AddConditionActivity) {
            i4 = 3;
        } else {
            i4 = 2;
        }
        intent.putExtra("ThemeType", i4);
        activity.startActivityForResult(intent, REQUEST_CODE_PICK_CELL_TOWER);
    }

    public void setCellGroupName(String str) {
        this.m_cellGroupName = str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_inRange ? 1 : 0);
        parcel.writeString(this.m_cellGroupName);
        parcel.writeStringList(this.m_cellIds);
    }

    public CellTowerConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private CellTowerConstraint() {
        this.m_inRange = true;
        this.m_cellIds = new ArrayList<>();
    }

    private CellTowerConstraint(Parcel parcel) {
        super(parcel);
        this.m_inRange = parcel.readInt() != 0;
        this.m_cellGroupName = parcel.readString();
        ArrayList<String> arrayList = new ArrayList<>();
        this.m_cellIds = arrayList;
        parcel.readStringList(arrayList);
    }
}
