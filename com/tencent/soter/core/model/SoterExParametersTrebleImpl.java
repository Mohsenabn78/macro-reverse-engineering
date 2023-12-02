package com.tencent.soter.core.model;

import androidx.annotation.NonNull;

/* loaded from: classes6.dex */
public class SoterExParametersTrebleImpl implements ISoterExParameters {
    private static int[] fingerprintPosition;
    private static int fingerprintType;

    public static void setParam(@NonNull String str, Object obj) {
        synchronized (SoterExParametersTrebleImpl.class) {
            if (ISoterExParameters.FINGERPRINT_TYPE.equals(str)) {
                fingerprintType = ((Integer) obj).intValue();
            } else if (ISoterExParameters.FINGERPRINT_HARDWARE_POSITION.equals(str)) {
                fingerprintPosition = (int[]) obj;
            }
        }
    }

    @Override // com.tencent.soter.core.model.ISoterExParameters
    public Object getParam(@NonNull String str, Object obj) {
        synchronized (SoterExParametersTrebleImpl.class) {
            if (ISoterExParameters.FINGERPRINT_TYPE.equals(str)) {
                int i4 = fingerprintType;
                if (i4 != 0) {
                    obj = Integer.valueOf(i4);
                }
                return obj;
            } else if (ISoterExParameters.FINGERPRINT_HARDWARE_POSITION.equals(str)) {
                int[] iArr = fingerprintPosition;
                if (iArr != null) {
                    obj = iArr;
                }
                return obj;
            } else {
                return null;
            }
        }
    }
}
