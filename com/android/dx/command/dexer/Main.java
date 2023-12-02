package com.android.dx.command.dexer;

import com.android.dex.Dex;
import com.android.dex.DexException;
import com.android.dex.DexFormat;
import com.android.dex.util.FileUtils;
import com.android.dx.cf.code.SimException;
import com.android.dx.cf.direct.ClassPathOpener;
import com.android.dx.cf.direct.DirectClassFile;
import com.android.dx.cf.direct.StdAttributeFactory;
import com.android.dx.cf.iface.ParseException;
import com.android.dx.command.DxConsole;
import com.android.dx.command.UsageException;
import com.android.dx.dex.DexOptions;
import com.android.dx.dex.cf.CfOptions;
import com.android.dx.dex.cf.CfTranslator;
import com.android.dx.dex.cf.CodeStatistics;
import com.android.dx.dex.file.ClassDefItem;
import com.android.dx.dex.file.DexFile;
import com.android.dx.dex.file.EncodedMethod;
import com.android.dx.merge.CollisionPolicy;
import com.android.dx.merge.DexMerger;
import com.android.dx.rop.annotation.Annotation;
import com.android.dx.rop.annotation.Annotations;
import com.android.dx.rop.annotation.AnnotationsList;
import com.android.dx.rop.cst.CstString;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import net.bytebuddy.dynamic.ClassFileLocator;
import org.apache.commons.cli.HelpFormatter;

/* loaded from: classes2.dex */
public class Main {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String DEX_EXTENSION = ".dex";
    private static final String DEX_PREFIX = "classes";
    private static final String IN_RE_CORE_CLASSES = "Ill-advised or mistaken usage of a core class (java.* or javax.*)\nwhen not building a core library.\n\nThis is often due to inadvertently including a core library file\nin your application's project, when using an IDE (such as\nEclipse). If you are sure you're not intentionally defining a\ncore class, then this is the most likely explanation of what's\ngoing on.\n\nHowever, you might actually be trying to define a class in a core\nnamespace, the source of which you may have taken, for example,\nfrom a non-Android virtual machine project. This will most\nassuredly not work. At a minimum, it jeopardizes the\ncompatibility of your app with future versions of the platform.\nIt is also often of questionable legality.\n\nIf you really intend to build a core library -- which is only\nappropriate as part of creating a full virtual machine\ndistribution, as opposed to compiling an application -- then use\nthe \"--core-library\" option to suppress this error message.\n\nIf you go ahead and use \"--core-library\" but are in fact\nbuilding an application, then be forewarned that your application\nwill still fail to build or run, at some point. Please be\nprepared for angry customers who find, for example, that your\napplication ceases to function once they upgrade their operating\nsystem. You will be to blame for this problem.\n\nIf you are legitimately using some code that happens to be in a\ncore package, then the easiest safe alternative you have is to\nrepackage that code. That is, move the classes in question into\nyour own package namespace. This means that they will never be in\nconflict with core system classes. JarJar is a tool that may help\nyou in this endeavor. If you find that you cannot do this, then\nthat is an indication that the path you are on will ultimately\nlead to pain, suffering, grief, and lamentation.\n";
    private static final String MANIFEST_NAME = "META-INF/MANIFEST.MF";
    private static final int MAX_FIELD_ADDED_DURING_DEX_CREATION = 9;
    private static final int MAX_METHOD_ADDED_DURING_DEX_CREATION = 2;
    private static volatile boolean anyFilesProcessed;
    private static Arguments args;
    private static ExecutorService classDefItemConsumer;
    private static ExecutorService classTranslatorPool;
    private static ExecutorService dexOutPool;
    private static DexFile outputDex;
    private static TreeMap<String, byte[]> outputResources;
    private static final Attributes.Name CREATED_BY = new Attributes.Name("Created-By");
    private static final String[] JAVAX_CORE = {"accessibility", "crypto", "imageio", "management", "naming", "net", "print", "rmi", "security", "sip", "sound", "sql", "swing", "transaction", "xml"};
    private static AtomicInteger errors = new AtomicInteger(0);
    private static final List<byte[]> libraryDexBuffers = new ArrayList();
    private static List<Future<Boolean>> addToDexFutures = new ArrayList();
    private static List<Future<byte[]>> dexOutputFutures = new ArrayList();
    private static Object dexRotationLock = new Object();
    private static int maxMethodIdsInProcess = 0;
    private static int maxFieldIdsInProcess = 0;
    private static long minimumFileAge = 0;
    private static Set<String> classesInMainDex = null;
    private static List<byte[]> dexOutputArrays = new ArrayList();
    private static OutputStreamWriter humanOutWriter = null;

