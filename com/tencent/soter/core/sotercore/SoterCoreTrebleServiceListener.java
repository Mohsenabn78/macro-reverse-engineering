package com.tencent.soter.core.sotercore;

/* loaded from: classes6.dex */
public interface SoterCoreTrebleServiceListener {
    void onNoServiceWhenCalling();

    void onServiceBinderDied();

    void onServiceConnected();

    void onServiceDisconnected();

    void onStartServiceConnecting();
}
