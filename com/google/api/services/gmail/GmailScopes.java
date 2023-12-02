package com.google.api.services.gmail;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes5.dex */
public class GmailScopes {
    public static final String GMAIL_COMPOSE = "https://www.googleapis.com/auth/gmail.compose";
    public static final String GMAIL_INSERT = "https://www.googleapis.com/auth/gmail.insert";
    public static final String GMAIL_LABELS = "https://www.googleapis.com/auth/gmail.labels";
    public static final String GMAIL_METADATA = "https://www.googleapis.com/auth/gmail.metadata";
    public static final String GMAIL_MODIFY = "https://www.googleapis.com/auth/gmail.modify";
    public static final String GMAIL_READONLY = "https://www.googleapis.com/auth/gmail.readonly";
    public static final String GMAIL_SEND = "https://www.googleapis.com/auth/gmail.send";
    public static final String GMAIL_SETTINGS_BASIC = "https://www.googleapis.com/auth/gmail.settings.basic";
    public static final String GMAIL_SETTINGS_SHARING = "https://www.googleapis.com/auth/gmail.settings.sharing";
    public static final String MAIL_GOOGLE_COM = "https://mail.google.com/";

    private GmailScopes() {
    }

    public static Set<String> all() {
        HashSet hashSet = new HashSet();
        hashSet.add(MAIL_GOOGLE_COM);
        hashSet.add(GMAIL_COMPOSE);
        hashSet.add(GMAIL_INSERT);
        hashSet.add(GMAIL_LABELS);
        hashSet.add(GMAIL_METADATA);
        hashSet.add(GMAIL_MODIFY);
        hashSet.add(GMAIL_READONLY);
        hashSet.add(GMAIL_SEND);
        hashSet.add(GMAIL_SETTINGS_BASIC);
        hashSet.add(GMAIL_SETTINGS_SHARING);
        return Collections.unmodifiableSet(hashSet);
    }
}
