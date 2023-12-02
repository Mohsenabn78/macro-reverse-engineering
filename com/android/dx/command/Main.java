package com.android.dx.command;

/* loaded from: classes2.dex */
public class Main {
    private static String USAGE_MESSAGE = "usage:\n  dx --dex [--debug] [--verbose] [--positions=<style>] [--no-locals]\n  [--no-optimize] [--statistics] [--[no-]optimize-list=<file>] [--no-strict]\n  [--keep-classes] [--output=<file>] [--dump-to=<file>] [--dump-width=<n>]\n  [--dump-method=<name>[*]] [--verbose-dump] [--no-files] [--core-library]\n  [--num-threads=<n>] [--incremental] [--force-jumbo] [--no-warning]\n  [--multi-dex [--main-dex-list=<file> [--minimal-main-dex]]\n  [--input-list=<file>]\n  [<file>.class | <file>.{zip,jar,apk} | <directory>] ...\n    Convert a set of classfiles into a dex file, optionally embedded in a\n    jar/zip. Output name must end with one of: .dex .jar .zip .apk or be a directory.\n    Positions options: none, important, lines.\n    --multi-dex: allows to generate several dex files if needed. This option is \n    exclusive with --incremental, causes --num-threads to be ignored and only\n    supports folder or archive output.\n    --main-dex-list=<file>: <file> is a list of class file names, classes defined by\n    those class files are put in classes.dex.\n    --minimal-main-dex: only classes selected by --main-dex-list are to be put in\n    the main dex.\n    --input-list: <file> is a list of inputs.\n    Each line in <file> must end with one of: .class .jar .zip .apk or be a directory.\n  dx --annotool --annotation=<class> [--element=<element types>]\n  [--print=<print types>]\n  dx --dump [--debug] [--strict] [--bytes] [--optimize]\n  [--basic-blocks | --rop-blocks | --ssa-blocks | --dot] [--ssa-step=<step>]\n  [--width=<n>] [<file>.class | <file>.txt] ...\n    Dump classfiles, or transformations thereof, in a human-oriented format.\n  dx --find-usages <file.dex> <declaring type> <member>\n    Find references and declarations to a field or method.\n    declaring type: a class name in internal form, like Ljava/lang/Object;\n    member: a field or method name, like hashCode\n  dx -J<option> ... <arguments, in one of the above forms>\n    Pass VM-specific options to the virtual machine that runs dx.\n  dx --version\n    Print the version of this tool (1.12).\n  dx --help\n    Print this message.";

