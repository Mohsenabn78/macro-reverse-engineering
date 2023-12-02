package com.tencent.soter.core.model;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class SoterSignatureResult {
    private static final int DEFAULT_SALT_LEN = 20;
    private static final String SIGNATURE_KEY_COUNTER = "counter";
    private static final String SIGNATURE_KEY_CPU_ID = "cpu_id";
    private static final String SIGNATURE_KEY_FID = "fid";
    private static final String SIGNATURE_KEY_FP_NAME = "fp_n";
    private static final String SIGNATURE_KEY_FP_VERSION = "fp_v";
    private static final String SIGNATURE_KEY_RAW = "raw";
    private static final String SIGNATURE_KEY_SALTLEN = "rsa_pss_saltlen";
    private static final String SIGNATURE_KEY_TEE_NAME = "tee_n";
    private static final String SIGNATURE_KEY_TEE_VERSION = "tee_v";
    private static final String TAG = "Soter.SoterSignatureResult";
    private String FpName;
    private String FpVersion;
    private String TEEName;
    private String TEEVersion;
    private long counter;
    private String cpuId;
    private String fid;
    private String jsonValue;
    private String rawValue;
    private int saltLen;
    private String signature;

    public SoterSignatureResult(String str, String str2, long j4, String str3, String str4, String str5, String str6, String str7, String str8, int i4) {
        this.jsonValue = "";
        this.rawValue = str;
        this.fid = str2;
        this.counter = j4;
        this.TEEName = str3;
        this.TEEVersion = str4;
        this.FpName = str5;
        this.FpVersion = str6;
        this.cpuId = str7;
        this.signature = str8;
        this.saltLen = i4;
    }

    public static SoterSignatureResult convertFromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            SoterSignatureResult soterSignatureResult = new SoterSignatureResult();
            soterSignatureResult.setJsonValue(str);
            soterSignatureResult.setRawValue(jSONObject.optString(SIGNATURE_KEY_RAW));
            soterSignatureResult.setFid(jSONObject.optString(SIGNATURE_KEY_FID));
            soterSignatureResult.setCounter(jSONObject.optLong("counter"));
            soterSignatureResult.setTEEName(jSONObject.optString(SIGNATURE_KEY_TEE_NAME));
            soterSignatureResult.setTEEVersion(jSONObject.optString(SIGNATURE_KEY_TEE_VERSION));
            soterSignatureResult.setFpName(jSONObject.optString(SIGNATURE_KEY_FP_NAME));
            soterSignatureResult.setFpVersion(jSONObject.optString(SIGNATURE_KEY_FP_VERSION));
            soterSignatureResult.setCpuId(jSONObject.optString("cpu_id"));
            soterSignatureResult.setSaltLen(jSONObject.optInt(SIGNATURE_KEY_SALTLEN, 20));
            return soterSignatureResult;
        } catch (JSONException e4) {
            SLogger.e(TAG, "soter: convert from json failed." + e4.toString(), new Object[0]);
            return null;
        }
    }

    private void setCounter(long j4) {
        this.counter = j4;
    }

    private void setFid(String str) {
        this.fid = str;
    }

    private void setFpName(String str) {
        this.FpName = str;
    }

    private void setFpVersion(String str) {
        this.FpVersion = str;
    }

    private void setJsonValue(String str) {
        this.jsonValue = str;
    }

    private void setRawValue(String str) {
        this.rawValue = str;
    }

    private void setSaltLen(int i4) {
        this.saltLen = i4;
    }

    private void setTEEName(String str) {
        this.TEEName = str;
    }

    private void setTEEVersion(String str) {
        this.TEEVersion = str;
    }

    public long getCounter() {
        return this.counter;
    }

    public String getCpuId() {
        return this.cpuId;
    }

    public String getFid() {
        return this.fid;
    }

    public String getFpName() {
        return this.FpName;
    }

    public String getFpVersion() {
        return this.FpVersion;
    }

    public String getJsonValue() {
        return this.jsonValue;
    }

    public String getRawValue() {
        return this.rawValue;
    }

    public int getSaltLen() {
        return this.saltLen;
    }

    public String getSignature() {
        return this.signature;
    }

    public String getTEEName() {
        return this.TEEName;
    }

    public String getTEEVersion() {
        return this.TEEVersion;
    }

    public void setCpuId(String str) {
        this.cpuId = str;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public String toString() {
        return "SoterSignatureResult{rawValue='" + this.rawValue + "', fid='" + this.fid + "', counter=" + this.counter + ", TEEName='" + this.TEEName + "', TEEVersion='" + this.TEEVersion + "', FpName='" + this.FpName + "', FpVersion='" + this.FpVersion + "', cpuId='" + this.cpuId + "', saltLen=" + this.saltLen + ", jsonValue='" + this.jsonValue + "', signature='" + this.signature + "'}";
    }

    public SoterSignatureResult() {
        this.rawValue = null;
        this.fid = null;
        this.counter = -1L;
        this.TEEName = "";
        this.TEEVersion = "";
        this.FpName = "";
        this.FpVersion = "";
        this.cpuId = "";
        this.saltLen = 20;
        this.jsonValue = "";
        this.signature = "";
    }
}
