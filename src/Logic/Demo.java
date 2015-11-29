/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import com.sun.tools.visualvm.charts.*;




/**
 *
 * @author Salifu
 */
public class Demo{

    private static final long SLEEP_TIME = 500;
    private static final int VALUES_LIMIT = 150;
    private static final int ITEMS_COUNT = 4;
    private SimpleXYChartSupport support;

    public Demo() {
        createModels();
    }
    
    public SimpleXYChartSupport getSupport(){
        return this.support;
    }

    private void createModels() {
        SimpleXYChartDescriptor descriptor =
                SimpleXYChartDescriptor.decimal(0, 1000, 1000, 1d, true, VALUES_LIMIT);
        String[] items = {"Disk", "Memory", "CPU", "Wifi"};
        for (int i = 0; i < ITEMS_COUNT; i++) {
            descriptor.addLineFillItems(items[i]);
        }

        descriptor.setDetailsItems(new String[]{"Detail 1", "Detail 2", "Detail 3"});
        descriptor.setChartTitle("<html><font size='+1'><b>Demo Chart</b></font></html>");
        descriptor.setXAxisDescription("<html>X Axis <i>[time]</i></html>");
        descriptor.setYAxisDescription("<html>Y Axis <i>[units]</i></html>");

        this.support = ChartFactory.createSimpleXYChart(descriptor);

        new Generator(support).start();
    }

    private static class Generator extends Thread {

        private SimpleXYChartSupport support;

        public void run() {
            while (true) {
                try {
                    long[] values = new long[ITEMS_COUNT];
                    for (int i = 0; i < values.length; i++) {
                        values[i] = (long) (1000 * Math.random());
                    }
                    support.addValues(System.currentTimeMillis(), values);
                    support.updateDetails(new String[]{1000 * Math.random() + "",
                                1000 * Math.random() + "",
                                1000 * Math.random() + ""});
                    Thread.sleep(SLEEP_TIME);
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }

        private Generator(SimpleXYChartSupport support_sent) {
            support = support_sent;
        }
    }


}