package com.koushikdutta.async;

/* loaded from: classes6.dex */
public interface DataTrackingEmitter extends DataEmitter {

    /* loaded from: classes6.dex */
    public interface DataTracker {
        void onData(int i4);
    }

    int getBytesRead();

    DataTracker getDataTracker();

    void setDataEmitter(DataEmitter dataEmitter);

    void setDataTracker(DataTracker dataTracker);
}
