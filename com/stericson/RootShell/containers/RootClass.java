package com.stericson.RootShell.containers;

import androidx.exifinterface.media.ExifInterface;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class RootClass {

    /* loaded from: classes6.dex */
    public static class AnnotationsFinder {

        /* renamed from: a  reason: collision with root package name */
        private final String f37431a;

        /* renamed from: b  reason: collision with root package name */
        private List<File> f37432b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public class a implements FileFilter {
            a() {
            }

            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public class b implements FilenameFilter {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f37434a;

            b(String str) {
                this.f37434a = str;
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.startsWith(this.f37434a);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public class c implements FileFilter {
            c() {
            }

            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file.isDirectory();
            }
        }

        public AnnotationsFinder() throws IOException {
            String str;
            boolean z3;
            boolean z4;
            String str2;
            String[] strArr;
            StringBuilder sb = new StringBuilder();
            sb.append("stericson");
            String str3 = File.separator;
            sb.append(str3);
            sb.append("RootShell");
            sb.append(str3);
            this.f37431a = sb.toString();
            System.out.println("Discovering root class annotations...");
            this.f37432b = new ArrayList();
            d(new File("src"), this.f37432b);
            System.out.println("Done discovering annotations. Building jar file.");
            File a4 = a();
            if (a4 == null) {
                str = "raw";
            } else {
                String str4 = "com" + str3 + "stericson" + str3 + "RootShell" + str3 + "containers" + str3 + "RootClass.class";
                String str5 = "com" + str3 + "stericson" + str3 + "RootShell" + str3 + "containers" + str3 + "RootClass$RootArgs.class";
                String str6 = "com" + str3 + "stericson" + str3 + "RootShell" + str3 + "containers" + str3 + "RootClass$AnnotationsFinder.class";
                String str7 = "com" + str3 + "stericson" + str3 + "RootShell" + str3 + "containers" + str3 + "RootClass$AnnotationsFinder$1.class";
                String str8 = "com" + str3 + "stericson" + str3 + "RootShell" + str3 + "containers" + str3 + "RootClass$AnnotationsFinder$2.class";
                if (-1 != System.getProperty("os.name").toLowerCase().indexOf("win")) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    z4 = z3;
                    StringBuilder sb2 = new StringBuilder();
                    str2 = "raw";
                    sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    sb2.append(str4);
                    sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    sb2.append(str5);
                    sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    sb2.append(str6);
                    sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    sb2.append(str7);
                    sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    sb2.append(str8);
                    StringBuilder sb3 = new StringBuilder(sb2.toString());
                    for (File file : this.f37432b) {
                        sb3.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                        sb3.append(file.getPath());
                    }
                    strArr = new String[]{"cmd", "/C", "jar cvf anbuild.jar" + sb3.toString()};
                } else {
                    z4 = z3;
                    str2 = "raw";
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("jar");
                    arrayList.add("cf");
                    arrayList.add("anbuild.jar");
                    arrayList.add(str4);
                    arrayList.add(str5);
                    arrayList.add(str6);
                    arrayList.add(str7);
                    arrayList.add(str8);
                    for (File file2 : this.f37432b) {
                        arrayList.add(file2.getPath());
                    }
                    strArr = (String[]) arrayList.toArray(new String[0]);
                }
                ProcessBuilder processBuilder = new ProcessBuilder(strArr);
                processBuilder.directory(a4);
                try {
                    processBuilder.start().waitFor();
                } catch (IOException | InterruptedException unused) {
                }
                String str9 = File.separator;
                a4.toString().startsWith("build");
                StringBuilder sb4 = new StringBuilder();
                sb4.append("src");
                sb4.append(str9);
                sb4.append("main");
                sb4.append(str9);
                sb4.append("res");
                sb4.append(str9);
                str = str2;
                sb4.append(str);
                String sb5 = sb4.toString();
                File file3 = new File(sb5);
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                System.out.println("Done building jar file. Creating dex file.");
                try {
                    new ProcessBuilder(z4 ? new String[]{"cmd", "/C", "dx --dex --output=" + sb5 + str9 + "anbuild.dex " + a4 + str9 + "anbuild.jar"} : new String[]{b(), "--dex", "--output=" + sb5 + str9 + "anbuild.dex", a4 + str9 + "anbuild.jar"}).start().waitFor();
                } catch (IOException | InterruptedException unused2) {
                }
            }
            PrintStream printStream = System.out;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("All done. ::: anbuild.dex should now be in your project's src");
            String str10 = File.separator;
            sb6.append(str10);
            sb6.append("main");
            sb6.append(str10);
            sb6.append("res");
            sb6.append(str10);
            sb6.append(str);
            sb6.append(str10);
            sb6.append(" folder :::");
            printStream.println(sb6.toString());
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0079  */
        /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        protected java.io.File a() {
            /*
                r6 = this;
                java.io.File r0 = new java.io.File
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "out"
                r1.append(r2)
                java.lang.String r2 = java.io.File.separator
                r1.append(r2)
                java.lang.String r3 = "production"
                r1.append(r3)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                boolean r1 = r0.isDirectory()
                if (r1 == 0) goto L52
                com.stericson.RootShell.containers.RootClass$AnnotationsFinder$c r1 = new com.stericson.RootShell.containers.RootClass$AnnotationsFinder$c
                r1.<init>()
                java.io.File[] r1 = r0.listFiles(r1)
                int r3 = r1.length
                if (r3 <= 0) goto L52
                java.io.File r3 = new java.io.File
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r0 = r0.getAbsolutePath()
                r4.append(r0)
                r4.append(r2)
                r0 = 0
                r0 = r1[r0]
                java.lang.String r0 = r0.getName()
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r3.<init>(r0)
                goto L53
            L52:
                r3 = 0
            L53:
                java.lang.String r0 = "classes"
                if (r3 != 0) goto L77
                java.io.File r1 = new java.io.File
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "bin"
                r4.append(r5)
                r4.append(r2)
                r4.append(r0)
                java.lang.String r4 = r4.toString()
                r1.<init>(r4)
                boolean r4 = r1.isDirectory()
                if (r4 == 0) goto L77
                r3 = r1
            L77:
                if (r3 != 0) goto La9
                java.io.File r1 = new java.io.File
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "build"
                r4.append(r5)
                r4.append(r2)
                java.lang.String r5 = "intermediates"
                r4.append(r5)
                r4.append(r2)
                r4.append(r0)
                r4.append(r2)
                java.lang.String r0 = "debug"
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r1.<init>(r0)
                boolean r0 = r1.isDirectory()
                if (r0 == 0) goto La9
                r3 = r1
            La9:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stericson.RootShell.containers.RootClass.AnnotationsFinder.a():java.io.File");
        }

        protected String b() throws IOException {
            File[] listFiles;
            String name;
            String str = System.getenv("ANDROID_HOME");
            if (str != null) {
                String str2 = null;
                int i4 = 0;
                for (File file : new File(str + File.separator + "build-tools").listFiles()) {
                    if (file.getName().contains("-")) {
                        String[] split = file.getName().split("-");
                        if (split[1].contains(ExifInterface.LONGITUDE_WEST)) {
                            name = String.valueOf(split[1].toCharArray()[0]);
                        } else if (!split[1].contains("rc")) {
                            name = split[1];
                        }
                    } else {
                        name = file.getName();
                    }
                    String[] split2 = name.split("[.]");
                    int parseInt = Integer.parseInt(split2[0]) * 10000;
                    if (split2.length > 1) {
                        parseInt += Integer.parseInt(split2[1]) * 100;
                        if (split2.length > 2) {
                            parseInt += Integer.parseInt(split2[2]);
                        }
                    }
                    if (parseInt > i4) {
                        String str3 = file.getAbsolutePath() + File.separator + "dx";
                        if (new File(str3).exists()) {
                            str2 = str3;
                            i4 = parseInt;
                        }
                    }
                }
                if (str2 != null) {
                    return str2;
                }
                throw new IOException("Error: unable to find dx binary in $ANDROID_HOME");
            }
            throw new IOException("Error: you need to set $ANDROID_HOME globally");
        }

        protected boolean c(File file) {
            b bVar = b.STARTING;
            Pattern compile = Pattern.compile(" class ([A-Za-z0-9_]+)");
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    int i4 = a.f37438a[bVar.ordinal()];
                    if (i4 != 1) {
                        if (i4 == 2) {
                            Matcher matcher = compile.matcher(readLine);
                            if (matcher.find()) {
                                PrintStream printStream = System.out;
                                printStream.println(" Found annotated class: " + matcher.group(0));
                                return true;
                            }
                            PrintStream printStream2 = System.err;
                            printStream2.println("Error: unmatched annotation in " + file.getAbsolutePath());
                            bVar = b.STARTING;
                        }
                    } else if (-1 < readLine.indexOf("@RootClass.Candidate")) {
                        bVar = b.FOUND_ANNOTATION;
                    }
                }
            } catch (FileNotFoundException e4) {
                e4.printStackTrace();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            return false;
        }

        protected void d(File file, List<File> list) {
            File[] listFiles;
            File[] listFiles2;
            String file2 = file.toString();
            StringBuilder sb = new StringBuilder();
            sb.append("src");
            String str = File.separator;
            sb.append(str);
            String replace = file2.replace(sb.toString(), "").replace("main" + str + "java" + str, "");
            for (File file3 : file.listFiles(new a())) {
                if (file3.isDirectory()) {
                    if (-1 == file3.getAbsolutePath().indexOf(this.f37431a)) {
                        d(file3, list);
                    }
                } else if (file3.getName().endsWith(".java") && c(file3)) {
                    for (File file4 : new File(a().toString() + File.separator + replace).listFiles(new b(file3.getName().replace(".java", "")))) {
                        list.add(new File(replace + File.separator + file4.getName()));
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public @interface Candidate {
    }

    /* loaded from: classes6.dex */
    public class RootArgs {
        public String[] args;

        public RootArgs() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f37438a;

        static {
            int[] iArr = new int[b.values().length];
            f37438a = iArr;
            try {
                iArr[b.STARTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37438a[b.FOUND_ANNOTATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public enum b {
        STARTING,
        FOUND_ANNOTATION
    }

    public RootClass(String[] strArr) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String str = strArr[0];
        RootArgs rootArgs = new RootArgs();
        String[] strArr2 = new String[strArr.length - 1];
        rootArgs.args = strArr2;
        System.arraycopy(strArr, 1, strArr2, 0, strArr.length - 1);
        Class.forName(str).getConstructor(RootArgs.class).newInstance(rootArgs);
    }

    static void a(Exception exc) {
        PrintStream printStream = System.out;
        printStream.println("##ERR##" + exc.getMessage() + "##");
        exc.printStackTrace();
    }

    public static void main(String[] strArr) {
        try {
            if (strArr.length == 0) {
                new AnnotationsFinder();
            } else {
                new RootClass(strArr);
            }
        } catch (Exception e4) {
            a(e4);
        }
    }
}
