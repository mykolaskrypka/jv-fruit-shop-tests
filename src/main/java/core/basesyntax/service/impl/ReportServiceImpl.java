package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.io.FileWriter;

public class ReportServiceImpl implements ReportService {

    @Override
    public String getReportText() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity");
        Storage.getStore().entrySet()
                .stream()
                .forEach(kv -> stringBuilder
                .append(System.lineSeparator())
                .append(kv.getKey().getName())
                .append(",")
                .append(kv.getValue()));
        return stringBuilder.toString();
    }

    @Override
    public void writeReport(String report, String fileName) {
        try (FileWriter output = new FileWriter(fileName)) {
            output.write(report);
        } catch (Exception e) {
            throw new RuntimeException("Can't write report file!", e);
        }
    }
}