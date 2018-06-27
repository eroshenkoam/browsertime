package io.eroshenkoam.browsertime;

import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import io.eroshenkoam.browsertime.browsertime.BrowsertimeReport;
import io.eroshenkoam.browsertime.coach.CoachReport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.StringJoiner;

public class BuildReport {

    public static void main(final String[] args) throws Exception {
        final ObjectMapper mapper = new ObjectMapper();

        final File browsertimeFile = getBrowsertimeFile(args).map(File::new)
                .orElseThrow(() -> new RuntimeException("Can't find browsertime file"));
        final StringJoiner browsertimeContent = new StringJoiner("\n");
        Files.readAllLines(browsertimeFile.toPath()).forEach(browsertimeContent::add);
        final BrowsertimeReport browsertime = mapper.readValue(browsertimeContent.toString(), BrowsertimeReport.class);

        final File coachFile = getCoachFile(args).map(File::new)
                .orElseThrow(() -> new RuntimeException("Can't find browsertime file"));
        final StringJoiner coachContent = new StringJoiner("\n");
        List<String> coachLines = Files.readAllLines(coachFile.toPath());
        coachLines.subList(4, coachLines.size()).forEach(coachContent::add);

        final CoachReport coach = mapper.readValue(coachContent.toString(), CoachReport.class);

        final Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setTemplateLoader(new ClassTemplateLoader(BuildReport.class, "/"));
        Template template = cfg.getTemplate("report.ftl");

        // Build the data-model
        Map<String, Object> data = new HashMap<>();
        data.put("browsertime", browsertime);
        data.put("coach", coach);

        final Path reportFile = getReportFile(args).map(Paths::get)
                .orElseThrow(() -> new RuntimeException("Report file mising"));

        System.out.println(reportFile);
        Files.createDirectories(reportFile.getParent());

        try (Writer out = new OutputStreamWriter(new FileOutputStream(reportFile.toFile()))) {
            template.process(data, out);
        }
    }

    private static Optional<String> getBrowsertimeFile(final String[] args) {
        return args.length > 0 ? Optional.of(args[0]) : Optional.empty();
    }

    private static Optional<String> getCoachFile(final String[] args) {
        return args.length > 0 ? Optional.of(args[1]) : Optional.empty();
    }

    private static Optional<String> getReportFile(final String[] args) {
        return args.length > 1 ? Optional.of(args[2]) : Optional.empty();
    }

}
