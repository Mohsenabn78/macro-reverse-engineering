package com.google.api.client.auth.oauth2;

import com.google.api.client.util.Beta;
import java.io.IOException;

@Beta
@Deprecated
/* loaded from: classes5.dex */
public interface CredentialStore {
    void delete(String str, Credential credential) throws IOException;

    boolean load(String str, Credential credential) throws IOException;

    void store(String str, Credential credential) throws IOException;
}
