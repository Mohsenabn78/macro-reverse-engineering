package com.tencent.soter.core.model;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class SoterPubKeyModel {
    public static final String JSON_KEY_CERTS = "certs";
    public static final String JSON_KEY_COUNTER = "counter";
    public static final String JSON_KEY_CPU_ID = "cpu_id";
    public static final String JSON_KEY_PUBLIC = "pub_key";
    public static final String JSON_KEY_UID = "uid";
    private static final String TAG = "Soter.SoterPubKeyModel";
    private ArrayList<String> certs;
    private long counter;
    private String cpu_id;
    private String pub_key_in_x509;
    private String rawJson;
    private String signature;
    private int uid;

    public SoterPubKeyModel(long j4, int i4, String str, String str2, String str3) {
        this.rawJson = "";
        this.certs = null;
        this.counter = j4;
        this.uid = i4;
        this.cpu_id = str;
        this.pub_key_in_x509 = str2;
        this.signature = str3;
    }

    private void loadDeviceInfo(X509Certificate x509Certificate) {
        try {
            CertUtil.extractAttestationSequence(x509Certificate, this);
        } catch (Exception e4) {
            SLogger.printErrStackTrace(TAG, e4, "soter: loadDeviceInfo from attestationCert failed");
        }
    }

    public long getCounter() {
        return this.counter;
    }

    public String getCpu_id() {
        return this.cpu_id;
    }

    public String getPub_key_in_x509() {
        return this.pub_key_in_x509;
    }

    public String getRawJson() {
        return this.rawJson;
    }

    public String getSignature() {
        return this.signature;
    }

    public int getUid() {
        return this.uid;
    }

    public void setCounter(long j4) {
        this.counter = j4;
    }

    public void setCpu_id(String str) {
        this.cpu_id = str;
    }

    public void setPub_key_in_x509(String str) {
        this.pub_key_in_x509 = str;
    }

    public void setRawJson(String str) {
        this.rawJson = str;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public void setUid(int i4) {
        this.uid = i4;
    }

    public String toString() {
        return "SoterPubKeyModel{counter=" + this.counter + ", uid=" + this.uid + ", cpu_id='" + this.cpu_id + "', pub_key_in_x509='" + this.pub_key_in_x509 + "', rawJson='" + this.rawJson + "', signature='" + this.signature + "'}";
    }

    public SoterPubKeyModel(String str, String str2) {
        this.counter = -1L;
        this.uid = -1;
        this.cpu_id = "";
        this.pub_key_in_x509 = "";
        this.rawJson = "";
        this.certs = null;
        this.signature = "";
        setRawJson(str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(JSON_KEY_CERTS)) {
                JSONArray optJSONArray = jSONObject.optJSONArray(JSON_KEY_CERTS);
                if (optJSONArray.length() < 2) {
                    SLogger.e(TAG, "certificates train not enough", new Object[0]);
                }
                SLogger.i(TAG, "certs size: [%d]", Integer.valueOf(optJSONArray.length()));
                this.certs = new ArrayList<>();
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    this.certs.add(optJSONArray.getString(i4));
                }
                loadDeviceInfo((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(this.certs.get(0).getBytes())));
                jSONObject.put("cpu_id", this.cpu_id);
                jSONObject.put("uid", this.uid);
                jSONObject.put("counter", this.counter);
                setRawJson(jSONObject.toString());
            } else {
                this.counter = jSONObject.optLong("counter");
                this.uid = jSONObject.optInt("uid");
                this.cpu_id = jSONObject.optString("cpu_id");
                this.pub_key_in_x509 = jSONObject.optString(JSON_KEY_PUBLIC);
            }
        } catch (Exception unused) {
            SLogger.e(TAG, "soter: pub key model failed", new Object[0]);
        }
        this.signature = str2;
    }

    public SoterPubKeyModel(Certificate[] certificateArr) {
        this.counter = -1L;
        this.uid = -1;
        this.cpu_id = "";
        this.pub_key_in_x509 = "";
        this.rawJson = "";
        this.certs = null;
        this.signature = "";
        if (certificateArr != null) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                JSONArray jSONArray = new JSONArray();
                for (int i4 = 0; i4 < certificateArr.length; i4++) {
                    Certificate certificate = certificateArr[i4];
                    Base64.encodeToString(certificate.getEncoded(), 2);
                    String format = CertUtil.format(certificate);
                    if (i4 == 0) {
                        loadDeviceInfo((X509Certificate) certificate);
                    }
                    jSONArray.put(format);
                    arrayList.add(format);
                }
                this.certs = arrayList;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(JSON_KEY_CERTS, jSONArray);
                jSONObject.put("cpu_id", this.cpu_id);
                jSONObject.put("uid", this.uid);
                jSONObject.put("counter", this.counter);
                setRawJson(jSONObject.toString());
            } catch (Exception unused) {
                SLogger.e(TAG, "soter: pub key model failed", new Object[0]);
            }
        }
    }
}
