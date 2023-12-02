package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import javax.mail.FetchProfile;

/* loaded from: classes6.dex */
public abstract class FetchItem {

    /* renamed from: a  reason: collision with root package name */
    private String f37840a;

    /* renamed from: b  reason: collision with root package name */
    private FetchProfile.Item f37841b;

    public FetchItem(String str, FetchProfile.Item item) {
        this.f37840a = str;
        this.f37841b = item;
    }

    public FetchProfile.Item getFetchProfileItem() {
        return this.f37841b;
    }

    public String getName() {
        return this.f37840a;
    }

    public abstract Object parseItem(FetchResponse fetchResponse) throws ParsingException;
}
