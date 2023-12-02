package com.google.api.services.gmail;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.googleapis.services.json.CommonGoogleJsonClientRequestInitializer;
import java.io.IOException;

/* loaded from: classes5.dex */
public class GmailRequestInitializer extends CommonGoogleJsonClientRequestInitializer {
    public GmailRequestInitializer() {
    }

    @Override // com.google.api.client.googleapis.services.json.CommonGoogleJsonClientRequestInitializer
    public final void initializeJsonRequest(AbstractGoogleJsonClientRequest<?> abstractGoogleJsonClientRequest) throws IOException {
        super.initializeJsonRequest(abstractGoogleJsonClientRequest);
        a((GmailRequest) abstractGoogleJsonClientRequest);
    }

    public GmailRequestInitializer(String str) {
        super(str);
    }

    public GmailRequestInitializer(String str, String str2) {
        super(str, str2);
    }

    protected void a(GmailRequest<?> gmailRequest) throws IOException {
    }
}
