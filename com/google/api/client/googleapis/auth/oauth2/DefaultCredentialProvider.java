package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.Beta;
import com.sun.mail.imap.IMAPStore;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.security.AccessControlException;
import java.util.Locale;

@Beta
/* loaded from: classes5.dex */
class DefaultCredentialProvider extends SystemEnvironmentProvider {

    /* renamed from: b  reason: collision with root package name */
    private GoogleCredential f25557b = null;

    /* renamed from: c  reason: collision with root package name */
    private Environment f25558c = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.api.client.googleapis.auth.oauth2.DefaultCredentialProvider$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25559a;

        static {
            int[] iArr = new int[Environment.values().length];
            f25559a = iArr;
            try {
                iArr[Environment.ENVIRONMENT_VARIABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25559a[Environment.WELL_KNOWN_FILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25559a[Environment.APP_ENGINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25559a[Environment.CLOUD_SHELL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25559a[Environment.COMPUTE_ENGINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class ComputeGoogleCredential extends GoogleCredential {

        /* renamed from: u  reason: collision with root package name */
        private static final String f25560u = String.valueOf(OAuth2Utils.getMetadataServerUrl()).concat("/computeMetadata/v1/instance/service-accounts/default/token");

        ComputeGoogleCredential(HttpTransport httpTransport, JsonFactory jsonFactory) {
            super(new GoogleCredential.Builder().setTransport(httpTransport).setJsonFactory(jsonFactory).setTokenServerEncodedUrl(f25560u));
        }

        @Override // com.google.api.client.googleapis.auth.oauth2.GoogleCredential, com.google.api.client.auth.oauth2.Credential
        protected TokenResponse a() throws IOException {
            HttpRequest buildGetRequest = getTransport().createRequestFactory().buildGetRequest(new GenericUrl(getTokenServerEncodedUrl()));
            JsonObjectParser jsonObjectParser = new JsonObjectParser(getJsonFactory());
            buildGetRequest.setParser(jsonObjectParser);
            buildGetRequest.getHeaders().set("Metadata-Flavor", "Google");
            buildGetRequest.setThrowExceptionOnExecuteError(false);
            HttpResponse execute = buildGetRequest.execute();
            int statusCode = execute.getStatusCode();
            if (statusCode == 200) {
                InputStream content = execute.getContent();
                if (content != null) {
                    return (TokenResponse) jsonObjectParser.parseAndClose(content, execute.getContentCharset(), (Class<Object>) TokenResponse.class);
                }
                throw new IOException("Empty content from metadata token server request.");
            } else if (statusCode == 404) {
                throw new IOException(String.format("Error code %s trying to get security access token from Compute Engine metadata for the default service account. This may be because the virtual machine instance does not have permission scopes specified.", Integer.valueOf(statusCode)));
            } else {
                throw new IOException(String.format("Unexpected Error code %s trying to get security access token from Compute Engine metadata for the default service account: %s", Integer.valueOf(statusCode), execute.parseAsString()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public enum Environment {
        UNKNOWN,
        ENVIRONMENT_VARIABLE,
        WELL_KNOWN_FILE,
        CLOUD_SHELL,
        APP_ENGINE,
        COMPUTE_ENGINE
    }

    private final Environment b(HttpTransport httpTransport) throws IOException {
        if (p()) {
            return Environment.ENVIRONMENT_VARIABLE;
        }
        if (q()) {
            return Environment.WELL_KNOWN_FILE;
        }
        if (n()) {
            return Environment.APP_ENGINE;
        }
        if (o()) {
            return Environment.CLOUD_SHELL;
        }
        if (OAuth2Utils.d(httpTransport, this)) {
            return Environment.COMPUTE_ENGINE;
        }
        return Environment.UNKNOWN;
    }

    private final GoogleCredential e(HttpTransport httpTransport, JsonFactory jsonFactory) throws IOException {
        try {
            return (GoogleCredential) d("com.google.api.client.googleapis.extensions.appengine.auth.oauth2.AppIdentityCredential$AppEngineCredentialWrapper").getConstructor(HttpTransport.class, JsonFactory.class).newInstance(httpTransport, jsonFactory);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e4) {
            throw ((IOException) OAuth2Utils.a(new IOException(String.format("Application Default Credentials failed to create the Google App Engine service account credentials class %s. Check that the component 'google-api-client-appengine' is deployed.", "com.google.api.client.googleapis.extensions.appengine.auth.oauth2.AppIdentityCredential$AppEngineCredentialWrapper")), e4));
        }
    }

    private GoogleCredential f(JsonFactory jsonFactory) {
        return new CloudShellCredential(Integer.parseInt(a("DEVSHELL_CLIENT_PORT")), jsonFactory);
    }

    private final GoogleCredential g(HttpTransport httpTransport, JsonFactory jsonFactory) {
        return new ComputeGoogleCredential(httpTransport, jsonFactory);
    }

    private GoogleCredential h(HttpTransport httpTransport, JsonFactory jsonFactory) throws IOException {
        String a4 = a("GOOGLE_APPLICATION_CREDENTIALS");
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(a4);
                try {
                    GoogleCredential fromStream = GoogleCredential.fromStream(fileInputStream2, httpTransport, jsonFactory);
                    fileInputStream2.close();
                    return fromStream;
                } catch (IOException e4) {
                    e = e4;
                    throw ((IOException) OAuth2Utils.a(new IOException(String.format("Error reading credential file from environment variable %s, value '%s': %s", "GOOGLE_APPLICATION_CREDENTIALS", a4, e.getMessage())), e));
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private GoogleCredential i(HttpTransport httpTransport, JsonFactory jsonFactory) throws IOException {
        File m4 = m();
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(m4);
                try {
                    GoogleCredential fromStream = GoogleCredential.fromStream(fileInputStream2, httpTransport, jsonFactory);
                    fileInputStream2.close();
                    return fromStream;
                } catch (IOException e4) {
                    e = e4;
                    fileInputStream = fileInputStream2;
                    throw new IOException(String.format("Error reading credential file from location %s: %s", m4, e.getMessage()));
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            e = e5;
        }
    }

    private final GoogleCredential k(HttpTransport httpTransport, JsonFactory jsonFactory) throws IOException {
        if (this.f25558c == null) {
            this.f25558c = b(httpTransport);
        }
        int i4 = AnonymousClass1.f25559a[this.f25558c.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        if (i4 != 5) {
                            return null;
                        }
                        return g(httpTransport, jsonFactory);
                    }
                    return f(jsonFactory);
                }
                return e(httpTransport, jsonFactory);
            }
            return i(httpTransport, jsonFactory);
        }
        return h(httpTransport, jsonFactory);
    }

    private final File m() {
        File file;
        if (l("os.name", "").toLowerCase(Locale.US).indexOf("windows") >= 0) {
            file = new File(new File(a("APPDATA")), "gcloud");
        } else {
            file = new File(new File(l("user.home", ""), ".config"), "gcloud");
        }
        return new File(file, "application_default_credentials.json");
    }

    private boolean n() {
        try {
            try {
                Field field = d("com.google.appengine.api.utils.SystemProperty").getField(IMAPStore.ID_ENVIRONMENT);
                if (field.getType().getMethod("value", new Class[0]).invoke(field.get(null), new Object[0]) == null) {
                    return false;
                }
                return true;
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | NoSuchMethodException | SecurityException | InvocationTargetException e4) {
                throw ((RuntimeException) OAuth2Utils.a(new RuntimeException(String.format("Unexpcted error trying to determine if runnning on Google App Engine: %s", e4.getMessage())), e4));
            }
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private boolean o() {
        if (a("DEVSHELL_CLIENT_PORT") != null) {
            return true;
        }
        return false;
    }

    private boolean p() throws IOException {
        String a4 = a("GOOGLE_APPLICATION_CREDENTIALS");
        if (a4 != null && a4.length() != 0) {
            try {
                File file = new File(a4);
                if (file.exists() && !file.isDirectory()) {
                    return true;
                }
                throw new IOException(String.format("Error reading credential file from environment variable %s, value '%s': File does not exist.", "GOOGLE_APPLICATION_CREDENTIALS", a4));
            } catch (AccessControlException unused) {
            }
        }
        return false;
    }

    private boolean q() {
        try {
            return c(m());
        } catch (AccessControlException unused) {
            return false;
        }
    }

    boolean c(File file) {
        if (file.exists() && !file.isDirectory()) {
            return true;
        }
        return false;
    }

    Class<?> d(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final GoogleCredential j(HttpTransport httpTransport, JsonFactory jsonFactory) throws IOException {
        synchronized (this) {
            if (this.f25557b == null) {
                this.f25557b = k(httpTransport, jsonFactory);
            }
            GoogleCredential googleCredential = this.f25557b;
            if (googleCredential != null) {
                return googleCredential;
            }
            throw new IOException(String.format("The Application Default Credentials are not available. They are available if running on Google App Engine, Google Compute Engine, or Google Cloud Shell. Otherwise, the environment variable %s must be defined pointing to a file defining the credentials. See %s for more information.", "GOOGLE_APPLICATION_CREDENTIALS", "https://developers.google.com/accounts/docs/application-default-credentials"));
        }
    }

    String l(String str, String str2) {
        return System.getProperty(str, str2);
    }
}
