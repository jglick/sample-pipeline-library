package com.github.jglick.sample
class Err {
    static void fail(script) {
        script.error 'oops'
    }
}
