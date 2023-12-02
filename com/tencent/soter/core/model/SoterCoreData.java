package com.tencent.soter.core.model;

/* loaded from: classes6.dex */
public class SoterCoreData {
    private static volatile SoterCoreData instance;
    private String mAskName = ConstantsSoter.COMMON_SOTER_APP_SECURE_KEY_NAME;

    public static SoterCoreData getInstance() {
        SoterCoreData soterCoreData;
        if (instance == null) {
            synchronized (SoterCoreData.class) {
                if (instance == null) {
                    instance = new SoterCoreData();
                }
                soterCoreData = instance;
            }
            return soterCoreData;
        }
        return instance;
    }

    public String getAskName() {
        return this.mAskName;
    }

    public void setAskName(String str) {
        this.mAskName = str;
    }
}
