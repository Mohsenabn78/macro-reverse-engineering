package com.tencent.soter.core.model;

import androidx.annotation.NonNull;

/* loaded from: classes6.dex */
public interface ISoterExParameters {
    public static final String FINGERPRINT_HARDWARE_POSITION = "fingerprint_hardware_position";
    public static final String FINGERPRINT_TYPE = "fingerprint_type";
    public static final int FINGERPRINT_TYPE_NORMAL = 1;
    public static final int FINGERPRINT_TYPE_UNDEFINE = 0;
    public static final int FINGERPRINT_TYPE_UNDER_SCREEN = 2;

    Object getParam(@NonNull String str, Object obj);
}
