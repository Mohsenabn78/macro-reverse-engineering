package com.koushikdutta.ion;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.parser.AsyncParser;
import com.koushikdutta.async.parser.DocumentParser;
import com.koushikdutta.async.parser.StringParser;
import com.koushikdutta.async.stream.FileDataSink;
import com.koushikdutta.async.util.FileCache;
import com.koushikdutta.ion.gson.GsonArrayParser;
import com.koushikdutta.ion.gson.GsonObjectParser;
import com.koushikdutta.ion.gson.GsonSerializer;
import java.io.File;
import org.w3c.dom.Document;

/* loaded from: classes6.dex */
public class FileCacheStore {

    /* renamed from: a  reason: collision with root package name */
    Ion f35698a;

    /* renamed from: b  reason: collision with root package name */
    FileCache f35699b;

    /* renamed from: c  reason: collision with root package name */
    String f35700c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AsyncParser f35701a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f35702b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SimpleFuture f35703c;

        /* renamed from: com.koushikdutta.ion.FileCacheStore$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class C0202a implements CompletedCallback {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ FileDataSink f35705a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ File f35706b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f35707c;

            C0202a(FileDataSink fileDataSink, File file, String str) {
                this.f35705a = fileDataSink;
                this.f35706b = file;
                this.f35707c = str;
            }

            @Override // com.koushikdutta.async.callback.CompletedCallback
            public void onCompleted(Exception exc) {
                this.f35705a.end();
                if (exc != null) {
                    this.f35706b.delete();
                    a.this.f35703c.setComplete(exc);
                    return;
                }
                FileCacheStore.this.f35699b.commitTempFiles(this.f35707c, this.f35706b);
                a aVar = a.this;
                aVar.f35703c.setComplete((SimpleFuture) aVar.f35702b);
            }
        }

        a(AsyncParser asyncParser, Object obj, SimpleFuture simpleFuture) {
            this.f35701a = asyncParser;
            this.f35702b = obj;
            this.f35703c = simpleFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            String c4 = FileCacheStore.this.c();
            File tempFile = FileCacheStore.this.f35699b.getTempFile();
            FileDataSink fileDataSink = new FileDataSink(FileCacheStore.this.f35698a.getServer(), tempFile);
            this.f35701a.write(fileDataSink, this.f35702b, new C0202a(fileDataSink, tempFile, c4));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SimpleFuture f35709a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AsyncParser f35710b;

        b(SimpleFuture simpleFuture, AsyncParser asyncParser) {
            this.f35709a = simpleFuture;
            this.f35710b = asyncParser;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                File file = FileCacheStore.this.f35699b.getFile(FileCacheStore.this.c());
                if (!file.exists()) {
                    this.f35709a.setComplete((SimpleFuture) null);
                    return;
                }
                Ion ion = FileCacheStore.this.f35698a;
                ion.build(ion.getContext()).load(file).as(this.f35710b).setCallback(this.f35709a.getCompletionCallback());
            } catch (Exception e4) {
                this.f35709a.setComplete(e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileCacheStore(Ion ion, FileCache fileCache, String str) {
        this.f35698a = ion;
        this.f35699b = fileCache;
        this.f35700c = str;
    }

    private <T> Future<T> b(AsyncParser<T> asyncParser) {
        SimpleFuture simpleFuture = new SimpleFuture();
        Ion.getIoExecutorService().execute(new b(simpleFuture, asyncParser));
        return simpleFuture;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        return this.f35700c.replace(":", "_");
    }

    private <T> T d(AsyncParser<T> asyncParser) {
        try {
            File file = this.f35699b.getFile(c());
            Ion ion = this.f35698a;
            return ion.build(ion.getContext()).load(file).as(asyncParser).get();
        } catch (Exception unused) {
            return null;
        }
    }

    private <T> Future<T> e(T t3, AsyncParser<T> asyncParser) {
        SimpleFuture simpleFuture = new SimpleFuture();
        Ion.getIoExecutorService().execute(new a(asyncParser, t3, simpleFuture));
        return simpleFuture;
    }

    public <T> Future<T> as(Class<T> cls) {
        return b(new GsonSerializer(this.f35698a.configure().getGson(), cls));
    }

    public Future<Document> asDocument() {
        return b(new DocumentParser());
    }

    public Future<JsonArray> asJsonArray() {
        return b(new GsonArrayParser());
    }

    public Future<JsonObject> asJsonObject() {
        return b(new GsonObjectParser());
    }

    public Future<String> asString() {
        return b(new StringParser());
    }

    public <T> T get(Class<T> cls) {
        return (T) d(new GsonSerializer(this.f35698a.configure().getGson(), cls));
    }

    public Document getDocument() {
        return (Document) d(new DocumentParser());
    }

    public JsonArray getJsonArray() {
        return (JsonArray) d(new GsonArrayParser());
    }

    public JsonObject getJsonObject() {
        return (JsonObject) d(new GsonObjectParser());
    }

    public String getString() {
        return (String) d(new StringParser());
    }

    public <T> Future<T> put(T t3, Class<T> cls) {
        return e(t3, new GsonSerializer(this.f35698a.configure().getGson(), cls));
    }

    public Future<Document> putDocument(Document document) {
        return e(document, new DocumentParser());
    }

    public Future<JsonArray> putJsonArray(JsonArray jsonArray) {
        return e(jsonArray, new GsonArrayParser());
    }

    public Future<JsonObject> putJsonObject(JsonObject jsonObject) {
        return e(jsonObject, new GsonObjectParser());
    }

    public Future<String> putString(String str) {
        return e(str, new StringParser());
    }

    public void remove() {
        this.f35699b.remove(c());
    }

    public <T> Future<T> as(TypeToken<T> typeToken) {
        return b(new GsonSerializer(this.f35698a.configure().getGson(), typeToken));
    }

    public <T> T get(TypeToken<T> typeToken) {
        return (T) d(new GsonSerializer(this.f35698a.configure().getGson(), typeToken));
    }

    public <T> Future<T> put(T t3, TypeToken<T> typeToken) {
        return e(t3, new GsonSerializer(this.f35698a.configure().getGson(), typeToken));
    }
}
