package com.google.api.client.googleapis.notifications;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Objects;
import com.google.api.client.util.Preconditions;

@Beta
/* loaded from: classes5.dex */
public abstract class AbstractNotification {

    /* renamed from: a  reason: collision with root package name */
    private long f25683a;

    /* renamed from: b  reason: collision with root package name */
    private String f25684b;

    /* renamed from: c  reason: collision with root package name */
    private String f25685c;

    /* renamed from: d  reason: collision with root package name */
    private String f25686d;

    /* renamed from: e  reason: collision with root package name */
    private String f25687e;

    /* renamed from: f  reason: collision with root package name */
    private String f25688f;

    /* renamed from: g  reason: collision with root package name */
    private String f25689g;

    /* renamed from: h  reason: collision with root package name */
    private String f25690h;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractNotification(long j4, String str, String str2, String str3, String str4) {
        setMessageNumber(j4);
        setResourceState(str);
        setResourceId(str2);
        setResourceUri(str3);
        setChannelId(str4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Objects.ToStringHelper a() {
        return Objects.toStringHelper(this).add("messageNumber", Long.valueOf(this.f25683a)).add("resourceState", this.f25684b).add("resourceId", this.f25685c).add("resourceUri", this.f25686d).add("channelId", this.f25687e).add("channelExpiration", this.f25688f).add("channelToken", this.f25689g).add("changed", this.f25690h);
    }

    public final String getChanged() {
        return this.f25690h;
    }

    public final String getChannelExpiration() {
        return this.f25688f;
    }

    public final String getChannelId() {
        return this.f25687e;
    }

    public final String getChannelToken() {
        return this.f25689g;
    }

    public final long getMessageNumber() {
        return this.f25683a;
    }

    public final String getResourceId() {
        return this.f25685c;
    }

    public final String getResourceState() {
        return this.f25684b;
    }

    public final String getResourceUri() {
        return this.f25686d;
    }

    public AbstractNotification setChanged(String str) {
        this.f25690h = str;
        return this;
    }

    public AbstractNotification setChannelExpiration(String str) {
        this.f25688f = str;
        return this;
    }

    public AbstractNotification setChannelId(String str) {
        this.f25687e = (String) Preconditions.checkNotNull(str);
        return this;
    }

    public AbstractNotification setChannelToken(String str) {
        this.f25689g = str;
        return this;
    }

    public AbstractNotification setMessageNumber(long j4) {
        boolean z3;
        if (j4 >= 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        this.f25683a = j4;
        return this;
    }

    public AbstractNotification setResourceId(String str) {
        this.f25685c = (String) Preconditions.checkNotNull(str);
        return this;
    }

    public AbstractNotification setResourceState(String str) {
        this.f25684b = (String) Preconditions.checkNotNull(str);
        return this;
    }

    public AbstractNotification setResourceUri(String str) {
        this.f25686d = (String) Preconditions.checkNotNull(str);
        return this;
    }

    public String toString() {
        return a().toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractNotification(AbstractNotification abstractNotification) {
        this(abstractNotification.getMessageNumber(), abstractNotification.getResourceState(), abstractNotification.getResourceId(), abstractNotification.getResourceUri(), abstractNotification.getChannelId());
        setChannelExpiration(abstractNotification.getChannelExpiration());
        setChannelToken(abstractNotification.getChannelToken());
        setChanged(abstractNotification.getChanged());
    }
}
