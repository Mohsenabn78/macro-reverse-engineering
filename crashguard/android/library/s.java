package crashguard.android.library;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ProxyInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.facebook.stetho.dumpapp.Framer;
import java.util.BitSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes6.dex */
final class s {

    /* renamed from: a  reason: collision with root package name */
    private final WifiManager f39029a;

    /* renamed from: b  reason: collision with root package name */
    private final z5 f39030b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(Context context) {
        this.f39029a = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        this.f39030b = new z5(context);
    }

    private static String a(int i4) {
        if (i4 > -1) {
            String[] strArr = WifiConfiguration.Status.strings;
            if (i4 < strArr.length) {
                return strArr[i4];
            }
        }
        return String.valueOf(i4);
    }

    private static JSONArray c(BitSet bitSet, String[] strArr) {
        JSONArray jSONArray = new JSONArray();
        for (int i4 = 0; i4 < bitSet.length(); i4++) {
            if (bitSet.get(i4)) {
                jSONArray.put(strArr[i4]);
            }
        }
        return jSONArray;
    }

    private static JSONArray d(String[] strArr) {
        JSONArray jSONArray = new JSONArray();
        if (strArr != null) {
            try {
                for (String str : strArr) {
                    if (!"null".equals(str)) {
                        jSONArray.put(str);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"MissingPermission"})
    public final JSONArray b() {
        String str;
        int i4;
        String str2;
        int i5;
        String str3;
        ProxyInfo httpProxy;
        boolean isPasspoint;
        String str4;
        boolean z3;
        try {
            if (this.f39030b.f() || this.f39030b.j()) {
                List<WifiConfiguration> configuredNetworks = this.f39029a.getConfiguredNetworks();
                JSONArray jSONArray = new JSONArray();
                for (int i6 = 0; i6 < configuredNetworks.size(); i6++) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("BSSID", configuredNetworks.get(i6).BSSID);
                    String replaceAll = configuredNetworks.get(i6).SSID.replaceAll("\\\"", "");
                    if (replaceAll.length() > 0) {
                        replaceAll = k2.a(replaceAll);
                    }
                    jSONObject.put("SSID", replaceAll);
                    int i7 = Build.VERSION.SDK_INT;
                    jSONObject.put("FQDN", configuredNetworks.get(i6).FQDN);
                    if (i7 >= 26) {
                        z3 = configuredNetworks.get(i6).isHomeProviderNetwork;
                        jSONObject.put("IsHomeProviderNetwork", z3);
                    }
                    jSONObject.put("NetworkId", configuredNetworks.get(i6).networkId);
                    jSONObject.put("Status", a(configuredNetworks.get(i6).status));
                    jSONObject.put("AllowedAuthAlgorithms", c(configuredNetworks.get(i6).allowedAuthAlgorithms, WifiConfiguration.AuthAlgorithm.strings));
                    jSONObject.put("AllowedGroupCiphers", c(configuredNetworks.get(i6).allowedGroupCiphers, WifiConfiguration.GroupCipher.strings));
                    jSONObject.put("AllowedKeyManagement", c(configuredNetworks.get(i6).allowedKeyManagement, WifiConfiguration.KeyMgmt.strings));
                    jSONObject.put("AllowedPairwiseCiphers", c(configuredNetworks.get(i6).allowedPairwiseCiphers, WifiConfiguration.PairwiseCipher.strings));
                    jSONObject.put("AllowedProtocols", c(configuredNetworks.get(i6).allowedProtocols, WifiConfiguration.Protocol.strings));
                    jSONObject.put("HiddenSSID", configuredNetworks.get(i6).hiddenSSID);
                    jSONObject.put("EnterpriseConfig", configuredNetworks.get(i6).enterpriseConfig);
                    if (configuredNetworks.get(i6).preSharedKey != null && !configuredNetworks.get(i6).preSharedKey.equals("*")) {
                        jSONObject.put("PreSharedKey", configuredNetworks.get(i6).preSharedKey);
                    }
                    if (i7 >= 23) {
                        str4 = configuredNetworks.get(i6).providerFriendlyName;
                        jSONObject.put("ProviderFriendlyName", str4);
                    }
                    jSONObject.put("Priority", configuredNetworks.get(i6).priority);
                    jSONObject.put("WepKeys", d(configuredNetworks.get(i6).wepKeys));
                    jSONObject.put(new String(new byte[]{87, 101, 112, 84, Framer.EXIT_FRAME_PREFIX, 75, 101, 121, 73, 110, 100, 101, Framer.EXIT_FRAME_PREFIX}), configuredNetworks.get(i6).wepTxKeyIndex);
                    if (i7 >= 23) {
                        isPasspoint = configuredNetworks.get(i6).isPasspoint();
                        jSONObject.put("IsPasspoint", isPasspoint);
                    }
                    if (i7 >= 26) {
                        String str5 = new String(new byte[]{71, 101, 116, 72, 116, 116, 112, 80, 114, 111, Framer.EXIT_FRAME_PREFIX, 121});
                        httpProxy = configuredNetworks.get(i6).getHttpProxy();
                        jSONObject.put(str5, httpProxy);
                    }
                    String str6 = "NumberOfAssociation";
                    String wifiConfiguration = configuredNetworks.get(i6).toString();
                    String str7 = "numAssociation";
                    try {
                        String substring = wifiConfiguration.substring(wifiConfiguration.indexOf(str7) + str7.length());
                        str = substring.substring(1, substring.indexOf("\n"));
                    } catch (Throwable unused) {
                        str = null;
                    }
                    try {
                        i4 = Integer.parseInt(str);
                    } catch (Throwable unused2) {
                        i4 = -1;
                    }
                    jSONObject.put(str6, i4);
                    String str8 = "AssociationRejectionCode";
                    String wifiConfiguration2 = configuredNetworks.get(i6).toString();
                    String str9 = "Association Rejection code:";
                    try {
                        String substring2 = wifiConfiguration2.substring(wifiConfiguration2.indexOf(str9) + str9.length());
                        str2 = substring2.substring(1, substring2.indexOf("\n"));
                    } catch (Throwable unused3) {
                        str2 = null;
                    }
                    try {
                        i5 = Integer.parseInt(str2);
                    } catch (Throwable unused4) {
                        i5 = -1;
                    }
                    jSONObject.put(str8, i5);
                    String str10 = "HasEverConnected";
                    String wifiConfiguration3 = configuredNetworks.get(i6).toString();
                    String str11 = "hasEverConnected:";
                    try {
                        String substring3 = wifiConfiguration3.substring(wifiConfiguration3.indexOf(str11) + str11.length());
                        str3 = substring3.substring(1, substring3.indexOf("\n"));
                    } catch (Throwable unused5) {
                        str3 = null;
                    }
                    jSONObject.put(str10, str3);
                    jSONArray.put(jSONObject);
                }
                return jSONArray;
            }
            return null;
        } catch (Throwable unused6) {
            return null;
        }
    }
}
