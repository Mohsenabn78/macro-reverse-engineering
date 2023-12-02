package com.tencent.soter.core.model;

import android.os.Process;

/* loaded from: classes6.dex */
public interface ConstantsSoter {
    public static final int ERR_BIOMETRIC_FAIL_MAX = 10308;
    public static final int ERR_BIOMETRIC_FAIL_MAX_PERMANENT = 10309;
    public static final int ERR_BIOMETRIC_WAIT_TIMEOUT = 10309;
    public static final int ERR_FINGERPRINT_FAIL_MAX = 10308;
    public static final int ERR_NEGATIVE_BUTTON = 10310;
    public static final int FACEID_AUTH = 2;
    public static final long FACEID_AUTH_CHECK_TIME = 3000;
    public static final int FINGERPRINT_AUTH = 1;
    public static final String SOTER_BIOMETRIC_ERR_FAIL_MAX_MSG = "Too many failed times";
    public static final String SOTER_FACEID_ERR_FAIL_MAX_MSG = "Too many failed times";
    public static final String SOTER_FINGERPRINT_ERR_FAIL_MAX_MSG = "Too many failed times";
    public static final String SOTER_PROVIDER_NAME = "SoterKeyStore";
    public static final String SOTER_COMMON_KEYNAME_PREFIX = "Wechat";
    public static final String COMMON_SOTER_APP_SECURE_KEY_NAME = SOTER_COMMON_KEYNAME_PREFIX + Process.myUid();
}
