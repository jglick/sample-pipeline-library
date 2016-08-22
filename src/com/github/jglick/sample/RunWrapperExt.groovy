package com.github.jglick.sample
public class RunWrapperExt {
    private RunWrapper delegate
    public RunWrapperExt(RunWrapper delegate) {
        this.delegate = delegate
    }
    @NonCPS
    public boolean hasChangeIn(String pathPrefix) {
        for (hudson.scm.ChangeLogSet set : delegate.changeSets) {
            for (hudson.scm.ChangeLogSet.Entry entry : set) {
                for (String path : entry.affectedPaths) {
                    if (path == pathPrefix || path.startsWith(pathPrefix + '/')) {
                        return true
                    }
                }
            }
        }
        false
    }
}