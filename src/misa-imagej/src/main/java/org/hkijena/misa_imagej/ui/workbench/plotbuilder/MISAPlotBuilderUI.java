/*
 * Copyright by Ruman Gerst
 * Research Group Applied Systems Biology - Head: Prof. Dr. Marc Thilo Figge
 * https://www.leibniz-hki.de/en/applied-systems-biology.html
 * HKI-Center for Systems Biology of Infection
 * Leibniz Institute for Natural Product Research and Infection Biology - Hans Knöll Insitute (HKI)
 * Adolf-Reichwein-Straße 23, 07745 Jena, Germany
 *
 * This code is licensed under BSD 2-Clause
 * See the LICENSE file provided with this code for the full license.
 */

package org.hkijena.misa_imagej.ui.workbench.plotbuilder;

import com.google.common.eventbus.Subscribe;
import org.hkijena.misa_imagej.MISAImageJRegistryService;
import org.hkijena.misa_imagej.ui.components.PlotReader;
import org.hkijena.misa_imagej.ui.registries.MISAPlotBuilderRegistry;
import org.hkijena.misa_imagej.ui.workbench.MISAWorkbenchUI;
import org.hkijena.misa_imagej.ui.workbench.tableanalyzer.MISAMergeTableColumnsDialogUI;
import org.hkijena.misa_imagej.ui.workbench.tableanalyzer.MISATableAnalyzerUI;
import org.hkijena.misa_imagej.utils.UIUtils;
import org.hkijena.misa_imagej.utils.ui.DocumentTabPane;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.ScrollableSizeHint;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MISAPlotBuilderUI extends JPanel {

    private MISAWorkbenchUI workbench;
    private JToolBar plotSeriesEditorToolBar;
    private JXPanel plotSeriesListPanel;
    private JPanel plotSettingsPanel;
    private MISAPlot currentPlot;

    private JToggleButton toggleAutoUpdate;
    private PlotReader plotReader;

    private List<MISAPlotSeriesData> seriesDataList = new ArrayList<>();

    public MISAPlotBuilderUI(MISAWorkbenchUI workbench) {
        this.workbench = workbench;
        initialize();
        updatePlotSettings();
        updatePlot();
    }

    public void importFromTable(DefaultTableModel model, String name) {
        for(int column = 0; column < model.getColumnCount(); ++column) {
            MISAPlotSeriesData data = new MISAPlotSeriesData(name + "." + model.getColumnName(column));
            for(int i = 0; i < model.getRowCount(); ++i) {
                data.getData().add(model.getValueAt(i, column));
            }
            seriesDataList.add(data);
        }
        updatePlotSettings();
        updatePlot();
    }

    private void initialize() {
        setLayout(new BorderLayout());

        plotReader = new PlotReader();

        plotReader.getToolBar().add(Box.createHorizontalGlue());

        toggleAutoUpdate = new JToggleButton(UIUtils.getIconFromResources("cog.png"));
        toggleAutoUpdate.setSelected(true);
        toggleAutoUpdate.setToolTipText("Automatically update the plot");
        plotReader.getToolBar().add(toggleAutoUpdate);

        JButton updatePlotButton = new JButton("Update", UIUtils.getIconFromResources("refresh.png"));
        updatePlotButton.addActionListener(e -> updatePlot());
        plotReader.getToolBar().add(updatePlotButton);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, createBuilderPanel(), plotReader);
        add(splitPane, BorderLayout.CENTER);
    }

    private JPanel createBuilderPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JToolBar toolBar = new JToolBar();

        JComboBox<MISAPlot> plotJComboBox = new JComboBox<>();
        plotJComboBox.setRenderer(new Renderer());
        MISAPlotBuilderRegistry registry = MISAImageJRegistryService.getInstance().getPlotBuilderRegistry();
        for(MISAPlot plot : registry.createAllPlots(seriesDataList).stream().sorted(Comparator.comparing(registry::getNameOf)).collect(Collectors.toList())) {
            plot.getEventBus().register(this);
            plotJComboBox.addItem(plot);
        }
        plotJComboBox.addItemListener(e -> { if(e.getItem() != null) setCurrentPlot((MISAPlot)e.getItem()); });
        toolBar.add(plotJComboBox);

        toolBar.add(Box.createHorizontalGlue());
        toolBar.add(Box.createHorizontalStrut(32));

        JButton importTableButton = new JButton("Import data", UIUtils.getIconFromResources("import.png"));
        importTableButton.addActionListener(e -> importTable());
        toolBar.add(importTableButton);

        JButton openTableButton = new JButton("Data as table", UIUtils.getIconFromResources("table.png"));
        openTableButton.addActionListener(e -> openTable());
        toolBar.add(openTableButton);

        panel.add(toolBar, BorderLayout.NORTH);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);

        JPanel seriesPanel = new JPanel(new BorderLayout());
        plotSeriesEditorToolBar = new JToolBar();

        JButton addSeriesButton = new JButton("Add series", UIUtils.getIconFromResources("add.png"));
        addSeriesButton.addActionListener(e -> addSeries());
        plotSeriesEditorToolBar.add(addSeriesButton);

        seriesPanel.add(plotSeriesEditorToolBar, BorderLayout.NORTH);

        plotSeriesListPanel = new JXPanel();
        plotSeriesListPanel.setScrollableWidthHint(ScrollableSizeHint.FIT);
        plotSeriesListPanel.setScrollableHeightHint(ScrollableSizeHint.NONE);
        plotSeriesListPanel.setLayout(new BoxLayout(plotSeriesListPanel, BoxLayout.PAGE_AXIS));
        seriesPanel.add(new JScrollPane(plotSeriesListPanel), BorderLayout.CENTER);
        tabbedPane.addTab("Data", UIUtils.getIconFromResources("table.png"), seriesPanel);

        plotSettingsPanel = new JPanel(new BorderLayout());
        tabbedPane.addTab("Settings", UIUtils.getIconFromResources("wrench.png"), plotSettingsPanel);

        panel.add(tabbedPane, BorderLayout.CENTER);

        if(plotJComboBox.getSelectedItem() instanceof MISAPlot)
            currentPlot = (MISAPlot) plotJComboBox.getSelectedItem();

        return panel;
    }

    private void importTable() {
        DefaultTableModel model = new DefaultTableModel();
        MISAMergeTableColumnsDialogUI dialog = new MISAMergeTableColumnsDialogUI(workbench, model);
        dialog.pack();
        dialog.setSize(800,600);
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dialog.setModal(true);
        dialog.setVisible(true);

        if(model.getColumnCount() > 0) {
            // Import series from the model
            importFromTable(model, dialog.getMergedTab().getTitle());
            updatePlotSettings();
        }
    }

    private void addSeries() {
        if(currentPlot != null)
            currentPlot.addSeries();
    }

    private void setCurrentPlot(MISAPlot plot) {
        this.currentPlot = plot;
        updatePlotSettings();
        updatePlot();
    }

    private void updatePlotSettings() {
        if(currentPlot != null) {
            // Update the settings
            plotSettingsPanel.removeAll();
            plotSettingsPanel.add(MISAImageJRegistryService.getInstance().
                    getPlotBuilderRegistry().createSettingsUIFor(currentPlot), BorderLayout.NORTH);
            plotSettingsPanel.revalidate();
            plotSettingsPanel.repaint();

            // Update the series list
            plotSeriesEditorToolBar.setVisible(currentPlot.canAddSeries());
            plotSeriesListPanel.removeAll();
            for (MISAPlotSeries series : currentPlot.getSeries()) {
                MISAPlotSeriesUI ui = new MISAPlotSeriesUI(currentPlot, series);
                ui.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8),
                        BorderFactory.createLineBorder(Color.BLACK)));
                plotSeriesListPanel.add(ui);
            }
            plotSeriesListPanel.add(Box.createVerticalGlue());
        }
    }

    private void updatePlot() {
        if(currentPlot != null) {
            // Rebuild the chart
            plotReader.getChartPanel().setChart(currentPlot.createPlot());
            plotReader.getChartPanel().setMaximumDrawWidth(Integer.MAX_VALUE);
            plotReader.getChartPanel().setMaximumDrawHeight(Integer.MAX_VALUE);
        }
    }

    @Subscribe
    public void handlePlotChangedEvent(MISAPlot.PlotChangedEvent event) {
        if(toggleAutoUpdate.isSelected())
            updatePlot();
    }

    @Subscribe
    public void handlePlotChangedSeriesListEvent(MISAPlot.PlotSeriesListChangedEvent event) {
        updatePlotSettings();
    }

    private void openTable() {
        DefaultTableModel tableModel = new DefaultTableModel();
        for(MISAPlotSeriesData data : seriesDataList) {
            tableModel.addColumn(data.getName());
        }
        Object[] rowBuffer = new Object[seriesDataList.size()];
        final int rowNumber = seriesDataList.stream().max(Comparator.comparing(MISAPlotSeriesData::getSize)).get().getSize();

        for(int i = 0; i < rowNumber; ++i) {
            for(int j = 0; j < seriesDataList.size(); ++j) {
                if(i < seriesDataList.get(j).getSize()) {
                    rowBuffer[j] = seriesDataList.get(j).getData().get(i);
                }
                else {
                    rowBuffer[j] = null;
                }
            }
            tableModel.addRow(rowBuffer);
        }

        workbench.addTab("Table",
                UIUtils.getIconFromResources("table.png"),
                new MISATableAnalyzerUI(workbench, tableModel),
                DocumentTabPane.CloseMode.withAskOnCloseButton, true);
        workbench.setSelectedTab(workbench.getTabCount() - 1);
    }

    private static class Renderer extends JLabel implements ListCellRenderer<MISAPlot> {

        public Renderer() {
            setOpaque(false);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends MISAPlot> list, MISAPlot value,
                                                      int index, boolean isSelected, boolean cellHasFocus) {

            if(value != null) {
                setText(MISAImageJRegistryService.getInstance().getPlotBuilderRegistry().getNameOf(value));
                setIcon(MISAImageJRegistryService.getInstance().getPlotBuilderRegistry().getIconOf(value));
            }

            if(isSelected) {
                setBackground(new Color(184, 207, 229));
            }
            else {
                setBackground(new Color(255,255,255));
            }

            if(cellHasFocus) {
                setBorder(null);
            }
            else {
                setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
            }

            return this;
        }
    }
}
