package com.google.api.client.googleapis.notifications;

import com.google.api.client.util.Beta;
import java.io.InputStream;

@Beta
/* loaded from: classes5.dex */
public class UnparsedNotification extends AbstractNotification {

    /* renamed from: i  reason: collision with root package name */
    private String f25692i;

    /* renamed from: j  reason: collision with root package name */
    private InputStream f25693j;

    public UnparsedNotification(long j4, String str, String str2, String str3, String str4) {
        super(j4, str, str2, str3, str4);
    }

    public final InputStream getContentStream() {
        return this.f25693j;
    }

    public final String getContentType() {
        return this.f25692i;
    }

    public UnparsedNotification setContentStream(InputStream inputStream) {
        this.f25693j = inputStream;
        return this;
    }

    public UnparsedNotification setContentType(String str) {
        this.f25692i = str;
        return this;
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public String toString() {
        return super.a().add("contentType", this.f25692i).toString();
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public UnparsedNotification setChanged(String str) {
        return (UnparsedNotification) super.setChanged(str);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public UnparsedNotification setChannelExpiration(String str) {
        return (UnparsedNotification) super.setChannelExpiration(str);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public UnparsedNotification setChannelId(String str) {
        return (UnparsedNotification) super.setChannelId(str);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public UnparsedNotification setChannelToken(String str) {
        return (UnparsedNotification) super.setChannelToken(str);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public UnparsedNotification setMessageNumber(long j4) {
        return (UnparsedNotification) super.setMessageNumber(j4);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public UnparsedNotification setResourceId(String str) {
        return (UnparsedNotification) super.setResourceId(str);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public UnparsedNotification setResourceState(String str) {
        return (UnparsedNotification) super.setResourceState(str);
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public UnparsedNotification setResourceUri(String str) {
        return (UnparsedNotification) super.setResourceUri(str);
    }
}
