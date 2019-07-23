package io.xjar.compiler;

import java.io.File;
import java.util.List;

/**
 * Mac 编译器
 *
 * @author Payne 646742615@qq.com
 * 2019/7/16 10:48
 */
public class XMacCompiler extends XPlatformCompiler {
    protected String gccPath = "g++";
    protected String jdkRoot = new File(System.getProperty("java.home")).getParent();

    @Override
    protected String convert(List<String> src, String lib) {
        StringBuilder command = new StringBuilder();
        command.append("\'").append(gccPath).append("\'");
        command.append(" ").append("-fPIC");
        command.append(" ").append("-shared");
        command.append(" ").append("-o");
        command.append(" ").append("\'").append(lib).append("\'");
        for (String path : src) {
            command.append(" ").append("\'").append(path).append("\'");
        }
        command.append(" ").append("-I \'").append(jdkRoot).append(File.separator).append("include").append("\'");
        command.append(" ").append("-I \'").append(jdkRoot).append(File.separator).append("include").append(File.separator).append("darwin").append("\'");
        return command.toString();
    }

    public String getGccPath() {
        return gccPath;
    }

    public void setGccPath(String gccPath) {
        this.gccPath = gccPath;
    }

    public String getJdkRoot() {
        return jdkRoot;
    }

    public void setJdkRoot(String jdkRoot) {
        this.jdkRoot = jdkRoot;
    }
}