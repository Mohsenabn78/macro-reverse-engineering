package com.android.dx.command.dump;

import com.android.dex.util.FileUtils;
import com.android.dx.cf.iface.ParseException;
import com.android.dx.util.HexParser;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import net.bytebuddy.dynamic.ClassFileLocator;
import org.apache.commons.cli.HelpFormatter;

/* loaded from: classes2.dex */
public class Main {
    static Args parsedArgs = new Args();

    private Main() {
    }

    public static void main(String[] strArr) {
        int i4 = 0;
        while (i4 < strArr.length) {
            String str = strArr[i4];
            if (str.equals(HelpFormatter.DEFAULT_LONG_OPT_PREFIX) || !str.startsWith(HelpFormatter.DEFAULT_LONG_OPT_PREFIX)) {
                break;
            }
            if (str.equals("--bytes")) {
                parsedArgs.rawBytes = true;
            } else if (str.equals("--basic-blocks")) {
                parsedArgs.basicBlocks = true;
            } else if (str.equals("--rop-blocks")) {
                parsedArgs.ropBlocks = true;
            } else if (str.equals("--optimize")) {
                parsedArgs.optimize = true;
            } else if (str.equals("--ssa-blocks")) {
                parsedArgs.ssaBlocks = true;
            } else if (str.startsWith("--ssa-step=")) {
                parsedArgs.ssaStep = str.substring(str.indexOf(61) + 1);
            } else if (str.equals("--debug")) {
                parsedArgs.debug = true;
            } else if (str.equals("--dot")) {
                parsedArgs.dotDump = true;
            } else if (str.equals("--strict")) {
                parsedArgs.strictParse = true;
            } else if (str.startsWith("--width=")) {
                String substring = str.substring(str.indexOf(61) + 1);
                parsedArgs.width = Integer.parseInt(substring);
            } else if (str.startsWith("--method=")) {
                parsedArgs.method = str.substring(str.indexOf(61) + 1);
            } else {
                PrintStream printStream = System.err;
                printStream.println("unknown option: " + str);
                throw new RuntimeException("usage");
            }
            i4++;
        }
        if (i4 != strArr.length) {
            while (i4 < strArr.length) {
                try {
                    String str2 = strArr[i4];
                    PrintStream printStream2 = System.out;
                    printStream2.println("reading " + str2 + "...");
                    byte[] readFile = FileUtils.readFile(str2);
                    if (!str2.endsWith(ClassFileLocator.CLASS_FILE_EXTENSION)) {
                        try {
                            readFile = HexParser.parse(new String(readFile, "utf-8"));
                        } catch (UnsupportedEncodingException e4) {
                            throw new RuntimeException("shouldn't happen", e4);
                            break;
                        }
                    }
                    processOne(str2, readFile);
                } catch (ParseException e5) {
                    System.err.println("\ntrouble parsing:");
                    if (parsedArgs.debug) {
                        e5.printStackTrace();
                    } else {
                        e5.printContext(System.err);
                    }
                }
                i4++;
            }
            return;
        }
        System.err.println("no input files specified");
        throw new RuntimeException("usage");
    }

    private static void processOne(String str, byte[] bArr) {
        Args args = parsedArgs;
        if (args.dotDump) {
            DotDumper.dump(bArr, str, args);
        } else if (args.basicBlocks) {
            BlockDumper.dump(bArr, System.out, str, false, args);
        } else if (args.ropBlocks) {
            BlockDumper.dump(bArr, System.out, str, true, args);
        } else if (args.ssaBlocks) {
            args.optimize = false;
            SsaDumper.dump(bArr, System.out, str, args);
        } else {
            ClassDumper.dump(bArr, System.out, str, args);
        }
    }
}
