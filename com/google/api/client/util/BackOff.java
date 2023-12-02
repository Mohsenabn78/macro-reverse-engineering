package com.google.api.client.util;

import java.io.IOException;

/* loaded from: classes5.dex */
public interface BackOff {
    public static final long STOP = -1;
    public static final BackOff ZERO_BACKOFF = new BackOff() { // from class: com.google.api.client.util.BackOff.1
        @Override // com.google.api.client.util.BackOff
        public long nextBackOffMillis() throws IOException {
            return 0L;
        }

        @Override // com.google.api.client.util.BackOff
        public void reset() throws IOException {
        }
    };
    public static final BackOff STOP_BACKOFF = new BackOff() { // from class: com.google.api.client.util.BackOff.2
        @Override // com.google.api.client.util.BackOff
        public long nextBackOffMillis() throws IOException {
            return -1L;
        }

        @Override // com.google.api.client.util.BackOff
        public void reset() throws IOException {
        }
    };

    long nextBackOffMillis() throws IOException;

    void reset() throws IOException;
}
