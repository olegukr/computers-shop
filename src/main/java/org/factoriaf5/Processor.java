package org.factoriaf5;

public class Processor {

    long processorID;

    public Processor(String vendorName, String nameCPU, int baseFrequency_MHz) {
        this.vendorName = vendorName;
        this.nameCPU = nameCPU;
        this.baseFrequency_MHz = baseFrequency_MHz;
    }
    String  vendorName;
    String  nameCPU;
    int     baseFrequency_MHz;

    // String  famelyCPU;
    // int     maxFraquency_MHz;
    // int     cache_1kB_CPU;
    // int     cache_2MB_CPU;
    // int     cache_3MB_CPU;
    // int     numberOfCoresCPU;
    // int     powerTDP;
    // String  connectorType;
    // boolean integrityGPU;
    // int     technology_nm;

}
