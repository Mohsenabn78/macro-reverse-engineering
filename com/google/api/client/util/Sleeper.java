package com.google.api.client.util;

/* loaded from: classes5.dex */
public interface Sleeper {
    public static final Sleeper DEFAULT = new Sleeper() { // from class: com.google.api.client.util.Sleeper.1
        @Override // com.google.api.client.util.Sleeper
        public void sleep(long j4) throws InterruptedException {
            Thread.sleep(j4);
        }
    };

    void sleep(long j4) throws InterruptedException;
}
