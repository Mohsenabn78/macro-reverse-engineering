package com.arlosoft.macrodroid.celltowers;

import android.content.Context;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.List;

/* loaded from: classes3.dex */
public class CellTowerUtils {

    /* loaded from: classes3.dex */
    public static class CellTowerInfo {
        public long cid;
        public int dbm;
        public String id;
        public String name;

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof CellTowerInfo)) {
                return false;
            }
            return this.id.equals(((CellTowerInfo) obj).id);
        }

        public String toString() {
            if (this.name != null) {
                return this.name + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.dbm;
            }
            return this.id + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.dbm;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:174:0x03bc A[Catch: Exception -> 0x03c1, NumberFormatException -> 0x0500, TRY_LEAVE, TryCatch #5 {NumberFormatException -> 0x0500, blocks: (B:158:0x035f, B:160:0x0366, B:162:0x037a, B:172:0x0392, B:174:0x03bc), top: B:244:0x035f }] */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<com.arlosoft.macrodroid.celltowers.CellTowerUtils.CellTowerInfo> getCellTowersInRange(android.content.Context r18) {
        /*
            Method dump skipped, instructions count: 1281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.celltowers.CellTowerUtils.getCellTowersInRange(android.content.Context):java.util.List");
    }

    public static String getSignalStrength(Context context) throws SecurityException {
        List<CellInfo> allCellInfo = ((TelephonyManager) context.getSystemService("phone")).getAllCellInfo();
        String str = null;
        if (allCellInfo != null) {
            for (int i4 = 0; i4 < allCellInfo.size(); i4++) {
                if (allCellInfo.get(i4).isRegistered()) {
                    if (allCellInfo.get(i4) instanceof CellInfoWcdma) {
                        str = String.valueOf(((CellInfoWcdma) allCellInfo.get(i4)).getCellSignalStrength().getDbm());
                    } else if (allCellInfo.get(i4) instanceof CellInfoGsm) {
                        str = String.valueOf(((CellInfoGsm) allCellInfo.get(i4)).getCellSignalStrength().getDbm());
                    } else if (allCellInfo.get(i4) instanceof CellInfoLte) {
                        str = String.valueOf(((CellInfoLte) allCellInfo.get(i4)).getCellSignalStrength().getDbm());
                    } else if (allCellInfo.get(i4) instanceof CellInfoCdma) {
                        str = String.valueOf(((CellInfoCdma) allCellInfo.get(i4)).getCellSignalStrength().getDbm());
                    }
                }
            }
        }
        return str;
    }
}
