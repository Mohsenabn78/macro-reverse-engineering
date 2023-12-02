package com.bumptech.glide.manager;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class RequestTracker {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Request> f17362a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final List<Request> f17363b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private boolean f17364c;

    private boolean a(@Nullable Request request, boolean z3) {
        boolean z4 = true;
        if (request == null) {
            return true;
        }
        boolean remove = this.f17362a.remove(request);
        if (!this.f17363b.remove(request) && !remove) {
            z4 = false;
        }
        if (z4) {
            request.clear();
            if (z3) {
                request.recycle();
            }
        }
        return z4;
    }

    public boolean clearRemoveAndRecycle(@Nullable Request request) {
        return a(request, true);
    }

    public void clearRequests() {
        for (Request request : Util.getSnapshot(this.f17362a)) {
            a(request, false);
        }
        this.f17363b.clear();
    }

    public boolean isPaused() {
        return this.f17364c;
    }

    public void pauseAllRequests() {
        this.f17364c = true;
        for (Request request : Util.getSnapshot(this.f17362a)) {
            if (request.isRunning() || request.isComplete()) {
                request.clear();
                this.f17363b.add(request);
            }
        }
    }

    public void pauseRequests() {
        this.f17364c = true;
        for (Request request : Util.getSnapshot(this.f17362a)) {
            if (request.isRunning()) {
                request.clear();
                this.f17363b.add(request);
            }
        }
    }

    public void restartRequests() {
        for (Request request : Util.getSnapshot(this.f17362a)) {
            if (!request.isComplete() && !request.isCleared()) {
                request.clear();
                if (!this.f17364c) {
                    request.begin();
                } else {
                    this.f17363b.add(request);
                }
            }
        }
    }

    public void resumeRequests() {
        this.f17364c = false;
        for (Request request : Util.getSnapshot(this.f17362a)) {
            if (!request.isComplete() && !request.isRunning()) {
                request.begin();
            }
        }
        this.f17363b.clear();
    }

    public void runRequest(@NonNull Request request) {
        this.f17362a.add(request);
        if (!this.f17364c) {
            request.begin();
            return;
        }
        request.clear();
        Log.isLoggable("RequestTracker", 2);
        this.f17363b.add(request);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f17362a.size() + ", isPaused=" + this.f17364c + "}";
    }
}
