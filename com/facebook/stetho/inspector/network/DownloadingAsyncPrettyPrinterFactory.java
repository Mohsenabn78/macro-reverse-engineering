package com.facebook.stetho.inspector.network;

import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.common.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public abstract class DownloadingAsyncPrettyPrinterFactory implements AsyncPrettyPrinterFactory {

    /* loaded from: classes3.dex */
    protected class MatchResult {
        private final PrettyPrinterDisplayType mDisplayType;
        private final String mSchemaUri;

        public MatchResult(String str, PrettyPrinterDisplayType prettyPrinterDisplayType) {
            this.mSchemaUri = str;
            this.mDisplayType = prettyPrinterDisplayType;
        }

        public PrettyPrinterDisplayType getDisplayType() {
            return this.mDisplayType;
        }

        public String getSchemaUri() {
            return this.mSchemaUri;
        }
    }

    /* loaded from: classes3.dex */
    private static class Request implements Callable<String> {
        private URL url;

        public Request(URL url) {
            this.url = url;
        }

        @Override // java.util.concurrent.Callable
        public String call() throws IOException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) this.url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    return Util.readAsUTF8(inputStream);
                } finally {
                    inputStream.close();
                }
            }
            throw new IOException("Got status code: " + responseCode + " while downloading schema with url: " + this.url.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doErrorPrint(PrintWriter printWriter, InputStream inputStream, String str) throws IOException {
        printWriter.print(str + "\n" + Util.readAsUTF8(inputStream));
    }

    private static AsyncPrettyPrinter getErrorAsyncPrettyPrinter(final String str, final String str2) {
        return new AsyncPrettyPrinter() { // from class: com.facebook.stetho.inspector.network.DownloadingAsyncPrettyPrinterFactory.2
            @Override // com.facebook.stetho.inspector.network.AsyncPrettyPrinter
            public PrettyPrinterDisplayType getPrettifiedType() {
                return PrettyPrinterDisplayType.TEXT;
            }

            @Override // com.facebook.stetho.inspector.network.AsyncPrettyPrinter
            public void printTo(PrintWriter printWriter, InputStream inputStream) throws IOException {
                DownloadingAsyncPrettyPrinterFactory.doErrorPrint(printWriter, inputStream, "[Failed to parse header: " + str + " : " + str2 + " ]");
            }
        };
    }

    @Nullable
    private static URL parseURL(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    protected abstract void doPrint(PrintWriter printWriter, InputStream inputStream, String str) throws IOException;

    @Override // com.facebook.stetho.inspector.network.AsyncPrettyPrinterFactory
    public AsyncPrettyPrinter getInstance(String str, String str2) {
        final MatchResult matchAndParseHeader = matchAndParseHeader(str, str2);
        if (matchAndParseHeader == null) {
            return null;
        }
        URL parseURL = parseURL(matchAndParseHeader.getSchemaUri());
        if (parseURL == null) {
            return getErrorAsyncPrettyPrinter(str, str2);
        }
        ExecutorService executorService = AsyncPrettyPrinterExecutorHolder.getExecutorService();
        if (executorService == null) {
            return null;
        }
        final Future submit = executorService.submit(new Request(parseURL));
        return new AsyncPrettyPrinter() { // from class: com.facebook.stetho.inspector.network.DownloadingAsyncPrettyPrinterFactory.1
            @Override // com.facebook.stetho.inspector.network.AsyncPrettyPrinter
            public PrettyPrinterDisplayType getPrettifiedType() {
                return matchAndParseHeader.getDisplayType();
            }

            @Override // com.facebook.stetho.inspector.network.AsyncPrettyPrinter
            public void printTo(PrintWriter printWriter, InputStream inputStream) throws IOException {
                try {
                    try {
                        try {
                            DownloadingAsyncPrettyPrinterFactory.this.doPrint(printWriter, inputStream, (String) submit.get());
                        } catch (ExecutionException e4) {
                            if (IOException.class.isInstance(e4.getCause())) {
                                DownloadingAsyncPrettyPrinterFactory.doErrorPrint(printWriter, inputStream, "Cannot successfully download schema: " + e4.getMessage());
                                return;
                            }
                            throw e4;
                        }
                    } catch (ExecutionException e5) {
                        throw ExceptionUtil.propagate(e5.getCause());
                    }
                } catch (InterruptedException e6) {
                    DownloadingAsyncPrettyPrinterFactory.doErrorPrint(printWriter, inputStream, "Encountered spurious interrupt while downloading schema for pretty printing: " + e6.getMessage());
                }
            }
        };
    }

    @Nullable
    protected abstract MatchResult matchAndParseHeader(String str, String str2);
}
