package com.google.api.client.googleapis.extensions.android.gms.auth;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.common.AccountPicker;
import com.google.api.client.googleapis.extensions.android.accounts.GoogleAccountManager;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.util.BackOff;
import com.google.api.client.util.BackOffUtils;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Joiner;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import java.io.IOException;
import java.util.Collection;

@Beta
/* loaded from: classes5.dex */
public class GoogleAccountCredential implements HttpRequestInitializer {

    /* renamed from: a  reason: collision with root package name */
    final Context f25635a;

    /* renamed from: b  reason: collision with root package name */
    final String f25636b;

    /* renamed from: c  reason: collision with root package name */
    private final GoogleAccountManager f25637c;

    /* renamed from: d  reason: collision with root package name */
    private String f25638d;

    /* renamed from: e  reason: collision with root package name */
    private Account f25639e;

    /* renamed from: f  reason: collision with root package name */
    private Sleeper f25640f = Sleeper.DEFAULT;

    /* renamed from: g  reason: collision with root package name */
    private BackOff f25641g;

    @Beta
    /* loaded from: classes5.dex */
    class RequestHandler implements HttpExecuteInterceptor, HttpUnsuccessfulResponseHandler {

        /* renamed from: a  reason: collision with root package name */
        boolean f25642a;

        /* renamed from: b  reason: collision with root package name */
        String f25643b;

        RequestHandler() {
        }

        @Override // com.google.api.client.http.HttpUnsuccessfulResponseHandler
        public boolean handleResponse(HttpRequest httpRequest, HttpResponse httpResponse, boolean z3) {
            if (httpResponse.getStatusCode() == 401 && !this.f25642a) {
                this.f25642a = true;
                GoogleAuthUtil.invalidateToken(GoogleAccountCredential.this.f25635a, this.f25643b);
                return true;
            }
            return false;
        }

        @Override // com.google.api.client.http.HttpExecuteInterceptor
        public void intercept(HttpRequest httpRequest) throws IOException {
            String str;
            try {
                this.f25643b = GoogleAccountCredential.this.getToken();
                HttpHeaders headers = httpRequest.getHeaders();
                String valueOf = String.valueOf(this.f25643b);
                if (valueOf.length() != 0) {
                    str = "Bearer ".concat(valueOf);
                } else {
                    str = new String("Bearer ");
                }
                headers.setAuthorization(str);
            } catch (GooglePlayServicesAvailabilityException e4) {
                throw new GooglePlayServicesAvailabilityIOException(e4);
            } catch (UserRecoverableAuthException e5) {
                throw new UserRecoverableAuthIOException(e5);
            } catch (GoogleAuthException e6) {
                throw new GoogleAuthIOException(e6);
            }
        }
    }

    public GoogleAccountCredential(Context context, String str) {
        this.f25637c = new GoogleAccountManager(context);
        this.f25635a = context;
        this.f25636b = str;
    }

    public static GoogleAccountCredential usingAudience(Context context, String str) {
        boolean z3;
        String str2;
        if (str.length() != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        if (str.length() != 0) {
            str2 = "audience:".concat(str);
        } else {
            str2 = new String("audience:");
        }
        return new GoogleAccountCredential(context, str2);
    }

    public static GoogleAccountCredential usingOAuth2(Context context, Collection<String> collection) {
        boolean z3;
        String str;
        if (collection != null && collection.iterator().hasNext()) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        String valueOf = String.valueOf(Joiner.on(' ').join(collection));
        if (valueOf.length() != 0) {
            str = "oauth2: ".concat(valueOf);
        } else {
            str = new String("oauth2: ");
        }
        return new GoogleAccountCredential(context, str);
    }

    public final Account[] getAllAccounts() {
        return this.f25637c.getAccounts();
    }

    public BackOff getBackOff() {
        return this.f25641g;
    }

    public final Context getContext() {
        return this.f25635a;
    }

    public final GoogleAccountManager getGoogleAccountManager() {
        return this.f25637c;
    }

    public final String getScope() {
        return this.f25636b;
    }

    public final Account getSelectedAccount() {
        return this.f25639e;
    }

    public final String getSelectedAccountName() {
        return this.f25638d;
    }

    public final Sleeper getSleeper() {
        return this.f25640f;
    }

    public String getToken() throws IOException, GoogleAuthException {
        BackOff backOff;
        BackOff backOff2 = this.f25641g;
        if (backOff2 != null) {
            backOff2.reset();
        }
        while (true) {
            try {
                return GoogleAuthUtil.getToken(this.f25635a, this.f25638d, this.f25636b);
            } catch (IOException e4) {
                try {
                    backOff = this.f25641g;
                } catch (InterruptedException unused) {
                }
                if (backOff == null || !BackOffUtils.next(this.f25640f, backOff)) {
                    throw e4;
                    break;
                }
            }
        }
    }

    @Override // com.google.api.client.http.HttpRequestInitializer
    public void initialize(HttpRequest httpRequest) {
        RequestHandler requestHandler = new RequestHandler();
        httpRequest.setInterceptor(requestHandler);
        httpRequest.setUnsuccessfulResponseHandler(requestHandler);
    }

    public final Intent newChooseAccountIntent() {
        return AccountPicker.newChooseAccountIntent(this.f25639e, null, new String[]{"com.google"}, true, null, null, null, null);
    }

    public GoogleAccountCredential setBackOff(BackOff backOff) {
        this.f25641g = backOff;
        return this;
    }

    public final GoogleAccountCredential setSelectedAccount(Account account) {
        String str;
        this.f25639e = account;
        if (account == null) {
            str = null;
        } else {
            str = account.name;
        }
        this.f25638d = str;
        return this;
    }

    public final GoogleAccountCredential setSelectedAccountName(String str) {
        Account accountByName = this.f25637c.getAccountByName(str);
        this.f25639e = accountByName;
        if (accountByName == null) {
            str = null;
        }
        this.f25638d = str;
        return this;
    }

    public final GoogleAccountCredential setSleeper(Sleeper sleeper) {
        this.f25640f = (Sleeper) Preconditions.checkNotNull(sleeper);
        return this;
    }
}