    private Main() {
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void main(java.lang.String[] r6) {
        /*
            java.lang.String r0 = "--"
            r1 = 0
            r2 = 0
        L4:
            r3 = 1
            int r4 = r6.length     // Catch: java.lang.Throwable -> L7c java.lang.RuntimeException -> L9c com.android.dx.command.UsageException -> Laf
            if (r2 >= r4) goto Lad
            r4 = r6[r2]     // Catch: java.lang.Throwable -> L7c java.lang.RuntimeException -> L9c com.android.dx.command.UsageException -> Laf
            boolean r5 = r4.equals(r0)     // Catch: java.lang.Throwable -> L7c java.lang.RuntimeException -> L9c com.android.dx.command.UsageException -> Laf
            if (r5 != 0) goto Lb0
            boolean r5 = r4.startsWith(r0)     // Catch: java.lang.Throwable -> L7c java.lang.RuntimeException -> L9c com.android.dx.command.UsageException -> Laf
            if (r5 != 0) goto L18
            goto Lb0
        L18:
            java.lang.String r5 = "--dex"
            boolean r5 = r4.equals(r5)     // Catch: java.lang.Throwable -> L73 java.lang.RuntimeException -> L76 com.android.dx.command.UsageException -> L79
            if (r5 == 0) goto L28
            java.lang.String[] r6 = without(r6, r2)     // Catch: java.lang.Throwable -> L73 java.lang.RuntimeException -> L76 com.android.dx.command.UsageException -> L79
            com.android.dx.command.dexer.Main.main(r6)     // Catch: java.lang.Throwable -> L73 java.lang.RuntimeException -> L76 com.android.dx.command.UsageException -> L79
            goto L63
        L28:
            java.lang.String r5 = "--dump"
            boolean r5 = r4.equals(r5)     // Catch: java.lang.Throwable -> L73 java.lang.RuntimeException -> L76 com.android.dx.command.UsageException -> L79
            if (r5 == 0) goto L38
            java.lang.String[] r6 = without(r6, r2)     // Catch: java.lang.Throwable -> L73 java.lang.RuntimeException -> L76 com.android.dx.command.UsageException -> L79
            com.android.dx.command.dump.Main.main(r6)     // Catch: java.lang.Throwable -> L73 java.lang.RuntimeException -> L76 com.android.dx.command.UsageException -> L79
            goto L63
        L38:
            java.lang.String r5 = "--annotool"
            boolean r5 = r4.equals(r5)     // Catch: java.lang.Throwable -> L73 java.lang.RuntimeException -> L76 com.android.dx.command.UsageException -> L79
            if (r5 == 0) goto L48
            java.lang.String[] r6 = without(r6, r2)     // Catch: java.lang.Throwable -> L73 java.lang.RuntimeException -> L76 com.android.dx.command.UsageException -> L79
            com.android.dx.command.annotool.Main.main(r6)     // Catch: java.lang.Throwable -> L73 java.lang.RuntimeException -> L76 com.android.dx.command.UsageException -> L79
            goto L63
        L48:
            java.lang.String r5 = "--find-usages"
            boolean r5 = r4.equals(r5)     // Catch: java.lang.Throwable -> L73 java.lang.RuntimeException -> L76 com.android.dx.command.UsageException -> L79
            if (r5 == 0) goto L58
            java.lang.String[] r6 = without(r6, r2)     // Catch: java.lang.Throwable -> L73 java.lang.RuntimeException -> L76 com.android.dx.command.UsageException -> L79
            com.android.dx.command.findusages.Main.main(r6)     // Catch: java.lang.Throwable -> L73 java.lang.RuntimeException -> L76 com.android.dx.command.UsageException -> L79
            goto L63
        L58:
            java.lang.String r5 = "--version"
            boolean r5 = r4.equals(r5)     // Catch: java.lang.Throwable -> L73 java.lang.RuntimeException -> L76 com.android.dx.command.UsageException -> L79
            if (r5 == 0) goto L66
            version()     // Catch: java.lang.Throwable -> L73 java.lang.RuntimeException -> L76 com.android.dx.command.UsageException -> L79
        L63:
            r6 = 0
        L64:
            r1 = 1
            goto Lb1
        L66:
            java.lang.String r5 = "--help"
            boolean r4 = r4.equals(r5)     // Catch: java.lang.Throwable -> L73 java.lang.RuntimeException -> L76 com.android.dx.command.UsageException -> L79
            if (r4 == 0) goto L70
            r6 = 1
            goto L64
        L70:
            int r2 = r2 + 1
            goto L4
        L73:
            r6 = move-exception
            r0 = 1
            goto L7e
        L76:
            r6 = move-exception
            r0 = 1
            goto L9e
        L79:
            r1 = 1
            goto Lb0
        L7c:
            r6 = move-exception
            r0 = 0
        L7e:
            java.io.PrintStream r2 = java.lang.System.err
            java.lang.String r4 = "\nUNEXPECTED TOP-LEVEL ERROR:"
            r2.println(r4)
            r6.printStackTrace()
            boolean r2 = r6 instanceof java.lang.NoClassDefFoundError
            if (r2 != 0) goto L90
            boolean r6 = r6 instanceof java.lang.NoSuchMethodError
            if (r6 == 0) goto L97
        L90:
            java.io.PrintStream r6 = java.lang.System.err
            java.lang.String r2 = "Note: You may be using an incompatible virtual machine or class library.\n(This program is known to be incompatible with recent releases of GCJ.)"
            r6.println(r2)
        L97:
            r6 = 3
            java.lang.System.exit(r6)
            goto Lac
        L9c:
            r6 = move-exception
            r0 = 0
        L9e:
            java.io.PrintStream r2 = java.lang.System.err
            java.lang.String r4 = "\nUNEXPECTED TOP-LEVEL EXCEPTION:"
            r2.println(r4)
            r6.printStackTrace()
            r6 = 2
            java.lang.System.exit(r6)
        Lac:
            r1 = r0
        Lad:
            r6 = 0
            goto Lb1
        Laf:
        Lb0:
            r6 = 1
        Lb1:
            if (r1 != 0) goto Lbb
            java.io.PrintStream r6 = java.lang.System.err
            java.lang.String r0 = "error: no command specified"
            r6.println(r0)
            r6 = 1
        Lbb:
            if (r6 == 0) goto Lc3
            usage()
            java.lang.System.exit(r3)
        Lc3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.dx.command.Main.main(java.lang.String[]):void");
    }

    private static void usage() {
        System.err.println(USAGE_MESSAGE);
    }

    private static void version() {
        System.err.println("dx version 1.12");
        System.exit(0);
    }

    private static String[] without(String[] strArr, int i4) {
        int length = strArr.length - 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, i4);
        System.arraycopy(strArr, i4 + 1, strArr2, i4, length - i4);
        return strArr2;
    }
}
