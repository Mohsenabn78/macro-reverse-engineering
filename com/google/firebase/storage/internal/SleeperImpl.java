package com.google.firebase.storage.internal;

/* loaded from: classes5.dex */
public class SleeperImpl implements Sleeper {
    @Override // com.google.firebase.storage.internal.Sleeper
    public void sleep(int i4) throws InterruptedException {
        Thread.sleep(i4);
    }
}
