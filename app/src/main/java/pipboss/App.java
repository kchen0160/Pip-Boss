package pipboss;

import java.util.*;
import java.util.concurrent.Callable;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.ParameterException;
import picocli.CommandLine.Spec;



@Command(description = "Play PipBoss.",
         name = "pipboss", mixinStandardHelpOptions = true, version = "pipboss 1.0")
public class App implements Callable<Integer> {

    @Spec CommandSpec spec;

    
    @Command(name = "phase0", description = "Play the Phase 0 version of PipBoss")
    void phase0() {
        Main.phase0();
    }
     
    @Command(name = "phase1", description = "Play the Phase 1 version of PipBoss")
    void phase1() {
        Main.phase1();
    }
    
    @Command(name = "phase2", description = "Play the Phase 2 version of PipBoss")
    void phase2() {
        Main.phase2();
    }

    @Command(name = "phase3", description = "Play the Phase 3 version of PipBoss")
    void phase3() {
        Main.phase3();
    }

    @Command(name = "phase4", description = "Play the Phase 4 version of PipBoss")
    void phase4() {
        Main.phase4();
    }

    @Command(name = "phase5", description = "Play the Phase 5 version of PipBoss")
    void phase5() {
        Main.phase5();
    }

    @Command(name = "phase6", description = "Play the Phase 6 version of PipBoss")
    void phase6() {
        Main.phase6();
    }

    @Command(name = "phase7", description = "Play the Phase 7 version of PipBoss")
    void phase7() {
        Main.phase7();
    }
    
    
    @Command(name = "phase8", description = "Play the Phase 8 version of PipBoss")
    void phase8() {
        Main.phase8();
    }

    @Command(name = "phase9", description = "Play the Phase 9 version of PipBoss")
    void phase9() {
        Main.phase9();
    }

    @Command(name = "phase10", description = "Play the Phase 10 version of PipBoss")
    void phase10() {
        Main.phase10();
    }

    @Command(name = "phase11", description = "Play the Phase 11 version of PipBoss")
    void phase11() {
        Main.phase11();
    }

    public static void main(String... args) throws Exception {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {
        throw new ParameterException(spec.commandLine(), "Specify a subcommand");
    }
}
