package com.google.firebase.heartbeatinfo;

import androidx.annotation.NonNull;

/* loaded from: classes5.dex */
public interface HeartBeatInfo {

    /* loaded from: classes5.dex */
    public enum HeartBeat {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);
        
        private final int code;

        HeartBeat(int i4) {
            this.code = i4;
        }

        public int getCode() {
            return this.code;
        }
    }

    @NonNull
    HeartBeat getHeartBeatCode(@NonNull String str);
}