    /* loaded from: classes2.dex */
    public static class Arguments {
        private static final String INCREMENTAL_OPTION = "--incremental";
        private static final String INPUT_LIST_OPTION = "--input-list";
        private static final String MAIN_DEX_LIST_OPTION = "--main-dex-list";
        private static final String MINIMAL_MAIN_DEX_OPTION = "--minimal-main-dex";
        private static final String MULTI_DEX_OPTION = "--multi-dex";
        private static final String NUM_THREADS_OPTION = "--num-threads";
        public CfOptions cfOptions;
        public DexOptions dexOptions;
        public String[] fileNames;
        public boolean statistics;
        public boolean debug = false;
        public boolean warnings = true;
        public boolean verbose = false;
        public boolean verboseDump = false;
        public boolean coreLibrary = false;
        public String methodToDump = null;
        public int dumpWidth = 0;
        public String outName = null;
        public String humanOutName = null;
        public boolean strictNameCheck = true;
        public boolean emptyOk = false;
        public boolean jarOutput = false;
        public boolean keepClassesInJar = false;
        public int positionInfo = 2;
        public boolean localInfo = true;
        public boolean incremental = false;
        public boolean forceJumbo = false;
        public boolean optimize = true;
        public String optimizeListFile = null;
        public String dontOptimizeListFile = null;
        public int numThreads = 1;
        public boolean multiDex = false;
        public String mainDexListFile = null;
        public boolean minimalMainDex = false;
        private List<String> inputList = null;
        private int maxNumberOfIdxPerDex = 65536;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class ArgumentsParser {
            private final String[] arguments;
            private String current;
            private int index = 0;
            private String lastValue;

            public ArgumentsParser(String[] strArr) {
                this.arguments = strArr;
            }

            private boolean getNextValue() {
                int i4 = this.index;
                String[] strArr = this.arguments;
                if (i4 >= strArr.length) {
                    return false;
                }
                this.current = strArr[i4];
                this.index = i4 + 1;
                return true;
            }

            public String getCurrent() {
                return this.current;
            }

            public String getLastValue() {
                return this.lastValue;
            }

            public boolean getNext() {
                int i4 = this.index;
                String[] strArr = this.arguments;
                if (i4 >= strArr.length) {
                    return false;
                }
                String str = strArr[i4];
                this.current = str;
                if (str.equals(HelpFormatter.DEFAULT_LONG_OPT_PREFIX) || !this.current.startsWith(HelpFormatter.DEFAULT_LONG_OPT_PREFIX)) {
                    return false;
                }
                this.index++;
                return true;
            }

            public String[] getRemaining() {
                String[] strArr = this.arguments;
                int length = strArr.length;
                int i4 = this.index;
                int i5 = length - i4;
                String[] strArr2 = new String[i5];
                if (i5 > 0) {
                    System.arraycopy(strArr, i4, strArr2, 0, i5);
                }
                return strArr2;
            }

            public boolean isArg(String str) {
                int length = str.length();
                if (length > 0) {
                    int i4 = length - 1;
                    if (str.charAt(i4) == '=') {
                        if (this.current.startsWith(str)) {
                            this.lastValue = this.current.substring(length);
                            return true;
                        }
                        String substring = str.substring(0, i4);
                        if (!this.current.equals(substring)) {
                            return false;
                        }
                        if (getNextValue()) {
                            this.lastValue = this.current;
                            return true;
                        }
                        System.err.println("Missing value after parameter " + substring);
                        throw new UsageException();
                    }
                }
                return this.current.equals(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void makeOptionsObjects() {
            CfOptions cfOptions = new CfOptions();
            this.cfOptions = cfOptions;
            cfOptions.positionInfo = this.positionInfo;
            cfOptions.localInfo = this.localInfo;
            cfOptions.strictNameCheck = this.strictNameCheck;
            cfOptions.optimize = this.optimize;
            cfOptions.optimizeListFile = this.optimizeListFile;
            cfOptions.dontOptimizeListFile = this.dontOptimizeListFile;
            cfOptions.statistics = this.statistics;
            if (this.warnings) {
                cfOptions.warn = DxConsole.err;
            } else {
                cfOptions.warn = DxConsole.noop;
            }
            DexOptions dexOptions = new DexOptions();
            this.dexOptions = dexOptions;
            dexOptions.forceJumbo = this.forceJumbo;
        }

        public void parse(String[] strArr) {
            ArgumentsParser argumentsParser = new ArgumentsParser(strArr);
            boolean z3 = false;
            boolean z4 = false;
            while (argumentsParser.getNext()) {
                if (argumentsParser.isArg("--debug")) {
                    this.debug = true;
                } else if (argumentsParser.isArg("--no-warning")) {
                    this.warnings = false;
                } else if (argumentsParser.isArg("--verbose")) {
                    this.verbose = true;
                } else if (argumentsParser.isArg("--verbose-dump")) {
                    this.verboseDump = true;
                } else if (argumentsParser.isArg("--no-files")) {
                    this.emptyOk = true;
                } else if (argumentsParser.isArg("--no-optimize")) {
                    this.optimize = false;
                } else if (argumentsParser.isArg("--no-strict")) {
                    this.strictNameCheck = false;
                } else if (argumentsParser.isArg("--core-library")) {
                    this.coreLibrary = true;
                } else if (argumentsParser.isArg("--statistics")) {
                    this.statistics = true;
                } else if (argumentsParser.isArg("--optimize-list=")) {
                    if (this.dontOptimizeListFile == null) {
                        this.optimize = true;
                        this.optimizeListFile = argumentsParser.getLastValue();
                    } else {
                        System.err.println("--optimize-list and --no-optimize-list are incompatible.");
                        throw new UsageException();
                    }
                } else if (argumentsParser.isArg("--no-optimize-list=")) {
                    if (this.dontOptimizeListFile == null) {
                        this.optimize = true;
                        this.dontOptimizeListFile = argumentsParser.getLastValue();
                    } else {
                        System.err.println("--optimize-list and --no-optimize-list are incompatible.");
                        throw new UsageException();
                    }
                } else if (argumentsParser.isArg("--keep-classes")) {
                    this.keepClassesInJar = true;
                } else if (argumentsParser.isArg("--output=")) {
                    this.outName = argumentsParser.getLastValue();
                    if (new File(this.outName).isDirectory()) {
                        this.jarOutput = false;
                        z4 = true;
                    } else if (FileUtils.hasArchiveSuffix(this.outName)) {
                        this.jarOutput = true;
                    } else if (!this.outName.endsWith(Main.DEX_EXTENSION) && !this.outName.equals("-")) {
                        PrintStream printStream = System.err;
                        printStream.println("unknown output extension: " + this.outName);
                        throw new UsageException();
                    } else {
                        this.jarOutput = false;
                        z3 = true;
                    }
                } else if (argumentsParser.isArg("--dump-to=")) {
                    this.humanOutName = argumentsParser.getLastValue();
                } else if (argumentsParser.isArg("--dump-width=")) {
                    this.dumpWidth = Integer.parseInt(argumentsParser.getLastValue());
                } else if (argumentsParser.isArg("--dump-method=")) {
                    this.methodToDump = argumentsParser.getLastValue();
                    this.jarOutput = false;
                } else if (argumentsParser.isArg("--positions=")) {
                    String intern = argumentsParser.getLastValue().intern();
                    if (intern == "none") {
                        this.positionInfo = 1;
                    } else if (intern == "important") {
                        this.positionInfo = 3;
                    } else if (intern == "lines") {
                        this.positionInfo = 2;
                    } else {
                        PrintStream printStream2 = System.err;
                        printStream2.println("unknown positions option: " + intern);
                        throw new UsageException();
                    }
                } else if (argumentsParser.isArg("--no-locals")) {
                    this.localInfo = false;
                } else if (argumentsParser.isArg("--num-threads=")) {
                    this.numThreads = Integer.parseInt(argumentsParser.getLastValue());
                } else if (argumentsParser.isArg(INCREMENTAL_OPTION)) {
                    this.incremental = true;
                } else if (argumentsParser.isArg("--force-jumbo")) {
                    this.forceJumbo = true;
                } else if (argumentsParser.isArg(MULTI_DEX_OPTION)) {
                    this.multiDex = true;
                } else if (argumentsParser.isArg("--main-dex-list=")) {
                    this.mainDexListFile = argumentsParser.getLastValue();
                } else if (argumentsParser.isArg(MINIMAL_MAIN_DEX_OPTION)) {
                    this.minimalMainDex = true;
                } else if (argumentsParser.isArg("--set-max-idx-number=")) {
                    this.maxNumberOfIdxPerDex = Integer.parseInt(argumentsParser.getLastValue());
                } else if (argumentsParser.isArg("--input-list=")) {
                    File file = new File(argumentsParser.getLastValue());
                    try {
                        this.inputList = new ArrayList();
                        Main.readPathsFromFile(file.getAbsolutePath(), this.inputList);
                    } catch (IOException unused) {
                        PrintStream printStream3 = System.err;
                        printStream3.println("Unable to read input list file: " + file.getName());
                        throw new UsageException();
                    }
                } else {
                    PrintStream printStream4 = System.err;
                    printStream4.println("unknown option: " + argumentsParser.getCurrent());
                    throw new UsageException();
                }
            }
            this.fileNames = argumentsParser.getRemaining();
            List<String> list = this.inputList;
            if (list != null && !list.isEmpty()) {
                this.inputList.addAll(Arrays.asList(this.fileNames));
                List<String> list2 = this.inputList;
                this.fileNames = (String[]) list2.toArray(new String[list2.size()]);
            }
            if (this.fileNames.length == 0) {
                if (!this.emptyOk) {
                    System.err.println("no input files specified");
                    throw new UsageException();
                }
            } else if (this.emptyOk) {
                System.out.println("ignoring input files");
            }
            if (this.humanOutName == null && this.methodToDump != null) {
                this.humanOutName = "-";
            }
            String str = this.mainDexListFile;
            if (str != null && !this.multiDex) {
                System.err.println("--main-dex-list is only supported in combination with --multi-dex");
                throw new UsageException();
            } else if (this.minimalMainDex && (str == null || !this.multiDex)) {
                System.err.println("--minimal-main-dex is only supported in combination with --multi-dex and --main-dex-list");
                throw new UsageException();
            } else {
                boolean z5 = this.multiDex;
                if (z5 && this.incremental) {
                    System.err.println("--incremental is not supported with --multi-dex");
                    throw new UsageException();
                } else if (z5 && z3) {
                    PrintStream printStream5 = System.err;
                    printStream5.println("Unsupported output \"" + this.outName + "\". " + MULTI_DEX_OPTION + " supports only archive or directory output");
                    throw new UsageException();
                } else {
                    if (z4 && !z5) {
                        this.outName = new File(this.outName, DexFormat.DEX_IN_JAR_NAME).getPath();
                    }
                    makeOptionsObjects();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class BestEffortMainDexListFilter implements ClassPathOpener.FileNameFilter {
        Map<String, List<String>> map = new HashMap();

        public BestEffortMainDexListFilter() {
            for (String str : Main.classesInMainDex) {
                String fixPath = Main.fixPath(str);
                String simpleName = getSimpleName(fixPath);
                List<String> list = this.map.get(simpleName);
                if (list == null) {
                    list = new ArrayList<>(1);
                    this.map.put(simpleName, list);
                }
                list.add(fixPath);
            }
        }

        private static String getSimpleName(String str) {
            int lastIndexOf = str.lastIndexOf(47);
            if (lastIndexOf >= 0) {
                return str.substring(lastIndexOf + 1);
            }
            return str;
        }

        @Override // com.android.dx.cf.direct.ClassPathOpener.FileNameFilter
        public boolean accept(String str) {
            if (str.endsWith(ClassFileLocator.CLASS_FILE_EXTENSION)) {
                String fixPath = Main.fixPath(str);
                List<String> list = this.map.get(getSimpleName(fixPath));
                if (list != null) {
                    for (String str2 : list) {
                        if (fixPath.endsWith(str2)) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ClassDefItemConsumer implements Callable<Boolean> {
        Future<ClassDefItem> futureClazz;
        int maxFieldIdsInClass;
        int maxMethodIdsInClass;
        String name;

        private ClassDefItemConsumer(String str, Future<ClassDefItem> future, int i4, int i5) {
            this.name = str;
            this.futureClazz = future;
            this.maxMethodIdsInClass = i4;
            this.maxFieldIdsInClass = i5;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            try {
                try {
                    ClassDefItem classDefItem = this.futureClazz.get();
                    if (classDefItem != null) {
                        Main.addClassToDex(classDefItem);
                        Main.updateStatus(true);
                    }
                    Boolean bool = Boolean.TRUE;
                    if (Main.args.multiDex) {
                        synchronized (Main.dexRotationLock) {
                            Main.maxMethodIdsInProcess -= this.maxMethodIdsInClass;
                            Main.maxFieldIdsInProcess -= this.maxFieldIdsInClass;
                            Main.dexRotationLock.notifyAll();
                        }
                    }
                    return bool;
                } catch (ExecutionException e4) {
                    Throwable cause = e4.getCause();
                    if (cause instanceof Exception) {
                        throw ((Exception) cause);
                    }
                    throw e4;
                }
            } catch (Throwable th) {
                if (Main.args.multiDex) {
                    synchronized (Main.dexRotationLock) {
                        Main.maxMethodIdsInProcess -= this.maxMethodIdsInClass;
                        Main.maxFieldIdsInProcess -= this.maxFieldIdsInClass;
                        Main.dexRotationLock.notifyAll();
                    }
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ClassParserTask implements Callable<DirectClassFile> {
        byte[] bytes;
        String name;

        private ClassParserTask(String str, byte[] bArr) {
            this.name = str;
            this.bytes = bArr;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public DirectClassFile call() throws Exception {
            return Main.parseClass(this.name, this.bytes);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ClassTranslatorTask implements Callable<ClassDefItem> {
        byte[] bytes;
        DirectClassFile classFile;
        String name;

        private ClassTranslatorTask(String str, byte[] bArr, DirectClassFile directClassFile) {
            this.name = str;
            this.bytes = bArr;
            this.classFile = directClassFile;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public ClassDefItem call() {
            return Main.translateClass(this.bytes, this.classFile);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class DexWriter implements Callable<byte[]> {
        private DexFile dexFile;

        private DexWriter(DexFile dexFile) {
            this.dexFile = dexFile;
        }

        @Override // java.util.concurrent.Callable
        public byte[] call() throws IOException {
            return Main.writeDex(this.dexFile);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class DirectClassFileConsumer implements Callable<Boolean> {
        byte[] bytes;
        Future<DirectClassFile> dcff;
        String name;

        private DirectClassFileConsumer(String str, byte[] bArr, Future<DirectClassFile> future) {
            this.name = str;
            this.bytes = bArr;
            this.dcff = future;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            return call(this.dcff.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't wrap try/catch for region: R(6:23|(2:28|(4:30|31|b3|35)(1:36))|37|38|31|b3) */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00b4 A[Catch: all -> 0x00d7, TRY_ENTER, TryCatch #3 {, blocks: (B:6:0x002b, B:7:0x002f, B:11:0x0052, B:13:0x0061, B:23:0x0094, B:24:0x00a4, B:15:0x0071, B:17:0x0077, B:20:0x007e, B:22:0x0090, B:27:0x00af, B:28:0x00b3, B:26:0x00a8, B:29:0x00b4, B:30:0x00d4, B:8:0x0030, B:9:0x0050), top: B:47:0x002b }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Boolean call(com.android.dx.cf.direct.DirectClassFile r9) {
            /*
                Method dump skipped, instructions count: 272
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.dx.command.dexer.Main.DirectClassFileConsumer.call(com.android.dx.cf.direct.DirectClassFile):java.lang.Boolean");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class FileBytesConsumer implements ClassPathOpener.Consumer {
        private FileBytesConsumer() {
        }

        @Override // com.android.dx.cf.direct.ClassPathOpener.Consumer
        public void onException(Exception exc) {
            if (!(exc instanceof StopProcessing)) {
                if (exc instanceof SimException) {
                    DxConsole.err.println("\nEXCEPTION FROM SIMULATION:");
                    PrintStream printStream = DxConsole.err;
                    printStream.println(exc.getMessage() + "\n");
                    DxConsole.err.println(((SimException) exc).getContext());
                } else if (exc instanceof ParseException) {
                    DxConsole.err.println("\nPARSE ERROR:");
                    ParseException parseException = (ParseException) exc;
                    if (Main.args.debug) {
                        parseException.printStackTrace(DxConsole.err);
                    } else {
                        parseException.printContext(DxConsole.err);
                    }
                } else {
                    DxConsole.err.println("\nUNEXPECTED TOP-LEVEL EXCEPTION:");
                    exc.printStackTrace(DxConsole.err);
                }
                Main.errors.incrementAndGet();
                return;
            }
            throw ((StopProcessing) exc);
        }

        @Override // com.android.dx.cf.direct.ClassPathOpener.Consumer
        public void onProcessArchiveStart(File file) {
            if (Main.args.verbose) {
                PrintStream printStream = DxConsole.out;
                printStream.println("processing archive " + file + "...");
            }
        }

        @Override // com.android.dx.cf.direct.ClassPathOpener.Consumer
        public boolean processFileBytes(String str, long j4, byte[] bArr) {
            return Main.processFileBytes(str, j4, bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class MainDexListFilter implements ClassPathOpener.FileNameFilter {
        private MainDexListFilter() {
        }

        @Override // com.android.dx.cf.direct.ClassPathOpener.FileNameFilter
        public boolean accept(String str) {
            if (str.endsWith(ClassFileLocator.CLASS_FILE_EXTENSION)) {
                return Main.classesInMainDex.contains(Main.fixPath(str));
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class NotFilter implements ClassPathOpener.FileNameFilter {
        private final ClassPathOpener.FileNameFilter filter;

        @Override // com.android.dx.cf.direct.ClassPathOpener.FileNameFilter
        public boolean accept(String str) {
            return !this.filter.accept(str);
        }

        private NotFilter(ClassPathOpener.FileNameFilter fileNameFilter) {
            this.filter = fileNameFilter;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class StopProcessing extends RuntimeException {
        private StopProcessing() {
        }
    }

    private Main() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean addClassToDex(ClassDefItem classDefItem) {
        synchronized (outputDex) {
            outputDex.add(classDefItem);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
        if (java.util.Arrays.binarySearch(com.android.dx.command.dexer.Main.JAVAX_CORE, r5.substring(6, r0)) >= 0) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void checkClassName(java.lang.String r5) {
        /*
            java.lang.String r0 = "java/"
            boolean r0 = r5.startsWith(r0)
            r1 = 1
            if (r0 == 0) goto La
            goto L2c
        La:
            java.lang.String r0 = "javax/"
            boolean r0 = r5.startsWith(r0)
            r2 = 0
            if (r0 == 0) goto L2b
            r0 = 47
            r3 = 6
            int r0 = r5.indexOf(r0, r3)
            r4 = -1
            if (r0 != r4) goto L1e
            goto L2c
        L1e:
            java.lang.String r0 = r5.substring(r3, r0)
            java.lang.String[] r3 = com.android.dx.command.dexer.Main.JAVAX_CORE
            int r0 = java.util.Arrays.binarySearch(r3, r0)
            if (r0 < 0) goto L2b
            goto L2c
        L2b:
            r1 = 0
        L2c:
            if (r1 != 0) goto L2f
            return
        L2f:
            java.io.PrintStream r0 = com.android.dx.command.DxConsole.err
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "\ntrouble processing \""
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = "\":\n\n"
            r1.append(r5)
            java.lang.String r5 = "Ill-advised or mistaken usage of a core class (java.* or javax.*)\nwhen not building a core library.\n\nThis is often due to inadvertently including a core library file\nin your application's project, when using an IDE (such as\nEclipse). If you are sure you're not intentionally defining a\ncore class, then this is the most likely explanation of what's\ngoing on.\n\nHowever, you might actually be trying to define a class in a core\nnamespace, the source of which you may have taken, for example,\nfrom a non-Android virtual machine project. This will most\nassuredly not work. At a minimum, it jeopardizes the\ncompatibility of your app with future versions of the platform.\nIt is also often of questionable legality.\n\nIf you really intend to build a core library -- which is only\nappropriate as part of creating a full virtual machine\ndistribution, as opposed to compiling an application -- then use\nthe \"--core-library\" option to suppress this error message.\n\nIf you go ahead and use \"--core-library\" but are in fact\nbuilding an application, then be forewarned that your application\nwill still fail to build or run, at some point. Please be\nprepared for angry customers who find, for example, that your\napplication ceases to function once they upgrade their operating\nsystem. You will be to blame for this problem.\n\nIf you are legitimately using some code that happens to be in a\ncore package, then the easiest safe alternative you have is to\nrepackage that code. That is, move the classes in question into\nyour own package namespace. This means that they will never be in\nconflict with core system classes. JarJar is a tool that may help\nyou in this endeavor. If you find that you cannot do this, then\nthat is an indication that the path you are on will ultimately\nlead to pain, suffering, grief, and lamentation.\n"
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.println(r5)
            java.util.concurrent.atomic.AtomicInteger r5 = com.android.dx.command.dexer.Main.errors
            r5.incrementAndGet()
            com.android.dx.command.dexer.Main$StopProcessing r5 = new com.android.dx.command.dexer.Main$StopProcessing
            r0 = 0
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.dx.command.dexer.Main.checkClassName(java.lang.String):void");
    }

    private static void closeOutput(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            return;
        }
        outputStream.flush();
        if (outputStream != System.out) {
            outputStream.close();
        }
    }

    private static void createDexFile() {
        DexFile dexFile = new DexFile(args.dexOptions);
        outputDex = dexFile;
        int i4 = args.dumpWidth;
        if (i4 != 0) {
            dexFile.setDumpWidth(i4);
        }
    }

    private static boolean createJar(String str) {
        try {
            Manifest makeManifest = makeManifest();
            OutputStream openOutput = openOutput(str);
            JarOutputStream jarOutputStream = new JarOutputStream(openOutput, makeManifest);
            for (Map.Entry<String, byte[]> entry : outputResources.entrySet()) {
                String key = entry.getKey();
                byte[] value = entry.getValue();
                JarEntry jarEntry = new JarEntry(key);
                int length = value.length;
                if (args.verbose) {
                    PrintStream printStream = DxConsole.out;
                    printStream.println("writing " + key + "; size " + length + "...");
                }
                jarEntry.setSize(length);
                jarOutputStream.putNextEntry(jarEntry);
                jarOutputStream.write(value);
                jarOutputStream.closeEntry();
            }
            jarOutputStream.finish();
            jarOutputStream.flush();
            closeOutput(openOutput);
            return true;
        } catch (Exception e4) {
            if (args.debug) {
                DxConsole.err.println("\ntrouble writing output:");
                e4.printStackTrace(DxConsole.err);
                return false;
            }
            PrintStream printStream2 = DxConsole.err;
            printStream2.println("\ntrouble writing output: " + e4.getMessage());
            return false;
        }
    }

    private static void dumpMethod(DexFile dexFile, String str, OutputStreamWriter outputStreamWriter) {
        boolean endsWith = str.endsWith("*");
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf > 0 && lastIndexOf != str.length() - 1) {
            String replace = str.substring(0, lastIndexOf).replace('.', '/');
            String substring = str.substring(lastIndexOf + 1);
            ClassDefItem classOrNull = dexFile.getClassOrNull(replace);
            if (classOrNull == null) {
                PrintStream printStream = DxConsole.err;
                printStream.println("no such class: " + replace);
                return;
            }
            if (endsWith) {
                substring = substring.substring(0, substring.length() - 1);
            }
            ArrayList<EncodedMethod> methods = classOrNull.getMethods();
            TreeMap treeMap = new TreeMap();
            Iterator<EncodedMethod> it = methods.iterator();
            while (it.hasNext()) {
                EncodedMethod next = it.next();
                String string = next.getName().getString();
                if ((endsWith && string.startsWith(substring)) || (!endsWith && string.equals(substring))) {
                    treeMap.put(next.getRef().getNat(), next);
                }
            }
            if (treeMap.size() == 0) {
                PrintStream printStream2 = DxConsole.err;
                printStream2.println("no such method: " + str);
                return;
            }
            PrintWriter printWriter = new PrintWriter(outputStreamWriter);
            for (EncodedMethod encodedMethod : treeMap.values()) {
                encodedMethod.debugPrint(printWriter, args.verboseDump);
                CstString sourceFile = classOrNull.getSourceFile();
                if (sourceFile != null) {
                    printWriter.println("  source file: " + sourceFile.toQuoted());
                }
                Annotations methodAnnotations = classOrNull.getMethodAnnotations(encodedMethod.getRef());
                AnnotationsList parameterAnnotations = classOrNull.getParameterAnnotations(encodedMethod.getRef());
                if (methodAnnotations != null) {
                    printWriter.println("  method annotations:");
                    Iterator<Annotation> it2 = methodAnnotations.getAnnotations().iterator();
                    while (it2.hasNext()) {
                        printWriter.println("    " + it2.next());
                    }
                }
                if (parameterAnnotations != null) {
                    printWriter.println("  parameter annotations:");
                    int size = parameterAnnotations.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        printWriter.println("    parameter " + i4);
                        Iterator<Annotation> it3 = parameterAnnotations.get(i4).getAnnotations().iterator();
                        while (it3.hasNext()) {
                            printWriter.println("      " + it3.next());
                        }
                    }
                }
            }
            printWriter.flush();
            return;
        }
        PrintStream printStream3 = DxConsole.err;
        printStream3.println("bogus fully-qualified method name: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String fixPath(String str) {
        if (File.separatorChar == '\\') {
            str = str.replace('\\', '/');
        }
        int lastIndexOf = str.lastIndexOf("/./");
        if (lastIndexOf != -1) {
            return str.substring(lastIndexOf + 3);
        }
        if (str.startsWith("./")) {
            return str.substring(2);
        }
        return str;
    }

    private static String getDexFileName(int i4) {
        if (i4 == 0) {
            return DexFormat.DEX_IN_JAR_NAME;
        }
        return DEX_PREFIX + (i4 + 1) + DEX_EXTENSION;
    }

    public static String getTooManyIdsErrorMessage() {
        if (args.multiDex) {
            return "The list of classes given in --main-dex-list is too big and does not fit in the main dex.";
        }
        return "You may try using --multi-dex option.";
    }

    public static void main(String[] strArr) throws IOException {
        Arguments arguments = new Arguments();
        arguments.parse(strArr);
        int run = run(arguments);
        if (run != 0) {
            System.exit(run);
        }
    }

    private static Manifest makeManifest() throws IOException {
        Attributes attributes;
        Manifest manifest;
        String str;
        byte[] bArr = outputResources.get(MANIFEST_NAME);
        if (bArr == null) {
            manifest = new Manifest();
            attributes = manifest.getMainAttributes();
            attributes.put(Attributes.Name.MANIFEST_VERSION, "1.0");
        } else {
            Manifest manifest2 = new Manifest(new ByteArrayInputStream(bArr));
            Attributes mainAttributes = manifest2.getMainAttributes();
            outputResources.remove(MANIFEST_NAME);
            attributes = mainAttributes;
            manifest = manifest2;
        }
        Attributes.Name name = CREATED_BY;
        String value = attributes.getValue(name);
        if (value == null) {
            str = "";
        } else {
            str = value + " + ";
        }
        attributes.put(name, str + "dx 1.12");
        attributes.putValue("Dex-Location", DexFormat.DEX_IN_JAR_NAME);
        return manifest;
    }

    private static byte[] mergeIncremental(byte[] bArr, File file) throws IOException {
        Dex dex;
        Dex dex2;
        if (bArr != null) {
            dex = new Dex(bArr);
        } else {
            dex = null;
        }
        if (file.exists()) {
            dex2 = new Dex(file);
        } else {
            dex2 = null;
        }
        if (dex == null && dex2 == null) {
            return null;
        }
        if (dex == null) {
            dex = dex2;
        } else if (dex2 != null) {
            dex = new DexMerger(new Dex[]{dex, dex2}, CollisionPolicy.KEEP_FIRST).merge();
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        dex.writeTo(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] mergeLibraryDexBuffers(byte[] bArr) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (bArr != null) {
            arrayList.add(new Dex(bArr));
        }
        for (byte[] bArr2 : libraryDexBuffers) {
            arrayList.add(new Dex(bArr2));
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new DexMerger((Dex[]) arrayList.toArray(new Dex[arrayList.size()]), CollisionPolicy.FAIL).merge().getBytes();
    }

    private static OutputStream openOutput(String str) throws IOException {
        if (!str.equals("-") && !str.startsWith("-.")) {
            return new FileOutputStream(str);
        }
        return System.out;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DirectClassFile parseClass(String str, byte[] bArr) {
        DirectClassFile directClassFile = new DirectClassFile(bArr, str, args.cfOptions.strictNameCheck);
        directClassFile.setAttributeFactory(StdAttributeFactory.THE_ONE);
        directClassFile.getMagic();
        return directClassFile;
    }

    private static boolean processAllFiles() {
        String str;
        ClassPathOpener.FileNameFilter bestEffortMainDexListFilter;
        createDexFile();
        if (args.jarOutput) {
            outputResources = new TreeMap<>();
        }
        anyFilesProcessed = false;
        String[] strArr = args.fileNames;
        Arrays.sort(strArr);
        int i4 = args.numThreads;
        classTranslatorPool = new ThreadPoolExecutor(i4, i4, 0L, TimeUnit.SECONDS, new ArrayBlockingQueue(args.numThreads * 2, true), new ThreadPoolExecutor.CallerRunsPolicy());
        classDefItemConsumer = Executors.newSingleThreadExecutor();
        try {
            Arguments arguments = args;
            if (arguments.mainDexListFile != null) {
                if (arguments.strictNameCheck) {
                    bestEffortMainDexListFilter = new MainDexListFilter();
                } else {
                    bestEffortMainDexListFilter = new BestEffortMainDexListFilter();
                }
                for (String str2 : strArr) {
                    processOne(str2, bestEffortMainDexListFilter);
                }
                if (dexOutputFutures.size() <= 0) {
                    if (args.minimalMainDex) {
                        synchronized (dexRotationLock) {
                            while (true) {
                                if (maxMethodIdsInProcess <= 0 && maxFieldIdsInProcess <= 0) {
                                    break;
                                }
                                try {
                                    dexRotationLock.wait();
                                } catch (InterruptedException unused) {
                                }
                            }
                        }
                        rotateDexFile();
                    }
                    for (String str3 : strArr) {
                        processOne(str3, new NotFilter(bestEffortMainDexListFilter));
                    }
                } else {
                    throw new DexException("Too many classes in --main-dex-list, main dex capacity exceeded");
                }
            } else {
                for (String str4 : strArr) {
                    processOne(str4, ClassPathOpener.acceptAll);
                }
            }
        } catch (StopProcessing unused2) {
        }
        try {
            classTranslatorPool.shutdown();
            ExecutorService executorService = classTranslatorPool;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            executorService.awaitTermination(600L, timeUnit);
            classDefItemConsumer.shutdown();
            classDefItemConsumer.awaitTermination(600L, timeUnit);
            for (Future<Boolean> future : addToDexFutures) {
                try {
                    future.get();
                } catch (ExecutionException e4) {
                    if (errors.incrementAndGet() < 10) {
                        if (args.debug) {
                            DxConsole.err.println("Uncaught translation error:");
                            e4.getCause().printStackTrace(DxConsole.err);
                        } else {
                            DxConsole.err.println("Uncaught translation error: " + e4.getCause());
                        }
                    } else {
                        throw new InterruptedException("Too many errors");
                    }
                }
            }
            int i5 = errors.get();
            if (i5 != 0) {
                PrintStream printStream = DxConsole.err;
                StringBuilder sb = new StringBuilder();
                sb.append(i5);
                sb.append(" error");
                if (i5 == 1) {
                    str = "";
                } else {
                    str = "s";
                }
                sb.append(str);
                sb.append("; aborting");
                printStream.println(sb.toString());
                return false;
            } else if (args.incremental && !anyFilesProcessed) {
                return true;
            } else {
                if (!anyFilesProcessed && !args.emptyOk) {
                    DxConsole.err.println("no classfiles specified");
                    return false;
                }
                Arguments arguments2 = args;
                if (arguments2.optimize && arguments2.statistics) {
                    CodeStatistics.dumpStatistics(DxConsole.out);
                }
                return true;
            }
        } catch (InterruptedException e5) {
            classTranslatorPool.shutdownNow();
            classDefItemConsumer.shutdownNow();
            throw new RuntimeException("Translation has been interrupted", e5);
        } catch (Exception e6) {
            classTranslatorPool.shutdownNow();
            classDefItemConsumer.shutdownNow();
            e6.printStackTrace(System.out);
            throw new RuntimeException("Unexpected exception in translator thread.", e6);
        }
    }

    private static boolean processClass(String str, byte[] bArr) {
        if (!args.coreLibrary) {
            checkClassName(str);
        }
        try {
            new DirectClassFileConsumer(str, bArr, null).call(new ClassParserTask(str, bArr).call());
            return true;
        } catch (ParseException e4) {
            throw e4;
        } catch (Exception e5) {
            throw new RuntimeException("Exception parsing classes", e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean processFileBytes(String str, long j4, byte[] bArr) {
        boolean z3;
        boolean endsWith = str.endsWith(ClassFileLocator.CLASS_FILE_EXTENSION);
        boolean equals = str.equals(DexFormat.DEX_IN_JAR_NAME);
        if (outputResources != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!endsWith && !equals && !z3) {
            if (args.verbose) {
                PrintStream printStream = DxConsole.out;
                printStream.println("ignored resource " + str);
            }
            return false;
        }
        if (args.verbose) {
            PrintStream printStream2 = DxConsole.out;
            printStream2.println("processing " + str + "...");
        }
        String fixPath = fixPath(str);
        if (endsWith) {
            if (z3 && args.keepClassesInJar) {
                synchronized (outputResources) {
                    outputResources.put(fixPath, bArr);
                }
            }
            if (j4 < minimumFileAge) {
                return true;
            }
            processClass(fixPath, bArr);
            return false;
        } else if (equals) {
            List<byte[]> list = libraryDexBuffers;
            synchronized (list) {
                list.add(bArr);
            }
            return true;
        } else {
            synchronized (outputResources) {
                outputResources.put(fixPath, bArr);
            }
            return true;
        }
    }

    private static void processOne(String str, ClassPathOpener.FileNameFilter fileNameFilter) {
        if (new ClassPathOpener(str, true, fileNameFilter, new FileBytesConsumer()).process()) {
            updateStatus(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readPathsFromFile(String str, Collection<String> collection) throws IOException {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        collection.add(fixPath(readLine));
                    } else {
                        bufferedReader2.close();
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void rotateDexFile() {
        DexFile dexFile = outputDex;
        if (dexFile != null) {
            ExecutorService executorService = dexOutPool;
            if (executorService != null) {
                dexOutputFutures.add(executorService.submit(new DexWriter(dexFile)));
            } else {
                dexOutputArrays.add(writeDex(dexFile));
            }
        }
        createDexFile();
    }

    public static int run(Arguments arguments) throws IOException {
        OutputStream outputStream;
        errors.set(0);
        libraryDexBuffers.clear();
        args = arguments;
        arguments.makeOptionsObjects();
        String str = args.humanOutName;
        if (str != null) {
            outputStream = openOutput(str);
            humanOutWriter = new OutputStreamWriter(outputStream);
        } else {
            outputStream = null;
        }
        try {
            if (args.multiDex) {
                return runMultiDex();
            }
            return runMonoDex();
        } finally {
            closeOutput(outputStream);
        }
    }

    private static int runMonoDex() throws IOException {
        File file;
        byte[] writeDex;
        String str;
        Arguments arguments = args;
        if (arguments.incremental) {
            if (arguments.outName == null) {
                System.err.println("error: no incremental output name specified");
                return -1;
            }
            file = new File(args.outName);
            if (file.exists()) {
                minimumFileAge = file.lastModified();
            }
        } else {
            file = null;
        }
        if (!processAllFiles()) {
            return 1;
        }
        if (args.incremental && !anyFilesProcessed) {
            return 0;
        }
        if (outputDex.isEmpty() && args.humanOutName == null) {
            writeDex = null;
        } else {
            writeDex = writeDex(outputDex);
            if (writeDex == null) {
                return 2;
            }
        }
        if (args.incremental) {
            writeDex = mergeIncremental(writeDex, file);
        }
        byte[] mergeLibraryDexBuffers = mergeLibraryDexBuffers(writeDex);
        Arguments arguments2 = args;
        if (arguments2.jarOutput) {
            outputDex = null;
            if (mergeLibraryDexBuffers != null) {
                outputResources.put(DexFormat.DEX_IN_JAR_NAME, mergeLibraryDexBuffers);
            }
            if (!createJar(args.outName)) {
                return 3;
            }
        } else if (mergeLibraryDexBuffers != null && (str = arguments2.outName) != null) {
            OutputStream openOutput = openOutput(str);
            openOutput.write(mergeLibraryDexBuffers);
            closeOutput(openOutput);
        }
        return 0;
    }

    private static int runMultiDex() throws IOException {
        if (args.mainDexListFile != null) {
            HashSet hashSet = new HashSet();
            classesInMainDex = hashSet;
            readPathsFromFile(args.mainDexListFile, hashSet);
        }
        dexOutPool = Executors.newFixedThreadPool(args.numThreads);
        if (!processAllFiles()) {
            return 1;
        }
        if (libraryDexBuffers.isEmpty()) {
            DexFile dexFile = outputDex;
            if (dexFile != null) {
                dexOutputFutures.add(dexOutPool.submit(new DexWriter(dexFile)));
                outputDex = null;
            }
            try {
                dexOutPool.shutdown();
                if (dexOutPool.awaitTermination(600L, TimeUnit.SECONDS)) {
                    for (Future<byte[]> future : dexOutputFutures) {
                        dexOutputArrays.add(future.get());
                    }
                    Arguments arguments = args;
                    if (arguments.jarOutput) {
                        for (int i4 = 0; i4 < dexOutputArrays.size(); i4++) {
                            outputResources.put(getDexFileName(i4), dexOutputArrays.get(i4));
                        }
                        if (!createJar(args.outName)) {
                            return 3;
                        }
                    } else if (arguments.outName != null) {
                        File file = new File(args.outName);
                        for (int i5 = 0; i5 < dexOutputArrays.size(); i5++) {
                            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, getDexFileName(i5)));
                            try {
                                fileOutputStream.write(dexOutputArrays.get(i5));
                                closeOutput(fileOutputStream);
                            } catch (Throwable th) {
                                closeOutput(fileOutputStream);
                                throw th;
                            }
                        }
                    }
                    return 0;
                }
                throw new RuntimeException("Timed out waiting for dex writer threads.");
            } catch (InterruptedException unused) {
                dexOutPool.shutdownNow();
                throw new RuntimeException("A dex writer thread has been interrupted.");
            } catch (Exception unused2) {
                dexOutPool.shutdownNow();
                throw new RuntimeException("Unexpected exception in dex writer thread");
            }
        }
        throw new DexException("Library dex files are not supported in multi-dex mode");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ClassDefItem translateClass(byte[] bArr, DirectClassFile directClassFile) {
        try {
            Arguments arguments = args;
            return CfTranslator.translate(directClassFile, bArr, arguments.cfOptions, arguments.dexOptions, outputDex);
        } catch (ParseException e4) {
            DxConsole.err.println("\ntrouble processing:");
            if (args.debug) {
                e4.printStackTrace(DxConsole.err);
            } else {
                e4.printContext(DxConsole.err);
            }
            errors.incrementAndGet();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateStatus(boolean z3) {
        anyFilesProcessed = z3 | anyFilesProcessed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] writeDex(DexFile dexFile) {
        byte[] dex;
        try {
            Arguments arguments = args;
            if (arguments.methodToDump != null) {
                dexFile.toDex(null, false);
                dumpMethod(dexFile, args.methodToDump, humanOutWriter);
                dex = null;
            } else {
                dex = dexFile.toDex(humanOutWriter, arguments.verboseDump);
            }
            if (args.statistics) {
                DxConsole.out.println(dexFile.getStatistics().toHuman());
            }
            OutputStreamWriter outputStreamWriter = humanOutWriter;
            if (outputStreamWriter != null) {
                outputStreamWriter.flush();
            }
            return dex;
        } catch (Exception e4) {
            if (args.debug) {
                DxConsole.err.println("\ntrouble writing output:");
                e4.printStackTrace(DxConsole.err);
            } else {
                DxConsole.err.println("\ntrouble writing output: " + e4.getMessage());
            }
            return null;
        }
    }
}
