package hu.modeldriven.astah.standalone;

import hu.modeldriven.astah.validation.core.AstahModelValidator;
import org.slf4j.simple.SimpleLogger;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.File;
import java.util.concurrent.Callable;

@Command(name = "validator", mixinStandardHelpOptions = true, version = "validator 1.0",
        description = "Validate an Astah SysML model file against a set of rules.")
public class Main implements Callable<Integer> {

    @Option(names = {"--model"}, description = "The axmz or auml file to validate.", required = true)
    private File modelFile;

    @Option(names = {"--repo"}, description = "The repository file containing the validation rules.", required = true)
    private File repoFile;

    @Option(names = {"--id"}, description = "The file containing unique id's to be checked", required = false)
    private File idFile;

    @Option(names = {"--output"}, description = "The file containing the validation results.", required = true)
    private File outputFile;

    @Option(names = {"--log-level"}, description = "The log level to use (TRACE, DEBUG, INFO, WARN, ERROR). Default is INFO.")
    private String logLevel;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {

        if (logLevel != null) {
            System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, logLevel);
        }

        var validator = new AstahModelValidator(modelFile, repoFile, outputFile, idFile);
        validator.validate();

        return 0;
    }

}
