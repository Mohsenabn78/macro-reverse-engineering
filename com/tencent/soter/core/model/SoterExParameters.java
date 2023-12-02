package com.tencent.soter.core.model;

import com.tencent.soter.core.SoterCore;

/* loaded from: classes6.dex */
public class SoterExParameters {
    private static final String SOTEREX_PROVIDER_CLASS_NAME = "com.tencent.soter.core.model.SoterExParameterProvider";
    private static final String TAG = "SoterExParameters";
    private static SoterExParameters instance;
    private ISoterExParameters impl;

    private SoterExParameters() {
        this.impl = null;
        try {
            this.impl = (ISoterExParameters) Class.forName(SOTEREX_PROVIDER_CLASS_NAME).getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            SLogger.e(TAG, "soter: init ext param failed.", new Object[0]);
            if (SoterCore.getSoterCoreType() == 1) {
                this.impl = new SoterExParametersTrebleImpl();
                if (SoterCore.getImpl() != null) {
                    SoterCore.getImpl().updateExtraParam();
                }
            }
        }
    }

    public static SoterExParameters getInstance() {
        SoterExParameters soterExParameters;
        SoterExParameters soterExParameters2 = instance;
        if (soterExParameters2 == null) {
            synchronized (SoterExParameters.class) {
                if (instance == null) {
                    instance = new SoterExParameters();
                }
                soterExParameters = instance;
            }
            return soterExParameters;
        }
        return soterExParameters2;
    }

    public int[] getFingerprintHardwarePosition() {
        Object param = getParam(ISoterExParameters.FINGERPRINT_HARDWARE_POSITION, null);
        if (!(param instanceof int[])) {
            return null;
        }
        return (int[]) param;
    }

    public int getFingerprintType() {
        Object param = getParam(ISoterExParameters.FINGERPRINT_TYPE, 0);
        if (!(param instanceof Integer)) {
            return 0;
        }
        return ((Integer) param).intValue();
    }

    public Object getParam(String str, Object obj) {
        ISoterExParameters iSoterExParameters = this.impl;
        if (iSoterExParameters != null) {
            return iSoterExParameters.getParam(str, obj);
        }
        return null;
    }
}
