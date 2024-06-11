package com.Sunshine.shell_utils;

import android.os.Environment;

import com.Sunshine.common.shell.KeepShellPublic;
import com.Sunshine.common.shell.RootFile;

public class AppErrorLogcatUtils {
    private String logPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/vtools-error.log";

    public String catLogInfo() {
        if (!RootFile.INSTANCE.fileExists(logPath)) {
            return KeepShellPublic.INSTANCE.doCmdSync("logcat -d *:E > \"" + logPath + "\"");
        }
        return KeepShellPublic.INSTANCE.doCmdSync("cat \"" + logPath + "\"");
    }

    public void catLogInfo2File(int pid) {
        KeepShellPublic.INSTANCE.doCmdSync("logcat -d *:E --pid " + pid + " > \"" + logPath + "\"");
    }
}
