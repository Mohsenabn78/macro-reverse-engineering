package com.koushikdutta.async;

import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;

/* loaded from: classes6.dex */
public interface DataEmitter {
    String charset();

    void close();

    DataCallback getDataCallback();

    CompletedCallback getEndCallback();

    AsyncServer getServer();

    boolean isChunked();

    boolean isPaused();

    void pause();

    void resume();

    void setDataCallback(DataCallback dataCallback);

    void setEndCallback(CompletedCallback completedCallback);
}
