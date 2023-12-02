package com.google.firebase.firestore.util;

import android.annotation.TargetApi;
import android.os.Build;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/* loaded from: classes5.dex */
public class FileUtil {

    @TargetApi(26)
    /* loaded from: classes5.dex */
    private static class DefaultFileDeleter {
        private DefaultFileDeleter() {
        }

        public static void a(File file) throws IOException {
            Path path;
            try {
                path = file.toPath();
                Files.deleteIfExists(path);
            } catch (IOException e4) {
                throw new IOException("Failed to delete file " + file + ": " + e4);
            }
        }
    }

    /* loaded from: classes5.dex */
    private static class LegacyFileDeleter {
        private LegacyFileDeleter() {
        }

        public static void a(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("Failed to delete file " + file);
            }
        }
    }

    public static void delete(File file) throws IOException {
        if (Build.VERSION.SDK_INT >= 26) {
            DefaultFileDeleter.a(file);
        } else {
            LegacyFileDeleter.a(file);
        }
    }
}
