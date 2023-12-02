package com.google.api.client.testing.util;

import com.google.api.client.util.BackOff;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import java.io.IOException;

@Beta
/* loaded from: classes5.dex */
public class MockBackOff implements BackOff {

    /* renamed from: a  reason: collision with root package name */
    private long f26050a;

    /* renamed from: b  reason: collision with root package name */
    private int f26051b = 10;

    /* renamed from: c  reason: collision with root package name */
    private int f26052c;

    public final int getMaxTries() {
        return this.f26052c;
    }

    public final int getNumberOfTries() {
        return this.f26052c;
    }

    @Override // com.google.api.client.util.BackOff
    public long nextBackOffMillis() throws IOException {
        int i4 = this.f26052c;
        if (i4 < this.f26051b) {
            long j4 = this.f26050a;
            if (j4 != -1) {
                this.f26052c = i4 + 1;
                return j4;
            }
        }
        return -1L;
    }

    @Override // com.google.api.client.util.BackOff
    public void reset() throws IOException {
        this.f26052c = 0;
    }

    public MockBackOff setBackOffMillis(long j4) {
        boolean z3;
        if (j4 != -1 && j4 < 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        Preconditions.checkArgument(z3);
        this.f26050a = j4;
        return this;
    }

    public MockBackOff setMaxTries(int i4) {
        boolean z3;
        if (i4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        this.f26051b = i4;
        return this;
    }
}
