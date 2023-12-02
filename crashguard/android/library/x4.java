package crashguard.android.library;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.CellIdentity;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityTdscdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthTdscdma;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import androidx.annotation.RequiresApi;
import androidx.compose.animation.core.AnimationKt;
import com.facebook.stetho.dumpapp.Framer;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import org.objenesis.instantiator.util.ClassDefinitionUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class x4 {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f39115a;

    /* renamed from: b  reason: collision with root package name */
    private final z5 f39116b;

    /* renamed from: c  reason: collision with root package name */
    private final n2 f39117c = new n2();

    /* renamed from: d  reason: collision with root package name */
    private final TelephonyManager f39118d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x4(Context context, z5 z5Var) {
        this.f39115a = new WeakReference<>(context);
        this.f39116b = z5Var;
        this.f39118d = (TelephonyManager) context.getSystemService("phone");
    }

    private static String a(int i4) {
        if (i4 == -2) {
            return new String(new byte[]{85, 78, 73, 78, 73, 84, 73, 65, 76, 73, 90, 69, 68, Framer.STDIN_REQUEST_FRAME_PREFIX, 67, 65, 82, 68, Framer.STDIN_REQUEST_FRAME_PREFIX, 73, 68});
        }
        if (i4 == -1) {
            return new String(new byte[]{85, 78, 83, 85, 80, 80, 79, 82, 84, 69, 68, Framer.STDIN_REQUEST_FRAME_PREFIX, 67, 65, 82, 68, Framer.STDIN_REQUEST_FRAME_PREFIX, 73, 68});
        }
        return String.valueOf(i4);
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    private String b(TelephonyManager telephonyManager, int i4) {
        String str;
        String imei;
        if (this.f39116b.h()) {
            try {
                int i5 = Build.VERSION.SDK_INT;
                if (i5 > 25) {
                    imei = telephonyManager.getImei();
                    return imei;
                }
                if (i5 > 23) {
                    str = telephonyManager.getDeviceId();
                } else {
                    str = (String) TelephonyManager.class.getMethod("getDeviceId", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(i4));
                }
                String c4 = c(str);
                if (c4 != null) {
                    return str + c4;
                }
                return str;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    private static String c(String str) {
        if (str != null && str.length() == 14) {
            int length = str.length();
            int[] iArr = new int[length];
            char[] charArray = str.toCharArray();
            for (int i4 = 0; i4 < charArray.length; i4++) {
                iArr[i4] = Character.getNumericValue(charArray[i4]);
            }
            int i5 = 0;
            for (int i6 = 0; i6 < length; i6++) {
                if (i6 % 2 == 0) {
                    i5 += iArr[i6];
                } else {
                    int i7 = iArr[i6] * 2;
                    if (i7 >= 10) {
                        i5 = (i7 / 10) + (i7 % 10) + i5;
                    } else {
                        i5 += i7;
                    }
                }
            }
            return String.valueOf((10 - (i5 % 10)) % 10);
        }
        return null;
    }

    @RequiresApi(api = 17)
    private static JSONObject e(CellInfo cellInfo) throws Exception {
        int cellConnectionStatus;
        Set<String> additionalPlmns;
        String mobileNetworkOperator;
        String mccString;
        String mncString;
        int cellConnectionStatus2;
        int arfcn;
        int bsic;
        if (cellInfo instanceof CellInfoGsm) {
            CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(new String(new byte[]{71, 83, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 84, 105, 109, 101, 83, 116, 97, 109, 112}), n(cellInfoGsm));
            jSONObject.put(new String(new byte[]{71, 83, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 105, 115, 82, 101, 103, 105, 115, 116, 101, 114, 101, 100}), cellInfoGsm.isRegistered());
            jSONObject.put(new String(new byte[]{71, 83, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 67, 105, 100}), cellInfoGsm.getCellIdentity().getCid());
            jSONObject.put(new String(new byte[]{71, 83, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 80, 115, 99}), cellInfoGsm.getCellIdentity().getPsc());
            int i4 = Build.VERSION.SDK_INT;
            if (i4 > 23) {
                String str = new String(new byte[]{71, 83, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 65, 114, 102, 99, 110});
                arfcn = cellInfoGsm.getCellIdentity().getArfcn();
                jSONObject.put(str, arfcn);
                String str2 = new String(new byte[]{71, 83, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 66, 115, 105, 99});
                bsic = cellInfoGsm.getCellIdentity().getBsic();
                jSONObject.put(str2, bsic);
            }
            if (i4 > 27) {
                String str3 = new String(new byte[]{71, 83, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 77, 111, 98, 105, 108, 101, 78, 101, 116, 119, 111, 114, 107, 79, 112, 101, 114, 97, 116, 111, 114});
                mobileNetworkOperator = cellInfoGsm.getCellIdentity().getMobileNetworkOperator();
                jSONObject.put(str3, mobileNetworkOperator);
                String str4 = new String(new byte[]{71, 83, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 77, 99, 99});
                mccString = cellInfoGsm.getCellIdentity().getMccString();
                jSONObject.put(str4, mccString);
                String str5 = new String(new byte[]{71, 83, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 77, 110, 99});
                mncString = cellInfoGsm.getCellIdentity().getMncString();
                jSONObject.put(str5, mncString);
                String str6 = new String(new byte[]{71, 83, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 67, 101, 108, 108, 67, 111, 110, 110, 101, 99, 116, 105, 111, 110, 83, 116, 97, 116, 117, 115});
                cellConnectionStatus2 = cellInfoGsm.getCellConnectionStatus();
                jSONObject.put(str6, cellConnectionStatus2);
            } else {
                String str7 = new String(new byte[]{71, 83, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 77, 99, 99});
                Locale locale = Locale.ENGLISH;
                jSONObject.put(str7, String.format(locale, "%03d", Integer.valueOf(cellInfoGsm.getCellIdentity().getMcc())));
                jSONObject.put(new String(new byte[]{71, 83, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 77, 110, 99}), String.format(locale, "%03d", Integer.valueOf(cellInfoGsm.getCellIdentity().getMnc())));
            }
            jSONObject.put(new String(new byte[]{71, 83, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 76, 97, 99}), cellInfoGsm.getCellIdentity().getLac());
            jSONObject.put(new String(new byte[]{71, 83, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 83, 105, 103, 110, 97, 108, 83, 116, 114, 101, 110, 103, 116, 104}), cellInfoGsm.getCellSignalStrength());
            jSONObject.put(new String(new byte[]{71, 83, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 68, 98, 109}), cellInfoGsm.getCellSignalStrength().getDbm());
            jSONObject.put(new String(new byte[]{71, 83, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 76, 101, 118, 101, 108}), cellInfoGsm.getCellSignalStrength().getLevel());
            jSONObject.put(new String(new byte[]{71, 83, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 65, 115, 117, 76, 101, 118, 101, 108}), cellInfoGsm.getCellSignalStrength().getAsuLevel());
            if (i4 > 29) {
                additionalPlmns = cellInfoGsm.getCellIdentity().getAdditionalPlmns();
                if (additionalPlmns.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (String str8 : additionalPlmns) {
                        jSONArray.put(str8);
                    }
                    jSONObject.put(new String(new byte[]{71, 83, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 65, 100, 100, 105, 116, 105, 111, 110, 97, 108, 80, 108, 109, 110, 115}), jSONArray);
                }
            }
            return jSONObject;
        } else if (cellInfo instanceof CellInfoLte) {
            return f((CellInfoLte) cellInfo);
        } else {
            if (cellInfo instanceof CellInfoCdma) {
                CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(new String(new byte[]{67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 84, 105, 109, 101, 83, 116, 97, 109, 112}), n(cellInfoCdma));
                jSONObject2.put(new String(new byte[]{67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 105, 115, 82, 101, 103, 105, 115, 116, 101, 114, 101, 100}), cellInfoCdma.isRegistered());
                if (Build.VERSION.SDK_INT > 27) {
                    String str9 = new String(new byte[]{67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 67, 101, 108, 108, 67, 111, 110, 110, 101, 99, 116, 105, 111, 110, 83, 116, 97, 116, 117, 115});
                    cellConnectionStatus = cellInfoCdma.getCellConnectionStatus();
                    jSONObject2.put(str9, cellConnectionStatus);
                }
                jSONObject2.put(new String(new byte[]{67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 66, 97, 115, 101, 115, 116, 97, 116, 105, 111, 110, 73, 100}), cellInfoCdma.getCellIdentity().getBasestationId());
                jSONObject2.put(new String(new byte[]{67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 78, 101, 116, 119, 111, 114, 107, 73, 100}), cellInfoCdma.getCellIdentity().getNetworkId());
                jSONObject2.put(new String(new byte[]{67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 76, 97, 116, 105, 116, 117, 100, 101}), cellInfoCdma.getCellIdentity().getLatitude());
                jSONObject2.put(new String(new byte[]{67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 76, 111, 110, 103, 105, 116, 117, 100, 101}), cellInfoCdma.getCellIdentity().getLongitude());
                jSONObject2.put(new String(new byte[]{67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 83, 121, 115, 116, 101, 109, 73, 100}), cellInfoCdma.getCellIdentity().getSystemId());
                jSONObject2.put(new String(new byte[]{67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 83, 105, 103, 110, 97, 108, 83, 116, 114, 101, 110, 103, 116, 104}), cellInfoCdma.getCellSignalStrength());
                jSONObject2.put(new String(new byte[]{67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 68, 98, 109}), cellInfoCdma.getCellSignalStrength().getDbm());
                jSONObject2.put(new String(new byte[]{67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 76, 101, 118, 101, 108}), cellInfoCdma.getCellSignalStrength().getLevel());
                jSONObject2.put(new String(new byte[]{67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 65, 115, 117, 76, 101, 118, 101, 108}), cellInfoCdma.getCellSignalStrength().getAsuLevel());
                return jSONObject2;
            }
            int i5 = Build.VERSION.SDK_INT;
            if (cellInfo instanceof CellInfoWcdma) {
                return i((CellInfoWcdma) cellInfo);
            }
            if (i5 > 28) {
                if (cellInfo instanceof CellInfoNr) {
                    return g((CellInfoNr) cellInfo);
                }
                if (cellInfo instanceof CellInfoTdscdma) {
                    return h((CellInfoTdscdma) cellInfo);
                }
                return null;
            }
            return null;
        }
    }

    @RequiresApi(api = 17)
    private static JSONObject f(CellInfoLte cellInfoLte) throws Exception {
        int[] bands;
        Set<String> additionalPlmns;
        String mobileNetworkOperator;
        String mccString;
        String mncString;
        int cellConnectionStatus;
        int bandwidth;
        int earfcn;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(new String(new byte[]{76, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 84, 105, 109, 101, 83, 116, 97, 109, 112}), n(cellInfoLte));
        jSONObject.put(new String(new byte[]{76, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 105, 115, 82, 101, 103, 105, 115, 116, 101, 114, 101, 100}), cellInfoLte.isRegistered());
        jSONObject.put(new String(new byte[]{76, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 67, 105}), cellInfoLte.getCellIdentity().getCi());
        jSONObject.put(new String(new byte[]{76, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 84, 97, 99}), cellInfoLte.getCellIdentity().getTac());
        jSONObject.put(new String(new byte[]{76, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 80, 99, 105}), cellInfoLte.getCellIdentity().getPci());
        int i4 = Build.VERSION.SDK_INT;
        if (i4 > 23) {
            String str = new String(new byte[]{76, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 69, 97, 114, 102, 99, 110});
            earfcn = cellInfoLte.getCellIdentity().getEarfcn();
            jSONObject.put(str, earfcn);
        }
        if (i4 > 27) {
            String str2 = new String(new byte[]{76, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 77, 111, 98, 105, 108, 101, 78, 101, 116, 119, 111, 114, 107, 79, 112, 101, 114, 97, 116, 111, 114});
            mobileNetworkOperator = cellInfoLte.getCellIdentity().getMobileNetworkOperator();
            jSONObject.put(str2, mobileNetworkOperator);
            String str3 = new String(new byte[]{76, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 77, 99, 99});
            mccString = cellInfoLte.getCellIdentity().getMccString();
            jSONObject.put(str3, mccString);
            String str4 = new String(new byte[]{76, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 77, 110, 99});
            mncString = cellInfoLte.getCellIdentity().getMncString();
            jSONObject.put(str4, mncString);
            String str5 = new String(new byte[]{76, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 67, 101, 108, 108, 67, 111, 110, 110, 101, 99, 116, 105, 111, 110, 83, 116, 97, 116, 117, 115});
            cellConnectionStatus = cellInfoLte.getCellConnectionStatus();
            jSONObject.put(str5, cellConnectionStatus);
            String str6 = new String(new byte[]{76, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 66, 97, 110, 100, 119, 105, 100, 116, 104});
            bandwidth = cellInfoLte.getCellIdentity().getBandwidth();
            jSONObject.put(str6, bandwidth);
        } else {
            String str7 = new String(new byte[]{76, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 77, 99, 99});
            Locale locale = Locale.ENGLISH;
            jSONObject.put(str7, String.format(locale, "%03d", Integer.valueOf(cellInfoLte.getCellIdentity().getMcc())));
            jSONObject.put(new String(new byte[]{76, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 77, 110, 99}), String.format(locale, "%03d", Integer.valueOf(cellInfoLte.getCellIdentity().getMnc())));
        }
        jSONObject.put(new String(new byte[]{76, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 83, 105, 103, 110, 97, 108, 83, 116, 114, 101, 110, 103, 116, 104}), cellInfoLte.getCellSignalStrength());
        jSONObject.put(new String(new byte[]{76, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 68, 98, 109}), cellInfoLte.getCellSignalStrength().getDbm());
        jSONObject.put(new String(new byte[]{76, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 76, 101, 118, 101, 108}), cellInfoLte.getCellSignalStrength().getLevel());
        jSONObject.put(new String(new byte[]{76, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 65, 115, 117, 76, 101, 118, 101, 108}), cellInfoLte.getCellSignalStrength().getAsuLevel());
        if (i4 > 29) {
            bands = cellInfoLte.getCellIdentity().getBands();
            if (bands.length > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i5 : bands) {
                    jSONArray.put(i5);
                }
                jSONObject.put(new String(new byte[]{78, 82, Framer.STDIN_REQUEST_FRAME_PREFIX, 66, 97, 110, 100, 115}), jSONArray);
            }
            additionalPlmns = cellInfoLte.getCellIdentity().getAdditionalPlmns();
            if (additionalPlmns.size() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str8 : additionalPlmns) {
                    jSONArray2.put(str8);
                }
                jSONObject.put(new String(new byte[]{76, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 65, 100, 100, 105, 116, 105, 111, 110, 97, 108, 80, 108, 109, 110, 115}), jSONArray2);
            }
        }
        return jSONObject;
    }

    @RequiresApi(api = 29)
    private static JSONObject g(CellInfoNr cellInfoNr) throws Exception {
        CellIdentity cellIdentity;
        CellIdentity cellIdentity2;
        boolean isRegistered;
        long nci;
        int tac;
        int pci;
        int nrarfcn;
        String mccString;
        String mncString;
        int cellConnectionStatus;
        CellSignalStrength cellSignalStrength;
        CellSignalStrength cellSignalStrength2;
        CellSignalStrength cellSignalStrength3;
        CellSignalStrength cellSignalStrength4;
        int[] bands;
        Set<String> additionalPlmns;
        JSONObject jSONObject = new JSONObject();
        cellIdentity = cellInfoNr.getCellIdentity();
        if (cellIdentity instanceof CellIdentityNr) {
            cellIdentity2 = cellInfoNr.getCellIdentity();
            CellIdentityNr cellIdentityNr = (CellIdentityNr) cellIdentity2;
            jSONObject.put(new String(new byte[]{78, 82, Framer.STDIN_REQUEST_FRAME_PREFIX, 84, 105, 109, 101, 83, 116, 97, 109, 112}), n(cellInfoNr));
            String str = new String(new byte[]{78, 82, Framer.STDIN_REQUEST_FRAME_PREFIX, 105, 115, 82, 101, 103, 105, 115, 116, 101, 114, 101, 100});
            isRegistered = cellInfoNr.isRegistered();
            jSONObject.put(str, isRegistered);
            String str2 = new String(new byte[]{78, 82, Framer.STDIN_REQUEST_FRAME_PREFIX, 78, 99, 105});
            nci = cellIdentityNr.getNci();
            jSONObject.put(str2, nci);
            String str3 = new String(new byte[]{78, 82, Framer.STDIN_REQUEST_FRAME_PREFIX, 84, 97, 99});
            tac = cellIdentityNr.getTac();
            jSONObject.put(str3, tac);
            String str4 = new String(new byte[]{78, 82, Framer.STDIN_REQUEST_FRAME_PREFIX, 80, 99, 105});
            pci = cellIdentityNr.getPci();
            jSONObject.put(str4, pci);
            String str5 = new String(new byte[]{78, 82, Framer.STDIN_REQUEST_FRAME_PREFIX, 78, 114, 97, 114, 102, 99, 110});
            nrarfcn = cellIdentityNr.getNrarfcn();
            jSONObject.put(str5, nrarfcn);
            String str6 = new String(new byte[]{78, 82, Framer.STDIN_REQUEST_FRAME_PREFIX, 77, 99, 99});
            mccString = cellIdentityNr.getMccString();
            jSONObject.put(str6, mccString);
            String str7 = new String(new byte[]{78, 82, Framer.STDIN_REQUEST_FRAME_PREFIX, 77, 110, 99});
            mncString = cellIdentityNr.getMncString();
            jSONObject.put(str7, mncString);
            String str8 = new String(new byte[]{78, 82, Framer.STDIN_REQUEST_FRAME_PREFIX, 67, 101, 108, 108, 67, 111, 110, 110, 101, 99, 116, 105, 111, 110, 83, 116, 97, 116, 117, 115});
            cellConnectionStatus = cellInfoNr.getCellConnectionStatus();
            jSONObject.put(str8, cellConnectionStatus);
            String str9 = new String(new byte[]{78, 82, Framer.STDIN_REQUEST_FRAME_PREFIX, 83, 105, 103, 110, 97, 108, 83, 116, 114, 101, 110, 103, 116, 104});
            cellSignalStrength = cellInfoNr.getCellSignalStrength();
            jSONObject.put(str9, cellSignalStrength);
            String str10 = new String(new byte[]{78, 82, Framer.STDIN_REQUEST_FRAME_PREFIX, 68, 98, 109});
            cellSignalStrength2 = cellInfoNr.getCellSignalStrength();
            jSONObject.put(str10, cellSignalStrength2.getDbm());
            String str11 = new String(new byte[]{78, 82, Framer.STDIN_REQUEST_FRAME_PREFIX, 76, 101, 118, 101, 108});
            cellSignalStrength3 = cellInfoNr.getCellSignalStrength();
            jSONObject.put(str11, cellSignalStrength3.getLevel());
            String str12 = new String(new byte[]{78, 82, Framer.STDIN_REQUEST_FRAME_PREFIX, 65, 115, 117, 76, 101, 118, 101, 108});
            cellSignalStrength4 = cellInfoNr.getCellSignalStrength();
            jSONObject.put(str12, cellSignalStrength4.getAsuLevel());
            if (Build.VERSION.SDK_INT > 29) {
                bands = cellIdentityNr.getBands();
                if (bands.length > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i4 : bands) {
                        jSONArray.put(i4);
                    }
                    jSONObject.put(new String(new byte[]{78, 82, Framer.STDIN_REQUEST_FRAME_PREFIX, 66, 97, 110, 100, 115}), jSONArray);
                }
                additionalPlmns = cellIdentityNr.getAdditionalPlmns();
                if (additionalPlmns.size() > 0) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (String str13 : additionalPlmns) {
                        jSONArray2.put(str13);
                    }
                    jSONObject.put(new String(new byte[]{78, 82, Framer.STDIN_REQUEST_FRAME_PREFIX, 65, 100, 100, 105, 116, 105, 111, 110, 97, 108, 80, 108, 109, 110, 115}), jSONArray2);
                }
            }
            return jSONObject;
        }
        return null;
    }

    @RequiresApi(api = 29)
    private static JSONObject h(CellInfoTdscdma cellInfoTdscdma) throws Exception {
        CellIdentityTdscdma cellIdentity;
        CellIdentityTdscdma cellIdentity2;
        boolean isRegistered;
        int cellConnectionStatus;
        int cid;
        int lac;
        String mobileNetworkOperator;
        String mccString;
        String mncString;
        int uarfcn;
        CellSignalStrengthTdscdma cellSignalStrength;
        CellSignalStrengthTdscdma cellSignalStrength2;
        int dbm;
        CellSignalStrengthTdscdma cellSignalStrength3;
        int level;
        CellSignalStrengthTdscdma cellSignalStrength4;
        int asuLevel;
        Set<String> additionalPlmns;
        JSONObject jSONObject = new JSONObject();
        cellIdentity = cellInfoTdscdma.getCellIdentity();
        if (cellIdentity != null) {
            cellIdentity2 = cellInfoTdscdma.getCellIdentity();
            jSONObject.put(new String(new byte[]{84, 68, 83, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 84, 105, 109, 101, 83, 116, 97, 109, 112}), n(cellInfoTdscdma));
            String str = new String(new byte[]{84, 68, 83, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 105, 115, 82, 101, 103, 105, 115, 116, 101, 114, 101, 100});
            isRegistered = cellInfoTdscdma.isRegistered();
            jSONObject.put(str, isRegistered);
            String str2 = new String(new byte[]{84, 68, 83, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 67, 101, 108, 108, 67, 111, 110, 110, 101, 99, 116, 105, 111, 110, 83, 116, 97, 116, 117, 115});
            cellConnectionStatus = cellInfoTdscdma.getCellConnectionStatus();
            jSONObject.put(str2, cellConnectionStatus);
            String str3 = new String(new byte[]{84, 68, 83, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 67, 105, 100});
            cid = cellIdentity2.getCid();
            jSONObject.put(str3, cid);
            String str4 = new String(new byte[]{84, 68, 83, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 76, 97, 99});
            lac = cellIdentity2.getLac();
            jSONObject.put(str4, lac);
            String str5 = new String(new byte[]{84, 68, 83, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 77, 111, 98, 105, 108, 101, 78, 101, 116, 119, 111, 114, 107, 79, 112, 101, 114, 97, 116, 111, 114});
            mobileNetworkOperator = cellIdentity2.getMobileNetworkOperator();
            jSONObject.put(str5, mobileNetworkOperator);
            String str6 = new String(new byte[]{84, 68, 83, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 77, 99, 99});
            mccString = cellIdentity2.getMccString();
            jSONObject.put(str6, mccString);
            String str7 = new String(new byte[]{84, 68, 83, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 77, 110, 99});
            mncString = cellIdentity2.getMncString();
            jSONObject.put(str7, mncString);
            String str8 = new String(new byte[]{84, 68, 83, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 85, 97, 114, 102, 99, 110});
            uarfcn = cellIdentity2.getUarfcn();
            jSONObject.put(str8, uarfcn);
            String str9 = new String(new byte[]{84, 68, 83, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 83, 105, 103, 110, 97, 108, 83, 116, 114, 101, 110, 103, 116, 104});
            cellSignalStrength = cellInfoTdscdma.getCellSignalStrength();
            jSONObject.put(str9, cellSignalStrength);
            String str10 = new String(new byte[]{84, 68, 83, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 68, 98, 109});
            cellSignalStrength2 = cellInfoTdscdma.getCellSignalStrength();
            dbm = cellSignalStrength2.getDbm();
            jSONObject.put(str10, dbm);
            String str11 = new String(new byte[]{84, 68, 83, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 76, 101, 118, 101, 108});
            cellSignalStrength3 = cellInfoTdscdma.getCellSignalStrength();
            level = cellSignalStrength3.getLevel();
            jSONObject.put(str11, level);
            String str12 = new String(new byte[]{84, 68, 83, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 65, 115, 117, 76, 101, 118, 101, 108});
            cellSignalStrength4 = cellInfoTdscdma.getCellSignalStrength();
            asuLevel = cellSignalStrength4.getAsuLevel();
            jSONObject.put(str12, asuLevel);
            if (Build.VERSION.SDK_INT > 29) {
                additionalPlmns = cellIdentity2.getAdditionalPlmns();
                if (additionalPlmns.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (String str13 : additionalPlmns) {
                        jSONArray.put(str13);
                    }
                    jSONObject.put(new String(new byte[]{84, 68, 83, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 65, 100, 100, 105, 116, 105, 111, 110, 97, 108, 80, 108, 109, 110, 115}), jSONArray);
                }
            }
            return jSONObject;
        }
        return null;
    }

    @RequiresApi(api = 18)
    private static JSONObject i(CellInfoWcdma cellInfoWcdma) throws Exception {
        Set<String> additionalPlmns;
        int uarfcn;
        String mccString;
        String mncString;
        String mobileNetworkOperator;
        int cellConnectionStatus;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(new String(new byte[]{87, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 84, 105, 109, 101, 83, 116, 97, 109, 112}), n(cellInfoWcdma));
        jSONObject.put(new String(new byte[]{87, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 105, 115, 82, 101, 103, 105, 115, 116, 101, 114, 101, 100}), cellInfoWcdma.isRegistered());
        int i4 = Build.VERSION.SDK_INT;
        if (i4 > 27) {
            String str = new String(new byte[]{87, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 67, 101, 108, 108, 67, 111, 110, 110, 101, 99, 116, 105, 111, 110, 83, 116, 97, 116, 117, 115});
            cellConnectionStatus = cellInfoWcdma.getCellConnectionStatus();
            jSONObject.put(str, cellConnectionStatus);
        }
        jSONObject.put(new String(new byte[]{87, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 67, 105, 100}), cellInfoWcdma.getCellIdentity().getCid());
        jSONObject.put(new String(new byte[]{87, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 76, 97, 99}), cellInfoWcdma.getCellIdentity().getLac());
        jSONObject.put(new String(new byte[]{87, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 80, 115, 99}), cellInfoWcdma.getCellIdentity().getPsc());
        if (i4 > 27) {
            String str2 = new String(new byte[]{87, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 77, 99, 99});
            mccString = cellInfoWcdma.getCellIdentity().getMccString();
            jSONObject.put(str2, mccString);
            String str3 = new String(new byte[]{87, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 77, 110, 99});
            mncString = cellInfoWcdma.getCellIdentity().getMncString();
            jSONObject.put(str3, mncString);
            String str4 = new String(new byte[]{87, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 77, 111, 98, 105, 108, 101, 78, 101, 116, 119, 111, 114, 107, 79, 112, 101, 114, 97, 116, 111, 114});
            mobileNetworkOperator = cellInfoWcdma.getCellIdentity().getMobileNetworkOperator();
            jSONObject.put(str4, mobileNetworkOperator);
        } else {
            String str5 = new String(new byte[]{87, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 77, 99, 99});
            Locale locale = Locale.ENGLISH;
            jSONObject.put(str5, String.format(locale, "%03d", Integer.valueOf(cellInfoWcdma.getCellIdentity().getMcc())));
            jSONObject.put(new String(new byte[]{87, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 77, 110, 99}), String.format(locale, "%03d", Integer.valueOf(cellInfoWcdma.getCellIdentity().getMnc())));
        }
        if (i4 > 23) {
            String str6 = new String(new byte[]{87, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 85, 97, 114, 102, 99, 110});
            uarfcn = cellInfoWcdma.getCellIdentity().getUarfcn();
            jSONObject.put(str6, uarfcn);
        }
        jSONObject.put(new String(new byte[]{87, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 83, 105, 103, 110, 97, 108, 83, 116, 114, 101, 110, 103, 116, 104}), cellInfoWcdma.getCellSignalStrength());
        jSONObject.put(new String(new byte[]{87, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 68, 98, 109}), cellInfoWcdma.getCellSignalStrength().getDbm());
        jSONObject.put(new String(new byte[]{87, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 76, 101, 118, 101, 108}), cellInfoWcdma.getCellSignalStrength().getLevel());
        jSONObject.put(new String(new byte[]{87, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 65, 115, 117, 76, 101, 118, 101, 108}), cellInfoWcdma.getCellSignalStrength().getAsuLevel());
        if (i4 > 29) {
            additionalPlmns = cellInfoWcdma.getCellIdentity().getAdditionalPlmns();
            if (additionalPlmns.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (String str7 : additionalPlmns) {
                    jSONArray.put(str7);
                }
                jSONObject.put(new String(new byte[]{87, 67, 68, 77, 65, Framer.STDIN_REQUEST_FRAME_PREFIX, 65, 100, 100, 105, 116, 105, 111, 110, 97, 108, 80, 108, 109, 110, 115}), jSONArray);
            }
        }
        return jSONObject;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    private void j(boolean z3) {
        CellLocation cellLocation;
        CellLocation cellLocation2;
        List list;
        int subscriptionId;
        int subscriptionId2;
        boolean isNetworkRoaming;
        String countryIso;
        int subscriptionId3;
        CharSequence carrierName;
        CharSequence displayName;
        int mcc;
        int mnc;
        boolean isEmbedded;
        int subscriptionType;
        int cardId;
        String mccString;
        String mncString;
        CellLocation cellLocation3;
        CellLocation cellLocation4;
        int subscriptionId4;
        String iccId;
        int subscriptionId5;
        if (this.f39116b.l()) {
            try {
                JSONArray jSONArray = new JSONArray();
                byte b4 = 77;
                byte b5 = 83;
                byte b6 = 73;
                if (Build.VERSION.SDK_INT > 21) {
                    SubscriptionManager subscriptionManager = (SubscriptionManager) this.f39115a.get().getSystemService("telephony_subscription_service");
                    try {
                        list = subscriptionManager.getActiveSubscriptionInfoList();
                    } catch (Exception unused) {
                        list = null;
                    }
                    if (list == null) {
                        return;
                    }
                    int i4 = 0;
                    while (i4 < list.size()) {
                        SubscriptionInfo subscriptionInfo = (SubscriptionInfo) list.get(i4);
                        JSONObject jSONObject = new JSONObject();
                        TelephonyManager telephonyManager = this.f39118d;
                        if (Build.VERSION.SDK_INT > 23) {
                            subscriptionId5 = subscriptionInfo.getSubscriptionId();
                            telephonyManager = telephonyManager.createForSubscriptionId(subscriptionId5);
                        }
                        if (this.f39116b.h()) {
                            String str = new String(new byte[]{b6, b4, b5, b6});
                            subscriptionId4 = subscriptionInfo.getSubscriptionId();
                            jSONObject.put(str, o(telephonyManager, subscriptionId4));
                            jSONObject.put(new String(new byte[]{b6, b4, 69, b6}), b(telephonyManager, i4));
                            iccId = subscriptionInfo.getIccId();
                            if (iccId.isEmpty()) {
                                try {
                                    iccId = telephonyManager.getSimSerialNumber();
                                } catch (Throwable unused2) {
                                    iccId = null;
                                }
                            }
                            jSONObject.put(new String(new byte[]{b5, 105, 109, b5, 101, 114, 105, 97, 108}), iccId);
                        }
                        if (z3) {
                            try {
                                jSONObject.put("CID", ((this.f39116b.e() || this.f39116b.f()) && (telephonyManager.getCellLocation() instanceof GsmCellLocation)) ? ((GsmCellLocation) cellLocation3).getCid() : 0L);
                                jSONObject.put("LAC", ((this.f39116b.e() || this.f39116b.f()) && (telephonyManager.getCellLocation() instanceof GsmCellLocation)) ? ((GsmCellLocation) cellLocation4).getLac() : 0L);
                            } catch (Throwable unused3) {
                            }
                            subscriptionId = subscriptionInfo.getSubscriptionId();
                            jSONObject.put("NetworkType", m(s(telephonyManager, subscriptionId)));
                            subscriptionId2 = subscriptionInfo.getSubscriptionId();
                            isNetworkRoaming = subscriptionManager.isNetworkRoaming(subscriptionId2);
                            jSONObject.put("OperatorIsRoaming", isNetworkRoaming);
                            String str2 = new String(new byte[]{79, 112, 101, 114, 97, 116, 111, 114, b5, 105, 109, 67, 111, 117, 110, 116, 114, 121});
                            countryIso = subscriptionInfo.getCountryIso();
                            jSONObject.put(str2, countryIso);
                            subscriptionId3 = subscriptionInfo.getSubscriptionId();
                            jSONObject.put("OperatorCountry", r(telephonyManager, subscriptionId3));
                            carrierName = subscriptionInfo.getCarrierName();
                            jSONObject.put("Carrier", carrierName);
                            displayName = subscriptionInfo.getDisplayName();
                            jSONObject.put("DisplayName", displayName);
                            int i5 = Build.VERSION.SDK_INT;
                            if (i5 > 28) {
                                String str3 = new String(new byte[]{b5, 105, 109, 84, 121, 112, 101});
                                subscriptionType = subscriptionInfo.getSubscriptionType();
                                jSONObject.put(str3, subscriptionType == 1 ? new String(new byte[]{82, 69, 77, 79, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 83, 73, 77}) : new String(new byte[]{76, 79, 67, 65, 76, Framer.STDIN_REQUEST_FRAME_PREFIX, 83, 73, 77}));
                                cardId = subscriptionInfo.getCardId();
                                jSONObject.put("CardId", a(cardId));
                                mccString = subscriptionInfo.getMccString();
                                jSONObject.put("MCC", mccString);
                                mncString = subscriptionInfo.getMncString();
                                jSONObject.put("MNC", mncString);
                            } else {
                                Locale locale = Locale.ENGLISH;
                                mcc = subscriptionInfo.getMcc();
                                jSONObject.put("MCC", String.format(locale, "%03d", Integer.valueOf(mcc)));
                                mnc = subscriptionInfo.getMnc();
                                jSONObject.put("MNC", String.format(locale, "%03d", Integer.valueOf(mnc)));
                            }
                            jSONObject.put("SimState", q(u(telephonyManager, i4)));
                            if (i5 > 27) {
                                isEmbedded = subscriptionInfo.isEmbedded();
                                jSONObject.put("IsEmbedded", isEmbedded);
                            } else {
                                jSONObject.put("IsEmbedded", false);
                            }
                        }
                        jSONArray.put(jSONObject);
                        i4++;
                        b4 = 77;
                        b5 = 83;
                        b6 = 73;
                    }
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    if (this.f39116b.h()) {
                        jSONObject2.put("IMEI", p());
                        jSONObject2.put("IMSI", t());
                        jSONObject2.put("SimSerial", y());
                    }
                    if (z3) {
                        String networkOperatorName = this.f39118d.getNetworkOperatorName();
                        if (networkOperatorName != null && networkOperatorName.length() > 0) {
                            jSONObject2.put("CarrierName", networkOperatorName);
                        }
                        String networkOperator = this.f39118d.getNetworkOperator();
                        jSONObject2.put("MCC", (networkOperator == null || networkOperator.length() <= 0) ? null : networkOperator.substring(0, 3));
                        jSONObject2.put("MNC", (networkOperator == null || networkOperator.length() <= 0) ? null : networkOperator.substring(3));
                        try {
                            jSONObject2.put("CID", ((this.f39116b.e() || this.f39116b.f()) && (this.f39118d.getCellLocation() instanceof GsmCellLocation)) ? ((GsmCellLocation) cellLocation).getCid() : 0L);
                            jSONObject2.put("LAC", ((this.f39116b.e() || this.f39116b.f()) && (this.f39118d.getCellLocation() instanceof GsmCellLocation)) ? ((GsmCellLocation) cellLocation2).getLac() : 0L);
                        } catch (Throwable unused4) {
                        }
                        jSONObject2.put("NetworkType", m(this.f39118d.getNetworkType()));
                        String networkCountryIso = this.f39118d.getNetworkCountryIso();
                        if (networkCountryIso != null && networkCountryIso.length() > 0) {
                            jSONObject2.put("OperatorCountry", networkCountryIso);
                        }
                        jSONObject2.put("OperatorSimCountry", this.f39118d.getSimCountryIso());
                        jSONObject2.put("OperatorIsRoaming", this.f39118d.isNetworkRoaming());
                        jSONObject2.put("SimState", q(this.f39118d.getSimState()));
                        jSONObject2.put("IsEmbedded", false);
                    }
                    jSONArray.put(jSONObject2);
                }
                if (jSONArray.length() > 0) {
                    if (z3) {
                        this.f39117c.c(jSONArray);
                    } else {
                        this.f39117c.e(jSONArray);
                    }
                }
            } catch (Throwable unused5) {
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    private static String m(int i4) {
        switch (i4) {
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "EVDO rev. 0";
            case 6:
                return "EVDO rev. A";
            case 7:
                return new String(new byte[]{Framer.STDOUT_FRAME_PREFIX, Framer.EXIT_FRAME_PREFIX, 82, 84, 84});
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "iDen";
            case 12:
                return "EVDO rev. B";
            case 13:
                return "LTE";
            case 14:
                return "eHRPD";
            case 15:
                return "HSPAP";
            case 16:
                return "GSM";
            case 17:
                return "SCDMA";
            case 18:
                return "IWLAN";
            case 19:
            default:
                return "Unknown";
            case 20:
                return "NR";
        }
    }

    @RequiresApi(api = 17)
    private static String n(CellInfo cellInfo) {
        long timestampMillis;
        if (Build.VERSION.SDK_INT > 29) {
            timestampMillis = cellInfo.getTimestampMillis();
            return y4.a(System.currentTimeMillis() - timestampMillis);
        }
        return y4.a(System.currentTimeMillis() - (cellInfo.getTimeStamp() / AnimationKt.MillisToNanos));
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    private String o(TelephonyManager telephonyManager, int i4) {
        if (this.f39116b.h()) {
            try {
                if (Build.VERSION.SDK_INT > 23) {
                    return telephonyManager.getSubscriberId();
                }
                return (String) TelephonyManager.class.getMethod("getSubscriberId", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(i4));
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    private static String q(int i4) {
        switch (i4) {
            case 1:
                return new String(new byte[]{83, 73, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 83, 84, 65, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 65, 66, 83, 69, 78, 84});
            case 2:
                return new String(new byte[]{83, 73, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 83, 84, 65, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 80, 73, 78, Framer.STDIN_REQUEST_FRAME_PREFIX, 82, 69, 81, 85, 73, 82, 69, 68});
            case 3:
                return new String(new byte[]{83, 73, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 83, 84, 65, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 80, 85, 75, Framer.STDIN_REQUEST_FRAME_PREFIX, 82, 69, 81, 85, 73, 82, 69, 68});
            case 4:
                return new String(new byte[]{83, 73, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 83, 84, 65, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 78, 69, 84, 87, 79, 82, 75, Framer.STDIN_REQUEST_FRAME_PREFIX, 76, 79, 67, 75, 69, 68});
            case 5:
                return new String(new byte[]{83, 73, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 83, 84, 65, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 82, 69, 65, 68, ClassDefinitionUtils.OPS_dup});
            case 6:
                return new String(new byte[]{83, 73, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 83, 84, 65, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 78, 79, 84, Framer.STDIN_REQUEST_FRAME_PREFIX, 82, 69, 65, 68, ClassDefinitionUtils.OPS_dup});
            case 7:
                return new String(new byte[]{83, 73, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 83, 84, 65, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 80, 69, 82, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 68, 73, 83, 65, 66, 76, 69, 68});
            case 8:
                return new String(new byte[]{83, 73, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 83, 84, 65, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 67, 65, 82, 68, Framer.STDIN_REQUEST_FRAME_PREFIX, 73, 79, Framer.STDIN_REQUEST_FRAME_PREFIX, 69, 82, 82, 79, 82});
            case 9:
                return new String(new byte[]{83, 73, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 83, 84, 65, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 67, 65, 82, 68, Framer.STDIN_REQUEST_FRAME_PREFIX, 82, 69, 83, 84, 82, 73, 67, 84, 69, 68});
            default:
                return new String(new byte[]{83, 73, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 83, 84, 65, 84, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 85, 78, 75, 78, 79, 87, 78});
        }
    }

    private static String r(TelephonyManager telephonyManager, int i4) {
        try {
            if (Build.VERSION.SDK_INT > 23) {
                return telephonyManager.getNetworkCountryIso();
            }
            return (String) TelephonyManager.class.getMethod("getNetworkCountryIsoForSubscription", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(i4));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static int s(TelephonyManager telephonyManager, int i4) {
        try {
            if (Build.VERSION.SDK_INT > 23) {
                return telephonyManager.getSimState();
            }
            return ((Integer) TelephonyManager.class.getMethod("getNetworkType", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(i4))).intValue();
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static int u(TelephonyManager telephonyManager, int i4) {
        try {
            if (Build.VERSION.SDK_INT > 23) {
                return telephonyManager.getSimState();
            }
            return ((Integer) TelephonyManager.class.getMethod("getSimState", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(i4))).intValue();
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final JSONArray d() {
        TelephonyManager telephonyManager = this.f39118d;
        JSONArray jSONArray = new JSONArray();
        if (this.f39116b.e() || this.f39116b.f() || this.f39116b.c()) {
            try {
                for (CellInfo cellInfo : telephonyManager.getAllCellInfo()) {
                    JSONObject e4 = e(cellInfo);
                    if (e4 != null) {
                        jSONArray.put(e4);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"MissingPermission"})
    public final long k() {
        CellLocation cellLocation = this.f39118d.getCellLocation();
        if ((this.f39116b.e() || this.f39116b.f()) && (cellLocation instanceof GsmCellLocation)) {
            return ((GsmCellLocation) cellLocation).getCid();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final n2 l(boolean z3) {
        j(z3);
        if (z3) {
            this.f39117c.b(new b6(this.f39115a.get()).f());
        }
        return this.f39117c;
    }

    final String p() {
        return b(this.f39118d, 0);
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    final String t() {
        try {
            return this.f39118d.getSubscriberId();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"MissingPermission"})
    public final long v() {
        CellLocation cellLocation = this.f39118d.getCellLocation();
        if ((this.f39116b.e() || this.f39116b.f()) && (cellLocation instanceof GsmCellLocation)) {
            return ((GsmCellLocation) cellLocation).getLac();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String w() {
        String networkOperator = this.f39118d.getNetworkOperator();
        if (networkOperator != null && networkOperator.length() > 0) {
            return networkOperator.substring(0, 3);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String x() {
        String networkOperator = this.f39118d.getNetworkOperator();
        if (networkOperator != null && networkOperator.length() > 0) {
            return networkOperator.substring(3);
        }
        return null;
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    final String y() {
        try {
            return this.f39118d.getSimSerialNumber();
        } catch (Throwable unused) {
            return null;
        }
    }
}
