package com.google.api.client.googleapis.notifications;

import com.google.api.client.util.Beta;
import com.google.firebase.analytics.FirebaseAnalytics;

@Beta
/* loaded from: classes5.dex */
public class TypedNotification<T> extends AbstractNotification {

    /* renamed from: i  reason: collision with root package name */
    private T f25691i;

    public TypedNotification(long j4, String str, String str2, String str3, String str4) {
        super(j4, str, str2, str3, str4);
    }

    public final T getContent() {
        return this.f25691i;
    }

    public TypedNotification<T> setContent(T t3) {
        this.f25691i = t3;
        return this;
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public String toString() {
        return super.a().add(FirebaseAnalytics.Param.CONTENT, this.f25691i).toString();
    }

    public TypedNotification(UnparsedNotification unparsedNotification) {
        super(unparsedNotification);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public TypedNotification<T> setChanged(String str) {
        return (TypedNotification) super.setChanged(str);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public TypedNotification<T> setChannelExpiration(String str) {
        return (TypedNotification) super.setChannelExpiration(str);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public TypedNotification<T> setChannelId(String str) {
        return (TypedNotification) super.setChannelId(str);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public TypedNotification<T> setChannelToken(String str) {
        return (TypedNotification) super.setChannelToken(str);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public TypedNotification<T> setMessageNumber(long j4) {
        return (TypedNotification) super.setMessageNumber(j4);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public TypedNotification<T> setResourceId(String str) {
        return (TypedNotification) super.setResourceId(str);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public TypedNotification<T> setResourceState(String str) {
        return (TypedNotification) super.setResourceState(str);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public TypedNotification<T> setResourceUri(String str) {
        return (TypedNotification) super.setResourceUri(str);
    }
}
