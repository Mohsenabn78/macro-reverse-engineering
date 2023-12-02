package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.json.JsonFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes5.dex */
public class CloudShellCredential extends GoogleCredential {

    /* renamed from: u  reason: collision with root package name */
    private final int f25555u;

    /* renamed from: v  reason: collision with root package name */
    private final JsonFactory f25556v;

    public CloudShellCredential(int i4, JsonFactory jsonFactory) {
        this.f25555u = i4;
        this.f25556v = jsonFactory;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.api.client.googleapis.auth.oauth2.GoogleCredential, com.google.api.client.auth.oauth2.Credential
    public TokenResponse a() throws IOException {
        Socket socket = new Socket("localhost", e());
        socket.setSoTimeout(5000);
        TokenResponse tokenResponse = new TokenResponse();
        try {
            new PrintWriter(socket.getOutputStream(), true).println("2\n[]");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedReader.readLine();
            tokenResponse.setAccessToken(((List) this.f25556v.createJsonParser(bufferedReader).parseArray(LinkedList.class, Object.class)).get(2).toString());
            return tokenResponse;
        } finally {
            socket.close();
        }
    }

    protected int e() {
        return this.f25555u;
    }
}
