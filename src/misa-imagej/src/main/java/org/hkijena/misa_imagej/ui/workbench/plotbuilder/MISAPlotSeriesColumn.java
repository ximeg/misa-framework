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

import com.google.common.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class MISAPlotSeriesColumn<T> {
    private List<MISAPlotSeriesData> seriesDataList;
    private List<MISAPlotSeriesGenerator<T>> generators;
    private int seriesDataIndex = -1;
    private EventBus eventBus = new EventBus();

    @SafeVarargs
    public MISAPlotSeriesColumn(List<MISAPlotSeriesData> seriesDataList, MISAPlotSeriesGenerator<T> defaultGenerator, MISAPlotSeriesGenerator<T>... additionalGenerators) {
        this.seriesDataList = seriesDataList;
        this.generators = new ArrayList<>();
        this.generators.add(defaultGenerator);
        this.generators.addAll(Arrays.asList(additionalGenerators));
    }

    public List<T> getValues(int rowCount) {
        if(seriesDataIndex < 0) {
            MISAPlotSeriesGenerator<T> generator = generators.get(-seriesDataIndex - 1);
            List<T> result = new ArrayList<>(rowCount);
            for(int row = 0; row < rowCount; ++row) {
                result.add(generator.getGeneratorFunction().apply(row));
            }
            return result;
        }
        else {
            return getValuesFromTable();
        }
    }

    protected abstract List<T> getValuesFromTable();

    public MISAPlotSeriesData getSeriesData() {
        if(seriesDataIndex >= 0)
            return seriesDataList.get(seriesDataIndex);
        else
            return null;
    }

    public int getSeriesDataIndex() {
        return seriesDataIndex;
    }

    public void setSeriesDataIndex(int seriesDataIndex) {
        this.seriesDataIndex = seriesDataIndex;
        eventBus.post(new DataChangedEvent(this));
    }

    /**
     * Gets the number of rows that is required to hold this data
     * If data is generated, it returns 0
     * @return
     */
    public int getRequiredRowCount() {
        if(seriesDataIndex >= 0) {
            return seriesDataList.get(seriesDataIndex).getSize();
        }
        else {
            return 0;
        }
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public List<MISAPlotSeriesGenerator<T>> getGenerators() {
        return Collections.unmodifiableList(generators);
    }

    public static class DataChangedEvent {
        private MISAPlotSeriesColumn seriesColumn;

        public DataChangedEvent(MISAPlotSeriesColumn seriesColumn) {
            this.seriesColumn = seriesColumn;
        }

        public MISAPlotSeriesColumn getSeriesColumn() {
            return seriesColumn;
        }
    }
}
