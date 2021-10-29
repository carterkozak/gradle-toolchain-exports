# Java Toolchains are Incompatible with `--add-exports` for System Modules

I've tested using a jdk-17 `JAVA_HOME` matching the toolchain definition for a like-for-like comparison.

Compilation and execution work as expected without a toolchain:

```bash
[gradle-toolchain-exports]$ ./gradlew compileJava

BUILD SUCCESSFUL in 559ms
1 actionable task: 1 executed
[gradle-toolchain-exports]$ ./gradlew run

> Task :run
Safepoint millis: 0

BUILD SUCCESSFUL in 645ms
2 actionable tasks: 1 executed, 1 up-to-date
```

However, there's seemingly no way to make this work using toolchains:

```bash
[gradle-toolchain-exports]$ ./gradlew compileJava -Ptoolchain

> Task :compileJava FAILED
error: exporting a package from system module java.management is not allowed with --release
1 error

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':compileJava'.
> Compilation failed; see the compiler error output for details.

* Try:
Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output. Run with --scan to get full insights.

* Get more help at https://help.gradle.org

BUILD FAILED in 582ms
1 actionable task: 1 executed
```

I should be able to use my toolchain version selection _instead_ of the `--release` flag, unless a lower version is specified.