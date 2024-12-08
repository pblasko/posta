package hu.posta.szekesfehervar.service;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.RingPlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ChartUtil {

    public static BufferedImage createChart() {
        PieDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);

        // Convert chart to image (BufferedImage)
        return chart.createBufferedImage(500, 500);
    }

    private static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category 1", 40);
        dataset.setValue("Category 2", 60);
        return dataset;
    }

    private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createRingChart(
                "Sample Doughnut Chart",  // Title
                dataset,                  // Dataset
                true,                     // Include legend
                true,                     // Tooltips
                false                     // URLs
        );

        RingPlot plot = (RingPlot) chart.getPlot();
        plot.setSectionDepth(0.35);  // Doughnut style
        return chart;
    }

    public static void saveChartAsImage(BufferedImage chartImage, String path) throws IOException {
        File outputFile = new File(path);
        ImageIO.write(chartImage, "PNG", outputFile);
    }

}
