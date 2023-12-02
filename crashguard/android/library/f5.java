package crashguard.android.library;

/* loaded from: classes6.dex */
final class f5 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() throws RuntimeException {
        try {
            Class.forName("androidx.appcompat.app.AppCompatActivity", false, f5.class.getClassLoader());
        } catch (Throwable th) {
            throw new RuntimeException("Couldn't find AppCompat library dependency. Please include \"implementation 'androidx.appcompat:appcompat:1.6.1'\" in your project.", th);
        }
    }
}
