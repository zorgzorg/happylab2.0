package kz.epam.happylab.entity;

import java.util.Collection;

public class Report {
    private String analysis;
    private String headLaboratory;
    private Collection result;
    private Collection probes;
    private Entity probe;

    public Report() {
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getHeadLaboratory() {
        return headLaboratory;
    }

    public void setHeadLaboratory(String headLaboratory) {
        this.headLaboratory = headLaboratory;
    }

    public Collection getResult() {
        return result;
    }

    public void setResult(Collection result) {
        this.result = result;
    }

    public Collection getProbes() {
        return probes;
    }

    public void setProbes(Collection probes) {
        this.probes = probes;
    }

    public Entity getProbe() {
        return probe;
    }

    public void setProbe(Entity probe) {
        this.probe = probe;
    }
}
