package com.bumptech.glide.request;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

/* loaded from: classes3.dex */
public class ThumbnailRequestCoordinator implements RequestCoordinator, Request {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final RequestCoordinator f17473a;

    /* renamed from: b  reason: collision with root package name */
    private Request f17474b;

    /* renamed from: c  reason: collision with root package name */
    private Request f17475c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17476d;

    @VisibleForTesting
    ThumbnailRequestCoordinator() {
        this(null);
    }

    private boolean a() {
        RequestCoordinator requestCoordinator = this.f17473a;
        if (requestCoordinator != null && !requestCoordinator.canNotifyCleared(this)) {
            return false;
        }
        return true;
    }

    private boolean b() {
        RequestCoordinator requestCoordinator = this.f17473a;
        if (requestCoordinator != null && !requestCoordinator.canNotifyStatusChanged(this)) {
            return false;
        }
        return true;
    }

    private boolean c() {
        RequestCoordinator requestCoordinator = this.f17473a;
        if (requestCoordinator != null && !requestCoordinator.canSetImage(this)) {
            return false;
        }
        return true;
    }

    private boolean d() {
        RequestCoordinator requestCoordinator = this.f17473a;
        if (requestCoordinator != null && requestCoordinator.isAnyResourceSet()) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.request.Request
    public void begin() {
        this.f17476d = true;
        if (!this.f17474b.isComplete() && !this.f17475c.isRunning()) {
            this.f17475c.begin();
        }
        if (this.f17476d && !this.f17474b.isRunning()) {
            this.f17474b.begin();
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyCleared(Request request) {
        if (a() && request.equals(this.f17474b)) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyStatusChanged(Request request) {
        if (b() && request.equals(this.f17474b) && !isAnyResourceSet()) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canSetImage(Request request) {
        if (c() && (request.equals(this.f17474b) || !this.f17474b.isResourceSet())) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        this.f17476d = false;
        this.f17475c.clear();
        this.f17474b.clear();
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean isAnyResourceSet() {
        if (!d() && !isResourceSet()) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        return this.f17474b.isCleared();
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        if (!this.f17474b.isComplete() && !this.f17475c.isComplete()) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request request) {
        if (!(request instanceof ThumbnailRequestCoordinator)) {
            return false;
        }
        ThumbnailRequestCoordinator thumbnailRequestCoordinator = (ThumbnailRequestCoordinator) request;
        Request request2 = this.f17474b;
        if (request2 == null) {
            if (thumbnailRequestCoordinator.f17474b != null) {
                return false;
            }
        } else if (!request2.isEquivalentTo(thumbnailRequestCoordinator.f17474b)) {
            return false;
        }
        Request request3 = this.f17475c;
        Request request4 = thumbnailRequestCoordinator.f17475c;
        if (request3 == null) {
            if (request4 != null) {
                return false;
            }
        } else if (!request3.isEquivalentTo(request4)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isFailed() {
        return this.f17474b.isFailed();
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isResourceSet() {
        if (!this.f17474b.isResourceSet() && !this.f17475c.isResourceSet()) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        return this.f17474b.isRunning();
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestFailed(Request request) {
        RequestCoordinator requestCoordinator;
        if (request.equals(this.f17474b) && (requestCoordinator = this.f17473a) != null) {
            requestCoordinator.onRequestFailed(this);
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestSuccess(Request request) {
        if (request.equals(this.f17475c)) {
            return;
        }
        RequestCoordinator requestCoordinator = this.f17473a;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestSuccess(this);
        }
        if (!this.f17475c.isComplete()) {
            this.f17475c.clear();
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void recycle() {
        this.f17474b.recycle();
        this.f17475c.recycle();
    }

    public void setRequests(Request request, Request request2) {
        this.f17474b = request;
        this.f17475c = request2;
    }

    public ThumbnailRequestCoordinator(@Nullable RequestCoordinator requestCoordinator) {
        this.f17473a = requestCoordinator;
    }
}
