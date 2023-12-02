package com.bumptech.glide.request;

import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public final class ErrorRequestCoordinator implements RequestCoordinator, Request {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final RequestCoordinator f17426a;

    /* renamed from: b  reason: collision with root package name */
    private Request f17427b;

    /* renamed from: c  reason: collision with root package name */
    private Request f17428c;

    public ErrorRequestCoordinator(@Nullable RequestCoordinator requestCoordinator) {
        this.f17426a = requestCoordinator;
    }

    private boolean a(Request request) {
        if (!request.equals(this.f17427b) && (!this.f17427b.isFailed() || !request.equals(this.f17428c))) {
            return false;
        }
        return true;
    }

    private boolean b() {
        RequestCoordinator requestCoordinator = this.f17426a;
        if (requestCoordinator != null && !requestCoordinator.canNotifyCleared(this)) {
            return false;
        }
        return true;
    }

    private boolean c() {
        RequestCoordinator requestCoordinator = this.f17426a;
        if (requestCoordinator != null && !requestCoordinator.canNotifyStatusChanged(this)) {
            return false;
        }
        return true;
    }

    private boolean d() {
        RequestCoordinator requestCoordinator = this.f17426a;
        if (requestCoordinator != null && !requestCoordinator.canSetImage(this)) {
            return false;
        }
        return true;
    }

    private boolean e() {
        RequestCoordinator requestCoordinator = this.f17426a;
        if (requestCoordinator != null && requestCoordinator.isAnyResourceSet()) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.request.Request
    public void begin() {
        if (!this.f17427b.isRunning()) {
            this.f17427b.begin();
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyCleared(Request request) {
        if (b() && a(request)) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyStatusChanged(Request request) {
        if (c() && a(request)) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canSetImage(Request request) {
        if (d() && a(request)) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        this.f17427b.clear();
        if (this.f17428c.isRunning()) {
            this.f17428c.clear();
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean isAnyResourceSet() {
        if (!e() && !isResourceSet()) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        Request request;
        if (this.f17427b.isFailed()) {
            request = this.f17428c;
        } else {
            request = this.f17427b;
        }
        return request.isCleared();
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        Request request;
        if (this.f17427b.isFailed()) {
            request = this.f17428c;
        } else {
            request = this.f17427b;
        }
        return request.isComplete();
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request request) {
        if (!(request instanceof ErrorRequestCoordinator)) {
            return false;
        }
        ErrorRequestCoordinator errorRequestCoordinator = (ErrorRequestCoordinator) request;
        if (!this.f17427b.isEquivalentTo(errorRequestCoordinator.f17427b) || !this.f17428c.isEquivalentTo(errorRequestCoordinator.f17428c)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isFailed() {
        if (this.f17427b.isFailed() && this.f17428c.isFailed()) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isResourceSet() {
        Request request;
        if (this.f17427b.isFailed()) {
            request = this.f17428c;
        } else {
            request = this.f17427b;
        }
        return request.isResourceSet();
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        Request request;
        if (this.f17427b.isFailed()) {
            request = this.f17428c;
        } else {
            request = this.f17427b;
        }
        return request.isRunning();
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestFailed(Request request) {
        if (!request.equals(this.f17428c)) {
            if (!this.f17428c.isRunning()) {
                this.f17428c.begin();
                return;
            }
            return;
        }
        RequestCoordinator requestCoordinator = this.f17426a;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestFailed(this);
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestSuccess(Request request) {
        RequestCoordinator requestCoordinator = this.f17426a;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestSuccess(this);
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void recycle() {
        this.f17427b.recycle();
        this.f17428c.recycle();
    }

    public void setRequests(Request request, Request request2) {
        this.f17427b = request;
        this.f17428c = request2;
    }
}
