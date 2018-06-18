package io.eroshenkoam.browsertime;

import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import io.eroshenkoam.browsertime.entity.Report;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BuildReport {

    public static void main(final String[] args) throws Exception {
        final ObjectMapper mapper = new ObjectMapper();

        final File browserTimeFile = getBrowserTimeFile(args).map(File::new)
                .orElseThrow(() -> new RuntimeException("Can't find browsertime file"));

        final Report report = mapper.readValue(browserTimeFile, Report.class);

        final Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setTemplateLoader(new ClassTemplateLoader(BuildReport.class, "/"));
        Template template = cfg.getTemplate("report.ftl");

        // Build the data-model
        Map<String, Object> data = new HashMap<>();
        data.put("report", report);

        final Path reportFile = getReportFile(args).map(Paths::get)
                .orElseThrow(() -> new RuntimeException("Report file mising"));

        System.out.println(reportFile);
        Files.createDirectories(reportFile.getParent());

        try (Writer out = new OutputStreamWriter(new FileOutputStream(reportFile.toFile()))) {
            template.process(data, out);
        }
    }

    private static Optional<String> getBrowserTimeFile(final String[] args) {
        return args.length > 0 ? Optional.of(args[0]) : Optional.empty();
    }

    private static Optional<String> getReportFile(final String[] args) {
        return args.length > 1 ? Optional.of(args[1]) : Optional.empty();
    }

}
