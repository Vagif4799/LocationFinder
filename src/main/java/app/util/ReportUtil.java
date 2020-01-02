package app.util;

import org.springframework.stereotype.Component;

import java.util.List;

public interface ReportUtil {

    void generatePieChart(String path, List<Object[]> data);

}
