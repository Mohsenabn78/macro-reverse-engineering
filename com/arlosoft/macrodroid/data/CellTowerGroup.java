package com.arlosoft.macrodroid.data;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public class CellTowerGroup implements Comparable<CellTowerGroup> {
    private ArrayList<String> m_cellTowerIdList;
    private Set<String> m_ignoreSet;
    private String m_name;

    public CellTowerGroup() {
        this.m_ignoreSet = new HashSet();
        this.m_cellTowerIdList = new ArrayList<>();
    }

    public static String convertLegacyCellTowerId(String str) {
        if (str.startsWith("GSM:")) {
            String[] split = str.substring(4).split(",");
            return split[0] + "," + split[1] + "," + split[3];
        } else if (str.startsWith("WCDMA:")) {
            String[] split2 = str.substring(6).split(",");
            return split2[0] + "," + split2[1] + "," + split2[3];
        } else if (str.startsWith("LTE:")) {
            String[] split3 = str.substring(4).split(",");
            return split3[0] + "," + split3[1] + "," + split3[4];
        } else {
            return str;
        }
    }

    public boolean contains(String str) {
        Iterator<String> it = this.m_cellTowerIdList.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getCellTowerIds() {
        return this.m_cellTowerIdList;
    }

    public Set<String> getIgnoreSet() {
        return this.m_ignoreSet;
    }

    public String getName() {
        return this.m_name;
    }

    public boolean isIgnore(String str) {
        return this.m_ignoreSet.contains(str);
    }

    public void setName(String str) {
        this.m_name = str;
    }

    public void updateCellTowerGroup(ArrayList<String> arrayList, Set<String> set) {
        this.m_cellTowerIdList = arrayList;
        this.m_ignoreSet = set;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull CellTowerGroup cellTowerGroup) {
        String str = this.m_name;
        if (str == null) {
            return -1;
        }
        return str.compareTo(cellTowerGroup.getName());
    }

    public CellTowerGroup(String str, ArrayList<String> arrayList) {
        this.m_name = str;
        this.m_cellTowerIdList = arrayList;
        this.m_ignoreSet = new HashSet();
    }
}
